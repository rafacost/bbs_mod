package com.rafacost3d.bbs_mod.init;

import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import com.rafacost3d.bbs_mod.items.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BBSItems {

    public static ItemBase stirringspoon;
    public static ItemBase sanitizer;
    public static ItemBase watergallon;
    public static ItemBase lme;
    public static ItemBase priming_sugar;
    public static ItemBase yeast;
    public static ItemBase thermometer;
    public static WortBucket wortBucket;



    public static void preinit(){
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
