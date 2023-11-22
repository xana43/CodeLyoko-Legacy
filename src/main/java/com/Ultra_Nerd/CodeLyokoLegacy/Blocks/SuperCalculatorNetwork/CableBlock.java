package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.SuperCalculatorNetwork;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperComputerNetwork.CableBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.SuperCalculatorDataPackets;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public final class CableBlock extends Block implements BlockEntityProvider {

//    private final static Map<CableBlock, LinkedList<CableBlock>> CABLE_LISTS = new HashMap<>();
//    private CableBlock startOfCable;

    //private final VoxelShape @NotNull [] shape;
    private final VoxelShape mainShape = Block.createCuboidShape(1, 0, 1, 15, 14, 15);

    public CableBlock(final Settings settings) {
        super(settings);
        //super(2.0F, 2.0F, 16.0F, 16.0F, 24.0F, settings);
        //this.shape = this.createShapes(10, 10, 10, 10, 10);
        //this.setDefaultState(this.getDefaultState().with(WATERLOGGED, Boolean.FALSE));
    }

   /* @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(NORTH, SOUTH, EAST, WEST, WATERLOGGED));
    }*/

    /*@Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(WATERLOGGED,
                Boolean.valueOf(ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER));
    }*/

    @Override
    public void onPlaced(final World world, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if(world.getBlockEntity(pos) instanceof final CableBlockEntity cableBlockEntity && !world.isClient())
        {
            cableBlockEntity.checkPhysicalConnection();
        }
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.CABLE_TILE_ENTITY_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(final BlockState state, final Direction direction, final BlockState neighborState, final WorldAccess world, final BlockPos pos, final BlockPos neighborPos) {
      //  if (state.<Boolean>get(WATERLOGGED).booleanValue())
      //  {
      //      world.scheduleFluidTick(pos,Fluids.WATER,Fluids.WATER.getTickRate(world));
      //  }
        if(neighborState != Blocks.AIR.getDefaultState() && !world.isClient())
        {
            if(world.getBlockEntity(pos) instanceof final CableBlockEntity cableBlockEntity)
            {
                cableBlockEntity.checkPhysicalConnection();
            }
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {
        if(world.getBlockEntity(pos) instanceof final CableBlockEntity blockEntity && !world.isClient())
        {
            blockEntity.transferData(0, SuperCalculatorDataPackets.NumberTest);

        }
        return ActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return mainShape;
    }


    @Override
    public void onBreak(final World world, final BlockPos pos, final BlockState state, final PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        if(world.getBlockEntity(pos) instanceof final CableBlockEntity cableBlockEntity && !world.isClient())
        {
            cableBlockEntity.removeFromNetwork();
        }
    }

    @Override
    public void onStateReplaced(final BlockState state, final World world, final BlockPos pos, final BlockState newState, final boolean moved) {
        super.onStateReplaced(state, world, pos, newState, moved);
        if(world.getBlockEntity(pos) instanceof final CableBlockEntity cableBlockEntity && !world.isClient())
        {
            cableBlockEntity.removeFromNetwork();
        }
    }

    @Override
    public void neighborUpdate(final BlockState state, final World world, final BlockPos pos, final Block sourceBlock, final BlockPos sourcePos, final boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }
}
