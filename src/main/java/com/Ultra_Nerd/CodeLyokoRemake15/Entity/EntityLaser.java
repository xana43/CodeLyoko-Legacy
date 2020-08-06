package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;

public class EntityLaser extends ArrowEntity {

	public EntityLaser(EntityType<? extends ArrowEntity> Laser,World world) {
		super(Laser,world);
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

	public EntityLaser(World world)
	{
		super(ModEntities.LASER.get(),world);
	}

	@Nonnull
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
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
	protected void arrowHit(@Nonnull LivingEntity live) {
		if(!this.world.isRemote)
		{
			super.arrowHit(live);
		}
		
	}

	
	
}
