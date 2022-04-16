package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage.CarthageBiomeProvider;
import com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage.CarthageGenerator;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

//@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID)
public final class ModDimensions {
    //registry references


    //dimensions
    public static final ResourceKey<Level> SECTOR5  = generateDimensionResourceKey("carthage");
    public static final ResourceKey<Level> FOREST = generateDimensionResourceKey("forest");
    public static final ResourceKey<Level> DESERT = generateDimensionResourceKey("desert");
    public static final ResourceKey<Level> ICE = generateDimensionResourceKey("ice");
    public static final ResourceKey<Level> MOUNTAIN = generateDimensionResourceKey("mountain");
    public static final ResourceKey<Level> VOLCANO = generateDimensionResourceKey("volcano");
    public static final ResourceKey<Level> DIGITAL_OCEAN = generateDimensionResourceKey("digital_ocean");
    public static final ResourceKey<Level> FRONTIER = generateDimensionResourceKey("frontier");

    private static @NotNull ResourceKey<Level> generateDimensionResourceKey(String name)
    {
       return ResourceKey.create(Registry.DIMENSION_REGISTRY,CodeLyokoMain.CodeLyokoPrefix(name));
    }



    public static void init()
    {




        Registry.register(Registry.CHUNK_GENERATOR,CodeLyokoMain.CodeLyokoPrefix("carthage_chunkgen"), CarthageGenerator.CARTHAGE_GENERATOR_CODEC);
        Registry.register(Registry.BIOME_SOURCE,CodeLyokoMain.CodeLyokoPrefix("carthage_biome"), CarthageBiomeProvider.CARTHAGE_BIOME_PROVIDER_CODEC);

    }


}
