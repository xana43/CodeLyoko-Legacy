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
        this.maxAge = (int)(8 / (Math.random() * 0.8 + 0.2));
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
        return clientPlayerEntity != null && clientPlayerEntity.getEyePos().squaredDistanceTo(this.x, this.y, this.z) <= 9.0 && minecraftClient.options.getPerspective().isFirstPerson() && clientPlayerEntity.isUsingSpyglass();
    }


    @Environment(EnvType.CLIENT)
    public record TowerParticleJeremy(SpriteProvider spriteProvider) implements ParticleFactory<DefaultLyokoParticleType>
    {
        @Override
        public @NotNull Particle createParticle(final DefaultLyokoParticleType parameters, final ClientWorld world, final double x, final double y, final double z, final double velocityX, final double velocityY, final double velocityZ) {
            final LyokoFloatingParticle lyokoFloatingParticle = new LyokoFloatingParticle(world,x,y,z,velocityX,velocityY,velocityZ,spriteProvider);
            lyokoFloatingParticle.velocityMultiplier = 0.8f;
            lyokoFloatingParticle.setColor(0.07058823529f,0.8f,0.07058823529f);
            lyokoFloatingParticle.setAlpha(1);

            return lyokoFloatingParticle;
        }
    }
    @Environment(EnvType.CLIENT)
    public record TowerParticleFranz(SpriteProvider spriteProvider) implements ParticleFactory<DefaultLyokoParticleType>
    {


        @Override
        public @NotNull Particle createParticle(final DefaultLyokoParticleType parameters, final ClientWorld world, final double x, final double y, final double z, final double velocityX, final double velocityY, final double velocityZ) {
            final LyokoFloatingParticle lyokoFloatingParticle = new LyokoFloatingParticle(world,x,y,z,velocityX,velocityY,velocityZ,spriteProvider);
            lyokoFloatingParticle.velocityMultiplier = 0.8f;
            lyokoFloatingParticle.setColor(1,1,1);
            lyokoFloatingParticle.setAlpha(1);

            return lyokoFloatingParticle;
        }
    }
    @Environment(EnvType.CLIENT)
    public record TowerParticleNeutral(SpriteProvider spriteProvider) implements ParticleFactory<DefaultLyokoParticleType>
    {

        @Override
        public @NotNull Particle createParticle(final DefaultLyokoParticleType parameters, final ClientWorld world, final double x, final double y, final double z, final double velocityX, final double velocityY, final double velocityZ) {
            final LyokoFloatingParticle lyokoFloatingParticle = new LyokoFloatingParticle(world,x,y,z,velocityX,velocityY,velocityZ,spriteProvider);
            lyokoFloatingParticle.velocityMultiplier = 0.8f;
            lyokoFloatingParticle.setColor(0.01960784314f,0.76470588235f,0.9f);
            lyokoFloatingParticle.setAlpha(1);

            return lyokoFloatingParticle;
        }
    }

    @Environment(EnvType.CLIENT)
    public record TowerParticleXana(SpriteProvider spriteProvider) implements ParticleFactory<DefaultLyokoParticleType>
    {


        @Override
        public @NotNull Particle createParticle(final DefaultLyokoParticleType parameters, final ClientWorld world, final double x, final double y, final double z, final double velocityX, final double velocityY, final double velocityZ) {
            final LyokoFloatingParticle lyokoFloatingParticle = new LyokoFloatingParticle(world,x,y,z,velocityX,velocityY,velocityZ,spriteProvider);
            lyokoFloatingParticle.velocityMultiplier = 0.8f;
            lyokoFloatingParticle.setColor(0.86274509804f,0.07843137255f,0.235429411765f);
            lyokoFloatingParticle.setAlpha(1);

            return lyokoFloatingParticle;
        }
    }

    @Environment(EnvType.CLIENT)
    public record DefaultLyokoParticle(SpriteProvider provider) implements ParticleFactory<DefaultParticleType>
    {



        @Override
        public @NotNull Particle createParticle(final DefaultParticleType parameters, final ClientWorld world, final double x, final double y, final double z, final double velocityX, final double velocityY, final double velocityZ) {
            return new LyokoFloatingParticle(world,x,y,z,velocityX,velocityY,velocityZ,provider);
        }
    }
/*


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

 */


}
