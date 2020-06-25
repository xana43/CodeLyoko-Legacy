package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Entityblok extends SkeletonEntity {

	private NearestAttackableTargetGoal<PlayerEntity> shoot;
	public Entityblok(EntityType<? extends SkeletonEntity> type, World world) {
		super(type,world);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean canBeRidden(Entity entityIn) {
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
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
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
	
	@Override
	protected void registerAttributes() {
		// TODO Auto-generated method stub
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(10D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(10D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20D);
	}

}
