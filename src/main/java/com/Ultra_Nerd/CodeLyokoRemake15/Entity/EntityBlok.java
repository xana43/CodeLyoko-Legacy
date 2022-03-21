package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nonnull;
import java.util.Random;

public class EntityBlok extends Skeleton implements IAnimatable {


    private final AnimationFactory manager = new AnimationFactory(this);
    private final AnimationController controller = new AnimationController(this, "blokcontroller", 20, this::pred);
/*
    public EntityBlok(Level world) {
        super(ModEntities.BLOK.get(), world);

    }*/




    private <E extends EntityBlok> PlayState pred(AnimationEvent<E> event) {
        return PlayState.STOP;
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(controller);
    }

    @Override
    protected boolean isSunBurnTick() {
        return false;
    }

    @Override
    public boolean isFreezeConverting() {
        return false;
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    @Override
    public void setAggressive(boolean p_21562_) {
        super.setAggressive(true);
    }



    public EntityBlok(EntityType<? extends Skeleton> type, Level world) {
        super(type, world);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected boolean canRide(Entity p_20339_) {
        return false;
    }

    @Override
    public void clearFire() {
        super.clearFire();
    }

    @Override
    public boolean curePotionEffects(ItemStack curativeItem) {
        return true;
    }

    @Override
    public boolean isAggressive() {
        // TODO Auto-generated method stub
        return true;
    }



    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damageSourceIn) {
        // TODO Auto-generated method stub
        return ModSounds.BLOKHURT.get();
    }



    @Override
    protected SoundEvent getAmbientSound() {
        // TODO Auto-generated method stub
        return ModSounds.BLOKAMBIENT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        // TODO Auto-generated method stub
        return super.getDeathSound();
    }

    @Nonnull
    @Override
    protected SoundEvent getStepSound() {
        return super.getStepSound();
    }



    public static boolean canSpawn(EntityType<EntityBlok> entity, LevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random)
    {
        return checkMobSpawnRules(entity,levelAccessor,spawnType,pos,random) && pos.getY() > 70;
    }


    public static AttributeSupplier.@NotNull Builder createAttributes(){
        return Mob.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 10D)
                .add(Attributes.MAX_HEALTH,10D)
                .add(Attributes.MOVEMENT_SPEED,0.5D)
                .add(Attributes.ATTACK_DAMAGE,10D)
                .add(Attributes.ARMOR,10D)
                .add(Attributes.FOLLOW_RANGE, 20D);
    }



    @Override
    public AnimationFactory getFactory() {
        return manager;
    }
}
