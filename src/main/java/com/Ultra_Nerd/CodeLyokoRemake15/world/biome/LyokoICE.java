package com.Ultra_Nerd.CodeLyokoRemake15.world.biome;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nonnull;

public class LyokoICE extends Biome {

	public LyokoICE(Builder biomeBuilder) {
		super(biomeBuilder);
	}


	@Override
	public boolean doesWaterFreeze(@Nonnull IWorldReader worldIn, @Nonnull BlockPos pos) {
		return false;
	}

	@Override
	public boolean doesWaterFreeze(@Nonnull IWorldReader worldIn, @Nonnull BlockPos water, boolean mustBeAtEdge) {
		return false;
	}

	@Override
	public boolean doesSnowGenerate(@Nonnull IWorldReader worldIn, @Nonnull BlockPos pos) {
		return false;
	}

	@Override
	public int getSkyColor() {
		return 0x000033;
	}

}
