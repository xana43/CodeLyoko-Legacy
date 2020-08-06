package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.QuantumChipletTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class FranzChiplet extends Block {
    private final static VoxelShape shape = Stream.of(
            Block.makeCuboidShape(4, 4, 0, 5, 5, 1),
            Block.makeCuboidShape(0, 0, 0, 4, 16, 2),
            Block.makeCuboidShape(0, 0, 14, 4, 16, 16),
            Block.makeCuboidShape(12, 0, 14, 16, 16, 16),
            Block.makeCuboidShape(12, 0, 0, 16, 16, 2),
            Block.makeCuboidShape(0, 0, 12, 2, 16, 14),
            Block.makeCuboidShape(14, 0, 12, 16, 16, 14),
            Block.makeCuboidShape(14, 0, 2, 16, 16, 4),
            Block.makeCuboidShape(0, 0, 2, 2, 16, 4),
            Block.makeCuboidShape(14, 0, 4, 16, 4, 12),
            Block.makeCuboidShape(0, 0, 4, 2, 4, 12),
            Block.makeCuboidShape(4, 0, 0, 12, 4, 2),
            Block.makeCuboidShape(4, 0, 14, 12, 4, 16),
            Block.makeCuboidShape(14, 12, 4, 16, 16, 12),
            Block.makeCuboidShape(0, 12, 4, 2, 16, 12),
            Block.makeCuboidShape(4, 12, 0, 12, 16, 2),
            Block.makeCuboidShape(4, 12, 14, 12, 16, 16),
            Block.makeCuboidShape(10, 14, 2, 11, 16, 3),
            Block.makeCuboidShape(10, 0, 2, 11, 2, 3),
            Block.makeCuboidShape(5, 14, 2, 6, 16, 3),
            Block.makeCuboidShape(5, 0, 2, 6, 2, 3),
            Block.makeCuboidShape(5, 14, 13, 6, 16, 14),
            Block.makeCuboidShape(5, 0, 13, 6, 2, 14),
            Block.makeCuboidShape(11, 14, 2, 13, 16, 4),
            Block.makeCuboidShape(11, 0, 2, 13, 2, 4),
            Block.makeCuboidShape(11, 14, 12, 13, 16, 14),
            Block.makeCuboidShape(11, 0, 12, 13, 2, 14),
            Block.makeCuboidShape(3, 14, 2, 5, 16, 4),
            Block.makeCuboidShape(3, 0, 2, 5, 2, 4),
            Block.makeCuboidShape(3, 14, 12, 5, 16, 14),
            Block.makeCuboidShape(3, 0, 12, 5, 2, 14),
            Block.makeCuboidShape(12, 14, 4, 13, 16, 5),
            Block.makeCuboidShape(12, 0, 4, 13, 2, 5),
            Block.makeCuboidShape(12, 14, 11, 13, 16, 12),
            Block.makeCuboidShape(12, 0, 11, 13, 2, 12),
            Block.makeCuboidShape(3, 14, 4, 4, 16, 5),
            Block.makeCuboidShape(3, 0, 4, 4, 2, 5),
            Block.makeCuboidShape(3, 14, 11, 4, 16, 12),
            Block.makeCuboidShape(10, 14, 6, 14, 15, 10),
            Block.makeCuboidShape(10, 1, 6, 14, 2, 10),
            Block.makeCuboidShape(10, 14, 10, 13, 15, 11),
            Block.makeCuboidShape(10, 1, 10, 13, 2, 11),
            Block.makeCuboidShape(3, 14, 10, 6, 15, 11),
            Block.makeCuboidShape(3, 1, 10, 6, 2, 11),
            Block.makeCuboidShape(3, 14, 5, 6, 15, 6),
            Block.makeCuboidShape(3, 1, 5, 6, 2, 6),
            Block.makeCuboidShape(10, 14, 5, 13, 15, 6),
            Block.makeCuboidShape(10, 1, 5, 13, 2, 6),
            Block.makeCuboidShape(10, 14, 4, 12, 15, 5),
            Block.makeCuboidShape(10, 1, 4, 12, 2, 5),
            Block.makeCuboidShape(10, 14, 11, 12, 15, 12),
            Block.makeCuboidShape(10, 1, 11, 12, 2, 12),
            Block.makeCuboidShape(4, 14, 11, 6, 15, 12),
            Block.makeCuboidShape(4, 1, 11, 6, 2, 12),
            Block.makeCuboidShape(4, 14, 4, 6, 15, 5),
            Block.makeCuboidShape(4, 1, 4, 6, 2, 5),
            Block.makeCuboidShape(5, 14, 3, 6, 15, 4),
            Block.makeCuboidShape(5, 1, 3, 6, 2, 4),
            Block.makeCuboidShape(5, 14, 12, 6, 15, 13),
            Block.makeCuboidShape(5, 1, 12, 6, 2, 13),
            Block.makeCuboidShape(10, 14, 12, 11, 15, 13),
            Block.makeCuboidShape(10, 1, 12, 11, 2, 13),
            Block.makeCuboidShape(10, 14, 3, 11, 15, 4),
            Block.makeCuboidShape(10, 1, 3, 11, 2, 4),
            Block.makeCuboidShape(2, 14, 6, 6, 15, 10),
            Block.makeCuboidShape(2, 1, 6, 6, 2, 10),
            Block.makeCuboidShape(6, 14, 2, 10, 15, 14),
            Block.makeCuboidShape(6, 1, 2, 10, 2, 14),
            Block.makeCuboidShape(3, 0, 11, 4, 2, 12),
            Block.makeCuboidShape(13, 14, 2, 14, 16, 6),
            Block.makeCuboidShape(13, 0, 2, 14, 2, 6),
            Block.makeCuboidShape(13, 14, 10, 14, 16, 14),
            Block.makeCuboidShape(13, 0, 10, 14, 2, 14),
            Block.makeCuboidShape(10, 14, 13, 11, 16, 14),
            Block.makeCuboidShape(10, 0, 13, 11, 2, 14),
            Block.makeCuboidShape(2, 14, 2, 3, 16, 6),
            Block.makeCuboidShape(2, 0, 2, 3, 2, 6),
            Block.makeCuboidShape(2, 14, 10, 3, 16, 14),
            Block.makeCuboidShape(2, 0, 10, 3, 2, 14),
            Block.makeCuboidShape(0, 4, 5, 1, 5, 11),
            Block.makeCuboidShape(0, 4, 4, 1, 5, 5),
            Block.makeCuboidShape(15, 4, 5, 16, 5, 11),
            Block.makeCuboidShape(0, 11, 5, 1, 12, 11),
            Block.makeCuboidShape(0, 11, 4, 1, 12, 5),
            Block.makeCuboidShape(15, 11, 4, 16, 12, 5),
            Block.makeCuboidShape(0, 11, 11, 1, 12, 12),
            Block.makeCuboidShape(15, 11, 5, 16, 12, 11),
            Block.makeCuboidShape(15, 4, 4, 16, 5, 5),
            Block.makeCuboidShape(0, 4, 11, 1, 5, 12),
            Block.makeCuboidShape(15, 4, 11, 16, 5, 12),
            Block.makeCuboidShape(0, 5, 4, 1, 11, 12),
            Block.makeCuboidShape(15, 5, 4, 16, 11, 12),
            Block.makeCuboidShape(15, 11, 11, 16, 12, 12),
            Block.makeCuboidShape(4, 5, 15, 12, 11, 16),
            Block.makeCuboidShape(4, 5, 0, 12, 11, 1),
            Block.makeCuboidShape(5, 11, 15, 11, 12, 16),
            Block.makeCuboidShape(4, 11, 15, 5, 12, 16),
            Block.makeCuboidShape(5, 11, 0, 11, 12, 1),
            Block.makeCuboidShape(4, 11, 0, 5, 12, 1),
            Block.makeCuboidShape(11, 11, 15, 12, 12, 16),
            Block.makeCuboidShape(11, 11, 0, 12, 12, 1),
            Block.makeCuboidShape(11, 4, 0, 12, 5, 1),
            Block.makeCuboidShape(11, 4, 15, 12, 5, 16),
            Block.makeCuboidShape(5, 4, 15, 11, 5, 16),
            Block.makeCuboidShape(4, 4, 15, 5, 5, 16),
            Block.makeCuboidShape(5, 4, 0, 11, 5, 1)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    public FranzChiplet() {
        super(Block.Properties.from(Blocks.IRON_BLOCK));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        return shape;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }


    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.QUANTUM_CHIPLET_TILE_ENTITY.get().create();
    }


    @Nonnull
    @Override
    public ActionResultType onBlockActivated(@Nonnull BlockState state, World worldIn, @Nonnull BlockPos pos, @Nonnull PlayerEntity player, @Nonnull Hand handIn, @Nonnull BlockRayTraceResult result) {
        if (!worldIn.isRemote) {
            TileEntity Chiplet = worldIn.getTileEntity(pos);
            if (Chiplet instanceof QuantumChipletTileEntity) {

                NetworkHooks.openGui((ServerPlayerEntity) player, (QuantumChipletTileEntity) Chiplet, pos);
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.FAIL;
    }

    @Override
    public void onReplaced(BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            TileEntity tile1 = worldIn.getTileEntity(pos);
            if (tile1 instanceof QuantumChipletTileEntity) {
                InventoryHelper.dropItems(worldIn, pos, ((QuantumChipletTileEntity) tile1).getItems());
            }
        }
    }
}
