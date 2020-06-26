package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityLaser extends ArrowEntity {

	public EntityLaser(final EntityType<? extends EntityLaser> entityType,World world) {
		super(entityType,world);
		// TODO Auto-generated constructor stub
	}
	public EntityLaser(World worldIn,LivingEntity throwerIn) {
		super(worldIn, throwerIn);
		// TODO Auto-generated constructor stub
	}
	public EntityLaser(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ItemStack getArrowStack() {
		// TODO Auto-generated method stub
		return new ItemStack(ModItems.GIGABIT.get());
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
	protected void arrowHit(LivingEntity live) {
		if(!this.world.isRemote)
		{
			super.arrowHit(live);
		}
		
	}

	
	
}
