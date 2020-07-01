package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.items.FlourideItem;
import com.Ultra_Nerd.CodeLyokoRemake15.items.ItemBase;
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
	     
		 public static final RegistryObject<BowItem> LASER_ARROWSHOOTER = ITEMS.register("laser_arrowshooter", () -> new LaserArrowShooter(new Item.Properties().group(Base.LYOKO_ITEMS).maxDamage(40).setNoRepair()));
	//for tools
	public static final RegistryObject<Item> DIGITAL_SAMPLER = ITEMS.register("digital_sampler", () -> new ShovelItem(LyokoTiers.LyokoTool, 2, 2, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<Item> DIGITAL_SABER = ITEMS.register("digital_saber", () -> new SwordItem(LyokoTiers.LyokoSamurai,25,10 , new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<Item> QUANTUM_SABER = ITEMS.register("quantum_saber", () -> new ShovelItem(LyokoTiers.LyokoTool, 2, 2, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<Item> ZWEIHANDER = ITEMS.register("zweihander", () -> new ZweihanderWeapon(LyokoTiers.LyokoWarrior,60,-3.7f, new Item.Properties().group(Base.LYOKO_ITEMS)));
	//for armor
	public static final RegistryObject<ArmorItem> AELITA_CHESTPLATE = ITEMS.register("aelita_chestplate", () -> new ArmorItem(LyokoArmorMaterial.GUARDIAN, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<ArmorItem> AELITA_LEGGINGS = ITEMS.register("aelita_leggings", () -> new ArmorItem(LyokoArmorMaterial.GUARDIAN, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<ArmorItem> AELITA_BOOTS = ITEMS.register("aelita_boots", () -> new ArmorItem(LyokoArmorMaterial.GUARDIAN, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<ArmorItem> ODD_CHESTPLATE = ITEMS.register("odd_chestplate", () -> new ArmorItem(LyokoArmorMaterial.FELNINE, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<ArmorItem> ODD_LEGGINGS = ITEMS.register("odd_leggings", () -> new ArmorItem(LyokoArmorMaterial.FELNINE, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<ArmorItem> ODD_BOOTS = ITEMS.register("odd_boots", () -> new ArmorItem(LyokoArmorMaterial.FELNINE, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<ArmorItem> ULRICH_CHESTPLATE = ITEMS.register("ulrich_chestplate", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<ArmorItem> ULRICH_LEGGINGS = ITEMS.register("ulrich_leggings", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<ArmorItem> ULRICH_BOOTS = ITEMS.register("ulrich_boots", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ITEMS)));

	public static final RegistryObject<ArmorItem> BLANKHELMET = ITEMS.register("blank_helmet",() -> new ArmorItem(LyokoArmorMaterial.BLANKHELM,EquipmentSlotType.HEAD,new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<ArmorItem> WILLIAM_CHESTPLATE = ITEMS.register("william_chestplate", () -> new ArmorItem(LyokoArmorMaterial.WARRIOR, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<ArmorItem> WILLIAM_LEGGINGS = ITEMS.register("william_leggings", () -> new ArmorItem(LyokoArmorMaterial.WARRIOR, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<ArmorItem> WILLIAM_BOOTS = ITEMS.register("william_boots", () -> new ArmorItem(LyokoArmorMaterial.WARRIOR, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<ArmorItem> YUMI_CHESTPLATE = ITEMS.register("yumi_chestplate", () -> new ArmorItem(LyokoArmorMaterial.NINJA, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<ArmorItem> YUMI_LEGGINGS = ITEMS.register("yumi_leggings", () -> new ArmorItem(LyokoArmorMaterial.NINJA, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ITEMS)));
	public static final RegistryObject<ArmorItem> YUMI_BOOTS = ITEMS.register("yumi_boots", () -> new ArmorItem(LyokoArmorMaterial.NINJA, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ITEMS)));

	//the old item code from 1.12
	/*
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


 //tools
 public static final ItemSword ZWEIHANDER = new Zweihander("zweihander", MATERIAL_WARRIOR);
 public static final ItemSword QUANTUM_SABER = new QuantSword("quantum_saber", MATERIAL_QUANTUM);
 public static final ItemSpade DIGITAL_SAMPLER = new QuantSpade("digital_sampler", MATERIAL_QUANTUM);
 public static final ItemBow LASER_ARROWSHOOTER = new LaserArrowShooter("laser_arrowshooter");
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
	 
	
	 
	 
	 } */
 
}
