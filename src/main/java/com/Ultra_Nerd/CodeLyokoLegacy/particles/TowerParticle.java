package com.Ultra_Nerd.CodeLyokoLegacy.particles;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.TextureSheetParticle;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;


public final class TowerParticle extends TextureSheetParticle {



    TowerParticle(final ClientLevel p_108323_, final double p_108324_, final double p_108325_, final double p_108326_) {
        super(p_108323_, p_108324_, p_108325_, p_108326_);
        setColor(0,  0,  255.0F);

        final float PARTICLE_SCALE_FOR_ONE_METRE = 0.5F; //  if the particleScale is 0.5, the texture will be rendered as 1 metre high

        this.scale(PARTICLE_SCALE_FOR_ONE_METRE * (float) 0.25); // sets the rendering size of the particle for a TexturedParticle.

        lifetime = 100;  // lifetime in ticks: 100 ticks = 5 seconds

        CodeLyokoMain.Log.info("should spawn");
        this.alpha = 9.0F;

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
    public void render(final @NotNull VertexConsumer pBuffer, final @NotNull Camera pRenderInfo, final float pPartialTicks) {
        super.render(pBuffer, pRenderInfo, pPartialTicks);
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {

            this.yd += 0.004D;
            this.move(this.xd, this.yd, this.zd);
            this.xd *= 0.9F;
            this.yd *= 0.9F;
            this.zd *= 0.9F;
            if (this.onGround) {
                this.xd *= 0.7F;
                this.zd *= 0.7F;
            }

        }
    }


}
