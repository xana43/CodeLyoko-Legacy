package com.Ultra_Nerd.CodeLyokoLegacy.Util.client.ParticleUTIL;

import com.mojang.brigadier.StringReader;
import com.mojang.serialization.Codec;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.util.registry.Registry;

import java.util.Objects;

public final class DefaultLyokoParticleType extends ParticleType<DefaultLyokoParticleType> implements ParticleEffect {



    public DefaultLyokoParticleType(final boolean alwaysShow) {

        super(alwaysShow, new Factory<>() {
            @Override
            public DefaultLyokoParticleType read(final ParticleType<DefaultLyokoParticleType> type, final StringReader reader) {
                return (DefaultLyokoParticleType) type;
            }

            @Override
            public DefaultLyokoParticleType read(final ParticleType<DefaultLyokoParticleType> type, final PacketByteBuf buf) {
                return (DefaultLyokoParticleType) type;
            }
        });
    }

    @Override
    public DefaultLyokoParticleType getType() {
        return this;
    }

    @Override
    public void write(final PacketByteBuf buf) {

    }

    @Override
    public String asString() {
        return Objects.requireNonNull(Registry.PARTICLE_TYPE.getId(this)).toString();
    }

    @Override
    public Codec<DefaultLyokoParticleType> getCodec() {
        return Codec.unit(this::getType);
    }
}
