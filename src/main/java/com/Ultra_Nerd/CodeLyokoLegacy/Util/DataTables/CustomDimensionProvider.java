package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public final class CustomDimensionProvider extends FabricDynamicRegistryProvider {
    public CustomDimensionProvider(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(final RegistryWrapper.WrapperLookup registries, final Entries entries) {

    }

    @Override
    public String getName() {
        return null;
    }
}
