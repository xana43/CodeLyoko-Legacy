package com.Ultra_Nerd.CodeLyokoRemake.Blocks.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;


public class MuliblockTest extends TileEntity{

	
	
	Block block = Modblocks.COMPUTER_FRAME;
	
	
	
	public boolean Check(World worldin, EntityPlayer arg)
	{
		int x = this.pos.getX();
		int y = this.pos.getY();
		int z = this.pos.getZ();
		
			if(worldin.getBlockState(new BlockPos(x + 5, y, z)) == block)
			{
				arg.sendMessage(new TextComponentString("x good"));
				if(worldin.getBlockState(new BlockPos(x , y + 5, z)) == block)
				{
					arg.sendMessage(new TextComponentString("y good"));
					if(worldin.getBlockState(new BlockPos(x, y, z + 5)) == block)
					{
						arg.sendMessage(new TextComponentString("z good"));
						return true;
					}
				}
				
			}
			return false;
		
	
	
	}
	
}
