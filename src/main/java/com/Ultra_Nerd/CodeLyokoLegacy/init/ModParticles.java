package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.ParticleUTIL.DefaultLyokoParticleType;
import com.google.common.collect.ImmutableMap;

public record ModParticles() {

    private static DefaultLyokoParticleType Simple(final boolean alwaysShow)
    {
        return new DefaultLyokoParticleType(alwaysShow);
    }
public static final DefaultLyokoParticleType TOWER_PARTICLE = Simple(true);
    public static final DefaultLyokoParticleType TOWER_PARTICLE_XANA = Simple(false);
    public static final DefaultLyokoParticleType TOWER_PARTICLE_JEREMY = Simple(false);
    public static final DefaultLyokoParticleType TOWER_PARTICLE_FRANZ = Simple(false);
    public static final DefaultLyokoParticleType RING_PARTICLE = Simple(false);

public static final ImmutableMap<String,DefaultLyokoParticleType> PARTICLE_TYPE_IMMUTABLE_MAP = ImmutableMap.<String, DefaultLyokoParticleType>builder()
        .put("tower_particle",TOWER_PARTICLE)
        .put("tower_particle_xana",TOWER_PARTICLE_XANA)
        .put("tower_particle_jeremy",TOWER_PARTICLE_JEREMY)
        .put("tower_particle_franz",TOWER_PARTICLE_FRANZ)
        .put("ring_particle",RING_PARTICLE)
        .build();

}
