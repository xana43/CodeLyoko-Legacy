package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBiome;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoRemake15.world.biome.Bepis;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;

public class Sector5 extends WorldProvider {
	
	
	public Sector5() {
		this.biomeProvider = new BiomeProviderSingle(ModBiome.SECTOR_5);
	}
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		this.biomeProvider = new Bepis(this.world.getSeed());
	}
	
	@Override
	public DimensionType getDimensionType() {
		// TODO Auto-generated method stub
		return ModDimensions.SECTOR5;
	}
	
	@Override
	public boolean isSkyColored() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void setSkyRenderer(IRenderHandler skyRenderer) {
		// TODO Auto-generated method stub
		super.setSkyRenderer(null);
		
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		// TODO Auto-generated method stub
		return new ChunkGeneratorLyoko5(this.world);
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
	public Vec3d getSkyColor(Entity cameraEntity, float partialTicks) {
		// TODO Auto-generated method stub
		return new Vec3d(0, 0, 200);
	}
	public float calculateCelestialAngle(long par1, float par3)
	{
	    return 0f;
	}

	@Override
	protected void generateLightBrightnessTable() {
		// TODO Auto-generated method stub
		//float f = 0.0F;

	    for (int i = 0; i <= 15; ++i)
	    {
	        float f1 = 1.0F - (float)i / 15.0F;
	        this.lightBrightnessTable[i] = 2f;
	    }
	}
}
