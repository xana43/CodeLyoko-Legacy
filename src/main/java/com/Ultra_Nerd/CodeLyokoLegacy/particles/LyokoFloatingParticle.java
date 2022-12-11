package com.Ultra_Nerd.CodeLyokoLegacy.particles;

import com.Ultra_Nerd.CodeLyokoLegacy.util.client.ParticleUTIL.DefaultLyokoParticleType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public final class LyokoFloatingParticle extends SpriteBillboardParticle {

    // private static final Random thisrandom = new Random();
    private final SpriteProvider provider;

    private LyokoFloatingParticle(final ClientWorld clientWorld, final double d, final double e, final double f, final double velx, final double vely, final double velz, final SpriteProvider provider) {
        super(clientWorld, d, e, f, velx, vely, velz);
        this.provider = provider;
        this.velocityMultiplier = 0.96f;
        this.gravityStrength = -0.1f;
        this.field_28787 = true;
        this.velocityY *= 0.20000000298023224;
        if (velocityX == 0.0 && velocityZ == 0.0) {
            this.velocityX *= 0.10000000149011612;
            this.velocityZ *= 0.10000000149011612;
        }

        this.scale *= 0.75F;
        this.maxAge = (int) (8 / (Math.random() * 0.8 + 0.2));
        this.collidesWithWorld = true;
        this.setSpriteForAge(provider);
        if (this.isInvisible()) {
            this.setAlpha(0);
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public void tick() {
        super.tick();
        this.setSpriteForAge(this.provider);
        if (this.isInvisible()) {
            this.setAlpha(0);
        } else {
            this.setAlpha(MathHelper.lerp(0.05F, this.alpha, 1));
        }

    }


    private boolean isInvisible() {
        final MinecraftClient minecraftClient = MinecraftClient.getInstance();
        final ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        return clientPlayerEntity != null && clientPlayerEntity.getEyePos()
                .squaredDistanceTo(this.x, this.y, this.z) <= 9.0 && minecraftClient.options.getPerspective()
                .isFirstPerson() && clientPlayerEntity.isUsingSpyglass();
    }


    @Environment(EnvType.CLIENT)
    public record TowerParticleJeremy(
            SpriteProvider spriteProvider) implements ParticleFactory<DefaultLyokoParticleType> {
        @Override
        public @NotNull Particle createParticle(final DefaultLyokoParticleType parameters, final ClientWorld world, final double x, final double y, final double z, final double velocityX, final double velocityY, final double velocityZ) {
            final LyokoFloatingParticle lyokoFloatingParticle = new LyokoFloatingParticle(world, x, y, z, velocityX,
                    velocityY, velocityZ, spriteProvider);
            lyokoFloatingParticle.velocityMultiplier = 0.8f;
            lyokoFloatingParticle.setColor(0.07058823529f, 0.8f, 0.07058823529f);
            lyokoFloatingParticle.setAlpha(1);

            return lyokoFloatingParticle;
        }
    }

    @Environment(EnvType.CLIENT)
    public record TowerParticleFranz(
            SpriteProvider spriteProvider) implements ParticleFactory<DefaultLyokoParticleType> {


        @Override
        public @NotNull Particle createParticle(final DefaultLyokoParticleType parameters, final ClientWorld world, final double x, final double y, final double z, final double velocityX, final double velocityY, final double velocityZ) {
            final LyokoFloatingParticle lyokoFloatingParticle = new LyokoFloatingParticle(world, x, y, z, velocityX,
                    velocityY, velocityZ, spriteProvider);
            lyokoFloatingParticle.velocityMultiplier = 0.8f;
            lyokoFloatingParticle.setColor(1, 1, 1);
            lyokoFloatingParticle.setAlpha(1);

            return lyokoFloatingParticle;
        }
    }

    @Environment(EnvType.CLIENT)
    public record TowerParticleNeutral(
            SpriteProvider spriteProvider) implements ParticleFactory<DefaultLyokoParticleType> {

        @Override
        public @NotNull Particle createParticle(final DefaultLyokoParticleType parameters, final ClientWorld world, final double x, final double y, final double z, final double velocityX, final double velocityY, final double velocityZ) {
            final LyokoFloatingParticle lyokoFloatingParticle = new LyokoFloatingParticle(world, x, y, z, velocityX,
                    velocityY, velocityZ, spriteProvider);
            lyokoFloatingParticle.velocityMultiplier = 0.8f;
            lyokoFloatingParticle.setColor(0.01960784314f, 0.76470588235f, 0.9f);
            lyokoFloatingParticle.setAlpha(1);

            return lyokoFloatingParticle;
        }
    }

    @Environment(EnvType.CLIENT)
    public record TowerParticleXana(
            SpriteProvider spriteProvider) implements ParticleFactory<DefaultLyokoParticleType> {


        @Override
        public @NotNull Particle createParticle(final DefaultLyokoParticleType parameters, final ClientWorld world, final double x, final double y, final double z, final double velocityX, final double velocityY, final double velocityZ) {
            final LyokoFloatingParticle lyokoFloatingParticle = new LyokoFloatingParticle(world, x, y, z, velocityX,
                    velocityY, velocityZ, spriteProvider);
            lyokoFloatingParticle.velocityMultiplier = 0.8f;
            lyokoFloatingParticle.setColor(0.86274509804f, 0.07843137255f, 0.235429411765f);
            lyokoFloatingParticle.setAlpha(1);

            return lyokoFloatingParticle;
        }
    }

    @Environment(EnvType.CLIENT)
    public record DefaultLyokoParticle(SpriteProvider provider) implements ParticleFactory<DefaultParticleType> {


        @Override
        public @NotNull Particle createParticle(final DefaultParticleType parameters, final ClientWorld world, final double x, final double y, final double z, final double velocityX, final double velocityY, final double velocityZ) {
            return new LyokoFloatingParticle(world, x, y, z, velocityX, velocityY, velocityZ, provider);
        }
    }


}
