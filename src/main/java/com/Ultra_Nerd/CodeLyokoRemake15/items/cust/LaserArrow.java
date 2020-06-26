package com.Ultra_Nerd.CodeLyokoRemake15.items.cust;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LaserArrow extends ArrowItem {

	public LaserArrow()
	{
		super(new Item.Properties().group(Base.LYOKO_ITEMS));
	}
	
	@Override
	public boolean isInfinite(ItemStack stack, ItemStack bow, PlayerEntity player) {
		// TODO Auto-generated method stub
		return false;
	}
}
