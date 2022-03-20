package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.sky.carthage.CustomCarthadgeSky;
import com.Ultra_Nerd.CodeLyokoRemake15.world.generators.Sector5Generator;
import net.minecraft.core.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Sector5Dimension extends Level {


    public static final BlockPos SPAWN = new BlockPos(0, 128, 0);

    public Sector5Dimension(World world, DimensionType type) {
        super(world, type, 0.0f);
        this.setSkyRenderer(new CustomCarthadgeSky());
    }

    @Nonnull
    @Override
    public Sector5Generator createChunkGenerator() {
        return new Sector5Generator(world, new Sector5Provider(), new Sector5GenSettings());
    }

    @Override
    public boolean isNight() {
        return false;
    }



    @Override
    public boolean isRaining() {
        return false;
    }

    @Override
    public @NotNull WorldBorder getWorldBorder() {
        return super.getWorldBorder();
    }

    @Override
    public void setSpawnSettings(BlockPos pos) {
        super.setSpawnPoint(SPAWN);
    }

    @Override
    public float getSunAngle(float p_46491_) {
        return 0;
    }



    @Override
    public BlockPos getSpawnCoordinate() {
        return SPAWN;
    }

    @Override
    @Nullable
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
        return this.findSpawn(new ChunkPos(posX >> 4, posZ >> 4), checkValid);
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
        return new Vec3d(0, 0, 1);
    }

    @Override
    public boolean canMineBlock(PlayerEntity player, BlockPos pos) {
        return false;
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public boolean canDoLightning(Chunk chunk) {
        return false;
    }

    @Override
    public boolean canDoRainSnowIce(Chunk chunk) {
        return false;
    }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

}
