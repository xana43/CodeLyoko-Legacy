package com.Ultra_Nerd.CodeLyokoRemake.world.dimension;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModBiome;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModDimensions;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;

public class Ice extends WorldProvider {
	
	
	public Ice() {
		this.biomeProvider = new BiomeProviderSingle(ModBiome.LYOKO_ICE);
	}
	
	@Override
	public DimensionType getDimensionType() {
		// TODO Auto-generated method stub
		return ModDimensions.LYOKOICE;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		// TODO Auto-generated method stub
		return new ChunkGeneratorLyokoICE(world);
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
public boolean isSkyColored() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public Vec3d getSkyColor(Entity cameraEntity, float partialTicks) {
	// TODO Auto-generated method stub
	return new Vec3d(0, 0, 200);
}
public float calculateCelestialAngle(long par1, float par3)
{
    return 0.55f;
}


@Override
public void setSkyRenderer(IRenderHandler skyRenderer) {
	// TODO Auto-generated method stub
	super.setSkyRenderer(null);
	
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

@Override
public boolean canBlockFreeze(BlockPos pos, boolean byWater) {
	// TODO Auto-generated method stub
	return true;
}


}
