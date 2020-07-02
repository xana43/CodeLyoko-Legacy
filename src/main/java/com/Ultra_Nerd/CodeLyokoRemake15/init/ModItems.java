package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.items.FlourideItem;
import com.Ultra_Nerd.CodeLyokoRemake15.items.ItemBase;
import com.Ultra_Nerd.CodeLyokoRemake15.items.armor.ArmorFeline;
import com.Ultra_Nerd.CodeLyokoRemake15.items.tools.LaserArrowShooter;
import com.Ultra_Nerd.CodeLyokoRemake15.items.tools.ZweihanderWeapon;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems 
{
	
	
	
	
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Base.MOD_ID);

		//for items
		 public static final RegistryObject<Item> SOLID_QUANTUM = ITEMS.register("solid_quantum", ItemBase::new);

		 public static final RegistryObject<Item>  SILICON_WAFER = ITEMS.register("silicon_wafer", ItemBase::new);

		 public static final RegistryObject<Item>  URANIUM_SILACATE = ITEMS.register("uranium_silicate", ItemBase::new);

		 public static final RegistryObject<Item>  URANIUM_DIOXIDE = ITEMS.register("uranium_dioxide", ItemBase::new);

		 public static final RegistryObject<Item>  URANIUM_MELT = ITEMS.register("uranium_melt", ItemBase::new);

		 public static final RegistryObject<Item>  URANIUM_ISOTOPE238 = ITEMS.register("uranium_isotope238", ItemBase::new);

		 public static final RegistryObject<Item>  URANIUM_ISOTOPE235 = ITEMS.register("uranium_isotope235", ItemBase::new);

		 public static final RegistryObject<Item>  RAW_SILICADUST = ITEMS.register("raw_silicadust", ItemBase::new);

		 public static final RegistryObject<Item>  TRIURANIUM_OCTAOXIDE = ITEMS.register("triuranium_octaoxide", ItemBase::new);

		 public static final RegistryObject<Item>  FLOURIDE = ITEMS.register("flouride", () -> new FlourideItem(new Item.Properties().group(Base.LYOKO_ITEMS)));

		 public static final RegistryObject<Item>  BIT = ITEMS.register("bit", ItemBase::new);

		 public static final RegistryObject<Item>  BYTE = ITEMS.register("byte", ItemBase::new);

		 public static final RegistryObject<Item>  MEGABIT = ITEMS.register("megabit", ItemBase::new);

		 public static final RegistryObject<Item>  MEGABYTE = ITEMS.register("megabyte", ItemBase::new);

		 public static final RegistryObject<Item>  GIGABIT = ITEMS.register("gigabit", ItemBase::new);

		 public static final RegistryObject<Item>  GIGABYTE = ITEMS.register("gigabyte", ItemBase::new);

		 public static final RegistryObject<Item>  TERABIT = ITEMS.register("terabit", ItemBase::new);

		 public static final RegistryObject<Item>  TERABYTE = ITEMS.register("terabyte", ItemBase::new);

		 public static final RegistryObject<Item>  PETABIT = ITEMS.register("petabit", ItemBase::new);

		 public static final RegistryObject<Item>  PETABYTE = ITEMS.register("petabyte", ItemBase::new);

		 public static final RegistryObject<Item>  QUBIT = ITEMS.register("qubit", ItemBase::new);

		 public static final RegistryObject<Item>  QUBYTE = ITEMS.register("qubyte", ItemBase::new);

		 public static final RegistryObject<Item>  TITANIUMI = ITEMS.register("titanium_ingot", ItemBase::new);
	     
		 public static final RegistryObject<BowItem> LASER_ARROWSHOOTER = ITEMS.register("laser_arrowshooter", () -> new LaserArrowShooter(new Item.Properties().group(Base.LYOKO_WEAPONS).maxDamage(40).setNoRepair()));
	//for tools
	public static final RegistryObject<Item> DIGITAL_SAMPLER = ITEMS.register("digital_sampler", () -> new ShovelItem(LyokoTiers.LyokoTool, 2, 2, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<Item> DIGITAL_SABER = ITEMS.register("digital_saber", () -> new SwordItem(LyokoTiers.LyokoSamurai,25,10 , new Item.Properties().group(Base.LYOKO_WEAPONS)));
	public static final RegistryObject<Item> QUANTUM_SABER = ITEMS.register("quantum_saber", () -> new ShovelItem(LyokoTiers.LyokoTool, 2, 2, new Item.Properties().group(Base.LYOKO_WEAPONS)));
	public static final RegistryObject<Item> ZWEIHANDER = ITEMS.register("zweihander", () -> new ZweihanderWeapon(LyokoTiers.LyokoWarrior, (byte) 60, (byte)-3, new Item.Properties().group(Base.LYOKO_WEAPONS)));
	//for armor
	public static final RegistryObject<ArmorItem> AELITA_CHESTPLATE = ITEMS.register("aelita_chestplate", () -> new ArmorItem(LyokoArmorMaterial.GUARDIAN, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> AELITA_LEGGINGS = ITEMS.register("aelita_leggings", () -> new ArmorItem(LyokoArmorMaterial.GUARDIAN, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> AELITA_BOOTS = ITEMS.register("aelita_boots", () -> new ArmorItem(LyokoArmorMaterial.GUARDIAN, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> ODD_CHESTPLATE = ITEMS.register("odd_chestplate", () -> new ArmorFeline(LyokoArmorMaterial.FELNINE, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ARMOR).maxDamage(60)));
	public static final RegistryObject<ArmorItem> ODD_LEGGINGS = ITEMS.register("odd_leggings", () -> new ArmorFeline(LyokoArmorMaterial.FELNINE, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ARMOR).maxDamage(60)));
	public static final RegistryObject<ArmorItem> ODD_BOOTS = ITEMS.register("odd_boots", () -> new ArmorFeline(LyokoArmorMaterial.FELNINE, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ARMOR).maxDamage(60)));
	public static final RegistryObject<ArmorItem> ULRICH_HEADBAND = ITEMS.register("ulrich_headband", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlotType.HEAD, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> ULRICH_CHESTPLATE = ITEMS.register("ulrich_chestplate", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> ULRICH_LEGGINGS = ITEMS.register("ulrich_leggings", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> ULRICH_BOOTS = ITEMS.register("ulrich_boots", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> BLANKHELMET = ITEMS.register("blank_helmet",() -> new ArmorItem(LyokoArmorMaterial.BLANKHELM,EquipmentSlotType.HEAD,new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> WILLIAM_CHESTPLATE = ITEMS.register("william_chestplate", () -> new ArmorItem(LyokoArmorMaterial.WARRIOR, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> WILLIAM_LEGGINGS = ITEMS.register("william_leggings", () -> new ArmorItem(LyokoArmorMaterial.WARRIOR, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> WILLIAM_BOOTS = ITEMS.register("william_boots", () -> new ArmorItem(LyokoArmorMaterial.WARRIOR, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> YUMI_CHESTPLATE = ITEMS.register("yumi_chestplate", () -> new ArmorItem(LyokoArmorMaterial.NINJA, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> YUMI_LEGGINGS = ITEMS.register("yumi_leggings", () -> new ArmorItem(LyokoArmorMaterial.NINJA, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> YUMI_BOOTS = ITEMS.register("yumi_boots", () -> new ArmorItem(LyokoArmorMaterial.NINJA, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ARMOR)));


 
}
