package com.rafacost3d.bbs_mod;

import com.rafacost3d.bbs_mod.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BBSMod.MODID, name = BBSMod.MODNAME, version = BBSMod.VERSION, useMetadata = true)

public class BBSMod
{
    public static final String MODID = "bbs_mod";
    public static final String MODNAME = "Beer Brewery Simulator";
    public static final String VERSION = "${version}";

    @SidedProxy(clientSide = "com.rafacost3d.bbs_mod.proxy.ClientProxy", serverSide = "com.rafacost3d.bbs_mod.proxy.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        this.proxy.preInit(e);
        System.out.println(" << BBS_Mod PreInit Successfully! >> ");
    }]'\
        40240'

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
        this.proxy.init(e);
        System.out.println(" << BBS_Mod Init Successfully! >> ");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        this.proxy.postInit(e);
        System.out.println(" << BBS_Mod PostInit Successfully! >> ");
    }
}
