package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tower;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class TowerEnter extends Block {

    public static final DirectionProperty DIRTOWER2 = BlockStateProperties.HORIZONTAL_FACING;

    public TowerEnter() {
        super(Properties.create(Material.MISCELLANEOUS)

                .hardnessAndResistance(-1, -1)
                .sound(SoundType.GLASS)
                .lightValue(5)
                .doesNotBlockMovement()


        );

    }

    @Override
    public void entityInside(BlockState p_60495_, Level p_60496_, BlockPos p_60497_, Entity p_60498_) {
        super.entityInside(p_60495_, p_60496_, p_60497_, p_60498_);
        if(!(p_60498_ instanceof Player))
        {
            p_60498_.hurt(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRTOWER2);
    }




    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(DIRTOWER2, context.getPlacementHorizontalFacing().getOpposite());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(DIRTOWER2, rot.rotate(state.get(DIRTOWER2)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(DIRTOWER2)));
    }

    //


    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }




}