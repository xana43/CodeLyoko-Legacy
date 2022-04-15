package com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.electroplate;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.handlers.CustomItemHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.ElectroplatingTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class ElectroplatingMachine extends BaseEntityBlock {

    public static final DirectionProperty ELECTRO_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty ELECTRO_ACTIVE = BooleanProperty.create("electro_active");

    public ElectroplatingMachine(@NotNull Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(ELECTRO_FACING, Direction.NORTH).setValue(ELECTRO_ACTIVE, false));
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(ELECTRO_ACTIVE).add(ELECTRO_FACING);
    }



    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        // TODO Auto-generated method stub
        return this.defaultBlockState().setValue(ELECTRO_FACING, context.getHorizontalDirection().getOpposite());
    }





    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(@NotNull BlockState state, @NotNull Rotation rot) {
        return state.setValue(ELECTRO_FACING, rot.rotate(state.getValue(ELECTRO_FACING)));
    }

    @Nonnull
    @Override
    public BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(ELECTRO_FACING)));
    }

    @Override
    public int getLightEmission(@NotNull BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(ELECTRO_ACTIVE) ? super.getLightEmission(state,level,pos) : 0;
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState p_60457_) {
        return true;
    }



    @Override
    public int getAnalogOutputSignal(@Nonnull BlockState blockState, @NotNull Level worldIn, @Nonnull BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(worldIn.getBlockEntity(pos));
    }




    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos,
                                             @Nonnull Player player, @Nonnull InteractionHand handIn, @Nonnull BlockHitResult hit) {
        if (worldIn.isClientSide) {
            BlockEntity tile = worldIn.getBlockEntity(pos);
            if (tile instanceof ElectroplatingTileEntity) {
                NetworkHooks.openGui((ServerPlayer) player, (MenuProvider) tile, pos);
                player.sendMessage(new TextComponent("not implemented yet"),player.getUUID());
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.SUCCESS;
    }




    @Override
    public void onRemove(@Nonnull BlockState state, @NotNull Level worldIn, @Nonnull BlockPos pos, @Nonnull BlockState newState, boolean isMoving) {
        BlockEntity tile = worldIn.getBlockEntity(pos);
        if (tile instanceof ElectroplatingTileEntity) {
            ElectroplatingTileEntity plater = (ElectroplatingTileEntity) tile;
            ((CustomItemHandler) plater.getInventory()).toNonNullList().forEach(item -> {
                ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), item);
                worldIn.addFreshEntity(itemEntity);
            });
        }
        if (state.hasBlockEntity() && state.getBlock() != newState.getBlock()) {
            worldIn.removeBlockEntity(pos);
        }
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return null; // ModTileEntities.ELECTROPLATING_TILE_ENTITY.get().create(p_153215_,p_153216_);
    }
}
