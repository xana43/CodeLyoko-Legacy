package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.world.ModFeatures.structures.Tower.TowerBase;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.StructureType;

public record ModStructures() {
    public static StructureType<TowerBase> towerStruct;


    public static void registerNewStructures() {
        towerStruct = Registry.register(Registries.STRUCTURE_TYPE, new Identifier(CodeLyokoMain.MOD_ID, "tower_base"),
                () -> TowerBase.CODEC);
    }

}
