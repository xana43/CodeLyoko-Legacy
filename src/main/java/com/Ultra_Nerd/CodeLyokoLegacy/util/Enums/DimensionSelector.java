package com.Ultra_Nerd.CodeLyokoLegacy.util.Enums;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModDimensions;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.World;

public enum DimensionSelector {
    FOREST(ModDimensions.forestSectorWorld),
    DESERT(ModDimensions.desertSectorWorld),
    ICE(ModDimensions.iceSectorWorld),
    MOUNTAIN(ModDimensions.mountainSectorWorld),
    CARTHAGE(ModDimensions.carthage),
    DIGITAL_OCEAN(ModDimensions.digitalOceanWorld),
    VOLCANO(ModDimensions.volcanoWorld);

    private final RegistryKey<World> worldRegistryKey;

    DimensionSelector(final RegistryKey<World> worldRegistryKey) {
        this.worldRegistryKey = worldRegistryKey;
    }

    public final RegistryKey<World> getWorldRegistryKey() {
        return worldRegistryKey;
    }
}
