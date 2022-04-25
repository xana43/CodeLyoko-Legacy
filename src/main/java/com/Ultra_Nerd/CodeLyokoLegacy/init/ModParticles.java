package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;

public final class ModParticles {
public static final DefaultParticleType TOWER_PARTICLE = FabricParticleTypes.simple();

public static final ImmutableMap<String,DefaultParticleType> PARTICLE_TYPE_IMMUTABLE_MAP = ImmutableMap.<String, DefaultParticleType>builder()
        .put("tower_particle",TOWER_PARTICLE)
        .build();

}
