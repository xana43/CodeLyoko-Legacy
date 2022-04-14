package com.Ultra_Nerd.CodeLyokoRemake15.particles;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModParticles;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Locale;

public final class TowerParticleData implements ParticleOptions {
    private final float red, green, blue, alpha;
    public static final TowerParticleData TOWER_PARTICLE_2 = new TowerParticleData(.125f, .25f, 1.f, 1.f);

    public TowerParticleData(float r, float g, float b, float a) {
        red = r;
        green = g;
        blue = b;
        alpha = a;
    }



    @Nonnull
    @Override
    public ParticleType<?> getType() {
        return ModParticles.TOWER_PARTICLE_2.get();
    }

    @Override
    public void writeToNetwork(@Nonnull FriendlyByteBuf buffer) {
        buffer.writeFloat(red);
        buffer.writeFloat(green);
        buffer.writeFloat(blue);
        buffer.writeFloat(alpha);
    }

    @Nonnull
    @Override
    public String writeToString() {
        return String.format(Locale.ROOT, "%s %.2f,%.2f,%.2f,%.2f", Registry.PARTICLE_TYPE.getKey(this.getType()), this.red, this.green, this.blue, this.alpha);
    }

    public static Codec<TowerParticleData> towerParticleDataCodec()
    {
        return RecordCodecBuilder.create((instance) -> instance.group(
                Codec.FLOAT.fieldOf("red").forGetter(o -> o.red),
                Codec.FLOAT.fieldOf("green").forGetter(o -> o.green),
                Codec.FLOAT.fieldOf("blue").forGetter(o -> o.blue),
                Codec.FLOAT.fieldOf("alpha").forGetter(o -> o.alpha)).apply(instance,TowerParticleData::new));
    }


    public static final ParticleOptions.Deserializer<TowerParticleData> DESERIALIZE = new ParticleOptions.Deserializer<>() {
        @Override
        public @NotNull TowerParticleData fromCommand(@Nonnull ParticleType<TowerParticleData> particleTypeIn, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            float red = (float) reader.readDouble();
            reader.expect(' ');
            float green = (float) reader.readDouble();
            reader.expect(' ');
            float blue = (float) reader.readDouble();
            reader.expect(' ');
            float alpha = (float) reader.readDouble();
            return new TowerParticleData(red, green, blue, alpha);
        }

        @Override
        public @NotNull TowerParticleData fromNetwork(@Nonnull ParticleType<TowerParticleData> particleTypeIn, @NotNull FriendlyByteBuf buffer) {
            return new TowerParticleData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
        }
    };

}
