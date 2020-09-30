package com.Ultra_Nerd.CodeLyokoRemake15.particles;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.awt.*;

@OnlyIn(Dist.CLIENT)
public class TowerParticle extends SpriteTexturedParticle {
    private final IAnimatedSprite sprite;

    public TowerParticle(World world, double x, double y, double z,
                         double speedX, double speedY, double speedZ,
                         Color tint, IAnimatedSprite sprites) {
        super(world, x, y, z, speedX, speedY, speedZ);
        this.sprite = sprites;

        setColor(tint.getRed()/255.0F, tint.getGreen()/255.0F, tint.getBlue()/255.0F);

        final float PARTICLE_SCALE_FOR_ONE_METRE = 0.5F; //  if the particleScale is 0.5, the texture will be rendered as 1 metre high
        particleScale = PARTICLE_SCALE_FOR_ONE_METRE * (float)0.25; // sets the rendering size of the particle for a TexturedParticle.

        maxAge = 100;  // lifetime in ticks: 100 ticks = 5 seconds
        this.selectSpriteWithAge(sprites);

        this.particleAlpha = 1.0F;

        //the vanilla Particle constructor added random variation to our starting velocity.  Undo it!
        motionX = speedX;
        motionY = speedY;
        motionZ = speedZ;

        this.canCollide = true;  // the move() method will check for collisions with scenery

    }

    @Nonnull
    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.age++ >= this.maxAge) {
            this.setExpired();
        } else {
            this.selectSpriteWithAge(this.sprite);
            this.motionY += 0.004D;
            this.move(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)0.9F;
            this.motionY *= (double)0.9F;
            this.motionZ *= (double)0.9F;
            if (this.onGround) {
                this.motionX *= (double)0.7F;
                this.motionZ *= (double)0.7F;
            }

        }
    }



}
