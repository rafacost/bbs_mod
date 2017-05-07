package com.rafacost3d.bbs_mod.items;

import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class HopsWholeLeafItem extends Item {

    public String hopsType;
    public Integer alphaAcid;

    public HopsWholeLeafItem(String hopstype, Integer alphaacid) {
        super();

        setRegistryName("hopsleaf_" + hopstype);
        setUnlocalizedName(BBSMod.MODID + ".hopsleaf_" + hopstype);
        setCreativeTab(CreativeTabsBBS.BBSTabsHops);
        setHopsType(hopstype);
        setAlphaAcid(alphaacid);
        GameRegistry.register(this);
    }

    public String setHopsType(String ht){
        return hopsType = ht;
    }

    public String getHopsType(){
        String ht = hopsType;
        return  ht.toString();
    }

    public Integer setAlphaAcid(Integer aan){
        return alphaAcid = aan;
    }

    public Integer getAlphaAcid(){
        Integer aan = alphaAcid;
        return  aan;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
