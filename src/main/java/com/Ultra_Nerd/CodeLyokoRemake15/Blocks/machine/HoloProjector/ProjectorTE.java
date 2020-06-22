package com.Ultra_Nerd.CodeLyokoRemake15.Blocks.machine.HoloProjector;

import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.HoloPro;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.QuantSteel;
import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class ProjectorTE extends TileEntity implements ITickable{

	
	public static boolean valid;
	private boolean OOOF;
	private int POWER;
	private ITickable powers;
	//private IInventory tories;
	private int x,y,z;
	@Override
	public void update() {
		
		boolean once = false;
		boolean onceback = false;
		
			
		checkstruct();
		once = false;
				if(valid)
					{
					HoloPro.SetModel(true, this.world, this.pos);
                    Block blockState = world.getBlockState(new BlockPos(this.pos.getX(), this.pos.getY() + 1, this.pos.getZ())).getBlock();
                    
                    
                    QuantSteel.SetModel2(true, world, pos);
                	QuantSteel.trans2 = true;
					HoloPro.trans = true;
					
					
                    if(blockState == Blocks.GLASS && !once)
                    {
                    	
                        world.setBlockState(this.pos.add(0, 1, 0), Modblocks.TRANSPARENT.getDefaultState());
                       
                        once = true;
                    }
                    
                    
                      
                    
					
					
					//useUran();
			
					}
				else 
				{
					QuantSteel.SetModel2(false, world, pos);
                	QuantSteel.trans2 = false;
					HoloPro.trans = false;
					HoloPro.SetModel(false, this.world, this.pos);
					if(world.getBlockState(this.pos.add(0, 1, 0)).getBlock().getDefaultState() != Blocks.GLASS.getDefaultState() && onceback)
					{
						world.setBlockState(this.pos.add(0, 1, 0), Blocks.GLASS.getDefaultState());
						onceback = false;
					}
					
				}
				
				
		
	}
	
	
	
	
	
	private void checkstruct()
	{
		
			
		
		
		x++;
		if(x > 1)
		{
			System.out.println("notworking");
			x = -1;
			y++;
			if(y > 0)
			{
				y = -1;
				z++;
				if(z > 1)
				{
					z = -1;
					valid = !OOOF && (POWER == 1 || POWER == 2 || POWER == 3 || POWER == 4);
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
			if(Focus != Modblocks.TRANSPARENT)
			{
			OOOF = true;
			}
		}
		
		
		if(y == 0 && x != 0 ^ z != 0)
		{
			TileEntity te = world.getTileEntity(new BlockPos(this.pos.getX() + x, this.pos.getY() + y, this.pos.getZ() + z));
			//TileEntity te2 = world.getTileEntity(new BlockPos(this.pos.getX() + x, this.pos.getY() + y, this.pos.getZ() + z));
			if(te instanceof ITickable)
			{
				POWER++;
				powers = (ITickable)te;
			}
			else if(block != Modblocks.QUANTUM_STEEL)
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
		else if(block != Modblocks.QUANTUM_STEEL)
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
