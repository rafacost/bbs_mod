package com.rafacost3d.bbs_mod.init;

import com.rafacost3d.bbs_mod.objects.blocks.machines.MicroBrewer.MicroBrewerBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlocksInit {
    /*
    @GameRegistry.ObjectHolder("bbs_mod:modelblock")
    public static ModelBlock modelBlock;
    @GameRegistry.ObjectHolder("bbs_mod:micropack")
    public static MicroPackBlock microPackBlock;
    */
    @GameRegistry.ObjectHolder("bbs_mod:microbrewer")
    public static MicroBrewerBlock microBrewerBlock;


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        microBrewerBlock.initModel();
        //modelBlock.initModel();
        //microPackBlock.initModel();
    }

}
