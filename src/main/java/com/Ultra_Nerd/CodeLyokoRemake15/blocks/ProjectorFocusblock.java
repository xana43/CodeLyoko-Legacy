package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.BlockRenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.stream.Stream;

public class ProjectorFocusblock extends Block {
    public static BooleanProperty VALIDFOCUS = BooleanProperty.create("validfocus");

    private final VoxelShape focus = Stream.of(
            Block.box(1, 0, 4, 15, 16, 12),
            Block.box(2, 0, 2, 3, 16, 3),
            Block.box(2, 0, 3, 14, 16, 4),
            Block.box(3, 0, 1, 4, 16, 2),
            Block.box(12, 0, 1, 13, 16, 2),
            Block.box(13, 0, 2, 14, 16, 3),
            Block.box(14, 0, 3, 15, 16, 4),
            Block.box(15, 0, 4, 16, 16, 12),
            Block.box(2, 0, 12, 14, 16, 13),
            Block.box(3, 0, 14, 4, 16, 15),
            Block.box(12, 0, 14, 13, 16, 15),
            Block.box(2, 0, 13, 3, 16, 14),
            Block.box(13, 0, 13, 14, 16, 14),
            Block.box(1, 0, 12, 2, 16, 13),
            Block.box(14, 0, 12, 15, 16, 13),
            Block.box(4, 0, 15, 12, 16, 16),
            Block.box(4, 0, 14, 12, 16, 15),
            Block.box(3, 0, 13, 13, 16, 14),
            Block.box(4, 0, 0, 12, 16, 1),
            Block.box(3, 0, 2, 13, 16, 3),
            Block.box(4, 0, 1, 12, 16, 2),
            Block.box(1, 0, 3, 2, 16, 4),
            Block.box(0, 0, 4, 1, 16, 12)
    ).reduce((v1, v2) -> {
        return Shapes.join(v1, v2, BooleanOp.OR);
    }).get();

    public ProjectorFocusblock() {
        super(Properties.of(Material.GLASS)
                .strength(6, 10)
                .sound(SoundType.GLASS)
                .noOcclusion()
        );
        this.registerDefaultState(this.defaultBlockState().setValue(VALIDFOCUS, false));
    }


    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return focus;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@Nonnull BlockItemUseContext context) {
        return this.getDefaultState().with(VALIDFOCUS, false);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder.add(VALIDFOCUS));
    }




    @Nonnull
    @Override
    public BlockRenderType getRenderType(@Nonnull BlockState state) {
        if (this.getDefaultState().get(VALIDFOCUS)) {
            return BlockRenderType.INVISIBLE;
        } else {
            return BlockRenderType.MODEL;
        }
    }


}
