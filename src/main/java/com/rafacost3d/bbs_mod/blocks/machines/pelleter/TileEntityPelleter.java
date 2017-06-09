package com.rafacost3d.bbs_mod.blocks.machines.pelleter;

import com.rafacost3d.bbs_mod.init.BBSCropRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;


public class TileEntityPelleter extends TileEntity implements ITickable {
    private int delayCounter = 20;
    public ItemStackHandler inventory = new ItemStackHandler(1);


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
        if (!world.isRemote) {
            updateCounter();
        }
    }

    private void updateCounter() {
        delayCounter--;
        String nameHop[] = inventory.getStackInSlot(0).getUnlocalizedName().split("[.]");
        if (!world.isRemote && delayCounter <= 0 && inventory.getStackInSlot(0).getCount()>0 && nameHop[2].equals("hop")) {
            delayCounter = 10;
            markDirty();
            ItemStack itemStack=null;
            itemStack = new ItemStack(BBSCropRegistry.getPellet(nameHop[1].toLowerCase()));
            itemStack.grow(1);
            inventory.getStackInSlot(0).shrink(1);
            EntityItem entityItem = new EntityItem(world, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), itemStack);
            world.spawnEntity(entityItem);
        } else {
            markDirty();
        }
    }
}
