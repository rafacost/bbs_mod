package com.rafacost3d.bbs_mod.blocks;


import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.compat.top.TOPInfoProvider;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BasicBlock extends Block implements TOPInfoProvider {


    protected String name;

    public BasicBlock(Material material, String name){
        super(material);
        this.name = name;
        setUnlocalizedName(BBSMod.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTabsBBS.BBSTabsMachines);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        ItemStack is = data.getPickBlock();
        Integer quali = getTagCompoundSafe(is).getInteger("Quality");
        probeInfo.horizontal().text("Country: Domestic");
        probeInfo.horizontal().text("Quality: ").progress(quali % 100, 100, probeInfo.defaultProgressStyle().suffix("%"));
    }

    private NBTTagCompound getTagCompoundSafe(ItemStack stack) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }
        return tagCompound;
    }

}
