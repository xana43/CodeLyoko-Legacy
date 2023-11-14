package com.Ultra_Nerd.CodeLyokoLegacy.init.common;

import net.minecraft.entity.damage.*;
import net.minecraft.registry.entry.RegistryEntry;

public record ModDamageSources() {
    //actual sources
    public  static final  DamageSource digitalOceanSource = createDamageSource("digital_ocean",DamageScaling.NEVER,0,
            DamageEffects.DROWNING,
            DeathMessageType.DEFAULT);
    public static final DamageSource marabuntaDamageSource = createDamageSource("marabunta",DamageScaling.ALWAYS,4,
            DamageEffects.THORNS,
            DeathMessageType.DEFAULT);
    public static final DamageSource digitalLavaSource = createDamageSource("digital_lava",DamageScaling.NEVER,0,
            DamageEffects.BURNING,
            DeathMessageType.DEFAULT);
    public static final DamageSource frontierDamageSource = createDamageSource("frontier",DamageScaling.ALWAYS,0,
            DamageEffects.HURT,DeathMessageType.DEFAULT);









//creation methods

    private static  DamageSource createDamageSource(final String messageId,final DamageScaling scaling,
            final float exhaustion,final DamageEffects damageEffects, final DeathMessageType deathMessageType)
    {
        return new DamageSource(RegistryEntry.of(new DamageType("codelyoko:"+messageId,scaling,exhaustion,damageEffects,
                deathMessageType)));
    }
    private static  DamageSource createDamageSource(final String messageId,final DamageScaling scaling,
            final float exhaustion)
    {
        return new DamageSource(RegistryEntry.of(new DamageType("codelyoko:"+messageId,scaling,exhaustion,DamageEffects.HURT,
                DeathMessageType.DEFAULT)));
    }
    private static  DamageSource createDamageSource(final String messageId,
            final float exhaustion,final DamageEffects damageEffects, final DeathMessageType deathMessageType)
    {
        return new DamageSource(RegistryEntry.of(new DamageType("codelyoko:"+messageId,DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER,exhaustion,damageEffects,
                deathMessageType)));
    }
    private static  DamageSource createDamageSource(final String messageId,
            final float exhaustion)
    {
        return new DamageSource(RegistryEntry.of(new DamageType("codelyoko:"+messageId,DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER,exhaustion)));
    }

}
