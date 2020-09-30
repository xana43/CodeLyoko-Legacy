package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.VolcanoSector;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.sky.volcano.CustomVolcanoSky;
import com.Ultra_Nerd.CodeLyokoRemake15.world.generators.VolcanoGenerator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraftforge.client.IRenderHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class VolcanoDimension extends Dimension {
    private static final CustomVolcanoSky customVolcanoSky = new CustomVolcanoSky();
    public VolcanoDimension(World world, DimensionType type) {
        super(world, type, 0.0f);
        this.setSkyRenderer(customVolcanoSky);
    }

    @Nonnull
    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return new VolcanoGenerator(world,new VolcanoProvider(),new VolcanoGenSettings());


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
        return new Vec3d(1, 0, 0);
    }

    @Override
    public void setCloudRenderer(@Nonnull IRenderHandler renderer) {
        super.setCloudRenderer(renderer);
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

    @Override
    public boolean canMineBlock(PlayerEntity player, BlockPos pos) {
        return false;
    }
}
