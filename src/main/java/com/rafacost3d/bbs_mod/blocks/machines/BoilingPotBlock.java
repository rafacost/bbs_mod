package com.rafacost3d.bbs_mod.blocks.machines;


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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BoilingPotBlock extends BlockTileEntity<TileEntityBoilingPot> implements TOPInfoProvider {
    //final String DEGREE  = "\u2109";

    private ResourceLocation nameBlock;
    public BoilingPotBlock(){
        super(Material.IRON, "boilingpot");
        setUnlocalizedName(BBSMod.MODID + ".boilingpot");
        setCreativeTab(CreativeTabsBBS.BBSTabsMachines);
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


    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        TileEntity te = world.getTileEntity(data.getPos());
        if (te instanceof TileEntityBoilingPot) {
            TileEntityBoilingPot tileEntity = (TileEntityBoilingPot) te;
            probeInfo.horizontal().text("Beer: American Pale Ale");
            probeInfo.text(TextFormatting.GREEN + "Seconds: ").progress(tileEntity.getCount() % 100, 100, probeInfo.defaultProgressStyle().suffix("%"));
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if (!world.isRemote) {
            TileEntityBoilingPot tile = getTileEntity(world, pos);
            player.sendMessage(new TextComponentString("Seconds Boiling: " + tile.getCount() + "s"));
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
