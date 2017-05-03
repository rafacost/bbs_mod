package com.rafacost3d.bbs_mod.items;

import com.rafacost3d.bbs_mod.BBSMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class BasicItem extends Item {

    public BasicItem() {
        super();

        setRegistryName("basicitem");
        setUnlocalizedName(BBSMod.MODID + ".basicitem");
        setCreativeTab(CreativeTabs.BREWING);
        GameRegistry.register(this);

    }
}
