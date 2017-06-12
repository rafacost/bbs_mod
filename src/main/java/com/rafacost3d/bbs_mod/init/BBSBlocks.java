package com.rafacost3d.bbs_mod.init;


import com.rafacost3d.bbs_mod.blocks.machines.aluminiumpot.AluminiumPot;
import com.rafacost3d.bbs_mod.blocks.machines.fermentorbucket.FermentorBucket;
import com.rafacost3d.bbs_mod.blocks.machines.pelleter.PelleterBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BBSBlocks {

    public static PelleterBlock pelleterBlock;
    public static AluminiumPot aluminiumPot;
    public static FermentorBucket fermentorBucket;

    public static void preinit(){
        pelleterBlock = new PelleterBlock(Material.ROCK, "pelleter");
        aluminiumPot = new AluminiumPot(Material.IRON, "aluminiumpot");
        fermentorBucket = new FermentorBucket(Material.ROCK, "fermentorbucket");
    }

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        pelleterBlock.initModel();
        aluminiumPot.initModel();
        fermentorBucket.initModel();
    }
}
