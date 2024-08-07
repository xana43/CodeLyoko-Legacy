package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModAdvancements.constructAdvancementTree;

public final class CustomAdvancements extends FabricAdvancementProvider {
    public CustomAdvancements(final FabricDataOutput output,final CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output,registryLookup);
    }

    @Override
    public void generateAdvancement(final RegistryWrapper.WrapperLookup registryLookup,final Consumer<AdvancementEntry> consumer) {
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
