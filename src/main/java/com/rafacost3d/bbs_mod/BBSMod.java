package com.rafacost3d.bbs_mod;

import com.rafacost3d.bbs_mod.init.BBSConfig;
import com.rafacost3d.bbs_mod.init.BBSGuiHandler;
import com.rafacost3d.bbs_mod.proxy.CommonProxy;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = BBSMod.MODID, name = BBSMod.MODNAME, version = BBSMod.VERSION, useMetadata = true, updateJSON = "https://github.com/rafacost/bbs_mod/version.json")

public class BBSMod
{
    public static final String MODID = "bbs_mod";
    public static final String MODNAME = "Beer Brewery Simulator";
    public static final String VERSION = "${version}";
    public static Logger logger;


    @Mod.Instance(MODID)
    public static BBSMod instance;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @SidedProxy(clientSide = "com.rafacost3d.bbs_mod.proxy.ClientProxy", serverSide = "com.rafacost3d.bbs_mod.proxy.ServerProxy")
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        logger = e.getModLog();
        logger.info("<<" + MODNAME + " is PreInitializing! >>");
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new BBSGuiHandler());
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init(e);
        logger.info("<<" + MODNAME + " is Initializing! >>");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        proxy.postInit(e);
        logger.info("<<" + MODNAME + " is PostInitializing! >>");
    }
}
