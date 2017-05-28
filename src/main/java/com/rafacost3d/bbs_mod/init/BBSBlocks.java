package com.rafacost3d.bbs_mod.init;


import com.rafacost3d.bbs_mod.blocks.*;
import com.rafacost3d.bbs_mod.blocks.machines.aluminiumpot.AluminiumPot;
import com.rafacost3d.bbs_mod.blocks.machines.boilingpot.BoilingPotBlock;
import com.rafacost3d.bbs_mod.blocks.machines.pelleter.PelleterBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BBSBlocks {

    //public static BasicBlock basicBlock;
    //public static BlockTileEntity counterBlock;
    public static HopCropBlock hopcropBlock;
    public static PelleterBlock pelleterBlock;
    public static BoilingPotBlock boilingPotBlock;
    public static AluminiumPot aluminiumPot;




    public static void preinit(){
        //basicBlock = new BasicBlock(Material.ROCK, "basicblock");
        //counterBlock = new BlockTileEntity(Material.ROCK, "counter");
        hopcropBlock = new HopCropBlock();
        boilingPotBlock = new BoilingPotBlock(Material.IRON, "boilingpot");
        pelleterBlock = new PelleterBlock(Material.ROCK, "pelleter");
        aluminiumPot = new AluminiumPot(Material.IRON, "aluminiumpot");

    }

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        //basicBlock.initModel();
        //counterBlock.initModel();
        hopcropBlock.initModel();
        boilingPotBlock.initModel();
        pelleterBlock.initModel();
        aluminiumPot.initModel();
    }
}
