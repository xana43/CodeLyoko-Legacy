package com.Ultra_Nerd.CodeLyokoLegacy.Blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlockEntities;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class LyokoCore extends BlockWithEntity {


    public LyokoCore(final Settings settings) {
        super(settings);
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean canMobSpawnInside(final BlockState state) {
        return false;
    }


    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.LYOKO_CORE.instantiate(pos, state);
    }
}
