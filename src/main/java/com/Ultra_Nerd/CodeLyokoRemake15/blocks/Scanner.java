package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Scanner extends Block {
    public static BooleanProperty Scanner = BooleanProperty.create("scanner_formed");
    public static final DirectionProperty directionProperty = HorizontalDirectionalBlock.FACING;
    private final VoxelShape shapeS = Stream.of(
            Block.makeCuboidShape(2, 0, -2, 14, 1, 18),
            Block.makeCuboidShape(-4, 0, 5, -3, 15.3, 11),
            Block.makeCuboidShape(-3, 0, 5, -2, 1, 11),
            Block.makeCuboidShape(19, 0, 5, 20, 15.3, 11),
            Block.makeCuboidShape(5, 0, -3, 11, 1, -2),
            Block.makeCuboidShape(5, 0, 19, 11, 15.3, 20),
            Block.makeCuboidShape(5, 0, 18, 11, 1, 19),
            Block.makeCuboidShape(-3, 0, 2, -2, 15.3, 5),
            Block.makeCuboidShape(18, 0, 11, 19, 15.3, 14),
            Block.makeCuboidShape(-3, 0, 11, -2, 15.3, 14),
            Block.makeCuboidShape(18, 0, 2, 19, 15.3, 5),
            Block.makeCuboidShape(11, 0, -3, 14, 1, -2),
            Block.makeCuboidShape(13, 1, -3, 14, 16.3, -2),
            Block.makeCuboidShape(2, 0, 18, 5, 15.3, 19),
            Block.makeCuboidShape(2, 0, -3, 5, 1, -2),
            Block.makeCuboidShape(2, 1, -3, 3, 16.3, -2),
            Block.makeCuboidShape(11, 0, 18, 14, 15.3, 19),
            Block.makeCuboidShape(-2, 0, 1, -1, 15.3, 2),
            Block.makeCuboidShape(-2, 0, 2, -1, 1, 14),
            Block.makeCuboidShape(-1, 0, 1, 0, 1, 15),
            Block.makeCuboidShape(0, 0, 0, 1, 1, 16),
            Block.makeCuboidShape(1, 0, -1, 2, 1, 17),
            Block.makeCuboidShape(14, 0, -1, 15, 1, 17),
            Block.makeCuboidShape(15, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(16, 0, 1, 17, 1, 15),
            Block.makeCuboidShape(17, 0, 2, 18, 1, 14),
            Block.makeCuboidShape(18, 0, 5, 19, 1, 11),
            Block.makeCuboidShape(17, 0, 14, 18, 15.3, 15),
            Block.makeCuboidShape(1, 0, 17, 2, 15.3, 18),
            Block.makeCuboidShape(14, 0, -2, 15, 15.3, -1),
            Block.makeCuboidShape(-1, 0, 0, 0, 15.3, 1),
            Block.makeCuboidShape(16, 0, 15, 17, 15.3, 16),
            Block.makeCuboidShape(0, 0, 16, 1, 15.3, 17),
            Block.makeCuboidShape(15, 0, -1, 16, 15.3, 0),
            Block.makeCuboidShape(0, 0, -1, 1, 15.3, 0),
            Block.makeCuboidShape(15, 0, 16, 16, 15.3, 17),
            Block.makeCuboidShape(-1, 0, 15, 0, 15.3, 16),
            Block.makeCuboidShape(16, 0, 0, 17, 15.3, 1),
            Block.makeCuboidShape(1, 0, -2, 2, 15.3, -1),
            Block.makeCuboidShape(14, 0, 17, 15, 15.3, 18),
            Block.makeCuboidShape(-2, 0, 14, -1, 15.3, 15),
            Block.makeCuboidShape(17, 0, 1, 18, 15.3, 2)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    private final VoxelShape shapeN = Stream.of(
            Block.makeCuboidShape(2, 0, -2.4523809523809526, 14, 1, 17.54761904761905),
            Block.makeCuboidShape(19, 0, 4.5476190476190474, 20, 15.3, 10.547619047619047),
            Block.makeCuboidShape(18, 0, 4.5476190476190474, 19, 1, 10.547619047619047),
            Block.makeCuboidShape(-4.000000000000002, 0, 4.5476190476190474, -3.0000000000000018, 15.3, 10.547619047619047),
            Block.makeCuboidShape(5, 0, 17.54761904761905, 11, 1, 18.54761904761905),
            Block.makeCuboidShape(5, 0, -4.4523809523809526, 11, 15.3, -3.4523809523809526),
            Block.makeCuboidShape(5, 0, -3.4523809523809526, 11, 1, -2.4523809523809526),
            Block.makeCuboidShape(18, 0, 10.547619047619047, 19, 15.3, 13.547619047619047),
            Block.makeCuboidShape(-3.0000000000000018, 0, 1.5476190476190474, -2.0000000000000018, 15.3, 4.5476190476190474),
            Block.makeCuboidShape(18, 0, 1.5476190476190474, 19, 15.3, 4.5476190476190474),
            Block.makeCuboidShape(-3.0000000000000018, 0, 10.547619047619047, -2.0000000000000018, 15.3, 13.547619047619047),
            Block.makeCuboidShape(2, 0, 17.54761904761905, 5, 1, 18.54761904761905),
            Block.makeCuboidShape(2, 1, 17.54761904761905, 3, 16.3, 18.54761904761905),
            Block.makeCuboidShape(11, 0, -3.4523809523809526, 14, 15.3, -2.4523809523809526),
            Block.makeCuboidShape(11, 0, 17.54761904761905, 14, 1, 18.54761904761905),
            Block.makeCuboidShape(13, 1, 17.54761904761905, 14, 16.3, 18.54761904761905),
            Block.makeCuboidShape(2, 0, -3.4523809523809526, 5, 15.3, -2.4523809523809526),
            Block.makeCuboidShape(17, 0, 13.547619047619047, 18, 15.3, 14.547619047619047),
            Block.makeCuboidShape(17, 0, 1.5476190476190474, 18, 1, 13.547619047619047),
            Block.makeCuboidShape(16, 0, 0.5476190476190474, 17, 1, 14.547619047619047),
            Block.makeCuboidShape(15, 0, -0.45238095238095255, 16, 1, 15.547619047619047),
            Block.makeCuboidShape(14, 0, -1.4523809523809526, 15, 1, 16.54761904761905),
            Block.makeCuboidShape(1, 0, -1.4523809523809526, 2, 1, 16.54761904761905),
            Block.makeCuboidShape(0, 0, -0.45238095238095255, 1, 1, 15.547619047619047),
            Block.makeCuboidShape(-1.0000000000000018, 0, 0.5476190476190474, 0, 1, 14.547619047619047),
            Block.makeCuboidShape(-2.0000000000000018, 0, 1.5476190476190474, -1.0000000000000018, 1, 13.547619047619047),
            Block.makeCuboidShape(-3.0000000000000018, 0, 4.5476190476190474, -2.0000000000000018, 1, 10.547619047619047),
            Block.makeCuboidShape(-2.0000000000000018, 0, 0.5476190476190474, -1.0000000000000018, 15.3, 1.5476190476190474),
            Block.makeCuboidShape(14, 0, -2.4523809523809526, 15, 15.3, -1.4523809523809526),
            Block.makeCuboidShape(1, 0, 16.54761904761905, 2, 15.3, 17.54761904761905),
            Block.makeCuboidShape(16, 0, 14.547619047619047, 17, 15.3, 15.547619047619047),
            Block.makeCuboidShape(-1.0000000000000018, 0, -0.45238095238095255, 0, 15.3, 0.5476190476190474),
            Block.makeCuboidShape(15, 0, -1.4523809523809526, 16, 15.3, -0.45238095238095255),
            Block.makeCuboidShape(0, 0, 15.547619047619047, 1, 15.3, 16.54761904761905),
            Block.makeCuboidShape(15, 0, 15.547619047619047, 16, 15.3, 16.54761904761905),
            Block.makeCuboidShape(0, 0, -1.4523809523809526, 1, 15.3, -0.45238095238095255),
            Block.makeCuboidShape(16, 0, -0.45238095238095255, 17, 15.3, 0.5476190476190474),
            Block.makeCuboidShape(-1.0000000000000018, 0, 14.547619047619047, 0, 15.3, 15.547619047619047),
            Block.makeCuboidShape(14, 0, 16.54761904761905, 15, 15.3, 17.54761904761905),
            Block.makeCuboidShape(1, 0, -2.4523809523809526, 2, 15.3, -1.4523809523809526),
            Block.makeCuboidShape(17, 0, 0.5476190476190474, 18, 15.3, 1.5476190476190474),
            Block.makeCuboidShape(-2.0000000000000018, 0, 13.547619047619047, -1.0000000000000018, 15.3, 14.547619047619047)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    private final VoxelShape shapeW = Stream.of(
            Block.makeCuboidShape(-2.2261904761904763, 0, 1.7738095238095237, 17.773809523809526, 1, 13.773809523809524),
            Block.makeCuboidShape(4.773809523809524, 0, -4.226190476190476, 10.773809523809524, 15.3, -3.2261904761904763),
            Block.makeCuboidShape(4.773809523809524, 0, -3.2261904761904763, 10.773809523809524, 1, -2.2261904761904763),
            Block.makeCuboidShape(4.773809523809524, 0, 18.773809523809526, 10.773809523809524, 15.3, 19.773809523809526),
            Block.makeCuboidShape(17.773809523809526, 0, 4.773809523809524, 18.773809523809526, 1, 10.773809523809524),
            Block.makeCuboidShape(-4.226190476190476, 0, 4.773809523809524, -3.2261904761904763, 15.3, 10.773809523809524),
            Block.makeCuboidShape(-3.2261904761904763, 0, 4.773809523809524, -2.2261904761904763, 1, 10.773809523809524),
            Block.makeCuboidShape(10.773809523809524, 0, -3.2261904761904763, 13.773809523809524, 15.3, -2.2261904761904763),
            Block.makeCuboidShape(1.7738095238095237, 0, 17.773809523809526, 4.773809523809524, 15.3, 18.773809523809526),
            Block.makeCuboidShape(1.7738095238095237, 0, -3.2261904761904763, 4.773809523809524, 15.3, -2.2261904761904763),
            Block.makeCuboidShape(10.773809523809524, 0, 17.773809523809526, 13.773809523809524, 15.3, 18.773809523809526),
            Block.makeCuboidShape(17.773809523809526, 0, 10.773809523809524, 18.773809523809526, 1, 13.773809523809524),
            Block.makeCuboidShape(17.773809523809526, 1, 12.773809523809524, 18.773809523809526, 16.3, 13.773809523809524),
            Block.makeCuboidShape(-3.2261904761904763, 0, 1.7738095238095237, -2.2261904761904763, 15.3, 4.773809523809524),
            Block.makeCuboidShape(17.773809523809526, 0, 1.7738095238095237, 18.773809523809526, 1, 4.773809523809524),
            Block.makeCuboidShape(17.773809523809526, 1, 1.7738095238095237, 18.773809523809526, 16.3, 2.7738095238095237),
            Block.makeCuboidShape(-3.2261904761904763, 0, 10.773809523809524, -2.2261904761904763, 15.3, 13.773809523809524),
            Block.makeCuboidShape(13.773809523809524, 0, -2.2261904761904763, 14.773809523809524, 15.3, -1.2261904761904763),
            Block.makeCuboidShape(1.7738095238095237, 0, -2.2261904761904763, 13.773809523809524, 1, -1.2261904761904763),
            Block.makeCuboidShape(0.7738095238095237, 0, -1.2261904761904763, 14.773809523809524, 1, -0.22619047619047628),
            Block.makeCuboidShape(-0.22619047619047628, 0, -0.22619047619047628, 15.773809523809524, 1, 0.7738095238095237),
            Block.makeCuboidShape(-1.2261904761904763, 0, 0.7738095238095237, 16.773809523809526, 1, 1.7738095238095237),
            Block.makeCuboidShape(-1.2261904761904763, 0, 13.773809523809524, 16.773809523809526, 1, 14.773809523809524),
            Block.makeCuboidShape(-0.22619047619047628, 0, 14.773809523809524, 15.773809523809524, 1, 15.773809523809524),
            Block.makeCuboidShape(0.7738095238095237, 0, 15.773809523809524, 14.773809523809524, 1, 16.773809523809526),
            Block.makeCuboidShape(1.7738095238095237, 0, 16.773809523809526, 13.773809523809524, 1, 17.773809523809526),
            Block.makeCuboidShape(4.773809523809524, 0, 17.773809523809526, 10.773809523809524, 1, 18.773809523809526),
            Block.makeCuboidShape(0.7738095238095237, 0, 16.773809523809526, 1.7738095238095237, 15.3, 17.773809523809526),
            Block.makeCuboidShape(-2.2261904761904763, 0, 0.7738095238095237, -1.2261904761904763, 15.3, 1.7738095238095237),
            Block.makeCuboidShape(16.773809523809526, 0, 13.773809523809524, 17.773809523809526, 15.3, 14.773809523809524),
            Block.makeCuboidShape(14.773809523809524, 0, -1.2261904761904763, 15.773809523809524, 15.3, -0.22619047619047628),
            Block.makeCuboidShape(-0.22619047619047628, 0, 15.773809523809524, 0.7738095238095237, 15.3, 16.773809523809526),
            Block.makeCuboidShape(-1.2261904761904763, 0, -0.22619047619047628, -0.22619047619047628, 15.3, 0.7738095238095237),
            Block.makeCuboidShape(15.773809523809524, 0, 14.773809523809524, 16.773809523809526, 15.3, 15.773809523809524),
            Block.makeCuboidShape(15.773809523809524, 0, -0.22619047619047628, 16.773809523809526, 15.3, 0.7738095238095237),
            Block.makeCuboidShape(-1.2261904761904763, 0, 14.773809523809524, -0.22619047619047628, 15.3, 15.773809523809524),
            Block.makeCuboidShape(-0.22619047619047628, 0, -1.2261904761904763, 0.7738095238095237, 15.3, -0.22619047619047628),
            Block.makeCuboidShape(14.773809523809524, 0, 15.773809523809524, 15.773809523809524, 15.3, 16.773809523809526),
            Block.makeCuboidShape(16.773809523809526, 0, 0.7738095238095237, 17.773809523809526, 15.3, 1.7738095238095237),
            Block.makeCuboidShape(-2.2261904761904763, 0, 13.773809523809524, -1.2261904761904763, 15.3, 14.773809523809524),
            Block.makeCuboidShape(0.7738095238095237, 0, -2.2261904761904763, 1.7738095238095237, 15.3, -1.2261904761904763),
            Block.makeCuboidShape(13.773809523809524, 0, 16.773809523809526, 14.773809523809524, 15.3, 17.773809523809526)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    private final VoxelShape shapeE = Stream.of(
            Block.makeCuboidShape(-1.7738095238095273, 0, 1.7738095238095237, 18.226190476190474, 1, 13.773809523809524),
            Block.makeCuboidShape(5.226190476190476, 0, 18.773809523809526, 11.226190476190476, 15.3, 19.773809523809526),
            Block.makeCuboidShape(5.226190476190476, 0, 17.773809523809526, 11.226190476190476, 1, 18.773809523809526),
            Block.makeCuboidShape(5.226190476190476, 0, -4.226190476190478, 11.226190476190476, 15.3, -3.226190476190478),
            Block.makeCuboidShape(-2.7738095238095273, 0, 4.773809523809524, -1.7738095238095273, 1, 10.773809523809524),
            Block.makeCuboidShape(19.226190476190474, 0, 4.773809523809524, 20.226190476190474, 15.3, 10.773809523809524),
            Block.makeCuboidShape(18.226190476190474, 0, 4.773809523809524, 19.226190476190474, 1, 10.773809523809524),
            Block.makeCuboidShape(2.2261904761904763, 0, 17.773809523809526, 5.226190476190476, 15.3, 18.773809523809526),
            Block.makeCuboidShape(11.226190476190476, 0, -3.226190476190478, 14.226190476190476, 15.3, -2.226190476190478),
            Block.makeCuboidShape(11.226190476190476, 0, 17.773809523809526, 14.226190476190476, 15.3, 18.773809523809526),
            Block.makeCuboidShape(2.2261904761904763, 0, -3.226190476190478, 5.226190476190476, 15.3, -2.226190476190478),
            Block.makeCuboidShape(-2.7738095238095273, 0, 1.7738095238095237, -1.7738095238095273, 1, 4.773809523809524),
            Block.makeCuboidShape(-2.7738095238095273, 1, 1.7738095238095237, -1.7738095238095273, 16.3, 2.7738095238095237),
            Block.makeCuboidShape(18.226190476190474, 0, 10.773809523809524, 19.226190476190474, 15.3, 13.773809523809524),
            Block.makeCuboidShape(-2.7738095238095273, 0, 10.773809523809524, -1.7738095238095273, 1, 13.773809523809524),
            Block.makeCuboidShape(-2.7738095238095273, 1, 12.773809523809524, -1.7738095238095273, 16.3, 13.773809523809524),
            Block.makeCuboidShape(18.226190476190474, 0, 1.7738095238095237, 19.226190476190474, 15.3, 4.773809523809524),
            Block.makeCuboidShape(1.2261904761904763, 0, 16.773809523809526, 2.2261904761904763, 15.3, 17.773809523809526),
            Block.makeCuboidShape(2.2261904761904763, 0, 16.773809523809526, 14.226190476190476, 1, 17.773809523809526),
            Block.makeCuboidShape(1.2261904761904763, 0, 15.773809523809524, 15.226190476190476, 1, 16.773809523809526),
            Block.makeCuboidShape(0.22619047619047628, 0, 14.773809523809524, 16.226190476190474, 1, 15.773809523809524),
            Block.makeCuboidShape(-0.7738095238095273, 0, 13.773809523809524, 17.226190476190474, 1, 14.773809523809524),
            Block.makeCuboidShape(-0.7738095238095273, 0, 0.7738095238095237, 17.226190476190474, 1, 1.7738095238095237),
            Block.makeCuboidShape(0.22619047619047628, 0, -0.22619047619047628, 16.226190476190474, 1, 0.7738095238095237),
            Block.makeCuboidShape(1.2261904761904763, 0, -1.226190476190478, 15.226190476190476, 1, -0.22619047619047628),
            Block.makeCuboidShape(2.2261904761904763, 0, -2.226190476190478, 14.226190476190476, 1, -1.226190476190478),
            Block.makeCuboidShape(5.226190476190476, 0, -3.226190476190478, 11.226190476190476, 1, -2.226190476190478),
            Block.makeCuboidShape(14.226190476190476, 0, -2.226190476190478, 15.226190476190476, 15.3, -1.226190476190478),
            Block.makeCuboidShape(17.226190476190474, 0, 13.773809523809524, 18.226190476190474, 15.3, 14.773809523809524),
            Block.makeCuboidShape(-1.7738095238095273, 0, 0.7738095238095237, -0.7738095238095273, 15.3, 1.7738095238095237),
            Block.makeCuboidShape(0.22619047619047628, 0, 15.773809523809524, 1.2261904761904763, 15.3, 16.773809523809526),
            Block.makeCuboidShape(15.226190476190476, 0, -1.226190476190478, 16.226190476190474, 15.3, -0.22619047619047628),
            Block.makeCuboidShape(16.226190476190474, 0, 14.773809523809524, 17.226190476190474, 15.3, 15.773809523809524),
            Block.makeCuboidShape(-0.7738095238095273, 0, -0.22619047619047628, 0.22619047619047628, 15.3, 0.7738095238095237),
            Block.makeCuboidShape(-0.7738095238095273, 0, 14.773809523809524, 0.22619047619047628, 15.3, 15.773809523809524),
            Block.makeCuboidShape(16.226190476190474, 0, -0.22619047619047628, 17.226190476190474, 15.3, 0.7738095238095237),
            Block.makeCuboidShape(15.226190476190476, 0, 15.773809523809524, 16.226190476190474, 15.3, 16.773809523809526),
            Block.makeCuboidShape(0.22619047619047628, 0, -1.226190476190478, 1.2261904761904763, 15.3, -0.22619047619047628),
            Block.makeCuboidShape(-1.7738095238095273, 0, 13.773809523809524, -0.7738095238095273, 15.3, 14.773809523809524),
            Block.makeCuboidShape(17.226190476190474, 0, 0.7738095238095237, 18.226190476190474, 15.3, 1.7738095238095237),
            Block.makeCuboidShape(14.226190476190476, 0, 16.773809523809526, 15.226190476190476, 15.3, 17.773809523809526),
            Block.makeCuboidShape(1.2261904761904763, 0, -2.226190476190478, 2.2261904761904763, 15.3, -1.226190476190478)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    private static final VoxelShape blockShape = Block.makeCuboidShape(0, 0, 0, 16, 16, 16);

    public Scanner() {
        super(Block.Properties.create(Material.ROCK)

                .hardnessAndResistance(10, 10)
                .sound(SoundType.METAL)
                .lightValue(0)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
        this.setDefaultState(this.getDefaultState().with(Scanner, false).with(directionProperty, Direction.NORTH));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        if (state.get(Scanner)) {
            switch (state.get(directionProperty)) {
                case NORTH:
                    return shapeN;
                case SOUTH:
                    return shapeS;
                case EAST:
                    return shapeE;
                case WEST:
                    return shapeW;
                default:
                    return shapeN;
            }
        } else {
            return blockShape;
        }

    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(directionProperty, context.getPlacementHorizontalFacing());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(directionProperty, rot.rotate(state.get(directionProperty)));
    }


    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(directionProperty)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(Scanner).add(directionProperty);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.SCANNER_TILE_ENTITY.get().create();
    }

    @Override
    public boolean isNormalCube(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return false;
    }

    @Override
    public boolean isSideInvisible(@Nonnull BlockState state, @Nonnull BlockState adjacentBlockState, @Nonnull Direction side) {
        return false;
    }

    @Override
    public boolean isTransparent(@Nonnull BlockState state) {
        return false;
    }
}
