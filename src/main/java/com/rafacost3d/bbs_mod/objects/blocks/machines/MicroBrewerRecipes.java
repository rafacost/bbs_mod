package com.rafacost3d.bbs_mod.objects.blocks.machines;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.rafacost3d.bbs_mod.init.ItemInit;
import com.rafacost3d.bbs_mod.objects.crops.CropRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class MicroBrewerRecipes {
    private static final MicroBrewerRecipes INSTANCE = new MicroBrewerRecipes();
    private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
    private final Map<ItemStack, Integer> cookTimeList = Maps.<ItemStack, Integer>newHashMap();

    public static MicroBrewerRecipes getInstance()
    {
        return INSTANCE;
    }

    private MicroBrewerRecipes()
    {
        addMicroBrewerRecipe(new ItemStack(Items.WHEAT), new ItemStack(Items.SUGAR), new ItemStack(ItemInit.LME_WHEAT), 5.0F, 240);
        addMicroBrewerRecipe(new ItemStack(ItemInit.WATER_KEG), new ItemStack(ItemInit.LME_WHEAT), new ItemStack(ItemInit.MASH_KEG), 5.0F, 720);
        addMicroBrewerRecipe(new ItemStack(ItemInit.MASH_KEG), new ItemStack(CropRegistry.getFood("liberty")), new ItemStack(ItemInit.HOTWORT_KEG), 5.0F, 1800);
        addMicroBrewerRecipe(new ItemStack(ItemInit.WORT_KEG), new ItemStack(ItemInit.YEAST), new ItemStack(ItemInit.BEER_KEG), 5.0F, 16000);

    }


    public void addMicroBrewerRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience, int cookTime)
    {
        if(getMicroBrewerResult(input1, input2) != ItemStack.EMPTY) return;
        this.smeltingList.put(input1, input2, result);
        this.experienceList.put(result, Float.valueOf(experience));
        this.cookTimeList.put(result, cookTime);

    }

    public ItemStack getMicroBrewerResult(ItemStack input1, ItemStack input2)
    {
        for(Map.Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet())
        {
            if(this.compareItemStacks(input1, (ItemStack)entry.getKey()))
            {
                for(Map.Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
                {
                    if(this.compareItemStacks(input2, (ItemStack)ent.getKey()))
                    {
                        return (ItemStack)ent.getValue();
                    }
                }
            }
        }
        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList()
    {
        return this.smeltingList;
    }

    public float getMicroBrewerExperience(ItemStack stack)
    {
        for (Map.Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if(this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }
        return 0.0F;
    }

    public int getMicroBrewerCookTime(ItemStack stack)
    {
        for (Map.Entry<ItemStack, Integer> entry : this.cookTimeList.entrySet())
        {
            if(this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Integer)entry.getValue()).intValue();
            }
        }
        return 0;
    }
}
