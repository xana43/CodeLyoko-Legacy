package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;

public final class QuantumSteelBlock extends Block {

    public static final BooleanProperty formed = BooleanProperty.create("formed");

    public QuantumSteelBlock(@NotNull Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(formed, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(formed);
    }












}
