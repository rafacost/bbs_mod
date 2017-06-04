package com.rafacost3d.bbs_mod.proxy;


import com.rafacost3d.bbs_mod.blocks.crops.CropsModels;
import com.rafacost3d.bbs_mod.init.BBSBlocks;
import com.rafacost3d.bbs_mod.init.BBSFluids;
import com.rafacost3d.bbs_mod.init.BBSItemRenderRegister;
import com.rafacost3d.bbs_mod.init.BBSItems;
import com.rafacost3d.bbs_mod.BBSMod;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        OBJLoader.INSTANCE.addDomain(BBSMod.MODID);
        BBSFluids.initModels();
        BBSBlocks.initModels();
        BBSItems.initModels();
        CropsModels.preInit();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        CropsModels.init();
        BBSItemRenderRegister.registerItemRenderer();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

}
