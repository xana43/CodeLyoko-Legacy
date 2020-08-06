package com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InfusingChamberTileEntity;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
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

public class FlourideInfuser extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final BooleanProperty INFUSING = BooleanProperty.create("infusing");

    public FlourideInfuser() {
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
    public ActionResultType onBlockActivated(@Nonnull BlockState state, World worldIn, @Nonnull BlockPos pos,
                                             @Nonnull PlayerEntity player, @Nonnull Hand handIn, @Nonnull BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            final TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof InfusingChamberTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (InfusingChamberTileEntity) tileEntity, pos);
            }
        }
        return ActionResultType.SUCCESS;
    }

    public static void setState(boolean act, World worldIn, BlockPos pos) {
        BlockState state = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (act) {
            worldIn.setBlockState(pos, ModBlocks.FLOURIDE_INFUSER.get().getDefaultState().with(FACING, state.get(FACING))
                    .with(INFUSING, true), 3);
        } else {
            worldIn.setBlockState(pos, ModBlocks.FLOURIDE_INFUSER.get().getDefaultState().with(FACING, state.get(FACING))
                    .with(INFUSING, false), 3);
        }
        if (tileentity != null) {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.INFUSING_CHAMBER_TILE_ENTITY.get().create();
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
