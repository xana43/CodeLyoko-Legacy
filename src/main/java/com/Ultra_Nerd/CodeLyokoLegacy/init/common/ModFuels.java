package com.Ultra_Nerd.CodeLyokoLegacy.init.common;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.google.common.collect.ImmutableMap;
import net.minecraft.item.ItemConvertible;

public record ModFuels() {
    public static final ImmutableMap<ItemConvertible, Integer> FUEL_MAP = ImmutableMap.<ItemConvertible, Integer>builder()
            .put(ModItems.URANIUM_ISOTOPE235, MethodUtil.TickConversion.secondsToTicks(130))
            .put(ModBlocks.URANIUM_BLOCK_235, MethodUtil.TickConversion.secondsToTicks(30))
            .build();
}
