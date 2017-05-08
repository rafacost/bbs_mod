package com.rafacost3d.bbs_mod.items;


import com.rafacost3d.bbs_mod.BBSMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    protected String name;

    public ItemBase(String name) {
        this.name = name;
        setUnlocalizedName(BBSMod.MODID + "." + name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        BBSMod.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
