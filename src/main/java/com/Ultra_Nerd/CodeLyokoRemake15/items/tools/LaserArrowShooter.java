package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;



public class LaserArrowShooter extends BowItem{

	
	
	 
	
	public LaserArrowShooter(Properties builder) {
		super(builder);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		ItemStack arrow = null;
		for(int i = 0; i < playerIn.inventory.getSizeInventory();i++)
		{
			arrow = playerIn.inventory.getStackInSlot(i);
		}
		
		if(arrow.getItem() == ModItems.BIT.get())
		{
			arrow.setCount(arrow.getCount() - 1);
		}
		
		Vec3d aim = playerIn.getLookVec();
		//worldIn.playSound(null,playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), ModItems.BIT.get(), SoundCategory.NEUTRAL, 1f, 1f);
		worldIn.playSound(playerIn,playerIn.getPosX(),playerIn.getPosY(),playerIn.getPosZ(), ModSounds.LASERARROW.get(),SoundCategory.NEUTRAL,1f,1f);
		EntityLaser las = new EntityLaser(worldIn, 1.0D, 1.0D, 1.0D);
		
		las.setPosition(playerIn.getPosX() + aim.x * 1.5D, playerIn.getPosY() + aim.y * 1.9D, playerIn.getPosZ() + aim.z * 1.5D);
		las.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0f, 10f, 0f);		
		if(!worldIn.isRemote)
		{
			worldIn.addEntity(las);
		}
		
		item.damageItem(1, playerIn, null);
		return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
	}



	
			
	
}
