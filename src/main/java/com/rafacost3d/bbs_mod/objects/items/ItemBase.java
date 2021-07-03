package com.rafacost3d.bbs_mod.objects.items;


import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import com.rafacost3d.bbs_mod.init.ItemInit;
import com.rafacost3d.bbs_mod.util.IHasModel;
import com.rafacost3d.bbs_mod.util.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name){
        setUnlocalizedName(Reference.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTabsBBS.BBSTabsItems);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels(){
        BBSMod.proxy.registerItemRenderer(this, 0, "inventory");
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

        if(stack.getItem().getUnlocalizedName().startsWith("item.bbs_mod.lme_")) {
            String lme = stack.getItem().getUnlocalizedName();
            switch (lme){
                case "item.bbs_mod.lme_pilsen":
                    tooltip.add(TextFormatting.GREEN + "LoviBond: 2.0");
                    break;
                case "item.bbs_mod.lme_extralight":
                    tooltip.add(TextFormatting.GREEN + "LoviBond: 2.5");
                    break;
                case "item.bbs_mod.lme_wheat":
                    tooltip.add(TextFormatting.GREEN + "LoviBond: 3.0");
                    break;
                case "item.bbs_mod.lme_light":
                    tooltip.add(TextFormatting.GREEN + "LoviBond: 4.0");
                    break;
                case "item.bbs_mod.lme_munich":
                    tooltip.add(TextFormatting.GREEN + "LoviBond: 8.0");
                    break;
                case "item.bbs_mod.lme_amber":
                    tooltip.add(TextFormatting.GREEN + "LoviBond: 10.0");
                    break;
                case "item.bbs_mod.lme_dark":
                    tooltip.add(TextFormatting.GREEN + "LoviBond: 30.0");
                    break;
            }
        }

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
