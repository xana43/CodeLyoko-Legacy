package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

//@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID)
public record ModDimensions() {


    //sector5
    public static final RegistryKey<World> carthage = RegistryKey.of(Registry.WORLD_KEY,
            RegistryKey.of(Registry.DIMENSION_KEY, CodeLyokoMain.codeLyokoPrefix("carthage")).getValue());
    public static final RegistryKey<DimensionType> carthageType = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            CodeLyokoMain.codeLyokoPrefix("carthage_type"));

    //forest Sector
    public static final RegistryKey<World> forestSectorWorld = RegistryKey.of(Registry.WORLD_KEY,
            RegistryKey.of(Registry.DIMENSION_KEY, CodeLyokoMain.codeLyokoPrefix("forest")).getValue());
    public static final RegistryKey<DimensionType> forestSectorType = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            CodeLyokoMain.codeLyokoPrefix("forestsector_type"));

    //Desert Sector
    public static final RegistryKey<World> desertSectorWorld = RegistryKey.of(Registry.WORLD_KEY,
            RegistryKey.of(Registry.DIMENSION_KEY, CodeLyokoMain.codeLyokoPrefix("desert")).getValue());
    public static final RegistryKey<DimensionType> desertSectorType = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            CodeLyokoMain.codeLyokoPrefix("desertsector_type"));

    //Ice Sector
    public static final RegistryKey<World> iceSectorWorld = RegistryKey.of(Registry.WORLD_KEY,
            RegistryKey.of(Registry.DIMENSION_KEY, CodeLyokoMain.codeLyokoPrefix("ice")).getValue());
    public static final RegistryKey<DimensionType> iceSectorType = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            CodeLyokoMain.codeLyokoPrefix("icesector_type"));

    //Mountain Sector
    public static final RegistryKey<World> mountainSectorWorld = RegistryKey.of(Registry.WORLD_KEY,
            RegistryKey.of(Registry.DIMENSION_KEY, CodeLyokoMain.codeLyokoPrefix("mountain")).getValue());
    public static final RegistryKey<DimensionType> mountainSectorType = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            CodeLyokoMain.codeLyokoPrefix("mountainsector_type"));

    //digital ocean
    public static final RegistryKey<World> digitalOceanWorld = RegistryKey.of(Registry.WORLD_KEY,
            RegistryKey.of(Registry.DIMENSION_KEY, CodeLyokoMain.codeLyokoPrefix("digital_ocean")).getValue());
    public static final RegistryKey<DimensionType> digitalOceanType = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            CodeLyokoMain.codeLyokoPrefix("digital_ocean_type"));

    //volcano sector
    public static final RegistryKey<World> volcanoWorld = RegistryKey.of(Registry.WORLD_KEY,
            RegistryKey.of(Registry.DIMENSION_KEY, CodeLyokoMain.codeLyokoPrefix("volcano")).getValue());
    public static final RegistryKey<DimensionType> volcanoType = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            CodeLyokoMain.codeLyokoPrefix("volcanosector_type"));

    //frontier
    public static final RegistryKey<World> frontierWorld = RegistryKey.of(Registry.WORLD_KEY,
            RegistryKey.of(Registry.DIMENSION_KEY, CodeLyokoMain.codeLyokoPrefix("frontier")).getValue());
    public static final RegistryKey<DimensionType> frontierType = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            CodeLyokoMain.codeLyokoPrefix("frontier_type"));


}
