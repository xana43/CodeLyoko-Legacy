package com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.CableBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CableBlock extends HorizontalConnectingBlock implements BlockEntityProvider {

//    private final static Map<CableBlock, LinkedList<CableBlock>> CABLE_LISTS = new HashMap<>();
//    private CableBlock startOfCable;
    private static final BooleanProperty isMaster = BooleanProperty.of("is_master");
    private final VoxelShape @NotNull [] shape;
    private final VoxelShape mainShape = Block.createCuboidShape(1, 0, 1, 15, 14, 15);

    public CableBlock(final Settings settings) {
        super(2.0F, 2.0F, 16.0F, 16.0F, 24.0F, settings);
        this.shape = this.createShapes(10, 10, 10, 10, 10);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, Boolean.FALSE).with(isMaster, Boolean.FALSE));
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(NORTH, SOUTH, EAST, WEST, WATERLOGGED,isMaster));
    }

    @Override
    public void neighborUpdate(final BlockState state, final World world, final BlockPos pos, final Block sourceBlock, final BlockPos sourcePos, final boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
        world.getBlockEntity(pos, ModBlockEntities.CABLE_TILE_ENTITY_BLOCK_ENTITY_TYPE).get().checkIfEnd();
        CodeLyokoMain.LOG.info("should update if end");
    }

    @Override
    public void onBreak(final World world, final BlockPos pos, final BlockState state, final PlayerEntity player) {
        for (final Direction dir : Direction.values())
        {
            final BlockPos nextPosition = pos.offset(dir,1);
            if(world != null && !world.isClient()) {
                if (!world.getBlockState(pos).<Boolean>get(isMaster).booleanValue() && world.getBlockEntity(nextPosition) != null && world.getBlockState(pos)
                        .isOf(ModBlocks.CABLE_BLOCK)) {
                    if (world.getBlockEntity(nextPosition) instanceof CableBlockEntity cableBlockEntity) {
                        if (cableBlockEntity.getIsMaster()) {
                            CableBlockEntity.removeFromMaster(pos, nextPosition, world);
                        }
                    }
                }
            }
        }
        super.onBreak(world, pos, state, player);
    }

/*
    @Override
    public void onPlaced(final World world, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack itemStack) {
        final CableBlockEntity thisTE = (CableBlockEntity) world.getBlockEntity(pos);
        CableBlockEntity.CONNECTIONS.put(thisTE, new ArrayList<>());
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    if (!(x == 0 && y == 0 && z == 0)) {
                        final BlockEntity surrounding = world.getBlockEntity(new BlockPos(pos.getX() + x,
                                pos.getY() + y, pos.getZ() + z));
                        if (surrounding instanceof CableBlockEntity) {
                            if (CableBlockEntity.CONNECTIONS.containsKey(surrounding)) {
                                CableBlockEntity.CONNECTIONS.get(surrounding).add(world.getBlockEntity(pos));
                                CableBlockEntity.CONNECTIONS.get(thisTE).add(surrounding);
                            }
                        }
                        if (surrounding instanceof ScannerTileEntity) {
                            CableBlockEntity.CONNECTIONS.get(thisTE).add(surrounding);
                            thisTE.connectToScanner();
                        }
                        if (surrounding instanceof ComputerControlPanelTileEntity) {
                            CableBlockEntity.CONNECTIONS.get(thisTE).add(surrounding);
                            thisTE.connectToComp();
                        }
                        if(surrounding instanceof RouterTE)
                        {
                            CableBlockEntity.CONNECTIONS.get(thisTE).add(surrounding);
                            thisTE.connectedToRouter();
                        }
                    }
                }
            }
        }

    }

 */

    @Override
    public void onPlaced(final World world, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack itemStack) {
        if(world.getBlockEntity(pos)instanceof final CableBlockEntity cableBlockEntity && !world.isClient())
        {
            cableBlockEntity.calculateConnected();
            if(cableBlockEntity.getIsMaster())
            {
                world.setBlockState(pos,state.with(isMaster, Boolean.TRUE));
            }
            else
            {
                cableBlockEntity.checkIfEnd();
                cableBlockEntity.propogateCheck(1);
            }
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }


    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(WATERLOGGED,
                Boolean.valueOf(ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER));
    }



    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.CABLE_TILE_ENTITY_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(final BlockState state, final Direction direction, final BlockState neighborState, final WorldAccess world, final BlockPos pos, final BlockPos neighborPos) {
        if (state.<Boolean>get(WATERLOGGED).booleanValue())
        {
            world.scheduleFluidTick(pos,Fluids.WATER,Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return mainShape;
    }
    /*

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModBlockEntities.CABLE_TILE_ENTITY.get().create();
    }

    private boolean sameState(BlockState state)
    {
        return state.getBlock() == ModBlocks.COMPUTER_SCREEN_FRAME.get() || state.getBlock() == ModBlocks.COMPUTER_SCREEN.get() || state.getBlock() == ModBlocks.COMPUTER_SCREEN_CONNECTOR.get();
    }



    @Override
    public boolean canConnect(final BlockState pState, final boolean pIsSideSolid, final Direction pDirection) {
        //return super.connectsTo(pState, pIsSideSolid, pDirection);
        //final Block blocks = pState.getBlock();
        final boolean valid = this.sameState(pState);
        return  !isExceptionForConnection(pState) && (pIsSideSolid || valid);

    }


    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return mainShape;
    }














/*
    @Override
    public void setPlacedBy(@Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull BlockState state, LivingEntity placer, @Nonnull ItemStack stack) {
        CableBlockEntity thisTE = (CableBlockEntity) worldIn.getBlockEntity(pos);
        CableBlockEntity.CONNECTIONS.put(thisTE, new ArrayList<>());
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    if (!(x == 0 && y == 0 && z == 0)) {
                        BlockEntityCapabilit surrounding = worldIn.getBlockEntity(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z));
                        if (surrounding instanceof CableBlockEntity) {
                            if (CableBlockEntity.CONNECTIONS.containsKey(surrounding)) {
                                CableBlockEntity.CONNECTIONS.get(surrounding).add(worldIn.getBlockEntity(pos));
                                CableBlockEntity.CONNECTIONS.get(thisTE).add(surrounding);
                            }
                        }
                        if (surrounding instanceof ScannerTileEntity) {
                            CableBlockEntity.CONNECTIONS.get(thisTE).add(surrounding);
                            thisTE.connectToScanner();
                        }
                        if (surrounding instanceof ComputerControlPanelTileEntity) {
                            CableBlockEntity.CONNECTIONS.get(thisTE).add(surrounding);
                            thisTE.connectToComp();
                        }
                    }
                }
            }
        }
    }

 */


}
