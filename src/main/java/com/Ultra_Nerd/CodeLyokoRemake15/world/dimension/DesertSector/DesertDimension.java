package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DesertSector;

import com.Ultra_Nerd.CodeLyokoRemake15.world.generators.DesertGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;

import javax.annotation.Nullable;

public class DesertDimension extends Dimension {
    public DesertDimension(World world, DimensionType type) {
       super(world,type,0);
    }



    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return new DesertGenerator(world,new DesertProvider(),new DesertGenSettings());
    }

    @Nullable
    @Override
    public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
        return null;
    }

    @Nullable
    @Override
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
        return null;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        return 0;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        return new Vec3d(74.9056,0.3637,0.3630);
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }



    @Override
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }
}
