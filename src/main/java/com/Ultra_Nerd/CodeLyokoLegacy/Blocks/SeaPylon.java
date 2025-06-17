package com.Ultra_Nerd.CodeLyokoLegacy.Blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import org.jetbrains.annotations.Nullable;


public final class SeaPylon extends HorizontalFacingBlock {

    public static final BooleanProperty SELECTED = BooleanProperty.of("selected_for_teleport");
    public static final BooleanProperty SELECTED_END = BooleanProperty.of("selected_as_teleport_endpoint");


    public SeaPylon(final Settings settings) {
        super(settings);

    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(FACING).add(SELECTED).add(SELECTED_END));
    }



    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }


    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }
}