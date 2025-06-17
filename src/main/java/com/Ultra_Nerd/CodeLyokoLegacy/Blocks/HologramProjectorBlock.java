package com.Ultra_Nerd.CodeLyokoLegacy.Blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HologramProjectorBlock extends BlockWithEntity {
    public static final @NotNull BooleanProperty VALID = BooleanProperty.of("valid");


    public HologramProjectorBlock(final Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(VALID, Boolean.TRUE));
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
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(VALID));
    }




    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.HOLOGRAM_PROJECTOR_TILE_ENTITY_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }
}
