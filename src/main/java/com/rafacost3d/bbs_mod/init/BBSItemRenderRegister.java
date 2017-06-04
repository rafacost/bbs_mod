package com.rafacost3d.bbs_mod.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class BBSItemRenderRegister {
    public static void registerItemRenderer() {
        for (Item item : BBSCropItemRegistry.items.values()) {
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
