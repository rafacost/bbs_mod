package com.rafacost3d.bbs_mod.integration.jei.microbrewer;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

import java.util.List;

public class MicroBrewerRecipe implements IRecipeWrapper {
    private final List<ItemStack> inputs;
    private final ItemStack output;

    public MicroBrewerRecipe(List<ItemStack> inputs, ItemStack output){
        this.inputs = inputs;
        this.output = output;
    }

    @Override
    public void getIngredients(IIngredients ingredients){
        ingredients.setInputs(ItemStack.class, inputs);
        ingredients.setOutput(ItemStack.class, output);
    }
}
