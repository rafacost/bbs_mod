package com.rafacost3d.bbs_mod.objects.crops;

import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemRegistry {
    public static final List<Item> itemlist = new ArrayList<Item>();
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
        itemlist.add(item);
        return item;
    }
    @SubscribeEvent
    public void onItemRegistry(RegistryEvent.Register<Item> e) {
        IForgeRegistry<Item> reg = e.getRegistry();
        reg.registerAll(itemlist.toArray(new Item[0]));
        //GeneralOreRegistry.initOreRegistry();
    }
}
