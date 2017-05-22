package com.rafacost3d.bbs_mod.blocks.machines.boilingpot;


import com.rafacost3d.bbs_mod.blocks.BasicBlock;
import com.rafacost3d.bbs_mod.init.BBSConstants;
import com.rafacost3d.bbs_mod.init.BBSItems;
import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.compat.top.TOPInfoProvider;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import com.rafacost3d.bbs_mod.items.HopsWholeLeafItem;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

import java.text.DecimalFormat;


public class BoilingPotBlock extends BasicBlock implements ITileEntityProvider, TOPInfoProvider {
    final String DEGREE  = BBSConstants.DEGREE;

    private ResourceLocation nameBlock;
    public BoilingPotBlock(Material material, String name){
        super(Material.IRON, name);
        setCreativeTab(CreativeTabsBBS.BBSTabsMachines);
        setHarvestLevel("shovel", -1);
        setHardness(1F);
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
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityBoilingPot();
    }

    private TileEntityBoilingPot getTE(World world, BlockPos pos) {
        return (TileEntityBoilingPot) world.getTileEntity(pos);
    }


    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        TileEntity te = world.getTileEntity(data.getPos());
        if (te instanceof TileEntityBoilingPot) {
            TileEntityBoilingPot tile = (TileEntityBoilingPot) te;
            Double d = tile.getTemp();
            Integer i = d.intValue();
            Double dg = tile.getWaterGL();
            Integer ig = dg.intValue();
            probeInfo.horizontal().text(TextFormatting.GREEN + "Beer: " + tile.getBeerType());
            probeInfo.horizontal().text(TextFormatting.GREEN + "Clean: " + tile.getClean());
            probeInfo.horizontal().text(TextFormatting.GREEN + "Malt: " + tile.getMalt());
            probeInfo.horizontal().text(TextFormatting.GREEN + "Hops: " + tile.getHops());
            probeInfo.text(TextFormatting.GREEN + "Water: ").progress(ig , BBSConstants.BP_MAX_LIQUID.intValue(), probeInfo.defaultProgressStyle().suffix(BBSConstants.KUNIT_LIQUID));
            probeInfo.text(TextFormatting.GREEN + "Temperature: ").progress(i, BBSConstants.WATER_BOILING, probeInfo.defaultProgressStyle().suffix(DEGREE));
            probeInfo.horizontal().text(TextFormatting.GREEN + "Time Boiling: " + tile.getCount() + "s");
            probeInfo.horizontal().text(TextFormatting.GREEN + "Heat Rate: " + tile.getHeatRate());
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if (!world.isRemote && player.isSneaking()) {
            TileEntityBoilingPot tile = getTE(world, pos);
            player.sendMessage(new TextComponentString("Beer: " + tile.getBeerType()));
            player.sendMessage(new TextComponentString("Clean: " + tile.getClean()));
            player.sendMessage(new TextComponentString("Water: " + tile.getWater()));
            player.sendMessage(new TextComponentString("Malt: " + tile.getMalt()));
            player.sendMessage(new TextComponentString("Hops: " + tile.getHops()));
            DecimalFormat df = new DecimalFormat("0.00");
            Double dvalue = tile.getWaterGL();
            player.sendMessage(new TextComponentString("Water: " + df.format(dvalue) + BBSConstants.KUNIT_LIQUID));
            player.sendMessage(new TextComponentString("Temperature: " + tile.getTemp() + DEGREE));
            player.sendMessage(new TextComponentString("Time Boiling: " + tile.getCount() + "s"));
            player.sendMessage(new TextComponentString("Heat Rate: " + tile.getHeatRate()));

        } else if(!world.isRemote && !player.isSneaking()) {
            TileEntityBoilingPot tile = getTE(world, pos);
            ItemStack itemStack = player.getHeldItem(hand);
            if (itemStack.getItem() == BBSItems.sanitizer) {
                itemStack.damageItem(1, player);
                player.sendMessage(new TextComponentString("Cleaning Boiling Pot."));
                tile.setClean(true);
            }
            if (itemStack.getItem() == BBSItems.watergallon) {
                if (tile.getWaterGL() < 5) {
                    itemStack.damageItem(7, player);
                    player.sendMessage(new TextComponentString("Putting " + BBSConstants.BP_MIN_LIQUID  + BBSConstants.KUNIT_LIQUID + " of Water."));
                    tile.setWaterGL(tile.getWaterGL() + 1);
                    tile.setWater(true);
                    tile.setBeerType("Water");
                } else {
                    player.sendMessage(new TextComponentString("This Pot is full!"));
                }
            }
            if (itemStack.getItem() == BBSItems.lme) {
                itemStack.damageItem(64, player);
                player.sendMessage(new TextComponentString( BBSConstants.LME_WEIGHT + BBSConstants.KUNIT_WEIGHT + " Wheat LME added to the recipe"));
                tile.setMalt(true);
                tile.setMaltType("Wheat Malt");
                tile.setBeerType("Wort");
            }
            if (itemStack.getItem() instanceof HopsWholeLeafItem) {
                itemStack.setCount(itemStack.getCount()-1);
                player.sendMessage(new TextComponentString( "Hops added to the recipe"));
                tile.setHops(true);
                tile.setMaltType(itemStack.getDisplayName());
                tile.setBeerType("Wort with " + itemStack.getDisplayName());
            }
        }
        return true;
    }


    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (hasTileEntity(state) && !(this instanceof BoilingPotBlock))
        {
            worldIn.removeTileEntity(pos);
        }
    }

}