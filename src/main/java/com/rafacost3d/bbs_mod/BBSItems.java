package com.rafacost3d.bbs_mod;

import com.rafacost3d.bbs_mod.items.BasicItem;
import com.rafacost3d.bbs_mod.items.HopSeedsItem;
import com.rafacost3d.bbs_mod.items.HopsWholeLeafItem;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BBSItems {

    public static BasicItem basicItem;
    public static HopsWholeLeafItem hopsLeafItemAA1;
    public static HopsWholeLeafItem hopsLeafItemAA2;
    public static HopSeedsItem hopSeedsItem;


    public static void init(){
        basicItem = new BasicItem();
        hopsLeafItemAA1 = new HopsWholeLeafItem("aa1", 3);
        hopsLeafItemAA2 = new HopsWholeLeafItem("aa2", 10);
        hopSeedsItem = new HopSeedsItem(BBSBlocks.hopcropBlock, Blocks.DIRT);
    }


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        basicItem.initModel();
        hopsLeafItemAA1.initModel();
        hopsLeafItemAA2.initModel();
        hopSeedsItem.initModel();
    }

}
