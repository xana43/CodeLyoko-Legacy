package com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InfusingChamberTileEntity;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.World;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.client.RenderProperties;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FluorideInfuser extends BaseEntityBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty INFUSING = BooleanProperty.create("infusing");

    public FluorideInfuser() {
        super(Block.Properties.create(Material.IRON)

                .hardnessAndResistance(6, 10)
                .sound(SoundType.METAL)
                .lightValue(1)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );

        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(INFUSING, false));


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
            worldIn.setBlockAndUpdate(pos, ModBlocks.FLUORIDE_INFUSER.get().defaultBlockState().with(FACING, state.getValue(FACING))
                    .with(INFUSING, true), 3);
        } else {
            worldIn.setBlockAndUpdate(pos, ModBlocks.FLUORIDE_INFUSER.get().defaultBlockState().with(FACING, state.getValue(FACING))
                    .with(INFUSING, false), 3);
        }
        if (tileentity != null) {
            worldIn.setBlockEntity(tileentity);
        }
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ModTileEntities.INFUSING_CHAMBER_TILE_ENTITY.get().create(pos,state);
    }



    @Override
    public boolean hasTileEntity(BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder.add(DirectionProperty.create("facing", Direction.Plane.HORIZONTAL))
                .add(INFUSING));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, @Nonnull BlockPos pos, @Nonnull BlockState state,
                                @Nullable LivingEntity placer, @Nonnull ItemStack stack) {
        worldIn.setBlockState(pos, this.getDefaultState().with(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Nonnull
    @Override
    public BlockRenderType getRenderType(@Nonnull BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
        return state.with(FACING, direction.rotate(state.get(FACING)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }


}
