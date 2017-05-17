package com.rafacost3d.bbs_mod;


import com.rafacost3d.bbs_mod.blocks.*;
import com.rafacost3d.bbs_mod.blocks.machines.BlockCounter;
import com.rafacost3d.bbs_mod.blocks.machines.BoilingPotBlock;
import com.rafacost3d.bbs_mod.blocks.machines.PelleterBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BBSBlocks {

    public static BasicBlock basicBlock;
    public static HopCropBlock hopcropBlock;
    public static BlockCounter counterBlock;
    public static PelleterBlock pelleterBlock;
    public static BoilingPotBlock boilingPotBlock;



    public static void init(){
        basicBlock = new BasicBlock();
        hopcropBlock = new HopCropBlock();
        boilingPotBlock = new BoilingPotBlock();
        counterBlock = register(new BlockCounter());
        pelleterBlock = register(new PelleterBlock());

    }

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        basicBlock.initModel();
        hopcropBlock.initModel();
        boilingPotBlock.initModel();
    }


    private static <T extends Block> T register(T block, ItemBlock itemBlock) {
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);

        if (block instanceof BlockBase) {
            ((BlockBase)block).registerItemModel(itemBlock);
        }

        if(block instanceof BlockTileEntity) {
            GameRegistry.registerTileEntity(((BlockTileEntity<?>)block).getTileEntityClass(), block.getRegistryName().toString()) ;
        }

        return block;
    }

    private static <T extends Block> T register(T block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }
}
