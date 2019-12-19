package com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.HoloProjector;

import com.Ultra_Nerd.CodeLyokoRemake.Blocks.QuantSteel;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InvisRend extends TileEntity implements ITickable{

	
	private boolean state = false;
	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(ProjectorTE.valid)
		{
			
			QuantSteel.SetModel2(true, world, pos);
			QuantSteel.trans2 = true;
	
		}
		else
		{
			QuantSteel.trans2 = false;
			QuantSteel.SetModel2(false, world, pos);
		}
	}
	
	
		
	/* @Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		// TODO Auto-generated method stub
		return (oldState.getBlock() != newSate.getBlock());
	}
	 
	 @Override
		public void readFromNBT(NBTTagCompound compound)
		{
			super.readFromNBT(compound);
			
			this.state = compound.getBoolean("state");
			
		}
		
		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound compound) 
		{
			super.writeToNBT(compound);
			
			compound.setBoolean("state", state);
			
			return compound;
		}*/

}
