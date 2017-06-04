package com.rafacost3d.bbs_mod.init;

import com.rafacost3d.bbs_mod.blocks.crops.BlockCrop;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.fml.common.FMLLog;

import java.text.MessageFormat;
import java.util.HashMap;

public class BBSCropRegistry {

    public static final String CROP_BLOCK_NAME = "hop{0}Crop";
    public static final String ITEM_NAME = "{0}.item";
    public static final String SEED_ITEM_NAME = "{0}.rhizome";

    public static final String SAAZ = "saaz";
    public static final String STRISSELSPALT = "strisselspalt";
    public static final String HALLERTAUMITTELFRUH = "hallertaumittelfruh";
    public static final String DOMESTICHALLERTAU = "domestichallertau";
    public static final String HALLERTAUHERSBRUCKER = "hallertauhersbrucker";
    public static final String HERSBRUCKER = "hersbrucker";
    public static final String LIBERTY = "liberty";
    public static final String YAMHILLGOLDINGS = "yamhillgoldings";
    public static final String CRYSTAL = "crystal";
    public static final String FUGGLES = "fuggles";
    public static final String GOLDINGS = "goldings";
    public static final String LUBLIN = "lublin";
    public static final String SPALT = "spalt";
    public static final String TETTNANGER = "tettnanger";
    public static final String ULTRA = "ultra";
    public static final String WILLAMETTE = "willamette";
    public static final String MOUNTHOOD = "mounthood";
    public static final String BCGOLDINGS = "bcgoldings";
    public static final String EASTKENTGOLDINGS = "eastkentgoldings";
    public static final String KENTGOLDINGS = "kentgoldings";
    public static final String VANGUARD = "vanguard";
    public static final String AHTANUM = "ahtanum";
    public static final String GLACIER = "glacier";
    public static final String STYRIANGOLDINGS = "styriangoldings";
    public static final String HULLERBITTERER = "hullerbitterer";
    public static final String WHITBREADGOLDING = "whitbreadgolding";
    public static final String MOUNTRAINIER = "mountrainier";
    public static final String PROGRESS = "progress";
    public static final String BRAMLINGCROSS = "bramlingcross";
    public static final String CLUSTER = "cluster";
    public static final String RECORD = "record";
    public static final String SANTIAM = "santiam";
    public static final String AQUILA = "aquila";
    public static final String CASCADE = "cascade";
    public static final String MOTUEKA = "motueka";
    public static final String ORION = "orion";
    public static final String YAKIMACLUSTER = "yakimacluster";
    public static final String YEOMAN = "yeoman";
    public static final String BULLION = "bullion";
    public static final String FIRSTGOLD = "firstgold";
    public static final String CENTENNIAL = "centennial";
    public static final String NORTHERNBREWER = "northernbrewer";
    public static final String TALISMAN = "talisman";
    public static final String PERLE = "perle";
    public static final String CHALLENGER = "challenger";
    public static final String AMARILLO = "amarillo";
    public static final String NORTHDOWN = "northdown";
    public static final String STERLING = "sterling";
    public static final String BREWERSGOLD = "brewersgold";
    public static final String PIONEER = "pioneer";
    public static final String SUPERSTYRIANS = "superstyrians";
    public static final String ZENITH = "zenith";
    public static final String BANNER = "banner";
    public static final String COMET = "comet";
    public static final String OMEGA = "omega";
    public static final String PHOENIX = "phoenix";
    public static final String PRIDEOFRINGWOOD = "prideofringwood";
    public static final String WYETARGET = "wyetarget";
    public static final String CITRA = "citra";
    public static final String SORACHIACE = "sorachiace";
    public static final String STICKLEBRACT = "sticklebract";
    public static final String TARGET = "target";
    public static final String EROICA = "eroica";
    public static final String HERALD = "herald";
    public static final String OLYMPIC = "olympic";
    public static final String HORIZON = "horizon";
    public static final String NELSONSAUVIN = "nelsonsauvin";
    public static final String SIMCOE = "simcoe";
    public static final String CHINOOK = "chinook";
    public static final String GALENA = "galena";
    public static final String SATUS = "satus";
    public static final String SUPERALPHA = "superalpha";
    public static final String NUGGET = "nugget";
    public static final String ADMIRAL = "admiral";
    public static final String COLUMBUS = "columbus";
    public static final String MAGNUM = "magnum";
    public static final String TOMAHAWK = "tomahawk";
    public static final String PACIFICGEM = "pacificgem";
    public static final String MILLENIUM = "millenium";
    public static final String NEWPORT = "newport";
    public static final String WARRIOR = "warrior";
    public static final String ZEUS = "zeus";
    public static final String SUMMIT = "summit";


