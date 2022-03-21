package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.DigitalLavaBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.DigitalSeaBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.LiquidHelium;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.UraniumWaste;
import com.Ultra_Nerd.CodeLyokoRemake15.fluids.LiquidHeliumFluid;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {


    //for fluids
    public static final DeferredRegister<Fluid> LIQUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Base.MOD_ID);
    //fluid resource locations
    public static final ResourceLocation FLOWING_DIGITAL_OCEAN_RL = new ResourceLocation(Base.MOD_ID, "block/digital_flowing");
    public static final ResourceLocation DIGITAL_OCEAN_RL = new ResourceLocation(Base.MOD_ID, "block/digital_still");
    public static final ResourceLocation LIQUID_HELIUM_FLOWING_RL = new ResourceLocation(Base.MOD_ID, "block/liquid_helium_flow");
    public static final ResourceLocation LIQUID_HELIUM_STILL_RL = new ResourceLocation(Base.MOD_ID, "block/liquid_helium_still");
    public static final ResourceLocation URANIUM_STILL_RL = new ResourceLocation(Base.MOD_ID, "block/uranium_still");
    public static final ResourceLocation URANIUM_FLOW_RL = new ResourceLocation(Base.MOD_ID, "block/uranium_flow");
    public static final ResourceLocation DIGITAL_LAVA_STILL_RL = new ResourceLocation(Base.MOD_ID,"block/digital_still_lava");
    public static final ResourceLocation DIGITAL_LAVA_FLOWING_RL = new ResourceLocation(Base.MOD_ID,"block/digital_flowing_lava");
    //fluid declarations
    public static final RegistryObject<FlowingFluid> FLOWING_DIGITAL_OCEAN = LIQUIDS.register("flowing_digital_ocean", () -> new ForgeFlowingFluid.Flowing(ModFluids.DIGITAL_PROPERTIES));
    public static final RegistryObject<FlowingFluid> DIGITAL_OCEAN = LIQUIDS.register("digital_ocean", () -> new ForgeFlowingFluid.Source(ModFluids.DIGITAL_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_LIQUID_HELIUM = LIQUIDS.register("flowing_liquid_helium", () -> new LiquidHeliumFluid.Flowing(ModFluids.HELIUM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> STILL_LIQUID_HELIUM = LIQUIDS.register("still_liquid_helium", () -> new LiquidHeliumFluid.Source(ModFluids.HELIUM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> STILL_URANIUM = LIQUIDS.register("still_uranium", () -> new ForgeFlowingFluid.Source(ModFluids.URANIUM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_URANIUM = LIQUIDS.register("flowing_uranium", () -> new ForgeFlowingFluid.Flowing(ModFluids.URANIUM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> DIGITAL_LAVA_STILL = LIQUIDS.register("digital_lava_still",() -> new ForgeFlowingFluid.Source(ModFluids.DIGITAL_LAVA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> DIGITAL_LAVA_FLOWING = LIQUIDS.register("digital_lava_flowing",() -> new ForgeFlowingFluid.Flowing(ModFluids.DIGITAL_LAVA_PROPERTIES));
    //fluid properties
    public static final ForgeFlowingFluid.Properties DIGITAL_PROPERTIES = new ForgeFlowingFluid.Properties(DIGITAL_OCEAN, FLOWING_DIGITAL_OCEAN,
            FluidAttributes.builder(DIGITAL_OCEAN_RL, FLOWING_DIGITAL_OCEAN_RL).density(1)
                    .temperature(10).luminosity(10).overlay(DIGITAL_OCEAN_RL)).block(ModFluids.DIGITAL_SEA_BLOCK);
    public static final LiquidHeliumFluid.Properties HELIUM_PROPERTIES = new LiquidHeliumFluid.Properties(STILL_LIQUID_HELIUM, FLOWING_LIQUID_HELIUM,
            FluidAttributes.builder(LIQUID_HELIUM_STILL_RL, LIQUID_HELIUM_FLOWING_RL).overlay(LIQUID_HELIUM_STILL_RL).density(2).temperature(-1000).viscosity(0).luminosity(0)).block(ModFluids.LIQUID_HELIUM)
            .bucket(ModItems.LIQUID_HELIUM_BUCKET);
    public static final ForgeFlowingFluid.Properties URANIUM_PROPERTIES = new ForgeFlowingFluid.Properties(STILL_URANIUM, FLOWING_URANIUM,
            FluidAttributes.builder(URANIUM_STILL_RL, URANIUM_FLOW_RL).density(3).viscosity(0).temperature(921378).luminosity(40).overlay(URANIUM_STILL_RL)).block(ModFluids.URANIUM);
    public static final ForgeFlowingFluid.Properties DIGITAL_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(DIGITAL_LAVA_STILL,DIGITAL_LAVA_FLOWING,
            FluidAttributes.builder(DIGITAL_LAVA_STILL_RL,DIGITAL_LAVA_FLOWING_RL).density(10).viscosity(20).temperature(Integer.MAX_VALUE).luminosity(90).overlay(DIGITAL_LAVA_STILL_RL))
            .block(ModFluids.DIGITAL_LAVA_BLOCK);
    //fluid blocks
    public static final RegistryObject<LiquidBlock> DIGITAL_SEA_BLOCK = ModBlocks.BLOCKS.register("digital_ocean", () -> new DigitalSeaBlock(DIGITAL_OCEAN));
    public static final RegistryObject<LiquidBlock> URANIUM = ModBlocks.BLOCKS.register("uranium_waste", () -> new UraniumWaste(STILL_URANIUM));
    public static final RegistryObject<LiquidBlock> LIQUID_HELIUM = ModBlocks.BLOCKS.register("liquid_helium", () -> new LiquidHelium(STILL_LIQUID_HELIUM));
    public static final RegistryObject<LiquidBlock> DIGITAL_LAVA_BLOCK = ModBlocks.BLOCKS.register("digital_lava_block", () -> new DigitalLavaBlock(DIGITAL_LAVA_STILL));
}
