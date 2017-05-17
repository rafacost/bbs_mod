package com.rafacost3d.bbs_mod;

import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import com.rafacost3d.bbs_mod.items.HopSeedsItem;
import com.rafacost3d.bbs_mod.items.HopsWholeLeafItem;
import com.rafacost3d.bbs_mod.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BBSItems {

    public static HopsWholeLeafItem hopsLeafItemAA1;
    public static HopsWholeLeafItem hopsLeafItemAA2;
    public static HopsWholeLeafItem hopsLeafItemAA3;
    public static HopSeedsItem hopSeedsItem;
    public static ItemBase stirringspoon;
    public static ItemBase sanitizer;
    public static ItemBase watergallon;
    public static ItemBase lme;


    public static void init(){
        hopsLeafItemAA1 = new HopsWholeLeafItem("aa1", 3);
        hopsLeafItemAA2 = new HopsWholeLeafItem("aa2", 10);
        hopsLeafItemAA3 = new HopsWholeLeafItem("aa3", 7);
        hopSeedsItem = new HopSeedsItem(BBSBlocks.hopcropBlock, Blocks.DIRT);
        stirringspoon = register(new ItemBase("stirringspoon").setCreativeTab(CreativeTabsBBS.BBSTabsItems));
        stirringspoon.canHarvestBlock(BBSBlocks.boilingPotBlock.getBlockState().getBaseState());
        sanitizer = register(new ItemBase("sanitizer").setCreativeTab(CreativeTabsBBS.BBSTabsItems));
        sanitizer.setMaxDamage(64);
        sanitizer.setMaxStackSize(1);
        watergallon = register(new ItemBase("watergallon").setCreativeTab(CreativeTabsBBS.BBSTabsItems));
        watergallon.setMaxDamage(64);
        watergallon.setMaxStackSize(1);
        lme = register(new ItemBase("lme").setCreativeTab(CreativeTabsBBS.BBSTabsItems));
        lme.setMaxDamage(64);
        lme.setMaxStackSize(1);
    }


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        hopsLeafItemAA1.initModel();
        hopsLeafItemAA2.initModel();
        hopsLeafItemAA3.initModel();
        hopSeedsItem.initModel();
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemBase) {
            ((ItemBase)item).registerItemModel();
        }
        return item;
    }


}
