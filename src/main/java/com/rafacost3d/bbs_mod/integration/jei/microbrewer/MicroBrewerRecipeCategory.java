package com.rafacost3d.bbs_mod.integration.jei.microbrewer;

import com.rafacost3d.bbs_mod.integration.jei.RecipeCategories;
import com.rafacost3d.bbs_mod.util.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

public class MicroBrewerRecipeCategory extends AbstractMicroBrewerRecipeCategory<MicroBrewerRecipe> {
    private final IDrawable background;
    private final String name;

    public MicroBrewerRecipeCategory(IGuiHelper helper) {
        super(helper);
        background = helper.createDrawable(TEXTURES, 4, 12, 150, 60);
        name = "MicroBrewer";
    }

    @Override
    public String getUid() {
        return RecipeCategories.MICRO;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public String getModName() {
        return Reference.NAME;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }


    @Override
    public void drawExtras(Minecraft minecraft){
        animatedFlame.draw(minecraft,4,42);
        animatedArrow.draw(minecraft, 40, 23);
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, MicroBrewerRecipe microBrewerRecipe, IIngredients iIngredients) {
        IGuiItemStackGroup stacks = iRecipeLayout.getItemStacks();
        stacks.init(input1, true, 21, 3);
        stacks.init(input2, true, 21, 40);
        stacks.init(output, false, 76,23);
        stacks.set(iIngredients);
    }

}
