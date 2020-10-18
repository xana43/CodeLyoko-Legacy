package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.CableTileEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ComputerControlPanelTileEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ScannerTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;

public class CableBlock extends FenceBlock {

//    private final static Map<CableBlock, LinkedList<CableBlock>> CABLE_LISTS = new HashMap<>();
//    private CableBlock startOfCable;

    private final VoxelShape[] shape;
    private final VoxelShape mainShape = Block.makeCuboidShape(1, 0, 1, 15, 14, 15);

    public CableBlock(Properties properties) {
        super(properties);
        this.shape = this.makeShapes(10, 10, 10, 10, 10);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.CABLE_TILE_ENTITY.get().create();
    }

    @Nonnull
    @Override
    public VoxelShape getCollisionShape(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        return mainShape;
    }


    @Nonnull
    @Override
    public ActionResultType onBlockActivated(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull PlayerEntity player, @Nonnull Hand handIn, @Nonnull BlockRayTraceResult hit) {
        return ActionResultType.PASS;
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        return mainShape;
    }

    @Nonnull
    @Override
    public VoxelShape getRenderShape(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return this.shape[this.getIndex(state)];
    }

    @Override
    public boolean isNormalCube(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isTransparent(@Nonnull BlockState state) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onBlockPlacedBy(@Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull BlockState state, LivingEntity placer, @Nonnull ItemStack stack) {
        CableTileEntity thisTE = (CableTileEntity) worldIn.getTileEntity(pos);
        CableTileEntity.CONNECTIONS.put(thisTE, new ArrayList<>());
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    TileEntity surrounding = worldIn.getTileEntity(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z));
                    if (surrounding instanceof CableTileEntity) {
                        if (CableTileEntity.CONNECTIONS.containsKey(surrounding)) {
                            CableTileEntity.CONNECTIONS.get(surrounding).add(worldIn.getTileEntity(pos));
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

    @Override
    public void onBlockAdded(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull BlockState oldState, boolean isMoving) {

        //int counter = 0;
        //BlockState around;
        CableTileEntity thisTE = (CableTileEntity) worldIn.getTileEntity(pos);
        CableTileEntity.CONNECTIONS.put(thisTE, new ArrayList<>());
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    TileEntity surrounding = worldIn.getTileEntity(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z));
                    if (surrounding instanceof CableTileEntity) {
                        if (CableTileEntity.CONNECTIONS.containsKey(surrounding)) {
                            CableTileEntity.CONNECTIONS.get(surrounding).add(worldIn.getTileEntity(pos));
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

    @Override
    public void onPlayerDestroy(@Nonnull IWorld worldIn, @Nonnull BlockPos pos, @Nonnull BlockState state) {
        CableTileEntity thisTE = (CableTileEntity) worldIn.getTileEntity(pos);
        ArrayList<TileEntity> toDisconnect = CableTileEntity.CONNECTIONS.get(thisTE);
        thisTE.disconnectToComp();
        thisTE.disconnectToScanner();
        CableTileEntity.CONNECTIONS.remove(thisTE);
        for (TileEntity te : toDisconnect) {
            if(te instanceof CableTileEntity) {
                CableTileEntity.CONNECTIONS.get(te).remove(thisTE);
            }
        }
    }

}
