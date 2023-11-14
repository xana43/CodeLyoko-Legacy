package com.Ultra_Nerd.CodeLyokoLegacy.init.common;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public record ModTags() {
    public record Blocks() {
        public static final TagKey<Block> LYOKO_BLOCKS = createBlockTag("lyoko_blocks");

        public static final TagKey<Block> COMPUTER_CIRCULATOR = createBlockTag("circulation_blocks");

        private static TagKey<Block> createBlockTag(final String name)
        {
            return TagKey.of(Registries.BLOCK.getKey(),CodeLyokoMain.codeLyokoPrefix(name));
        }
        private static TagKey<Block> createCommonTag(final String name)
        {
            return TagKey.of(Registries.BLOCK.getKey(), new Identifier("c",name));
        }
        public static final TagKey<Block> URANIUM_ORE_TAG = createCommonTag("raw_uranium_ores");
        public static final TagKey<Block> URANIUM_ORES_TAG = createCommonTag("uranium_ores");
        public static final TagKey<Block> URANIUM_235_BLOCKS = createCommonTag("uranium_235_blocks");
        public static final TagKey<Block> URANIUM_238_BLOCKS = createCommonTag("uranium_238_blocks");

        public static final TagKey<Block> COMMON_WATER_TAG = createCommonTag("water");
        public static final TagKey<Block> COMMON_VISUAL_WATER_TAG = createCommonTag("visual/water");
        public static final TagKey<Block> COMMON_LAVA_TAG = createCommonTag("lava");
     }

    public record Biomes() {

        public static final TagKey<Biome> LYOKO_BIOMES = createBiomesTag("is_lyoko");
        public static final TagKey<Biome> REPLIKA_BIOMES = createBiomesTag("is_replika");
        private static TagKey<Biome> createBiomesTag(final String name)
        {
            return TagKey.of(RegistryKeys.BIOME,
                    CodeLyokoMain.codeLyokoPrefix(name));
        }
    }

    public record ItemTags() {
        public static final TagKey<Item> URANIUM_BATTERIES = TagKey.of(RegistryKeys.ITEM,
                CodeLyokoMain.codeLyokoPrefix("uranium_batteries"));
        public static final TagKey<Item> URANIUM_ORE_TAG = createCommonTag("raw_uranium_ores");
        public static final TagKey<Item> URANIUM_ORES_TAG = createCommonTag("uranium_ores");
        public static final TagKey<Item> URANIUM_235_INGOTS = createCommonTag("uranium_235_ingots");
        public static final TagKey<Item> URANIUM_238_INGOTS = createCommonTag("uranium_238_ingots");
        public static final TagKey<Item> LEAD_INGOTS = createCommonTag("lead_ingots");
        public static final TagKey<Item> COMMON_IRON_INGOTS = createCommonTag("iron_ingots");
        public static final TagKey<Item> COMMON_COPPER_INGOTS = createCommonTag("copper_ingots");
        public static final TagKey<Item> COMMON_GRAVEL = createCommonTag("gravel");
        public static final TagKey<Item> COMMON_SILICON = createCommonTag("silicon");
        public static final TagKey<Item> COMMON_SILICON_PLATES = createCommonTag("silicon_plates");
        private static TagKey<Item> createCommonTag(final String name)
        {
            return TagKey.of(Registries.ITEM.getKey(), new Identifier("c",name));
        }
        public static final TagKey<Item> LYOKO_ITEM = TagKey.of(RegistryKeys.ITEM,
                CodeLyokoMain.codeLyokoPrefix("lyoko_item"));
     }
    public record FluidTags()
    {

        public static final TagKey<Fluid> COMMON_WATER_TAG = createCommonTag("water");
        public static final TagKey<Fluid> COMMON_VISUAL_WATER_TAG = createCommonTag("visual/water");
        public static final TagKey<Fluid> COMMON_LAVA_TAG = createCommonTag("lava");

        private static TagKey<Fluid> createCommonTag(final String name)
        {
            return TagKey.of(Registries.FLUID.getKey(), new Identifier("c",name));
        }
    }
}
