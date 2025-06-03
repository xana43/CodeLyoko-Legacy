package com.Ultra_Nerd.CodeLyokoLegacy.Init.Common;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.entity.damage.DamageEffects;
import net.minecraft.entity.damage.DamageScaling;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DeathMessageType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

/**
 * @author Ultra_Nerd
 * @desc <br/>
 * @since 2025-06-02
 */
public record ModDamageTypes() {
    public static final Object2ObjectMap<RegistryKey<DamageType>,DamageType> DAMAGE_TYPE_MAP = new Object2ObjectOpenHashMap<>();
    public static final RegistryKey<DamageType> DIGITAL_OCEAN;
    public static final RegistryKey<DamageType> MARABUNTA_DAMAGE;
    public static final RegistryKey<DamageType> DIGITAL_LAVA;
    public static final RegistryKey<DamageType> FRONTIER_DAMAGE;
    static {
       DIGITAL_OCEAN = registerDamageType("digital_ocean",DamageScaling.NEVER,0,DamageEffects.DROWNING);
       MARABUNTA_DAMAGE = registerDamageType("marabunta",DamageScaling.ALWAYS,4, DamageEffects.THORNS);
       DIGITAL_LAVA = registerDamageType("digital_lava",DamageScaling.NEVER,0, DamageEffects.BURNING);
       FRONTIER_DAMAGE = registerDamageType("frontier",DamageScaling.ALWAYS,0);
    }
    public static void bootstrap(final Registerable<DamageType> registerable) {
        Object2ObjectMaps.fastForEach(DAMAGE_TYPE_MAP,registryKeyDamageTypeEntry -> {
            registerable.register(registryKeyDamageTypeEntry.getKey(), registryKeyDamageTypeEntry.getValue());
        });
    }
    private static RegistryKey<DamageType> registerDamageType(final String name, final float exhaustion,final DamageEffects effects) {
        return registerDamageType(name,DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER,exhaustion,effects);
    }
    private static RegistryKey<DamageType> registerDamageType(final String name, final float exhaustion) {
        return registerDamageType(name,DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER,exhaustion);
    }
    private static RegistryKey<DamageType> registerDamageType(final String name, final DamageScaling scaling, final float exhaustion) {

        return registerDamageType(name,scaling, exhaustion,DamageEffects.HURT);
    }
    private static RegistryKey<DamageType> registerDamageType(final String name, final DamageScaling scaling, final float exhaustion, final DamageEffects effects) {

        return registerDamageType(name, scaling, exhaustion, effects, DeathMessageType.DEFAULT);
    }
    private static RegistryKey<DamageType> registerDamageType(final String name, final DamageScaling scaling, final float exhaustion, final DamageEffects effects, final DeathMessageType deathMessageType) {
        RegistryKey<DamageType> damageTypeRegistryKey = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, CodeLyokoMain.codeLyokoPrefix(name));
        DamageType newDamageType = new DamageType("codelyoko:"+name, scaling, exhaustion, effects, deathMessageType);
        DAMAGE_TYPE_MAP.put(damageTypeRegistryKey,newDamageType);
        return damageTypeRegistryKey;
    }
}
