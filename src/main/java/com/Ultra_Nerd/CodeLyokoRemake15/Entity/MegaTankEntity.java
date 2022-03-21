package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import javax.annotation.Nonnull;
import java.util.Random;

public class MegaTankEntity extends Skeleton implements IAnimatedEntity {

    private final EntityAnimationManager TankManager = new EntityAnimationManager();
    private final EntityAnimationController Tankcontroller = new EntityAnimationController(this, "movecontroller", 20, this::animationPred);

    public MegaTankEntity(EntityType<? extends Skeleton> type, Level world) {
        super(type, world);
        TankManager.addAnimationController(Tankcontroller);

    }

    public MegaTankEntity(Level world) {
        super(ModEntities.MEGATANK.get(), world);


    }





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
    }

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

    private <E extends MegaTankEntity> boolean animationPred(AnimationTestEvent<E> event) {

        if ((event.isWalking() || event.getEntity().isSwimming()) && !event.getEntity().isAggressive()) {
            Tankcontroller.setAnimation(new AnimationBuilder().addAnimation("animation.MegaTank.move", true));

            return true;
        } else if (event.getEntity().isAggressive()) {
            Tankcontroller.setAnimation(new AnimationBuilder().addAnimation("animation.MegaTank.open", true));

            return true;
        } else {
            Tankcontroller.setAnimation(new AnimationBuilder().addAnimation("animation.MegaTank.idle", true));
            return true;
        }


    }

    @Override
    public EntityAnimationManager getAnimationManager() {
        return TankManager;
    }


}
