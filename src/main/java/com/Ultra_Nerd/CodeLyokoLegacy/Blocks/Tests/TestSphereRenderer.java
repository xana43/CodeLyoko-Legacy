package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Tests;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class TestSphereRenderer extends BlockWithEntity {
    public TestSphereRenderer(final Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.TEST_PROJECTOR_TILE_ENTITY_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }
}
