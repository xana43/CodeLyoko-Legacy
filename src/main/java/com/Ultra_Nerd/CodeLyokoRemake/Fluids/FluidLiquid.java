package com.Ultra_Nerd.CodeLyokoRemake.Fluids;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModFluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidLiquid extends Fluid {

	
	public FluidLiquid(String fluidName, ResourceLocation still, ResourceLocation flowing) {
		super(fluidName, still, flowing);
		this.setUnlocalizedName(fluidName);
		ModFluids.FLUIDS.add(this);
	}
	
	

}
