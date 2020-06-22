package com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class Interface extends TileEntity implements ITickable
{
	
	public boolean isUsableByPlayer(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
