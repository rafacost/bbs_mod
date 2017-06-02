package com.rafacost3d.bbs_mod.init;


import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BBSRecipes {

    public static void init() {
        ItemStack rhizo1 = new ItemStack(BBSItems.rhizomesItem);
        rhizo1.setTagCompound(new NBTTagCompound());
        rhizo1.getTagCompound().setString("rhizome", "rhizome_1");
        rhizo1.getTagCompound().setString("alphaAcid", "4");
        rhizo1.getTagCompound().setString("priceRhi", "46.95");
        rhizo1.getTagCompound().setString("Quality", "85");
        GameRegistry.addShapelessRecipe(rhizo1, BBSItems.hopsLeafItemAA1);
    }
}
