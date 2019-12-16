package com.Ultra_Nerd.CodeLyokoRemake.Entity;

import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;

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
