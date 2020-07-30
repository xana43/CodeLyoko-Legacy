package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class HornetEntity extends PhantomEntity {


    public HornetEntity(EntityType<? extends PhantomEntity> type, World worldIn) {
        super(type, worldIn);
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
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
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
    protected boolean canBeRidden(Entity entityIn) {
        return false;
    }


    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
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
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20D);
    }
}
