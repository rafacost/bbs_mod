package com.rafacost3d.bbs_mod;


import com.rafacost3d.bbs_mod.blocks.BasicBlock;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BBSBlocks {

    private static BasicBlock basicBlock;

    public static void init(){

        basicBlock = new BasicBlock();

    }

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        basicBlock.initModel();
    }
}
