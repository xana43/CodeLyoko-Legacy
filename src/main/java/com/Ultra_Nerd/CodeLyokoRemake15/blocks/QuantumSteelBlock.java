package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class QuantumSteelBlock extends Block {

    public static final BooleanProperty formed = BooleanProperty.create("formed");

    public QuantumSteelBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(formed, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(formed);
    }












}
