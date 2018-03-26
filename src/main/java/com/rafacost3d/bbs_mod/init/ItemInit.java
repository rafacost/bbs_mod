package com.rafacost3d.bbs_mod.init;


import com.rafacost3d.bbs_mod.objects.items.BeerKegItem;
import com.rafacost3d.bbs_mod.objects.items.ItemBase;
import com.rafacost3d.bbs_mod.objects.items.MashKegItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    //public static final Item SPOON = new ItemBase("spoon");
    public static final Item SANITIZER = new ItemBase("sanitizer");
    public static final Item WATERGALLON = new ItemBase("watergallon");
    public static final Item LME_PILSEN = new ItemBase("lme_pilsen");
    public static final Item LME_EXTRALIGHT = new ItemBase("lme_extralight");
    public static final Item LME_WHEAT = new ItemBase("lme_wheat");
    public static final Item LME_LIGHT = new ItemBase("lme_light");
    public static final Item LME_MUNICH = new ItemBase("lme_munich");
    public static final Item LME_AMBER = new ItemBase("lme_amber");
    public static final Item LME_DARK = new ItemBase("lme_dark");
    //public static final Item PRIMING_SUGAR = new ItemBase("priming_sugar");
    public static final Item YEAST = new ItemBase("yeast");
    //public static final Item THERMOMETER = new ItemBase("thermometer");
    public static final Item WATER_KEG = new ItemBase("waterkeg");
    public static final Item WORT_KEG = new ItemBase("wortkeg");
    public static final Item HOTWORT_KEG = new ItemBase("hotwortkeg");
    //public static final Item BEER_KEG = new ItemBase("beerkeg");
    public static final Item KEG = new ItemBase("keg");
    public static final Item GRAFTER = new ItemBase("grafter");

    @GameRegistry.ObjectHolder("bbs_mod:mashkeg")
    public static MashKegItem mashKegItem;
    @GameRegistry.ObjectHolder("bbs_mod:beerkeg")
    public static BeerKegItem BEER_KEG;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        mashKegItem.initModel();
        BEER_KEG.initModel();
    }
}
