package com.rafacost3d.bbs_mod.proxy;

import com.rafacost3d.bbs_mod.BBSItems;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        BBSItems.init();
    }
    public void init(FMLInitializationEvent e) {

    }
    public void postInit(FMLPostInitializationEvent e) {

    }
}
