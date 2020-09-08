package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import javax.annotation.Nonnull;

public class HornetEntity extends MobEntity implements IAnimatedEntity {

    EntityAnimationManager manager = new EntityAnimationManager();
    EntityAnimationController controller = new EntityAnimationController(this, "movecontroller", 20, this::animationPred);

    public HornetEntity(EntityType<HornetEntity> hornetEntityEntityType, World world) {
        super(hornetEntityEntityType,world);
        registerControllers();
    }


    @Nonnull
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected boolean isInDaylight() {
        return false;
    }

    public HornetEntity(World world) {
        super(ModEntities.HORNET.get(), world);

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
    protected boolean canBeRidden(@Nonnull Entity entityIn) {
        return false;
    }


    @Override
    public boolean canSpawn(@Nonnull IWorld worldIn, @Nonnull SpawnReason spawnReasonIn) {
        return true;
    }
/*
    @Override
    protected void registerAttributes() {
        // TODO Auto-generated method stub
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20D);
    }

 */

    @Override
    public EntityAnimationManager getAnimationManager() {
        return manager;
    }

    private <E extends HornetEntity> boolean animationPred(AnimationTestEvent<E> event) {
        if (event.isWalking()) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.fly", true));
            return true;
        } else {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.fly", true));
            return true;
        }
    }

    private void registerControllers() {
        manager.addAnimationController(controller);

    }

}
