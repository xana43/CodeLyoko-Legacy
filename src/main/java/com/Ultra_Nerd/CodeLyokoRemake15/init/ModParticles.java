package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.particles.ColoredParticle;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Base.MOD_ID);

    public static final RegistryObject<ParticleType<ColoredParticle.ColoredParticleData>> TOWER_PARTICLE = PARTICLES.register("tower_particle", () -> new ParticleType<ColoredParticle.ColoredParticleData>(false, ColoredParticle.ColoredParticleData.DESERIALIZE));
}
