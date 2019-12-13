package com.Ultra_Nerd.CodeLyokoRemake.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Souinds;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;



public class LaserArrowShooter extends Item{

	public LaserArrowShooter(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		
		setCreativeTab(CreativeTabs.COMBAT);
		ModItems.Items.add(this);
		//this.attackDamage = 3.0F + material.getAttackDamage();
		
	}
	
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		Vec3d aim = playerIn.getLookVec();
		worldIn.playSound(null,playerIn.posX, playerIn.posY, playerIn.posZ, Souinds.SHOOT, SoundCategory.NEUTRAL, 1f, 1f);
		EntityLaser las = new EntityLaser(worldIn, 1.0D, 1.0D, 1.0D);
		
		las.setPosition(playerIn.posX + aim.x * 1.5D, playerIn.chasingPosY + aim.y * 1.68D, playerIn.posZ + aim.z * 1.5D);
		las.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 1.5f, 0.5f);		
		if(!worldIn.isRemote)
		{
			worldIn.spawnEntity(las);
		}
		
		item.damageItem(1, playerIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
	}



	
			
	
}
