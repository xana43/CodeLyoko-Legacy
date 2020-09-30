package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBiome;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.Set;

public class ForestProvider extends BiomeProvider {

    private static final Set<Biome> List = ImmutableSet.of(ModBiome.FOREST.get());
    private final Random rand;

    protected ForestProvider() {
        super(List);
        rand = new Random();
    }

    @Nonnull
    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return ModBiome.FOREST.get();
    }
}
