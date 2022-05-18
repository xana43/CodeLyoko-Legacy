package com.Ultra_Nerd.CodeLyokoLegacy.particles;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.ParticleUTIL.DefaultLyokoParticleType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BeaconBlock;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.particle.*;
import net.minecraft.client.render.entity.LightningEntityRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.enchantment.SweepingEnchantment;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;
@Environment(EnvType.CLIENT)
public final class LyokoRingParticle extends SpriteBillboardParticle {


    private final SpriteProvider provider;
    private final double xw,zw;
    private LyokoRingParticle(final ClientWorld clientWorld, final double d, final double e, final double f, final double velx, final double vely, final double velz, final SpriteProvider provider) {
        super(clientWorld, d, e, f, velx, vely, velz);
        this.provider = provider;
        this.velocityMultiplier = 2f;
        this.gravityStrength = 0;


        this.velocityY = 0;
        this.field_28787 = false;
        this.xw = x;
        this.zw = z;
        //this.velocityX = MathHelper.cos((float) MathHelper.atan2(velx,velz));
        //this.velocityZ =  MathHelper.sign(MathHelper.atan2(velx,velz));

        //this.scale *= 0.75F;
        this.maxAge = 6;

        this.collidesWithWorld = true;
        this.setSpriteForAge(provider);
        if (this.isInvisible()) {
            this.setAlpha(0);
        }
    }

    private float time = 0;

    public void tick() {
        super.tick();
        this.spacingY = 0;


            this.x = (Math.sin( Math.toRadians(time)) / 2) + (xw + 0.5f);
            this.z = (Math.cos( Math.toRadians(time)) / 2) + (zw);

        time+=60;
        if(time == 360)
        {
            time = 0;
        }
        //this.x = MathHelper.sin((float) Math.atan(this.angle));
        //this.z = MathHelper.cos((float) Math.atan(this.angle));
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
        return clientPlayerEntity != null && clientPlayerEntity.getEyePos().squaredDistanceTo(this.x, this.y, this.z) <= 9.0 && minecraftClient.options.getPerspective().isFirstPerson() && clientPlayerEntity.isUsingSpyglass();
    }


    @Environment(EnvType.CLIENT)
    public record TestRingParticle(SpriteProvider provider) implements ParticleFactory<DefaultLyokoParticleType>
    {
        @Override
        public @NotNull Particle createParticle(final DefaultLyokoParticleType parameters, final ClientWorld world, final double x, final double y, final double z, final double velocityX, final double velocityY, final double velocityZ) {
            final LyokoRingParticle lyokoRingParticle = new LyokoRingParticle(world,x,y,z,velocityX,velocityY,velocityZ,provider);
            lyokoRingParticle.setColor(1,1,0);
            lyokoRingParticle.setAlpha(1);

            return lyokoRingParticle;
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_LIT;
    }
}
