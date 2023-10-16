package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.AdvancementEntry;

import java.util.function.Consumer;

import static com.Ultra_Nerd.CodeLyokoLegacy.init.ModAdvancements.constructAdvancementTree;

public final class CustomAdvancements extends FabricAdvancementProvider {
    public CustomAdvancements(final FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(final Consumer<AdvancementEntry> consumer) {
        new Advancements().accept(consumer);
    }

    private record Advancements() implements Consumer<Consumer<AdvancementEntry>>
    {
        @Override
        public void accept(final Consumer<AdvancementEntry> advancementConsumer) {
            constructAdvancementTree(advancementConsumer);
        }

    }
}
