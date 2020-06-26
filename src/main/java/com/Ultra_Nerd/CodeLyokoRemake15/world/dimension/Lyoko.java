package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoRemake15.world.biome.Bepis;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class Lyoko extends WorldProvider {
	
	
	
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		this.biomeProvider = new Bepis(this.world.getSeed());
	}
	
	@Override
	public DimensionType getDimensionType() {
		// TODO Auto-generated method stub
		return ModDimensions.LYOKO;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		// TODO Auto-generated method stub
		return new ChunkGeneratorLyoko(this.world,true, this.world.getSeed(), this.world.getSpawnPoint());
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
