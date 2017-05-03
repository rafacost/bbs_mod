package com.rafacost3d.bbs_mod;

import com.rafacost3d.bbs_mod.items.BasicItem;
import com.rafacost3d.bbs_mod.items.HopSeedsItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BBSItems {

    public static BasicItem basicItem;
    public static HopSeedsItem hopSeedsItem;

    public static void init(){
        basicItem = new BasicItem();
        hopSeedsItem = new HopSeedsItem();
    }


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        basicItem.initModel();
        hopSeedsItem.initModel();
    }

}
