package io.github.elsopeen.lyokomod.world.biomes;

import io.github.elsopeen.lyokomod.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class LyokoBanquiseBiome extends Biome {
    public LyokoBanquiseBiome(Builder biomeBuilder) {
        super(biomeBuilder.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
                ModBlocks.BANQUISE_ICE.get().getDefaultState(),
                ModBlocks.BANQUISE_ICE.get().getDefaultState(),
                ModBlocks.BANQUISE_ICE.get().getDefaultState()))
                .category(Category.ICY)
                .depth(0.0f)
                .precipitation(RainType.NONE)
                .scale(1.5f)
                .temperature(0.5f)
                .downfall(0.5f)
                .waterColor(0x0d186b)
                .waterFogColor(0x0d186b)
                .parent(null));
    }
}
