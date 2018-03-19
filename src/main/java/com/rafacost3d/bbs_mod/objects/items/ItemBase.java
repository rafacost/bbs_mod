package com.rafacost3d.bbs_mod.objects.items;


import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import com.rafacost3d.bbs_mod.init.ItemInit;
import com.rafacost3d.bbs_mod.util.IHasModel;
import com.rafacost3d.bbs_mod.util.Reference;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name){
        setUnlocalizedName(Reference.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTabsBBS.BBSTabsItems);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels(){
        BBSMod.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
