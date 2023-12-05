package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModBiomes;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModTags;
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
        for(final ModBiomes.RegisteredBiomes biomes : ModBiomes.RegisteredBiomes.values())
        {
            if(biomes != ModBiomes.RegisteredBiomes.VOLCANO && biomes != ModBiomes.RegisteredBiomes.FRONTIER)
            {
                getOrCreateTagBuilder(ModTags.Biomes.LYOKO_BIOMES).add(biomes.getBiomesValue());
            }
            if (biomes != ModBiomes.RegisteredBiomes.FRONTIER && biomes != ModBiomes.RegisteredBiomes.DIGITAL_OCEAN && biomes != ModBiomes.RegisteredBiomes.SECTOR5)
            {
                getOrCreateTagBuilder(ModTags.Biomes.HAS_TOWER).add(biomes.getBiomesValue());
            }
            if( biomes == ModBiomes.RegisteredBiomes.VOLCANO)
            {
                getOrCreateTagBuilder(ModTags.Biomes.REPLIKA_BIOMES).add(biomes.getBiomesValue());
            }
        }
    }
}
