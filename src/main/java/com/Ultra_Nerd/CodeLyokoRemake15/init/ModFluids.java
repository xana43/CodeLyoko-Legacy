package com.Ultra_Nerd.CodeLyokoRemake15.init;

import java.util.ArrayList;

import com.Ultra_Nerd.CodeLyokoRemake15.Fluids.FluidLiquid;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.ref;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {

	
	public static final ArrayList<Fluid> FLUIDS = new ArrayList<Fluid>(); 
	public static final Fluid DIGITAL_SEA = new FluidLiquid("digital_sea", new ResourceLocation(ref.MOD_ID + ":blocks/digital_still"), new ResourceLocation(ref.MOD_ID + ":blocks/digital_flowing"));
	public static final Fluid COOLANT_FLUID = new FluidLiquid("coolant_fluid", new ResourceLocation(ref.MOD_ID + ":blocks/coolc"), new ResourceLocation(ref.MOD_ID + ":blocks/coolf"));
	public static void REGFLU()
	{
   for(Fluid fluid : FLUIDS)
   {
	   REGAASSWSS(fluid);
   }
    
	}
	
	
	public static void REGAASSWSS(Fluid fluid)
	{
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
	
}
