package com.Ultra_Nerd.CodeLyokoLegacy.Init.Common;

import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.DigitalLAVA;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.DigitalOcean;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.LiquidHeliumFluid;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.UraniumWasteFluid;
import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public record ModFluids() {


    public static final FluidPair DIGITAL_LAVA = registerFluidPair(
            "digital_lava",
            DigitalLAVA.Still::new,
            DigitalLAVA.Flowing::new
    );
    public static final FlowableFluid STILL_DIGITAL_LAVA = DIGITAL_LAVA.still();
    public static final FlowableFluid FLOWING_DIGITAL_LAVA = DIGITAL_LAVA.flowing();


    public static final FluidPair DIGITAL_OCEAN = registerFluidPair(
            "digital_ocean",
            DigitalOcean.Still::new,
            DigitalOcean.Flowing::new
    );
    public static final FlowableFluid STILL_DIGITAL_OCEAN = DIGITAL_OCEAN.still();
    public static final FlowableFluid FLOWING_DIGITAL_OCEAN = DIGITAL_OCEAN.flowing();

    public static final FluidPair LIQUID_HELIUM = registerFluidPair(
            "liquid_helium",
            LiquidHeliumFluid.Still::new,
            LiquidHeliumFluid.Flowing::new
    );
    public static final FlowableFluid STILL_LIQUID_HELIUM = LIQUID_HELIUM.still();
    public static final FlowableFluid FLOWING_LIQUID_HELIUM = LIQUID_HELIUM.flowing();

    public static final FluidPair URANIUM = registerFluidPair(
      "uranium",
            UraniumWasteFluid.Still::new,
            UraniumWasteFluid.Flowing::new
    );
    public static final FlowableFluid STILL_URANIUM = URANIUM.still();
    public static final  FlowableFluid FLOWING_URANIUM = URANIUM.flowing();
    public record FluidPair(FlowableFluid still,FlowableFluid flowing) {}

    private static FluidPair registerFluidPair(String baseName, Supplier<? extends FlowableFluid> stillSupplier, Supplier<? extends FlowableFluid> flowingSupplier) {
        return new FluidPair(
                register(baseName,stillSupplier.get()),
                register("flowing_" + baseName,flowingSupplier.get())
        );
    }
    public record BlockStateProvider() {

        public static void  generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            registerFluidStateModels(blockStateModelGenerator, ModBlocks.DIGITAL_OCEAN_BLOCK);
            registerFluidStateModels(blockStateModelGenerator, ModBlocks.DIGITAL_LAVA_BLOCK);
            registerFluidStateModels(blockStateModelGenerator, ModBlocks.LIQUID_HELIUM_BLOCK);
            registerFluidStateModels(blockStateModelGenerator, ModBlocks.URANIUM_WASTE_BLOCK);
        }
        private static void registerFluidStateModels(final BlockStateModelGenerator generator, final Block fluidBlock) {
            final Identifier modelId = ModelIds.getBlockModelId(fluidBlock);
            generator.blockStateCollector.accept(
                    VariantsBlockStateSupplier.create(fluidBlock).coordinate(
                            BlockStateVariantMap.create(Properties.LEVEL_15)
                                    .register(level -> BlockStateVariant.create().put(VariantSettings.MODEL, modelId))

                    )
            );
        }

    }
    private static <T extends Fluid> T register(final String name,final T value)
    {
        return Registry.register(Registries.FLUID, CodeLyokoMain.codeLyokoPrefix(name),value);
    }

    public static void registerModFluids(){}

}
