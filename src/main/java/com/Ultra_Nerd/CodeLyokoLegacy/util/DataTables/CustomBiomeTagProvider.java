package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBiomes;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.biome.Biome;

import java.util.concurrent.CompletableFuture;

public final class CustomBiomeTagProvider extends FabricTagProvider<Biome> {
    /**
     * Constructs a new {@link FabricTagProvider} with the default computed path.
     *
     * <p>Common implementations of this class are provided.
     *
     * @param output           the {@link FabricDataOutput} instance
     * @param registriesFuture the backing registry for the tag type
     */
    public CustomBiomeTagProvider(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BIOME, registriesFuture);
    }

    @Override
    protected RegistryKey<Biome> reverseLookup(final Biome element) {
       for(final ModBiomes.RegisteredBiomes biomes : ModBiomes.RegisteredBiomes.values())
       {
           if(biomes.getBiomesValue() == element)
           {
               return biomes.getBiomesRegistryKey();
           }
       }
       return null;
    }

    @Override
    protected void configure(final RegistryWrapper.WrapperLookup arg) {
        for(final ModBiomes.RegisteredBiomes biome : ModBiomes.RegisteredBiomes.values())
        {
            if(biome != ModBiomes.RegisteredBiomes.VOLCANO && biome != ModBiomes.RegisteredBiomes.FRONTIER)
            {
                getOrCreateTagBuilder(ModTags.Biomes.LYOKO_BIOMES).add(biome.getBiomesValue());
            }
            if (biome != ModBiomes.RegisteredBiomes.FRONTIER && biome != ModBiomes.RegisteredBiomes.DIGITAL_OCEAN && biome != ModBiomes.RegisteredBiomes.SECTOR5)
            {
                getOrCreateTagBuilder(ModTags.Biomes.HAS_TOWER).add(biome.getBiomesValue());
            }
            if( biome == ModBiomes.RegisteredBiomes.VOLCANO)
            {
                getOrCreateTagBuilder(ModTags.Biomes.REPLIKA_BIOMES).add(biome.getBiomesValue());
            }
        }
    }
}
