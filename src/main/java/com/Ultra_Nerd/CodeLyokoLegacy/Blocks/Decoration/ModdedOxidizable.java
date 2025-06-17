package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Decoration;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Degradable;
import net.minecraft.block.Oxidizable;
import net.minecraft.util.StringIdentifiable;

import java.util.Optional;
import java.util.function.Supplier;

public interface ModdedOxidizable extends Degradable<Oxidizable.OxidationLevel> {
    Supplier<BiMap<Block, Block>> MODDED_OXIDATION_LEVEL_INCREASES = Suppliers.memoize(() -> ImmutableBiMap.<Block,Block>builder()
            .put(ModBlocks.IRON_RAILING,ModBlocks.ERODED_IRON_RAILING).put(ModBlocks.ERODED_IRON_RAILING,ModBlocks.TARNISHED_IRON_RAILING).put(ModBlocks.TARNISHED_IRON_RAILING,ModBlocks.RUSTED_IRON_RAILING).buildOrThrow());
    Supplier<BiMap<Block,Block>> MODDED_OXIDATION_LEVEL_DECREASES = Suppliers.memoize(() -> MODDED_OXIDATION_LEVEL_INCREASES.get().inverse());
    static Optional<Block> getDecreasedOxidationBlock(Block block) {
        return null; //Optional.ofNullable(OxidizeableFenceBlock.MODDED_OXIDATION_LEVEL_DECREASES.get().get(block));
    }

    static Block getUnaffectedOxidationBlock(Block block) {
        Block block2 = block;
        for (Block block3 = (Block) ((BiMap<?, ?>) MODDED_OXIDATION_LEVEL_DECREASES.get()).get(block); block3 != null; block3 = (Block) ((BiMap<?, ?>) MODDED_OXIDATION_LEVEL_DECREASES.get()).get(block3)) {
            block2 = block3;
        }
        return block2;
    }

    static Optional<BlockState> getDecreasedOxidationState(BlockState state) {
        return getDecreasedOxidationBlock(state.getBlock()).map((block) -> block.getStateWithProperties(state));
    }

    static Optional<Block> getIncreasedOxidationBlock(Block block) {
        return Optional.ofNullable((Block) ((BiMap) MODDED_OXIDATION_LEVEL_INCREASES.get()).get(block));
    }

    static BlockState getUnaffectedOxidationState(BlockState state) {
        return getUnaffectedOxidationBlock(state.getBlock()).getStateWithProperties(state);
    }
    default Optional<BlockState> getDegradationResult(BlockState state) {
        return getIncreasedOxidationBlock(state.getBlock()).map((block) -> block.getStateWithProperties(state));
    }

    default float getDegradationChanceMultiplier() {
        return this.getDegradationLevel() == Oxidizable.OxidationLevel.UNAFFECTED ? 0.75F : 1.0F;
    }
    public static enum OxidationLevel implements StringIdentifiable {
        UNAFFECTED("unaffected"),
        EXPOSED("exposed"),
        WEATHERED("weathered"),
        OXIDIZED("oxidized");

        public static final Codec<Oxidizable.OxidationLevel> CODEC = StringIdentifiable.createCodec(Oxidizable.OxidationLevel::values);
        private final String id;

        private OxidationLevel(final String id) {
            this.id = id;
        }

        public String asString() {
            return this.id;
        }
    }
}
