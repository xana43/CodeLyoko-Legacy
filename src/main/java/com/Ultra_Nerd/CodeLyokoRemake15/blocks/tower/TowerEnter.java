package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tower;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nonnull;


public class TowerEnter extends Block {

    public static final DirectionProperty DIRTOWER2 = BlockStateProperties.HORIZONTAL_FACING;

    public TowerEnter() {
        super(Properties.of(Material.BARRIER)

                .strength(-1, -1)
                .sound(SoundType.GLASS)
                .noCollission()


        );

    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 5;
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
        return this.defaultBlockState().setValue(DIRTOWER2, context.getHorizontalDirection().getOpposite());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(DIRTOWER2, rot.rotate(state.getValue(DIRTOWER2)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(DIRTOWER2)));
    }

    //


    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }




}