package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.EntityViewRenderEvent.CameraSetup;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class DIO extends BlockFluidClassic {

	
	public DIO(String name, Fluid fluid, Material material) {
		super(fluid, material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(null);
		setDensity(10);
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}
	
	@SubscribeEvent
	public void kill(LivingAttackEvent event)
	{
		if(event.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer play = (EntityPlayer)event.getEntity();
			if(event.getSource().equals(new DamageSource(this.getUnlocalizedName())))
			{
				if(play.getRidingEntity() instanceof EntityBoat)
				{
					event.setCanceled(true);
				}
			}
		}
			
	}
	
	@Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {	if(!(entityIn instanceof EntityBoat))
    	{
    	EntityPlayer play = (EntityPlayer)entityIn;
    	if(!(play.getRidingEntity() instanceof EntityBoat))
    	{
        entityIn.attackEntityFrom(new DamageSource(this.getUnlocalizedName()), Integer.MAX_VALUE);
    	}
    	}
   
    
    
    }
	
	
	
	
	
	

}
