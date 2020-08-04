package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;

public class QuantumSteelBlock extends Block {
    public static final BooleanProperty formed = BooleanProperty.create("formed");
    public QuantumSteelBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.getStateContainer().getBaseState().with(formed,false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(formed);
    }


}
