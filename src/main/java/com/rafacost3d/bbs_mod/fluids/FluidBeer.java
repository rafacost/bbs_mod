package com.rafacost3d.bbs_mod.fluids;

import com.rafacost3d.bbs_mod.BBSMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidBeer extends Fluid {
    protected String name;
    public static final FluidBeer instance = new FluidBeer("beer");

    public FluidBeer(String name){
        super(name, new ResourceLocation(BBSMod.MODID + ":" + "fluid/" + name + "_still"), new ResourceLocation(BBSMod.MODID + ":" + "fluid/" + name + "_flow"));
        setDensity(1060);
        setTemperature(277);
        setViscosity(1800);
    }
}