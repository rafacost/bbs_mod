package com.rafacost3d.bbs_mod.init;

import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import com.rafacost3d.bbs_mod.items.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BBSItems {

    public static ItemBase stirringspoon;
    public static ItemBase sanitizer;
    public static ItemBase watergallon;
    public static ItemBase lme_pilsen;
    public static ItemBase lme_extralight;
    public static ItemBase lme_wheat;
    public static ItemBase lme_light;
    public static ItemBase lme_munich;
    public static ItemBase lme_amber;
    public static ItemBase lme_dark;
    public static ItemBase priming_sugar;
    public static ItemBase yeast;
    public static ItemBase thermometer;
    public static WortBucket wortBucket;
    public static BeerBucket beerBucket;



    public static void preinit(){
        stirringspoon = new ItemBase("stirringspoon").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        sanitizer = new ItemBase("sanitizer").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        sanitizer.setMaxDamage(64);
        sanitizer.setMaxStackSize(1);
        watergallon = new ItemBase("watergallon").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        watergallon.setMaxDamage(64);
        watergallon.setMaxStackSize(5);
        lme_pilsen = new ItemBase("lme_pilsen").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        lme_pilsen.setMaxStackSize(5);
        lme_extralight = new ItemBase("lme_extralight").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        lme_extralight.setMaxStackSize(5);
        lme_wheat = new ItemBase("lme_wheat").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        lme_wheat.setMaxStackSize(5);
        lme_light = new ItemBase("lme_light").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        lme_light.setMaxStackSize(5);
        lme_munich = new ItemBase("lme_munich").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        lme_munich.setMaxStackSize(5);
        lme_amber = new ItemBase("lme_amber").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        lme_amber.setMaxStackSize(5);
        lme_dark = new ItemBase("lme_dark").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        lme_dark.setMaxStackSize(5);
        priming_sugar = new ItemBase("priming_sugar").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        yeast = new ItemBase("yeast").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        thermometer = new ItemBase("thermometer").setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        wortBucket = new WortBucket(BBSFluids.blockWort);
        beerBucket = new BeerBucket(BBSFluids.blockBeer);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        stirringspoon.initModel();
        sanitizer.initModel();
        watergallon.initModel();
        lme_pilsen.initModel();
        lme_extralight.initModel();
        lme_wheat.initModel();
        lme_light.initModel();
        lme_munich.initModel();
        lme_amber.initModel();
        lme_dark.initModel();
        priming_sugar.initModel();
        yeast.initModel();
        thermometer.initModel();
        wortBucket.initModel();
        beerBucket.initModel();
    }
}
