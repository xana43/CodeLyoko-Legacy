package com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ElectricInfusingChamberTileEntity;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.World;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ElectricFluorideInfuser extends BaseEntityBlock {

    public static DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public ElectricFluorideInfuser() {
        super(Block.Properties.create(Material.IRON)

                .hardnessAndResistance(6, 10)
                .sound(SoundType.METAL)
                .lightValue(1)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
        );

        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(INFUSING, false));

        // TODO Auto-generated constructor stub
    }


    public static final BooleanProperty INFUSING = BooleanProperty.create("infusing");

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(INFUSING);
    }





    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, Level worldIn, @Nonnull BlockPos pos, @Nonnull Player player, @Nonnull InteractionHand handIn, @Nonnull BlockHitResult hit) {
        if (worldIn.isClientSide) {
            final BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof ElectricInfusingChamberTileEntity) {
                NetworkHooks.openGui((ServerPlayer) player, (ElectricInfusingChamberTileEntity) tileEntity, pos);
            }
        }
        return InteractionResult.SUCCESS;
    }

    public static void setState(boolean act, Level worldIn, BlockPos pos) {
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
        return new ElectricInfusingChamberTileEntity();
    }





    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }



    @Override
    public void onBlockPlacedBy(World worldIn, @Nonnull BlockPos pos, @Nonnull BlockState state, LivingEntity placer, @Nonnull ItemStack stack) {
        worldIn.setBlockState(pos, this.getDefaultState().with(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Nonnull
    @Override
    public BlockRenderType getRenderType(@Nonnull BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }



    @Override
    public void onReplaced(BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof ElectricInfusingChamberTileEntity) {
                assert te != null;
                InventoryHelper.dropItems(worldIn, pos, NonNullList.from(((ElectricInfusingChamberTileEntity) te).handler.getStackInSlot(0)));
                InventoryHelper.dropItems(worldIn, pos, NonNullList.from(((ElectricInfusingChamberTileEntity) te).handler.getStackInSlot(1)));
                InventoryHelper.dropItems(worldIn, pos, NonNullList.from(((ElectricInfusingChamberTileEntity) te).handler.getStackInSlot(2)));
                //InventoryHelper.dropItems(worldIn, pos, NonNullList.from(((ElectricInfusingChamberTileEntity) te).handler.getStackInSlot(3)));
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
