package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.items.*;
import com.Ultra_Nerd.CodeLyokoRemake15.items.armor.*;
import com.Ultra_Nerd.CodeLyokoRemake15.items.tools.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {


    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Base.MOD_ID);

    //for items
    public static final RegistryObject<Item> APU_PACKAGE_ARM = ITEMS.register("apu_package_arm", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> APU_PACKAGE_x86 = ITEMS.register("apu_package_x86", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> APU_PACKAGE_ASIC = ITEMS.register("apu_package_asic", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> APU_PACKAGE_RISC = ITEMS.register("apu_package_risc", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> APU_DIE_ARM = ITEMS.register("apu_die_arm", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> APU_DIE_x86 = ITEMS.register("apu_die_x86", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> APU_DIE_ASIC = ITEMS.register("apu_die_asic", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> APU_DIE_RISC = ITEMS.register("apu_die_risc", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final RegistryObject<BlokItem> BLOK_SPAWN_EGG = ITEMS.register("blok_spawn_egg", () -> new BlokItem(ModEntities.BLOK, 1, 1, new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> CHALCOPYRITE_ITEM = ITEMS.register("chalcopyrite_item", () -> new Item(new Item.Properties().group(Base.LYOKO_ITEMS).maxDamage(5)));
    public static final RegistryObject<Item> BORNITE_ITEM = ITEMS.register("bornite_item",() -> new Item(new Item.Properties().group(Base.LYOKO_ITEMS).maxDamage(4)));
    public static final RegistryObject<Item> CHALCOCITE_ITEM = ITEMS.register("chalcocite_item",() -> new Item(new Item.Properties().group(Base.LYOKO_ITEMS).maxDamage(7)));
    public static final RegistryObject<Item> COVELLITE_ITEM = ITEMS.register("covellite_item",() -> new Item(new Item.Properties().group(Base.LYOKO_ITEMS).maxDamage(6)));
    public static final RegistryObject<Item> CUPROUS_OXIDE = ITEMS.register("cuprous_oxide", () -> new Item(new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> BLISTER_COPPER = ITEMS.register("blister_copper", () -> new BlisterCopper(new Item.Properties().group(Base.LYOKO_ITEMS).maxDamage(60)));
    public static final RegistryObject<Item> CPU_PACKAGE_ARM = ITEMS.register("cpu_package_arm", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> CPU_PACKAGE_x86 = ITEMS.register("cpu_package_x86", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> CPU_PACKAGE_RISC = ITEMS.register("cpu_package_risc", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> CPU_PACKAGE_ASIC = ITEMS.register("cpu_package_asic", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> CPU_PACKAGE_QUANTUM = ITEMS.register("cpu_package_quantum", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("LEGENDARY", TextFormatting.DARK_AQUA))));
    public static final RegistryObject<Item> CPU_DIE_ARM = ITEMS.register("cpu_die_arm", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> CPU_DIE_x86 = ITEMS.register("cpu_die_x86", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> CPU_DIE_RISC = ITEMS.register("cpu_die_risc", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> CPU_DIE_ASIC = ITEMS.register("cpu_die_asic", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> CPU_DIE_QUANTUM = ITEMS.register("cpu_die_quantum", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("LEGENDARY", TextFormatting.DARK_AQUA))));
    public static final RegistryObject<Item> COMPUTER_ARM_CORE = ITEMS.register("computer_arm_core", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> COMPUTER_X86_CORE = ITEMS.register("computer_x86_core", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> COMPUTER_RISC_CORE = ITEMS.register("computer_risc_core", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> COMPUTER_ASIC_CORE = ITEMS.register("computer_asic_core", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> COMPUTER_QUANTUM_CORE = ITEMS.register("computer_quantum_core", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("LEGENDARY", TextFormatting.DARK_AQUA))));
    public static final RegistryObject<Item> COMPUTER_RISC_GPU_CORE = ITEMS.register("computer_risc_gpu_core", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COMPUTER_ASIC_GPU_CORE = ITEMS.register("computer_asic_gpu_core", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> COMPUTER_NEURAL_GPU_CORE = ITEMS.register("computer_neural_gpu_core", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("LEGENDARY", TextFormatting.DARK_AQUA))));
    public static final RegistryObject<Item> COMPUTER_QUANTUM_NUMA_GPU_CORE = ITEMS.register("computer_quantum_numa_gpu_core", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("QUANTUM", TextFormatting.DARK_GRAY))));
    public static final RegistryObject<Item> COMPUTER_DRAM_DIE = ITEMS.register("computer_dram_die", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> COMPUTER_SRAM_DIE = ITEMS.register("computer_sram_die", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> COMPUTER_QRAM_DIE = ITEMS.register("computer_qram_die", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> COMPUTER_SRAM_CONTROLLER = ITEMS.register("computer_sram_controller", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> COMPUTER_SDR_CONTROLLER = ITEMS.register("computer_sdr_controller", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> COMPUTER_DDR_CONTROLLER = ITEMS.register("computer_ddr_controller", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> COMPUTER_ECC_CONTROLLER = ITEMS.register("computer_ecc_controller", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> COMPUTER_DRAM_SDR_RAM = ITEMS.register("computer_dram_sdr_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("common_part", TextFormatting.GRAY))));
    public static final RegistryObject<Item> COMPUTER_DRAM_DDR_RAM = ITEMS.register("computer_dram_ddr_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("common_part", TextFormatting.GRAY))));
    public static final RegistryObject<Item> COMPUTER_DRAM2_DDR_RAM = ITEMS.register("computer_dram_ddr2_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("common_part", TextFormatting.GRAY))));
    public static final RegistryObject<Item> COMPUTER_DRAM3_DDR_RAM = ITEMS.register("computer_dram_ddr3_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> COMPUTER_DRAM4_DDR_RAM = ITEMS.register("computer_dram_ddr4_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COMPUTER_DRAM5_DDR_RAM = ITEMS.register("computer_dram_ddr5_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> COMPUTER_SRAM_DDR_RAM = ITEMS.register("computer_sram_ddr_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> COMPUTER_SRAM_DDR2_RAM = ITEMS.register("computer_sram_ddr2_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("prosumer", TextFormatting.DARK_BLUE))));
    public static final RegistryObject<Item> COMPUTER_SRAM_DDR3_RAM = ITEMS.register("computer_sram_ddr3_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("matureprosumer", TextFormatting.DARK_AQUA))));
    public static final RegistryObject<Item> COMPUTER_SRAM_DDR4_RAM = ITEMS.register("computer_sram_ddr4_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("professional", TextFormatting.DARK_GREEN))));
    public static final RegistryObject<Item> COMPUTER_SRAM_DDR5_RAM = ITEMS.register("computer_sram_ddr5_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("professional_enthusiast", TextFormatting.DARK_RED))));
    public static final RegistryObject<Item> COMPUTER_SRAM_ECC_DDR_RAM = ITEMS.register("computer_sram_ecc_ddr_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("server_entrylevel", TextFormatting.BLUE))));
    public static final RegistryObject<Item> COMPUTER_SRAM_ECC_DDR2_RAM = ITEMS.register("computer_sram_ecc_ddr2_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("server_prosumer", TextFormatting.AQUA))));
    public static final RegistryObject<Item> COMPUTER_SRAM_ECC_DDR3_RAM = ITEMS.register("computer_sram_ecc_ddr3_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("server_matureprosumer", TextFormatting.GREEN))));
    public static final RegistryObject<Item> COMPUTER_SRAM_ECC_DDR4_RAM = ITEMS.register("computer_sram_ecc_ddr4_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("server_professional", TextFormatting.RED))));
    public static final RegistryObject<Item> COMPUTER_SRAM_ECC_DDR5_RAM = ITEMS.register("computer_sram_ecc_ddr5_ram", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("server_professional_enthusiast", TextFormatting.GRAY))));
    public static final RegistryObject<Item> COMPUTER_QRAM_LOW_DENSITY = ITEMS.register("computer_qram_low_density", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("franz_starter", TextFormatting.DARK_GRAY))));
    public static final RegistryObject<Item> COMPUTER_QRAM_MEDIUM_DENSITY = ITEMS.register("computer_qram_medium_density", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("franz_novice", TextFormatting.GOLD))));
    public static final RegistryObject<Item> COMPUTER_QRAM_HIGH_DENSITY = ITEMS.register("computer_qram_high_density", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("franz_hopper", TextFormatting.DARK_PURPLE))));
    public static final RegistryObject<Item> COMPUTER_HEATSINK = ITEMS.register("computer_heatsink", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COMPUTER_FULLTOWER_FAN_HEATSINK = ITEMS.register("computer_fulltower_fan_heatsink", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> COMPUTER_FLUID_HEAT_TRANSFER_PLATE = ITEMS.register("computer_fluid_heat_transfer_plate", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("franz_hopper", TextFormatting.DARK_PURPLE))));
    public static final RegistryObject<Item> COLORED_POLYCARBONATE_BODY_PART = ITEMS.register("colored_polycarbonate_body_part", ItemBase::new);
    public static final RegistryObject<Item> BIT = ITEMS.register("bit", ItemBase::new);
    public static final RegistryObject<Item> BYTE = ITEMS.register("byte", ItemBase::new);
    public static final RegistryObject<Item> FLOURIDE = ITEMS.register("flouride", () -> new FlourideItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> GIGABIT = ITEMS.register("gigabit", ItemBase::new);
    public static final RegistryObject<Item> GIGABYTE = ITEMS.register("gigabyte", ItemBase::new);
    public static final RegistryObject<Item> GPU_COMPUTE_PROCESSOR_CORE = ITEMS.register("gpu_compute_processor_core", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> GPU_COMPUTE_PROCESSOR = ITEMS.register("gpu_compute_processor", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> GPU_PACKAGE_RISC = ITEMS.register("gpu_package_risc", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> GPU_PACKAGE_ASIC = ITEMS.register("gpu_package_asic", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GPU_PACKAGE_QUANTUM = ITEMS.register("gpu_package_quantum", () -> new ComputerItem(new Item.Properties().group(Base.LYOKO_ITEMS).rarity(Rarity.create("LEGENDARY", TextFormatting.DARK_AQUA))));
    public static final RegistryObject<Item> INTEGRATED_HEAT_SPREADER = ITEMS.register("integrated_heat_spreader", ItemBase::new);
    public static final RegistryObject<Item> KEY_CAP = ITEMS.register("key_cap", ItemBase::new);
    public static final RegistryObject<Item> KEY_SPRING = ITEMS.register("key_spring", ItemBase::new);
    public static final RegistryObject<Item> MEGABIT = ITEMS.register("megabit", ItemBase::new);
    public static final RegistryObject<Item> MEGABYTE = ITEMS.register("megabyte", ItemBase::new);
    public static final RegistryObject<Item> MOLTEN_POLYCARBONATE_CONCENTRATE = ITEMS.register("molten_polycarbonate_concentrate", ItemBase::new);
    public static final RegistryObject<Item> PETABIT = ITEMS.register("petabit", ItemBase::new);
    public static final RegistryObject<Item> PETABYTE = ITEMS.register("petabyte", ItemBase::new);
    public static final RegistryObject<Item> POLYCARBONATE_CRYSTALLINE_DYE = ITEMS.register("polycarbonate_crystalline_dye", ItemBase::new);
    public static final RegistryObject<Item> QUBIT = ITEMS.register("qubit", ItemBase::new);
    public static final RegistryObject<Item> QUBYTE = ITEMS.register("qubyte", ItemBase::new);
    public static final RegistryObject<Item> RAW_SILICADUST = ITEMS.register("raw_silicadust", ItemBase::new);
    public static final RegistryObject<Item> RAW_POLYCARBONATE = ITEMS.register("raw_polycarbonate", ItemBase::new);
    public static final RegistryObject<Item> SOLID_QUANTUM = ITEMS.register("solid_quantum", ItemBase::new);
    public static final RegistryObject<Item> SOLDER_BLOB = ITEMS.register("solder_blob", ItemBase::new);
    public static final RegistryObject<WrittenBookItem> STORY_BOOK = ITEMS.register("story_book", () -> new StoryBook(new Item.Properties().group(Base.LYOKO_ITEMS).maxStackSize(1)));
    public static final RegistryObject<Item> SILICON_WAFER = ITEMS.register("silicon_wafer", () -> new WaferText(new Item.Properties().group(Base.LYOKO_ITEMS).maxDamage(4)));
    public static final RegistryObject<Item> URANIUM_SILICATE = ITEMS.register("uranium_silicate", ItemBase::new);
    public static final RegistryObject<Item> URANIUM_SILICON_PLATE = ITEMS.register("uranium_silicon_plate",ItemBase::new);
    public static final RegistryObject<Item> TRIURANIUM_OCTAOXIDE = ITEMS.register("triuranium_octaoxide", ItemBase::new);
    public static final RegistryObject<Item> TERABIT = ITEMS.register("terabit", ItemBase::new);
    public static final RegistryObject<Item> TERABYTE = ITEMS.register("terabyte", ItemBase::new);
    public static final RegistryObject<Item> TITANIUMINGOT = ITEMS.register("titanium_ingot", ItemBase::new);
    public static final RegistryObject<Item> URANIUM_DIOXIDE = ITEMS.register("uranium_dioxide", ItemBase::new);
    public static final RegistryObject<Item> URANIUM_MELT = ITEMS.register("uranium_melt", ItemBase::new);
    public static final RegistryObject<Item> URANIUM_ISOTOPE238 = ITEMS.register("uranium_isotope238", ItemBase::new);
    public static final RegistryObject<Item> URANIUM_ISOTOPE235 = ITEMS.register("uranium_isotope235", ItemBase::new);


    //for tools
    public static final RegistryObject<Item> DIGITAL_SAMPLER = ITEMS.register("digital_sampler", () -> new ShovelItem(LyokoTiers.LyokoTool, 2, 2, new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> TRUSTTY_SCREWDRIVER = ITEMS.register("trusty_screwdriver", () -> new TrustyScrewDriverItem(new Item.Properties().group(Base.LYOKO_ITEMS)));
    public static final RegistryObject<Item> SOLDERING_IRON = ITEMS.register("soldering_iron", () -> new soldering_iron(new Item.Properties().group(Base.LYOKO_ITEMS).maxDamage(100)));
    //for weapons
    public static final RegistryObject<SwordItem> DIGITAL_SABER = ITEMS.register("digital_saber", () -> new SaberKatana(LyokoTiers.LyokoSamurai, 25, -0.9f, new Item.Properties().group(Base.LYOKO_WEAPONS)));
    public static final RegistryObject<BowItem> LASER_ARROWSHOOTER = ITEMS.register("laser_arrowshooter", () -> new LaserArrowShooter(new Item.Properties().group(Base.LYOKO_WEAPONS).maxDamage(40).setNoRepair()));
    public static final RegistryObject<SwordItem> QUANTUM_SABER = ITEMS.register("quantum_saber", () -> new SwordItem(LyokoTiers.LyokoTool, 15, 2, new Item.Properties().group(Base.LYOKO_WEAPONS).maxDamage(50).rarity(Rarity.EPIC)));
    public static final RegistryObject<TridentItem> YUMI_TRADITONAL_FANS = ITEMS.register("yumi_traditional_fans", () -> new YumiFans(new Item.Properties().group(Base.LYOKO_WEAPONS).maxDamage(20).setNoRepair()));
    public static final RegistryObject<SwordItem> ZWEIHANDER = ITEMS.register("zweihander", () -> new ZweihanderWeapon(LyokoTiers.LyokoWarrior, 60, -3.9f, new Item.Properties().group(Base.LYOKO_WEAPONS)));
    public static final RegistryObject<BowItem> FORCE_FIELD_EMITTER = ITEMS.register("force_field_emitter", () -> new ForceFieldEmitter(new Item.Properties().group(Base.LYOKO_WEAPONS).rarity(Rarity.EPIC)));
    public static final RegistryObject<BowItem> ARCHER_BOW = ITEMS.register("archer_bow", () -> new ArcherClassBow(new Item.Properties().group(Base.LYOKO_WEAPONS).maxDamage(40)));
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
    public static final RegistryObject<ArmorItem> BLANKHELMET = ITEMS.register("blank_helmet", () -> new ArmorItem(LyokoArmorMaterial.BLANKHELM, EquipmentSlotType.HEAD, new Item.Properties().group(Base.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> WILLIAM_CHESTPLATE = ITEMS.register("william_chestplate", () -> new ArmorWarrior(LyokoArmorMaterial.WARRIOR, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> WILLIAM_LEGGINGS = ITEMS.register("william_leggings", () -> new ArmorWarrior(LyokoArmorMaterial.WARRIOR, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> WILLIAM_BOOTS = ITEMS.register("william_boots", () -> new ArmorWarrior(LyokoArmorMaterial.WARRIOR, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> YUMI_CHESTPLATE = ITEMS.register("yumi_chestplate", () -> new ArmorNinja(LyokoArmorMaterial.NINJA, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> YUMI_LEGGINGS = ITEMS.register("yumi_leggings", () -> new ArmorNinja(LyokoArmorMaterial.NINJA, EquipmentSlotType.LEGS, new Item.Properties().group(Base.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> YUMI_BOOTS = ITEMS.register("yumi_boots", () -> new ArmorNinja(LyokoArmorMaterial.NINJA, EquipmentSlotType.FEET, new Item.Properties().group(Base.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> MIND_HELMET = ITEMS.register("mind_helmet", () -> new MindHelm(LyokoArmorMaterial.BLANKHELM, EquipmentSlotType.HEAD, new Item.Properties().group(Base.LYOKO_ARMOR).rarity(Rarity.EPIC)));
    public static final RegistryObject<ArmorItem> LINKER = ITEMS.register("linker", () -> new linker(LyokoArmorMaterial.LINKER, EquipmentSlotType.CHEST, new Item.Properties().group(Base.LYOKO_ARMOR).rarity(Rarity.EPIC)));
    public static final RegistryObject<ArmorItem> JEREMY_CHESTPLATE = ITEMS.register("jeremy_chestplate",() -> new ArmorArcher(LyokoArmorMaterial.ARCHER,EquipmentSlotType.CHEST,new Item.Properties().group(Base.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> JEREMY_LEGGINGS = ITEMS.register("jeremy_leggings",() -> new ArmorArcher(LyokoArmorMaterial.ARCHER,EquipmentSlotType.LEGS,new Item.Properties().group(Base.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> JEREMY_BOOTS = ITEMS.register("jeremy_boots", () -> new ArmorArcher(LyokoArmorMaterial.ARCHER,EquipmentSlotType.FEET,new Item.Properties().group(Base.LYOKO_ARMOR)));

}
