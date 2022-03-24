package com.Ultra_Nerd.CodeLyokoRemake15.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class TowerParticle extends SimpleAnimatedParticle {
    private final SpriteSet sprite;

    public TowerParticle(ClientLevel world, double x, double y, double z,

                         SpriteSet sprites, float unknown) {
        super(world, x, y, z, sprites,unknown);
        this.sprite = sprites;

        setColor(255.0F,  255.0F,  255.0F);

        final float PARTICLE_SCALE_FOR_ONE_METRE = 0.5F; //  if the particleScale is 0.5, the texture will be rendered as 1 metre high

        this.scale(PARTICLE_SCALE_FOR_ONE_METRE * (float) 0.25); // sets the rendering size of the particle for a TexturedParticle.

        lifetime = 100;  // lifetime in ticks: 100 ticks = 5 seconds
        this.pickSprite(sprites);

        this.alpha = 1.0F;

        //the vanilla Particle constructor added random variation to our starting velocity.  Undo it!
        //
        //



        this.move(x,y,z);   // the move() method will check for collisions with scenery

    }

    @Nonnull
    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.pickSprite(this.sprite);
            this.yd += 0.004D;
            this.move(this.xd, this.yd, this.zd);
            this.xd *= (double) 0.9F;
            this.yd *= (double) 0.9F;
            this.zd *= (double) 0.9F;
            if (this.onGround) {
                this.xd *= (double) 0.7F;
                this.zd *= (double) 0.7F;
            }

        }
    }


}
