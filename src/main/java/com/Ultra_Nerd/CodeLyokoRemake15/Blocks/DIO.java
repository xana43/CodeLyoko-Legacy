package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;


public class DIO extends net.minecraft.fluid.Fluid {

	
	public DIO() {
		super(Block.Properties.create(Material.WATER)
				
				.hardnessAndResistance(6, 10)
				.sound(SoundType.STONE)
				.lightValue(1)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
			);
		
	
		//setDensity(10);
		this.getFluid().setDensity(40);
		
		
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

	@Override
	public Item getFilledBucket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean canDisplace(IFluidState p_215665_1_, IBlockReader p_215665_2_, BlockPos p_215665_3_,
			net.minecraft.fluid.Fluid p_215665_4_, Direction p_215665_5_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Vec3d getFlow(IBlockReader p_215663_1_, BlockPos p_215663_2_, IFluidState p_215663_3_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTickRate(IWorldReader p_205569_1_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected float getExplosionResistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getActualHeight(IFluidState p_215662_1_, IBlockReader p_215662_2_, BlockPos p_215662_3_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getHeight(IFluidState p_223407_1_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected BlockState getBlockState(IFluidState state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSource(IFluidState state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLevel(IFluidState p_207192_1_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VoxelShape func_215664_b(IFluidState p_215664_1_, IBlockReader p_215664_2_, BlockPos p_215664_3_) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	
	
	
	
	
	

}
