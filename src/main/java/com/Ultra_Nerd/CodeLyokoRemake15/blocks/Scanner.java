package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Scanner extends HorizontalBlock {

    public static final DirectionProperty DIRSCANNER = HorizontalBlock.HORIZONTAL_FACING;
    private static VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(2, -16, -2, 14, -15, 18),
            Block.makeCuboidShape(-4, -16, 5, -3, 32, 11),
            Block.makeCuboidShape(-3, 31, 5, -2, 32, 11),
            Block.makeCuboidShape(-3, -16, 5, -2, -15, 11),
            Block.makeCuboidShape(19, -16, 5, 20, 32, 11),
            Block.makeCuboidShape(5, 31, -3, 11, 32, -2),
            Block.makeCuboidShape(5, -16, -3, 11, -15.5, -2),
            Block.makeCuboidShape(5, -16, 19, 11, 32, 20),
            Block.makeCuboidShape(5, 31, 18, 11, 32, 19),
            Block.makeCuboidShape(5, -16, 18, 11, -15, 19),
            Block.makeCuboidShape(-3, -16, 2, -2, 32, 5),
            Block.makeCuboidShape(18, -16, 11, 19, 32, 14),
            Block.makeCuboidShape(-3, -16, 11, -2, 32, 14),
            Block.makeCuboidShape(18, -16, 2, 19, 32, 5),
            Block.makeCuboidShape(11, -16, -3, 14, -15.5, -2),
            Block.makeCuboidShape(11, 31, -3, 14, 32, -2),
            Block.makeCuboidShape(2, -16, 18, 5, 32, 19),
            Block.makeCuboidShape(2, -16, -3, 5, -15.5, -2),
            Block.makeCuboidShape(2, 31, -3, 5, 32, -2),
            Block.makeCuboidShape(11, -16, 18, 14, 32, 19),
            Block.makeCuboidShape(-2, -16, 1, -1, 32, 2),
            Block.makeCuboidShape(-2, 31, 2, -1, 32, 14),
            Block.makeCuboidShape(-2, -16, 2, -1, -15, 14),
            Block.makeCuboidShape(-1, 31, 1, 0, 32, 15),
            Block.makeCuboidShape(-1, -16, 1, 0, -15, 15),
            Block.makeCuboidShape(0, 31, 0, 1, 32, 16),
            Block.makeCuboidShape(0, -16, 0, 1, -15, 16),
            Block.makeCuboidShape(1, 31, -1, 2, 32, 17),
            Block.makeCuboidShape(1, -16, -1, 2, -15, 17),
            Block.makeCuboidShape(14, 31, -1, 15, 32, 17),
            Block.makeCuboidShape(14, -16, -1, 15, -15, 17),
            Block.makeCuboidShape(15, 31, 0, 16, 32, 16),
            Block.makeCuboidShape(15, -16, 0, 16, -15, 16),
            Block.makeCuboidShape(16, 31, 1, 17, 32, 15),
            Block.makeCuboidShape(16, -16, 1, 17, -15, 15),
            Block.makeCuboidShape(17, 31, 2, 18, 32, 14),
            Block.makeCuboidShape(17, -16, 2, 18, -15, 14),
            Block.makeCuboidShape(18, 31, 5, 19, 32, 11),
            Block.makeCuboidShape(18, -16, 5, 19, -15, 11),
            Block.makeCuboidShape(17, -16, 14, 18, 32, 15),
            Block.makeCuboidShape(1, -16, 17, 2, 32, 18),
            Block.makeCuboidShape(14, -16, -2, 15, 32, -1),
            Block.makeCuboidShape(-1, -16, 0, 0, 32, 1),
            Block.makeCuboidShape(16, -16, 15, 17, 32, 16),
            Block.makeCuboidShape(0, -16, 16, 1, 32, 17),
            Block.makeCuboidShape(15, -16, -1, 16, 32, 0),
            Block.makeCuboidShape(0, -16, -1, 1, 32, 0),
            Block.makeCuboidShape(15, -16, 16, 16, 32, 17),
            Block.makeCuboidShape(-1, -16, 15, 0, 32, 16),
            Block.makeCuboidShape(16, -16, 0, 17, 32, 1),
            Block.makeCuboidShape(1, -16, -2, 2, 32, -1),
            Block.makeCuboidShape(14, -16, 17, 15, 32, 18),
            Block.makeCuboidShape(-2, -16, 14, -1, 32, 15),
            Block.makeCuboidShape(17, -16, 1, 18, 32, 2),
            Block.makeCuboidShape(2, 31, -2, 14, 32, 18)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(1.9999999999999991, -16, -2.345454545454545, 14, -15, 17.654545454545456),
            Block.makeCuboidShape(19, -16, 4.654545454545454, 20, 32, 10.654545454545456),
            Block.makeCuboidShape(18, 31, 4.654545454545454, 19, 32, 10.654545454545456),
            Block.makeCuboidShape(18, -16, 4.654545454545454, 19, -15, 10.654545454545456),
            Block.makeCuboidShape(-4, -16, 4.654545454545454, -3, 32, 10.654545454545456),
            Block.makeCuboidShape(4.999999999999999, 31, 17.654545454545456, 11, 32, 18.654545454545456),
            Block.makeCuboidShape(4.999999999999999, -16, 17.654545454545456, 11, -15.5, 18.654545454545456),
            Block.makeCuboidShape(4.999999999999999, -16, -4.345454545454545, 11, 32, -3.345454545454545),
            Block.makeCuboidShape(4.999999999999999, 31, -3.345454545454545, 11, 32, -2.345454545454545),
            Block.makeCuboidShape(4.999999999999999, -16, -3.345454545454545, 11, -15, -2.345454545454545),
            Block.makeCuboidShape(18, -16, 10.654545454545456, 19, 32, 13.654545454545456),
            Block.makeCuboidShape(-3, -16, 1.6545454545454543, -2, 32, 4.654545454545454),
            Block.makeCuboidShape(18, -16, 1.6545454545454543, 19, 32, 4.654545454545454),
            Block.makeCuboidShape(-3, -16, 10.654545454545456, -2, 32, 13.654545454545456),
            Block.makeCuboidShape(1.9999999999999991, -16, 17.654545454545456, 4.999999999999999, -15.5, 18.654545454545456),
            Block.makeCuboidShape(1.9999999999999991, 31, 17.654545454545456, 4.999999999999999, 32, 18.654545454545456),
            Block.makeCuboidShape(11, -16, -3.345454545454545, 14, 32, -2.345454545454545),
            Block.makeCuboidShape(11, -16, 17.654545454545456, 14, -15.5, 18.654545454545456),
            Block.makeCuboidShape(11, 31, 17.654545454545456, 14, 32, 18.654545454545456),
            Block.makeCuboidShape(1.9999999999999991, -16, -3.345454545454545, 4.999999999999999, 32, -2.345454545454545),
            Block.makeCuboidShape(17, -16, 13.654545454545456, 18, 32, 14.654545454545456),
            Block.makeCuboidShape(17, 31, 1.6545454545454543, 18, 32, 13.654545454545456),
            Block.makeCuboidShape(17, -16, 1.6545454545454543, 18, -15, 13.654545454545456),
            Block.makeCuboidShape(16, 31, 0.6545454545454543, 17, 32, 14.654545454545456),
            Block.makeCuboidShape(16, -16, 0.6545454545454543, 17, -15, 14.654545454545456),
            Block.makeCuboidShape(15, 31, -0.3454545454545448, 16, 32, 15.654545454545456),
            Block.makeCuboidShape(15, -16, -0.3454545454545448, 16, -15, 15.654545454545456),
            Block.makeCuboidShape(14, 31, -1.3454545454545448, 15, 32, 16.654545454545456),
            Block.makeCuboidShape(14, -16, -1.3454545454545448, 15, -15, 16.654545454545456),
            Block.makeCuboidShape(0.9999999999999991, 31, -1.3454545454545448, 1.9999999999999991, 32, 16.654545454545456),
            Block.makeCuboidShape(0.9999999999999991, -16, -1.3454545454545448, 1.9999999999999991, -15, 16.654545454545456),
            Block.makeCuboidShape(0, 31, -0.3454545454545448, 0.9999999999999991, 32, 15.654545454545456),
            Block.makeCuboidShape(0, -16, -0.3454545454545448, 0.9999999999999991, -15, 15.654545454545456),
            Block.makeCuboidShape(-1, 31, 0.6545454545454543, 0, 32, 14.654545454545456),
            Block.makeCuboidShape(-1, -16, 0.6545454545454543, 0, -15, 14.654545454545456),
            Block.makeCuboidShape(-2, 31, 1.6545454545454543, -1, 32, 13.654545454545456),
            Block.makeCuboidShape(-2, -16, 1.6545454545454543, -1, -15, 13.654545454545456),
            Block.makeCuboidShape(-3, 31, 4.654545454545454, -2, 32, 10.654545454545456),
            Block.makeCuboidShape(-3, -16, 4.654545454545454, -2, -15, 10.654545454545456),
            Block.makeCuboidShape(-2, -16, 0.6545454545454543, -1, 32, 1.6545454545454543),
            Block.makeCuboidShape(14, -16, -2.345454545454545, 15, 32, -1.3454545454545448),
            Block.makeCuboidShape(0.9999999999999991, -16, 16.654545454545456, 1.9999999999999991, 32, 17.654545454545456),
            Block.makeCuboidShape(16, -16, 14.654545454545456, 17, 32, 15.654545454545456),
            Block.makeCuboidShape(-1, -16, -0.3454545454545448, 0, 32, 0.6545454545454543),
            Block.makeCuboidShape(15, -16, -1.3454545454545448, 16, 32, -0.3454545454545448),
            Block.makeCuboidShape(0, -16, 15.654545454545456, 0.9999999999999991, 32, 16.654545454545456),
            Block.makeCuboidShape(15, -16, 15.654545454545456, 16, 32, 16.654545454545456),
            Block.makeCuboidShape(0, -16, -1.3454545454545448, 0.9999999999999991, 32, -0.3454545454545448),
            Block.makeCuboidShape(16, -16, -0.3454545454545448, 17, 32, 0.6545454545454543),
            Block.makeCuboidShape(-1, -16, 14.654545454545456, 0, 32, 15.654545454545456),
            Block.makeCuboidShape(14, -16, 16.654545454545456, 15, 32, 17.654545454545456),
            Block.makeCuboidShape(0.9999999999999991, -16, -2.345454545454545, 1.9999999999999991, 32, -1.3454545454545448),
            Block.makeCuboidShape(17, -16, 0.6545454545454543, 18, 32, 1.6545454545454543),
            Block.makeCuboidShape(-2, -16, 13.654545454545456, -1, 32, 14.654545454545456),
            Block.makeCuboidShape(1.9999999999999991, 31, -2.345454545454545, 14, 32, 17.654545454545456)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(-2.172727272727272, -16, 1.8272727272727272, 17.827272727272728, -15, 13.827272727272728),
            Block.makeCuboidShape(4.827272727272727, -16, -4.172727272727273, 10.827272727272728, 32, -3.172727272727273),
            Block.makeCuboidShape(4.827272727272727, 31, -3.172727272727273, 10.827272727272728, 32, -2.172727272727273),
            Block.makeCuboidShape(4.827272727272727, -16, -3.172727272727273, 10.827272727272728, -15, -2.172727272727273),
            Block.makeCuboidShape(4.827272727272727, -16, 18.827272727272728, 10.827272727272728, 32, 19.827272727272728),
            Block.makeCuboidShape(17.827272727272728, 31, 4.827272727272727, 18.827272727272728, 32, 10.827272727272728),
            Block.makeCuboidShape(17.827272727272728, -16, 4.827272727272727, 18.827272727272728, -15.5, 10.827272727272728),
            Block.makeCuboidShape(-4.172727272727272, -16, 4.827272727272727, -3.172727272727272, 32, 10.827272727272728),
            Block.makeCuboidShape(-3.172727272727272, 31, 4.827272727272727, -2.172727272727272, 32, 10.827272727272728),
            Block.makeCuboidShape(-3.172727272727272, -16, 4.827272727272727, -2.172727272727272, -15, 10.827272727272728),
            Block.makeCuboidShape(10.827272727272728, -16, -3.172727272727273, 13.827272727272728, 32, -2.172727272727273),
            Block.makeCuboidShape(1.8272727272727272, -16, 17.827272727272728, 4.827272727272727, 32, 18.827272727272728),
            Block.makeCuboidShape(1.8272727272727272, -16, -3.172727272727273, 4.827272727272727, 32, -2.172727272727273),
            Block.makeCuboidShape(10.827272727272728, -16, 17.827272727272728, 13.827272727272728, 32, 18.827272727272728),
            Block.makeCuboidShape(17.827272727272728, -16, 10.827272727272728, 18.827272727272728, -15.5, 13.827272727272728),
            Block.makeCuboidShape(17.827272727272728, 31, 10.827272727272728, 18.827272727272728, 32, 13.827272727272728),
            Block.makeCuboidShape(-3.172727272727272, -16, 1.8272727272727272, -2.172727272727272, 32, 4.827272727272727),
            Block.makeCuboidShape(17.827272727272728, -16, 1.8272727272727272, 18.827272727272728, -15.5, 4.827272727272727),
            Block.makeCuboidShape(17.827272727272728, 31, 1.8272727272727272, 18.827272727272728, 32, 4.827272727272727),
            Block.makeCuboidShape(-3.172727272727272, -16, 10.827272727272728, -2.172727272727272, 32, 13.827272727272728),
            Block.makeCuboidShape(13.827272727272728, -16, -2.172727272727273, 14.827272727272728, 32, -1.1727272727272728),
            Block.makeCuboidShape(1.8272727272727272, 31, -2.172727272727273, 13.827272727272728, 32, -1.1727272727272728),
            Block.makeCuboidShape(1.8272727272727272, -16, -2.172727272727273, 13.827272727272728, -15, -1.1727272727272728),
            Block.makeCuboidShape(0.8272727272727272, 31, -1.1727272727272728, 14.827272727272728, 32, -0.17272727272727284),
            Block.makeCuboidShape(0.8272727272727272, -16, -1.1727272727272728, 14.827272727272728, -15, -0.17272727272727284),
            Block.makeCuboidShape(-0.17272727272727195, 31, -0.17272727272727284, 15.827272727272728, 32, 0.8272727272727272),
            Block.makeCuboidShape(-0.17272727272727195, -16, -0.17272727272727284, 15.827272727272728, -15, 0.8272727272727272),
            Block.makeCuboidShape(-1.172727272727272, 31, 0.8272727272727272, 16.827272727272728, 32, 1.8272727272727272),
            Block.makeCuboidShape(-1.172727272727272, -16, 0.8272727272727272, 16.827272727272728, -15, 1.8272727272727272),
            Block.makeCuboidShape(-1.172727272727272, 31, 13.827272727272728, 16.827272727272728, 32, 14.827272727272728),
            Block.makeCuboidShape(-1.172727272727272, -16, 13.827272727272728, 16.827272727272728, -15, 14.827272727272728),
            Block.makeCuboidShape(-0.17272727272727195, 31, 14.827272727272728, 15.827272727272728, 32, 15.827272727272728),
            Block.makeCuboidShape(-0.17272727272727195, -16, 14.827272727272728, 15.827272727272728, -15, 15.827272727272728),
            Block.makeCuboidShape(0.8272727272727272, 31, 15.827272727272728, 14.827272727272728, 32, 16.827272727272728),
            Block.makeCuboidShape(0.8272727272727272, -16, 15.827272727272728, 14.827272727272728, -15, 16.827272727272728),
            Block.makeCuboidShape(1.8272727272727272, 31, 16.827272727272728, 13.827272727272728, 32, 17.827272727272728),
            Block.makeCuboidShape(1.8272727272727272, -16, 16.827272727272728, 13.827272727272728, -15, 17.827272727272728),
            Block.makeCuboidShape(4.827272727272727, 31, 17.827272727272728, 10.827272727272728, 32, 18.827272727272728),
            Block.makeCuboidShape(4.827272727272727, -16, 17.827272727272728, 10.827272727272728, -15, 18.827272727272728),
            Block.makeCuboidShape(0.8272727272727272, -16, 16.827272727272728, 1.8272727272727272, 32, 17.827272727272728),
            Block.makeCuboidShape(-2.172727272727272, -16, 0.8272727272727272, -1.172727272727272, 32, 1.8272727272727272),
            Block.makeCuboidShape(16.827272727272728, -16, 13.827272727272728, 17.827272727272728, 32, 14.827272727272728),
            Block.makeCuboidShape(14.827272727272728, -16, -1.1727272727272728, 15.827272727272728, 32, -0.17272727272727284),
            Block.makeCuboidShape(-0.17272727272727195, -16, 15.827272727272728, 0.8272727272727272, 32, 16.827272727272728),
            Block.makeCuboidShape(-1.172727272727272, -16, -0.17272727272727284, -0.17272727272727195, 32, 0.8272727272727272),
            Block.makeCuboidShape(15.827272727272728, -16, 14.827272727272728, 16.827272727272728, 32, 15.827272727272728),
            Block.makeCuboidShape(15.827272727272728, -16, -0.17272727272727284, 16.827272727272728, 32, 0.8272727272727272),
            Block.makeCuboidShape(-1.172727272727272, -16, 14.827272727272728, -0.17272727272727195, 32, 15.827272727272728),
            Block.makeCuboidShape(-0.17272727272727195, -16, -1.1727272727272728, 0.8272727272727272, 32, -0.17272727272727284),
            Block.makeCuboidShape(14.827272727272728, -16, 15.827272727272728, 15.827272727272728, 32, 16.827272727272728),
            Block.makeCuboidShape(16.827272727272728, -16, 0.8272727272727272, 17.827272727272728, 32, 1.8272727272727272),
            Block.makeCuboidShape(-2.172727272727272, -16, 13.827272727272728, -1.172727272727272, 32, 14.827272727272728),
            Block.makeCuboidShape(0.8272727272727272, -16, -2.172727272727273, 1.8272727272727272, 32, -1.1727272727272728),
            Block.makeCuboidShape(13.827272727272728, -16, 16.827272727272728, 14.827272727272728, 32, 17.827272727272728),
            Block.makeCuboidShape(-2.172727272727272, 31, 1.8272727272727272, 17.827272727272728, 32, 13.827272727272728)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(-1.827272727272728, -16, 1.8272727272727263, 18.172727272727272, -15, 13.827272727272728),
            Block.makeCuboidShape(5.172727272727271, -16, 18.827272727272728, 11.172727272727272, 32, 19.827272727272728),
            Block.makeCuboidShape(5.172727272727271, 31, 17.827272727272728, 11.172727272727272, 32, 18.827272727272728),
            Block.makeCuboidShape(5.172727272727271, -16, 17.827272727272728, 11.172727272727272, -15, 18.827272727272728),
            Block.makeCuboidShape(5.172727272727271, -16, -4.172727272727273, 11.172727272727272, 32, -3.172727272727273),
            Block.makeCuboidShape(-2.827272727272728, 31, 4.827272727272726, -1.827272727272728, 32, 10.827272727272728),
            Block.makeCuboidShape(-2.827272727272728, -16, 4.827272727272726, -1.827272727272728, -15.5, 10.827272727272728),
            Block.makeCuboidShape(19.172727272727272, -16, 4.827272727272726, 20.172727272727272, 32, 10.827272727272728),
            Block.makeCuboidShape(18.172727272727272, 31, 4.827272727272726, 19.172727272727272, 32, 10.827272727272728),
            Block.makeCuboidShape(18.172727272727272, -16, 4.827272727272726, 19.172727272727272, -15, 10.827272727272728),
            Block.makeCuboidShape(2.172727272727271, -16, 17.827272727272728, 5.172727272727271, 32, 18.827272727272728),
            Block.makeCuboidShape(11.172727272727272, -16, -3.172727272727273, 14.172727272727272, 32, -2.172727272727273),
            Block.makeCuboidShape(11.172727272727272, -16, 17.827272727272728, 14.172727272727272, 32, 18.827272727272728),
            Block.makeCuboidShape(2.172727272727271, -16, -3.172727272727273, 5.172727272727271, 32, -2.172727272727273),
            Block.makeCuboidShape(-2.827272727272728, -16, 1.8272727272727263, -1.827272727272728, -15.5, 4.827272727272726),
            Block.makeCuboidShape(-2.827272727272728, 31, 1.8272727272727263, -1.827272727272728, 32, 4.827272727272726),
            Block.makeCuboidShape(18.172727272727272, -16, 10.827272727272728, 19.172727272727272, 32, 13.827272727272728),
            Block.makeCuboidShape(-2.827272727272728, -16, 10.827272727272728, -1.827272727272728, -15.5, 13.827272727272728),
            Block.makeCuboidShape(-2.827272727272728, 31, 10.827272727272728, -1.827272727272728, 32, 13.827272727272728),
            Block.makeCuboidShape(18.172727272727272, -16, 1.8272727272727263, 19.172727272727272, 32, 4.827272727272726),
            Block.makeCuboidShape(1.172727272727271, -16, 16.827272727272728, 2.172727272727271, 32, 17.827272727272728),
            Block.makeCuboidShape(2.172727272727271, 31, 16.827272727272728, 14.172727272727272, 32, 17.827272727272728),
            Block.makeCuboidShape(2.172727272727271, -16, 16.827272727272728, 14.172727272727272, -15, 17.827272727272728),
            Block.makeCuboidShape(1.172727272727271, 31, 15.827272727272728, 15.172727272727272, 32, 16.827272727272728),
            Block.makeCuboidShape(1.172727272727271, -16, 15.827272727272728, 15.172727272727272, -15, 16.827272727272728),
            Block.makeCuboidShape(0.17272727272727106, 31, 14.827272727272728, 16.172727272727272, 32, 15.827272727272728),
            Block.makeCuboidShape(0.17272727272727106, -16, 14.827272727272728, 16.172727272727272, -15, 15.827272727272728),
            Block.makeCuboidShape(-0.827272727272728, 31, 13.827272727272728, 17.172727272727272, 32, 14.827272727272728),
            Block.makeCuboidShape(-0.827272727272728, -16, 13.827272727272728, 17.172727272727272, -15, 14.827272727272728),
            Block.makeCuboidShape(-0.827272727272728, 31, 0.8272727272727263, 17.172727272727272, 32, 1.8272727272727263),
            Block.makeCuboidShape(-0.827272727272728, -16, 0.8272727272727263, 17.172727272727272, -15, 1.8272727272727263),
            Block.makeCuboidShape(0.17272727272727106, 31, -0.17272727272727284, 16.172727272727272, 32, 0.8272727272727263),
            Block.makeCuboidShape(0.17272727272727106, -16, -0.17272727272727284, 16.172727272727272, -15, 0.8272727272727263),
            Block.makeCuboidShape(1.172727272727271, 31, -1.1727272727272728, 15.172727272727272, 32, -0.17272727272727284),
            Block.makeCuboidShape(1.172727272727271, -16, -1.1727272727272728, 15.172727272727272, -15, -0.17272727272727284),
            Block.makeCuboidShape(2.172727272727271, 31, -2.172727272727273, 14.172727272727272, 32, -1.1727272727272728),
            Block.makeCuboidShape(2.172727272727271, -16, -2.172727272727273, 14.172727272727272, -15, -1.1727272727272728),
            Block.makeCuboidShape(5.172727272727271, 31, -3.172727272727273, 11.172727272727272, 32, -2.172727272727273),
            Block.makeCuboidShape(5.172727272727271, -16, -3.172727272727273, 11.172727272727272, -15, -2.172727272727273),
            Block.makeCuboidShape(14.172727272727272, -16, -2.172727272727273, 15.172727272727272, 32, -1.1727272727272728),
            Block.makeCuboidShape(17.172727272727272, -16, 13.827272727272728, 18.172727272727272, 32, 14.827272727272728),
            Block.makeCuboidShape(-1.827272727272728, -16, 0.8272727272727263, -0.827272727272728, 32, 1.8272727272727263),
            Block.makeCuboidShape(0.17272727272727106, -16, 15.827272727272728, 1.172727272727271, 32, 16.827272727272728),
            Block.makeCuboidShape(15.172727272727272, -16, -1.1727272727272728, 16.172727272727272, 32, -0.17272727272727284),
            Block.makeCuboidShape(16.172727272727272, -16, 14.827272727272728, 17.172727272727272, 32, 15.827272727272728),
            Block.makeCuboidShape(-0.827272727272728, -16, -0.17272727272727284, 0.17272727272727106, 32, 0.8272727272727263),
            Block.makeCuboidShape(-0.827272727272728, -16, 14.827272727272728, 0.17272727272727106, 32, 15.827272727272728),
            Block.makeCuboidShape(16.172727272727272, -16, -0.17272727272727284, 17.172727272727272, 32, 0.8272727272727263),
            Block.makeCuboidShape(15.172727272727272, -16, 15.827272727272728, 16.172727272727272, 32, 16.827272727272728),
            Block.makeCuboidShape(0.17272727272727106, -16, -1.1727272727272728, 1.172727272727271, 32, -0.17272727272727284),
            Block.makeCuboidShape(-1.827272727272728, -16, 13.827272727272728, -0.827272727272728, 32, 14.827272727272728),
            Block.makeCuboidShape(17.172727272727272, -16, 0.8272727272727263, 18.172727272727272, 32, 1.8272727272727263),
            Block.makeCuboidShape(14.172727272727272, -16, 16.827272727272728, 15.172727272727272, 32, 17.827272727272728),
            Block.makeCuboidShape(1.172727272727271, -16, -2.172727272727273, 2.172727272727271, 32, -1.1727272727272728),
            Block.makeCuboidShape(-1.827272727272728, 31, 1.8272727272727263, 18.172727272727272, 32, 13.827272727272728)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    public Scanner() {
        super(Block.Properties.create(Material.ROCK)

                .hardnessAndResistance(10, 10)
                .sound(SoundType.METAL)
                .lightValue(0)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
        this.setDefaultState(this.stateContainer.getBaseState().with(DIRSCANNER, Direction.NORTH));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(DIRSCANNER);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

        switch(state.get(DIRSCANNER))
        {
            case NORTH: return SHAPE_N;
            case SOUTH: return SHAPE_S;
            case EAST: return SHAPE_E;
            case WEST: return SHAPE_W;
            default:return SHAPE_N;
        }

    }


    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(DIRSCANNER, context.getPlacementHorizontalFacing().getOpposite());
    }

    //mod compatiability
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(DIRSCANNER,rot.rotate(state.get(DIRSCANNER)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(DIRSCANNER)));
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if(worldIn.getBlockState(pos) != ModBlocks.TOWER_WALL.get().getDefaultState());
        {
            this.getBlock().asItem();
        }
    }


    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        return false;
    }

    @Override
    public boolean isTransparent(BlockState state) {
        return false;
    }
}
