package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.minecraft.block.Block;

public final class ElectroplatingRodParts extends Block {
    public ElectroplatingRodParts(final Settings settings) {
        super(settings);
    }
/*
    private static final VoxelShape RodPart = Stream.of(
            Block.box(6, 0, 6, 10, 16, 10),
            Block.box(7, 0, 5, 9, 16, 6),
            Block.box(7, 0, 10, 9, 16, 11),
            Block.box(5, 0, 7, 6, 16, 9),
            Block.box(10, 0, 7, 11, 16, 9)
    ).reduce((v1, v2) -> {
        return Shapes.join(v1, v2, BooleanOp.OR);
    }).get();



    @Override
    public @NotNull VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return RodPart;
    }

 */
}
