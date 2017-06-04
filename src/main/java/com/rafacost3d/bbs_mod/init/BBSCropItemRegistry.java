package com.rafacost3d.bbs_mod.init;

import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashMap;

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
            BBSMod.logger.info("Rhizome: " + (name[1].equals("rhizome")) + " name: " + name[1]);
            item.setCreativeTab(CreativeTabsBBS.BBSTabsSeeds);
        } else {
           BBSMod.logger.info("Hops: " + (name[1].equals("rhizome")) + " name: " + name[1]);
            item.setCreativeTab(CreativeTabsBBS.BBSTabsHops);
        }
        item.setRegistryName(registryName);
        item.setUnlocalizedName(registryName);
        items.put(registryName, item);
        return GameRegistry.register(item);
    }
}
