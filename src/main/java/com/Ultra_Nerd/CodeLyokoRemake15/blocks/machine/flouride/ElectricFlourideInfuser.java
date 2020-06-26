package com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ElectricInfusingChamberTileEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers.Conf;

import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InfusingChamberTileEntity;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class ElectricFlourideInfuser extends Block {

    public ElectricFlourideInfuser() {
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

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final BooleanProperty INFUSING = BooleanProperty.create("infusing");

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            final TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof ElectricInfusingChamberTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (ElectricInfusingChamberTileEntity) tileEntity, pos);
            }
        }
        return ActionResultType.SUCCESS;
    }

    public static void setState(boolean act, World worldIn, BlockPos pos) {
        BlockState state = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (act)
            worldIn.setBlockState(pos, ModBlocks.ELECTRICFLOURIDE_INFUSER.get().getDefaultState()
                    .with(FACING, state.get(FACING)).with(INFUSING, true), 3);
        else
            worldIn.setBlockState(pos, ModBlocks.ELECTRICFLOURIDE_INFUSER.get().getDefaultState()
                    .with(FACING, state.get(FACING)).with(INFUSING, false), 3);
        if (tileentity != null) {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ElectricInfusingChamberTileEntity();
    }

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
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof ElectricInfusingChamberTileEntity) {
                InventoryHelper.dropItems(worldIn, pos, NonNullList.from(((ElectricInfusingChamberTileEntity) te).handler.getStackInSlot(0)));
                InventoryHelper.dropItems(worldIn, pos, NonNullList.from(((ElectricInfusingChamberTileEntity) te).handler.getStackInSlot(1)));
                InventoryHelper.dropItems(worldIn, pos, NonNullList.from(((ElectricInfusingChamberTileEntity) te).handler.getStackInSlot(2)));
                InventoryHelper.dropItems(worldIn, pos, NonNullList.from(((ElectricInfusingChamberTileEntity) te).handler.getStackInSlot(3)));
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
