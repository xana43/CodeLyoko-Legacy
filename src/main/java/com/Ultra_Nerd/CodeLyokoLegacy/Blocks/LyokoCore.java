package com.Ultra_Nerd.CodeLyokoLegacy.Blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.LyokoCoreBE;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LyokoCore extends BlockWithEntity {


    public LyokoCore(final Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public boolean canMobSpawnInside(final BlockState state) {
        return false;
    }

    @Override
    public <T extends BlockEntity> @NotNull BlockEntityTicker<T> getTicker(final World world, final BlockState state, final BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if(blockEntity instanceof final LyokoCoreBE lyokoCoreBE) {
                lyokoCoreBE.tick();
            }
        };
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.LYOKO_CORE.instantiate(pos, state);
    }
}
