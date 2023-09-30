package com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.flouride;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.InfusingChamberTileEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class FluorideInfuser extends BlockWithEntity  {


    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return null;
    }

    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty INFUSING = BooleanProperty.of("infusing");

    public FluorideInfuser() {
        super(FabricBlockSettings.of(Material.METAL)

                .strength(6, 10)
                .sounds(BlockSoundGroup.METAL)

        );

  //      this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(INFUSING, false));


    }
/*


    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, @NotNull Level worldIn, @Nonnull BlockPos pos,
                                 @Nonnull Player player, @Nonnull InteractionHand handIn, @Nonnull BlockHitResult hit) {
        if (worldIn.isClientSide) {
            final BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof InfusingChamberTileEntity) {
                NetworkHooks.openGui((ServerPlayer) player, (InfusingChamberTileEntity) tileEntity, pos);
            }
        }
        return InteractionResult.SUCCESS;
    }


    public static void setState(boolean act, @NotNull Level worldIn, @NotNull BlockPos pos) {
        BlockState state = worldIn.getBlockState(pos);
        BlockEntity tileentity = worldIn.getBlockEntity(pos);
        if (act) {
            worldIn.setBlock(pos, ModBlocks.FLUORIDE_INFUSER.get().defaultBlockState().setValue(FACING, state.getValue(FACING))
                    .setValue(INFUSING, true), 3);
        } else {
            worldIn.setBlock(pos, ModBlocks.FLUORIDE_INFUSER.get().defaultBlockState().setValue(FACING, state.getValue(FACING))
                    .setValue(INFUSING, false), 3);
        }
        if (tileentity != null) {
            worldIn.setBlockEntity(tileentity);
        }
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return null; //ModTileEntities.INFUSING_CHAMBER_TILE_ENTITY.get().create(pos,state);
    }


/*
    @Override
    public boolean hasTileEntity(BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(DirectionProperty.create("facing", Direction.Plane.HORIZONTAL))
                .add(INFUSING));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }



    @Override
    public void setPlacedBy(@NotNull Level worldIn, @Nonnull BlockPos pos, @Nonnull BlockState state,
                            @Nullable LivingEntity placer, @Nonnull ItemStack stack) {
        worldIn.setBlock(pos, this.defaultBlockState().setValue(FACING, placer.getDirection().getOpposite()), 2);
    }


    @Override
    public @NotNull RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull BlockState rotate(@NotNull BlockState state, LevelAccessor world, BlockPos pos, @NotNull Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }

    @Nonnull
    @Override
    public BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

 */


}
