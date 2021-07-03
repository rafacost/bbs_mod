package com.rafacost3d.bbs_mod.objects.blocks.machines.MicroBrewer;

import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import com.rafacost3d.bbs_mod.init.BlocksInit;
import com.rafacost3d.bbs_mod.util.Reference;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class MicroBrewerBlock extends BlockContainer implements ITileEntityProvider {

    public static final PropertyBool WORKING = PropertyBool.create("working");
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    private static boolean keepInventory;

    public MicroBrewerBlock() {
        super(Material.GRASS);
        setSoundType(SoundType.METAL);
        setUnlocalizedName(Reference.MODID + ".microbrewer");
        setRegistryName("microbrewer");
        setDefaultState(this.blockState.getBaseState().withProperty(WORKING, Boolean.FALSE).withProperty(FACING, EnumFacing.NORTH));
        setCreativeTab(CreativeTabsBBS.BBSTabsMachines);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(final IBlockState bs, final IBlockAccess world, final BlockPos coord, final EnumFacing face) {
        return false;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(BlocksInit.microBrewerBlock);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(BlocksInit.microBrewerBlock);
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[]{WORKING, FACING});
    }


    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        this.setDefaultFacing(worldIn, pos, state);
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            IBlockState north = worldIn.getBlockState(pos.north());
            IBlockState south = worldIn.getBlockState(pos.south());
            IBlockState west = worldIn.getBlockState(pos.west());
            IBlockState east = worldIn.getBlockState(pos.east());
            EnumFacing face = (EnumFacing)state.getValue(FACING);

            if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock())
                face = EnumFacing.SOUTH;
            else if (face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock())
                face = EnumFacing.NORTH;
            else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock())
                face = EnumFacing.EAST;
            else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock())
                face = EnumFacing.WEST;
            worldIn.setBlockState(pos, state.withProperty(FACING, face), 2);
        }
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        if(!keepInventory){
            TileEntity tileEntity = worldIn.getTileEntity(pos);

            if(tileEntity instanceof TileEntityMicroBrewer){
                InventoryHelper.dropInventoryItems(worldIn,pos,(TileEntityMicroBrewer)tileEntity);
            }
        }

        super.breakBlock(worldIn,pos,state);
    }

    public IBlockState getStateFromMeta(int meta) {
        /*
        return this.getDefaultState();
        */
        EnumFacing facing = EnumFacing.getFront(meta);
        if(facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
        return this.getDefaultState().withProperty(FACING, facing);
        }

    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }


    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(world.isRemote){
            return true;
        }
        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof TileEntityMicroBrewer)) {
            return false;
        }
                player.openGui(BBSMod.instance, Reference.GUI_MICROBREWER, world, pos.getX(), pos.getY(), pos.getZ());

        return true;

    }

    public static void setState(boolean active, World worldIn, BlockPos pos){
        IBlockState state = worldIn.getBlockState(pos);
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        keepInventory = true;

        if(active) worldIn.setBlockState(pos, BlocksInit.microBrewerBlock.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(WORKING, true), 3);
        else worldIn.setBlockState(pos, BlocksInit.microBrewerBlock.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(WORKING, false), 3);

        keepInventory=false;

        if(tileEntity != null)
        {
            tileEntity.validate();
            worldIn.setTileEntity(pos, tileEntity);
        }
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityMicroBrewer();
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }
}
