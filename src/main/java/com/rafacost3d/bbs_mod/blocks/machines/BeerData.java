package com.rafacost3d.bbs_mod.blocks.machines;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

public class BeerData {
    private Integer temp;
    private Integer timeBoiling;
    private Integer seconds;
    private Boolean isClean;
    private Boolean hasHeat;
    private Boolean hasWater;
    private Boolean hasMalt;
    private Boolean hasHops;
    private String hopsType;
    private int x, y, z;

    public BeerData(String hopsType, int temp, int timeBoiling, int seconds, boolean isClean, boolean hasHeat, boolean hasWater, boolean hasMalt, boolean hasHops, int x, int y, int z)
    {
        this.hopsType = hopsType;
        this.temp = temp;
        this.timeBoiling = timeBoiling;
        this.seconds = seconds;
        this.isClean = isClean;
        this.hasHeat = hasHeat;
        this.hasWater = hasWater;
        this.hasMalt = hasMalt;
        this.hasHops = hasHops;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public BlockPos getPos() {
        return new BlockPos(x,y,z);
    }
    public String getHopsType() {
        return hopsType;
    }
    public int getTemp() {
        return temp;
    }
    public int getTimeBoiling() {
        return timeBoiling;
    }
    public int getSeconds() {
        return seconds;
    }
    public boolean getIsClean() {
        return isClean;
    }
    public boolean getHasHeat() {
        return hasHeat;
    }
    public boolean getHasWater() {
        return hasWater;
    }
    public boolean getHasMalt() {
        return hasMalt;
    }
    public boolean getHasHops() {
        return hasHops;
    }
    public void writeEntryToNBT(NBTTagCompound nbt) {
        nbt.setString("hopsType", hopsType);
        nbt.setInteger("temp", temp);
        nbt.setInteger("timeBoiling", timeBoiling);
        nbt.setInteger("seconds", seconds);
        nbt.setBoolean("isClean", isClean);
        nbt.setBoolean("hasHeat", hasHeat);
        nbt.setBoolean("hasWater",  hasWater);
        nbt.setBoolean("hasMalt", hasMalt);
        nbt.setBoolean("hasHops", hasHops);
        nbt.setInteger("posX", x);
        nbt.setInteger("posY", y);
        nbt.setInteger("posZ", z);
    }

}
