package com.Ultra_Nerd.CodeLyokoRemake15.particles;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;

@OnlyIn(Dist.CLIENT)
public class TowerParticleFactory implements IParticleFactory<TowerParticleData> {
    private final IAnimatedSprite spriteSet;

    public TowerParticleFactory(IAnimatedSprite sprite) {
        this.spriteSet = sprite;
    }

    @Nullable
    @Override
    public Particle makeParticle(@Nonnull TowerParticleData typeIn, @Nonnull World worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        return new TowerParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, new Color(.125F,.25F,1.F,1.F), this.spriteSet);
    }

}