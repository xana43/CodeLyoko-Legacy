package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Tower;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.LyokoVehicleEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public final class TowerEnter extends HorizontalFacingBlock {

    public TowerEnter(final Settings settings) {
        super(settings);

    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(FACING));
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        super.onEntityCollision(state, world, pos, entity, handler);
        if (!(entity instanceof PlayerEntity) && !(entity instanceof LyokoVehicleEntity)) {
            entity.damage((ServerWorld) world,entity.getWorld().getDamageSources().outOfWorld(),Float.MAX_VALUE);
        }
    }



    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public boolean canMobSpawnInside(final BlockState state) {
        return false;
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }
}