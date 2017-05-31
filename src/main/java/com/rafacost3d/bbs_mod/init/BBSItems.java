package com.rafacost3d.bbs_mod.init;

import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import com.rafacost3d.bbs_mod.fluids.BlockWort;
import com.rafacost3d.bbs_mod.items.*;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BBSItems {

    public static HopsWholeLeafItem hopsLeafItemAA1;
    public static HopsWholeLeafItem hopsLeafItemAA2;
    public static HopsWholeLeafItem hopsLeafItemAA3;
    public static HopsPelletsItem hopsPelletsItemAA1;
    public static HopsPelletsItem hopsPelletsItemAA2;
    public static HopsPelletsItem hopsPelletsItemAA3;
    public static HopSeedsItem hopSeedsItem;
    public static ItemBase stirringspoon;
    public static ItemBase sanitizer;
    public static ItemBase watergallon;
    public static ItemBase lme;
    public static ItemBase priming_sugar;
    public static ItemBase yeast;
    public static ItemBase thermometer;
    public static WortBucket wortBucket;


    public static void preinit(){
        hopsLeafItemAA1 = new HopsWholeLeafItem("aa1", 3);
        hopsLeafItemAA2 = new HopsWholeLeafItem("aa2", 10);
        hopsLeafItemAA3 = new HopsWholeLeafItem("aa3", 7);
        hopsPelletsItemAA1 = new HopsPelletsItem("aa1", 3);
        hopsPelletsItemAA2 = new HopsPelletsItem("aa2", 10);
        hopsPelletsItemAA3 = new HopsPelletsItem("aa3", 7);
        hopSeedsItem = new HopSeedsItem(BBSBlocks.hopcropBlock, Blocks.DIRT);
        stirringspoon = new ItemBase("stirringspoon").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        sanitizer = new ItemBase("sanitizer").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        sanitizer.setMaxDamage(64);
        sanitizer.setMaxStackSize(1);
        watergallon = new ItemBase("watergallon").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        watergallon.setMaxDamage(64);
        watergallon.setMaxStackSize(1);
        lme = new ItemBase("lme").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        lme.setMaxDamage(64);
        lme.setMaxStackSize(1);
        priming_sugar = new ItemBase("priming_sugar").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        yeast = new ItemBase("yeast").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        thermometer = new ItemBase("thermometer").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        wortBucket = new WortBucket(BBSFluids.blockWort);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        hopsLeafItemAA1.initModel();
        hopsLeafItemAA2.initModel();
        hopsLeafItemAA3.initModel();
        hopsPelletsItemAA1.initModel();
        hopsPelletsItemAA2.initModel();
        hopsPelletsItemAA3.initModel();
        hopSeedsItem.initModel();
        stirringspoon.initModel();
        sanitizer.initModel();
        watergallon.initModel();
        lme.initModel();
        priming_sugar.initModel();
        yeast.initModel();
        thermometer.initModel();
        wortBucket.initModel();
    }
}
