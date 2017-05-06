package com.rafacost3d.bbs_mod.compat;

import com.rafacost3d.bbs_mod.compat.top.TOPCompatibility;
import net.minecraftforge.fml.common.Loader;

public class MainCompatHandler {
    public static void registerTOP() {
        if (Loader.isModLoaded("theoneprobe")) {
            TOPCompatibility.register();
        }
    }

}