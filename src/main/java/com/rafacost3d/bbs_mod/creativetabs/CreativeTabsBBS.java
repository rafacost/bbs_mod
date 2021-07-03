package com.rafacost3d.bbs_mod.creativetabs;

import com.rafacost3d.bbs_mod.init.BlocksInit;
import com.rafacost3d.bbs_mod.init.ItemInit;
import com.rafacost3d.bbs_mod.objects.crops.CropRegistry;
import com.rafacost3d.bbs_mod.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class CreativeTabsBBS {

    public static final CreativeTabs BBSTabsHops = new CreativeTabs(Reference.MODID + ".hops") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() { return CropRegistry.getFood(CropRegistry.POLARIS).getDefaultInstance(); }
    };
/*
    public static final CreativeTabs BBSTabsPellets = new CreativeTabs(Reference.MODID + ".pellets") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() { return CropRegistry.getPellet(CropRegistry.HORIZON).getDefaultInstance(); }
    };
*/
    public static final CreativeTabs BBSTabsSeeds = new CreativeTabs(Reference.MODID + ".seeds") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() { return CropRegistry.getFood(CropRegistry.POLARIS).getDefaultInstance(); }
    };

    public static final CreativeTabs BBSTabsMachines = new CreativeTabs(Reference.MODID + ".machines") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() { return Item.getItemFromBlock(BlocksInit.microBrewerBlock).getDefaultInstance(); }
    };

    public static final CreativeTabs BBSTabsItems = new CreativeTabs(Reference.MODID + ".item") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return ItemInit.SANITIZER.getDefaultInstance();
        }
    };
/*
    public static final CreativeTabs BBSTabsFluids = new CreativeTabs(BBSMod.MODID + ".fluid") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return Item.getItemFromBlock(FluidBeer.instance.getBlock()).getDefaultInstance();
        }
    };
*/
}
