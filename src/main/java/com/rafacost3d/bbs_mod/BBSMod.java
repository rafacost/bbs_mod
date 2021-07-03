package com.rafacost3d.bbs_mod;

import com.rafacost3d.bbs_mod.proxy.CommonProxy;
import com.rafacost3d.bbs_mod.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class BBSMod
{
    public static Logger logger;

    @Mod.Instance
    public static BBSMod instance;

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        logger = e.getModLog();
        logger.info("<<" + Reference.NAME + " is PreInitializing! >>");
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
        logger.info("<<" + Reference.NAME + " is Initializing! >>");
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        logger.info("<<" + Reference.NAME + " is PostInitializing! >>");
        proxy.postInit(e);
    }
}
