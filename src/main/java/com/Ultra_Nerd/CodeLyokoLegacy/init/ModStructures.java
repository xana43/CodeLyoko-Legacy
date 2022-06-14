package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.world.ModFeatures.structures.Tower.TowerBase;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;

public record ModStructures() {
    public static final StructureType<TowerBase> towerStruct = new TowerBase(net.minecraft.world.gen.feature.SingleStateFeatureConfig.CODEC);






    public static final ImmutableMap<String,StructureType<?>> structmap = ImmutableMap.<String,StructureType<?>>builder()
            .put("tower_base", towerStruct)


            .build();

}
