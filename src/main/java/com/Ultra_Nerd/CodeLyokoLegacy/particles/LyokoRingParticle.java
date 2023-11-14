package com.Ultra_Nerd.CodeLyokoLegacy.particles;

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
public final class LyokoRingParticle extends SpriteBillboardParticle {


    private final SpriteProvider provider;
    private final double xw, zw;
    private float time = 0;

    private LyokoRingParticle(final ClientWorld clientWorld, final double d, final double e, final double f, final double velx, final double vely, final double velz, final SpriteProvider provider) {
        super(clientWorld, d, e, f, velx, vely, velz);
        this.provider = provider;
        this.velocityMultiplier = 2f;
        this.gravityStrength = 0;
        this.velocityY = 0;
        this.xw = x;
        this.zw = z;
        this.maxAge = 6;
        this.collidesWithWorld = true;
        this.setSpriteForAge(provider);
        if (this.isInvisible()) {
            this.setAlpha(0);
        }
    }

    public void tick() {
        super.tick();
        this.spacingY = 0;


        this.x = (Math.sin(Math.toRadians(time)) / 2) + (xw + 0.5f);
        this.z = (Math.cos(Math.toRadians(time)) / 2) + (zw);

        time += 60;
        if (time == 360) {
            time = 0;
        }
        this.setSpriteForAge(this.provider);
        if (this.isInvisible()) {
            this.setAlpha(0);
        } else {
            this.setAlpha(MathHelper.lerp(1, this.alpha, 1));
        }

    }


    private boolean isInvisible() {
        final MinecraftClient minecraftClient = MinecraftClient.getInstance();
        final ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        return clientPlayerEntity != null && clientPlayerEntity.getEyePos()
                .squaredDistanceTo(this.x, this.y, this.z) <= 9.0 && minecraftClient.options.getPerspective()
                .isFirstPerson() && clientPlayerEntity.isUsingSpyglass();
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_LIT;
    }

    @Environment(EnvType.CLIENT)
    public record ScannerRingParticle(SpriteProvider provider) implements ParticleFactory<DefaultParticleType> {
        @Override
        public @NotNull Particle createParticle(final DefaultParticleType parameters, final ClientWorld world, final double x, final double y, final double z, final double velocityX, final double velocityY, final double velocityZ) {
            final LyokoRingParticle lyokoRingParticle = new LyokoRingParticle(world, x, y, z, velocityX, velocityY,
                    velocityZ, provider);
            lyokoRingParticle.setColor(1, 1, 0);
            lyokoRingParticle.setAlpha(1);

            return lyokoRingParticle;
        }
    }
}
