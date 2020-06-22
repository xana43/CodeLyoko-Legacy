package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Conf;
import com.Ultra_Nerd.CodeLyokoRemake.commands.tele;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Virutalization extends Block {

	public Virutalization(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onBlockActivated(World worldin, BlockPos pos, IBlockState state, EntityPlayer playerin, EnumHand hand, EnumFacing facing, float x, float y, float z)
	{	
		

		if(!worldin.isRemote)// TODO Auto-generated method stub
		{
			
			tele.teleportToDim(playerin, Conf.Dim, playerin.getPosition().getX(), playerin.getPosition().getY() + 5, playerin.getPosition().getZ());
			return true;
			
		}
		else return false;
	}

}
