package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tower;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.TowerInterfaceTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TowerInterface extends Block {

    public static final DirectionProperty DIRINTERFACE = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Block.makeCuboidShape(1, 9, 3, 15, 9.1, 12);
    private static final VoxelShape SHAPE_S = Block.makeCuboidShape(1, 9, 3, 15, 9.1, 12);
    private static final VoxelShape SHAPE_E = Block.makeCuboidShape(4, 9, 1, 13, 9.1, 15);
    private static final VoxelShape SHAPE_W = Block.makeCuboidShape(4, 9, 1, 13, 9.1, 15);


    public TowerInterface() {
        super(Block.Properties.create(Material.DRAGON_EGG)

                .hardnessAndResistance(-1, -1)
                .sound(SoundType.METAL)
                .lightValue(5)

        );
        this.setDefaultState(this.stateContainer.getBaseState().with(DIRINTERFACE, Direction.NORTH));

    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(DIRINTERFACE);
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        switch (state.get(DIRINTERFACE)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(DIRINTERFACE, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public boolean isViewBlocking(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return false;
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(DIRINTERFACE, rot.rotate(state.get(DIRINTERFACE)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(DIRINTERFACE)));
    }

    //
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
    public boolean hasTileEntity(BlockState state) {
        return true;

    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.TOWER_INTERFACE_TILE_ENTITY.get().create();
    }


    @Nonnull
    @Override
    public ActionResultType onBlockActivated(@Nonnull BlockState state, World worldIn, @Nonnull BlockPos pos, @Nonnull PlayerEntity player,
                                             @Nonnull Hand handIn, @Nonnull BlockRayTraceResult result) {
        if (!worldIn.isRemote) {
            TileEntity Tower = worldIn.getTileEntity(pos);
            if (Tower instanceof TowerInterfaceTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (TowerInterfaceTileEntity) Tower, pos);
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.FAIL;
    }


}
