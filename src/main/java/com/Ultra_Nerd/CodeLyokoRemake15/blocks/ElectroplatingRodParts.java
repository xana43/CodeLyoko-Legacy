package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class ElectroplatingRodParts extends Block {

    private static final VoxelShape RodPart = Stream.of(
            Block.makeCuboidShape(6, 0, 6, 10, 16, 10),
            Block.makeCuboidShape(7, 0, 5, 9, 16, 6),
            Block.makeCuboidShape(7, 0, 10, 9, 16, 11),
            Block.makeCuboidShape(5, 0, 7, 6, 16, 9),
            Block.makeCuboidShape(10, 0, 7, 11, 16, 9)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    public ElectroplatingRodParts(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return RodPart;
    }
}
