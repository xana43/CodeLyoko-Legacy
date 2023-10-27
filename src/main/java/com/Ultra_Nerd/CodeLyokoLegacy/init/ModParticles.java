package com.Ultra_Nerd.CodeLyokoLegacy.init;

import static com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain.codeLyokoPrefix;

import com.Ultra_Nerd.CodeLyokoLegacy.util.client.ParticleUTIL.DefaultLyokoParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public record ModParticles() {

    public static final DefaultLyokoParticleType TOWER_PARTICLE = register("tower_particle",true);
    public static final DefaultLyokoParticleType TOWER_PARTICLE_XANA = register("tower_particle_xana",false);
    public static final DefaultLyokoParticleType TOWER_PARTICLE_JEREMY = register("tower_particle_jeremy",false);
    public static final DefaultLyokoParticleType TOWER_PARTICLE_FRANZ = register("tower_particle_franz",false);
    public static final DefaultLyokoParticleType RING_PARTICLE = register("ring_particle",false);
    

    private static DefaultLyokoParticleType register(final String name,final DefaultLyokoParticleType defaultLyokoParticleType) {
        return Registry.register(Registries.PARTICLE_TYPE, codeLyokoPrefix(name),
                defaultLyokoParticleType);
    }
    private static DefaultLyokoParticleType register(final String name,final boolean alwaysShow) {
        return Registry.register(Registries.PARTICLE_TYPE, codeLyokoPrefix(name),
                new DefaultLyokoParticleType(alwaysShow));
    }
    public static void registerParticles(){}
}
