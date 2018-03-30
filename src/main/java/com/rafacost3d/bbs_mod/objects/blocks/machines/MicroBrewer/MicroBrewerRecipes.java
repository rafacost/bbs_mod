package com.rafacost3d.bbs_mod.objects.blocks.machines.MicroBrewer;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.rafacost3d.bbs_mod.init.ItemInit;
import com.rafacost3d.bbs_mod.objects.crops.CropRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class MicroBrewerRecipes {
    private static final MicroBrewerRecipes INSTANCE = new MicroBrewerRecipes();
    private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
    private final Map<ItemStack, Integer> cookTimeList = Maps.<ItemStack, Integer>newHashMap();

    public static MicroBrewerRecipes getInstance()
    {
        return INSTANCE;
    }

    private MicroBrewerRecipes()
    {
        addMicroBrewerRecipe(new ItemStack(CropRegistry.getFood("malt")), new ItemStack(CropRegistry.getFood("malt")), new ItemStack(CropRegistry.getFood("maltpilsen")), 5.0F, 20);
        addMicroBrewerRecipe(new ItemStack(CropRegistry.getFood("maltpilsen")), new ItemStack(CropRegistry.getFood("maltpilsen")), new ItemStack(CropRegistry.getFood("maltmunich")), 5.0F, 20);addMicroBrewerRecipe(new ItemStack(Items.WHEAT), new ItemStack(Items.SUGAR), new ItemStack(ItemInit.LME_WHEAT), 5.0F, 20);
        addMicroBrewerRecipe(new ItemStack(CropRegistry.getFood("maltmunich")), new ItemStack(CropRegistry.getFood("maltmunich")), new ItemStack(CropRegistry.getFood("maltamber")), 5.0F, 20);addMicroBrewerRecipe(new ItemStack(Items.WHEAT), new ItemStack(Items.SUGAR), new ItemStack(ItemInit.LME_WHEAT), 5.0F, 240);
        addMicroBrewerRecipe(new ItemStack(CropRegistry.getFood("maltamber")), new ItemStack(CropRegistry.getFood("maltamber")), new ItemStack(CropRegistry.getFood("maltdark")), 5.0F, 20);

        addMicroBrewerRecipe(new ItemStack(Items.WHEAT), new ItemStack(Items.SUGAR), new ItemStack(ItemInit.LME_WHEAT), 5.0F, 240);
        addMicroBrewerRecipe(new ItemStack(CropRegistry.getFood("malt")), new ItemStack(ItemInit.WATERGALLON), new ItemStack(ItemInit.LME_EXTRALIGHT), 5.0F, 240);
        addMicroBrewerRecipe(new ItemStack(CropRegistry.getFood("malt")), new ItemStack(Items.SUGAR), new ItemStack(ItemInit.LME_LIGHT), 5.0F, 240);
        addMicroBrewerRecipe(new ItemStack(CropRegistry.getFood("maltpilsen")), new ItemStack(Items.SUGAR), new ItemStack(ItemInit.LME_PILSEN), 5.0F, 240);
        addMicroBrewerRecipe(new ItemStack(CropRegistry.getFood("maltmunich")), new ItemStack(Items.SUGAR), new ItemStack(ItemInit.LME_MUNICH), 5.0F, 240);
        addMicroBrewerRecipe(new ItemStack(CropRegistry.getFood("maltamber")), new ItemStack(Items.SUGAR), new ItemStack(ItemInit.LME_AMBER), 5.0F, 240);
        addMicroBrewerRecipe(new ItemStack(CropRegistry.getFood("maltdark")), new ItemStack(Items.SUGAR), new ItemStack(ItemInit.LME_DARK), 5.0F, 240);

        addMicroBrewerRecipe(new ItemStack(ItemInit.WATER_KEG), new ItemStack(ItemInit.LME_WHEAT), new ItemStack(ItemInit.mashKegItem), 5.0F, 720);
        addMicroBrewerRecipe(new ItemStack(ItemInit.WATER_KEG), new ItemStack(ItemInit.LME_EXTRALIGHT), new ItemStack(ItemInit.mashKegItem), 5.0F, 720);
        addMicroBrewerRecipe(new ItemStack(ItemInit.WATER_KEG), new ItemStack(ItemInit.LME_LIGHT), new ItemStack(ItemInit.mashKegItem), 5.0F, 720);
        addMicroBrewerRecipe(new ItemStack(ItemInit.WATER_KEG), new ItemStack(ItemInit.LME_PILSEN), new ItemStack(ItemInit.mashKegItem), 5.0F, 720);
        addMicroBrewerRecipe(new ItemStack(ItemInit.WATER_KEG), new ItemStack(ItemInit.LME_MUNICH), new ItemStack(ItemInit.mashKegItem), 5.0F, 720);
        addMicroBrewerRecipe(new ItemStack(ItemInit.WATER_KEG), new ItemStack(ItemInit.LME_AMBER), new ItemStack(ItemInit.mashKegItem), 5.0F, 720);
        addMicroBrewerRecipe(new ItemStack(ItemInit.WATER_KEG), new ItemStack(ItemInit.LME_DARK), new ItemStack(ItemInit.mashKegItem), 5.0F, 720);

        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("admiral")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("ahtanum")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("amarillo")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("aquila")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("aramis")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("aurora")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("banner")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("bcgolding")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("bittergold")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("blanc")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("bobek")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("bramlingcross")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("bravo")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("brewersgoldgermany")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("brewersgoldusa")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("bullion")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("cascade")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("celeia")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("centennial")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("challenger")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("chelan")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("chinook")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("citra")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("cluster")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("columbus")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("comet")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("crystal")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("drrudi")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("eastkentgolding")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("ekuanot")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("ella")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("eroica")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("falconersflight")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("firstgold")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("fuggleuk")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("galaxy")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("galena")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("glacier")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("gold")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("goldinguk")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("goldingusa")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("greenbullet")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("hallertaumittelfruh")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("hallertauusa")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("hbc431experimental")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("hbc438experimental")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("hbc472experimental")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("hbc682experimental")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("helga")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("herald")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("herkules")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("hersbrucker")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("horizon")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("huellmelon")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("hullerbitterer")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("kohatu")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("liberty")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("loral")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("lubelska")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("magnum")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("mandarinabavaria")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("merkur")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("millenium")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("mosaic")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("motueka")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("mounthood")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("mountrainier")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("nelsonsauvin")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("newport")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("northdown")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("northernbrewer")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("nugget")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("olympic")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("omega")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("opal")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("orion")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("pacifica")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("pacificgem")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("pacificjade")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("palisade")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("perlegermany")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("perleusa")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("phoenix")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("pilgrim")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("pioneer")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("polaris")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("premiant")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("prideofringwood")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("progress")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("rakau")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("record")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("riwaka")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("saaz")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("santiam")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("saphir")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("satus")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("savinjskigolding")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("select")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("simcoe")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("smaragd")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("sorachiace")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("southerncross")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("sovereign")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("spalt")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("sterling")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("sticklebract")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("strisselspalt")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("styriangolding")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("summer")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("summit")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("superalpha")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("superpride")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("sussex")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("sylva")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("tahoma")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("talisman")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("target")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("tettnangergermany")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("tettnangerusa")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("tomahawk")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("tradition")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("triplepearl")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("triskel")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("ultra")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("vanguard")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("waiiti")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("waimea")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("wakatu")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("warrior")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("whitbreadgolding")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("willamette")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("yakimacluster")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("yamhillgolding")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("yeoman")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("zenith")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("zeus")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.mashKegItem), new ItemStack(CropRegistry.getFood("zythos")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.HOTWORT_KEG), new ItemStack(Blocks.ICE), new ItemStack(ItemInit.WORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.WORT_KEG), new ItemStack(ItemInit.YEAST), new ItemStack(ItemInit.BEER_KEG), 5.0F, 16000);

    }


    public void addMicroBrewerRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience, int cookTime)
    {
        if(getMicroBrewerResult(input1, input2) != ItemStack.EMPTY) return;
        this.smeltingList.put(input1, input2, result);
        this.experienceList.put(result, Float.valueOf(experience));
        this.cookTimeList.put(result, cookTime);

    }

    public ItemStack getMicroBrewerResult(ItemStack input1, ItemStack input2)
    {
        for(Map.Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet())
        {
            if(this.compareItemStacks(input1, (ItemStack)entry.getKey()))
            {
                for(Map.Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
                {
                    if(this.compareItemStacks(input2, (ItemStack)ent.getKey()))
                    {
                        return (ItemStack)ent.getValue();
                    }
                }
            }
        }
        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList()
    {
        return this.smeltingList;
    }

    public float getMicroBrewerExperience(ItemStack stack)
    {
        for (Map.Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if(this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }
        return 0.0F;
    }

    public int getMicroBrewerCookTime(ItemStack stack)
    {
        for (Map.Entry<ItemStack, Integer> entry : this.cookTimeList.entrySet())
        {
            if(this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Integer)entry.getValue()).intValue();
            }
        }
        return 0;
    }


}
