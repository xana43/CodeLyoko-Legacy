package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DesertSector;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBiome;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import javax.annotation.Nonnull;
import java.util.Set;

public class DesertProvider extends BiomeProvider {

    private static final Set<Biome> List = ImmutableSet.of(ModBiome.DESERT.get());

    protected DesertProvider() {
        super(List);

    }

    @Nonnull
    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return ModBiome.DESERT.get();
    }
}
