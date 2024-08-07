package com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.LaserEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

@SuppressWarnings("MethodMayBeStatic")
public final class MantaEntity extends GuardianEntity implements GeoAnimatable, RangedAttackMob {
    private final AnimatableInstanceCache manager = GeckoLibUtil.createInstanceCache(this);
    private final AnimationController<?> controller = new AnimationController<>(this, "mantamovecontroller", 20,
            this::animationPred);

    public MantaEntity(final EntityType<? extends GuardianEntity> entityType, final World world) {
        super(entityType, world);
    }

    /*
        public MantaEntity(@NotNull EntityType<? extends Guardian> type, @NotNull Level worldIn) {
            super(type, worldIn);

        }

        @Override
        public void tick() {
            super.tick();
            if(!this.isUnderWater())
            {
                this.hurt(DamageSource.DROWN,Float.MAX_VALUE);
            }
        }

        @Override
        protected void registerGoals() {
            this.goalSelector.addGoal(1,new RangedAttackGoal(this,2,3,6));
            this.targetSelector.addGoal(1,new NearestAttackableTargetGoal<>(this, Player.class,true));
            this.goalSelector.addGoal(2,new LookAtPlayerGoal(this,Player.class,4));
            this.goalSelector.addGoal(3,new RandomLookAroundGoal(this));

        }


        @Override
        public boolean isAlive() {
            return true;
        }

        @Override
        public boolean isOnFire() {
            return false;
        }

        @Override
        protected boolean isSunBurnTick() {
            return false;
        }

        @Override
        public @NotNull Packet<?> getAddEntityPacket() {
            return  NetworkHooks.getEntitySpawningPacket(this);
        }

        @Override
        public void performRangedAttack(@NotNull LivingEntity target, float distanceFactor) {

            EntityLaser laser = new EntityLaser(this.level, 1.0D, 1.0D, 1.0D);
            double d0 = target.getX() - this.getX();
            double d1 = target.getY(0.3333333333333333D) - laser.getY();
            double d2 = target.getZ() - this.getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            laser.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() << 2));
            this.playSound(ModSounds.LASERARROW.get(), 1.0F, 1.0F / (this.random.nextFloat() * 1.2f));
            this.level.addFreshEntity(laser);
        }
    */


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return manager;
    }

    @Override
    public double getTick(final Object o) {
        return 0;
    }

    @Override
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar data) {
        data.add(controller);
    }

    private <E extends MantaEntity> @NotNull PlayState animationPred(AnimationState<E> event) {
        return PlayState.STOP;
    }

    @Override
    public void shootAt(final LivingEntity target, final float pullProgress) {
        final LaserEntity laserProjectile = new LaserEntity(this.getWorld(), this, 20);
        final double d0 = target.getX() - this.getX();
        final double d1 = target.getBodyY(0.3333333333333333D) - laserProjectile.getY();
        final double d2 = target.getZ() - this.getZ();
        final double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        laserProjectile.setVelocity(d0, d1 + d3 * 0.2D, d2, 4F, (float) (14 - this.getWorld().getDifficulty().getId() << 2));
        this.playSound(ModSounds.LASERARROW, 1.0F, 1.0F / (this.getRandom().nextFloat() * 1.2f));
        this.getWorld().spawnEntity(laserProjectile);
    }
}


