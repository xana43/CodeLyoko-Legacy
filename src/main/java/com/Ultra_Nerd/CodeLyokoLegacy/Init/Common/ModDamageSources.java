package com.Ultra_Nerd.CodeLyokoLegacy.Init.Common;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public record ModDamageSources() {
    private static final ConcurrentHashMap<RegistryKey<DamageType>,DamageSource> DAMAGE_SOURCE_CACHE = new ConcurrentHashMap<>(8);

    public static DamageSource of(final World world,final RegistryKey<DamageType> key) {
        Objects.requireNonNull(world, "world is null");
        Objects.requireNonNull(key, "key is null");
        return DAMAGE_SOURCE_CACHE.computeIfAbsent(key,damageTypeRegistryKey -> new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(damageTypeRegistryKey)));
    }
}
