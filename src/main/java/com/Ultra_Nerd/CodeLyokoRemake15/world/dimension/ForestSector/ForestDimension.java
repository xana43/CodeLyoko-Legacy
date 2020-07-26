package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector;

import com.Ultra_Nerd.CodeLyokoRemake15.world.generators.ForestGenerator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraftforge.client.IRenderHandler;

import javax.annotation.Nullable;

public class ForestDimension extends Dimension  {




    public ForestDimension(World world, DimensionType type) {
        super(world,type,0.0f);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return new ForestGenerator(world,new ForestProvider(),new ForestGenSettings());
    }




    @Override
    public void setSkyRenderer(IRenderHandler skyRenderer) {
        super.setSkyRenderer(skyRenderer);
    }

    @Override
    public boolean isSkyColored() {
        return true;
    }

    @Override
    public boolean hasSkyLight() {
        return true;
    }


    @Override
    public boolean isDaytime() {
        return true;
    }

    @Override
    public boolean isNether() {
        return false;
    }


    @Override
    public boolean canDoRainSnowIce(Chunk chunk) {
        return false;
    }

    @Override
    public boolean canDoLightning(Chunk chunk) {
        return true;
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
        return 1000;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        return new Vec3d(0.9f,1,0.6F);
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
    public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
        return SleepResult.DENY;
    }

    @Override
    public boolean canMineBlock(PlayerEntity player, BlockPos pos) {
        return false;
    }




    @Override
    public void setAllowedSpawnTypes(boolean allowHostile, boolean allowPeaceful) {
        super.setAllowedSpawnTypes(true,false);
    }
}
