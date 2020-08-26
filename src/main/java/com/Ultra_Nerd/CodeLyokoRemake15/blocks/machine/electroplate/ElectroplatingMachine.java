package com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.electroplate;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers.CustomItemHandler;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ElectroplatingTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ElectroplatingMachine extends Block {

    public static final DirectionProperty ELECTRO_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty ELECTRO_ACTIVE = BooleanProperty.create("electro_active");

    public ElectroplatingMachine(Properties properties) {
        super(properties);
        this.setDefaultState(getStateContainer().getBaseState().with(ELECTRO_FACING, Direction.NORTH).with(ELECTRO_ACTIVE, false));
    }

    @Override
    protected void fillStateContainer(@Nonnull StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(ELECTRO_ACTIVE).add(ELECTRO_FACING);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(ELECTRO_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public boolean isViewBlocking(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return false;
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(ELECTRO_FACING, rot.rotate(state.get(ELECTRO_FACING)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(ELECTRO_FACING)));
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.ELECTROPLATING_TILE_ENTITY.get().create();
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return state.get(ELECTRO_ACTIVE) ? super.getLightValue(state) : 0;
    }


    @Override
    public boolean hasComparatorInputOverride(@Nonnull BlockState state) {
        return true;
    }

    @Override
    public int getComparatorInputOverride(@Nonnull BlockState blockState, World worldIn, @Nonnull BlockPos pos) {
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }

    @Nonnull
    @Override
    public ActionResultType onBlockActivated(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos,
                                             @Nonnull PlayerEntity player, @Nonnull Hand handIn, @Nonnull BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            TileEntity tile = worldIn.getTileEntity(pos);
            if (tile instanceof ElectroplatingTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tile, pos);
                player.sendMessage(new StringTextComponent("not implemented yet"));
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public void onReplaced(@Nonnull BlockState state, World worldIn, @Nonnull BlockPos pos, @Nonnull BlockState newState, boolean isMoving) {
        TileEntity tile = worldIn.getTileEntity(pos);
        if (tile instanceof ElectroplatingTileEntity) {
            ElectroplatingTileEntity plater = (ElectroplatingTileEntity) tile;
            ((CustomItemHandler) plater.getInventory()).toNonNullList().forEach(item -> {
                ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), item);
                worldIn.addEntity(itemEntity);
            });
        }
        if (state.hasTileEntity() && state.getBlock() != newState.getBlock()) {
            worldIn.removeTileEntity(pos);
        }
    }
}
