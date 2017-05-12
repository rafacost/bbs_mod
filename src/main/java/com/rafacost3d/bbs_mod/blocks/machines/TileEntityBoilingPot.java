package com.rafacost3d.bbs_mod.blocks.machines;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityBoilingPot extends TileEntity implements ITickable {

    private int count;
    private int delayCounter = 20;

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger("seconds", count);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        count = compound.getInteger("seconds");
        super.readFromNBT(compound);
    }


    public int getCount() {
        return count;
    }


    @Override
    public void update() {
        // This method is called every tick (20 times per second normally)
        if (!world.isRemote) {
             updateCounter();
        }
    }

    private void updateCounter() {
        //Count by seconds.
        delayCounter--;
        if (delayCounter <= 0) {
            delayCounter = 20;
            count++;
            markDirty();
        }
    }


}
