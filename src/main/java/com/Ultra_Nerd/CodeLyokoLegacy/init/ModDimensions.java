package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

//@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID)
public record ModDimensions() {


    //sector5
    public static final RegistryKey<World> carthage = RegistryKey.of(RegistryKeys.WORLD,
            RegistryKey.of(RegistryKeys.DIMENSION, CodeLyokoMain.codeLyokoPrefix("carthage")).getValue());
    public static final RegistryKey<DimensionType> carthageType = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            CodeLyokoMain.codeLyokoPrefix("carthage_type"));

    //forest Sector
    public static final RegistryKey<World> forestSectorWorld = RegistryKey.of(RegistryKeys.WORLD,
            RegistryKey.of(RegistryKeys.DIMENSION, CodeLyokoMain.codeLyokoPrefix("forest")).getValue());
    public static final RegistryKey<DimensionType> forestSectorType = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            CodeLyokoMain.codeLyokoPrefix("forestsector_type"));

    //Desert Sector
    public static final RegistryKey<World> desertSectorWorld = RegistryKey.of(RegistryKeys.WORLD,
            RegistryKey.of(RegistryKeys.DIMENSION, CodeLyokoMain.codeLyokoPrefix("desert")).getValue());
    public static final RegistryKey<DimensionType> desertSectorType = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            CodeLyokoMain.codeLyokoPrefix("desertsector_type"));

    //Ice Sector
    public static final RegistryKey<World> iceSectorWorld = RegistryKey.of(RegistryKeys.WORLD,
            RegistryKey.of(RegistryKeys.DIMENSION, CodeLyokoMain.codeLyokoPrefix("ice")).getValue());
    public static final RegistryKey<DimensionType> iceSectorType = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            CodeLyokoMain.codeLyokoPrefix("icesector_type"));

    //Mountain Sector
    public static final RegistryKey<World> mountainSectorWorld = RegistryKey.of(RegistryKeys.WORLD,
            RegistryKey.of(RegistryKeys.DIMENSION, CodeLyokoMain.codeLyokoPrefix("mountain")).getValue());
    public static final RegistryKey<DimensionType> mountainSectorType = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            CodeLyokoMain.codeLyokoPrefix("mountainsector_type"));

    //digital ocean
    public static final RegistryKey<World> digitalOceanWorld = RegistryKey.of(RegistryKeys.WORLD,
            RegistryKey.of(RegistryKeys.DIMENSION, CodeLyokoMain.codeLyokoPrefix("digital_ocean")).getValue());
    public static final RegistryKey<DimensionType> digitalOceanType = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            CodeLyokoMain.codeLyokoPrefix("digital_ocean_type"));

    //volcano sector
    public static final RegistryKey<World> volcanoWorld = RegistryKey.of(RegistryKeys.WORLD,
            RegistryKey.of(RegistryKeys.DIMENSION, CodeLyokoMain.codeLyokoPrefix("volcano")).getValue());
    public static final RegistryKey<DimensionType> volcanoType = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            CodeLyokoMain.codeLyokoPrefix("volcanosector_type"));

    //frontier
    public static final RegistryKey<World> frontierWorld = RegistryKey.of(RegistryKeys.WORLD,
            RegistryKey.of(RegistryKeys.DIMENSION, CodeLyokoMain.codeLyokoPrefix("frontier")).getValue());
    public static final RegistryKey<DimensionType> frontierType = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            CodeLyokoMain.codeLyokoPrefix("frontier_type"));


}
