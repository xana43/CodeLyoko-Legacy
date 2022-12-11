package com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.flouride;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class ElectricFluorideInfuser extends BlockWithEntity {


    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public ElectricFluorideInfuser() {
        super(FabricBlockSettings.copy(Blocks.IRON_BLOCK)


        );

        //this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(INFUSING, false));

        // TODO Auto-generated constructor stub
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return null;
    }

/*
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
