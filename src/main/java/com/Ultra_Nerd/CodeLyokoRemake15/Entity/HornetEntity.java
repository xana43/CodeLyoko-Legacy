package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nonnull;

public class HornetEntity extends Phantom implements IAnimatable, RangedAttackMob {

    private final AnimationFactory manager = new AnimationFactory(this);
    private final AnimationController controller2 = new AnimationController(this, "attackcontroller", 20, this::animationPred);
    private final AnimationController controller = new AnimationController(this, "movecontroller", 20, this::animationPred);
    private RangedAttackGoal rangedAttackGoal;

    public HornetEntity(EntityType<HornetEntity> hornetEntityEntityType, Level world) {
        super(hornetEntityEntityType, world);

    }
/*
    public HornetEntity(Level world) {
        super(ModEntities.HORNET.get(), world);

    }*/

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
        this.rangedAttackGoal = new RangedAttackGoal(this, 1, 1, 1);
        this.goalSelector.addGoal(4, rangedAttackGoal);
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




    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20D);
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(controller);
        data.addAnimationController(controller2);
    }

    @Override
    public AnimationFactory getFactory() {
        return manager;
    }

    private <E extends HornetEntity> PlayState animationPred(AnimationEvent<E> event) {
        if (event.isMoving()) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.fly", true));

            return PlayState.CONTINUE;
        }
        if (event.getAnimatable().getTarget() instanceof Player) {
            controller2.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.attack", false));
            return PlayState.CONTINUE;
        } else {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.fly", true));
            return PlayState.CONTINUE;
        }
    }


    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {

        EntityLaser laser = new EntityLaser(this.level, 1.0D, 1.0D, 1.0D);
        double d0 = target.getX() - this.getX();
        double d1 = target.getY(0.3333333333333333D) - laser.getY();
        double d2 = target.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        laser.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
        this.playSound(ModSounds.LASERARROW.get(), 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(laser);
    }
}
