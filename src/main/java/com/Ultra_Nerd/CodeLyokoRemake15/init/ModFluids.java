package com.Ultra_Nerd.CodeLyokoRemake15.init;

import java.util.ArrayList;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Fluids.FluidLiquid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {

	
	public static final ArrayList<net.minecraft.fluid.Fluid> FLUIDS = new ArrayList<net.minecraft.fluid.Fluid>(); 
	public static final FluidLiquid DIGITAL_SEA = new FluidLiquid("digital_sea", new ResourceLocation(Base.MOD_ID + ":blocks/digital_still"), new ResourceLocation(Base.MOD_ID + ":blocks/digital_flowing"));
	public static final FluidLiquid COOLANT_FLUID = new FluidLiquid("coolant_fluid", new ResourceLocation(Base.MOD_ID + ":blocks/coolc"), new ResourceLocation(Base.MOD_ID + ":blocks/coolf"));
	public static void REGFLU()
	{
   for(net.minecraft.fluid.Fluid fluid : FLUIDS)
   {
	   REGAASSWSS(fluid);
   }
    
	}
	
	
	public static void REGAASSWSS(net.minecraft.fluid.Fluid fluid)
	{
		ForgeRegistries.FLUIDS.register(fluid);
		
	}
	
}
