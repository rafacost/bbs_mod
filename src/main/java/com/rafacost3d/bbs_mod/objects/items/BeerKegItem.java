package com.rafacost3d.bbs_mod.objects.items;

import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import com.rafacost3d.bbs_mod.util.Reference;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class BeerKegItem extends Item {

    public BeerKegItem(){
        setRegistryName("beerkeg");
        setUnlocalizedName(Reference.MODID + ".beerkeg");
        setCreativeTab(CreativeTabsBBS.BBSTabsItems);
        setMaxDamage(64);
        setMaxStackSize(1);
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
        ModelResourceLocation lb10 = new ModelResourceLocation(getRegistryName() + "_lb10", "inventory");
        ModelResourceLocation lb15 = new ModelResourceLocation(getRegistryName() + "_lb15", "inventory");
        ModelResourceLocation lb20 = new ModelResourceLocation(getRegistryName() + "_lb20", "inventory");
        ModelResourceLocation lb25 = new ModelResourceLocation(getRegistryName() + "_lb25", "inventory");
        ModelResourceLocation lb30 = new ModelResourceLocation(getRegistryName() + "_lb30", "inventory");
        ModelResourceLocation lb35 = new ModelResourceLocation(getRegistryName() + "_lb35", "inventory");
        ModelResourceLocation lb40 = new ModelResourceLocation(getRegistryName() + "_lb40", "inventory");

        ModelBakery.registerItemVariants(this, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb10, lb15, lb20, lb25, lb30, lb35, lb40);
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
                    case 8:
                    case 9:
                    case 10:
                        return lb10;
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        return lb15;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                        return lb20;
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                        return lb25;
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                        return lb30;
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                        return lb35;
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                        return lb40;
                    default:
                        return lb40;
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
        if(getTagCompoundSafe(stack).hasKey("ibu")) {
            tooltip.add(TextFormatting.GREEN + "Malt: " + getTagCompoundSafe(stack).getString("malt"));
            tooltip.add(TextFormatting.GREEN + "SRM: " + getTagCompoundSafe(stack).getDouble("srm"));
            tooltip.add(TextFormatting.GREEN + "IBU: " + getTagCompoundSafe(stack).getDouble("ibu"));
            tooltip.add(TextFormatting.GREEN + "OG: " + getTagCompoundSafe(stack).getDouble("og"));
        }

        if(getTagCompoundSafe(stack).hasKey("abv")) {
            tooltip.add(TextFormatting.GREEN + "FG: " + getTagCompoundSafe(stack).getDouble("fg"));
            tooltip.add(TextFormatting.GREEN + "ABV: " + getTagCompoundSafe(stack).getDouble("abv") + "%");
        }

    }

}
