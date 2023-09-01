package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.util.AdditionalStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Optional;

public final class ComputerFluidPipe extends BlockWithEntity {
    //NOTE: this is in liters as 1m³ is 1 Kiloliter
    public static final AdditionalStateProperties.FloatProperty STORED_FLUID =
            AdditionalStateProperties.FloatProperty.of("stored_fluid",0,1);
    public ComputerFluidPipe(final Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(STORED_FLUID));
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return null;
    }
}
