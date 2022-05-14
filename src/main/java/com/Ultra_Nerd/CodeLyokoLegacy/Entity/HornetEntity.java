package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public final class HornetEntity extends PhantomEntity implements IAnimatable, RangedAttackMob {

    private final AnimationController<?> controller2 = new AnimationController<>(this, "attackcontroller", 20, this::animationPred);
    private final AnimationController<?> controller = new AnimationController<>(this, "movecontroller", 20, this::animationPred);

    public HornetEntity(final EntityType<? extends PhantomEntity> entityType, final World world) {
        super(entityType, world);
    }

    @Override
    public void attack(final LivingEntity target, final float pullProgress) {

    }

    @Override
    public void registerControllers(final AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return new AnimationFactory(this);
    }
/*
    public HornetEntity(@NotNull EntityType<HornetEntity> hornetEntityEntityType, @NotNull Level world) {
        super(hornetEntityEntityType, world);

    }
/*
    public HornetEntity(Level world) {
        super(ModEntities.HORNET.get(), world);

    }*/
/*
    @Override
    public void tick() {
        super.tick();


        if (this.isAlive()) {
            this.level.playSound(null,this.getX(), this.getY(), this.getZ(), ModSounds.HORNETFLY.get(), this.getSoundSource(), 0.95F + this.random.nextFloat() * 0.05F, 0.95F + this.random.nextFloat() * 0.05F);
        }


    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        final RangedAttackGoal rangedAttackGoal = new RangedAttackGoal(this, 1, 1, 10);
        this.goalSelector.addGoal(2, rangedAttackGoal);
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }

    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damageSourceIn) {
        return super.getHurtSound(damageSourceIn);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return super.getDeathSound();
    }

    @Override
    public boolean isAggressive() {
        return true;
    }



/*
    protected void registerAttributes() {

        this.getAttribute(new AttributeInstance().KNOCKBACK_RESISTANCE).setBaseValue(1D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20D);
    }
*/
    /*
    public static AttributeSupplier.@NotNull Builder registerAttributes()
    {
        return Phantom.createMobAttributes().add(Attributes.KNOCKBACK_RESISTANCE,1D)
                .add(Attributes.MAX_HEALTH,10D)
                .add(Attributes.MOVEMENT_SPEED,2D)
                .add(Attributes.ATTACK_DAMAGE,10D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.FOLLOW_RANGE,20D);
    }
    @Override
    public void registerControllers(@NotNull AnimationData data) {
        data.addAnimationController(controller);
        data.addAnimationController(controller2);
    }

    @Override
    public @NotNull AnimationFactory getFactory() {
        return manager;
    }
*/
    private <E extends HornetEntity> @NotNull PlayState animationPred(@NotNull AnimationEvent<E> event) {
        if (event.isMoving()) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.fly", true));

            return PlayState.CONTINUE;
        }
        if (event.getAnimatable().getTarget() instanceof PlayerEntity) {
            controller2.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.attack", false));
            return PlayState.CONTINUE;
        } else {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.fly", true));
            return PlayState.CONTINUE;
        }
    }
/*

    @Override
    public void performRangedAttack(@NotNull LivingEntity target, float distanceFactor) {

        EntityLaser laser = new EntityLaser(this.level, 1.0D, 1.0D, 1.0D);
        double d0 = target.getX() - this.getX();
        double d1 = target.getY(0.3333333333333333D) - laser.getY();
        double d2 = target.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        laser.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() << 2));
        this.playSound(ModSounds.LASERARROW.get(), 1.0F, 1.0F / (this.getRandom().nextFloat() * 1.2f));
        this.level.addFreshEntity(laser);
    }

    @Override
    public void attack(final LivingEntity target, final float pullProgress) {

    }

     */
}
