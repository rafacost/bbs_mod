package com.rafacost3d.bbs_mod.objects.crops;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRenderRegister {
    public static void registerItemRenderer() {
        for (Item item : ItemRegistry.items.values()) {
            register(item);
        }
        for (Item item : ItemRegistry.itemlist) {
            register(item);
        }
    }

    private static void register(final Item item) {
        final String resName = item.getRegistryName().toString();

        final ModelResourceLocation res =
                new ModelResourceLocation(resName, "inventory");
        Minecraft.getMinecraft().getRenderItem().
                getItemModelMesher().register(item, 0, res);
    }
}
