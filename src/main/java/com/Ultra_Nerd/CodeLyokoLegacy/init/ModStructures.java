package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.world.ModFeatures.structures.Tower.TowerBase;
import com.mojang.serialization.Codec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;

public record ModStructures() {
    public static final StructureType<TowerBase> towerStruct;
    static {
        towerStruct = registerStructure("tower_base",TowerBase.CODEC);
    }
    private static<T extends Structure> StructureType<T> registerStructure(final String structureName, final Codec<T> codec)
    {
        return Registry.register(Registries.STRUCTURE_TYPE,CodeLyokoMain.codeLyokoPrefix(structureName),() -> codec);
    }

    public static void registerNewStructures() {}

}
