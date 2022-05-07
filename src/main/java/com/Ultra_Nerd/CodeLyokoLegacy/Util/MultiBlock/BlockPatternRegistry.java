package com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.predicate.block.BlockStatePredicate;

public final class BlockPatternRegistry {



 public static final BlockPattern scanner = BlockPatternBuilder.start().aisle(
         "010",
         "020",
         "030")
         .where('1', CachedBlockPosition.matchesBlockState(state -> state.getBlock() == ModBlocks.SCANNER_TOP))
         .where('2', CachedBlockPosition.matchesBlockState(state -> state.getBlock()==ModBlocks.SCANNER_FRAME))
         .where('3', CachedBlockPosition.matchesBlockState(state -> state.getBlock()==ModBlocks.SCANNER_BASE))
         .where('0', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY)).build();

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


