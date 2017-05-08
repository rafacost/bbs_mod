package com.rafacost3d.bbs_mod.proxy;


import com.rafacost3d.bbs_mod.BBSBlocks;
import com.rafacost3d.bbs_mod.BBSItems;
import com.rafacost3d.bbs_mod.BBSMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerItemRenderer(Item item, int meta, String id){
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(BBSMod.MODID + ":" + id, "inventory"));
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {

        super.preInit(e);
        BBSBlocks.initModels();
        BBSItems.initModels();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);

    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
