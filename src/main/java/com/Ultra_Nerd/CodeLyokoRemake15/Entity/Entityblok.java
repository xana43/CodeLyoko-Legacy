package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers.Loot;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers.Souinds;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Entityblok extends EntitySkeleton {

	public Entityblok(World worldIn) 
	{
		super(worldIn);
		this.setSize(4, 1.99F);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void initEntityAI() {
		 this.tasks.addTask(1, new EntityAISwimming(this));
	        //this.tasks.addTask(2, new EntityAIRestrictSun(this));
	        //this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
	        //this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityWolf.class, 6.0F, 1.0D, 1.2D));
	        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
	        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	        this.tasks.addTask(6, new EntityAILookIdle(this));
	        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
	}
	@Override
	protected void applyEntityAttributes() {
		// TODO Auto-generated method stub
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
	}
	
	@Override
	protected ResourceLocation getLootTable() {
		// TODO Auto-generated method stub
		return Loot.BLOK;
	}
	
	@Override
	public void onLivingUpdate() {
		if(this.isBurning())
		{
			this.setFire(0);
		}
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		// TODO Auto-generated method stub
		return Souinds.ENTITY_BLOK_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		// TODO Auto-generated method stub
		return Souinds.ENTITY_BLOK_HURT;
	}
	@Override
	protected SoundEvent getDeathSound() {
		// TODO Auto-generated method stub
		return Souinds.ENTITY_BLOK_DEATH;
	}


}
