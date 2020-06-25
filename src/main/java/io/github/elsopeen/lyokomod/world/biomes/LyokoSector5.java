package io.github.elsopeen.lyokomod.world.biomes;

import io.github.elsopeen.lyokomod.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class LyokoSector5 extends Biome {

	public LyokoSector5(Builder biomeBuilder) {
		super(biomeBuilder.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.MOUNTAIN_ROCK.get().getDefaultState(),
                ModBlocks.SECTOR_5.get().getDefaultState(),
                ModBlocks.SECTOR_5.get().getDefaultState()))
                .category(Category.EXTREME_HILLS)
                .depth(0.0f)
                .precipitation(RainType.NONE)
                .scale(1.5f)
                .temperature(1.f)
                .downfall(0.5f)
                .waterColor(72)
                .waterFogColor(72)
                .parent(null));
	}

	@Override
	public int getSkyColor() {
		// TODO Auto-generated method stub
		return 72;
	}
	
	
	
}
