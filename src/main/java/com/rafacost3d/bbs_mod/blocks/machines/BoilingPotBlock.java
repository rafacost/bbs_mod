package com.rafacost3d.bbs_mod.blocks.machines;


import com.rafacost3d.bbs_mod.BBSItems;
import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.blocks.BlockTileEntity;
import com.rafacost3d.bbs_mod.compat.top.TOPInfoProvider;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BoilingPotBlock extends BlockTileEntity<TileEntityBoilingPot> implements TOPInfoProvider {
    final String DEGREE  = "\u2109";

    private ResourceLocation nameBlock;
    public BoilingPotBlock(){
        super(Material.IRON, "boilingpot");
        setUnlocalizedName(BBSMod.MODID + ".boilingpot");
        setCreativeTab(CreativeTabsBBS.BBSTabsMachines);
        setHarvestLevel("shovel", -1);
        setHardness(1F);
        GameRegistry.register(this);
        if(getRegistryName()!=null) {
            nameBlock = getRegistryName();
        }
        GameRegistry.register(new ItemBlock(this), nameBlock);
        GameRegistry.registerTileEntity(TileEntityBoilingPot.class, BBSMod.MODID + "_boilingpot");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean isBlockNormalCube(IBlockState blockState) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }


    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        TileEntity te = world.getTileEntity(data.getPos());
        if (te instanceof TileEntityBoilingPot) {
            TileEntityBoilingPot tile = (TileEntityBoilingPot) te;
            Double d = tile.getTemp();
            Integer i = d.intValue();
            probeInfo.horizontal().text(TextFormatting.GREEN + "Beer: " + tile.getBeerType());
            probeInfo.horizontal().text(TextFormatting.GREEN + "Clean: " + tile.getClean());
            probeInfo.horizontal().text(TextFormatting.GREEN + "Water: " + tile.getWater());
            probeInfo.text(TextFormatting.GREEN + "Temperature: ").progress(i, 212, probeInfo.defaultProgressStyle().suffix(DEGREE));
            probeInfo.horizontal().text(TextFormatting.GREEN + "Time Boiling: " + tile.getCount() + "s");
            probeInfo.horizontal().text(TextFormatting.GREEN + "Heat Rate: " + tile.getHeatRate());
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if (!world.isRemote && player.isSneaking()) {
            TileEntityBoilingPot tile = getTileEntity(world, pos);
            player.sendMessage(new TextComponentString("Beer: " + tile.getBeerType()));
            player.sendMessage(new TextComponentString("Clean: " + tile.getClean()));
            player.sendMessage(new TextComponentString("Water: " + tile.getWater()));
            player.sendMessage(new TextComponentString("Temperature: " + tile.getTemp() + DEGREE));
            player.sendMessage(new TextComponentString("Time Boiling: " + tile.getCount() + "s"));
            player.sendMessage(new TextComponentString("Heat Rate: " + tile.getHeatRate()));

        } else if(!world.isRemote && !player.isSneaking()) {
            TileEntityBoilingPot tile = getTileEntity(world, pos);
            ItemStack itemStack = player.getHeldItem(hand);
            if (itemStack.getItem() == BBSItems.sanitizer) {
                player.sendMessage(new TextComponentString("Cleaning Boiling Pot."));
                tile.setClean(true);
            }
            if (itemStack.getItem() == BBSItems.watergallon) {
                player.sendMessage(new TextComponentString("Putting 1 Gallon of Water."));
                tile.setWater(true);
            }
        }
        return true;
    }

    @Override
    public Class<TileEntityBoilingPot> getTileEntityClass() {
        return TileEntityBoilingPot.class;
    }

    @Nullable
    @Override
    public TileEntityBoilingPot createTileEntity(World world, IBlockState state) {
        return new TileEntityBoilingPot();
    }



}
