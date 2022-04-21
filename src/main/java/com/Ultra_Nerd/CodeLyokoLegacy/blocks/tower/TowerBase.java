package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower;




public final class TowerBase extends TowerWall {

    public TowerBase(final Settings settings) {
        super(settings);
    }

    @Override
    public boolean canMobSpawnInside() {
        return false;
    }
}
