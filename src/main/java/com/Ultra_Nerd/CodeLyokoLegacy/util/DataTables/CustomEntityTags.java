package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public final class CustomEntityTags extends FabricTagProvider.EntityTypeTagProvider {
    public CustomEntityTags(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(final RegistryWrapper.WrapperLookup arg) {
    }
}
