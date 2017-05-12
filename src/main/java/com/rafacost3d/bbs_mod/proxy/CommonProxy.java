package com.rafacost3d.bbs_mod.proxy;

import com.rafacost3d.bbs_mod.BBSBlocks;
import com.rafacost3d.bbs_mod.BBSItems;
import com.rafacost3d.bbs_mod.compat.MainCompatHandler;
import net.minecraft.item.Item;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class CommonProxy {

    public void registerItemRenderer(Item item, int meta, String id){

    }
    public String localize(String unlocalized, Object... args) {
        return I18n.translateToLocalFormatted(unlocalized, args);
    }

    public void preInit(FMLPreInitializationEvent e) {
        MainCompatHandler.registerTOP();
        BBSBlocks.init();
        BBSItems.init();
    }
    public void init(FMLInitializationEvent e) {

    }
    public void postInit(FMLPostInitializationEvent e) {

    }
}
