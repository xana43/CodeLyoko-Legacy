package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake.Base;
import com.Ultra_Nerd.CodeLyokoRemake.Util.IHasModel;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;
public class blockBase extends Block implements IHasModel
{
	public blockBase(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}


	@Override
	public void registerModels() {
		Base.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0 , "inventory");
		
	}


	public Item[] getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
