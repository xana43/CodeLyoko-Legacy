package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBiome;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.Set;

public class Sector5Provider extends BiomeProvider {

    private static final Set<Biome> List = ImmutableSet.of(ModBiome.SECTOR5.get());
    private final Random rand;

    protected Sector5Provider() {
        super(List);
        rand = new Random();
    }

    @Nonnull
    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return ModBiome.SECTOR5.get();
    }
}
