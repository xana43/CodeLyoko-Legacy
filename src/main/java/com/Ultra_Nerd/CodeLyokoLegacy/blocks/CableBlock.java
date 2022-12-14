package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalConnectingBlock;
import net.minecraft.state.StateManager;
import net.minecraft.util.shape.VoxelShape;
import org.jetbrains.annotations.NotNull;

public final class CableBlock extends HorizontalConnectingBlock {

//    private final static Map<CableBlock, LinkedList<CableBlock>> CABLE_LISTS = new HashMap<>();
//    private CableBlock startOfCable;

    private final VoxelShape @NotNull [] shape;
    private final VoxelShape mainShape = Block.createCuboidShape(1, 0, 1, 15, 14, 15);

    public CableBlock(final Settings settings) {
        super(2.0F, 2.0F, 16.0F, 16.0F, 24.0F, settings);
        this.shape = this.createShapes(10, 10, 10, 10, 10);
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(NORTH, SOUTH, EAST, WEST, WATERLOGGED));
    }


    /*

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.CABLE_TILE_ENTITY.get().create();
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
        CableTileEntity thisTE = (CableTileEntity) worldIn.getBlockEntity(pos);
        CableTileEntity.CONNECTIONS.put(thisTE, new ArrayList<>());
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    if (!(x == 0 && y == 0 && z == 0)) {
                        BlockEntityCapabilit surrounding = worldIn.getBlockEntity(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z));
                        if (surrounding instanceof CableTileEntity) {
                            if (CableTileEntity.CONNECTIONS.containsKey(surrounding)) {
                                CableTileEntity.CONNECTIONS.get(surrounding).add(worldIn.getBlockEntity(pos));
                                CableTileEntity.CONNECTIONS.get(thisTE).add(surrounding);
                            }
                        }
                        if (surrounding instanceof ScannerTileEntity) {
                            CableTileEntity.CONNECTIONS.get(thisTE).add(surrounding);
                            thisTE.connectToScanner();
                        }
                        if (surrounding instanceof ComputerControlPanelTileEntity) {
                            CableTileEntity.CONNECTIONS.get(thisTE).add(surrounding);
                            thisTE.connectToComp();
                        }
                    }
                }
            }
        }
    }

 */


}
