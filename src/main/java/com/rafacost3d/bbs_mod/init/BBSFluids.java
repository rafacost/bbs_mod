package com.rafacost3d.bbs_mod.init;

import com.rafacost3d.bbs_mod.fluids.BlockBeer;
import com.rafacost3d.bbs_mod.fluids.BlockWort;
import com.rafacost3d.bbs_mod.fluids.FluidBeer;
import com.rafacost3d.bbs_mod.fluids.FluidWort;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BBSFluids {

    public static BlockWort blockWort;
    public static BlockBeer blockBeer;

    public static void preinit() {
        FluidRegistry.registerFluid(FluidWort.instance);
        FluidRegistry.registerFluid(FluidBeer.instance);

        FluidRegistry.addBucketForFluid(FluidWort.instance);
        FluidRegistry.addBucketForFluid(FluidBeer.instance);

        blockWort = new BlockWort(FluidWort.instance, Material.WATER);
        blockBeer = new BlockBeer(FluidBeer.instance, Material.WATER);

    }

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        blockWort.initModel();
        blockBeer.initModel();
    }
}
