package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import javax.annotation.Nonnull;


public class SeaPylon extends Block {

    public static final DirectionProperty DIRPYLON = BlockStateProperties.HORIZONTAL_FACING;

    public SeaPylon() {
        super(Properties.of(new Material.Builder(MaterialColor.METAL).build())

                .strength(-1, -1)
                .sound(SoundType.GLASS)
                .noOcclusion()



        );

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRPYLON);
    }




    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 5;
    }



    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // TODO Auto-generated method stub
        return this.defaultBlockState().setValue(DIRPYLON, context.getHorizontalDirection().getOpposite());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(DIRPYLON, rot.rotate(state.getValue(DIRPYLON)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(DIRPYLON)));
    }
    //





}