package com.Ultra_Nerd.CodeLyokoRemake15.particles;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModParticles;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.registry.Registry;

import javax.annotation.Nonnull;
import java.util.Locale;

public class TowerParticleData implements IParticleData {
    private final float red,green,blue,alpha;
    public static final TowerParticleData TOWER_PARTICLE_2 = new TowerParticleData(.125f,.25f,1.f,1.f);

    public TowerParticleData(float r, float g, float b, float a) {
        red=r;
        green=g;
        blue=b;
        alpha=a;
    }

    @Nonnull
    @Override
    public ParticleType<?> getType() {
        return ModParticles.TOWER_PARTICLE_2.get();
    }

    @Override
    public void write(@Nonnull PacketBuffer buffer) {
        buffer.writeFloat(red);
        buffer.writeFloat(green);
        buffer.writeFloat(blue);
        buffer.writeFloat(alpha);
    }

    @Nonnull
    @Override
    public String getParameters() {
        return String.format(Locale.ROOT, "%s %.2f,%.2f,%.2f,%.2f", Registry.PARTICLE_TYPE.getKey(this.getType()), this.red, this.green, this.blue, this.alpha);
    }

    public static final IParticleData.IDeserializer<TowerParticleData> DESERIALIZE = new IParticleData.IDeserializer<TowerParticleData>() {
        @Override
        public TowerParticleData deserialize(@Nonnull ParticleType<TowerParticleData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
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
        public TowerParticleData read(@Nonnull ParticleType<TowerParticleData> particleTypeIn, PacketBuffer buffer) {
            return new TowerParticleData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
        }
    };

}
