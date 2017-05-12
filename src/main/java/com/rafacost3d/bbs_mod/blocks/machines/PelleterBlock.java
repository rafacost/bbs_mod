package com.rafacost3d.bbs_mod.blocks.machines;


import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.blocks.BlockTileEntity;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import com.rafacost3d.bbs_mod.items.HopsWholeLeafItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

public class PelleterBlock extends BlockTileEntity<TileEntityPelleter> {

    public PelleterBlock() {
        super(Material.IRON, "pelleter");
        setCreativeTab(CreativeTabsBBS.BBSTabsMachines);
    }

    @Override
    public Class<TileEntityPelleter> getTileEntityClass() {
        return TileEntityPelleter.class;
    }

    @Nullable
    @Override
    public TileEntityPelleter createTileEntity(World world, IBlockState state) {
        return new TileEntityPelleter();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        ItemStack heldItem = player.getHeldItem(hand);
        Integer heldCount = heldItem.getCount();
        Integer retCount;
        if (heldCount * 2 <=64 ) {
            retCount = heldCount *2;
        } else {
            retCount = 64;
        }
        ItemStack retItem = new ItemStack(heldItem.getItem(), retCount);
        if (!world.isRemote) {
            TileEntityPelleter tile = getTileEntity(world, pos);
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);
            if (!player.isSneaking()) {

                if (heldItem.isEmpty()) {
                        player.setHeldItem(hand, itemHandler.extractItem(0, 1, false));
                } else {
                    if (heldItem.getItem() instanceof HopsWholeLeafItem) {
                        player.setHeldItem(hand, itemHandler.insertItem(0, retItem, false));
                    }
                }
                tile.markDirty();

            } else {
                ItemStack stack = itemHandler.getStackInSlot(0);
                if (!stack.isEmpty()) {
                    String localized = BBSMod.proxy.localize(stack.getUnlocalizedName() + ".name");
                    player.sendMessage(new TextComponentString(stack.getCount() + "x " + localized));
                } else {
                    player.sendMessage(new TextComponentString("Empty"));
                }
            }
        }
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityPelleter tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack = itemHandler.getStackInSlot(0);
        if (!stack.isEmpty()) {
            EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(item);
        }
        super.breakBlock(world, pos, state);
    }
}
