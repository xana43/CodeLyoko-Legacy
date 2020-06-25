package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.DigitalSeaBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {

	
 //for fluids
	public static final DeferredRegister<Fluid> LIQUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, Base.MOD_ID);
    //fluid resource locations
    public static final ResourceLocation FLOWING_DIGITAL_OCEAN_RL = new ResourceLocation(Base.MOD_ID,"blocks/digital_flowing");
	public static final ResourceLocation DIGITAL_OCEAN_RL = new ResourceLocation(Base.MOD_ID,"blocks/digital_still");
	//fluid declarations
    public static final RegistryObject<FlowingFluid> FLOWING_DIGITAL_OCEAN = LIQUIDS.register("flowing_digital_ocean", () -> new ForgeFlowingFluid.Flowing(ModFluids.DIGITAL_PROPERTIES));
    public static final RegistryObject<FlowingFluid> DIGITAL_OCEAN = LIQUIDS.register("digital_ocean",() -> new ForgeFlowingFluid.Source(ModFluids.DIGITAL_PROPERTIES));
    //fluid properties
    public static final ForgeFlowingFluid.Properties DIGITAL_PROPERTIES = new ForgeFlowingFluid.Properties(() -> DIGITAL_OCEAN.get(), () -> FLOWING_DIGITAL_OCEAN.get(), 
    		FluidAttributes.builder(DIGITAL_OCEAN_RL, FLOWING_DIGITAL_OCEAN_RL)
    		.temperature(100).luminosity(10).overlay(DIGITAL_OCEAN_RL)).block(() -> ModFluids.DIO.get());
    //fluid blocks
    public static final RegistryObject<FlowingFluidBlock> DIO = ModBlocks.BLOCKS.register("digital_ocean", () -> new DigitalSeaBlock(() -> DIGITAL_OCEAN.get()));
	
	
	
}
