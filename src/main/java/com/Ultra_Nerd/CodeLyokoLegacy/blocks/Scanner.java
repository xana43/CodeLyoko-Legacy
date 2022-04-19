package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.ScannerTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.stream.Stream;

public final class Scanner extends BaseEntityBlock  {
    public static final BooleanProperty Scanner = BooleanProperty.create("scanner_formed");
    public static final DirectionProperty directionProperty = HorizontalDirectionalBlock.FACING;
    private static final VoxelShape shapeS = Stream.of(
            Block.box(2, 0, -2, 14, 1, 18),
            Block.box(-4, 0, 5, -3, 15.3, 11),
            Block.box(-3, 0, 5, -2, 1, 11),
            Block.box(19, 0, 5, 20, 15.3, 11),
            Block.box(5, 0, -3, 11, 1, -2),
            Block.box(5, 0, 19, 11, 15.3, 20),
            Block.box(5, 0, 18, 11, 1, 19),
            Block.box(-3, 0, 2, -2, 15.3, 5),
            Block.box(18, 0, 11, 19, 15.3, 14),
            Block.box(-3, 0, 11, -2, 15.3, 14),
            Block.box(18, 0, 2, 19, 15.3, 5),
            Block.box(11, 0, -3, 14, 1, -2),
            Block.box(13, 1, -3, 14, 16.3, -2),
            Block.box(2, 0, 18, 5, 15.3, 19),
            Block.box(2, 0, -3, 5, 1, -2),
            Block.box(2, 1, -3, 3, 16.3, -2),
            Block.box(11, 0, 18, 14, 15.3, 19),
            Block.box(-2, 0, 1, -1, 15.3, 2),
            Block.box(-2, 0, 2, -1, 1, 14),
            Block.box(-1, 0, 1, 0, 1, 15),
            Block.box(0, 0, 0, 1, 1, 16),
            Block.box(1, 0, -1, 2, 1, 17),
            Block.box(14, 0, -1, 15, 1, 17),
            Block.box(15, 0, 0, 16, 1, 16),
            Block.box(16, 0, 1, 17, 1, 15),
            Block.box(17, 0, 2, 18, 1, 14),
            Block.box(18, 0, 5, 19, 1, 11),
            Block.box(17, 0, 14, 18, 15.3, 15),
            Block.box(1, 0, 17, 2, 15.3, 18),
            Block.box(14, 0, -2, 15, 15.3, -1),
            Block.box(-1, 0, 0, 0, 15.3, 1),
            Block.box(16, 0, 15, 17, 15.3, 16),
            Block.box(0, 0, 16, 1, 15.3, 17),
            Block.box(15, 0, -1, 16, 15.3, 0),
            Block.box(0, 0, -1, 1, 15.3, 0),
            Block.box(15, 0, 16, 16, 15.3, 17),
            Block.box(-1, 0, 15, 0, 15.3, 16),
            Block.box(16, 0, 0, 17, 15.3, 1),
            Block.box(1, 0, -2, 2, 15.3, -1),
            Block.box(14, 0, 17, 15, 15.3, 18),
            Block.box(-2, 0, 14, -1, 15.3, 15),
            Block.box(17, 0, 1, 18, 15.3, 2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape shapeN = Stream.of(
            Block.box(2, 0, -2.4523809523809526, 14, 1, 17.54761904761905),
            Block.box(19, 0, 4.5476190476190474, 20, 15.3, 10.547619047619047),
            Block.box(18, 0, 4.5476190476190474, 19, 1, 10.547619047619047),
            Block.box(-4.000000000000002, 0, 4.5476190476190474, -3.0000000000000018, 15.3, 10.547619047619047),
            Block.box(5, 0, 17.54761904761905, 11, 1, 18.54761904761905),
            Block.box(5, 0, -4.4523809523809526, 11, 15.3, -3.4523809523809526),
            Block.box(5, 0, -3.4523809523809526, 11, 1, -2.4523809523809526),
            Block.box(18, 0, 10.547619047619047, 19, 15.3, 13.547619047619047),
            Block.box(-3.0000000000000018, 0, 1.5476190476190474, -2.0000000000000018, 15.3, 4.5476190476190474),
            Block.box(18, 0, 1.5476190476190474, 19, 15.3, 4.5476190476190474),
            Block.box(-3.0000000000000018, 0, 10.547619047619047, -2.0000000000000018, 15.3, 13.547619047619047),
            Block.box(2, 0, 17.54761904761905, 5, 1, 18.54761904761905),
            Block.box(2, 1, 17.54761904761905, 3, 16.3, 18.54761904761905),
            Block.box(11, 0, -3.4523809523809526, 14, 15.3, -2.4523809523809526),
            Block.box(11, 0, 17.54761904761905, 14, 1, 18.54761904761905),
            Block.box(13, 1, 17.54761904761905, 14, 16.3, 18.54761904761905),
            Block.box(2, 0, -3.4523809523809526, 5, 15.3, -2.4523809523809526),
            Block.box(17, 0, 13.547619047619047, 18, 15.3, 14.547619047619047),
            Block.box(17, 0, 1.5476190476190474, 18, 1, 13.547619047619047),
            Block.box(16, 0, 0.5476190476190474, 17, 1, 14.547619047619047),
            Block.box(15, 0, -0.45238095238095255, 16, 1, 15.547619047619047),
            Block.box(14, 0, -1.4523809523809526, 15, 1, 16.54761904761905),
            Block.box(1, 0, -1.4523809523809526, 2, 1, 16.54761904761905),
            Block.box(0, 0, -0.45238095238095255, 1, 1, 15.547619047619047),
            Block.box(-1.0000000000000018, 0, 0.5476190476190474, 0, 1, 14.547619047619047),
            Block.box(-2.0000000000000018, 0, 1.5476190476190474, -1.0000000000000018, 1, 13.547619047619047),
            Block.box(-3.0000000000000018, 0, 4.5476190476190474, -2.0000000000000018, 1, 10.547619047619047),
            Block.box(-2.0000000000000018, 0, 0.5476190476190474, -1.0000000000000018, 15.3, 1.5476190476190474),
            Block.box(14, 0, -2.4523809523809526, 15, 15.3, -1.4523809523809526),
            Block.box(1, 0, 16.54761904761905, 2, 15.3, 17.54761904761905),
            Block.box(16, 0, 14.547619047619047, 17, 15.3, 15.547619047619047),
            Block.box(-1.0000000000000018, 0, -0.45238095238095255, 0, 15.3, 0.5476190476190474),
            Block.box(15, 0, -1.4523809523809526, 16, 15.3, -0.45238095238095255),
            Block.box(0, 0, 15.547619047619047, 1, 15.3, 16.54761904761905),
            Block.box(15, 0, 15.547619047619047, 16, 15.3, 16.54761904761905),
            Block.box(0, 0, -1.4523809523809526, 1, 15.3, -0.45238095238095255),
            Block.box(16, 0, -0.45238095238095255, 17, 15.3, 0.5476190476190474),
            Block.box(-1.0000000000000018, 0, 14.547619047619047, 0, 15.3, 15.547619047619047),
            Block.box(14, 0, 16.54761904761905, 15, 15.3, 17.54761904761905),
            Block.box(1, 0, -2.4523809523809526, 2, 15.3, -1.4523809523809526),
            Block.box(17, 0, 0.5476190476190474, 18, 15.3, 1.5476190476190474),
            Block.box(-2.0000000000000018, 0, 13.547619047619047, -1.0000000000000018, 15.3, 14.547619047619047)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape shapeW = Stream.of(
            Block.box(-2.2261904761904763, 0, 1.7738095238095237, 17.773809523809526, 1, 13.773809523809524),
            Block.box(4.773809523809524, 0, -4.226190476190476, 10.773809523809524, 15.3, -3.2261904761904763),
            Block.box(4.773809523809524, 0, -3.2261904761904763, 10.773809523809524, 1, -2.2261904761904763),
            Block.box(4.773809523809524, 0, 18.773809523809526, 10.773809523809524, 15.3, 19.773809523809526),
            Block.box(17.773809523809526, 0, 4.773809523809524, 18.773809523809526, 1, 10.773809523809524),
            Block.box(-4.226190476190476, 0, 4.773809523809524, -3.2261904761904763, 15.3, 10.773809523809524),
            Block.box(-3.2261904761904763, 0, 4.773809523809524, -2.2261904761904763, 1, 10.773809523809524),
            Block.box(10.773809523809524, 0, -3.2261904761904763, 13.773809523809524, 15.3, -2.2261904761904763),
            Block.box(1.7738095238095237, 0, 17.773809523809526, 4.773809523809524, 15.3, 18.773809523809526),
            Block.box(1.7738095238095237, 0, -3.2261904761904763, 4.773809523809524, 15.3, -2.2261904761904763),
            Block.box(10.773809523809524, 0, 17.773809523809526, 13.773809523809524, 15.3, 18.773809523809526),
            Block.box(17.773809523809526, 0, 10.773809523809524, 18.773809523809526, 1, 13.773809523809524),
            Block.box(17.773809523809526, 1, 12.773809523809524, 18.773809523809526, 16.3, 13.773809523809524),
            Block.box(-3.2261904761904763, 0, 1.7738095238095237, -2.2261904761904763, 15.3, 4.773809523809524),
            Block.box(17.773809523809526, 0, 1.7738095238095237, 18.773809523809526, 1, 4.773809523809524),
            Block.box(17.773809523809526, 1, 1.7738095238095237, 18.773809523809526, 16.3, 2.7738095238095237),
            Block.box(-3.2261904761904763, 0, 10.773809523809524, -2.2261904761904763, 15.3, 13.773809523809524),
            Block.box(13.773809523809524, 0, -2.2261904761904763, 14.773809523809524, 15.3, -1.2261904761904763),
            Block.box(1.7738095238095237, 0, -2.2261904761904763, 13.773809523809524, 1, -1.2261904761904763),
            Block.box(0.7738095238095237, 0, -1.2261904761904763, 14.773809523809524, 1, -0.22619047619047628),
            Block.box(-0.22619047619047628, 0, -0.22619047619047628, 15.773809523809524, 1, 0.7738095238095237),
            Block.box(-1.2261904761904763, 0, 0.7738095238095237, 16.773809523809526, 1, 1.7738095238095237),
            Block.box(-1.2261904761904763, 0, 13.773809523809524, 16.773809523809526, 1, 14.773809523809524),
            Block.box(-0.22619047619047628, 0, 14.773809523809524, 15.773809523809524, 1, 15.773809523809524),
            Block.box(0.7738095238095237, 0, 15.773809523809524, 14.773809523809524, 1, 16.773809523809526),
            Block.box(1.7738095238095237, 0, 16.773809523809526, 13.773809523809524, 1, 17.773809523809526),
            Block.box(4.773809523809524, 0, 17.773809523809526, 10.773809523809524, 1, 18.773809523809526),
            Block.box(0.7738095238095237, 0, 16.773809523809526, 1.7738095238095237, 15.3, 17.773809523809526),
            Block.box(-2.2261904761904763, 0, 0.7738095238095237, -1.2261904761904763, 15.3, 1.7738095238095237),
            Block.box(16.773809523809526, 0, 13.773809523809524, 17.773809523809526, 15.3, 14.773809523809524),
            Block.box(14.773809523809524, 0, -1.2261904761904763, 15.773809523809524, 15.3, -0.22619047619047628),
            Block.box(-0.22619047619047628, 0, 15.773809523809524, 0.7738095238095237, 15.3, 16.773809523809526),
            Block.box(-1.2261904761904763, 0, -0.22619047619047628, -0.22619047619047628, 15.3, 0.7738095238095237),
            Block.box(15.773809523809524, 0, 14.773809523809524, 16.773809523809526, 15.3, 15.773809523809524),
            Block.box(15.773809523809524, 0, -0.22619047619047628, 16.773809523809526, 15.3, 0.7738095238095237),
            Block.box(-1.2261904761904763, 0, 14.773809523809524, -0.22619047619047628, 15.3, 15.773809523809524),
            Block.box(-0.22619047619047628, 0, -1.2261904761904763, 0.7738095238095237, 15.3, -0.22619047619047628),
            Block.box(14.773809523809524, 0, 15.773809523809524, 15.773809523809524, 15.3, 16.773809523809526),
            Block.box(16.773809523809526, 0, 0.7738095238095237, 17.773809523809526, 15.3, 1.7738095238095237),
            Block.box(-2.2261904761904763, 0, 13.773809523809524, -1.2261904761904763, 15.3, 14.773809523809524),
            Block.box(0.7738095238095237, 0, -2.2261904761904763, 1.7738095238095237, 15.3, -1.2261904761904763),
            Block.box(13.773809523809524, 0, 16.773809523809526, 14.773809523809524, 15.3, 17.773809523809526)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape shapeE = Stream.of(
            Block.box(-1.7738095238095273, 0, 1.7738095238095237, 18.226190476190474, 1, 13.773809523809524),
            Block.box(5.226190476190476, 0, 18.773809523809526, 11.226190476190476, 15.3, 19.773809523809526),
            Block.box(5.226190476190476, 0, 17.773809523809526, 11.226190476190476, 1, 18.773809523809526),
            Block.box(5.226190476190476, 0, -4.226190476190478, 11.226190476190476, 15.3, -3.226190476190478),
            Block.box(-2.7738095238095273, 0, 4.773809523809524, -1.7738095238095273, 1, 10.773809523809524),
            Block.box(19.226190476190474, 0, 4.773809523809524, 20.226190476190474, 15.3, 10.773809523809524),
            Block.box(18.226190476190474, 0, 4.773809523809524, 19.226190476190474, 1, 10.773809523809524),
            Block.box(2.2261904761904763, 0, 17.773809523809526, 5.226190476190476, 15.3, 18.773809523809526),
            Block.box(11.226190476190476, 0, -3.226190476190478, 14.226190476190476, 15.3, -2.226190476190478),
            Block.box(11.226190476190476, 0, 17.773809523809526, 14.226190476190476, 15.3, 18.773809523809526),
            Block.box(2.2261904761904763, 0, -3.226190476190478, 5.226190476190476, 15.3, -2.226190476190478),
            Block.box(-2.7738095238095273, 0, 1.7738095238095237, -1.7738095238095273, 1, 4.773809523809524),
            Block.box(-2.7738095238095273, 1, 1.7738095238095237, -1.7738095238095273, 16.3, 2.7738095238095237),
            Block.box(18.226190476190474, 0, 10.773809523809524, 19.226190476190474, 15.3, 13.773809523809524),
            Block.box(-2.7738095238095273, 0, 10.773809523809524, -1.7738095238095273, 1, 13.773809523809524),
            Block.box(-2.7738095238095273, 1, 12.773809523809524, -1.7738095238095273, 16.3, 13.773809523809524),
            Block.box(18.226190476190474, 0, 1.7738095238095237, 19.226190476190474, 15.3, 4.773809523809524),
            Block.box(1.2261904761904763, 0, 16.773809523809526, 2.2261904761904763, 15.3, 17.773809523809526),
            Block.box(2.2261904761904763, 0, 16.773809523809526, 14.226190476190476, 1, 17.773809523809526),
            Block.box(1.2261904761904763, 0, 15.773809523809524, 15.226190476190476, 1, 16.773809523809526),
            Block.box(0.22619047619047628, 0, 14.773809523809524, 16.226190476190474, 1, 15.773809523809524),
            Block.box(-0.7738095238095273, 0, 13.773809523809524, 17.226190476190474, 1, 14.773809523809524),
            Block.box(-0.7738095238095273, 0, 0.7738095238095237, 17.226190476190474, 1, 1.7738095238095237),
            Block.box(0.22619047619047628, 0, -0.22619047619047628, 16.226190476190474, 1, 0.7738095238095237),
            Block.box(1.2261904761904763, 0, -1.226190476190478, 15.226190476190476, 1, -0.22619047619047628),
            Block.box(2.2261904761904763, 0, -2.226190476190478, 14.226190476190476, 1, -1.226190476190478),
            Block.box(5.226190476190476, 0, -3.226190476190478, 11.226190476190476, 1, -2.226190476190478),
            Block.box(14.226190476190476, 0, -2.226190476190478, 15.226190476190476, 15.3, -1.226190476190478),
            Block.box(17.226190476190474, 0, 13.773809523809524, 18.226190476190474, 15.3, 14.773809523809524),
            Block.box(-1.7738095238095273, 0, 0.7738095238095237, -0.7738095238095273, 15.3, 1.7738095238095237),
            Block.box(0.22619047619047628, 0, 15.773809523809524, 1.2261904761904763, 15.3, 16.773809523809526),
            Block.box(15.226190476190476, 0, -1.226190476190478, 16.226190476190474, 15.3, -0.22619047619047628),
            Block.box(16.226190476190474, 0, 14.773809523809524, 17.226190476190474, 15.3, 15.773809523809524),
            Block.box(-0.7738095238095273, 0, -0.22619047619047628, 0.22619047619047628, 15.3, 0.7738095238095237),
            Block.box(-0.7738095238095273, 0, 14.773809523809524, 0.22619047619047628, 15.3, 15.773809523809524),
            Block.box(16.226190476190474, 0, -0.22619047619047628, 17.226190476190474, 15.3, 0.7738095238095237),
            Block.box(15.226190476190476, 0, 15.773809523809524, 16.226190476190474, 15.3, 16.773809523809526),
            Block.box(0.22619047619047628, 0, -1.226190476190478, 1.2261904761904763, 15.3, -0.22619047619047628),
            Block.box(-1.7738095238095273, 0, 13.773809523809524, -0.7738095238095273, 15.3, 14.773809523809524),
            Block.box(17.226190476190474, 0, 0.7738095238095237, 18.226190476190474, 15.3, 1.7738095238095237),
            Block.box(14.226190476190476, 0, 16.773809523809526, 15.226190476190476, 15.3, 17.773809523809526),
            Block.box(1.2261904761904763, 0, -2.226190476190478, 2.2261904761904763, 15.3, -1.226190476190478)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape blockShape = Block.box(0, 0, 0, 16, 16, 16);

    public Scanner() {
        super(Block.Properties.of(Material.METAL)

                .strength(10, 10)
                .sound(SoundType.METAL)
                .randomTicks()



        );

        this.registerDefaultState(this.defaultBlockState().setValue(Scanner, false).setValue(directionProperty, Direction.NORTH));
    }


    @Override
    public void randomTick(final BlockState pState, final ServerLevel pLevel, final BlockPos pPos, final Random pRandom) {
        super.randomTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public boolean isRandomlyTicking(final BlockState pState) {
        return true;
    }

    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, BlockGetter pLevel, BlockPos pPos) {

            switch (state.getValue(directionProperty)) {
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

    }



    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return ModTileEntities.SCANNER_TILE_ENTITY.get().create(pos, state);
    }


    @Override
    public @NotNull RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull VoxelShape getVisualShape(@NotNull BlockState state, BlockGetter p_60480_, BlockPos p_60481_, CollisionContext p_60482_) {

            switch (state.getValue(directionProperty)) {
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

    }

    @Nonnull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        if (state.getValue(Scanner)) {
            switch (state.getValue(directionProperty)) {
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



    @Override
    public @NotNull BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(directionProperty, context.getHorizontalDirection());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(@NotNull BlockState state, @NotNull Rotation rot) {
        return state.setValue(directionProperty, rot.rotate(state.getValue(directionProperty)));
    }


    @Nonnull
    @Override
    public BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(directionProperty)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(Scanner).add(directionProperty);



    }

    @Override
    public void animateTick(final BlockState pState, final Level pLevel, final BlockPos pPos, final Random pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);
    }





    @Override
    public boolean canEntityDestroy(final BlockState state, final BlockGetter level, final BlockPos pos, final Entity entity) {

        return entity instanceof Player;


    }



    @Override
    public boolean onDestroyedByPlayer(final BlockState state, final Level level, final BlockPos pos, final Player player, final boolean willHarvest, final FluidState fluid) {
       if (level.getBlockEntity(pos) instanceof ScannerTileEntity scannerTile)
       {

           scannerTile.invalidateEntity();


       }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }




    @Override
    public @NotNull InteractionResult use(final @NotNull BlockState pState, final Level pLevel, final @NotNull BlockPos pPos, final @NotNull Player pPlayer, final @NotNull InteractionHand pHand, final BlockHitResult pHit) {
/*
        if(pLevel.getBlockEntity(pPos) instanceof ScannerTileEntity scannerTile)
        {
            if(!pLevel.isClientSide) {
                pPlayer.sendMessage(new TextComponent("Checking for valid placement"), pPlayer.getUUID());
                if (scannerTile.check()) {

                    if (!FMLEnvironment.production) {
                        pPlayer.sendMessage(new TextComponent("Scanner check " + scannerTile.check()), pPlayer.getUUID());
                    } else {
                        pPlayer.sendMessage(new TextComponent("scanner formed"), pPlayer.getUUID());
                    }
                    pLevel.getCapability(CapabilityRegistration.BLOCK_ENTITY_CAP).ifPresent(cap -> cap.setThispos(scannerTile));
                } else {
                    pLevel.getCapability(CapabilityRegistration.BLOCK_ENTITY_CAP).ifPresent(cap -> cap.removePos(scannerTile));
                }
            }


           // scannerTile.getLevel().getCapability(CapabilityRegistration.BLOCK_ENTITY_CAP).ifPresent(cap -> cap.setThispos(pLevel.getBlockEntity(pPos)));
            //CodeLyokoMain.Log.info("used");
            return InteractionResult.SUCCESS;
        }
        else
        {
            return InteractionResult.FAIL;
        }


        if(pLevel.getBlockEntity(pPos) instanceof ScannerTileEntity tileEntity && !pLevel.isClientSide)
        {
            if(!pPlayer.isCreative() && pPlayer.getItemInHand(pHand).getItem() == ModItems.TRUSTTY_SCREWDRIVER.get()) {
                checkStruct(tileEntity, pPos, (ServerLevel) pLevel);
                return InteractionResult.SUCCESS;
            }
            else if(pPlayer.isCreative())
            {
                checkStruct(tileEntity, pPos, (ServerLevel) pLevel);
                return InteractionResult.SUCCESS;

            }
            else
            {
                return InteractionResult.FAIL;
            }
        }

 */
        return InteractionResult.FAIL;



    }


    /*
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable


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

 */
}
