package com.rafacost3d.bbs_mod.proxy;

import com.rafacost3d.bbs_mod.init.BBSBlocks;
import com.rafacost3d.bbs_mod.init.BBSFluids;
import com.rafacost3d.bbs_mod.init.BBSItems;
import com.rafacost3d.bbs_mod.compat.MainCompatHandler;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public abstract class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        MainCompatHandler.registerTOP();
        BBSFluids.preinit();
        BBSBlocks.preinit();
        BBSItems.preinit();
    }
    public void init(FMLInitializationEvent e) {

    }
    public void postInit(FMLPostInitializationEvent e) {

    }

    public String localize(String unlocalized, Object... args) {
        return I18n.translateToLocalFormatted(unlocalized, args);
    }
}
