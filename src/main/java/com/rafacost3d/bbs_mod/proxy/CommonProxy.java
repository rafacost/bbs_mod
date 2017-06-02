package com.rafacost3d.bbs_mod.proxy;

import com.rafacost3d.bbs_mod.init.*;
import com.rafacost3d.bbs_mod.compat.MainCompatHandler;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import java.io.File;

public abstract class CommonProxy {

    // Config instance
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "bbs_mod.cfg"));
        BBSConfig.readConfig();
        BBSConstants.preint();
        MainCompatHandler.registerTOP();
        BBSFluids.preinit();
        BBSBlocks.preinit();
        BBSItems.preinit();
    }
    public void init(FMLInitializationEvent e) {
        BBSRecipes.init();
    }
    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.addCustomCategoryComment("general","Selected below the Unit System you prefer. Metric (true) or US/Imperial (false)");
            config.save();
        }
    }
}
