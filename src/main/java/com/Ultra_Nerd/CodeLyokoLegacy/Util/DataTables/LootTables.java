package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables.DataProviders.LootProvider;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.minecraft.data.DataGenerator;

public final class LootTables extends LootProvider {
    public LootTables(final DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void addTables() {
        dataMap.put(ModBlocks.BORNITE_ORE.get(), createBlockTabe("bornite_ore",ModBlocks.BORNITE_ORE.get()));

    }
}
