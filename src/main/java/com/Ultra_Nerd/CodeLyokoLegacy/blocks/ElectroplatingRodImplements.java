package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public final class ElectroplatingRodImplements extends Block {

    private static final VoxelShape Rod = Stream.of(
            Block.box(10, 14, 6, 11, 15, 10),
            Block.box(6, 0, 6, 10, 14, 10),
            Block.box(6, 14, 6, 10, 15, 10),
            Block.box(7, 0, 5, 9, 14, 6),
            Block.box(6, 14, 5, 10, 15, 6),
            Block.box(7, 0, 10, 9, 14, 11),
            Block.box(6, 14, 10, 10, 15, 11),
            Block.box(5, 0, 7, 6, 14, 9),
            Block.box(5, 14, 6, 6, 15, 10),
            Block.box(10, 0, 7, 11, 14, 9)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public ElectroplatingRodImplements(@NotNull Properties properties) {
        super(properties);
    }



    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return Rod;
    }
}
