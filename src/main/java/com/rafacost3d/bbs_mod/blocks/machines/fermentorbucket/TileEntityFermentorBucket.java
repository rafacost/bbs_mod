package com.rafacost3d.bbs_mod.blocks.machines.fermentorbucket;

import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.init.BBSConstants;
import com.rafacost3d.bbs_mod.init.BBSHopsTypes;
import com.rafacost3d.bbs_mod.init.BBSItems;
import com.rafacost3d.bbs_mod.items.BeerBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
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
    private double waterQuant = 0.0;
    private boolean hasYeast = false;
    private double yeastQuant = 0.0;
    private boolean hasExtra = false;
    private double extraQuant = 0.0;
    private String extraType = "";
    private int timeFerment=20;
    private boolean hasBucket = false;


    private ItemStackHandler inventory = new ItemStackHandler(5);

    public Boolean getClean() { return isClean;}
    public Boolean setClean(Boolean clean) { isClean = clean; return isClean;}
    public Boolean getWater() {
        ItemStack itemStackinv = inventory.getStackInSlot(1);
        if(itemStackinv.getItem() == BBSItems.watergallon) {
            hasWater=true;
            waterQuant = inventory.getStackInSlot(1).getCount();
        } else {
            hasWater=false;
        }
        return hasWater;
    }
    public Boolean getYeast() {
        ItemStack itemStackinv = inventory.getStackInSlot(2);
        if(itemStackinv.getItem() == BBSItems.yeast) {
            hasYeast=true;
            yeastQuant = inventory.getStackInSlot(2).getCount();
        } else {
            hasYeast=false;
        }
        return hasYeast;
    }
    public Boolean getExtra() {
        ItemStack itemStackinv = inventory.getStackInSlot(3);
        if(!itemStackinv.isEmpty()) {
            String name[] = itemStackinv.getUnlocalizedName().split("[.]");
            if (name[2].equals("hop") || name[2].equals("pellet")) {
                hasExtra = true;
                extraQuant = inventory.getStackInSlot(3).getCount();
            } else {
                hasExtra = false;
            }
        }
        return hasExtra;
    }
    public String getExtraType() {
        ItemStack itemStackinv = inventory.getStackInSlot(3);
        if(!itemStackinv.isEmpty()) {
            String name[] = itemStackinv.getUnlocalizedName().split("[.]");
            if (name.length >= 2 && name[2].equals("hop") || name[2].equals("pellet")) {
                hasExtra = true;
                extraType = itemStackinv.getDisplayName();
            } else {
                hasExtra = false;
                extraType = "";
            }
        }
        return extraType;
    }

    public Boolean getBucket() {
        ItemStack itemStackinv = inventory.getStackInSlot(0);
        if(itemStackinv.getItem() == BBSItems.wortBucket) {
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
        compound.setBoolean("yeast", hasYeast);
        compound.setBoolean("extra", hasExtra);
        compound.setBoolean("bucket", hasBucket);
        compound.setString("extratype", extraType);
        compound.setDouble("waterQ", waterQuant);
        compound.setDouble("yeastQ", yeastQuant);
        compound.setDouble("extraQ", extraQuant);
        compound.setInteger("time", count);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        inventory.deserializeNBT(compound.getCompoundTag("inventory"));
        isClean = compound.getBoolean("clean");
        hasWater = compound.getBoolean("water");
        hasYeast = compound.getBoolean("yeast");
        hasExtra = compound.getBoolean("extra");
        hasBucket = compound.getBoolean("bucket");
        extraType = compound.getString("extratype");
        waterQuant = compound.getDouble("waterQ");
        yeastQuant = compound.getDouble("yeastQ");
        extraQuant = compound.getDouble("extraQ");
        count = compound.getInteger("time");
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
        getWater();
        getYeast();
        getExtra();
        getExtraType();

        delayCounter--;
        if (delayCounter <=0 && hasYeast) {
            delayCounter = 20;
                count++;
                markDirty();
                if(count>=timeFerment) {
                    try {
                        if(!inventory.getStackInSlot(0).isEmpty() && !inventory.getStackInSlot(1).isEmpty() && !inventory.getStackInSlot(2).isEmpty()) {
                            BeerBucket wb = BBSItems.beerBucket;
                            ItemStack resultBucket = new ItemStack(wb);
                            resultBucket.setTagCompound(new NBTTagCompound());
                            // Hops Type
                            resultBucket.getTagCompound().setString("beerType", inventory.getStackInSlot(0).getTagCompound().getString("wortType"));
                            //SRM
                            Double e=2.718281828459045235;
                            Double srm=0.0;
                            Double mcu=0.0;
                            Integer boil = 1;
                            Integer time = inventory.getStackInSlot(0).getTagCompound().getInteger("timeBoiling");
                            Integer batch = boil + inventory.getStackInSlot(1).getCount();
                            Double lovibond=inventory.getStackInSlot(0).getTagCompound().getDouble("lovibond");
                            Double quant= inventory.getStackInSlot(0).getTagCompound().getInteger("maltQuant") * 3.3;
                            mcu=lovibond * (quant/batch);
                            srm=1.4922 * Math.pow(mcu, 0.6859);
                            resultBucket.getTagCompound().setDouble("srm", srm);
                            //OG FG ABV
                            Double points = 37 * quant;
                            Double OG = ((points/batch) * 0.001)+1;
                            Double FG = ((OG-1) * (1-0.72))+1;
                            Double ABV = (OG-FG) * (125 * 1.05);
                            resultBucket.getTagCompound().setDouble("og", OG);
                            resultBucket.getTagCompound().setDouble("fg", FG);
                            resultBucket.getTagCompound().setDouble("abv", ABV);
                            //IBU
                            Double hopQuantg = inventory.getStackInSlot(0).getTagCompound().getDouble("wortQuant");
                            Double hopQuant = 0.0352739619*hopQuantg;
                            Double BG = (batch/boil) * (OG-1);
                            Double tfactor=0.0;
                            Double bfactor=0.0;
                            BBSMod.logger.info(inventory.getStackInSlot(0).getTagCompound().getString("wortType"));
                            BBSMod.logger.info(BBSHopsTypes.getAlpha(inventory.getStackInSlot(0).getTagCompound().getString("wortType")));
                            Double aa= BBSHopsTypes.getAlpha(inventory.getStackInSlot(0).getTagCompound().getString("wortType"));
                            tfactor = (1-Math.pow(e,(-0.04*time)))/4.15;
                            bfactor = 1.65*Math.pow(0.000125,BG);
                            Double util = bfactor * tfactor;
                            if(inventory.getStackInSlot(0).getTagCompound().getString("hopType").equals("pellet")) {
                                util = util * 1.1;
                            }
                            Double IBU = util * (((aa/100) * hopQuant * 7490)/batch);
                            resultBucket.getTagCompound().setDouble("ibu", IBU);

                            //Remove Items
                            inventory.getStackInSlot(0).shrink(1);
                            inventory.getStackInSlot(1).shrink(5);
                            inventory.getStackInSlot(2).shrink(1);
                            inventory.setStackInSlot(4,resultBucket);
                            temp = BBSConstants.ROOM_TEMP;
                            count = 0;
                            isClean = false;
                            hasBucket = false;
                            hasWater = false;
                        }
                    } catch (Exception e) {
                        BBSMod.logger.warn("Couldn't process Beer");
                        e.printStackTrace();
                    }
                } else {
                    markDirty();
                }
        }
    }
}
