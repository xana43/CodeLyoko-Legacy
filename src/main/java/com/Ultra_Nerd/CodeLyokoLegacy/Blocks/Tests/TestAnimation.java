package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Tests;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

/**
 * @author Ultra_Nerd
 * @desc <br/>
 * @since 2025-05-12
 */
public final class TestAnimation extends HorizontalFacingBlock implements BlockEntityProvider {
    public TestAnimation() {
        super(AbstractBlock.Settings.copy(Blocks.BEDROCK));
    }
    @Override
    protected boolean isCullingShapeFullCube(final BlockState state, final BlockView world, final BlockPos pos) {
        return false;
    }
    @Override
    public @Nullable BlockState getPlacementState(final ItemPlacementContext ctx) {
        return getDefaultState().with(FACING,ctx.getHorizontalPlayerFacing());
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(FACING));
    }
    @Override
    protected VoxelShape getCullingShape(final BlockState state, final BlockView world, final BlockPos pos) {
        return VoxelShapes.empty();
    }
    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.TEST_ANIMATION_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }
}
