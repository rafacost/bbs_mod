package com.rafacost3d.bbs_mod.blocks;

import com.rafacost3d.bbs_mod.BBSItems;
import com.rafacost3d.bbs_mod.BBSMod;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HopCropBlock extends BlockCrops {
    private ResourceLocation nameBlock;

    public  HopCropBlock(){
        super();
        setRegistryName("hopcropblock");
        setUnlocalizedName(BBSMod.MODID + ".hopcropblock");
        GameRegistry.register(this);
        if(getRegistryName()!=null) {
            nameBlock = getRegistryName();
        }
        GameRegistry.register(new ItemBlock(this), nameBlock);
    }

    @Override
    protected Item getSeed() {
        return BBSItems.hopSeedsItem;
    }

    @Override
    protected Item getCrop() {
        return BBSItems.basicItem;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(nameBlock, "inventory"));
    }
}
