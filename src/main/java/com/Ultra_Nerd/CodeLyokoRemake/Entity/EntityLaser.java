package com.Ultra_Nerd.CodeLyokoRemake.Entity;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityLaser extends EntityArrow {

	public EntityLaser(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
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
	protected ItemStack getArrowStack() {
		// TODO Auto-generated method stub
		return new ItemStack(ModItems.LASERARROW);
	}
	
	@Override
	protected void arrowHit(EntityLivingBase live) {
		if(!this.world.isRemote)
		{
			super.arrowHit(live);
		}
		
	}

	
	
}
