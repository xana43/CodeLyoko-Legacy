package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBiome;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.Random;
import java.util.Set;

public class ForestProvider extends BiomeProvider {
    private Random rand;
    protected ForestProvider() {
        super(List);
        rand = new Random();
    }
    private static final Set<Biome> List = ImmutableSet.of(ModBiome.FOREST.get());

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return ModBiome.FOREST.get();
    }
}
