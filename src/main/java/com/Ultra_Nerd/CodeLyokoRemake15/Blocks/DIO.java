package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;


public class DIO extends BlockFluidClassic {

	
	public DIO(String name, Fluid fluid, Material material) {
		super(fluid, material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(null);
		//setDensity(10);
		this.getFluid().setDensity(40);
		
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}
	
	

	@Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {	
		EntityPlayer play = null;
		if(!(entityIn instanceof EntityBoat))
    	{
			if(entityIn instanceof EntityPlayer)
			{
				play = (EntityPlayer)entityIn;
				if(!(play.getRidingEntity() instanceof EntityBoat))
				{
					entityIn.attackEntityFrom(new DamageSource(this.getUnlocalizedName()), Integer.MAX_VALUE);
				}
			}
			else if (!(entityIn instanceof EntityPlayer))
			{
				entityIn.attackEntityFrom(new DamageSource(this.getUnlocalizedName()), Integer.MAX_VALUE);
			}
			
			
			
			
    	}
   
		 
    
    }
	@Override
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, SpawnPlacementType type) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean canSpawnInBlock() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	
	
	
	
	
	
	

}
