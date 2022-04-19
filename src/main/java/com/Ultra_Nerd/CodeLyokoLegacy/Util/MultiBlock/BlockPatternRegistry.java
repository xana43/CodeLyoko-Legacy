package com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;

public final class BlockPatternRegistry {



 public static final BlockPattern scanner = BlockPatternBuilder.start().aisle(
         "010",
         "020",
         "030")
         .where('1', BlockInWorld.hasState(state -> state.getBlock() == ModBlocks.SCANNER_TOP.get()))
         .where('2',BlockInWorld.hasState(state -> state.getBlock()==ModBlocks.SCANNER_FRAME.get()))
         .where('3',BlockInWorld.hasState(state -> state.getBlock()==ModBlocks.SCANNER_BASE.get()))
         .where('0', BlockInWorld.hasState(BlockStatePredicate.ANY)).build();



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
         ).where('1',BlockInWorld.hasState(state -> state.getBlock() == ModBlocks.QUANTUM_STEEL_BLOCK.get()))
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

}