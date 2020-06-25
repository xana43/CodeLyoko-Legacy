package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor {

	public ArmorBase(String name,ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn,renderIndexIn,equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		
		ModItems.Items.add(this);
	}

	

}
