package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;

public class EntityBlok extends SkeletonEntity {

    private NearestAttackableTargetGoal<PlayerEntity> shoot;

    public EntityBlok(World world) {
        super(ModEntities.BLOK.get(), world);

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


    public EntityBlok(EntityType<? extends SkeletonEntity> type, World world) {
        super(type, world);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected boolean canBeRidden(@Nonnull Entity entityIn) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAggressive() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean clearActivePotions() {
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

    @Override
    public boolean canSpawn(@Nonnull IWorld worldIn, @Nonnull SpawnReason spawnReasonIn) {
        return true;
    }


    @Override
    protected void registerAttributes() {
        // TODO Auto-generated method stub
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10D);
        //this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20D);
    }

}
