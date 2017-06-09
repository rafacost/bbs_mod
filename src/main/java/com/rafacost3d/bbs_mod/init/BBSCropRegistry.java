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

    public static final String CROP_BLOCK_NAME = "hop{0}.crop";
    public static final String ITEM_NAME = "{0}.hop";
    public static final String SEED_ITEM_NAME = "{0}.rhizome";
    public static final String PELLET_ITEM_NAME = "{0}.pellet";

    public static final String ADMIRAL = "admiral";
    public static final String AHTANUM = "ahtanum";
    public static final String AMARILLO = "amarillo";
    public static final String AQUILA = "aquila";
    public static final String ARAMIS = "aramis";
    public static final String AURORA = "aurora";
    public static final String BANNER = "banner";
    public static final String BCGOLDING = "bcgolding";
    public static final String BITTERGOLD = "bittergold";
    public static final String BLANC = "blanc";
    public static final String BOBEK = "bobek";
    public static final String BRAMLINGCROSS = "bramlingcross";
    public static final String BRAVO = "bravo";
    public static final String BREWERSGOLDGERMANY = "brewersgoldgermany";
    public static final String BREWERSGOLDUSA = "brewersgoldusa";
    public static final String BULLION = "bullion";
    public static final String CASCADE = "cascade";
    public static final String CELEIA = "celeia";
    public static final String CENTENNIAL = "centennial";
    public static final String CHALLENGER = "challenger";
    public static final String CHELAN = "chelan";
    public static final String CHINOOK = "chinook";
    public static final String CITRA = "citra";
    public static final String CLUSTER = "cluster";
    public static final String COLUMBUS = "columbus";
    public static final String COMET = "comet";
    public static final String CRYSTAL = "crystal";
    public static final String DRRUDI = "drrudi";
    public static final String EASTKENTGOLDING = "eastkentgolding";
    public static final String EKUANOT = "ekuanot";
    public static final String ELLA = "ella";
    public static final String EROICA = "eroica";
    public static final String FALCONERSFLIGHT = "falconersflight";
    public static final String FIRSTGOLD = "firstgold";
    public static final String FUGGLEUK = "fuggleuk";
    public static final String GALAXY = "galaxy";
    public static final String GALENA = "galena";
    public static final String GLACIER = "glacier";
    public static final String GOLD = "gold";
    public static final String GOLDINGUK = "goldinguk";
    public static final String GOLDINGUSA = "goldingusa";
    public static final String GREENBULLET = "greenbullet";
    public static final String HALLERTAUMITTELFRUH = "hallertaumittelfruh";
    public static final String HALLERTAUUSA = "hallertauusa";
    public static final String HBC431EXPERIMENTAL = "hbc431experimental";
    public static final String HBC438EXPERIMENTAL = "hbc438experimental";
    public static final String HBC472EXPERIMENTAL = "hbc472experimental";
    public static final String HBC682EXPERIMENTAL = "hbc682experimental";
    public static final String HELGA = "helga";
    public static final String HERALD = "herald";
    public static final String HERKULES = "herkules";
    public static final String HERSBRUCKER = "hersbrucker";
    public static final String HORIZON = "horizon";
    public static final String HUELLMELON = "huellmelon";
    public static final String HULLERBITTERER = "hullerbitterer";
    public static final String KOHATU = "kohatu";
    public static final String LIBERTY = "liberty";
    public static final String LORAL = "loral";
    public static final String LUBELSKA = "lubelska";
    public static final String MAGNUM = "magnum";
    public static final String MANDARINABAVARIA = "mandarinabavaria";
    public static final String MERKUR = "merkur";
    public static final String MILLENIUM = "millenium";
    public static final String MOSAIC = "mosaic";
    public static final String MOTUEKA = "motueka";
    public static final String MOUNTHOOD = "mounthood";
    public static final String MOUNTRAINIER = "mountrainier";
    public static final String NELSONSAUVIN = "nelsonsauvin";
    public static final String NEWPORT = "newport";
    public static final String NORTHDOWN = "northdown";
    public static final String NORTHERNBREWER = "northernbrewer";
    public static final String NUGGET = "nugget";
    public static final String OLYMPIC = "olympic";
    public static final String OMEGA = "omega";
    public static final String OPAL = "opal";
    public static final String ORION = "orion";
    public static final String PACIFICA = "pacifica";
    public static final String PACIFICGEM = "pacificgem";
    public static final String PACIFICJADE = "pacificjade";
    public static final String PALISADE = "palisade";
    public static final String PERLEGERMANY = "perlegermany";
    public static final String PERLEUSA = "perleusa";
    public static final String PHOENIX = "phoenix";
    public static final String PILGRIM = "pilgrim";
    public static final String PIONEER = "pioneer";
    public static final String POLARIS = "polaris";
    public static final String PREMIANT = "premiant";
    public static final String PRIDEOFRINGWOOD = "prideofringwood";
    public static final String PROGRESS = "progress";
    public static final String RAKAU = "rakau";
    public static final String RECORD = "record";
    public static final String RIWAKA = "riwaka";
    public static final String SAAZ = "saaz";
    public static final String SANTIAM = "santiam";
    public static final String SAPHIR = "saphir";
    public static final String SATUS = "satus";
    public static final String SAVINJSKIGOLDING = "savinjskigolding";
    public static final String SELECT = "select";
    public static final String SIMCOE = "simcoe";
    public static final String SMARAGD = "smaragd";
    public static final String SORACHIACE = "sorachiace";
    public static final String SOUTHERNCROSS = "southerncross";
    public static final String SOVEREIGN = "sovereign";
    public static final String SPALT = "spalt";
    public static final String STERLING = "sterling";
    public static final String STICKLEBRACT = "sticklebract";
    public static final String STRISSELSPALT = "strisselspalt";
    public static final String STYRIANGOLDING = "styriangolding";
    public static final String SUMMER = "summer";
    public static final String SUMMIT = "summit";
    public static final String SUPERALPHA = "superalpha";
    public static final String SUPERPRIDE = "superpride";
    public static final String SUSSEX = "sussex";
    public static final String SYLVA = "sylva";
    public static final String TAHOMA = "tahoma";
    public static final String TALISMAN = "talisman";
    public static final String TARGET = "target";
    public static final String TETTNANGERGERMANY = "tettnangergermany";
    public static final String TETTNANGERUSA = "tettnangerusa";
    public static final String TOMAHAWK = "tomahawk";
    public static final String TRADITION = "tradition";
    public static final String TRIPLEPEARL = "triplepearl";
    public static final String TRISKEL = "triskel";
    public static final String ULTRA = "ultra";
    public static final String VANGUARD = "vanguard";
    public static final String WAIITI = "waiiti";
    public static final String WAIMEA = "waimea";
    public static final String WAKATU = "wakatu";
    public static final String WARRIOR = "warrior";
    public static final String WHITBREADGOLDING = "whitbreadgolding";
    public static final String WILLAMETTE = "willamette";
    public static final String YAKIMACLUSTER = "yakimacluster";
    public static final String YAMHILLGOLDING = "yamhillgolding";
    public static final String YEOMAN = "yeoman";
    public static final String ZENITH = "zenith";
    public static final String ZEUS = "zeus";
    public static final String ZYTHOS = "zythos";


    public static final String[] cropNames = new String[]  {
            ADMIRAL,
            AHTANUM,
            AMARILLO,
            AQUILA,
            ARAMIS,
            AURORA,
            BANNER,
            BCGOLDING,
            BITTERGOLD,
            BLANC,
            BOBEK,
            BRAMLINGCROSS,
            BRAVO,
            BREWERSGOLDGERMANY,
            BREWERSGOLDUSA,
            BULLION,
            CASCADE,
            CELEIA,
            CENTENNIAL,
            CHALLENGER,
            CHELAN,
            CHINOOK,
            CITRA,
            CLUSTER,
            COLUMBUS,
            COMET,
            CRYSTAL,
            DRRUDI,
            EASTKENTGOLDING,
            EKUANOT,
            ELLA,
            EROICA,
            FALCONERSFLIGHT,
            FIRSTGOLD,
            FUGGLEUK,
            GALAXY,
            GALENA,
            GLACIER,
            GOLD,
            GOLDINGUK,
            GOLDINGUSA,
            GREENBULLET,
            HALLERTAUMITTELFRUH,
            HALLERTAUUSA,
            HBC431EXPERIMENTAL,
            HBC438EXPERIMENTAL,
            HBC472EXPERIMENTAL,
            HBC682EXPERIMENTAL,
            HELGA,
            HERALD,
            HERKULES,
            HERSBRUCKER,
            HORIZON,
            HUELLMELON,
            HULLERBITTERER,
            KOHATU,
            LIBERTY,
            LORAL,
            LUBELSKA,
            MAGNUM,
            MANDARINABAVARIA,
            MERKUR,
            MILLENIUM,
            MOSAIC,
            MOTUEKA,
            MOUNTHOOD,
            MOUNTRAINIER,
            NELSONSAUVIN,
            NEWPORT,
            NORTHDOWN,
            NORTHERNBREWER,
            NUGGET,
            OLYMPIC,
            OMEGA,
            OPAL,
            ORION,
            PACIFICA,
            PACIFICGEM,
            PACIFICJADE,
            PALISADE,
            PERLEGERMANY,
            PERLEUSA,
            PHOENIX,
            PILGRIM,
            PIONEER,
            POLARIS,
            PREMIANT,
            PRIDEOFRINGWOOD,
            PROGRESS,
            RAKAU,
            RECORD,
            RIWAKA,
            SAAZ,
            SANTIAM,
            SAPHIR,
            SATUS,
            SAVINJSKIGOLDING,
            SELECT,
            SIMCOE,
            SMARAGD,
            SORACHIACE,
            SOUTHERNCROSS,
            SOVEREIGN,
            SPALT,
            STERLING,
            STICKLEBRACT,
            STRISSELSPALT,
            STYRIANGOLDING,
            SUMMER,
            SUMMIT,
            SUPERALPHA,
            SUPERPRIDE,
            SUSSEX,
            SYLVA,
            TAHOMA,
            TALISMAN,
            TARGET,
            TETTNANGERGERMANY,
            TETTNANGERUSA,
            TOMAHAWK,
            TRADITION,
            TRIPLEPEARL,
            TRISKEL,
            ULTRA,
            VANGUARD,
            WAIITI,
            WAIMEA,
            WAKATU,
            WARRIOR,
            WHITBREADGOLDING,
            WILLAMETTE,
            YAKIMACLUSTER,
            YAMHILLGOLDING,
            YEOMAN,
            ZENITH,
            ZEUS,
            ZYTHOS
    };

    private static boolean isInitialized = false;

    private static final HashMap<String, Item> seeds = new HashMap<String, Item>();
    private static final HashMap<String, ItemSeedFood> foods = new HashMap<String, ItemSeedFood>();
    private static final HashMap<String, ItemSeedFood> pellets = new HashMap<String, ItemSeedFood>();
    private static final HashMap<String, BlockCrop> crops = new HashMap<String, BlockCrop>();

    public static HashMap<String, Item> getSeeds() {
        return seeds;
    }

    public static HashMap<String, ItemSeedFood> getFoods() {
        return foods;
    }

    public static HashMap<String, ItemSeedFood> getPellets() {
        return pellets;
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

    public static ItemSeedFood getPellet(String cropName) {
        if (!isInitialized()) {
            FMLLog.bigWarning("Crop registry has not been initialized yet.");
            return null;
        }

        if (!pellets.containsKey(cropName)) {
            FMLLog.bigWarning("No pellet for key %s", cropName);
            return null;
        }


        return pellets.get(cropName);
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

        final ItemSeedFood itemPellet = createItem(cropBlock);
        BBSCropItemRegistry.registerItem(itemPellet, MessageFormat.format(PELLET_ITEM_NAME, cropName));
        //cropBlock.setFood(itemPellet);

        final Item seedItem = createSeed(cropBlock);
        BBSCropItemRegistry.registerItem(seedItem, getSeedName(cropName));
        cropBlock.setSeed(seedItem);

        seeds.put(cropName, seedItem);
        foods.put(cropName, item);
        pellets.put(cropName, itemPellet);
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
