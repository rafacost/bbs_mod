package com.rafacost3d.bbs_mod.blocks;

import com.rafacost3d.bbs_mod.BBSItems;
import com.rafacost3d.bbs_mod.BBSMod;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

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
        Random rand = new Random();
        Integer i = rand.nextInt(3);

        switch (i){
            case 0: return BBSItems.hopsLeafItemAA1;
            case 1: return BBSItems.hopsLeafItemAA2;
            case 2: return BBSItems.hopsLeafItemAA3;
            default: return BBSItems.hopSeedsItem;
        }


    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(nameBlock, "inventory"));
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        List ret = super.getDrops(world, pos, state, fortune);
        int age = this.getAge(state);
        Random rand = world instanceof World ?((World)world).rand:new Random();
        if(age >= this.getMaxAge()) {
            int k = 1 + fortune;

            for(int i = 0; i < k; ++i) {
                if(rand.nextInt(2 * this.getMaxAge()) <= age) {
                    ItemStack seeds = new ItemStack(this.getSeed(), 1, 0);

                    if (haveQuality(seeds)) {
                        getTagCompoundSafe(seeds).setInteger("Quality", getTagCompoundSafe(seeds).getInteger("Quality")+1);
                    } else {
                        getTagCompoundSafe(seeds).setInteger("Quality", 1);
                        getTagCompoundSafe(seeds).setString("Country", "Domestic");
                    }

                    ret.add(seeds);
                }
            }
        }

        return ret;
    }

    private NBTTagCompound getTagCompoundSafe(ItemStack stack) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }
        return tagCompound;
    }
    private boolean haveQuality(ItemStack stack) {
        return getTagCompoundSafe(stack).hasKey("Quality");
    }



}
