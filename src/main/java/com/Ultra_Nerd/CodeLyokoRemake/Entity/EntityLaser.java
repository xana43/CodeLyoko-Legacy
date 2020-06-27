package com.Ultra_Nerd.CodeLyokoRemake.Entity;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityLaser extends EntityArrow {

	public EntityLaser(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
		this.setDamage(10D);
		this.pickupStatus = PickupStatus.DISALLOWED;
		
	}
	public EntityLaser(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		
	
		// TODO Auto-generated constructor stub
	}
	public EntityLaser(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
		// TODO Auto-generated constructor stub
	}
	
	


	
	
	@Override
	protected boolean makeFlySound() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
 
	
	@Override
	public void setDamage(double damageIn) {
		// TODO Auto-generated method stub
		super.setDamage(10);
	}
	
	@Override
	protected boolean canBeRidden(Entity entityIn) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	@Override
	protected void onHit(RayTraceResult raytraceResultIn) {
		EntityLivingBase entity = (EntityLivingBase) raytraceResultIn.entityHit; 
		if(!(entity instanceof EntityLivingBase))
		{
			this.setDead();
			//System.out.println("no target");
		}
		else
		{
			//System.out.println("target hit");
			entity.attackEntityFrom(new DamageSource(this.getName()), 10);
		}
		;
	}

	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(ModItems.LASERARROW);
	}


}
