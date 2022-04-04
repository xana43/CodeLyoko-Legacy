package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;

public class GuardianEntity extends FlyingMob implements RangedAttackMob {

    public GuardianEntity(EntityType<? extends FlyingMob> type, Level worldIn) {
        super(type, worldIn);

    }



    @Override
    protected AABB getBoundingBoxForPose(Pose p_20218_) {
        return super.getBoundingBoxForPose(p_20218_);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
        this.targetSelector.addGoal(1, new TargetGoal(this, true, true) {


            @Override
            public boolean canUse() {
                return false;
            }
        });

    }



    public void registerAttributes() {
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(16.0D);
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30.0D);
    }

    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }



    @Override
    public void performRangedAttack(LivingEntity p_33317_, float p_33318_) {

    }
}
