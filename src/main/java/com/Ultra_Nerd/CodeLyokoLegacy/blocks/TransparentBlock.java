package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;

public class TransparentBlock extends Block {

    public TransparentBlock() {
        super(Block.Properties.copy(Blocks.BARRIER).randomTicks());

    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState pState) {
        return RenderShape.INVISIBLE;
    }

    @Override
    public boolean canBeReplaced(@NotNull BlockState p_60470_, @NotNull BlockPlaceContext p_60471_) {
        return false;
    }

    @Override
    public boolean canBeReplaced(@NotNull BlockState p_60535_, @NotNull Fluid p_60536_) {
        return false;
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player) {
        return false;
    }

    @Override
    public void fallOn(@NotNull Level p_152426_, @NotNull BlockState p_152427_, @NotNull BlockPos p_152428_, @NotNull Entity entity, float p_152430_) {
        super.fallOn(p_152426_, p_152427_, p_152428_, entity, p_152430_);
        entity.fallDistance = 0;

    }

    @Override
    public boolean canSurvive(final BlockState pState, final LevelReader pLevel, final BlockPos pPos) {
        return false;
    }


}