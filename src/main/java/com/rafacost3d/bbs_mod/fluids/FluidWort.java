package com.rafacost3d.bbs_mod.fluids;

import com.rafacost3d.bbs_mod.BBSMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidWort extends Fluid {

    protected String name;
    public static final FluidWort instance = new FluidWort("wort");

    public FluidWort(String name){
        super(name, new ResourceLocation(BBSMod.MODID + ":" + "fluid/" + name + "_still"), new ResourceLocation(BBSMod.MODID + ":" + "fluid/" + name + "_flow"));
        setDensity(10000);
        setTemperature(338);
        setViscosity(13000);
    }
}