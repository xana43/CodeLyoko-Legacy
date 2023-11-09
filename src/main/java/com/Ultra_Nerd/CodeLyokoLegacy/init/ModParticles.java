package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.util.client.ParticleUTIL.DefaultLyokoParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain.codeLyokoPrefix;

public record ModParticles() {

    public static final DefaultLyokoParticleType TOWER_PARTICLE = registerDefaultLyokoParticle("tower_particle",true);
    public static final DefaultLyokoParticleType TOWER_PARTICLE_XANA = registerDefaultLyokoParticle("tower_particle_xana",false);
    public static final DefaultLyokoParticleType TOWER_PARTICLE_JEREMY = registerDefaultLyokoParticle("tower_particle_jeremy",false);
    public static final DefaultLyokoParticleType TOWER_PARTICLE_FRANZ = registerDefaultLyokoParticle("tower_particle_franz",false);
    public static final DefaultLyokoParticleType RING_PARTICLE = registerDefaultLyokoParticle("ring_particle",false);
    

    private static<T extends ParticleEffect> ParticleType<T> registerDefaultLyokoParticle(final String name, final ParticleType<T> defaultLyokoParticleType) {
        return Registry.register(Registries.PARTICLE_TYPE, codeLyokoPrefix(name),
                defaultLyokoParticleType);
    }
    private static DefaultLyokoParticleType registerDefaultLyokoParticle(final String name, final boolean alwaysShow) {
        return (DefaultLyokoParticleType) registerDefaultLyokoParticle(name,new DefaultLyokoParticleType(alwaysShow));
    }
    public static void registerParticles(){}
}
