package com.Ultra_Nerd.CodeLyokoRemake.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake.Base;
import com.Ultra_Nerd.CodeLyokoRemake.Util.IHasModel;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Souinds;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.items.ItemBase;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.PlaySoundEvent;



public class LaserArrowShooter extends ItemBase{

	public LaserArrowShooter(String name)
	{
		super(name);
		
		//this.attackDamage = 3.0F + material.getAttackDamage();
		
	}
	
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		Vec3d aim = playerIn.getLookVec();
		worldIn.playSound(playerIn,playerIn.posX, playerIn.posY, playerIn.posZ, Souinds.SHOOT, SoundCategory.NEUTRAL, 1f, 1f);
		EntityTNTPrimed tnt = new EntityTNTPrimed(worldIn);
				
			
				
		EntityFireball fire = new EntityFireball(worldIn, playerIn, 1, 1, 1) {
		
			@Override
			protected void onImpact(RayTraceResult result) {
				worldIn.spawnEntity(tnt);
				
				
			}
		};
			fire.setPosition(playerIn.posX + aim.x * 1.5D, playerIn.posY + aim.y * 1.5D, playerIn.posZ + aim.z * 1.5D);
			fire.accelerationX = aim.x * 1;
			fire.accelerationY = aim.y * 1;
			fire.accelerationZ = aim.z * 1;
		worldIn.spawnEntity(fire);
		item.damageItem(1, playerIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
	}



	
			
	
}
