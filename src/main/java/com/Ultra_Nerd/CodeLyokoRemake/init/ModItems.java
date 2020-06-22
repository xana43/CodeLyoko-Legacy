package com.Ultra_Nerd.CodeLyokoRemake.init;

import java.util.ArrayList;
import java.util.List;

import com.Ultra_Nerd.CodeLyokoRemake.Base;
import com.Ultra_Nerd.CodeLyokoRemake.Records.*;
import com.Ultra_Nerd.CodeLyokoRemake.Util.*;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.*;
import com.Ultra_Nerd.CodeLyokoRemake.items.*;
import com.Ultra_Nerd.CodeLyokoRemake.items.armor.*;
import com.Ultra_Nerd.CodeLyokoRemake.items.cust.LaserArrow;
import com.Ultra_Nerd.CodeLyokoRemake.items.tools.*;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistry;

public class ModItems 
{
 
 public static final List<Item> Items = new ArrayList<Item>();
 public static final List<Item> Records = new ArrayList<Item>();

 //materials
 public static final ToolMaterial MATERIAL_QUANTUM = EnumHelper.addToolMaterial("material_quantum", 20, 250, 7.0f, 3.0f, 900);
 public static final ToolMaterial MATERIAL_WARRIOR = EnumHelper.addToolMaterial("material_warrior", 4, 4000, 20, 30, 9000);
 public static final ToolMaterial MATERIAL_FELINE = EnumHelper.addToolMaterial("material_feline", 4, 2000, 900, 6, 90);
 public static final ToolMaterial MATERIAL_NINJA = EnumHelper.addToolMaterial("material_ninja", 4, 2000, 9000, 6, 90);
 public static final ToolMaterial MATERIAL_SAMURAI = EnumHelper.addToolMaterial("material_samurai" , 4 ,1000, 10, 25, 80);
 public static final ToolMaterial MATERIAL_GUARDIAN = EnumHelper.addToolMaterial("material_guardian", 4, 4000, 40, 60, 100);
 public static final ArmorMaterial ARMOR_MATERIAL_ODD = EnumHelper.addArmorMaterial("armor_material_odd", ref.MOD_ID + ":odd", 30, new int[] {6, 12, 16, 6}, 20, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 0.0f);
 public static final ArmorMaterial ARMOR_MATERIAL_YUMI = EnumHelper.addArmorMaterial("armor_material_yumi", ref.MOD_ID + ":yumi", 30, new int[] {6, 12, 16, 6}, 20, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 0.0f);
 public static final ArmorMaterial ARMOR_MATERIAL_AELITA = EnumHelper.addArmorMaterial("armor_material_aelita", ref.MOD_ID + ":aelita", 30, new int[] {6, 12, 16, 6}, 20, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 0.0f);
 public static final ArmorMaterial ARMOR_MATERIAL_ULRICH = EnumHelper.addArmorMaterial("armor_material_ulrich", ref.MOD_ID + ":ulrich", 30, new int[] {4, 16, 12, 9}, 20, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 0.0f);
 public static final ArmorMaterial ARMOR_MATERIAL_WILLIAM = EnumHelper.addArmorMaterial("armor_material_william", ref.MOD_ID + ":william", 30, new int[] {24, 24, 24, 24}, 20, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 0.0f);
 public static final ArmorMaterial ARMOR_MATERIAL_BITS = EnumHelper.addArmorMaterial("armor_material_bits", ref.MOD_ID + ":bits", 30, new int[] {16, 16, 16, 16}, 20, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 0.0f);
 public static final ArmorMaterial AROMOR_MATERIAL_JEREMY = EnumHelper.addArmorMaterial("armor_material_jeremy", ref.MOD_ID + ":jeremy", 30, new int[]{3,3,3,3}, 20, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 0.0f);
 //Items
 public static final Item SOLID_QUANTUM = new ItemBase("solid_quantum");

 public static final Item SILICON_WAFER = new ItemBase("silicon_wafer");
 public static final Item URANIUM_SILACATE = new ItemBase("uranium_silacate");
 public static final Item URANIUM_DIOXIDE = new ItemBase("uranium_dioxide");
 public static final Item URANIUM_MELT = new ItemBase("uranium_melt");
 public static final Item URANIUM_ISOTOPE238 = new ItemBase("uranium238");
 public static final Item URANIUM_ISOTOPE23S5 = new ItemBase("uranium23/5");
 public static final Item URANIUM_ISOTOPE235U = new ItemBase("uranium235");
 public static final Item RAW_SILICADUST = new ItemBase("raw_silicadust");
 public static final Item TRIURANIUM_OCTAOXIDE = new ItemBase("triuranium_octaoxide");
 public static final Item FLOURIDE = new ItemBase("flouride");
 public static final Item BIT = new ItemBase("bit");
 public static final Item BYTE = new ItemBase("byte");
 public static final Item MEGABIT = new ItemBase("megabit");
 public static final Item MEGABYTE = new ItemBase("MegaByte");
 public static final Item GIGABIT = new ItemBase("gigabit");
 public static final Item GIGABYTE = new ItemBase("GigaByte");
 public static final Item TERABIT = new ItemBase("terabit");
 public static final Item TERABYTE = new ItemBase("TeraByte");
 public static final Item PETABIT = new ItemBase("petabit");
 public static final Item PETABYTE = new ItemBase("PetaByte");
 public static final Item QUBIT = new ItemBase("qubit");
 public static final Item QUBYTE = new ItemBase("QuByte");
 public static final Item TITANIUM = new ItemBase("titanium_ingot");

