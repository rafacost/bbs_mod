package com.rafacost3d.bbs_mod.objects.crops;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemModels extends Item {
    private static final HashMap<Item, ItemModelList> models = new HashMap<Item, ItemModelList>();

    public static void preInit() {
        defineItemModels();
        prepareModels();
    }

    public static void init() {
        registerModels();
    }

    private static void defineItemModels() {

        for (BlockBBSCrop crop : CropRegistry.getCrops().values()) {
            registerItemModels(getItem(crop), new ItemModelList("")
                    .add(0, crop.getStageId(0))
                    .add(1, crop.getStageId(1))
                    .add(2, crop.getStageId(2))
                    .add(3, crop.getStageId(3))
                    .add(4, crop.getStageId(4))
                    .add(5, crop.getStageId(5))
                    .add(6, crop.getStageId(6))
                    .add(7, crop.getStageId(7))
            );
        }
     }

    private static void registerItemModels(Item item, ItemModelList list) {
        models.put(item, list);

    }

    private static void prepareModels() {
        for (Map.Entry<Item, ItemModelList> entry : models.entrySet()) {
            Item item = entry.getKey();

            Collection<String> registrations = entry.getValue().getRegistrations().values();

            for (String registration : registrations) {
                if (item == null || registration == null) continue;

                ModelBakery.registerItemVariants(item, new ResourceLocation(registration));
            }
        }
    }

    private static void registerModels() {
        for (HashMap.Entry<Item, ItemModelList> entry : models.entrySet()) {
            Item item = entry.getKey();

            HashMap<Integer, String> registrations = entry.getValue().getRegistrations();

            for (Map.Entry<Integer, String> registration : registrations.entrySet()) {
                int meta = registration.getKey();
                String path = registration.getValue();

                ModelResourceLocation resource = new ModelResourceLocation(path, "inventory");

                Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, resource);
            }
        }
    }

    private static Item getItem(Block block) {
        return Item.getItemFromBlock(block);
    }
}