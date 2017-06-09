package com.rafacost3d.bbs_mod.init;


import com.rafacost3d.bbs_mod.blocks.machines.aluminiumpot.AluminiumPot;
import com.rafacost3d.bbs_mod.blocks.machines.pelleter.PelleterBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BBSBlocks {

    public static PelleterBlock pelleterBlock;
    public static AluminiumPot aluminiumPot;

    public static void preinit(){
        pelleterBlock = new PelleterBlock(Material.ROCK, "pelleter");
        aluminiumPot = new AluminiumPot(Material.IRON, "aluminiumpot");
    }

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        pelleterBlock.initModel();
        aluminiumPot.initModel();
    }
}
