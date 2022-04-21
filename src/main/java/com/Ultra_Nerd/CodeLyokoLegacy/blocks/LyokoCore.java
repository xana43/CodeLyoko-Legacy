package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class LyokoCore extends Block implements BlockEntityProvider {


    public LyokoCore(final Settings settings) {
        super(settings);
    }
/*
    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 200;
    }


    @Override
    public RenderShape getRenderShape(final BlockState pState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public @NotNull BlockEntity newBlockEntity(final BlockPos pPos, final BlockState pState) {
        return ModTileEntities.LYOKO_CORE.get().create(pPos, pState);
    }

 */


    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return null;
    }
}
