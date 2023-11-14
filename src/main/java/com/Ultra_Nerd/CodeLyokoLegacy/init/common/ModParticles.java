package com.Ultra_Nerd.CodeLyokoLegacy.init.common;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain.codeLyokoPrefix;

public record ModParticles() {

    public static final DefaultParticleType TOWER_PARTICLE = registerSimpleParticle("tower_particle",true);
    public static final DefaultParticleType TOWER_PARTICLE_XANA = registerSimpleParticle("tower_particle_xana",false);
    public static final DefaultParticleType TOWER_PARTICLE_JEREMY = registerSimpleParticle("tower_particle_jeremy",false);
    public static final DefaultParticleType TOWER_PARTICLE_FRANZ = registerSimpleParticle("tower_particle_franz",false);
    public static final DefaultParticleType RING_PARTICLE = registerSimpleParticle("ring_particle",false);
    

    private static<T extends ParticleEffect> ParticleType<T> registerComplexParticle(final String name, final ParticleType<T> particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, codeLyokoPrefix(name),
                particleType);
    }
    private static net.minecraft.particle.DefaultParticleType registerSimpleParticle(final String name, final boolean alwaysSpawn) {
        return Registry.register(Registries.PARTICLE_TYPE, codeLyokoPrefix(name),
                FabricParticleTypes.simple(alwaysSpawn));
    }

    public static void registerParticles(){}
}
