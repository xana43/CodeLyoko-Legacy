package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public record ModTags() {
    public record Blocks() {
        public static final TagKey<Block> LYOKO_BLOCKS = TagKey.of(Registry.BLOCK_KEY, CodeLyokoMain.CodeLyokoPrefix("lyoko_blocks"));

    }

    public record Biomes() {

        public static final TagKey<Biome> LYOKO_BIOME = TagKey.of(Registry.BIOME_KEY, CodeLyokoMain.CodeLyokoPrefix("is_lyoko"));
    }

}
