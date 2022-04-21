package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class TransparentBlock extends Block {

    public TransparentBlock() {
        super(FabricBlockSettings.copy(Blocks.BARRIER).ticksRandomly());

    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.INVISIBLE;
    }
/*
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
    }\

 */


}
