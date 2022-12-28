package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public final class SeaPylon extends HorizontalFacingBlock {

    public static final BooleanProperty SELECTED = BooleanProperty.of("selected_for_teleport");
    public static final BooleanProperty SELECTED_END = BooleanProperty.of("selected_as_teleport_endpoint");


    public SeaPylon() {
        super(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)

                .strength(-1, Integer.MAX_VALUE)
                .sounds(BlockSoundGroup.GLASS)
                .nonOpaque()
                .luminance(10)


        );

    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(FACING).add(SELECTED).add(SELECTED_END));
    }



    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }


}