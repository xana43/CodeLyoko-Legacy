package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.particles.ColoredParticle;
import com.Ultra_Nerd.CodeLyokoLegacy.particles.TowerParticleData;
import com.mojang.serialization.Codec;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public final class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, CodeLyokoMain.MOD_ID);

    public static final RegistryObject<ParticleType<ColoredParticle.ColoredParticleData>> TOWER_PARTICLE = PARTICLES.register("tower_particle",
            () -> new ParticleType<>(false, ColoredParticle.ColoredParticleData.DESERIALIZE) {
                @Override
                public @NotNull Codec<ColoredParticle.ColoredParticleData> codec() {
                    return ColoredParticle.ColoredParticleData.coloredCodec();
                }
            });

    public static final RegistryObject<ParticleType<TowerParticleData>> TOWER_PARTICLE_2 = PARTICLES.register("tower_particle_2",
            () -> new ParticleType<>(false, TowerParticleData.DESERIALIZE) {
                @Override
                public @NotNull Codec<TowerParticleData> codec() {
                    return TowerParticleData.towerParticleDataCodec();
                }
            });

}
