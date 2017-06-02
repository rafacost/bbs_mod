package com.rafacost3d.bbs_mod.items;

import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;


public class RhizomesItem extends Item implements IPlantable {

    public String hopsType;
    public Double alphaAcid;
    public Double priceRhi;
    private final Block crops;

    public RhizomesItem(Block crops) {
        this.crops = crops;
        setRegistryName("rhizome");
        setUnlocalizedName(BBSMod.MODID + "." + "rhizome");
        GameRegistry.register(this);
        setCreativeTab(CreativeTabsBBS.BBSTabsSeeds);
        hopsType = "Unclassified Rhizome";
        alphaAcid = 0.0;
        priceRhi = 0.0;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return this.crops == Blocks.NETHER_WART ? EnumPlantType.Nether : EnumPlantType.Crop;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return this.crops.getDefaultState();
    }


    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);
        IBlockState state = worldIn.getBlockState(pos);
        if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up())) {
            worldIn.setBlockState(pos.up(), this.crops.getDefaultState());
            itemstack.shrink(1);
            return EnumActionResult.SUCCESS;
        } else {
            return EnumActionResult.FAIL;
        }
    }


    public String setHopsType(String ht) {
        return hopsType = ht;
    }

    public String getHopsType() {
        String ht = hopsType;
        return ht.toString();
    }

    public Double setAlphaAcid(Double aan) {
        return alphaAcid = aan;
    }

    public Double getAlphaAcid() {
        Double aan = alphaAcid;
        return aan;
    }

    public Double setPrice(Double pri) {
        return priceRhi = pri;
    }

    public Double getPrice() {
        Double pri = priceRhi;
        return pri;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }


    @Override
    public String getUnlocalizedName(ItemStack stack) {
        if (stack.hasTagCompound()) {
            NBTTagCompound itemData = stack.getTagCompound();
            if (itemData.hasKey("rhizomes")) {
                return "item." + BBSMod.MODID + "." + itemData.getString("rhizome");
            }
        }
        return "item.bbs_mod.rhizome_0";
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List itemList) {
        for (int i = 1; i < 6; i++) {
            ItemStack stack = new ItemStack(item);
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setString("rhizome", "rhizome_" + i);
            itemList.add(stack);
        }
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player,
                               List tooltip, boolean isAdvanced) {
        if (stack.hasTagCompound()
                && stack.getTagCompound().hasKey("rhizome")) {
            tooltip.add(I18n.translateToLocal("tooltip.bbs_mod." + stack.getTagCompound().getString("rhizome") + ".desc"));
            tooltip.add("Alpha Acid: " + stack.getTagCompound().getString("alphaAcid") + "%");
            tooltip.add("Price: $" + stack.getTagCompound().getString("priceRhi"));
            tooltip.add("Quality: " + stack.getTagCompound().getString("Quality") + "%");
        } else {
            tooltip.add(I18n.translateToLocal("tooltip.bbs_mod.rhizome_0.desc"));
            tooltip.add("Alpha Acid: 0%");
            tooltip.add("Price: $0");
            tooltip.add("Quality: 0%");
        }

    }
}
