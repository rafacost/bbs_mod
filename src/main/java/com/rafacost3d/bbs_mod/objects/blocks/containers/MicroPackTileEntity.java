package com.rafacost3d.bbs_mod.objects.blocks.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class MicroPackTileEntity extends TileEntity {
    public static final int SIZE = 9;

    public ItemStackHandler itemStackHandler = new ItemStackHandler(SIZE){
        @Override
        protected void onContentsChanged(int slot) {
            MicroPackTileEntity.this.markDirty();
        }
    };

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if(compound.hasKey("items")) {
            itemStackHandler.deserializeNBT((NBTTagCompound)compound.getTag("items"));
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setTag("items", itemStackHandler.serializeNBT());
        return compound;
    }

    public boolean canInteractWith(EntityPlayer playerIn){
        return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <=64D;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(itemStackHandler);
        }
        return super.getCapability(capability, facing);
    }

}
