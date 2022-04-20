package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public final class LyokoCore extends BaseEntityBlock {
    public LyokoCore(@NotNull Properties properties) {
        super(properties);
    }




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



}
