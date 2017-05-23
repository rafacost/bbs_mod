package com.rafacost3d.bbs_mod.blocks.machines.pelleter;


import com.rafacost3d.bbs_mod.init.BBSItems;
import com.rafacost3d.bbs_mod.items.HopsWholeLeafItem;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.util.Random;

public class TileEntityPelleter extends TileEntity implements ITickable {
    private int delayCounter = 20;
    private static final Random RANDOM = new Random();
    public ItemStackHandler inventory = new ItemStackHandler(1);
    private String hopsType = null;

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("inventory", inventory.serializeNBT());
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        inventory.deserializeNBT(compound.getCompoundTag("inventory"));
        super.readFromNBT(compound);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory : super.getCapability(capability, facing);
    }


    @Override
    public void update() {
        // This method is called every tick (20 times per second normally)
        if (!world.isRemote) {
            updateCounter();
        }
    }

    private void updateCounter() {
        delayCounter--;
        //Check if a second has passed
        if (!world.isRemote && delayCounter <= 0 && inventory.getStackInSlot(0).getCount()>0 && inventory.getStackInSlot(0).getItem() instanceof HopsWholeLeafItem) {
            delayCounter = 10;
            markDirty();
            hopsType = StringUtils.right(inventory.getStackInSlot(0).getUnlocalizedName(),3);
            ItemStack itemStack = null;
            if (hopsType.equals("aa1")) {itemStack = new ItemStack(BBSItems.hopsPelletsItemAA1);
                itemStack.grow(1);}
            if (hopsType.equals("aa2")) {itemStack = new ItemStack(BBSItems.hopsPelletsItemAA2);
                itemStack.grow(1);}
            if (hopsType.equals("aa3")) {itemStack = new ItemStack(BBSItems.hopsPelletsItemAA3);
                itemStack.grow(1);}
            inventory.getStackInSlot(0).shrink(1);
            EntityItem entityItem = new EntityItem(world, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), itemStack);
            world.spawnEntity(entityItem);
        } else {
            markDirty();
        }
    }
}
