package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.particles.ColoredParticle;
import com.Ultra_Nerd.CodeLyokoRemake15.particles.TowerParticleData;
import com.mojang.serialization.Codec;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Base.MOD_ID);

    public static final RegistryObject<ParticleType<ColoredParticle.ColoredParticleData>> TOWER_PARTICLE = PARTICLES.register("tower_particle",
            () -> new ParticleType<>(false, ColoredParticle.ColoredParticleData.DESERIALIZE) {
                @Override
                public Codec<ColoredParticle.ColoredParticleData> codec() {
                    return null;
                }
            });

    public static final RegistryObject<ParticleType<TowerParticleData>> TOWER_PARTICLE_2 = PARTICLES.register("tower_particle_2",
            () -> new ParticleType<>(false, TowerParticleData.DESERIALIZE) {
                @Override
                public Codec<TowerParticleData> codec() {
                    return null;
                }
            });

}
