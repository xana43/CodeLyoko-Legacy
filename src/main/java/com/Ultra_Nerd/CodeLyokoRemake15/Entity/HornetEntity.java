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
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import javax.annotation.Nonnull;

public class HornetEntity extends Phantom implements IAnimatedEntity, RangedAttackMob {

    private final EntityAnimationManager manager = new EntityAnimationManager();
    private final EntityAnimationController controller2 = new EntityAnimationController(this, "attackcontroller", 20, this::animationPred);
    private final EntityAnimationController controller = new EntityAnimationController(this, "movecontroller", 20, this::animationPred);
    private RangedAttackGoal rangedAttackGoal;

    public HornetEntity(EntityType<HornetEntity> hornetEntityEntityType, Level world) {
        super(hornetEntityEntityType, world);
        manager.addAnimationController(controller);
        manager.addAnimationController(controller2);
    }

    public HornetEntity(Level world) {
        super(ModEntities.HORNET.get(), world);

    }

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
    public EntityAnimationManager getAnimationManager() {
        return manager;
    }

    private <E extends HornetEntity> boolean animationPred(AnimationTestEvent<E> event) {
        if (event.isWalking()) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.fly", true));

            return true;
        }
        if (event.getEntity().getAttackTarget() instanceof PlayerEntity) {
            controller2.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.attack", false));
            return true;
        } else {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.fly", true));
            return true;
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
