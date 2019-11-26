package com.Ultra_Nerd.CodeLyokoRemake.world.dimension;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModBiome;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModDimensions;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class Lyoko extends WorldProvider {
	
	
	public Lyoko() {
		this.biomeProvider = new BiomeProviderSingle(ModBiome.LYOKO_FS);
	}
	
	@Override
	public DimensionType getDimensionType() {
		// TODO Auto-generated method stub
		return ModDimensions.LYOKO;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		// TODO Auto-generated method stub
		return new ChunkGeneratorLyoko(world);
	}
	
	@Override
	public boolean canRespawnHere() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		// TODO Auto-generated method stub
		return false;
	}

}
