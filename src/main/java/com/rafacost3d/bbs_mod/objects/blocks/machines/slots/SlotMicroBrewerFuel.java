package com.rafacost3d.bbs_mod.objects.blocks.machines.slots;

import com.rafacost3d.bbs_mod.objects.blocks.machines.TileEntityMicroBrewer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMicroBrewerFuel extends Slot {
    public SlotMicroBrewerFuel(IInventory inventory, int index, int x, int y)
    {
        super(inventory, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return TileEntityMicroBrewer.isItemFuel(stack);
    }

    @Override
    public int getItemStackLimit(ItemStack stack)
    {
        return super.getItemStackLimit(stack);
    }
}
