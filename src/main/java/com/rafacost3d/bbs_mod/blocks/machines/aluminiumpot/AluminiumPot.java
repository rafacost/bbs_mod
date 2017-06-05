package com.rafacost3d.bbs_mod.blocks.machines.aluminiumpot;


import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.blocks.BasicBlock;
import com.rafacost3d.bbs_mod.compat.top.TOPInfoProvider;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import com.rafacost3d.bbs_mod.init.BBSConstants;
import com.rafacost3d.bbs_mod.init.BBSGuiHandler;
import com.rafacost3d.bbs_mod.init.BBSItems;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.item.EntityItem;
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
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;


public class AluminiumPot extends BasicBlock implements ITileEntityProvider, TOPInfoProvider {

    private ResourceLocation nameBlock;
    public AluminiumPot(Material material, String name){
        super(Material.IRON, name);
        setCreativeTab(CreativeTabsBBS.BBSTabsMachines);
        setHarvestLevel("shovel", -1);
        setHardness(1F);
        GameRegistry.registerTileEntity(TileEntityAluminiumPot.class, BBSMod.MODID + "_aluminiumpot");
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
        return new TileEntityAluminiumPot();
    }

    private TileEntityAluminiumPot getTE(World world, BlockPos pos) {
        return (TileEntityAluminiumPot) world.getTileEntity(pos);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            // ...
            if (!player.isSneaking()) {
                TileEntityAluminiumPot tile = getTE(world, pos);
                ItemStack itemStack = player.getHeldItem(hand);
                if (itemStack.getItem() == BBSItems.sanitizer) {
                    itemStack.damageItem(1, player);
                    player.sendMessage(new TextComponentString("Cleaning Boiling Pot."));
                    tile.setClean(true);
                }
                if (itemStack.getItem() == BBSItems.stirringspoon) {
                    if(tile.getTimeBoil()<=105) {
                        tile.setTimeBoil(tile.getTimeBoil() + 15);
                        player.sendMessage(new TextComponentString("Boil Time: " + tile.getTimeBoil() + " min"));
                    } else {
                        tile.setTimeBoil(0);
                    }
                }
            } else {
                player.openGui(BBSMod.instance, BBSGuiHandler.ALUMINIUMPOT, world, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;

    }




    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        TileEntity te = world.getTileEntity(data.getPos());
        try {
            if (te instanceof TileEntityAluminiumPot) {
                TileEntityAluminiumPot tile = (TileEntityAluminiumPot) te;
                Double d = tile.getTemp();
                Integer i = d.intValue();
                probeInfo.horizontal().text(TextFormatting.GREEN + "Hops: " + tile.getHopsType());
                probeInfo.horizontal().text(TextFormatting.GREEN + "Clean: " + tile.getClean());
                probeInfo.horizontal().text(TextFormatting.GREEN + "Malt: " + tile.getMalt());
                probeInfo.horizontal().text(TextFormatting.GREEN + "Hops: " + tile.getHops());
                probeInfo.text(TextFormatting.GREEN + "Temperature: ").progress(i, BBSConstants.WATER_BOILING, probeInfo.defaultProgressStyle().suffix(BBSConstants.DEGREE));
                probeInfo.horizontal().text(TextFormatting.GREEN + "Boil Time: " + tile.getTimeBoil() + " min");
                probeInfo.horizontal().text(TextFormatting.GREEN + "Time Boiling: " + tile.getCount() + " min");
                probeInfo.horizontal().text(TextFormatting.GREEN + "Heat Rate: " + tile.getHeatRate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityAluminiumPot tile = getTE(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack = itemHandler.getStackInSlot(0);
        if (!stack.isEmpty()) {
            EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(item);
        }
        super.breakBlock(world, pos, state);
    }

}
