package com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.HoloProjector;

import com.Ultra_Nerd.CodeLyokoRemake.RF.EG;
import com.Ultra_Nerd.CodeLyokoRemake.Util.compat.Oredict;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import cofh.redstoneflux.api.IEnergyReceiver;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

public class ProjectorTE extends TileEntity implements ITickable{

	
	private boolean valid;
	private boolean OOOF;
	private int POWER;
	private ITickable powers;
	//private IInventory tories;
	private int x,y,z;
	@Override
	public void update() {
		if(!world.isRemote)
		{
		checkstruct();
				if(valid)
					{
					
					//useUran();
			
					}
		}
	}
	
	
	
	
	
	
	private void checkstruct()
	{
		
		
		x++;
		if(x > 1)
		{
			x = -1;
			y++;
			if(y > 0)
			{
				y = -1;
				z++;
				if(z > 1)
				{
					z = -1;
					valid = !OOOF && (POWER == 1 || POWER == 2);
					OOOF = false;
					POWER = 0;
					System.out.println("Valid" + valid);
					
				}
			}
		}
		
		if(x == 0 && y == 0 && z == 0)
		{
			return;
		}
		
		Block block = world.getBlockState(new BlockPos(this.pos.getX() + x, this.pos.getY() + y, this.pos.getZ() + z)).getBlock();
		Block Focus = world.getBlockState(new BlockPos(this.pos.getX(), this.pos.getY() + 1, this.pos.getZ())).getBlock();
		
		if (Focus != Blocks.GLASS)
		{
			OOOF = true;
		}
		
		
		if(y == 0 && x != 0 ^ z != 0)
		{
			TileEntity te = world.getTileEntity(new BlockPos(this.pos.getX() + x, this.pos.getY() + y, this.pos.getZ() + z));
			TileEntity te2 = world.getTileEntity(new BlockPos(this.pos.getX() + x, this.pos.getY() + y, this.pos.getZ() + z));
			if(te instanceof ITickable)
			{
				POWER++;
				powers = (ITickable)te;
			}
			else if(block != Blocks.IRON_BLOCK)
			{
				OOOF = true;
			}
		   /* if(te2 instanceof IInventory)
			{
				POWER++;
				tories = (IInventory)te2;
			}
			
			else if(block != Blocks.IRON_BLOCK)
			{
				OOOF = true;
			}*/
		}
		else if(block != Blocks.IRON_BLOCK)
		{
			OOOF = true;
		}
	}
	
	/*private void useUran()
	{
		if(tories != null)
		{
			System.out.println("notnull");
			for(int i = 0; i < tories.getSizeInventory(); i++)
			{
				
				ItemStack stack = tories.getStackInSlot(i);
				if(stack != null) {
					
					if(stack.getItem() == ModItems.URANIUM_ISOTOPE235U)
					{
					tories.decrStackSize(i, 1);
					System.out.println("used uranium");
					}
				}
			}
		}
	}*/
	
}
