package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.DigitalSeaBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.LiquidHelium;
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
    public static final ResourceLocation FLOWING_DIGITAL_OCEAN_RL = new ResourceLocation(Base.MOD_ID,"block/digital_flowing");
	public static final ResourceLocation DIGITAL_OCEAN_RL = new ResourceLocation(Base.MOD_ID,"block/digital_still");
	//fluid declarations
    public static final RegistryObject<FlowingFluid> FLOWING_DIGITAL_OCEAN = LIQUIDS.register("flowing_digital_ocean", () -> new ForgeFlowingFluid.Flowing(ModFluids.DIGITAL_PROPERTIES));
    public static final RegistryObject<FlowingFluid> DIGITAL_OCEAN = LIQUIDS.register("digital_ocean",() -> new ForgeFlowingFluid.Source(ModFluids.DIGITAL_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_LIQUIDHELIUM = LIQUIDS.register("flowing_liquidhelium",() -> new ForgeFlowingFluid.Flowing(ModFluids.HELIUM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> STILL_LIQUIDHELIUM = LIQUIDS.register("still_liquidhelium",() -> new ForgeFlowingFluid.Source(ModFluids.HELIUM_PROPERTIES));
    //fluid properties
    public static final ForgeFlowingFluid.Properties DIGITAL_PROPERTIES = new ForgeFlowingFluid.Properties(() -> DIGITAL_OCEAN.get(), () -> FLOWING_DIGITAL_OCEAN.get(), 
    		FluidAttributes.builder(DIGITAL_OCEAN_RL, FLOWING_DIGITAL_OCEAN_RL).density(1)
    		.temperature(100).luminosity(10).overlay(DIGITAL_OCEAN_RL)).block(() -> ModFluids.DIO.get());
    public static final ForgeFlowingFluid.Properties HELIUM_PROPERTIES = new ForgeFlowingFluid.Properties(() -> STILL_LIQUIDHELIUM.get(),() -> FLOWING_LIQUIDHELIUM.get(),
            FluidAttributes.builder(FLOWING_DIGITAL_OCEAN_RL,FLOWING_DIGITAL_OCEAN_RL).density(1).temperature(1).luminosity(1)).block(() -> ModFluids.LIQUIDHELIUM.get());
    //fluid blocks
    public static final RegistryObject<FlowingFluidBlock> DIO = ModBlocks.BLOCKS.register("digital_ocean", () -> new DigitalSeaBlock(DIGITAL_OCEAN));
	public static final RegistryObject<FlowingFluidBlock> URANIUM = ModBlocks.BLOCKS.register("uranium_waste", () -> new DigitalSeaBlock(DIGITAL_OCEAN));
	public static final RegistryObject<FlowingFluidBlock> LIQUIDHELIUM = ModBlocks.BLOCKS.register("liquidhelium",() -> new LiquidHelium(FLOWING_LIQUIDHELIUM));
	
}
