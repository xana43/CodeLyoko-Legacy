package com.Ultra_Nerd.CodeLyokoRemake.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.google.common.collect.Multimap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class Zweihander extends ItemSword {
	
	private float attackDamage;
	private final Item.ToolMaterial material;
	public Zweihander(String name, Item.ToolMaterial material)
	{
		
		super(material);
		this.material = material;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		this.attackDamage = 9.0F + material.getAttackDamage();
		
		ModItems.Items.add(this);
	}
	
	
@Override
public float getAttackDamage() {
	// TODO Auto-generated method stub
	return this.material.getAttackDamage();
}

@Override
public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
{
    Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

    if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
    {
        multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
        multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -4D, 0));
    }

    return multimap;
}

}



