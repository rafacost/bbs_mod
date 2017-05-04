package com.rafacost3d.bbs_mod.blocks;


import com.rafacost3d.bbs_mod.BBSMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FirstBlock extends Block {
    public FirstBlock() {
        super(Material.PLANTS);
        setUnlocalizedName(BBSMod.MODID + ".firstblock");
        setRegistryName("firstblock");
        setCreativeTab(CreativeTabs.MATERIALS);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
    }
}
