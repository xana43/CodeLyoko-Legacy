package com.Ultra_Nerd.CodeLyokoLegacy.util.DamageSources;

import net.minecraft.entity.damage.DamageSource;

public final class LyokoDamage extends DamageSource {

    public LyokoDamage(final String name) {
        super(name);
    }

    @Override
    public DamageSource setBypassesArmor() {
        return super.setBypassesArmor();
    }
}