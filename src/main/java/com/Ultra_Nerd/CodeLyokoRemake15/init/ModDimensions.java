package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.world.WorldGen.Carthage.CarthageBiomeProvider;
import com.Ultra_Nerd.CodeLyokoRemake15.world.WorldGen.Carthage.CarthageGenerator;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

//@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID)
public class ModDimensions {
    //registry references


    //dimensions
    public static final ResourceKey<Level> SECTOR5  = ResourceKey.create(Registry.DIMENSION_REGISTRY,CodeLyokoMain.CodeLyokoPrefix("carthage"));
    public static final ResourceKey<DimensionType> SECTOR5_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,CodeLyokoMain.CodeLyokoPrefix("carthage_type"));

    public static final ResourceKey<Level> FOREST = ResourceKey.create(Registry.DIMENSION_REGISTRY,CodeLyokoMain.CodeLyokoPrefix("forest"));
    public static final ResourceKey<Level> DESERT = ResourceKey.create(Registry.DIMENSION_REGISTRY,CodeLyokoMain.CodeLyokoPrefix("desert"));
    public static final ResourceKey<Level> ICE = ResourceKey.create(Registry.DIMENSION_REGISTRY, CodeLyokoMain.CodeLyokoPrefix("ice"));
    public static final ResourceKey<Level> MOUNTAIN = ResourceKey.create(Registry.DIMENSION_REGISTRY,CodeLyokoMain.CodeLyokoPrefix("mountain"));
    public static final ResourceKey<Level> VOLCANO = ResourceKey.create(Registry.DIMENSION_REGISTRY,CodeLyokoMain.CodeLyokoPrefix("volcano"));
    public static final ResourceKey<Level> DIGITAL_OCEAN = ResourceKey.create(Registry.DIMENSION_REGISTRY,CodeLyokoMain.CodeLyokoPrefix("digital_ocean"));






    public static void init()
    {




        Registry.register(Registry.CHUNK_GENERATOR,CodeLyokoMain.CodeLyokoPrefix("carthage_chunkgen"), CarthageGenerator.CARTHAGE_GENERATOR_CODEC);
        Registry.register(Registry.BIOME_SOURCE,CodeLyokoMain.CodeLyokoPrefix("carthage_biome"), CarthageBiomeProvider.CARTHAGE_BIOME_PROVIDER_CODEC);

    }


}
