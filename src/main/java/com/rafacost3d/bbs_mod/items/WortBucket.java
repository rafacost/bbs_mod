package com.rafacost3d.bbs_mod.items;

import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class WortBucket extends ItemBucket {
    protected String name;
    protected String hopsType;
    protected Double hops;


    public static WortBucket instance;

    public WortBucket(Block containedBlockIn) {
        super(containedBlockIn);
        name = "wortbucket";
        setRegistryName(name);
        setUnlocalizedName(BBSMod.MODID + "." + name);
        GameRegistry.register(this);
        this.setCreativeTab(CreativeTabsBBS.BBSTabsFluids);
        hopsType = "No Hop";
        hops = 0.0;
    }


    public String getHopsType() {
        return hopsType;
    }

    public void setHopsType(String hopsType) {
        this.hopsType = hopsType;
    }

    public Double getHopsQuant() {
        return hops;
    }

    public void setHopsQuant(Double hopsQuant) {
        this.hops = hopsQuant;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    // This is an array of all the types I am going to be adding.
    String[] wortTypes = { "hopsleaf"};

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        if (stack.hasTagCompound())
        {
            NBTTagCompound itemData = stack.getTagCompound();
            if (itemData.hasKey("wortTypes"))
            {
                return "item." + BBSMod.MODID + ".worttype." + itemData.getString("wortType");
            }
        }
        return "item.bbs_mod.worttype.nullWort";
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List itemList)
    {
        for (int pos = 0; pos < wortTypes.length; pos++)
        {
            ItemStack wortStack = new ItemStack(item);
            wortStack.setTagCompound(new NBTTagCompound());
            wortStack.getTagCompound().setString("wortType", wortTypes[pos]);
            itemList.add(wortStack);
        }
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player,
                               List tooltip, boolean isAdvanced)
    {
        if ( stack.hasTagCompound()
                && stack.getTagCompound().hasKey("wortType"))
        {
            tooltip.add(I18n.format("item." + stack.getTagCompound().getString("wortType") + "." + stack.getTagCompound().getString("hopType") + ".name"));
            //tooltip.add("Type: " + stack.getTagCompound().getString("hopType"));
            tooltip.add("Hops Quantity: " + stack.getTagCompound().getString("wortQuant"));
            tooltip.add("Time Boiled: " + stack.getTagCompound().getInteger("timeBoiling") + " min");
        }
        else
        {
            tooltip.add(I18n.format("tooltip.bbs_mod.worttype.nullWort.desc"));
        }
    }
}
