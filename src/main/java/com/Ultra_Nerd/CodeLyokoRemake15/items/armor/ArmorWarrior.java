package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ArmorWarrior extends ArmorItem {
	private byte I = 0;
	private int damage;
	public ArmorWarrior(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
		this.damage = materialIn.getDurability(slot);
	}




	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {

		if(!player.getItemStackFromSlot(EquipmentSlotType.CHEST).isEmpty() &&
		!player.getItemStackFromSlot(EquipmentSlotType.FEET).isEmpty() &&
		!player.getItemStackFromSlot(EquipmentSlotType.LEGS).isEmpty()
		){

			if(player.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() == ModItems.WILLIAM_CHESTPLATE.get() && player.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).getItem() == ModItems.WILLIAM_LEGGINGS.get() && player.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).getItem() == ModItems.WILLIAM_BOOTS.get()) {
				I++;
					if(I == 1000)
					{
						if(stack.getDamage() != 0)
						{
							stack.damageItem(-1, player, null);
						}
						I = 0;
					}
				if(player.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getDamage() < damage && player.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).getDamage() < damage && player.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).getDamage() < damage) {
					player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, -1, 1, false, false, false));
					player.addPotionEffect(new EffectInstance(Effects.STRENGTH, -1, 3, false, false, false));
					player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, -1, 2, false, false, false));
				}

			}




		}
	}


}
