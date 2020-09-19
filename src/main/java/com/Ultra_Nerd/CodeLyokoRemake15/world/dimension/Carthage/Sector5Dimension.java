package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.sky.carthage.CustomCarthadgeSky;
import com.Ultra_Nerd.CodeLyokoRemake15.world.generators.Sector5Generator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.client.IRenderHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Sector5Dimension extends Dimension {

    private static CustomCarthadgeSky carthadgeSky = null;
    public static final BlockPos SPAWN = new BlockPos(0, 128, 0);

    public Sector5Dimension(World world, DimensionType type) {
        super(world, type, 0.0f);
        carthadgeSky = new CustomCarthadgeSky();
        this.setSkyRenderer(carthadgeSky);
    }

    @Nonnull
    @Override
    public Sector5Generator createChunkGenerator() {
        return new Sector5Generator(world, new Sector5Provider(), new Sector5GenSettings());
    }



    @Override
    @Nullable
    public BlockPos findSpawn(@Nonnull ChunkPos chunkPosIn, boolean checkValid) {
        /*Random random = new Random(this.world.getSeed());
        BlockPos blockpos = new BlockPos(chunkPosIn.getXStart() + random.nextInt(15), 0, chunkPosIn.getZEnd() + random.nextInt(15));
        return this.world.getGroundAboveSeaLevel(blockpos).getMaterial().blocksMovement() ? blockpos : null;*/
        return SPAWN;
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
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }


    @Nullable
    @Override
    public IRenderHandler getSkyRenderer() {
        return carthadgeSky;
    }
}
