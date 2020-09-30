package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;

public class GuardianEntity extends FlyingEntity implements IMob, IRangedAttackMob {

    public GuardianEntity(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
        recalculateSize();
    }

    @Nonnull
    @Override
    protected AxisAlignedBB getBoundingBox(@Nonnull Pose p_213321_1_) {
        return super.getBoundingBox(p_213321_1_);
    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true, true));
        this.targetSelector.addGoal(1, new TargetGoal(this,true,true) {
            @Override
            public boolean shouldExecute() {
                return true;
            }

        });

    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
     //   this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
    }

    @Nonnull
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void attackEntityWithRangedAttack(@Nonnull LivingEntity target, float distanceFactor) {

    }
}
