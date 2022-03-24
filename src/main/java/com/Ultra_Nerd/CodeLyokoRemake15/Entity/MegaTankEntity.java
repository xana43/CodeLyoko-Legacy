package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nonnull;
import java.util.Random;

public class MegaTankEntity extends Skeleton implements IAnimatable /*implements IAnimatedEntity*/ {

   private final AnimationFactory TankManager = new AnimationFactory(this);
    private final AnimationController Tankcontroller = new AnimationController(this, "movecontroller", 20, this::animationPred);

    public MegaTankEntity(EntityType<? extends Skeleton> type, Level world) {
        super(type, world);

    }
/*
    public MegaTankEntity(Level world) {
        super(ModEntities.MEGATANK.get(), world);


    }*/





    @Override
    protected void dropExperience() {
        super.dropExperience();
    }


    @Override
    protected boolean canRide(@Nonnull Entity entityIn) {
        return false;
    }





    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public boolean canBeAffected(MobEffectInstance p_21197_) {
        return false;
    }



/*
    @Override
    protected void registerAttributes() {
        // TODO Auto-generated method stub
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20D);
    }*/

    @Override
    public boolean isSprinting() {
        return true;
    }



    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.MEGATANKDIE.get();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }




    @Nonnull
    @Override
    public Fallsounds getFallSounds() {
        return  new Fallsounds(ModSounds.MEGATANKSMALLFALL.get(),ModSounds.MEGATANKBIGFALL.get());
    }


    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damageSourceIn) {
        boolean random = new Random().nextBoolean();
        if (random) {
            return ModSounds.MEGATANKHURT1.get();
        } else {
            return ModSounds.MEGATANKHURT2.get();
        }
    }

    @Nonnull
    @Override
    protected SoundEvent getStepSound() {


        return ModSounds.MEGATANKROLL.get();

    }

    @Override
    public void registerControllers(AnimationData data) {
    data.addAnimationController(Tankcontroller);
    }



    private <E extends MegaTankEntity> PlayState animationPred(AnimationEvent<E> event) {

        if ((event.isMoving() || event.getAnimatable().isSwimming()) && !event.getAnimatable().isAggressive()) {
            Tankcontroller.setAnimation(new AnimationBuilder().addAnimation("animation.MegaTank.move", true));

            return PlayState.CONTINUE;
        } else if (event.getAnimatable().isAggressive()) {
            Tankcontroller.setAnimation(new AnimationBuilder().addAnimation("animation.MegaTank.open", true));

            return PlayState.CONTINUE;
        } else {
            Tankcontroller.setAnimation(new AnimationBuilder().addAnimation("animation.MegaTank.idle", true));
            return PlayState.CONTINUE;
        }


    }

    @Override
    public AnimationFactory getFactory() {
        return TankManager;
    }


}
