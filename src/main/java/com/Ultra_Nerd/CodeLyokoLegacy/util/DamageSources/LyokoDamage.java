package com.Ultra_Nerd.CodeLyokoLegacy.util.DamageSources;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.entry.RegistryEntry;

public final class LyokoDamage extends DamageSource {
    public LyokoDamage(final RegistryEntry<DamageType> type) {
        super(type);
    }
}

