package com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public final class LyokoGuardianEntity extends FlyingEntity implements RangedAttackMob {
    public LyokoGuardianEntity(final EntityType<? extends FlyingEntity> entityType, final World world) {
        super(entityType, world);
    }

    @Override
    public void shootAt(final LivingEntity target, final float pullProgress) {

    }

    public static DefaultAttributeContainer.Builder createGuardianAttributes()
    {

        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_ATTACK_DAMAGE,6).add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.5D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE,16).add(EntityAttributes.GENERIC_MAX_HEALTH,30);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        //this.goalSelector.add(8,new LookAtEntityGoal(this, PlayerEntity.class,8.0f));
        this.goalSelector.add(4,new ActiveTargetGoal<>(this, PlayerEntity.class,true));
        this.goalSelector.add(1,new ProjectileAttackGoal(this,1,20,5));

    }


}
