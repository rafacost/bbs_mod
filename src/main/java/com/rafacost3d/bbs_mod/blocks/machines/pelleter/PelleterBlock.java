package com.rafacost3d.bbs_mod.blocks.machines.pelleter;


import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.blocks.BasicBlock;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import com.rafacost3d.bbs_mod.init.BBSGuiHandler;
import com.rafacost3d.bbs_mod.init.BBSItems;
import com.rafacost3d.bbs_mod.items.HopsWholeLeafItem;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;


public class PelleterBlock extends BasicBlock implements ITileEntityProvider {

    protected String name;

    public PelleterBlock(Material material, String name) {
        super(Material.IRON, name);
        setCreativeTab(CreativeTabsBBS.BBSTabsMachines);
        GameRegistry.registerTileEntity(TileEntityPelleter.class, BBSMod.MODID + "_pelleter");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityPelleter();
    }

    private TileEntityPelleter getTE(World world, BlockPos pos) {
        return (TileEntityPelleter) world.getTileEntity(pos);
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
        ItemStack retItem = new ItemStack(BBSItems.hopsPelletsItemAA1, retCount);
        if (!world.isRemote && heldItem.getItem() instanceof HopsWholeLeafItem) {
            TileEntityPelleter tile = getTE(world, pos);
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);
            if (!player.isSneaking()) {

                if (heldItem.isEmpty()) {
                        player.setHeldItem(hand, itemHandler.extractItem(0, 1, false));
                } else {
                    player.openGui(BBSMod.instance, BBSGuiHandler.PELLETER, world, pos.getX(), pos.getY(), pos.getZ());
                }
                tile.markDirty();

            } else {
                ItemStack stack = itemHandler.getStackInSlot(0);
                if (!stack.isEmpty()) {
                    String localized = I18n.format(stack.getUnlocalizedName() + ".name");
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
        TileEntityPelleter tile = getTE(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack = itemHandler.getStackInSlot(0);
        if (!stack.isEmpty()) {
            EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(item);
        }
        super.breakBlock(world, pos, state);
    }
}