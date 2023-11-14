package com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public final class FranzChiplet extends BlockWithEntity {
    private final static VoxelShape shape = Stream.of(
            Block.createCuboidShape(4, 4, 0, 5, 5, 1),
            Block.createCuboidShape(0, 0, 0, 4, 16, 2),
            Block.createCuboidShape(0, 0, 14, 4, 16, 16),
            Block.createCuboidShape(12, 0, 14, 16, 16, 16),
            Block.createCuboidShape(12, 0, 0, 16, 16, 2),
            Block.createCuboidShape(0, 0, 12, 2, 16, 14),
            Block.createCuboidShape(14, 0, 12, 16, 16, 14),
            Block.createCuboidShape(14, 0, 2, 16, 16, 4),
            Block.createCuboidShape(0, 0, 2, 2, 16, 4),
            Block.createCuboidShape(14, 0, 4, 16, 4, 12),
            Block.createCuboidShape(0, 0, 4, 2, 4, 12),
            Block.createCuboidShape(4, 0, 0, 12, 4, 2),
            Block.createCuboidShape(4, 0, 14, 12, 4, 16),
            Block.createCuboidShape(14, 12, 4, 16, 16, 12),
            Block.createCuboidShape(0, 12, 4, 2, 16, 12),
            Block.createCuboidShape(4, 12, 0, 12, 16, 2),
            Block.createCuboidShape(4, 12, 14, 12, 16, 16),
            Block.createCuboidShape(10, 14, 2, 11, 16, 3),
            Block.createCuboidShape(10, 0, 2, 11, 2, 3),
            Block.createCuboidShape(5, 14, 2, 6, 16, 3),
            Block.createCuboidShape(5, 0, 2, 6, 2, 3),
            Block.createCuboidShape(5, 14, 13, 6, 16, 14),
            Block.createCuboidShape(5, 0, 13, 6, 2, 14),
            Block.createCuboidShape(11, 14, 2, 13, 16, 4),
            Block.createCuboidShape(11, 0, 2, 13, 2, 4),
            Block.createCuboidShape(11, 14, 12, 13, 16, 14),
            Block.createCuboidShape(11, 0, 12, 13, 2, 14),
            Block.createCuboidShape(3, 14, 2, 5, 16, 4),
            Block.createCuboidShape(3, 0, 2, 5, 2, 4),
            Block.createCuboidShape(3, 14, 12, 5, 16, 14),
            Block.createCuboidShape(3, 0, 12, 5, 2, 14),
            Block.createCuboidShape(12, 14, 4, 13, 16, 5),
            Block.createCuboidShape(12, 0, 4, 13, 2, 5),
            Block.createCuboidShape(12, 14, 11, 13, 16, 12),
            Block.createCuboidShape(12, 0, 11, 13, 2, 12),
            Block.createCuboidShape(3, 14, 4, 4, 16, 5),
            Block.createCuboidShape(3, 0, 4, 4, 2, 5),
            Block.createCuboidShape(3, 14, 11, 4, 16, 12),
            Block.createCuboidShape(10, 14, 6, 14, 15, 10),
            Block.createCuboidShape(10, 1, 6, 14, 2, 10),
            Block.createCuboidShape(10, 14, 10, 13, 15, 11),
            Block.createCuboidShape(10, 1, 10, 13, 2, 11),
            Block.createCuboidShape(3, 14, 10, 6, 15, 11),
            Block.createCuboidShape(3, 1, 10, 6, 2, 11),
            Block.createCuboidShape(3, 14, 5, 6, 15, 6),
            Block.createCuboidShape(3, 1, 5, 6, 2, 6),
            Block.createCuboidShape(10, 14, 5, 13, 15, 6),
            Block.createCuboidShape(10, 1, 5, 13, 2, 6),
            Block.createCuboidShape(10, 14, 4, 12, 15, 5),
            Block.createCuboidShape(10, 1, 4, 12, 2, 5),
            Block.createCuboidShape(10, 14, 11, 12, 15, 12),
            Block.createCuboidShape(10, 1, 11, 12, 2, 12),
            Block.createCuboidShape(4, 14, 11, 6, 15, 12),
            Block.createCuboidShape(4, 1, 11, 6, 2, 12),
            Block.createCuboidShape(4, 14, 4, 6, 15, 5),
            Block.createCuboidShape(4, 1, 4, 6, 2, 5),
            Block.createCuboidShape(5, 14, 3, 6, 15, 4),
            Block.createCuboidShape(5, 1, 3, 6, 2, 4),
            Block.createCuboidShape(5, 14, 12, 6, 15, 13),
            Block.createCuboidShape(5, 1, 12, 6, 2, 13),
            Block.createCuboidShape(10, 14, 12, 11, 15, 13),
            Block.createCuboidShape(10, 1, 12, 11, 2, 13),
            Block.createCuboidShape(10, 14, 3, 11, 15, 4),
            Block.createCuboidShape(10, 1, 3, 11, 2, 4),
            Block.createCuboidShape(2, 14, 6, 6, 15, 10),
            Block.createCuboidShape(2, 1, 6, 6, 2, 10),
            Block.createCuboidShape(6, 14, 2, 10, 15, 14),
            Block.createCuboidShape(6, 1, 2, 10, 2, 14),
            Block.createCuboidShape(3, 0, 11, 4, 2, 12),
            Block.createCuboidShape(13, 14, 2, 14, 16, 6),
            Block.createCuboidShape(13, 0, 2, 14, 2, 6),
            Block.createCuboidShape(13, 14, 10, 14, 16, 14),
            Block.createCuboidShape(13, 0, 10, 14, 2, 14),
            Block.createCuboidShape(10, 14, 13, 11, 16, 14),
            Block.createCuboidShape(10, 0, 13, 11, 2, 14),
            Block.createCuboidShape(2, 14, 2, 3, 16, 6),
            Block.createCuboidShape(2, 0, 2, 3, 2, 6),
            Block.createCuboidShape(2, 14, 10, 3, 16, 14),
            Block.createCuboidShape(2, 0, 10, 3, 2, 14),
            Block.createCuboidShape(0, 4, 5, 1, 5, 11),
            Block.createCuboidShape(0, 4, 4, 1, 5, 5),
            Block.createCuboidShape(15, 4, 5, 16, 5, 11),
            Block.createCuboidShape(0, 11, 5, 1, 12, 11),
            Block.createCuboidShape(0, 11, 4, 1, 12, 5),
            Block.createCuboidShape(15, 11, 4, 16, 12, 5),
            Block.createCuboidShape(0, 11, 11, 1, 12, 12),
            Block.createCuboidShape(15, 11, 5, 16, 12, 11),
            Block.createCuboidShape(15, 4, 4, 16, 5, 5),
            Block.createCuboidShape(0, 4, 11, 1, 5, 12),
            Block.createCuboidShape(15, 4, 11, 16, 5, 12),
            Block.createCuboidShape(0, 5, 4, 1, 11, 12),
            Block.createCuboidShape(15, 5, 4, 16, 11, 12),
            Block.createCuboidShape(15, 11, 11, 16, 12, 12),
            Block.createCuboidShape(4, 5, 15, 12, 11, 16),
            Block.createCuboidShape(4, 5, 0, 12, 11, 1),
            Block.createCuboidShape(5, 11, 15, 11, 12, 16),
            Block.createCuboidShape(4, 11, 15, 5, 12, 16),
            Block.createCuboidShape(5, 11, 0, 11, 12, 1),
            Block.createCuboidShape(4, 11, 0, 5, 12, 1),
            Block.createCuboidShape(11, 11, 15, 12, 12, 16),
            Block.createCuboidShape(11, 11, 0, 12, 12, 1),
            Block.createCuboidShape(11, 4, 0, 12, 5, 1),
            Block.createCuboidShape(11, 4, 15, 12, 5, 16),
            Block.createCuboidShape(5, 4, 15, 11, 5, 16),
            Block.createCuboidShape(4, 4, 15, 5, 5, 16),
            Block.createCuboidShape(5, 4, 0, 11, 5, 1)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public FranzChiplet(final Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.QUANTUM_CHIPLET_TILE_ENTITY_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }

    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return shape;
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {
        if(world.isClient) return ActionResult.SUCCESS;
        final Inventory entityInventory = (Inventory) world.getBlockEntity(pos);
        if(!player.getStackInHand(hand).isEmpty())
        {
            if(entityInventory.getStack(0).isEmpty())
            {
                entityInventory.setStack(0,player.getStackInHand(hand).copy());
                player.getStackInHand(hand).setCount(0);
            }
        }
        else {
            if(!entityInventory.getStack(0).isEmpty())
            {
                player.getInventory().offerOrDrop(entityInventory.getStack(0));
                entityInventory.removeStack(0);
            }
        }
        return ActionResult.SUCCESS;
    }



}
