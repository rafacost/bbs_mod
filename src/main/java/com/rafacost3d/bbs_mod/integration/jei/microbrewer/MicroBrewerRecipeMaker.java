package com.rafacost3d.bbs_mod.integration.jei.microbrewer;

import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import com.rafacost3d.bbs_mod.objects.blocks.machines.MicroBrewer.MicroBrewerRecipes;
import mezz.jei.api.IJeiHelpers;
import net.minecraft.item.ItemStack;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MicroBrewerRecipeMaker {
    public static List<MicroBrewerRecipe> getRecipes(IJeiHelpers helpers)
    {
        MicroBrewerRecipes instance = MicroBrewerRecipes.getInstance();
        Table<ItemStack, ItemStack, ItemStack> recipes = instance.getDualSmeltingList();
        List<MicroBrewerRecipe> jeiRecipes = Lists.newArrayList();

        for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : recipes.columnMap().entrySet())
        {
            for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
            {
                ItemStack input1 = entry.getKey();
                ItemStack input2 = ent.getKey();
                ItemStack output = ent.getValue();
                List<ItemStack> inputs = Lists.newArrayList(input1, input2);
                MicroBrewerRecipe recipe = new MicroBrewerRecipe(inputs, output);
                jeiRecipes.add(recipe);
            }
        }
        return jeiRecipes;
    }
}