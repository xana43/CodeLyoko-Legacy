package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class ElectroplatingRodParts extends Block {

    private static final VoxelShape RodPart = Stream.of(
            Block.makeCuboidShape(6, 0, 6, 10, 16, 10),
            Block.makeCuboidShape(7, 0, 5, 9, 16, 6),
            Block.makeCuboidShape(7, 0, 10, 9, 16, 11),
            Block.makeCuboidShape(5, 0, 7, 6, 16, 9),
            Block.makeCuboidShape(10, 0, 7, 11, 16, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public ElectroplatingRodParts(Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        return RodPart;
    }
}
