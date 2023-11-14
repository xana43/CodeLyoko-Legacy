package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModFluids;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;

import java.util.concurrent.CompletableFuture;

public final class CustomFluidTags extends FabricTagProvider.FluidTagProvider {
    public CustomFluidTags(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(final RegistryWrapper.WrapperLookup arg) {
        final Fluid[] waterFluids = {
                ModFluids.STILL_DIGITAL_OCEAN,
                ModFluids.FLOWING_DIGITAL_OCEAN,
                ModFluids.FLOWING_LIQUID_HELIUM,
                ModFluids.STILL_LIQUID_HELIUM
        };
        final Fluid[] lavaFluids = {
                ModFluids.FLOWING_DIGITAL_LAVA,
                ModFluids.STILL_DIGITAL_LAVA,
                ModFluids.STILL_URANIUM,
                ModFluids.FLOWING_URANIUM
        };
        for (final Fluid fluid : waterFluids)
        {
            getOrCreateTagBuilder(ModTags.FluidTags.COMMON_VISUAL_WATER_TAG).add(fluid);
            getOrCreateTagBuilder(ModTags.FluidTags.COMMON_WATER_TAG).add(fluid);
            getOrCreateTagBuilder(FluidTags.WATER).add(fluid);
        }
        for(final Fluid fluid : lavaFluids)
        {
            getOrCreateTagBuilder(ModTags.FluidTags.COMMON_LAVA_TAG).add(fluid);
            getOrCreateTagBuilder(FluidTags.LAVA).add(fluid);
        }
    }
}
