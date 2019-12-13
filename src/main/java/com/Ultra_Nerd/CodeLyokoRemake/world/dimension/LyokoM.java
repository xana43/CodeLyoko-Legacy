package com.Ultra_Nerd.CodeLyokoRemake.world.dimension;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModBiome;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoRemake.world.biome.Bepis;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class LyokoM extends WorldProvider {
	
	
	public LyokoM() {
		this.biomeProvider = new BiomeProviderSingle(ModBiome.LYOKO_M);
	}
	
	
	
	@Override
	public DimensionType getDimensionType() {
		// TODO Auto-generated method stub
		return ModDimensions.LYOKOMOUNTAIN;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		// TODO Auto-generated method stub
		return new ChunkGeneratorLyokoM();
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

	@Override
	protected void generateLightBrightnessTable() {
		// TODO Auto-generated method stub
		float f = 0.0F;

	    for (int i = 0; i <= 15; ++i)
	    {
	        float f1 = 1.0F - (float)i / 15.0F;
	        this.lightBrightnessTable[i] = 2f;
	    }
	}
}
