package com.rafacost3d.bbs_mod.blocks.machines;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class TileEntityBoilingPot extends TileEntity implements ITickable {

    private String beerType = "Weizen German Wheat Ale";
    private boolean isClean = false;
    private boolean hasWater = false;
    private int waterGL = 0;
    private double temp = 70;
    private int count;
    private int delayCounter = 20;



    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setString("beerType", beerType);
        compound.setBoolean("clean", isClean);
        compound.setBoolean("water", hasWater);
        compound.setInteger("waterGL", waterGL);
        compound.setDouble("temperature", temp);
        compound.setInteger("seconds", count);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        beerType = compound.getString("beerType");
        isClean = compound.getBoolean("clean");
        hasWater = compound.getBoolean("water");
        waterGL = compound.getInteger("waterGL");
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
    public Boolean setClean(Boolean clean) { isClean = clean; return isClean;}
    public Boolean getWater() {
        return hasWater;
    }
    public Boolean setWater(Boolean water) { hasWater = water; return hasWater;}
    public double getTemp() {
        return temp;
    }
    public int getCount() {
        return count;
    }
    public int getWaterGL() {
        return waterGL;
    }
    public int setWaterGL(int gl) { waterGL = gl; return waterGL;}


    @Override
    public void update() {
        // This method is called every tick (20 times per second normally)
        if (!world.isRemote) {
             updateCounter();
        }
    }

    private void updateCounter() {
        //Count by seconds.
        Integer heat = getHeatRate();
        delayCounter--;
        if (delayCounter <= 0 && heat ==0) {
            delayCounter = 20;
            if(temp<=70){
                temp = 70;
                markDirty();
            } else {
                temp--;
                markDirty();
            }
        } else if (delayCounter <=0 && heat > 0 && isClean && hasWater) {
            delayCounter = 20;
            if(temp>=211)
            {
                count++;
                temp=212;
                markDirty();
            } else {
                temp += ((0.25/waterGL) * heat);
                markDirty();
            }
        }
    }

    public int getHeatRate() {
        BlockPos posBelow = pos.add(0, -1, 0);
        IBlockState stateBelow = world.getBlockState(posBelow);
        if (stateBelow == null)
        {
            return 0;
        }

        int heat;
        Block heatSource = stateBelow.getBlock();
        if (heatSource == Blocks.LIT_FURNACE) {
            heat = 2;
        } else if (heatSource == Blocks.TORCH) {
            heat = 1;
        } else if (heatSource == Blocks.LAVA) {
            heat = 4;
        } else if (heatSource == Blocks.FLOWING_LAVA) {
            heat = 4;
        } else if (heatSource == Blocks.FIRE) {
            heat = 3;
        } else { heat = 0;}

        return heat;
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
        return false;
    }
}
