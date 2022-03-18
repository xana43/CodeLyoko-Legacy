package com.Ultra_Nerd.CodeLyokoRemake15.particles;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModParticles;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.particle.Particle;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Locale;

public class ColoredParticle extends SpriteTexturedParticle {
    private double posX, posY, posZ;

    public ColoredParticle(World world, double x, double y, double z, double xspeed, double yspeed, double zspeed, ColoredParticleData data, IAnimatedSprite sprite) {
        super(world, x, y, z, xspeed, yspeed, zspeed);
        this.motionX = xspeed;
        this.motionY = yspeed;
        this.motionZ = zspeed;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        float f = (float) Math.random() * 0.4f + 0.6f;
        this.particleScale = 0.1f * (this.rand.nextFloat() * 0.2f + 2);
        this.particleRed = ((float) (Math.random() * (double) 0.2f) + 0.8f * data.getRed() * f);
        this.particleGreen = ((float) (Math.random() * (double) 0.2f) + 0.8f * data.getGreen() * f);
        this.particleBlue = ((float) (Math.random() * (double) 0.2f) + 0.8f * data.getBlue() * f);
        this.maxAge = (int) (Math.random() * 10.0D) + 40;
    }

    @Override
    public void tick() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.age++ >= this.maxAge) {
            this.setExpired();
        } else {
            float f = (float) this.age / (float) this.maxAge;
            float f1 = -1 + f * f * 2.0F;
            float f2 = 1.0F - f1;
            this.posX = this.posX + this.motionX * (double) f2;
            this.posY = this.posY + this.motionY * (double) f2 + (double) (0.2F - f);
            this.posZ = this.posZ + this.motionZ * (double) f2;
        }
    }

    @Nonnull
    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<ColoredParticleData> {
        private final IAnimatedSprite ss;

        public Factory(IAnimatedSprite spriteIn) {
            this.ss = spriteIn;
        }

        @Nullable
        @Override
        public Particle makeParticle(@Nonnull ColoredParticleData typeIn, @Nonnull World worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            ColoredParticle part = new ColoredParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, typeIn, ss);
            part.selectSpriteRandomly(ss);
            return part;
        }
    }

    public static class ColoredParticleData implements IParticleData {
        public static final ColoredParticleData TOWER_PARTICLE = new ColoredParticleData(0.125f, 0.25f, 1, 1);
        public static final IParticleData.IDeserializer<ColoredParticleData> DESERIALIZE = new IParticleData.IDeserializer<ColoredParticleData>() {
            @Override
            public ColoredParticleData deserialize(@Nonnull ParticleType<ColoredParticleData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
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
            public ColoredParticleData read(@Nonnull ParticleType<ColoredParticleData> particleTypeIn, PacketBuffer buffer) {
                return new ColoredParticleData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
            }
        };
        private final float red, green, blue, alpha;

        public ColoredParticleData(float redIn, float greenIn, float blueIn, float alphaIn) {
            this.red = redIn;
            this.green = greenIn;
            this.blue = blueIn;
            this.alpha = MathHelper.clamp(alphaIn, 0.01f, 4.0f);
        }

        @Override
        public void write(PacketBuffer buffer) {
            buffer.writeFloat(this.red);
            buffer.writeFloat(this.green);
            buffer.writeFloat(this.blue);
            buffer.writeFloat(this.alpha);
        }

        @Nonnull
        @Override
        public String getParameters() {
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
