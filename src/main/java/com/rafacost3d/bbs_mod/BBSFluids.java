package com.rafacost3d.bbs_mod;


import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BBSFluids {
    private static ModelResourceLocation beer_location = new ModelResourceLocation(BBSMod.MODID + ":" + BlockBeer.name, "fluid");
    private static ModelResourceLocation wort_location = new ModelResourceLocation(BBSMod.MODID + ":" + BlockWort.name, "fluid");



    public static void register() {
        FluidRegistry.registerFluid(BBSFluids.FluidBeer.instance);
        FluidRegistry.registerFluid(BBSFluids.FluidWort.instance);
        FluidRegistry.addBucketForFluid(BBSFluids.FluidBeer.instance);
        FluidRegistry.addBucketForFluid(BBSFluids.FluidWort.instance);
        registerBlock(BlockBeer.instance);
        registerBlock(BlockWort.instance);
        Item beer = Item.getItemFromBlock(BlockBeer.instance);
        Item wort = Item.getItemFromBlock(BlockWort.instance);
        ModelLoader.setCustomMeshDefinition(beer, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return beer_location;
            }
        });
        ModelLoader.setCustomStateMapper(BlockBeer.instance, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return beer_location;
            }
        });
        ModelLoader.setCustomMeshDefinition(wort, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return wort_location;
            }
        });
        ModelLoader.setCustomStateMapper(BlockWort.instance, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return wort_location;
            }
        });


    }

    public static final class FluidBeer extends Fluid {
        public static final String name = "beer";
        public static final FluidBeer instance = new FluidBeer();

        public FluidBeer(){
            super(name, new ResourceLocation(BBSMod.MODID + ":" + "fluid/" + name + "_still"), new ResourceLocation(BBSMod.MODID + ":" + "fluid/" + name + "_flow"));
            setDensity(1060);
            setTemperature(277);
            setViscosity(1800);
        }
    }

    public static final class FluidWort extends Fluid {
        public static final String name = "wort";
        public static final FluidWort instance = new FluidWort();

        public FluidWort(){
            super(name, new ResourceLocation(BBSMod.MODID + ":" + "fluid/" + name + "_still"), new ResourceLocation(BBSMod.MODID + ":" + "fluid/" + name + "_flow"));
            setDensity(10000);
            setTemperature(338);
            setViscosity(13000);
        }
    }

    public static void registerBlock(Block block){

        GameRegistry.register(block);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        GameRegistry.register(item);

    }

    public static final class BlockBeer extends BlockFluidClassic {

        public static final BlockBeer instance = new BlockBeer();
        public static final String name = "beer";

        public BlockBeer() {
            super(FluidBeer.instance, Material.WATER);
            setUnlocalizedName(BBSMod.MODID + "." + name);
            setRegistryName(name);
            setCreativeTab(CreativeTabsBBS.BBSTabsFluids);


        }

        @Override
        public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
            if(entityIn instanceof EntityLivingBase) {
                ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(2), 100, 10, false, true));
                ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(25), 10, 10, false, true));
                ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(9), 1, 10, false, true));

            }
        }

        @Override
        public EnumBlockRenderType getRenderType(IBlockState state){
            return EnumBlockRenderType.MODEL;
        }
    }

    public static final class BlockWort extends BlockFluidClassic {

        public static final BlockWort instance = new BlockWort();
        public static final String name = "wort";

        public BlockWort() {
            super(FluidWort.instance, Material.WATER);
            setUnlocalizedName(BBSMod.MODID + "." + name);
            setRegistryName(name);
            setCreativeTab(CreativeTabsBBS.BBSTabsFluids);
        }

        @Override
        public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
            if(entityIn instanceof EntityLivingBase) {
                ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(2), 200, 10, false, true));
            }
        }

        @Override
        public EnumBlockRenderType getRenderType(IBlockState state){
            return EnumBlockRenderType.MODEL;
        }
    }

}
