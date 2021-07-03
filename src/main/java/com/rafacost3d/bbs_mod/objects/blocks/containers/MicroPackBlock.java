package com.rafacost3d.bbs_mod.objects.blocks.containers;

import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class MicroPackBlock extends Block {
    public MicroPackBlock(){
        super(Material.GLASS);
        setUnlocalizedName(Reference.MODID + ".micropack");
        setSoundType(SoundType.GLASS);
        setRegistryName("micropack");
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public void initModel(){
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    @Nullable
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new MicroPackTileEntity();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(worldIn.isRemote){
            return true;
        }
        TileEntity te = worldIn.getTileEntity(pos);
        if (!(te instanceof MicroPackTileEntity)) {
            return false;
        }
        playerIn.openGui(BBSMod.instance, Reference.GUI_MICROPACK, worldIn,pos.getX(), pos.getY(), pos.getZ());

        return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
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
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Keeps inventory when broken");
    }


    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity tee = worldIn.getTileEntity(pos);
        MicroPackTileEntity tileEntity = (MicroPackTileEntity)tee;
        ItemStack itemStack = new ItemStack(Item.getItemFromBlock(this));
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        nbtTagCompound.setTag("items", tileEntity.itemStackHandler.serializeNBT());
        itemStack.setTagCompound(nbtTagCompound);
        spawnAsEntity(worldIn,pos,itemStack);
        //BBSMod.logger.info(itemStack.getTagCompound().getTag("items"));
        super.breakBlock(worldIn,pos,state);
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        MicroPackTileEntity te = (MicroPackTileEntity) world.getTileEntity(pos);
        ItemStack itemStack = new ItemStack(Item.getItemFromBlock(this));
        NBTTagCompound tag = new NBTTagCompound();
        tag.setTag("items", te.itemStackHandler.serializeNBT());
        itemStack.setTagCompound(tag);
        return itemStack;
    }


    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player,
                                   boolean willHarvest) {
        if (willHarvest)
            return true;
        return super.removedByPlayer(state, world, pos, player, willHarvest);
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te,
                             ItemStack tool) {
        super.harvestBlock(world, player, pos, state, te, tool);
        world.setBlockToAir(pos);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        MicroPackTileEntity te = (MicroPackTileEntity)worldIn.getTileEntity(pos);
        if(!stack.hasTagCompound()){
            //NBTTagCompound tag = new NBTTagCompound();
            //tag.setTag("items", " ");
            //stack.setTagCompound(tag);
        } else {
            NBTTagCompound data = (NBTTagCompound) stack.getTagCompound().getTag("items");
            ItemStackHandler handler = new ItemStackHandler(9);
            handler.deserializeNBT(data);
            for (int i = 0; i < 9; i++) {
                te.itemStackHandler.setStackInSlot(i, handler.getStackInSlot(i));
            }
        }
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }
}
