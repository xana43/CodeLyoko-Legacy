package com.Ultra_Nerd.CodeLyokoLegacy.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public final class TowerParticleFactory implements ParticleProvider<TowerParticleData> {
    private final SpriteSet spriteSet;

    public TowerParticleFactory(SpriteSet sprite) {
        this.spriteSet = sprite;
    }

    @Nullable
    @Override
    public Particle createParticle(@Nonnull TowerParticleData typeIn, @Nonnull ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        final TowerParticle particle = new TowerParticle(worldIn,x,y,z);

        particle.pickSprite(this.spriteSet);
        return particle;
    }


}