package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.CableTileEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ComputerControlPanelTileEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ScannerTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class CableBlock extends FenceBlock {

//    private final static Map<CableBlock, LinkedList<CableBlock>> CABLE_LISTS = new HashMap<>();
//    private CableBlock startOfCable;

    private final VoxelShape[] shape;
    private final VoxelShape mainShape = Block.box(1, 0, 1, 15, 14, 15);

    public CableBlock(Properties properties) {
        super(properties);
        this.shape = this.makeShapes(10, 10, 10, 10, 10);
    }

/*

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.CABLE_TILE_ENTITY.get().create();
    }
*/
    @Nonnull
    @Override
    public VoxelShape getCollisionShape(@Nonnull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return mainShape;
    }



    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Player player, @Nonnull InteractionHand handIn, @Nonnull BlockHitResult hit) {
        return InteractionResult.PASS;
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return mainShape;
    }





    @Override
    public void setPlacedBy(@Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull BlockState state, LivingEntity placer, @Nonnull ItemStack stack) {
        CableTileEntity thisTE = (CableTileEntity) worldIn.getBlockEntity(pos);
        CableTileEntity.CONNECTIONS.put(thisTE, new ArrayList<>());
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    if (!(x == 0 && y == 0 && z == 0)) {
                        BlockEntity surrounding = worldIn.getBlockEntity(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z));
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


}
