package com.rafacost3d.bbs_mod.blocks;

import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.compat.top.TOPInfoProvider;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockTileEntity extends BasicBlock implements ITileEntityProvider, TOPInfoProvider {

    protected String name;

    public BlockTileEntity(Material material, String name) {
        super(material, name);
        GameRegistry.registerTileEntity(TileEntityCounter.class, BBSMod.MODID + "_counterblock");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCounter();
    }

    private TileEntityCounter getTE(World world, BlockPos pos) {
        return (TileEntityCounter) world.getTileEntity(pos);
    }


    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if (!world.isRemote) {
            TileEntityCounter tile = getTE(world, pos);
            if (side == EnumFacing.DOWN) {
                tile.decrementCount();
            } else if (side == EnumFacing.UP) {
                tile.incrementCount();
            }
            player.sendMessage(new TextComponentString("Quality: " + tile.getCount() + "%"));
        }
        return true;
    }

    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        TileEntity te = world.getTileEntity(data.getPos());
        if (te instanceof TileEntityCounter) {
            TileEntityCounter tileEntity = (TileEntityCounter) te;
            probeInfo.text(TextFormatting.GREEN + "Quality: ").progress(tileEntity.getCount() % 100, 100, probeInfo.defaultProgressStyle().suffix("%"));
        }
    }

}
