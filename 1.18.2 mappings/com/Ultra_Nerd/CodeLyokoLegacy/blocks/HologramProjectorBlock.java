package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HologramProjectorBlock extends BlockWithEntity {
    public static @NotNull BooleanProperty VALID = BooleanProperty.of("valid");



    public HologramProjectorBlock() {
        super(FabricBlockSettings.of(Material.METAL)
                .strength(6, 10)
                .sounds(BlockSoundGroup.METAL)

        );
        //this.registerDefaultState(this.defaultBlockState().setValue(VALID, false));
        this.setDefaultState(this.getDefaultState().with(VALID, true));
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(VALID));
    }

/*
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

 */


    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return null;
    }
}
