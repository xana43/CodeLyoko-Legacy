package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import net.minecraft.entity.item.BoatEntity;
import net.minecraft.world.World;

public class EntitySkid extends BoatEntity {


	public EntitySkid(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);

	}

	@Override
	public void setDamageTaken(float damageTaken) {
		// TODO Auto-generated method stub
		super.setDamageTaken(0);
	}
	
	

}
