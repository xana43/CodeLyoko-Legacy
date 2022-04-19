package com.Ultra_Nerd.CodeLyokoLegacy.particles;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModParticles;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Locale;

public final class ColoredParticle extends TextureSheetParticle {
    private double posX, posY, posZ;

    public ColoredParticle(@NotNull ClientLevel world, double x, double y, double z, double xspeed, double yspeed, double zspeed, @NotNull ColoredParticleData data) {
        super(world, x, y, z, xspeed, yspeed, zspeed);
        this.xd = xspeed;
        this.yd = yspeed;
        this.zd = zspeed;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        float f = (float) Math.random() * 0.4f + 0.6f;
        this.scale(0.1f * ((float) Math.random() * 0.2f + 2));
        this.rCol = ((float) (Math.random() * (double) 0.2f) + 0.8f * data.getRed() * f);
        this.gCol = ((float) (Math.random() * (double) 0.2f) + 0.8f * data.getGreen() * f);
        this.bCol = ((float) (Math.random() * (double) 0.2f) + 0.8f * data.getBlue() * f);
        this.lifetime  = (int) (Math.random() * 10.0D) + 40;
    }

    @Override
    public void tick() {
        this.xo = this.posX;
        this.yo = this.posY;
        this.zo = this.posZ;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            float f = (float) this.age / (float) this.lifetime;
            float f1 = -1 + f * f * 2.0F;
            float f2 = 1.0F - f1;
            this.posX = this.posX + this.xd * (double) f2;
            this.posY = this.posY + this.yd * (double) f2 + (double) (0.2F - f);
            this.posZ = this.posZ + this.zd * (double) f2;
        }
    }

    @Override
    public void render(VertexConsumer p_107261_, Camera p_107262_, float p_107263_) {

    }

    @Nonnull
    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }


    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<ColoredParticleData> {
        private final SpriteSet spriteSet;
        public Factory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(@Nonnull ColoredParticleData typeIn, @Nonnull ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            //part.set(ss);
            return new ColoredParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, typeIn);
        }


    }

    public static class ColoredParticleData implements ParticleOptions {
        public static final ColoredParticleData TOWER_PARTICLE = new ColoredParticleData(0.125f, 0.25f, 1, 1);
        public static final ParticleOptions.Deserializer<ColoredParticleData> DESERIALIZE = new ParticleOptions.Deserializer<>() {

            @Override
            public @NotNull ColoredParticleData fromCommand(@NotNull ParticleType<ColoredParticleData> particleTypeIn, @NotNull StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                float red = (float) reader.readDouble();
                reader.expect(' ');
                float green = (float) reader.readDouble();
                reader.expect(' ');
                float blue = (float) reader.readDouble();
                reader.expect(' ');
                float alpha = (float) reader.readDouble();
                return new ColoredParticleData(red, green, blue, alpha);
            }


            @Override
            public @NotNull ColoredParticleData fromNetwork(@Nonnull ParticleType<ColoredParticleData> particleTypeIn, @NotNull FriendlyByteBuf
                    buffer) {
                return new ColoredParticleData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
            }
        };
        private final float red, green, blue, alpha;

        public ColoredParticleData(float redIn, float greenIn, float blueIn, float alphaIn) {
            this.red = redIn;
            this.green = greenIn;
            this.blue = blueIn;
            this.alpha = Mth.clamp(alphaIn, 0.01f, 4.0f);
        }

        @Override
        public void writeToNetwork(@NotNull FriendlyByteBuf buffer) {
            buffer.writeFloat(this.red);
            buffer.writeFloat(this.green);
            buffer.writeFloat(this.blue);
            buffer.writeFloat(this.alpha);
        }
public static Codec<ColoredParticleData> coloredCodec()
{
    return RecordCodecBuilder.create((instance -> instance.group(
            Codec.FLOAT.fieldOf("red").forGetter(o -> o.red),
            Codec.FLOAT.fieldOf("green").forGetter(o -> o.green),
            Codec.FLOAT.fieldOf("blue").forGetter(o -> o.blue),
            Codec.FLOAT.fieldOf("alpha").forGetter(o -> o.alpha)
    ).apply(instance,ColoredParticleData::new)));
}
        @Nonnull
        @Override
        public String writeToString() {
            return String.format(Locale.ROOT, "%s %.2f,%.2f,%.2f,%.2f", Registry.PARTICLE_TYPE.getKey(this.getType()), this.red, this.green, this.blue, this.alpha);
        }

        @Nonnull
        @Override
        public ParticleType<?> getType() {
            return ModParticles.TOWER_PARTICLE.get();
        }

        @OnlyIn(Dist.CLIENT)
        public float getAlpha() {
            return this.alpha;
        }

        @OnlyIn(Dist.CLIENT)
        public float getRed() {
            return this.red;
        }

        @OnlyIn(Dist.CLIENT)
        public float getGreen() {
            return this.green;
        }

        @OnlyIn(Dist.CLIENT)
        public float getBlue() {
            return this.blue;
        }
    }


}
