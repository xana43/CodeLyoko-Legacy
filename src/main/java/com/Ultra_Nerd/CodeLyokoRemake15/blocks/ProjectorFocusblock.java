package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.stream.Stream;

public class ProjectorFocusblock extends ContainerBlock {
    public static BooleanProperty VALIDFOCUS = BooleanProperty.create("validfocus");

    private final VoxelShape focus = Stream.of(
            Block.makeCuboidShape(1, 0, 4, 15, 16, 12),
            Block.makeCuboidShape(2, 0, 2, 3, 16, 3),
            Block.makeCuboidShape(2, 0, 3, 14, 16, 4),
            Block.makeCuboidShape(3, 0, 1, 4, 16, 2),
            Block.makeCuboidShape(12, 0, 1, 13, 16, 2),
            Block.makeCuboidShape(13, 0, 2, 14, 16, 3),
            Block.makeCuboidShape(14, 0, 3, 15, 16, 4),
            Block.makeCuboidShape(15, 0, 4, 16, 16, 12),
            Block.makeCuboidShape(2, 0, 12, 14, 16, 13),
            Block.makeCuboidShape(3, 0, 14, 4, 16, 15),
            Block.makeCuboidShape(12, 0, 14, 13, 16, 15),
            Block.makeCuboidShape(2, 0, 13, 3, 16, 14),
            Block.makeCuboidShape(13, 0, 13, 14, 16, 14),
            Block.makeCuboidShape(1, 0, 12, 2, 16, 13),
            Block.makeCuboidShape(14, 0, 12, 15, 16, 13),
            Block.makeCuboidShape(4, 0, 15, 12, 16, 16),
            Block.makeCuboidShape(4, 0, 14, 12, 16, 15),
            Block.makeCuboidShape(3, 0, 13, 13, 16, 14),
            Block.makeCuboidShape(4, 0, 0, 12, 16, 1),
            Block.makeCuboidShape(3, 0, 2, 13, 16, 3),
            Block.makeCuboidShape(4, 0, 1, 12, 16, 2),
            Block.makeCuboidShape(1, 0, 3, 2, 16, 4),
            Block.makeCuboidShape(0, 0, 4, 1, 16, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public ProjectorFocusblock() {
        super(Properties.create(Material.GLASS)
                .hardnessAndResistance(6, 10)
                .sound(SoundType.GLASS)
                .lightValue(2)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .notSolid()
        );
        this.setDefaultState(this.getDefaultState().with(VALIDFOCUS, false));
    }


    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
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

    @Override
    public boolean hasTileEntity(BlockState state) {
        // TODO Auto-generated method stub
        return false;
    }



    @Nullable
    @Override
    public TileEntity createNewTileEntity(@Nonnull IBlockReader worldIn) {
        return null;
    }

}
