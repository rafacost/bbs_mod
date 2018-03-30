package com.rafacost3d.bbs_mod.proxy;


import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.init.BBSConstants;
import com.rafacost3d.bbs_mod.init.BlocksInit;
import com.rafacost3d.bbs_mod.init.ConfigInit;
import com.rafacost3d.bbs_mod.objects.blocks.*;
import com.rafacost3d.bbs_mod.objects.blocks.machines.MicroBrewer.MicroBrewerBlock;
import com.rafacost3d.bbs_mod.objects.blocks.machines.MicroBrewer.TileEntityMicroBrewer;
import com.rafacost3d.bbs_mod.objects.crops.BlockRegistry;
import com.rafacost3d.bbs_mod.objects.crops.CropRegistry;
import com.rafacost3d.bbs_mod.objects.crops.ItemRegistry;
import com.rafacost3d.bbs_mod.objects.items.BeerKegItem;
import com.rafacost3d.bbs_mod.objects.items.MashKegItem;
import com.rafacost3d.bbs_mod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {
    public static Configuration config;

    public void registerItemRenderer(Item item, int meta, String id) {}

    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "bbs_mod.cfg"));
        ConfigInit.readConfig();
        BBSConstants.preint();
        CropRegistry.registerCrops();
        BlockRegistry.initBlockRegistry();
        MinecraftForge.EVENT_BUS.register(new BlockRegistry());
        ItemRegistry.registerItems();
        MinecraftForge.EVENT_BUS.register(new ItemRegistry());
    }

    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(BBSMod.instance, new GuiProxy());
        MinecraftForge.addGrassSeed(CropRegistry.getSeed(CropRegistry.LIBERTY).getDefaultInstance(), 10);
        MinecraftForge.addGrassSeed(CropRegistry.getSeed(CropRegistry.STRISSELSPALT).getDefaultInstance(), 10);
        MinecraftForge.addGrassSeed(CropRegistry.getSeed(CropRegistry.MALT).getDefaultInstance(), 5);
       }
    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new ModelBlock());
        event.getRegistry().register(new MicroBrewerBlock());
        GameRegistry.registerTileEntity(TileEntityMicroBrewer.class, Reference.MODID + "_microbrewer");
        //event.getRegistry().register(new MicroPackBlock());
        //GameRegistry.registerTileEntity(MicroPackTileEntity.class, Reference.MODID + "_micropack");
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(BlocksInit.microBrewerBlock).setRegistryName(BlocksInit.microBrewerBlock.getRegistryName()));
        event.getRegistry().register(new MashKegItem());
        event.getRegistry().register(new BeerKegItem());
        //event.getRegistry().register(new ItemBlock(BlocksInit.modelBlock).setRegistryName(BlocksInit.modelBlock.getRegistryName()));
        //event.getRegistry().register(new ItemBlock(BlocksInit.microPackBlock).setRegistryName(BlocksInit.microPackBlock.getRegistryName()));

    }
}
