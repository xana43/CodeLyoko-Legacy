package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public final class HologramProjectorBlock extends BaseEntityBlock{
    public static @NotNull BooleanProperty VALID = BooleanProperty.create("valid");

    public HologramProjectorBlock() {
        super(Block.Properties.of(Material.METAL)
                .strength(6, 10)
                .sound(SoundType.METAL)

        );
        this.registerDefaultState(this.defaultBlockState().setValue(VALID, false));

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(BooleanProperty.create("valid")));
    }



    @Override
    public @NotNull BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(VALID, false);
    }



    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return null;//ModTileEntities.HOLOGRAM_TILE_ENTITY.get().create(pos, state);
    }




}
