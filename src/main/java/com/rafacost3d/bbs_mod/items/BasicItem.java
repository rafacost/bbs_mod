package com.rafacost3d.bbs_mod.items;

import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BasicItem extends Item {

    public BasicItem() {
        super();

        setRegistryName("basicitem");
        setUnlocalizedName(BBSMod.MODID + ".basicitem");
        setCreativeTab(CreativeTabsBBS.BBSTabsHops);
        GameRegistry.register(this);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (haveQuality(itemstack)) {
            playerIn.sendMessage(new TextComponentString("This hops are " + getTagCompoundSafe(itemstack).getString("Country") + ", with " + getTagCompoundSafe(itemstack).getInteger("Quality") + "% quality."));
        } else {
            playerIn.sendMessage(new TextComponentString("This hops are garbage..."));
        }
        return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }

    private NBTTagCompound getTagCompoundSafe(ItemStack stack) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }
        return tagCompound;
    }
    private boolean haveQuality(ItemStack stack) {
        return getTagCompoundSafe(stack).hasKey("Quality");
    }
}
