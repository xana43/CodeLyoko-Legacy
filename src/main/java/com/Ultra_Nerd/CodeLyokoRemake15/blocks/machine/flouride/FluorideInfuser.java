package com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InfusingChamberTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FluorideInfuser extends BaseEntityBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty INFUSING = BooleanProperty.create("infusing");

    public FluorideInfuser() {
        super(Block.Properties.of(Material.METAL)

                .strength(6, 10)
                .sound(SoundType.METAL)

        );

        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(INFUSING, false));


    }



    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, Level worldIn, @Nonnull BlockPos pos,
                                             @Nonnull Player player, @Nonnull InteractionHand handIn, @Nonnull BlockHitResult hit) {
        if (worldIn.isClientSide) {
            final BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof InfusingChamberTileEntity) {
                NetworkHooks.openGui((ServerPlayer) player, (InfusingChamberTileEntity) tileEntity, pos);
            }
        }
        return InteractionResult.SUCCESS;
    }


    public static void setState(boolean act, Level worldIn, BlockPos pos) {
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
    }*/

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(DirectionProperty.create("facing", Direction.Plane.HORIZONTAL))
                .add(INFUSING));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }



    @Override
    public void setPlacedBy(Level worldIn, @Nonnull BlockPos pos, @Nonnull BlockState state,
                            @Nullable LivingEntity placer, @Nonnull ItemStack stack) {
        worldIn.setBlock(pos, this.defaultBlockState().setValue(FACING, placer.getDirection().getOpposite()), 2);
    }


    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor world, BlockPos pos, Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }


}
