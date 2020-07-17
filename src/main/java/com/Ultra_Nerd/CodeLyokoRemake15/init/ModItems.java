package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.items.ComputerItem;
import com.Ultra_Nerd.CodeLyokoRemake15.items.FlourideItem;
import com.Ultra_Nerd.CodeLyokoRemake15.items.ItemBase;
import com.Ultra_Nerd.CodeLyokoRemake15.items.TrustyScrewDriverItem;
import com.Ultra_Nerd.CodeLyokoRemake15.items.armor.AelitaArmorElytra;
import com.Ultra_Nerd.CodeLyokoRemake15.items.armor.ArmorFeline;
import com.Ultra_Nerd.CodeLyokoRemake15.items.armor.ArmorWarrior;
import com.Ultra_Nerd.CodeLyokoRemake15.items.tools.LaserArrowShooter;
import com.Ultra_Nerd.CodeLyokoRemake15.items.tools.YumiFans;
import com.Ultra_Nerd.CodeLyokoRemake15.items.tools.ZweihanderWeapon;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems 
{
	
	
	
	
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Base.MOD_ID);

		//for items
		 public static final RegistryObject<Item>  COMPUTER_ARM_CORE = ITEMS.register("computer_arm_core", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.COMMON)));
		 public static final RegistryObject<Item>  COMPUTER_X86_CORE = ITEMS.register("computer_x86_core",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.COMMON)));
		 public static final RegistryObject<Item>  COMPUTER_CISC_CORE = ITEMS.register("computer_cisc_core",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
		 public static final RegistryObject<Item>  COMPUTER_RISC_CORE = ITEMS.register("computer_risc_core",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.RARE)));
		 public static final RegistryObject<Item>  COMPUTER_ASIC_CORE = ITEMS.register("computer_asic_core",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.EPIC)));
	     public static final RegistryObject<Item>  COMPUTER_QUANTUM_CORE = ITEMS.register("computer_quantum_core",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("LEGENDARY", TextFormatting.DARK_AQUA))));
		 public static final RegistryObject<Item>  COMPUTER_ARMAPU_CORE = ITEMS.register("computer_armapu_core",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.COMMON)));
	     public static final RegistryObject<Item>  COMPUTER_X86APU_CORE = ITEMS.register("computer_x86apu_core",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.COMMON)));
	     public static final RegistryObject<Item>  COMPUTER_CISCAPU_CORE = ITEMS.register("computer_ciscapu_core",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
	     public static final RegistryObject<Item>  COMPUTER_RISCAPU_CORE = ITEMS.register("computer_riscapu_core",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.RARE)));
	     public static final RegistryObject<Item>  COMPUTER_ASICAPU_CORE = ITEMS.register("computer_asicapu_core",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.EPIC)));
	     public static final RegistryObject<Item>  COMPUTER_RISCGPU_CORE = ITEMS.register("computer_riscgpu_core",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
	     public static final RegistryObject<Item>  COMPUTER_ASICGPU_CORE = ITEMS.register("computer_asicgpu_core",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.RARE)));
	     public static final RegistryObject<Item>  COMPUTER_NEURALGPU_CORE = ITEMS.register("computer_neuralgpu_core",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("LEGENDARY", TextFormatting.DARK_AQUA))));
	     public static final RegistryObject<Item>  COMPUTER_QUANTUMNUMAGPU_CORE = ITEMS.register("computer_quantumnumagpu_core",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("QUANTUM", TextFormatting.OBFUSCATED))));
		 public static final RegistryObject<Item>  COMPUTER_DRAM_SDR_RAM = ITEMS.register("computer_dram_sdr_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
		 public static final RegistryObject<Item>  COMPUTER_DRAM_DDR_RAM = ITEMS.register("computer_dram_ddr_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_DRAM2_DDR_RAM = ITEMS.register("computer_dram_ddr2_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_DRAM3_DDR_RAM = ITEMS.register("computer_dram_ddr3_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_DRAM4_DDR_RAM = ITEMS.register("computer_dram_ddr4_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_DRAM5_DDR_RAM = ITEMS.register("computer_dram_ddr5_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_SRAM_DDR_RAM = ITEMS.register("computer_sram_ddr_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_SRAM_DDR2_RAM = ITEMS.register("computer_sram_ddr2_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_SRAM_DDR3_RAM = ITEMS.register("computer_sram_ddr3_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_SRAM_DDR4_RAM = ITEMS.register("computer_sram_ddr4_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_SRAM_DDR5_RAM = ITEMS.register("computer_sram_ddr5_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_SRAM_ECC_DDR_RAM = ITEMS.register("computer_sram_ecc_ddr_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_SRAM_ECC_DDR2_RAM = ITEMS.register("computer_sram_ecc_ddr2_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_SRAM_ECC_DDR3_RAM = ITEMS.register("computer_sram_ecc_ddr3_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_SRAM_ECC_DDR4_RAM = ITEMS.register("computer_sram_ecc_ddr4_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_SRAM_ECC_DDR5_RAM = ITEMS.register("computer_sram_ecc_ddr5_ram",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_QRAM_LOWDENSITY = ITEMS.register("computer_qram_lowdensity",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_QRAM_MEDIUMDENSITY = ITEMS.register("computer_qram_mediumdensity",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  COMPUTER_QRAM_HIGHDENSITY = ITEMS.register("computer_qram_highdensity",() -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  BIT = ITEMS.register("bit", ItemBase::new);
	     public static final RegistryObject<Item>  BYTE = ITEMS.register("byte", ItemBase::new);
	     public static final RegistryObject<Item>  FLOURIDE = ITEMS.register("flouride", () -> new FlourideItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  GIGABIT = ITEMS.register("gigabit", ItemBase::new);
	     public static final RegistryObject<Item>  GIGABYTE = ITEMS.register("gigabyte", ItemBase::new);
	     public static final RegistryObject<Item>  MEGABIT = ITEMS.register("megabit", ItemBase::new);
	     public static final RegistryObject<Item>  MEGABYTE = ITEMS.register("megabyte", ItemBase::new);
	     public static final RegistryObject<Item>  PETABIT = ITEMS.register("petabit", ItemBase::new);
		 public static final RegistryObject<Item>  PETABYTE = ITEMS.register("petabyte", ItemBase::new);
	     public static final RegistryObject<Item>  QUBIT = ITEMS.register("qubit", ItemBase::new);
	     public static final RegistryObject<Item>  QUBYTE = ITEMS.register("qubyte", ItemBase::new);
	     public static final RegistryObject<Item>  RAW_SILICADUST = ITEMS.register("raw_silicadust", ItemBase::new);
	     public static final RegistryObject<Item>  SOLID_QUANTUM = ITEMS.register("solid_quantum", ItemBase::new);
		 public static final RegistryObject<Item>  SILICON_WAFER = ITEMS.register("silicon_wafer", ItemBase::new);
		 public static final RegistryObject<Item>  URANIUM_SILICATE = ITEMS.register("uranium_silicate", ItemBase::new);
		 public static final RegistryObject<Item>  TRIURANIUM_OCTAOXIDE = ITEMS.register("triuranium_octaoxide", ItemBase::new);
	     public static final RegistryObject<Item>  TERABIT = ITEMS.register("terabit", ItemBase::new);
	     public static final RegistryObject<Item>  TERABYTE = ITEMS.register("terabyte", ItemBase::new);
	     public static final RegistryObject<Item>  TITANIUMINGOT = ITEMS.register("titanium_ingot", ItemBase::new);
	     public static final RegistryObject<Item>  TRUSTTY_SCREWDRIVER = ITEMS.register("trusty_screwdriver",()->new TrustyScrewDriverItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
	     public static final RegistryObject<Item>  URANIUM_DIOXIDE = ITEMS.register("uranium_dioxide", ItemBase::new);
		 public static final RegistryObject<Item>  URANIUM_MELT = ITEMS.register("uranium_melt", ItemBase::new);
		 public static final RegistryObject<Item>  URANIUM_ISOTOPE238 = ITEMS.register("uranium_isotope238", ItemBase::new);
		 public static final RegistryObject<Item>  URANIUM_ISOTOPE235 = ITEMS.register("uranium_isotope235", ItemBase::new);
	//for tools
	public static final RegistryObject<Item> DIGITAL_SAMPLER = ITEMS.register("digital_sampler", () -> new ShovelItem(LyokoTiers.LyokoTool, 2, 2, new Item.Properties().group(Base.LYOKO_ITEMS)));
	//for weapons

	public static final RegistryObject<SwordItem> DIGITAL_SABER = ITEMS.register("digital_saber", () -> new SwordItem(LyokoTiers.LyokoSamurai,25,-1 , new Item.Properties().group(Base.LYOKO_WEAPONS)));
	public static final RegistryObject<BowItem> LASER_ARROWSHOOTER = ITEMS.register("laser_arrowshooter", () -> new LaserArrowShooter(new Item.Properties().group(Base.LYOKO_WEAPONS).maxDamage(40).setNoRepair()));
	public static final RegistryObject<SwordItem> QUANTUM_SABER = ITEMS.register("quantum_saber", () -> new SwordItem(LyokoTiers.LyokoTool, 15, 2, new Item.Properties().group(Base.LYOKO_WEAPONS).maxDamage(50)));
	public static final RegistryObject<TridentItem> YUMI_TRADITONAL_FANS = ITEMS.register("yumi_traditional_fans", () -> new YumiFans(new Item.Properties().group(Base.LYOKO_WEAPONS).maxDamage(20).setNoRepair()));
	public static final RegistryObject<SwordItem> ZWEIHANDER = ITEMS.register("zweihander", () -> new ZweihanderWeapon(LyokoTiers.LyokoWarrior,60, -3.9f, new Item.Properties().group(Base.LYOKO_WEAPONS)));

	//for armor
	public static final RegistryObject<ArmorItem> AELITA_CHESTPLATE = ITEMS.register("aelita_chestplate", () -> new AelitaArmorElytra(LyokoArmorMaterial.GUARDIAN, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> AELITA_LEGGINGS = ITEMS.register("aelita_leggings", () -> new ArmorItem(LyokoArmorMaterial.GUARDIAN, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> AELITA_BOOTS = ITEMS.register("aelita_boots", () -> new ArmorItem(LyokoArmorMaterial.GUARDIAN, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> ODD_CHESTPLATE = ITEMS.register("odd_chestplate", () -> new ArmorFeline(LyokoArmorMaterial.FELNINE, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> ODD_LEGGINGS = ITEMS.register("odd_leggings", () -> new ArmorFeline(LyokoArmorMaterial.FELNINE, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> ODD_BOOTS = ITEMS.register("odd_boots", () -> new ArmorFeline(LyokoArmorMaterial.FELNINE, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> ULRICH_HEADBAND = ITEMS.register("ulrich_headband", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlotType.HEAD, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> ULRICH_CHESTPLATE = ITEMS.register("ulrich_chestplate", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> ULRICH_LEGGINGS = ITEMS.register("ulrich_leggings", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> ULRICH_BOOTS = ITEMS.register("ulrich_boots", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> BLANKHELMET = ITEMS.register("blank_helmet",() -> new ArmorItem(LyokoArmorMaterial.BLANKHELM,EquipmentSlotType.HEAD,new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> WILLIAM_CHESTPLATE = ITEMS.register("william_chestplate", () -> new ArmorWarrior(LyokoArmorMaterial.WARRIOR, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> WILLIAM_LEGGINGS = ITEMS.register("william_leggings", () -> new ArmorWarrior(LyokoArmorMaterial.WARRIOR, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> WILLIAM_BOOTS = ITEMS.register("william_boots", () -> new ArmorWarrior(LyokoArmorMaterial.WARRIOR, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> YUMI_CHESTPLATE = ITEMS.register("yumi_chestplate", () -> new ArmorItem(LyokoArmorMaterial.NINJA, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> YUMI_LEGGINGS = ITEMS.register("yumi_leggings", () -> new ArmorItem(LyokoArmorMaterial.NINJA, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ARMOR)));
	public static final RegistryObject<ArmorItem> YUMI_BOOTS = ITEMS.register("yumi_boots", () -> new ArmorItem(LyokoArmorMaterial.NINJA, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ARMOR)));


 
}
