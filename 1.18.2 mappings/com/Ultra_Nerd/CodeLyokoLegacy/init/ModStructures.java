package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.world.ModFeatures.structures.Tower.TowerBase;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public record ModStructures() {
    public static final StructureFeature<?> towerStruct = new TowerBase(StructurePoolFeatureConfig.CODEC);






    public static final ImmutableMap<String,StructureFeature<?>> structmap = ImmutableMap.<String,StructureFeature<?>>builder()
            .put("tower_base", towerStruct)


            .build();

}
