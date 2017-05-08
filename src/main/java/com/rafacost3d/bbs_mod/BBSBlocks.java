package com.rafacost3d.bbs_mod;


import com.rafacost3d.bbs_mod.blocks.BasicBlock;
import com.rafacost3d.bbs_mod.blocks.BlockBase;
import com.rafacost3d.bbs_mod.blocks.HopCropBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BBSBlocks {

    public static BasicBlock basicBlock;
    public static HopCropBlock hopcropBlock;
    public static Boolean isBurning;

    public static void init(){
        isBurning = false;
        basicBlock = new BasicBlock();
        hopcropBlock = new HopCropBlock();

    }

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        basicBlock.initModel();
        hopcropBlock.initModel();
    }

    private static <T extends Block> T register(T block, ItemBlock itemBlock) {
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);

        if (block instanceof BlockBase) {
            ((BlockBase)block).registerItemModel(itemBlock);
        }

        return block;
    }

    private static <T extends Block> T register(T block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }
}
