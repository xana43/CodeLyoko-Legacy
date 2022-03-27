package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.world.WorldGen.Carthage.CarthageBiomeProvider;
import com.Ultra_Nerd.CodeLyokoRemake15.world.WorldGen.Carthage.CarthageGenerator;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;

//@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID)
public class ModDimensions {
    //registry references


    //dimensions
    public static final ResourceKey<Level> SECTOR5  = ResourceKey.create(Registry.DIMENSION_REGISTRY,CodeLyokoMain.CodeLyokoPrefix("carthage"));
    public static final ResourceKey<Level> FOREST = ResourceKey.create(Registry.DIMENSION_REGISTRY,CodeLyokoMain.CodeLyokoPrefix("forest_sector"));
    public static final ResourceKey<Level> DESERT = ResourceKey.create(Registry.DIMENSION_REGISTRY,CodeLyokoMain.CodeLyokoPrefix("desert_sector"));
    public static final ResourceKey<Level> ICE = ResourceKey.create(Registry.DIMENSION_REGISTRY, CodeLyokoMain.CodeLyokoPrefix("ice_sector"));
    public static final ResourceKey<Level> MOUNTAIN = ResourceKey.create(Registry.DIMENSION_REGISTRY,CodeLyokoMain.CodeLyokoPrefix("mountain_sector"));
    public static final ResourceKey<Level> VOLCANO = ResourceKey.create(Registry.DIMENSION_REGISTRY,CodeLyokoMain.CodeLyokoPrefix("volcano_sector"));
    //dimension types key
    public static final ResourceKey<DimensionType> SECTOR5_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,CodeLyokoMain.CodeLyokoPrefix("carthage_type"));

    //dimension Stems
    public static final ResourceKey<LevelStem> SECTOR5_STEM = ResourceKey.create(Registry.LEVEL_STEM_REGISTRY,CodeLyokoMain.CodeLyokoPrefix("carthage_stem"));

    public static void init()
    {




        Registry.register(Registry.CHUNK_GENERATOR,CodeLyokoMain.CodeLyokoPrefix("carthage_chunkgen"), CarthageGenerator.CARTHAGE_GENERATOR_CODEC);
        Registry.register(Registry.BIOME_SOURCE,CodeLyokoMain.CodeLyokoPrefix("carthage_biome"), CarthageBiomeProvider.CARTHAGE_BIOME_PROVIDER_CODEC);

    }


}
