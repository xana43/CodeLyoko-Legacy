package com.Ultra_Nerd.CodeLyokoLegacy.Blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public final class ProjectorFocusblock extends Block {


    public static final @NotNull BooleanProperty VALIDFOCUS = BooleanProperty.of("validfocus");

    private static final VoxelShape focus = Stream.of(
            Block.createCuboidShape(1, 0, 4, 15, 16, 12),
            Block.createCuboidShape(2, 0, 2, 3, 16, 3),
            Block.createCuboidShape(2, 0, 3, 14, 16, 4),
            Block.createCuboidShape(3, 0, 1, 4, 16, 2),
            Block.createCuboidShape(12, 0, 1, 13, 16, 2),
            Block.createCuboidShape(13, 0, 2, 14, 16, 3),
            Block.createCuboidShape(14, 0, 3, 15, 16, 4),
            Block.createCuboidShape(15, 0, 4, 16, 16, 12),
            Block.createCuboidShape(2, 0, 12, 14, 16, 13),
            Block.createCuboidShape(3, 0, 14, 4, 16, 15),
            Block.createCuboidShape(12, 0, 14, 13, 16, 15),
            Block.createCuboidShape(2, 0, 13, 3, 16, 14),
            Block.createCuboidShape(13, 0, 13, 14, 16, 14),
            Block.createCuboidShape(1, 0, 12, 2, 16, 13),
            Block.createCuboidShape(14, 0, 12, 15, 16, 13),
            Block.createCuboidShape(4, 0, 15, 12, 16, 16),
            Block.createCuboidShape(4, 0, 14, 12, 16, 15),
            Block.createCuboidShape(3, 0, 13, 13, 16, 14),
            Block.createCuboidShape(4, 0, 0, 12, 16, 1),
            Block.createCuboidShape(3, 0, 2, 13, 16, 3),
            Block.createCuboidShape(4, 0, 1, 12, 16, 2),
            Block.createCuboidShape(1, 0, 3, 2, 16, 4),
            Block.createCuboidShape(0, 0, 4, 1, 16, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public ProjectorFocusblock() {
        super(FabricBlockSettings.copyOf(Blocks.GLASS)
                .strength(6, 10)
                .sounds(BlockSoundGroup.GLASS)
                .nonOpaque()
        );
        this.setDefaultState(this.getDefaultState().with(VALIDFOCUS, Boolean.FALSE));
    }

    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return focus;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(VALIDFOCUS, Boolean.FALSE);
    }


    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(VALIDFOCUS));
    }


}
