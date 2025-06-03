package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

/**
 * @author Ultra_Nerd
 * @desc <br/>
 * @since 2025-06-02
 */
public class BlockWithExtraProperties extends Block {
    final boolean fullCube;
    final boolean shapeFullCube;
    final boolean transparent;
    //normal constructor
    public BlockWithExtraProperties(final Settings settings) {
        this(settings,true,false);
    }
    public BlockWithExtraProperties(final Settings settings, final boolean fullCube) {
        this(settings,fullCube,false);
    }
    public BlockWithExtraProperties(final Settings settings, final boolean fullCube,final boolean transparent) {
        super(settings);
        this.fullCube = shapeFullCube = fullCube;
        this.transparent = transparent;
    }



    @Override
    protected VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return fullCube ? super.getCullingShape(state, world, pos):VoxelShapes.empty() ;
    }

    @Override
    protected boolean isCullingShapeFullCube(BlockState state, BlockView world, BlockPos pos) {
        return fullCube;
    }

    @Override
    protected boolean isShapeFullCube(BlockState state, BlockView world, BlockPos pos) {
        return shapeFullCube;
    }

    @Override
    protected boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return transparent;
    }
}
