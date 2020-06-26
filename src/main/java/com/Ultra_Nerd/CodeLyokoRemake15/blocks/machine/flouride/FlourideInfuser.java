package com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InfusingChamberTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static net.minecraft.block.HorizontalBlock.HORIZONTAL_FACING;

public class FlourideInfuser extends Block {

    public FlourideInfuser() {
        super(Block.Properties.create(Material.IRON)

                .hardnessAndResistance(6, 10)
                .sound(SoundType.METAL)
                .lightValue(1)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );

        //this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(INFUSING, false));


        // TODO Auto-generated constructor stub
    }

    public static final DirectionProperty FACING = HORIZONTAL_FACING;
    public static final BooleanProperty INFUSING = BooleanProperty.create("infusing");



    /*@Override
    public Item getItemDropped(BlockState state, Random rand, int fortune) {
        // TODO Auto-generated method stub
        return Item.getItemFromBlock(ModBlocks.FLOURIDE_INFUSER.get());
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        // TODO Auto-generated method stub
        return new ItemStack(Modblocks.FLOURIDE_INFUSER);
    }

    @Nonnull
    @Override
    public ActionResultType onBlockActivated(@Nonnull BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            final TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof InfusingChamberTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (InfusingChamberTileEntity) tileEntity, pos);
            }
        }
        return ActionResultType.SUCCESS;
    }


    /*@Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {

        if (!worldIn.isRemote) {
            BlockState north = worldIn.getBlockState(pos.north());
            BlockState south = worldIn.getBlockState(pos.south());
            BlockState east = worldIn.getBlockState(pos.east());
            BlockState west = worldIn.getBlockState(pos.west());
            Direction face =  state.get(FACING);

            if (face == Direction.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.SOUTH;
            else if (face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) face = EnumFacing.NORTH;
            else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) face = EnumFacing.EAST;
            else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) face = EnumFacing.WEST;
            worldIn.setBlockState(pos, state.withProperty(FACING, face), 2);


        }

    }*/

    public static void setState(boolean act, World worldIn, BlockPos pos) {
        BlockState state = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (act)
            worldIn.setBlockState(pos, ModBlocks.FLOURIDE_INFUSER.get().getDefaultState().with(FACING, state.get(FACING))
                    .with(INFUSING, true), 3);
        else
            worldIn.setBlockState(pos, ModBlocks.FLOURIDE_INFUSER.get().getDefaultState().with(FACING, state.get(FACING))
                    .with(INFUSING, false), 3);
        if (tileentity != null) {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }
/*
    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.INFUSING_CHAMBER_TILE_ENTITY.get().create();
    }
*/
    @Override
    public boolean hasTileEntity(BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {

        worldIn.setBlockState(pos, this.getDefaultState().with(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
        return state.with(FACING, direction.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }
/*
    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof InfusingChamberTileEntity) {
                InventoryHelper.dropItems(worldIn, pos, NonNullList.from(((InfusingChamberTileEntity) te).handler.getStackInSlot(0)));
            }
        }
    }

    /*@Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        InfusingChamberTileEntity tileentity = (InfusingChamberTileEntity) worldIn.getTileEntity(pos);
        worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileentity.handler.getStackInSlot(0)));
        worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileentity.handler.getStackInSlot(1)));
        worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileentity.handler.getStackInSlot(2)));
        worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileentity.handler.getStackInSlot(3)));
        super.breakBlock(worldIn, pos, state);
    }*/

}
