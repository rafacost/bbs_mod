package com.rafacost3d.bbs_mod.init;


import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.List;

public class BBSCropItemRegistry {
    public static final HashMap<String, Item> items = new HashMap<String, Item>();

    public static boolean initialized = false;

    public static void registerItems() {
        initialized = true;
    }

    private static Item registerGenericItem(String registryName) {
        final Item item = new Item();

        return registerItem(item, registryName);
    }

    public static Item registerItem(Item item, String registryName) {
        String name[] = registryName.split("[.]");
        if (name[1].equals("rhizome")) {
            item.setCreativeTab(CreativeTabsBBS.BBSTabsSeeds);
        } else if (name[1].equals("pellet")) {
            item.setCreativeTab(CreativeTabsBBS.BBSTabsPellets);
        } else {
            item.setCreativeTab(CreativeTabsBBS.BBSTabsHops);
        }
        item.setRegistryName(registryName);
        item.setUnlocalizedName(registryName);
        items.put(registryName, item);
        return GameRegistry.register(item);
    }
}
