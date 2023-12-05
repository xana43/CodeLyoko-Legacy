package com.Ultra_Nerd.CodeLyokoLegacy.Init.common;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.item.ItemConvertible;

public record ModFuels() {
    public static final Object2ObjectMap<ItemConvertible, Integer> FUEL_MAP = Object2ObjectMaps.unmodifiable(new Object2ObjectOpenHashMap<>() {{
            put(ModItems.URANIUM_ISOTOPE235, MethodUtil.TickConversion.secondsToTicks(130));
                put(ModBlocks.URANIUM_BLOCK_235, MethodUtil.TickConversion.secondsToTicks(30));
        }}
    );
}
