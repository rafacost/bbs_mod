package com.rafacost3d.bbs_mod.blocks.machines.boilingpot;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class TileEntityBoilingPot extends TileEntity implements ITickable {

    private String beerType = "";
    private String maltType = "";
    private String hopsType = "";
    private boolean isClean = false;
    private boolean hasWater = false;
    private boolean hasMalt = false;
    private boolean hasHops = false;
    private double waterGL = 0;
    private double temp = 70;
    private int count;
    private int delayCounter = 20;



    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setString("beerType", beerType);
        compound.setString("maltType", maltType);
        compound.setString("hopsType", hopsType);
        compound.setBoolean("clean", isClean);
        compound.setBoolean("water", hasWater);
        compound.setBoolean("malt", hasMalt);
        compound.setBoolean("hops", hasHops);
        compound.setDouble("waterGL", waterGL);
        compound.setDouble("temperature", temp);
        compound.setInteger("seconds", count);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        beerType = compound.getString("beerType");
        maltType = compound.getString("maltType");
        hopsType = compound.getString("hopsType");
        isClean = compound.getBoolean("clean");
        hasWater = compound.getBoolean("water");
        hasMalt = compound.getBoolean("hasMalt");
        hasHops = compound.getBoolean("hasHops");
        waterGL = compound.getDouble("waterGL");
        temp = compound.getInteger("temperature");
        count = compound.getInteger("seconds");
        super.readFromNBT(compound);
    }

    public String getBeerType() {
        return beerType;
    }
    public String getMaltType() {
        return maltType;
    }
    public String getHopsType() {
        return hopsType;
    }
    public String setBeerType(String beer) {beerType = beer; return beerType;}
    public String setMaltType(String malt) {maltType = malt; return maltType;}
    public String setHopsType(String hops) {hopsType = hops; return hopsType;}
    public Boolean getClean() {
        return isClean;
    }
    public Boolean setClean(Boolean clean) { isClean = clean; return isClean;}
    public Boolean getWater() {
        return hasWater;
    }
    public Boolean setWater(Boolean water) { hasWater = water; return hasWater;}
    public Boolean getMalt() {
        return hasMalt;
    }
    public Boolean setMalt(Boolean malt) { hasMalt = malt; return hasMalt;}
    public Boolean getHops() {
        return hasHops;
    }
    public Boolean setHops(Boolean hops) { hasHops = hops; return hasHops;}
    public double getTemp() {
        return temp;
    }
    public int getCount() {
        return count;
    }
    public double getWaterGL() {
        return waterGL;
    }
    public double setWaterGL(double gl) { waterGL = gl; return waterGL;}


    @Override
    public void update() {
        // This method is called every tick (20 times per second normally)
        if (!world.isRemote) {
             updateCounter();
        }
    }

    private void updateCounter() {
        //Get HeatRate.
        Integer heat = getHeatRate();
        delayCounter--;
        //Check if a second has passed and Heat is off
        if (delayCounter <= 0 && heat ==0) {
            delayCounter = 20;
            //If Yes set Room Temperature
            if(temp<=70){
                temp = 70;
                markDirty();
            //If Heat is off and Water is hot cool water
            } else {
                temp--;
                markDirty();
            }
        //Check if Second Passed, Heat is On, Is Clean, and Has Water
        } else if (delayCounter <=0 && heat > 0 && isClean && hasWater) {
            delayCounter = 20;
            //Check if Water is Boiling start Boiling Counter
            if(temp>=211)
            {
                count++;
                temp=212;
                //Check if Water is dry
                if (waterGL<=0) {
                    waterGL = 0;
                //Evaporate the water
                } else {
                    waterGL -= 0.001;
                }
                markDirty();
            //Heat Water using HeatRate/Water Quantity formula
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