package com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ElectricInfusingChamberTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ElectricFluorideInfuser extends BaseEntityBlock {

    public static @NotNull DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public ElectricFluorideInfuser() {
        super(Block.Properties.of(Material.METAL)

                .strength(6, 10)
                .sound(SoundType.METAL)

        );

        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(INFUSING, false));

        // TODO Auto-generated constructor stub
    }


    public static final BooleanProperty INFUSING = BooleanProperty.create("infusing");

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(INFUSING);
    }





    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, @NotNull Level worldIn, @Nonnull BlockPos pos, @Nonnull Player player, @Nonnull InteractionHand handIn, @Nonnull BlockHitResult hit) {
        if (worldIn.isClientSide) {
            final BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof ElectricInfusingChamberTileEntity) {
                NetworkHooks.openGui((ServerPlayer) player, (ElectricInfusingChamberTileEntity) tileEntity, pos);
            }
        }
        return InteractionResult.SUCCESS;
    }

    public static void setState(boolean act, @NotNull Level worldIn, @NotNull BlockPos pos) {
        BlockState state = worldIn.getBlockState(pos);
        BlockEntity tileentity = worldIn.getBlockEntity(pos);
        if (act)
            worldIn.setBlockAndUpdate(pos, ModBlocks.ELECTRIC_FLUORIDE_INFUSER.get().defaultBlockState()
                    .setValue(FACING, state.getValue(FACING)).setValue(INFUSING, true));
        else
            worldIn.setBlockAndUpdate(pos, ModBlocks.ELECTRIC_FLUORIDE_INFUSER.get().defaultBlockState()
                    .setValue(FACING, state.getValue(FACING)).setValue(INFUSING, false));
        if (tileentity != null) {
            tileentity.onLoad();
            worldIn.setBlockEntity(tileentity);
        }
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return null; //new ElectricInfusingChamberTileEntity(p_153215_,p_153216_);
    }





    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }



    @Override
    public void setPlacedBy(@NotNull Level worldIn, @Nonnull BlockPos pos, @Nonnull BlockState state, @NotNull LivingEntity placer, @Nonnull ItemStack stack) {
        worldIn.setBlock(pos, this.defaultBlockState().setValue(FACING, placer.getDirection().getOpposite()), 2);
    }


    @Override
    public @NotNull RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }



    @Nonnull
    @Override
    public BlockState rotate(@NotNull BlockState state, @NotNull Rotation rot) {

        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Nonnull
    @Override
    public BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }


    @Override
    public void onRemove(@NotNull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @NotNull BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity te = worldIn.getBlockEntity(pos);
            if (te instanceof ElectricInfusingChamberTileEntity) {
                assert te != null;
                Containers.dropContents(worldIn, pos, NonNullList.of(((ElectricInfusingChamberTileEntity) te).handler.getStackInSlot(0)));
                Containers.dropContents(worldIn, pos, NonNullList.of(((ElectricInfusingChamberTileEntity) te).handler.getStackInSlot(1)));
                Containers.dropContents(worldIn, pos, NonNullList.of(((ElectricInfusingChamberTileEntity) te).handler.getStackInSlot(2)));
                Containers.dropContents(worldIn, pos, NonNullList.of(((ElectricInfusingChamberTileEntity) te).handler.getStackInSlot(3)));
            }
        }
    }

    /*@Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        ElectricInfusingChamberTileEntity tileentity = (ElectricInfusingChamberTileEntity) worldIn.getTileEntity(pos);
        worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileentity.handler.getStackInSlot(0)));
        worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileentity.handler.getStackInSlot(1)));
        worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileentity.handler.getStackInSlot(2)));

        super.breakBlock(worldIn, pos, state);
    }*/

}
