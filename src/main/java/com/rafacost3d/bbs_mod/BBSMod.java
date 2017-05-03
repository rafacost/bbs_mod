package com.rafacost3d.bbs_mod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = BBSMod.MODID, name = BBSMod.MODNAME, version = BBSMod.VERSION, useMetadata = true)

public class BBSMod
{
    public static final String MODID = "bbs_mod";
    public static final String MODNAME = "Beer Brewery Simulator";
    public static final String VERSION = "${version}";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
}
