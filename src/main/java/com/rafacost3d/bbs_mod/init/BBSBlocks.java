package com.rafacost3d.bbs_mod.init;


import com.rafacost3d.bbs_mod.blocks.*;
import com.rafacost3d.bbs_mod.blocks.machines.boilingpot.BoilingPotBlock;
import com.rafacost3d.bbs_mod.blocks.machines.pelleter.PelleterBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BBSBlocks {

    public static BasicBlock basicBlock;
    public static HopCropBlock hopcropBlock;
    public static BlockTileEntity counterBlock;
    public static PelleterBlock pelleterBlock;
    public static BoilingPotBlock boilingPotBlock;



    public static void preinit(){
        //basicBlock = new BasicBlock(Material.ROCK, "basicblock");
        hopcropBlock = new HopCropBlock();
        boilingPotBlock = new BoilingPotBlock(Material.IRON, "boilingpot");
        counterBlock = new BlockTileEntity(Material.ROCK, "counter");
        pelleterBlock = new PelleterBlock(Material.ROCK, "pelleter");

    }

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        //basicBlock.initModel();
        hopcropBlock.initModel();
        counterBlock.initModel();
        pelleterBlock.initModel();
        boilingPotBlock.initModel();
    }
}
