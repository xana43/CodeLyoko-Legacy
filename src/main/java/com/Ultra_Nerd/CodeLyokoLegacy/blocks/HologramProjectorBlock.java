package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class HologramProjectorBlock extends Block implements BlockEntityProvider {
    //public static @NotNull BooleanProperty VALID = BooleanProperty.create("valid");

    public HologramProjectorBlock(final Settings settings) {
        super(settings);
    }
/*
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

 */


    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return null;
    }
}
