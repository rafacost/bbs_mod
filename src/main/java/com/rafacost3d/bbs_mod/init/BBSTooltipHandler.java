package com.rafacost3d.bbs_mod.init;


import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;

@SideOnly(Side.CLIENT)
public class BBSTooltipHandler {

    @SubscribeEvent
    public void handleItemTooltipEvent(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        HashMap<String, Double> plist = BBSGetMarketDataFireBase.getPriceList();

        try {
            String nameHop[] = stack.getUnlocalizedName().split("[.]");
            if (nameHop[2].equals("hop")) {
                event.getToolTip().add("Quant: " + String.format("%.2f",stack.getCount() * BBSConstants.HOPS_WEIGHT) + BBSConstants.UNIT_WEIGHT);
                event.getToolTip().add("Value B$: " + String.format("%.2f", plist.get("hop." + nameHop[1]) * stack.getCount()));
            } else if (nameHop[2].equals("pellet")) {
                event.getToolTip().add("Quant: " + String.format("%.2f",stack.getCount() * BBSConstants.PELLETS_WEIGHT) + BBSConstants.UNIT_WEIGHT);
                event.getToolTip().add("Value B$: " + String.format("%.2f", plist.get("pellet." + nameHop[1]) * stack.getCount()));
            }  else if (nameHop[2].equals("rhizome")) {
                event.getToolTip().add("Quant: " + String.format("%.2f",stack.getCount() * BBSConstants.PELLETS_WEIGHT) + BBSConstants.UNIT_WEIGHT);
                event.getToolTip().add("Value B$: " + String.format("%.2f",plist.get("rhizome." + nameHop[1]) * stack.getCount()));
            }

        } catch (Exception e) {
           // e.printStackTrace();
        }
    }
}
