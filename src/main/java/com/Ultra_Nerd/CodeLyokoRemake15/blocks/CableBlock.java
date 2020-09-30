package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CableBlock extends FenceBlock {

    private final static Map<CableBlock, LinkedList<CableBlock>> CABLE_LISTS = new HashMap<>();
    private CableBlock startOfCable;

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
        return true;
    }

    @Override
    public void onBlockAdded(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull BlockState oldState, boolean isMoving) {
        int counter = 0;
        BlockState around;
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    BlockState surrounding = worldIn.getBlockState(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z));
                    if (surrounding.getBlock() instanceof CableBlock) {
                        around = surrounding;
                        if (counter < 2) {
                            counter++;
                            CABLE_LISTS.get(((CableBlock) surrounding.getBlock()).startOfCable).addLast(this);
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        this.startOfCable = this;
        CABLE_LISTS.put(this, new LinkedList<>());
        CABLE_LISTS.get(this).add(this);

    }
}
