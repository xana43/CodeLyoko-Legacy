package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tower;

import net.minecraft.block.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class TowerBaseCorner extends TowerWallCorner {


    @Override
    public void animateTick(@NotNull BlockState stateIn, @NotNull Level worldIn, @NotNull BlockPos pos, @NotNull Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
    }

    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }
}
