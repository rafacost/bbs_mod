package com.rafacost3d.bbs_mod.util;

import com.rafacost3d.bbs_mod.objects.crops.BBSHopsTypes;
import java.text.DecimalFormat;

import static com.rafacost3d.bbs_mod.init.BBSConstants.HOPS_WEIGHT;

public class BeerMath {

    public static double RoundTo2Decimals(double val) {
        DecimalFormat df2 = new DecimalFormat("###.##");
        return Double.valueOf(df2.format(val));
    }

    public static double RoundTo3Decimals(double val) {
        DecimalFormat df2 = new DecimalFormat("###.###");
        return Double.valueOf(df2.format(val));
    }
    public static Double SRM(Double love, Integer maltquant){
        Double srm;
        Double mcu;
        //Double boil = 5.0;
        Double batch = 5.0;
        Double lovibond=love;
        Double quant= maltquant * 3.3;
        mcu=lovibond * (quant/batch);
        srm=1.4922 * Math.pow(mcu, 0.6859);
        return srm;
    }
    public static Double OG(Double maltquant, Integer batch){
        Double points = 37 * maltquant;
        Double OG = ((points/batch) * 0.001)+1;
        return OG;
    }
    public static Double FG(Double OG){
        return ((OG-1) * (1-0.72))+1;
    }
    public static Double ABV(Double OG, Double FG){
        return (OG-FG) * (125 * 1.05);
    }

    public static Double IBU(Integer hopQuantgrams, Double batch, Double boil, Double OG, String hopName){
        Double e=2.718281828459045235;
        Integer time = 60;
        Double hopQuantg = hopQuantgrams * HOPS_WEIGHT;
        Double hopQuant = 0.0352739619*hopQuantg;
        Double BG = (batch/boil) * (OG-1);
        Double tfactor=0.0;
        Double bfactor=0.0;
        Double aa= BBSHopsTypes.getAlpha(hopName);
        tfactor = (1-Math.pow(e,(-0.04*time)))/4.15;
        bfactor = 1.65*Math.pow(0.000125,BG);
        Double util = bfactor * tfactor;
        /*
        if(inventory.getStackInSlot(0).getTagCompound().getString("hopType").equals("pellet")) {
            util = util * 1.1;
        }
        */
        Double IBU = util * (((aa/100) * hopQuant * 7490)/batch);
        return IBU;
    }


}
