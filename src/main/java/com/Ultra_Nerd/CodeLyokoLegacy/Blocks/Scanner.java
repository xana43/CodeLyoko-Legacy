package com.Ultra_Nerd.CodeLyokoLegacy.Blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.ScannerTileEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock.MasterEntity;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public final class Scanner extends HorizontalFacingBlock implements BlockEntityProvider {
    public static final BooleanProperty SCANNER_PROPERTY = BooleanProperty.of("scanner_property");
    private List<BlockState> checkedBlockStates;
    private static final VoxelShape shapeS = Stream.of(Block.createCuboidShape(2, 0, -2, 14, 1, 18),
                    Block.createCuboidShape(-4, 0, 5, -3, 15.3, 11), Block.createCuboidShape(-3, 0, 5, -2, 1, 11),
                    Block.createCuboidShape(19, 0, 5, 20, 15.3, 11), Block.createCuboidShape(5, 0, -3, 11, 1, -2),
                    Block.createCuboidShape(5, 0, 19, 11, 15.3, 20), Block.createCuboidShape(5, 0, 18, 11, 1, 19),
                    Block.createCuboidShape(-3, 0, 2, -2, 15.3, 5), Block.createCuboidShape(18, 0, 11, 19, 15.3, 14),
                    Block.createCuboidShape(-3, 0, 11, -2, 15.3, 14), Block.createCuboidShape(18, 0, 2, 19, 15.3, 5),
                    Block.createCuboidShape(11, 0, -3, 14, 1, -2), Block.createCuboidShape(13, 1, -3, 14, 16.3, -2),
                    Block.createCuboidShape(2, 0, 18, 5, 15.3, 19), Block.createCuboidShape(2, 0, -3, 5, 1, -2),
                    Block.createCuboidShape(2, 1, -3, 3, 16.3, -2), Block.createCuboidShape(11, 0, 18, 14, 15.3, 19),
                    Block.createCuboidShape(-2, 0, 1, -1, 15.3, 2), Block.createCuboidShape(-2, 0, 2, -1, 1, 14),
                    Block.createCuboidShape(-1, 0, 1, 0, 1, 15), Block.createCuboidShape(0, 0, 0, 1, 1, 16),
                    Block.createCuboidShape(1, 0, -1, 2, 1, 17), Block.createCuboidShape(14, 0, -1, 15, 1, 17),
                    Block.createCuboidShape(15, 0, 0, 16, 1, 16), Block.createCuboidShape(16, 0, 1, 17, 1, 15),
                    Block.createCuboidShape(17, 0, 2, 18, 1, 14), Block.createCuboidShape(18, 0, 5, 19, 1, 11),
                    Block.createCuboidShape(17, 0, 14, 18, 15.3, 15), Block.createCuboidShape(1, 0, 17, 2, 15.3, 18),
                    Block.createCuboidShape(14, 0, -2, 15, 15.3, -1), Block.createCuboidShape(-1, 0, 0, 0, 15.3, 1),
                    Block.createCuboidShape(16, 0, 15, 17, 15.3, 16), Block.createCuboidShape(0, 0, 16, 1, 15.3, 17),
                    Block.createCuboidShape(15, 0, -1, 16, 15.3, 0), Block.createCuboidShape(0, 0, -1, 1, 15.3, 0),
                    Block.createCuboidShape(15, 0, 16, 16, 15.3, 17), Block.createCuboidShape(-1, 0, 15, 0, 15.3, 16),
                    Block.createCuboidShape(16, 0, 0, 17, 15.3, 1), Block.createCuboidShape(1, 0, -2, 2, 15.3, -1),
                    Block.createCuboidShape(14, 0, 17, 15, 15.3, 18), Block.createCuboidShape(-2, 0, 14, -1, 15.3, 15),
                    Block.createCuboidShape(17, 0, 1, 18, 15.3, 2))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape shapeN = Stream.of(
                    Block.createCuboidShape(2, 0, -2.4523809523809526, 14, 1, 17.54761904761905),
                    Block.createCuboidShape(19, 0, 4.5476190476190474, 20, 15.3, 10.547619047619047),
                    Block.createCuboidShape(18, 0, 4.5476190476190474, 19, 1, 10.547619047619047),
                    Block.createCuboidShape(-4.000000000000002, 0, 4.5476190476190474, -3.0000000000000018, 15.3,
                            10.547619047619047), Block.createCuboidShape(5, 0, 17.54761904761905, 11, 1, 18.54761904761905),
                    Block.createCuboidShape(5, 0, -4.4523809523809526, 11, 15.3, -3.4523809523809526),
                    Block.createCuboidShape(5, 0, -3.4523809523809526, 11, 1, -2.4523809523809526),
                    Block.createCuboidShape(18, 0, 10.547619047619047, 19, 15.3, 13.547619047619047),
                    Block.createCuboidShape(-3.0000000000000018, 0, 1.5476190476190474, -2.0000000000000018, 15.3,
                            4.5476190476190474),
                    Block.createCuboidShape(18, 0, 1.5476190476190474, 19, 15.3, 4.5476190476190474),
                    Block.createCuboidShape(-3.0000000000000018, 0, 10.547619047619047, -2.0000000000000018, 15.3,
                            13.547619047619047), Block.createCuboidShape(2, 0, 17.54761904761905, 5, 1, 18.54761904761905),
                    Block.createCuboidShape(2, 1, 17.54761904761905, 3, 16.3, 18.54761904761905),
                    Block.createCuboidShape(11, 0, -3.4523809523809526, 14, 15.3, -2.4523809523809526),
                    Block.createCuboidShape(11, 0, 17.54761904761905, 14, 1, 18.54761904761905),
                    Block.createCuboidShape(13, 1, 17.54761904761905, 14, 16.3, 18.54761904761905),
                    Block.createCuboidShape(2, 0, -3.4523809523809526, 5, 15.3, -2.4523809523809526),
                    Block.createCuboidShape(17, 0, 13.547619047619047, 18, 15.3, 14.547619047619047),
                    Block.createCuboidShape(17, 0, 1.5476190476190474, 18, 1, 13.547619047619047),
                    Block.createCuboidShape(16, 0, 0.5476190476190474, 17, 1, 14.547619047619047),
                    Block.createCuboidShape(15, 0, -0.45238095238095255, 16, 1, 15.547619047619047),
                    Block.createCuboidShape(14, 0, -1.4523809523809526, 15, 1, 16.54761904761905),
                    Block.createCuboidShape(1, 0, -1.4523809523809526, 2, 1, 16.54761904761905),
                    Block.createCuboidShape(0, 0, -0.45238095238095255, 1, 1, 15.547619047619047),
                    Block.createCuboidShape(-1.0000000000000018, 0, 0.5476190476190474, 0, 1, 14.547619047619047),
                    Block.createCuboidShape(-2.0000000000000018, 0, 1.5476190476190474, -1.0000000000000018, 1,
                            13.547619047619047),
                    Block.createCuboidShape(-3.0000000000000018, 0, 4.5476190476190474, -2.0000000000000018, 1,
                            10.547619047619047),
                    Block.createCuboidShape(-2.0000000000000018, 0, 0.5476190476190474, -1.0000000000000018, 15.3,
                            1.5476190476190474),
                    Block.createCuboidShape(14, 0, -2.4523809523809526, 15, 15.3, -1.4523809523809526),
                    Block.createCuboidShape(1, 0, 16.54761904761905, 2, 15.3, 17.54761904761905),
                    Block.createCuboidShape(16, 0, 14.547619047619047, 17, 15.3, 15.547619047619047),
                    Block.createCuboidShape(-1.0000000000000018, 0, -0.45238095238095255, 0, 15.3, 0.5476190476190474),
                    Block.createCuboidShape(15, 0, -1.4523809523809526, 16, 15.3, -0.45238095238095255),
                    Block.createCuboidShape(0, 0, 15.547619047619047, 1, 15.3, 16.54761904761905),
                    Block.createCuboidShape(15, 0, 15.547619047619047, 16, 15.3, 16.54761904761905),
                    Block.createCuboidShape(0, 0, -1.4523809523809526, 1, 15.3, -0.45238095238095255),
                    Block.createCuboidShape(16, 0, -0.45238095238095255, 17, 15.3, 0.5476190476190474),
                    Block.createCuboidShape(-1.0000000000000018, 0, 14.547619047619047, 0, 15.3, 15.547619047619047),
                    Block.createCuboidShape(14, 0, 16.54761904761905, 15, 15.3, 17.54761904761905),
                    Block.createCuboidShape(1, 0, -2.4523809523809526, 2, 15.3, -1.4523809523809526),
                    Block.createCuboidShape(17, 0, 0.5476190476190474, 18, 15.3, 1.5476190476190474),
                    Block.createCuboidShape(-2.0000000000000018, 0, 13.547619047619047, -1.0000000000000018, 15.3,
                            14.547619047619047))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape shapeW = Stream.of(
                    Block.createCuboidShape(-2.2261904761904763, 0, 1.7738095238095237, 17.773809523809526, 1,
                            13.773809523809524),
                    Block.createCuboidShape(4.773809523809524, 0, -4.226190476190476, 10.773809523809524, 15.3,
                            -3.2261904761904763),
                    Block.createCuboidShape(4.773809523809524, 0, -3.2261904761904763, 10.773809523809524, 1,
                            -2.2261904761904763),
                    Block.createCuboidShape(4.773809523809524, 0, 18.773809523809526, 10.773809523809524, 15.3,
                            19.773809523809526),
                    Block.createCuboidShape(17.773809523809526, 0, 4.773809523809524, 18.773809523809526, 1,
                            10.773809523809524),
                    Block.createCuboidShape(-4.226190476190476, 0, 4.773809523809524, -3.2261904761904763, 15.3,
                            10.773809523809524),
                    Block.createCuboidShape(-3.2261904761904763, 0, 4.773809523809524, -2.2261904761904763, 1,
                            10.773809523809524),
                    Block.createCuboidShape(10.773809523809524, 0, -3.2261904761904763, 13.773809523809524, 15.3,
                            -2.2261904761904763),
                    Block.createCuboidShape(1.7738095238095237, 0, 17.773809523809526, 4.773809523809524, 15.3,
                            18.773809523809526),
                    Block.createCuboidShape(1.7738095238095237, 0, -3.2261904761904763, 4.773809523809524, 15.3,
                            -2.2261904761904763),
                    Block.createCuboidShape(10.773809523809524, 0, 17.773809523809526, 13.773809523809524, 15.3,
                            18.773809523809526),
                    Block.createCuboidShape(17.773809523809526, 0, 10.773809523809524, 18.773809523809526, 1,
                            13.773809523809524),
                    Block.createCuboidShape(17.773809523809526, 1, 12.773809523809524, 18.773809523809526, 16.3,
                            13.773809523809524),
                    Block.createCuboidShape(-3.2261904761904763, 0, 1.7738095238095237, -2.2261904761904763, 15.3,
                            4.773809523809524),
                    Block.createCuboidShape(17.773809523809526, 0, 1.7738095238095237, 18.773809523809526, 1,
                            4.773809523809524),
                    Block.createCuboidShape(17.773809523809526, 1, 1.7738095238095237, 18.773809523809526, 16.3,
                            2.7738095238095237),
                    Block.createCuboidShape(-3.2261904761904763, 0, 10.773809523809524, -2.2261904761904763, 15.3,
                            13.773809523809524),
                    Block.createCuboidShape(13.773809523809524, 0, -2.2261904761904763, 14.773809523809524, 15.3,
                            -1.2261904761904763),
                    Block.createCuboidShape(1.7738095238095237, 0, -2.2261904761904763, 13.773809523809524, 1,
                            -1.2261904761904763),
                    Block.createCuboidShape(0.7738095238095237, 0, -1.2261904761904763, 14.773809523809524, 1,
                            -0.22619047619047628),
                    Block.createCuboidShape(-0.22619047619047628, 0, -0.22619047619047628, 15.773809523809524, 1,
                            0.7738095238095237),
                    Block.createCuboidShape(-1.2261904761904763, 0, 0.7738095238095237, 16.773809523809526, 1,
                            1.7738095238095237),
                    Block.createCuboidShape(-1.2261904761904763, 0, 13.773809523809524, 16.773809523809526, 1,
                            14.773809523809524),
                    Block.createCuboidShape(-0.22619047619047628, 0, 14.773809523809524, 15.773809523809524, 1,
                            15.773809523809524),
                    Block.createCuboidShape(0.7738095238095237, 0, 15.773809523809524, 14.773809523809524, 1,
                            16.773809523809526),
                    Block.createCuboidShape(1.7738095238095237, 0, 16.773809523809526, 13.773809523809524, 1,
                            17.773809523809526),
                    Block.createCuboidShape(4.773809523809524, 0, 17.773809523809526, 10.773809523809524, 1,
                            18.773809523809526),
                    Block.createCuboidShape(0.7738095238095237, 0, 16.773809523809526, 1.7738095238095237, 15.3,
                            17.773809523809526),
                    Block.createCuboidShape(-2.2261904761904763, 0, 0.7738095238095237, -1.2261904761904763, 15.3,
                            1.7738095238095237),
                    Block.createCuboidShape(16.773809523809526, 0, 13.773809523809524, 17.773809523809526, 15.3,
                            14.773809523809524),
                    Block.createCuboidShape(14.773809523809524, 0, -1.2261904761904763, 15.773809523809524, 15.3,
                            -0.22619047619047628),
                    Block.createCuboidShape(-0.22619047619047628, 0, 15.773809523809524, 0.7738095238095237, 15.3,
                            16.773809523809526),
                    Block.createCuboidShape(-1.2261904761904763, 0, -0.22619047619047628, -0.22619047619047628, 15.3,
                            0.7738095238095237),
                    Block.createCuboidShape(15.773809523809524, 0, 14.773809523809524, 16.773809523809526, 15.3,
                            15.773809523809524),
                    Block.createCuboidShape(15.773809523809524, 0, -0.22619047619047628, 16.773809523809526, 15.3,
                            0.7738095238095237),
                    Block.createCuboidShape(-1.2261904761904763, 0, 14.773809523809524, -0.22619047619047628, 15.3,
                            15.773809523809524),
                    Block.createCuboidShape(-0.22619047619047628, 0, -1.2261904761904763, 0.7738095238095237, 15.3,
                            -0.22619047619047628),
                    Block.createCuboidShape(14.773809523809524, 0, 15.773809523809524, 15.773809523809524, 15.3,
                            16.773809523809526),
                    Block.createCuboidShape(16.773809523809526, 0, 0.7738095238095237, 17.773809523809526, 15.3,
                            1.7738095238095237),
                    Block.createCuboidShape(-2.2261904761904763, 0, 13.773809523809524, -1.2261904761904763, 15.3,
                            14.773809523809524),
                    Block.createCuboidShape(0.7738095238095237, 0, -2.2261904761904763, 1.7738095238095237, 15.3,
                            -1.2261904761904763),
                    Block.createCuboidShape(13.773809523809524, 0, 16.773809523809526, 14.773809523809524, 15.3,
                            17.773809523809526))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape shapeE = Stream.of(
                    Block.createCuboidShape(-1.7738095238095273, 0, 1.7738095238095237, 18.226190476190474, 1,
                            13.773809523809524),
                    Block.createCuboidShape(5.226190476190476, 0, 18.773809523809526, 11.226190476190476, 15.3,
                            19.773809523809526),
                    Block.createCuboidShape(5.226190476190476, 0, 17.773809523809526, 11.226190476190476, 1,
                            18.773809523809526),
                    Block.createCuboidShape(5.226190476190476, 0, -4.226190476190478, 11.226190476190476, 15.3,
                            -3.226190476190478),
                    Block.createCuboidShape(-2.7738095238095273, 0, 4.773809523809524, -1.7738095238095273, 1,
                            10.773809523809524),
                    Block.createCuboidShape(19.226190476190474, 0, 4.773809523809524, 20.226190476190474, 15.3,
                            10.773809523809524),
                    Block.createCuboidShape(18.226190476190474, 0, 4.773809523809524, 19.226190476190474, 1,
                            10.773809523809524),
                    Block.createCuboidShape(2.2261904761904763, 0, 17.773809523809526, 5.226190476190476, 15.3,
                            18.773809523809526),
                    Block.createCuboidShape(11.226190476190476, 0, -3.226190476190478, 14.226190476190476, 15.3,
                            -2.226190476190478),
                    Block.createCuboidShape(11.226190476190476, 0, 17.773809523809526, 14.226190476190476, 15.3,
                            18.773809523809526),
                    Block.createCuboidShape(2.2261904761904763, 0, -3.226190476190478, 5.226190476190476, 15.3,
                            -2.226190476190478),
                    Block.createCuboidShape(-2.7738095238095273, 0, 1.7738095238095237, -1.7738095238095273, 1,
                            4.773809523809524),
                    Block.createCuboidShape(-2.7738095238095273, 1, 1.7738095238095237, -1.7738095238095273, 16.3,
                            2.7738095238095237),
                    Block.createCuboidShape(18.226190476190474, 0, 10.773809523809524, 19.226190476190474, 15.3,
                            13.773809523809524),
                    Block.createCuboidShape(-2.7738095238095273, 0, 10.773809523809524, -1.7738095238095273, 1,
                            13.773809523809524),
                    Block.createCuboidShape(-2.7738095238095273, 1, 12.773809523809524, -1.7738095238095273, 16.3,
                            13.773809523809524),
                    Block.createCuboidShape(18.226190476190474, 0, 1.7738095238095237, 19.226190476190474, 15.3,
                            4.773809523809524),
                    Block.createCuboidShape(1.2261904761904763, 0, 16.773809523809526, 2.2261904761904763, 15.3,
                            17.773809523809526),
                    Block.createCuboidShape(2.2261904761904763, 0, 16.773809523809526, 14.226190476190476, 1,
                            17.773809523809526),
                    Block.createCuboidShape(1.2261904761904763, 0, 15.773809523809524, 15.226190476190476, 1,
                            16.773809523809526),
                    Block.createCuboidShape(0.22619047619047628, 0, 14.773809523809524, 16.226190476190474, 1,
                            15.773809523809524),
                    Block.createCuboidShape(-0.7738095238095273, 0, 13.773809523809524, 17.226190476190474, 1,
                            14.773809523809524),
                    Block.createCuboidShape(-0.7738095238095273, 0, 0.7738095238095237, 17.226190476190474, 1,
                            1.7738095238095237),
                    Block.createCuboidShape(0.22619047619047628, 0, -0.22619047619047628, 16.226190476190474, 1,
                            0.7738095238095237),
                    Block.createCuboidShape(1.2261904761904763, 0, -1.226190476190478, 15.226190476190476, 1,
                            -0.22619047619047628),
                    Block.createCuboidShape(2.2261904761904763, 0, -2.226190476190478, 14.226190476190476, 1,
                            -1.226190476190478),
                    Block.createCuboidShape(5.226190476190476, 0, -3.226190476190478, 11.226190476190476, 1,
                            -2.226190476190478),
                    Block.createCuboidShape(14.226190476190476, 0, -2.226190476190478, 15.226190476190476, 15.3,
                            -1.226190476190478),
                    Block.createCuboidShape(17.226190476190474, 0, 13.773809523809524, 18.226190476190474, 15.3,
                            14.773809523809524),
                    Block.createCuboidShape(-1.7738095238095273, 0, 0.7738095238095237, -0.7738095238095273, 15.3,
                            1.7738095238095237),
                    Block.createCuboidShape(0.22619047619047628, 0, 15.773809523809524, 1.2261904761904763, 15.3,
                            16.773809523809526),
                    Block.createCuboidShape(15.226190476190476, 0, -1.226190476190478, 16.226190476190474, 15.3,
                            -0.22619047619047628),
                    Block.createCuboidShape(16.226190476190474, 0, 14.773809523809524, 17.226190476190474, 15.3,
                            15.773809523809524),
                    Block.createCuboidShape(-0.7738095238095273, 0, -0.22619047619047628, 0.22619047619047628, 15.3,
                            0.7738095238095237),
                    Block.createCuboidShape(-0.7738095238095273, 0, 14.773809523809524, 0.22619047619047628, 15.3,
                            15.773809523809524),
                    Block.createCuboidShape(16.226190476190474, 0, -0.22619047619047628, 17.226190476190474, 15.3,
                            0.7738095238095237),
                    Block.createCuboidShape(15.226190476190476, 0, 15.773809523809524, 16.226190476190474, 15.3,
                            16.773809523809526),
                    Block.createCuboidShape(0.22619047619047628, 0, -1.226190476190478, 1.2261904761904763, 15.3,
                            -0.22619047619047628),
                    Block.createCuboidShape(-1.7738095238095273, 0, 13.773809523809524, -0.7738095238095273, 15.3,
                            14.773809523809524),
                    Block.createCuboidShape(17.226190476190474, 0, 0.7738095238095237, 18.226190476190474, 15.3,
                            1.7738095238095237),
                    Block.createCuboidShape(14.226190476190476, 0, 16.773809523809526, 15.226190476190476, 15.3,
                            17.773809523809526),
                    Block.createCuboidShape(1.2261904761904763, 0, -2.226190476190478, 2.2261904761904763, 15.3,
                            -1.226190476190478))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape blockShape = Block.createCuboidShape(0, 0, 0, 16, 16, 16);
    private float time;


    public Scanner() {
        super(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)

                .strength(10, 10).sounds(BlockSoundGroup.METAL)


        );

        this.setDefaultState(this.getDefaultState().with(SCANNER_PROPERTY, Boolean.FALSE)
                .with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getCullingShape(final BlockState state, final BlockView world, final BlockPos pos) {
        return switch (state.get(FACING)) {
            case SOUTH -> shapeS;
            case EAST -> shapeE;
            case WEST -> shapeW;
            default -> shapeN;
        };
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {

        if (state.<Boolean>get(SCANNER_PROPERTY)) {
            return switch (state.get(FACING)) {
                case SOUTH -> shapeS;
                case EAST -> shapeE;
                case WEST -> shapeW;
                default -> shapeN;
            };
        } else {
            return blockShape;
        }
    }

    @Override
    public void onPlaced(final World world, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if(world.getBlockEntity(pos) instanceof final MasterEntity masterEntity)
        {
            masterEntity.check();
        }
    }


    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing()).with(SCANNER_PROPERTY, Boolean.FALSE);
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(SCANNER_PROPERTY).add(FACING));
    }




    @Override
    public void onBroken(final WorldAccess world, final BlockPos pos, final BlockState state) {
        if (world.getBlockEntity(pos) instanceof final ScannerTileEntity scannerTile) {

            scannerTile.invalidateEntity();
            time = 0;

        }
        super.onBroken(world, pos, state);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.SCANNER_TILE_ENTITY.instantiate(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(final World world, final BlockState state, final BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if (blockEntity instanceof final ScannerTileEntity scannerTile) {

                time += 0.01f;
                final float offset = (MathHelper.sin(time) * 1.2f) + 1.4f;
                if (time == Float.MAX_VALUE) {
                    time = 0;
                }

                scannerTile.tick();

                if (state.<Boolean>get(SCANNER_PROPERTY) && scannerTile.isInScanner()) {
                    final PacketByteBuf buf = PacketByteBufs.create();
                    buf.writeBlockPos(pos);
                    buf.writeFloat(offset);
                    if(!world.isClient)
                    {
                        for(final PlayerEntity player : world1.getPlayers())
                        {
                            //ServerPlayNetworking.send((ServerPlayerEntity) player, PacketHandler.SYNC_SCANNER_PARTICLES,buf);
                        }
                    }
                }
            }
        };
    }


    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }
}


