package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.sky.ice.CustomIceSky;
import com.Ultra_Nerd.CodeLyokoRemake15.world.generators.IceGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class IceDimension extends Dimension {
    public IceDimension(World p_i225788_1_, DimensionType p_i225788_2_) {
        super(p_i225788_1_, p_i225788_2_, 0);
        this.setSkyRenderer(new CustomIceSky());
    }

    @Nonnull
    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return new IceGenerator(world, new IceProvider(), new IceGenSettings());
    }

    @Nullable
    @Override
    public BlockPos findSpawn(@Nonnull ChunkPos chunkPosIn, boolean checkValid) {
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

    @Nonnull
    @Override
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        return new Vec3d(0.15, 0.06, 1.864);
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
