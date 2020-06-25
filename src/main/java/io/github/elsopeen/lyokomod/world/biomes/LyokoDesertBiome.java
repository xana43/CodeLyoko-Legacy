package io.github.elsopeen.lyokomod.world.biomes;

import io.github.elsopeen.lyokomod.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class LyokoDesertBiome extends Biome {
    public LyokoDesertBiome(Builder biomeBuilder) {
        super(biomeBuilder.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.DESERT_SAND.get().getDefaultState(),
                ModBlocks.DESERT_SAND.get().getDefaultState(),
                ModBlocks.DESERT_SAND.get().getDefaultState()))
                .category(Category.DESERT)
                .depth(0.0f)
                .precipitation(RainType.NONE)
                .scale(1.5f)
                .temperature(1.5f)
                .downfall(0.5f)
                .waterColor(0x0d186b)
                .waterFogColor(0x0d186b)
                .parent(null));
    }
}
