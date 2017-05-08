package com.rafacost3d.bbs_mod;

import com.rafacost3d.bbs_mod.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BBSMod.MODID, name = BBSMod.MODNAME, version = BBSMod.VERSION, useMetadata = true, updateJSON = "https://github.com/rafacost/bbs_mod/version.json")

public class BBSMod
{
    public static final String MODID = "bbs_mod";
    public static final String MODNAME = "Beer Brewery Simulator";
    public static final String VERSION = "${version}";

    @SidedProxy(clientSide = "com.rafacost3d.bbs_mod.proxy.ClientProxy", serverSide = "com.rafacost3d.bbs_mod.proxy.ServerProxy")
    public static CommonProxy proxy;


    @Mod.Instance(MODID)
    public static BBSMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        this.proxy.preInit(e);
        System.out.println(" << " + MODNAME + " PreInit Successfully! >> ");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        this.proxy.init(e);
        System.out.println(" << " + MODNAME + " Init Successfully! >> ");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        this.proxy.postInit(e);
        System.out.println(" << " + MODNAME + " PostInit Successfully! >> ");
    }
}
