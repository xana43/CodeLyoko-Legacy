package com.Ultra_Nerd.CodeLyokoRemake.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.world.World;

public class EntitySkid extends EntityBoat {

	public EntitySkid(World worldIn) {
		super(worldIn);
		world.spawnEntity(this);
	}
	
	@Override
	public void setDamageTaken(float damageTaken) {
		// TODO Auto-generated method stub
		super.setDamageTaken(0);
	}
	
	

}
