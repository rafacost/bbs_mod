package com.rafacost3d.bbs_mod.creativetabs;

import com.rafacost3d.bbs_mod.*;
import com.rafacost3d.bbs_mod.fluids.FluidBeer;
import com.rafacost3d.bbs_mod.init.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class CreativeTabsBBS {

    public static final CreativeTabs BBSTabsHops = new CreativeTabs(BBSMod.MODID + ".hops") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return BBSItems.hopsPelletsItemAA1.getDefaultInstance();
        }
    };

    public static final CreativeTabs BBSTabsSeeds = new CreativeTabs(BBSMod.MODID + ".seeds") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return BBSItems.hopsPelletsItemAA1.getDefaultInstance();
        }
    };

    public static final CreativeTabs BBSTabsMachines = new CreativeTabs(BBSMod.MODID + ".machines") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return Item.getItemFromBlock(BBSBlocks.pelleterBlock).getDefaultInstance();
        }
    };

    public static final CreativeTabs BBSTabsItems = new CreativeTabs(BBSMod.MODID + ".item") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return BBSItems.sanitizer.getDefaultInstance();
        }
    };

    public static final CreativeTabs BBSTabsFluids = new CreativeTabs(BBSMod.MODID + ".fluid") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return Item.getItemFromBlock(FluidBeer.instance.getBlock()).getDefaultInstance();
        }
    };

}
