package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import org.jetbrains.annotations.Nullable;


public final class SeaPylon extends HorizontalFacingBlock {


    public SeaPylon() {
        super(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)

                .strength(-1, -1)
                .sounds(BlockSoundGroup.GLASS)
                .nonOpaque()
                .luminance(10)


        );

    }


    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }


}