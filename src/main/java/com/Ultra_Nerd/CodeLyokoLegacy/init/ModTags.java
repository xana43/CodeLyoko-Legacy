package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;

public record ModTags() {
    public record Blocks() {
        public static final TagKey<Block> LYOKO_BLOCKS = TagKey.of(Registries.BLOCK.getKey(),
                CodeLyokoMain.codeLyokoPrefix("lyoko_blocks"));

    }

    public record Biomes() {

        public static final TagKey<Biome> LYOKO_BIOME = TagKey.of(RegistryKeys.BIOME,
                CodeLyokoMain.codeLyokoPrefix("is_lyoko"));
    }

    public record ItemTags()
    {
        public static final TagKey<Item> LYOKO_ITEM = TagKey.of(RegistryKeys.ITEM,
                CodeLyokoMain.codeLyokoPrefix("lyoko_item"));
     }

}
