package com.rafacost3d.bbs_mod.blocks.machines.fermentorbucket;

import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.init.BBSConstants;
import com.rafacost3d.bbs_mod.init.BBSItems;
import com.rafacost3d.bbs_mod.items.WortBucket;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityFermentorBucket extends TileEntity implements ITickable {

    private int count;
    private int delayCounter = 20;
    private double temp = BBSConstants.ROOM_TEMP;
    private boolean isClean = false;
    private boolean hasWater = false;
    private boolean hasMalt = false;
    private boolean hasHops = false;
    private boolean hasBucket = false;
    private String hopsType = "";
    private int timeBoil=0;

    public int getTimeBoil() {
        return timeBoil;
    }

    public void setTimeBoil(int timeBoil) {
        this.timeBoil = timeBoil;
    }

    private ItemStackHandler inventory = new ItemStackHandler(5);


    public Boolean getClean() { return isClean;}
    public Boolean setClean(Boolean clean) { isClean = clean; return isClean;}
    public Boolean getWater() {
        ItemStack itemStackinv = inventory.getStackInSlot(1);
        if(itemStackinv.getItem() == BBSItems.watergallon) {
            hasWater=true;
        } else {
            hasWater=false;
        }
        return hasWater;
    }
    public Boolean getMalt() {
        ItemStack itemStackinv = inventory.getStackInSlot(3);
        if(itemStackinv.getItem() == BBSItems.lme) {
            hasMalt=true;
        } else {
            hasMalt=false;
        }
        return hasMalt;
    }
    public Boolean getHops() {
        ItemStack itemStackinv = inventory.getStackInSlot(2);
        if(!itemStackinv.isEmpty()) {
            String name[] = itemStackinv.getUnlocalizedName().split("[.]");
            if (name[2].equals("hop") || name[2].equals("pellet")) {
                //BBSMod.logger.info("Name: " + name[2]);
                hasHops = true;
                hopsType = itemStackinv.getDisplayName();
            } else {
                hasHops = false;
                hopsType = "";
            }
        }
        return hasHops;
    }
    public String getHopsType() {
        ItemStack itemStackinv = inventory.getStackInSlot(2);
        if(!itemStackinv.isEmpty()) {
            String name[] = itemStackinv.getUnlocalizedName().split("[.]");
            if (name.length >= 2 && name[2].equals("hop") || name[2].equals("pellet")) {
                //BBSMod.logger.info("Name: " + name[2]);
                hasHops = true;
                hopsType = itemStackinv.getDisplayName();
            } else {
                hasHops = false;
                hopsType = "";
            }
        }
        return hopsType;
    }
    public Boolean getBucket() {
        ItemStack itemStackinv = inventory.getStackInSlot(0);
        if(itemStackinv.getItem() == Items.BUCKET) {
            hasBucket=true;
        } else {
            hasBucket=false;
        }
        return hasBucket;
    }
    public double getTemp() { return temp; }
    public int getCount() { return count; }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("inventory", inventory.serializeNBT());
        compound.setBoolean("clean", isClean);
        compound.setBoolean("water", hasWater);
        compound.setBoolean("malt", hasMalt);
        compound.setBoolean("hops", hasHops);
        compound.setString("hopsType", hopsType);
        compound.setBoolean("bucket", hasBucket);
        compound.setDouble("temperature", temp);
        compound.setInteger("seconds", count);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        inventory.deserializeNBT(compound.getCompoundTag("inventory"));
        isClean = compound.getBoolean("clean");
        hasWater = compound.getBoolean("water");
        hasMalt = compound.getBoolean("malt");
        hasHops = compound.getBoolean("hops");
        hopsType = compound.getString("hopsType");
        hasBucket = compound.getBoolean("bucket");
        temp = compound.getInteger("temperature");
        count = compound.getInteger("seconds");
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
        //Get HeatRate.
        Integer heat = getHeatRate();
        getWater();
        getBucket();
        getMalt();
        delayCounter--;
        if (delayCounter <= 0 && heat < 0) {
            delayCounter = 20;
            if(temp<=BBSConstants.ROOM_TEMP){
                temp = BBSConstants.ROOM_TEMP;
                markDirty();
            } else {
                temp--;
                markDirty();
            }
        } else if (delayCounter <=0 && heat > 0 && hasBucket && hasWater && hasMalt) {
            delayCounter = 20;
            if(temp>=BBSConstants.WATER_BOILING)
            {
                count++;
                temp=BBSConstants.WATER_BOILING;
                markDirty();
                if(count>=timeBoil) {
                    try {
                        if(!inventory.getStackInSlot(1).isEmpty() && !inventory.getStackInSlot(3).isEmpty() && !inventory.getStackInSlot(0).isEmpty() && inventory.getStackInSlot(2).getCount()>=32) {
                            WortBucket wb = BBSItems.wortBucket;
                            ItemStack resultBucket = new ItemStack(wb);
                            resultBucket.setTagCompound(new NBTTagCompound());
                            String nameHop[] = inventory.getStackInSlot(2).getUnlocalizedName().split("[.]");
                            resultBucket.getTagCompound().setString("wortType", nameHop[1]);
                            //Use Water
                            inventory.getStackInSlot(1).shrink(1);
                            //Use Hops
                            if(nameHop.length>=2 && nameHop[2].equals("hop") && hasHops) {
                                Double quantD=0.0;
                                quantD = inventory.getStackInSlot(2).getCount() * BBSConstants.HOPS_WEIGHT;
                                String quant = String.format("%.2f", quantD) + BBSConstants.UNIT_WEIGHT;
                                resultBucket.getTagCompound().setString("wortQuant", quant);
                                resultBucket.getTagCompound().setString("hopType", nameHop[2]);
                                inventory.getStackInSlot(2).shrink(64);
                            } else if(nameHop.length>=2 && nameHop[2].equals("pellet") && hasHops) {
                                Double quantD=0.0;
                                quantD = inventory.getStackInSlot(2).getCount() * BBSConstants.PELLETS_WEIGHT;
                                String quant = String.format("%.2f", quantD) + BBSConstants.UNIT_WEIGHT;
                                resultBucket.getTagCompound().setString("wortQuant", quant);
                                resultBucket.getTagCompound().setString("hopType", nameHop[2]);
                                inventory.getStackInSlot(2).shrink(32);
                            } else {
                                hasHops=false;
                                hopsType="";
                            }

                            inventory.getStackInSlot(3).shrink(1);
                            inventory.getStackInSlot(0).shrink(1);
                            resultBucket.getTagCompound().setInteger("timeBoiling", count);
                            inventory.setStackInSlot(4,resultBucket);
                            BBSMod.logger.info("Wort is Done! Type:" + resultBucket.getTagCompound().getString("wortType") + " Quant: " + resultBucket.getTagCompound().getString("wortQuant"));
                            temp = BBSConstants.ROOM_TEMP;
                            count = 0;
                            isClean = false;
                            hasHops = false;
                            hopsType = "";
                            hasBucket = false;
                            hasWater = false;

                        }
                    } catch (Exception e) {
                        BBSMod.logger.warn("Couldn't process Wort");
                        e.printStackTrace();
                    }
                } else {

                    markDirty();
                }
            } else {
                temp += ((0.25) * heat);
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
}
