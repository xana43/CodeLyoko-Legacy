package com.Ultra_Nerd.CodeLyokoLegacy.util.MultiBlock;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.predicate.block.BlockStatePredicate;

public enum BlockPatternRegistry {


    SCANNER(BlockPatternBuilder.start().aisle(
                    "010",
                    "020",
                    "030")
            .where('1', CachedBlockPosition.matchesBlockState(state -> state.getBlock() == ModBlocks.SCANNER_TOP))
            .where('2', CachedBlockPosition.matchesBlockState(state -> state.getBlock() == ModBlocks.SCANNER_FRAME))
            .where('3', CachedBlockPosition.matchesBlockState(state -> state.getBlock() == ModBlocks.SCANNER_BASE))
            .where('0', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).build()),
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
            .where('0',CachedBlockPosition.matchesBlockState(blockState -> blockState.isOf(Blocks.AIR)))
            .build());


    private final BlockPattern thisBlockPatttern;

    BlockPatternRegistry(final BlockPattern pattern) {
        this.thisBlockPatttern = pattern;
    }

    public BlockPattern getThisBlockPatttern() {
        return thisBlockPatttern;
    }









/*

 public static final BlockPattern HoloProjector = BlockPatternBuilder.start().aisle(
         "010",
         "111"
         )
         .aisle(
                 "121",
                 "111"
                 ).aisle(
                         "010",
                         "111"
         ).where('1',CachedBlockPosition.matchesBlockState(state -> state.getBlock() == ModBlocks.QUANTUM_STEEL_BLOCK))
         .where('2',BlockInWorld.hasState(state -> state.getBlock() == ModBlocks.HOLOPROJECTOR.get()))
         .where('0',BlockInWorld.hasState(BlockStatePredicate.ANY)).build();

 public static final BlockPattern SuperCalculatorScreen = BlockPatternBuilder.start().aisle(
         "1000001",
         "1000001",
         "1000001"
 ).aisle(
         "2211122",
         "2211122",
         "2211122"
 )
         .where('0',BlockInWorld.hasState(BlockStatePredicate.ANY))
         .where('1',BlockInWorld.hasState(state -> state.getBlock() == ModBlocks.COMPUTER_SCREEN.get()))
         .where('2',BlockInWorld.hasState(state -> state.getBlock() == ModBlocks.COMPUTER_SCREEN_CONNECTOR.get())).build();

 */


}


