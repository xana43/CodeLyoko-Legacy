package com.Ultra_Nerd.CodeLyokoLegacy.util.MultiBlock;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.predicate.block.BlockStatePredicate;

public enum BlockPatternRegistry {


    SCANNER(BlockPatternBuilder.start().aisle(
                    "1",
                    "2",
                    "3")
            .where('1', CachedBlockPosition.matchesBlockState(state -> state.getBlock() == ModBlocks.SCANNER_TOP))
            .where('2', CachedBlockPosition.matchesBlockState(state -> state.getBlock() == ModBlocks.SCANNER_FRAME))
            .where('3', CachedBlockPosition.matchesBlockState(state -> state.getBlock() == ModBlocks.SCANNER_BASE))
            .build()),
    SCREEN_FRAME(BlockPatternBuilder.start()
            .aisle(
                    "30003",
                    "30003",
                    "30103"

            )
            .aisle("42224",
                    "43334",
                    "42224")

            .where('1',CachedBlockPosition.matchesBlockState(blockState -> blockState.isOf(ModBlocks.COMPUTER_KEYBOARD)))
            .where('2',CachedBlockPosition.matchesBlockState(blockState -> blockState.isOf(ModBlocks.COMPUTER_SCREEN_FRAME)))
            .where('3',CachedBlockPosition.matchesBlockState(blockState -> blockState.isOf(ModBlocks.COMPUTER_SCREEN)))
            .where('4',CachedBlockPosition.matchesBlockState(blockState -> blockState.isOf(ModBlocks.COMPUTER_SCREEN_CONNECTOR)))
            .where('0',CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY))
            .build());


    private final BlockPattern thisBlockPattern;

    BlockPatternRegistry(final BlockPattern pattern) {
        this.thisBlockPattern = pattern;
    }

    public BlockPattern getThisBlockPattern() {
        return thisBlockPattern;
    }




}


