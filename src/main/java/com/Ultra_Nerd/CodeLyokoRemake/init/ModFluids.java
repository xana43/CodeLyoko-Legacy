package com.Ultra_Nerd.CodeLyokoRemake.init;

import com.Ultra_Nerd.CodeLyokoRemake.Fluids.FluidLiquid;
import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {

	public static final Fluid DIGITAL_SEA = new FluidLiquid("digital_sea",new ResourceLocation(ref.MOD_ID + ":blocks/digital_still"), new ResourceLocation(ref.MOD_ID + ":blocks/digital_flowing"));
	
	public static void REGFLU()
	{
	REGAASSWSS(DIGITAL_SEA);	
	}
	
	
	public static void REGAASSWSS(Fluid fluid)
	{
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
	
}