package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public final class TowerGeneric extends Block {


    public TowerGeneric() {
        super(FabricBlockSettings.of(Material.BARRIER).strength(-1, -1).sounds(BlockSoundGroup.GLASS).luminance(250));
    }


    @Override
    public boolean canMobSpawnInside() {
        return false;
    }


}