 //tools
 public static final ItemSword ZWEIHANDER = new Zweihander("zweihander", MATERIAL_WARRIOR);
 public static final ItemSword QUANTUM_SABER = new QuantSword("quantum_saber", MATERIAL_QUANTUM);
 public static final ItemSpade DIGITAL_SAMPLER = new QuantSpade("digital_sampler", MATERIAL_QUANTUM);
 public static final Item LASER_ARROWSHOOTER = new LaserArrowShooter("laser_arrowshooter");
 public static final ItemSword DIGITAL_SABER = new QuantSword("digital_saber", MATERIAL_SAMURAI);  
 //armor
 public static final Item DIGITAL_ENVELOPE_CAP = new ArmorBase("digital_envelope_cap", ARMOR_MATERIAL_BITS, 1 , EntityEquipmentSlot.HEAD);
 public static final Item AELITA_CHESTPLATE = new ArmorBase("aelita_chestplate", ARMOR_MATERIAL_AELITA, 1 , EntityEquipmentSlot.CHEST);
 public static final Item AELITA_LEGGINGS = new ArmorBase("aelita_leggings", ARMOR_MATERIAL_AELITA, 2 , EntityEquipmentSlot.LEGS);
 public static final Item AELITA_BOOTS = new ArmorBase("aelita_boots", ARMOR_MATERIAL_AELITA, 1 , EntityEquipmentSlot.FEET);
 public static final Item ULRICH_CHESTPLATE = new ArmorBase("ulrich_chestplate", ARMOR_MATERIAL_ULRICH, 1 , EntityEquipmentSlot.CHEST);
 public static final Item ULRICH_LEGGINGS = new ArmorBase("ulrich_leggings", ARMOR_MATERIAL_ULRICH, 2 , EntityEquipmentSlot.LEGS);
 public static final Item ULRICH_BOOTS = new ArmorBase("ulrich_boots", ARMOR_MATERIAL_ULRICH, 1 , EntityEquipmentSlot.FEET);
 public static final Item YUMI_CHESTPLATE = new ArmorBase("yumi_chestplate", ARMOR_MATERIAL_YUMI, 1 , EntityEquipmentSlot.CHEST);
 public static final Item YUMI_LEGGINGS = new ArmorBase("yumi_leggings", ARMOR_MATERIAL_YUMI, 2 , EntityEquipmentSlot.LEGS);
 public static final Item YUMI_BOOTS = new ArmorBase("yumi_boots", ARMOR_MATERIAL_YUMI, 1 , EntityEquipmentSlot.FEET);
 public static final Item ODD_CHESTPLATE = new ArmorBase("odd_chestplate", ARMOR_MATERIAL_ODD, 1 , EntityEquipmentSlot.CHEST);
 public static final Item ODD_LEGGINGS = new ArmorBase("odd_leggings", ARMOR_MATERIAL_ODD, 2 , EntityEquipmentSlot.LEGS);
 public static final Item ODD_BOOTS = new ArmorBase("odd_boots", ARMOR_MATERIAL_ODD, 1 , EntityEquipmentSlot.FEET);
 public static final Item WILLIAM_CHESTPLATE = new ArmorBase("william_chestplate", ARMOR_MATERIAL_WILLIAM, 1 , EntityEquipmentSlot.CHEST);
 public static final Item WILLIAM_LEGGINGS = new ArmorBase("william_leggings", ARMOR_MATERIAL_WILLIAM, 2 , EntityEquipmentSlot.LEGS);
 public static final Item WILLIAM_BOOTS = new ArmorBase("william_boots", ARMOR_MATERIAL_WILLIAM, 1 , EntityEquipmentSlot.FEET);
 public static final Item LASERARROW = new LaserArrow("laser_arrow");
 public static ItemRecord LYOKO;
 public static void initRecords()
 {
	 LYOKO = new LyokoRecord("lyokoDisc", Souinds.THEME);
 }
 
 public static void register(Item item)
 {
	 ForgeRegistries.ITEMS.register(item);
	 
 }
 
 public static void reg() {
	 
	 for(Item records : ModItems.Records)
	 {
		 register(records); 
		 
		Base.proxy.registerItemRenderer(records, 0,"inventory");
		
			
	 }
	 
	
	 
	 
	 } 
 
}
