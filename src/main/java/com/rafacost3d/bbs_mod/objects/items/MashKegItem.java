package com.rafacost3d.bbs_mod.objects.items;

import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import com.rafacost3d.bbs_mod.util.Reference;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class MashKegItem extends Item {

    public MashKegItem(){
        setRegistryName("mashkeg");
        setUnlocalizedName(Reference.MODID + ".mashkeg");
        setCreativeTab(CreativeTabsBBS.BBSTabsItems);
    }
    @SideOnly(Side.CLIENT)
    public void initModel(){
        ModelResourceLocation lb1 = new ModelResourceLocation(getRegistryName() + "_lb1", "inventory");
        ModelResourceLocation lb2 = new ModelResourceLocation(getRegistryName() + "_lb2", "inventory");
        ModelResourceLocation lb3 = new ModelResourceLocation(getRegistryName() + "_lb3", "inventory");
        ModelResourceLocation lb4 = new ModelResourceLocation(getRegistryName() + "_lb4", "inventory");
        ModelResourceLocation lb5 = new ModelResourceLocation(getRegistryName() + "_lb5", "inventory");
        ModelResourceLocation lb6 = new ModelResourceLocation(getRegistryName() + "_lb6", "inventory");
        ModelResourceLocation lb7 = new ModelResourceLocation(getRegistryName() + "_lb7", "inventory");

        ModelBakery.registerItemVariants(this, lb1, lb2, lb3, lb4, lb5, lb6, lb7);
        ModelLoader.setCustomMeshDefinition(this, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {

                Integer lb = getTagCompoundSafe(stack).getInteger("lb");
                switch (lb){
                    case 1:
                        return lb1;
                    case 2:
                        return lb2;
                    case 3:
                        return lb3;
                    case 4:
                        return lb4;
                    case 5:
                        return lb5;
                    case 6:
                        return lb6;
                    case 7:
                        return lb7;
                    default:
                        return lb1;
                }
            }
        });
    }
    private int getLove(ItemStack stack) {
        return getTagCompoundSafe(stack).getInteger("love");
    }

    private NBTTagCompound getTagCompoundSafe(ItemStack stack) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }
        return tagCompound;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.GREEN + "Malt: " + getTagCompoundSafe(stack).getString("malt"));
        tooltip.add(TextFormatting.GREEN + "SRM: " + getTagCompoundSafe(stack).getDouble("srm"));
        tooltip.add(TextFormatting.GREEN + "OG: " + getTagCompoundSafe(stack).getDouble("og"));
    }

}
