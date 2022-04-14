package com.Ultra_Nerd.CodeLyokoRemake15.blocks.SuperCalculator;

import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.QuantumChipletTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class FranzChiplet extends BaseEntityBlock {
    private final static VoxelShape shape = Stream.of(
            Block.box(4, 4, 0, 5, 5, 1),
            Block.box(0, 0, 0, 4, 16, 2),
            Block.box(0, 0, 14, 4, 16, 16),
            Block.box(12, 0, 14, 16, 16, 16),
            Block.box(12, 0, 0, 16, 16, 2),
            Block.box(0, 0, 12, 2, 16, 14),
            Block.box(14, 0, 12, 16, 16, 14),
            Block.box(14, 0, 2, 16, 16, 4),
            Block.box(0, 0, 2, 2, 16, 4),
            Block.box(14, 0, 4, 16, 4, 12),
            Block.box(0, 0, 4, 2, 4, 12),
            Block.box(4, 0, 0, 12, 4, 2),
            Block.box(4, 0, 14, 12, 4, 16),
            Block.box(14, 12, 4, 16, 16, 12),
            Block.box(0, 12, 4, 2, 16, 12),
            Block.box(4, 12, 0, 12, 16, 2),
            Block.box(4, 12, 14, 12, 16, 16),
            Block.box(10, 14, 2, 11, 16, 3),
            Block.box(10, 0, 2, 11, 2, 3),
            Block.box(5, 14, 2, 6, 16, 3),
            Block.box(5, 0, 2, 6, 2, 3),
            Block.box(5, 14, 13, 6, 16, 14),
            Block.box(5, 0, 13, 6, 2, 14),
            Block.box(11, 14, 2, 13, 16, 4),
            Block.box(11, 0, 2, 13, 2, 4),
            Block.box(11, 14, 12, 13, 16, 14),
            Block.box(11, 0, 12, 13, 2, 14),
            Block.box(3, 14, 2, 5, 16, 4),
            Block.box(3, 0, 2, 5, 2, 4),
            Block.box(3, 14, 12, 5, 16, 14),
            Block.box(3, 0, 12, 5, 2, 14),
            Block.box(12, 14, 4, 13, 16, 5),
            Block.box(12, 0, 4, 13, 2, 5),
            Block.box(12, 14, 11, 13, 16, 12),
            Block.box(12, 0, 11, 13, 2, 12),
            Block.box(3, 14, 4, 4, 16, 5),
            Block.box(3, 0, 4, 4, 2, 5),
            Block.box(3, 14, 11, 4, 16, 12),
            Block.box(10, 14, 6, 14, 15, 10),
            Block.box(10, 1, 6, 14, 2, 10),
            Block.box(10, 14, 10, 13, 15, 11),
            Block.box(10, 1, 10, 13, 2, 11),
            Block.box(3, 14, 10, 6, 15, 11),
            Block.box(3, 1, 10, 6, 2, 11),
            Block.box(3, 14, 5, 6, 15, 6),
            Block.box(3, 1, 5, 6, 2, 6),
            Block.box(10, 14, 5, 13, 15, 6),
            Block.box(10, 1, 5, 13, 2, 6),
            Block.box(10, 14, 4, 12, 15, 5),
            Block.box(10, 1, 4, 12, 2, 5),
            Block.box(10, 14, 11, 12, 15, 12),
            Block.box(10, 1, 11, 12, 2, 12),
            Block.box(4, 14, 11, 6, 15, 12),
            Block.box(4, 1, 11, 6, 2, 12),
            Block.box(4, 14, 4, 6, 15, 5),
            Block.box(4, 1, 4, 6, 2, 5),
            Block.box(5, 14, 3, 6, 15, 4),
            Block.box(5, 1, 3, 6, 2, 4),
            Block.box(5, 14, 12, 6, 15, 13),
            Block.box(5, 1, 12, 6, 2, 13),
            Block.box(10, 14, 12, 11, 15, 13),
            Block.box(10, 1, 12, 11, 2, 13),
            Block.box(10, 14, 3, 11, 15, 4),
            Block.box(10, 1, 3, 11, 2, 4),
            Block.box(2, 14, 6, 6, 15, 10),
            Block.box(2, 1, 6, 6, 2, 10),
            Block.box(6, 14, 2, 10, 15, 14),
            Block.box(6, 1, 2, 10, 2, 14),
            Block.box(3, 0, 11, 4, 2, 12),
            Block.box(13, 14, 2, 14, 16, 6),
            Block.box(13, 0, 2, 14, 2, 6),
            Block.box(13, 14, 10, 14, 16, 14),
            Block.box(13, 0, 10, 14, 2, 14),
            Block.box(10, 14, 13, 11, 16, 14),
            Block.box(10, 0, 13, 11, 2, 14),
            Block.box(2, 14, 2, 3, 16, 6),
            Block.box(2, 0, 2, 3, 2, 6),
            Block.box(2, 14, 10, 3, 16, 14),
            Block.box(2, 0, 10, 3, 2, 14),
            Block.box(0, 4, 5, 1, 5, 11),
            Block.box(0, 4, 4, 1, 5, 5),
            Block.box(15, 4, 5, 16, 5, 11),
            Block.box(0, 11, 5, 1, 12, 11),
            Block.box(0, 11, 4, 1, 12, 5),
            Block.box(15, 11, 4, 16, 12, 5),
            Block.box(0, 11, 11, 1, 12, 12),
            Block.box(15, 11, 5, 16, 12, 11),
            Block.box(15, 4, 4, 16, 5, 5),
            Block.box(0, 4, 11, 1, 5, 12),
            Block.box(15, 4, 11, 16, 5, 12),
            Block.box(0, 5, 4, 1, 11, 12),
            Block.box(15, 5, 4, 16, 11, 12),
            Block.box(15, 11, 11, 16, 12, 12),
            Block.box(4, 5, 15, 12, 11, 16),
            Block.box(4, 5, 0, 12, 11, 1),
            Block.box(5, 11, 15, 11, 12, 16),
            Block.box(4, 11, 15, 5, 12, 16),
            Block.box(5, 11, 0, 11, 12, 1),
            Block.box(4, 11, 0, 5, 12, 1),
            Block.box(11, 11, 15, 12, 12, 16),
            Block.box(11, 11, 0, 12, 12, 1),
            Block.box(11, 4, 0, 12, 5, 1),
            Block.box(11, 4, 15, 12, 5, 16),
            Block.box(5, 4, 15, 11, 5, 16),
            Block.box(4, 4, 15, 5, 5, 16),
            Block.box(5, 4, 0, 11, 5, 1)
    ).reduce((v1, v2) -> {
        return Shapes.join(v1, v2, BooleanOp.OR);
    }).get();

    public FranzChiplet() {
        super(Block.Properties.copy(Blocks.IRON_BLOCK));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return shape;
    }



    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return null;//ModTileEntities.QUANTUM_CHIPLET_TILE_ENTITY.get().create(pos, state);
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, @NotNull Level worldIn, @Nonnull BlockPos pos, @Nonnull Player player, @Nonnull InteractionHand handIn, @Nonnull BlockHitResult result) {
        if (worldIn.isClientSide) {
            BlockEntity Chiplet = worldIn.getBlockEntity(pos);
            if (Chiplet instanceof QuantumChipletTileEntity) {

                //NetworkHooks.openGui((ServerPlayer) player, (QuantumChipletTileEntity) Chiplet, pos);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }


    @Override
    public void onRemove(@NotNull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @NotNull BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity tile1 = worldIn.getBlockEntity(pos);
            if (tile1 instanceof QuantumChipletTileEntity) {
                Containers.dropContents(worldIn, pos, ((QuantumChipletTileEntity) tile1).getItems());
            }
        }
    }

}
