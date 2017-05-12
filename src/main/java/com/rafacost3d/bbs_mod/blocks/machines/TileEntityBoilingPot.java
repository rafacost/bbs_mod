package com.rafacost3d.bbs_mod.blocks.machines;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;


public class TileEntityBoilingPot extends TileEntity implements ITickable {

    private String beerType = "Weizen German Wheat Ale";
    private boolean isClean = false;
    private int temp = 70;
    private int count;
    private int delayCounter = 20;

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setString("beerType", beerType);
        compound.setBoolean("clean", isClean);
        compound.setInteger("temperature", temp);
        compound.setInteger("seconds", count);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        beerType = compound.getString("beerType");
        isClean = compound.getBoolean("clean");
        temp = compound.getInteger("temperature");
        count = compound.getInteger("seconds");
        super.readFromNBT(compound);
    }

    public String getBeerType() {
        return beerType;
    }
    public Boolean getClean() {
        return isClean;
    }
    public int getTemp() {
        return temp;
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
