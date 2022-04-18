package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class CustomTags {
    public static final TagKey<Block> CODELYOKO_URANIUM_ORE = TagKey.create(Registry.BLOCK_REGISTRY, CodeLyokoMain.CodeLyokoPrefix("uranium_ore"));
    public static final TagKey<Item> CODELYOKO_URANIUM_ORE_ITEM = TagKey.create(Registry.ITEM_REGISTRY, CodeLyokoMain.CodeLyokoPrefix("uranium_ore_item"));
}
