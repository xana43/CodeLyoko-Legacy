package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Decoration;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModBlocks;
import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;

import java.util.Optional;
import java.util.function.Supplier;

public interface ModdedOxidizable extends Oxidizable{
    Supplier<BiMap<Block, Block>> MODDED_OXIDATION_LEVEL_INCREASES = Suppliers.memoize(() -> ImmutableBiMap.<Block,Block>builder()
            .put(ModBlocks.IRON_RAILING,ModBlocks.ERODED_IRON_RAILING).put(ModBlocks.ERODED_IRON_RAILING,ModBlocks.TARNISHED_IRON_RAILING).put(ModBlocks.TARNISHED_IRON_RAILING,ModBlocks.RUSTED_IRON_RAILING).build());
    Supplier<BiMap<Block,Block>> MODDED_OXIDATION_LEVEL_DECREASES = Suppliers.memoize(() -> MODDED_OXIDATION_LEVEL_INCREASES.get().inverse());
    static Optional<Block> getModdedDecreasedOxidationBlock(Block block) {
        return Optional.ofNullable(OxidizeableFenceBlock.MODDED_OXIDATION_LEVEL_DECREASES.get().get(block));
    }

    static Block getUnaffectedModdedOxidationBlock(Block block) {
        Block block2 = block;

        for (Block block3 = (Block) ((BiMap) MODDED_OXIDATION_LEVEL_DECREASES.get()).get(block); block3 != null; block3 = (Block) ((BiMap) MODDED_OXIDATION_LEVEL_DECREASES.get()).get(block3)) {
            block2 = block3;
        }
        return block2;
    }

    static Optional<BlockState> getModdedDecreasedOxidationState(BlockState state) {
        return getModdedDecreasedOxidationBlock(state.getBlock()).map((block) -> block.getStateWithProperties(state));
    }
    default Optional<BlockState> getModdedDegradationResult(BlockState state) {
        return getModdedIncreasedOxidationBlock(state.getBlock()).map((block) -> block.getStateWithProperties(state));
    }
    static Optional<Block> getModdedIncreasedOxidationBlock(Block block) {
        return Optional.ofNullable((Block) ((BiMap) MODDED_OXIDATION_LEVEL_INCREASES.get()).get(block));
    }

    static BlockState getModdedUnaffectedOxidationState(BlockState state) {
        return getUnaffectedModdedOxidationBlock(state.getBlock()).getStateWithProperties(state);
    }
}
