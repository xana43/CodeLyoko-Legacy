package com.Ultra_Nerd.CodeLyokoRemake15.particles;

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
        return new TowerParticle(worldIn,x,y,z,this.spriteSet,20);
    }


}