    public static final String[] cropNames = new String[]  {
            SAAZ,
            STRISSELSPALT,
            HALLERTAUMITTELFRUH,
            DOMESTICHALLERTAU,
            HALLERTAUHERSBRUCKER,
            HERSBRUCKER,
            LIBERTY,
            YAMHILLGOLDINGS,
            CRYSTAL,
            FUGGLES,
            GOLDINGS,
            LUBLIN,
            SPALT,
            TETTNANGER,
            ULTRA,
            WILLAMETTE,
            MOUNTHOOD,
            BCGOLDINGS,
            EASTKENTGOLDINGS,
            KENTGOLDINGS,
            VANGUARD,
            AHTANUM,
            GLACIER,
            STYRIANGOLDINGS,
            HULLERBITTERER,
            WHITBREADGOLDING,
            MOUNTRAINIER,
            PROGRESS,
            BRAMLINGCROSS,
            CLUSTER,
            RECORD,
            SANTIAM,
            AQUILA,
            CASCADE,
            MOTUEKA,
            ORION,
            YAKIMACLUSTER,
            YEOMAN,
            BULLION,
            FIRSTGOLD,
            CENTENNIAL,
            NORTHERNBREWER,
            TALISMAN,
            PERLE,
            CHALLENGER,
            AMARILLO,
            NORTHDOWN,
            STERLING,
            BREWERSGOLD,
            PIONEER,
            SUPERSTYRIANS,
            ZENITH,
            BANNER,
            COMET,
            OMEGA,
            PHOENIX,
            PRIDEOFRINGWOOD,
            WYETARGET,
            CITRA,
            SORACHIACE,
            STICKLEBRACT,
            TARGET,
            EROICA,
            HERALD,
            OLYMPIC,
            HORIZON,
            NELSONSAUVIN,
            SIMCOE,
            CHINOOK,
            GALENA,
            SATUS,
            SUPERALPHA,
            NUGGET,
            ADMIRAL,
            COLUMBUS,
            MAGNUM,
            TOMAHAWK,
            PACIFICGEM,
            MILLENIUM,
            NEWPORT,
            WARRIOR,
            ZEUS,
            SUMMIT
    };

    private static boolean isInitialized = false;

    private static final HashMap<String, Item> seeds = new HashMap<String, Item>();
    private static final HashMap<String, ItemSeedFood> foods = new HashMap<String, ItemSeedFood>();
    private static final HashMap<String, BlockCrop> crops = new HashMap<String, BlockCrop>();

    public static HashMap<String, Item> getSeeds() {
        return seeds;
    }

    public static HashMap<String, ItemSeedFood> getFoods() {
        return foods;
    }

    public static HashMap<String, BlockCrop> getCrops() {
        if (!isInitialized) {
            FMLLog.bigWarning("Crop registry is not initialized.");
            return new HashMap<String, BlockCrop>();
        }
        return crops;
    }

    public static boolean isInitialized() {
        return isInitialized;
    }

    public static Item getSeed(String cropName) {
        if (!isInitialized()) {
            FMLLog.bigWarning("Crop registry has not been initialized yet.");
            return null;
        }

        if (!seeds.containsKey(cropName)) {
            FMLLog.bigWarning("No seed for key %s", cropName);
            return null;
        }


        return seeds.get(cropName);
    }

    public static ItemSeedFood getFood(String cropName) {
        if (!isInitialized()) {
            FMLLog.bigWarning("Crop registry has not been initialized yet.");
            return null;
        }

        if (!foods.containsKey(cropName)) {
            FMLLog.bigWarning("No food for key %s", cropName);
            return null;
        }


        return foods.get(cropName);
    }

    public static BlockCrop getCrop(String cropName) {
        if (!isInitialized()) {
            FMLLog.bigWarning("Crop registry has not been initialized yet.");
            return null;
        }

        if (!crops.containsKey(cropName)) {
            FMLLog.bigWarning("No crop for key %s", cropName);
            return null;
        }


        return crops.get(cropName);
    }

    public static void registerCrops() {
        if (isInitialized) return;

        for (String cropName : cropNames) {
            registerCrop(cropName);
        }

        isInitialized = true;
    }

    private static void registerCrop(String cropName) {
        final String registryName = MessageFormat.format(CROP_BLOCK_NAME, cropName);
        final BlockCrop cropBlock = new BlockCrop(registryName, cropName);
        final ItemBlock cropItemBlock = new BBSItemBlockCrop(cropBlock);

        BBSCropBlockRegistry.registerBlock(registryName, cropItemBlock, cropBlock);

        final ItemSeedFood item = createItem(cropBlock);
        BBSCropItemRegistry.registerItem(item, MessageFormat.format(ITEM_NAME, cropName));
        cropBlock.setFood(item);

        final Item seedItem = createSeed(cropBlock);
        BBSCropItemRegistry.registerItem(seedItem, getSeedName(cropName));
        cropBlock.setSeed(seedItem);

        seeds.put(cropName, seedItem);
        foods.put(cropName, item);
        crops.put(cropName, cropBlock);

    }

    private static String getSeedName(String cropName) {
        return MessageFormat.format(SEED_ITEM_NAME, cropName);
    }


    private static ItemSeedFood createItem(BlockCrop cropBlock) {
        return new ItemSeedFood(1, 0.6F, cropBlock, Blocks.FARMLAND);
    }

    private static Item createSeed(BlockCrop cropBlock) {
        return new ItemSeeds(cropBlock, Blocks.FARMLAND);
    }

}
