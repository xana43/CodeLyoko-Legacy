package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthadge;

import com.Ultra_Nerd.CodeLyokoRemake15.world.generators.Sector5Generator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;

import javax.annotation.Nullable;

public class Sector5Dimension extends Dimension {

    public Sector5Dimension(World world, DimensionType type) {
        super(world,type,0.0f);
    }

    @Override
    public Sector5Generator createChunkGenerator() {
        return new Sector5Generator(world,new Sector5Provider(),new Sector5GenSettings());
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
        return new Vec3d(0,0,1);
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
