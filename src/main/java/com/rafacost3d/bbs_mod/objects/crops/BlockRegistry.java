package com.rafacost3d.bbs_mod.objects.crops;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public class BlockRegistry {

    public static final List<Block> blocks = new ArrayList<Block>();

    private static boolean initialized = false;

    public static void initBlockRegistry() {
        initialized = true;
    }


    public static void registerBlock(String registerName, ItemBlock itemBlock, Block block) {
        block.setRegistryName(registerName);
        block.setUnlocalizedName(registerName);
        blocks.add(block);

        if (itemBlock != null)
        {
            itemBlock.setRegistryName(registerName);
            itemBlock.setUnlocalizedName(registerName);
            ItemRegistry.itemlist.add(itemBlock);
        }
        return;
    }

    public static void registerBlock(String registerName, Block block) {
        final ItemBlock itemBlock = new ItemBlock(block);
        registerBlock(registerName, itemBlock, block);
    }
    @SubscribeEvent
    public void onBlockRegistry(RegistryEvent.Register<Block> e) {
        IForgeRegistry<Block> reg = e.getRegistry();
        reg.registerAll(blocks.toArray(new Block[0]));
        //reg.register(BlockRegistry.pamfossilItemBlock);
    }
}
