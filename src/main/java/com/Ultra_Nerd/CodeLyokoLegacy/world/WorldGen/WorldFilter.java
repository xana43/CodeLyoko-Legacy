package com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

import java.util.Random;
import java.util.function.Predicate;

public class WorldFilter extends PlacementFilter {
    private final Predicate<ResourceKey<Level>> check;

    public WorldFilter(Predicate<ResourceKey<Level>> test) {
        this.check = test;
    }

    @Override
    protected boolean shouldPlace(final PlacementContext ctx, final Random rand, final BlockPos pos) {
        if (check.test(ctx.getLevel().getLevel().dimension())) {
            PlacedFeature placedFeature = ctx.topFeature().orElseThrow(() -> new IllegalStateException("feature not registered"));
            Holder<Biome> biomeRegistryObject = ctx.getLevel().getBiome(pos);
            return biomeRegistryObject.value().getGenerationSettings().hasFeature(placedFeature);
        } else {
            return false;
        }
    }

    @Override
    public PlacementModifierType<?> type() {
        return PlacementModifierType.BIOME_FILTER;
    }
}
