package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;
import java.util.Random;

public final class MegaTankEntity extends SkeletonEntity implements GeoAnimatable {


    private final AnimationController<?> tank = new AnimationController<>(this, "movecontroller", 0,
            this::animationPred);


    public MegaTankEntity(EntityType<? extends SkeletonEntity> type, @NotNull World world) {
        super(type, world);

        //AnimationController.(
          //      (AnimationController.ModelFetcher<MegaTankEntity>) animated -> new ModelMegaTank());


    }

    //@Override
    private static SoundEvent getStepSound() {
        return ModSounds.MEGATANKROLL;
    }

    public static DefaultAttributeContainer.@NotNull Builder registerAttributes() {
        // TODO Auto-generated method stub
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 10D)
                .add(EntityAttributes.GENERIC_ARMOR, 20D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20D);


    }


    // abstract SoundEvent getStepSound();

    public static boolean canSpawn(@NotNull WorldAccess world, @NotNull SpawnReason reason, @NotNull BlockPos pos, @NotNull Random rand) {
        return world.getBiome(pos).isIn(ModTags.Biomes.LYOKO_BIOME);
    }

    @Override
    protected boolean isAffectedByDaylight() {
        return false;
    }

    @Override
    protected void playStepSound(final BlockPos pos, final BlockState state) {
        this.playSound(getStepSound(), MinecraftClient.getInstance().options.getSoundVolume(SoundCategory.HOSTILE), 1);
    }

    @Override
    public boolean isUndead() {
        return false;
    }

    @Override
    public boolean isSprinting() {
        return true;
    }

    @Override
    protected void spawnSprintingParticles() {
    }

    @Override
    protected @NotNull SoundEvent getDeathSound() {
        return ModSounds.MEGATANKDIE;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }


    @Override
    public FallSounds getFallSounds() {
        return new FallSounds(ModSounds.MEGATANKSMALLFALL, ModSounds.MEGATANKBIGFALL);
    }

    @Override
    protected void initGoals() {


        this.goalSelector.add(1, new ProjectileStopThenAttackGoal(this, 1, 10, 10));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 3.0));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected @NotNull SoundEvent getHurtSound(final DamageSource damageSourceIn) {
        final boolean random = new Random().nextBoolean();
        if (random) {
            return ModSounds.MEGATANKHURT1;
        } else {
            return ModSounds.MEGATANKHURT2;
        }
    }

    @Override
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar data) {
        data.add(tank);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return GeckoLibUtil.createInstanceCache(this);
    }

    @Override
    public double getTick(final Object o) {
        return 0;
    }

    @Override
    public void attack(final LivingEntity target, final float pullProgress) {
        //super.attack(target, pullProgress);
        final EntityLaser abstractarrow = new EntityLaser(this.getWorld(), this, 20);

        final double d0 = target.getX() - this.getX();
        final double d1 = target.getBodyY(0.3333333333333333D) - abstractarrow.getY();
        final double d2 = target.getZ() - this.getZ();
        final double d3 = Math.sqrt(d0 * d0 + d2 * d2);

        abstractarrow.setVelocity(d0, d1 + d3 * 0.2F, d2, 4F, (14 - this.getWorld().getDifficulty().getId() << 2));
        this.playSound(ModSounds.LASERARROW, 1.0F, 1.0F / (this.getRandom().nextFloat() * 1.2f));
        if (!this.getWorld().isClient) {
            this.getWorld().spawnEntity(abstractarrow);
        }
    }

    private <E extends MegaTankEntity> PlayState animationPred(@NotNull AnimationState<E> event) {


        //CodeLyokoMain.LOG.info("attacking " + event.getAnimatable().isAttacking());
        if (event.isMoving() && !event.getAnimatable().isAttacking()) {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("animation.MegaTank.move"));
            //CodeLyokoMain.LOG.info("moving");
        } else if (event.getAnimatable().isAttacking()) {

            event.getController().setAnimation(RawAnimation.begin().thenLoop("animation.MegaTank.open"));
            //CodeLyokoMain.LOG.info("attacking");
        } else {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("animation.MegaTank.idle"));
            //CodeLyokoMain.LOG.info("not moving");

        }

    return PlayState.CONTINUE;

    }



    private static final class ProjectileStopThenAttackGoal extends Goal {

        private final MobEntity mob;
        private final RangedAttackMob owner;
        private final double mobSpeed;
        private final int minIntervalTicks;
        private final int maxIntervalTicks;
        private final float maxShootRange;
        private final float squaredMaxShootRange;
        @Nullable
        private LivingEntity target;
        private int updateCountdownTicks;
        private int seenTargetTicks;

        public ProjectileStopThenAttackGoal(RangedAttackMob mob, double mobSpeed, int intervalTicks, float maxShootRange) {
            this(mob, mobSpeed, intervalTicks, intervalTicks, maxShootRange);
        }

        public ProjectileStopThenAttackGoal(RangedAttackMob mob, double mobSpeed, int minIntervalTicks, int maxIntervalTicks, float maxShootRange) {
            this.updateCountdownTicks = -1;
            if (!(mob instanceof LivingEntity)) {
                throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
            } else {
                this.owner = mob;
                this.mob = (MobEntity) mob;
                this.mobSpeed = mobSpeed;
                this.minIntervalTicks = minIntervalTicks;
                this.maxIntervalTicks = maxIntervalTicks;
                this.maxShootRange = maxShootRange;
                this.squaredMaxShootRange = maxShootRange * maxShootRange;
                this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
            }
        }

        public boolean canStart() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity != null && livingEntity.isAlive()) {
                this.target = livingEntity;
                return true;
            } else {
                return false;
            }
        }

        public boolean shouldContinue() {
            return this.canStart() || !this.mob.getNavigation().isIdle();
        }

        public void stop() {
            this.target = null;
            this.seenTargetTicks = 0;
            this.updateCountdownTicks = -1;
            this.mob.setAttacking(false);
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            if (target == null) {
                return;
            }
            final double d = this.mob.squaredDistanceTo(target.getX(), target.getY(), target.getZ());
            final boolean bl = this.mob.getVisibilityCache().canSee(target);
            if (bl) {
                ++this.seenTargetTicks;
            } else {
                this.seenTargetTicks = 0;
            }

            if (!(d > (double) this.squaredMaxShootRange) && this.seenTargetTicks >= 5) {
                this.mob.getNavigation().stop();
            } else {
                this.mob.setAttacking(false);
                this.mob.getNavigation().startMovingTo(this.target, this.mobSpeed);
            }

            this.mob.getLookControl().lookAt(this.target, 30.0F, 30.0F);
            if (--this.updateCountdownTicks == 0) {
                if (!bl) {
                    return;
                }

                final float f = (float) Math.sqrt(d) / this.maxShootRange;
                final float g = MathHelper.clamp(f, 0.1F, 1.0F);
                if (!(d > (double) this.squaredMaxShootRange) && this.seenTargetTicks >= 5) {
                    this.owner.attack(this.target, g);
                    this.mob.setAttacking(true);
                }
                this.updateCountdownTicks = MathHelper.floor(
                        f * (float) (this.maxIntervalTicks - this.minIntervalTicks) + (float) this.minIntervalTicks);
            } else if (this.updateCountdownTicks < 0) {
                this.updateCountdownTicks = MathHelper.floor(
                        MathHelper.lerp(Math.sqrt(d) / (double) this.maxShootRange, this.minIntervalTicks,
                                this.maxIntervalTicks));
            }

        }
    }


}
