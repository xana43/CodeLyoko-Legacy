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

import java.util.stream.Stream;

public final class ElectroplatingRodParts extends Block {

    private static final VoxelShape RodPart = Stream.of(
            Block.box(6, 0, 6, 10, 16, 10),
            Block.box(7, 0, 5, 9, 16, 6),
            Block.box(7, 0, 10, 9, 16, 11),
            Block.box(5, 0, 7, 6, 16, 9),
            Block.box(10, 0, 7, 11, 16, 9)
    ).reduce((v1, v2) -> {
        return Shapes.join(v1, v2, BooleanOp.OR);
    }).get();

    public ElectroplatingRodParts(@NotNull Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return RodPart;
    }
}
