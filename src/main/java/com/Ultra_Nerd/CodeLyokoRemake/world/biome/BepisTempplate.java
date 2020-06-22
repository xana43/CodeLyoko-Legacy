package com.Ultra_Nerd.CodeLyokoRemake.world.biome;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModBiome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class BepisTempplate extends GenLayer
{
	private Biome[] allowedBiomes = {ModBiome.LYOKO_FS};

	public BepisTempplate(long seed) 
	{
		super(seed);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) 
	{
		int[] dest = IntCache.getIntCache(width * depth);
		for (int dz = 0; dz < depth; dz++) 
		{
			for (int dx = 0; dx < width; dx++) 
			{
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
			}
		}
		return dest;
	}
}