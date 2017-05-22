package com.rafacost3d.bbs_mod.blocks.machines.pelleter;


import com.rafacost3d.bbs_mod.init.BBSItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.Random;

public class TileEntityPelleter extends TileEntity implements ITickable {
    private int delayCounter = 20;
    private static final Random RANDOM = new Random();
    private ItemStackHandler inventory = new ItemStackHandler(1);

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
        if (delayCounter <= 0) {
            delayCounter = 20;
            markDirty();
            EntityItem entityItem = new EntityItem(world,this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), BBSItems.hopsPelletsItemAA1.getDefaultInstance());
            world.spawnEntity(entityItem);
            System.out.println("Spawn!");
            } else {
               markDirty();
            }
    }
}
