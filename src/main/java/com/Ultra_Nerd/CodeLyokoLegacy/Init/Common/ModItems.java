package com.Ultra_Nerd.CodeLyokoLegacy.Init.Common;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Items.Armor.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Items.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Items.SpawnItems.LyokoSpawnItem;
import com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools.Buckets.CustomColorBucket;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.Enums.LyokoArmorMaterial;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.Enums.LyokoTiers;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.ColorHelper;

public record ModItems() {

    //for test items
    public static final Item TEST_MULTIPLAYER_PHONE;
    //for spawn eggs

    public static final Item HOVERBOARD_SPAWN_ITEM;
    public static final Item OVERBOARD_SPAWN_ITEM;

    public static final Item OVERBIKE_SPAWN_ITEM;
    //for items
    public static final Item APU_PACKAGE_ARM;

    public static final Item APU_PACKAGE_x86;
    public static final Item APU_PACKAGE_ASIC;
    public static final Item APU_PACKAGE_RISC;
    public static final Item APU_DIE_ARM;
    public static final Item APU_DIE_x86;
    public static final Item APU_DIE_ASIC;
    public static final Item BORNITE_ITEM;
    public static final Item BLISTER_COPPER;
    public static final Item CHALCOPYRITE_ITEM;
    public static final Item CHALCOCITE_ITEM;
    public static final Item COVELLITE_ITEM;
    public static final Item CUPROUS_OXIDE;
    public static final Item CPU_PACKAGE_ARM;
    public static final Item CPU_PACKAGE_x86;
    public static final Item CPU_PACKAGE_RISC;
    public static final Item CPU_PACKAGE_ASIC;
    public static final Item CPU_PACKAGE_QUANTUM;
    public static final Item CPU_DIE_ARM;
    public static final Item CPU_DIE_x86;
    public static final Item CPU_DIE_RISC;
    public static final Item CPU_DIE_ASIC;
    public static final Item CPU_DIE_QUANTUM;
    public static final Item COMPUTER_ARM_CORE;
    public static final Item COMPUTER_X86_CORE;
    public static final Item COMPUTER_RISC_CORE;
    public static final Item COMPUTER_ASIC_CORE;
    public static final Item COMPUTER_QUANTUM_CORE;
    public static final Item COMPUTER_RISC_GPU_CORE;
    public static final Item COMPUTER_ASIC_GPU_CORE;
    public static final Item COMPUTER_NEURAL_GPU_CORE;
    public static final Item COMPUTER_QUANTUM_NUMA_GPU_CORE;
    public static final Item COMPUTER_DRAM_DIE;
    public static final Item COMPUTER_SRAM_DIE;
    public static final Item COMPUTER_QRAM_DIE;
    public static final Item COMPUTER_SRAM_CONTROLLER;
    public static final Item COMPUTER_SDR_CONTROLLER;
    public static final Item COMPUTER_DDR_CONTROLLER;
    public static final Item COMPUTER_ECC_CONTROLLER;
    public static final Item COMPUTER_DRAM_SDR_RAM;
    public static final Item COMPUTER_DRAM_DDR_RAM;
    public static final Item COMPUTER_DRAM_DDR2_RAM;
    public static final Item COMPUTER_DRAM_DDR3_RAM;
    public static final Item COMPUTER_DRAM_DDR4_RAM;
    public static final Item COMPUTER_DRAM_DDR5_RAM;
    public static final Item COMPUTER_SRAM_DDR_RAM;
    public static final Item COMPUTER_SRAM_DDR2_RAM;
    public static final Item COMPUTER_SRAM_DDR3_RAM;
    public static final Item COMPUTER_SRAM_DDR4_RAM;
    public static final Item COMPUTER_SRAM_DDR5_RAM;
    public static final Item COMPUTER_SRAM_ECC_DDR_RAM;
    public static final Item COMPUTER_SRAM_ECC_DDR2_RAM;
    public static final Item COMPUTER_SRAM_ECC_DDR3_RAM;
    public static final Item COMPUTER_SRAM_ECC_DDR4_RAM;
    public static final Item COMPUTER_SRAM_ECC_DDR5_RAM;
    public static final Item COMPUTER_QRAM_LOW_DENSITY;
    public static final Item COMPUTER_QRAM_MEDIUM_DENSITY;
    public static final Item COMPUTER_QRAM_HIGH_DENSITY;
    public static final Item COMPUTER_HEATSINK;
    public static final Item COMPUTER_FULLTOWER_FAN_HEATSINK;
    public static final Item COMPUTER_FLUID_HEAT_TRANSFER_PLATE;
    public static final Item COLORED_POLYCARBONATE_BODY_PART;
    public static final Item BIT;
    public static final Item BYTE;
    public static final Item FLUORIDE;
    public static final Item GIGABIT;
    public static final Item GIGABYTE;
    public static final Item GPU_COMPUTE_PROCESSOR_CORE;
    public static final Item GPU_COMPUTE_PROCESSOR;
    public static final Item GPU_PACKAGE_RISC;
    public static final Item GPU_PACKAGE_ASIC;
    public static final Item GPU_PACKAGE_QUANTUM;
    public static final Item INTEGRATED_HEAT_SPREADER;
    public static final Item JEREMY_LAPTOP;
    public static final Item KEY_CAP;
    public static final Item KEY_SPRING;
    public static final BucketItem LIQUID_HELIUM_BUCKET;
    public static final Item MEGABIT;
    public static final Item MEGABYTE;
    public static final Item MOLTEN_POLYCARBONATE_CONCENTRATE;
    public static final Item PETABIT;
    public static final Item PETABYTE;
    public static final Item POLYCARBONATE_CRYSTALLINE_DYE;
    public static final Item COLD_POLYCARBONATE_CONCENTRATE;
    public static final Item QUBIT;
    public static final Item QUBYTE;
    public static final Item RAW_SILICADUST;
    public static final Item RAW_POLYCARBONATE;
    public static final Item SOLID_QUANTUM;
    public static final Item SOLDER_BLOB;
    //books
    private static final Item.Settings DEFAULT_BOOK_SETTINGS = new Item.Settings().maxCount(1);
    public static final WrittenBookItem STORY_BOOK;
    public static final WrittenBookItem STORY_BOOK2;

    public static final Item SILICON_WAFER;
    public static final Item SILICON_PLATE;
    public static final Item TRIURANIUM_OCTAOXIDE;
    public static final Item TRUSTY_SCREWDRIVER;
    public static final Item TERABIT;
    public static final Item TERABYTE;
    public static final Item TITANIUM_INGOT;
    public static final Item URANIUM_SILICATE;
    public static final Item URANIUM_SILICON_PLATE;
    public static final Item URANIUM_DIOXIDE;
    public static final Item URANIUM_MELT;
    public static final Item URANIUM_ISOTOPE238;
    public static final Item URANIUM_ISOTOPE235;
    public static final Item URANIUM_BATTERY_STARTER;
    public static final Item URANIUM_BATTERY_NOVICE;
    public static final Item URANIUM_BATTERY_FINAL;

    public static final Item XANA_SYMBOL;

    //weapons
    private static final Item.Settings WEAPONS = new Item.Settings();
    public static final BowItem ARCHER_BOW;
    public static final SwordItem DIGITAL_SABER;
    public static final BowItem FORCE_FIELD_EMITTER;
    public static final BowItem LASER_ARROW_SHOOTER;
    public static final SwordItem QUANTUM_SABER;
    public static final TridentItem YUMI_TRADITIONAL_FANS;
    public static final SwordItem ZWEIHANDER;
    
    

    //armor
    private static final Item.Settings ArmorGroup = new Item.Settings().maxCount(1);
    public static final ArmorItem AELITA_CHESTPLATE;
    public static final ArmorItem AELITA_LEGGINGS;
    public static final ArmorItem AELITA_BOOTS;
    public static final ArmorItem BLANK_HELMET;
    public static final ArmorItem JEREMY_CHESTPLATE;
    public static final ArmorItem JEREMY_LEGGINGS;
    public static final ArmorItem JEREMY_BOOTS;
    public static final ArmorItem LINKER;
    public static final ArmorItem MIND_HELMET;
    public static final ArmorItem ODD_CHESTPLATE;
    public static final ArmorItem ODD_LEGGINGS;
    public static final ArmorItem ODD_BOOTS;
    public static final ArmorItem ULRICH_HEADBAND;
    public static final ArmorItem ULRICH_CHESTPLATE;
    public static final ArmorItem ULRICH_LEGGINGS;
    public static final ArmorItem ULRICH_BOOTS;
    
    public static final ArmorItem WILLIAM_CHESTPLATE;
    public static final ArmorItem WILLIAM_LEGGINGS;
    public static final ArmorItem WILLIAM_BOOTS;
    public static final ArmorItem YUMI_CHESTPLATE;
    public static final ArmorItem YUMI_LEGGINGS;
    public static final ArmorItem YUMI_BOOTS;

    

   

    public static final MusicDiscItem LYOKO_THEME;
    public static final MusicDiscItem LYOKO_THEME_INSTRUMENTAL;
    static {
        TEST_MULTIPLAYER_PHONE = registerModItem("test_multiplayer_phone",new MultiplayerPhone(BaseSettings()));
        //spawn items
        HOVERBOARD_SPAWN_ITEM = registerModItem("hoverboard_spawn_item",new LyokoSpawnItem(
                BaseSettings().rarity(Rarity.EPIC),ModEntities.HOVERBOARD));
        OVERBOARD_SPAWN_ITEM = registerModItem("overboard_spawn_item",new LyokoSpawnItem(BaseSettings().rarity(Rarity.EPIC),ModEntities.OVERBOARD));
        OVERBIKE_SPAWN_ITEM = registerModItem("overbike_spawn_item",new LyokoSpawnItem(BaseSettings().rarity(Rarity.EPIC),ModEntities.OVERBIKE));
        //items
        APU_PACKAGE_ARM = registerComputerItem("apu_package_arm");
        APU_PACKAGE_x86 = registerComputerItem("apu_package_x86",BaseSettings().rarity(
                Rarity.UNCOMMON));
        APU_PACKAGE_ASIC = registerComputerItem("apu_package_asic",BaseSettings().rarity(
                Rarity.RARE));
        APU_PACKAGE_RISC = registerComputerItem("apu_package_risc",BaseSettings().rarity(
                Rarity.EPIC));
        APU_DIE_ARM = registerComputerItem("apu_die_arm");
        APU_DIE_x86 = registerComputerItem("apu_die_x86",BaseSettings().rarity(
                Rarity.COMMON));
        APU_DIE_ASIC = registerComputerItem("apu_die_asic",BaseSettings().rarity(
                Rarity.RARE));
        BORNITE_ITEM = registerGenericItem("bornite_item",BaseSettings().maxDamage(4));
        BLISTER_COPPER = registerModItem("blister_copper",new BlisterCopper(BaseSettings().maxDamage(60)));
        CHALCOPYRITE_ITEM = registerGenericItem("chalcopyrite_item",BaseSettings().maxDamage(5));
        CHALCOCITE_ITEM = registerGenericItem("chalcocite_item",BaseSettings().maxDamage(7));
        COVELLITE_ITEM = registerGenericItem("covellite_item",BaseSettings().maxDamage(6));
        CUPROUS_OXIDE = registerGenericItem("cuprous_oxide");
        CPU_PACKAGE_ARM = registerComputerItem("cpu_package_arm",BaseSettings().rarity(Rarity.COMMON));
        CPU_PACKAGE_x86 = registerComputerItem("cpu_package_x86",BaseSettings().rarity(Rarity.COMMON));
        CPU_PACKAGE_RISC = registerComputerItem("cpu_package_risc",BaseSettings().rarity(Rarity.UNCOMMON));
        CPU_PACKAGE_ASIC = registerComputerItem("cpu_package_asic",BaseSettings().rarity(Rarity.RARE));
        CPU_PACKAGE_QUANTUM = registerComputerItem("cpu_package_quantum",BaseSettings().rarity(Rarity.EPIC));
        CPU_DIE_ARM = registerComputerItem("cpu_die_arm",BaseSettings().rarity(Rarity.COMMON));
        CPU_DIE_x86 = registerComputerItem("cpu_die_x86",BaseSettings().rarity(Rarity.COMMON));
        CPU_DIE_RISC = registerComputerItem("cpu_die_risc",BaseSettings().rarity(Rarity.UNCOMMON));
        CPU_DIE_ASIC = registerComputerItem("cpu_die_asic",BaseSettings().rarity(Rarity.RARE));
        CPU_DIE_QUANTUM = registerComputerItem("cpu_die_quantum",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_ARM_CORE = registerComputerItem("computer_arm_core",BaseSettings().rarity(Rarity.COMMON));
        COMPUTER_X86_CORE = registerComputerItem("computer_x86_core",BaseSettings().rarity(Rarity.COMMON));
        COMPUTER_RISC_CORE = registerComputerItem("computer_risc_core",BaseSettings().rarity(Rarity.UNCOMMON));
        COMPUTER_ASIC_CORE = registerComputerItem("computer_asic_core",BaseSettings().rarity(Rarity.RARE));
        COMPUTER_QUANTUM_CORE = registerComputerItem("computer_quantum_core",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_RISC_GPU_CORE = registerComputerItem("computer_risc_gpu_core",BaseSettings().rarity(Rarity.UNCOMMON));
        COMPUTER_ASIC_GPU_CORE = registerComputerItem("computer_asic_gpu_core",BaseSettings().rarity(Rarity.RARE));
        COMPUTER_NEURAL_GPU_CORE = registerComputerItem("computer_neural_gpu_core",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_QUANTUM_NUMA_GPU_CORE = registerComputerItem("computer_quantum_numa_gpu_core",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_DRAM_DIE = registerComputerItem("computer_dram_die");
        COMPUTER_SRAM_DIE = registerComputerItem("computer_sram_die");
        COMPUTER_QRAM_DIE = registerComputerItem("computer_qram_die",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_SRAM_CONTROLLER = registerComputerItem("computer_sram_controller");
        COMPUTER_SDR_CONTROLLER = registerComputerItem("computer_sdr_controller");
        COMPUTER_DDR_CONTROLLER = registerComputerItem("computer_ddr_controller");
        COMPUTER_ECC_CONTROLLER = registerComputerItem("computer_ecc_controller");
        COMPUTER_DRAM_SDR_RAM = registerComputerItem("computer_dram_sdr_ram",BaseSettings().rarity(Rarity.COMMON));
        COMPUTER_DRAM_DDR_RAM = registerComputerItem("computer_dram_ddr_ram",BaseSettings().rarity(Rarity.COMMON));
        COMPUTER_DRAM_DDR2_RAM = registerComputerItem("computer_dram_ddr2_ram",BaseSettings().rarity(Rarity.COMMON));
        COMPUTER_DRAM_DDR3_RAM = registerComputerItem("computer_dram_ddr3_ram",BaseSettings().rarity(Rarity.COMMON));
        COMPUTER_DRAM_DDR4_RAM = registerComputerItem("computer_dram_ddr4_ram",BaseSettings().rarity(Rarity.UNCOMMON));
        COMPUTER_DRAM_DDR5_RAM = registerComputerItem("computer_dram_ddr5_ram",BaseSettings().rarity(Rarity.RARE));
        COMPUTER_SRAM_DDR_RAM = registerComputerItem("computer_sram_ddr_ram",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_SRAM_DDR2_RAM = registerComputerItem("computer_sram_ddr2_ram",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_SRAM_DDR3_RAM = registerComputerItem("computer_sram_ddr3_ram",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_SRAM_DDR4_RAM = registerComputerItem("computer_sram_ddr4_ram",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_SRAM_DDR5_RAM = registerComputerItem("computer_sram_ddr5_ram",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_SRAM_ECC_DDR_RAM = registerComputerItem("computer_sram_ecc_ddr_ram",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_SRAM_ECC_DDR2_RAM = registerComputerItem("computer_sram_ecc_ddr2_ram", BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_SRAM_ECC_DDR3_RAM = registerComputerItem("computer_sram_ecc_ddr3_ram",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_SRAM_ECC_DDR4_RAM = registerComputerItem("computer_sram_ecc_ddr4_ram",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_SRAM_ECC_DDR5_RAM = registerComputerItem("computer_sram_ecc_ddr5_ram",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_QRAM_LOW_DENSITY = registerComputerItem("computer_qram_low_density",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_QRAM_MEDIUM_DENSITY = registerComputerItem("computer_qram_medium_density",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_QRAM_HIGH_DENSITY = registerComputerItem("computer_qram_high_density",BaseSettings().rarity(Rarity.EPIC));
        COMPUTER_HEATSINK = registerComputerItem("computer_heatsink",BaseSettings().rarity(Rarity.UNCOMMON));
        COMPUTER_FULLTOWER_FAN_HEATSINK = registerComputerItem("computer_fulltower_fan_heatsink",BaseSettings().rarity(Rarity.RARE));
        COMPUTER_FLUID_HEAT_TRANSFER_PLATE = registerComputerItem("computer_fluid_heat_transfer_plate",BaseSettings().rarity(Rarity.EPIC));
        COLORED_POLYCARBONATE_BODY_PART = registerComputerItem("colored_polycarbonate_body_part");
        BIT = registerGenericItem("bit");
        BYTE = registerGenericItem("byte");
        FLUORIDE = registerGenericItem("fluoride");
        GIGABIT = registerGenericItem("gigabit");
        GIGABYTE = registerGenericItem("gigabyte");
        GPU_COMPUTE_PROCESSOR_CORE = registerComputerItem("gpu_compute_processor_core");
        GPU_COMPUTE_PROCESSOR = registerComputerItem("gpu_compute_processor",BaseSettings().rarity(Rarity.UNCOMMON));
        GPU_PACKAGE_RISC = registerComputerItem("gpu_package_risc",BaseSettings().rarity(Rarity.RARE));
        GPU_PACKAGE_ASIC = registerComputerItem("gpu_package_asic",BaseSettings().rarity(Rarity.EPIC));
        GPU_PACKAGE_QUANTUM = registerComputerItem("gpu_package_quantum",BaseSettings().rarity(Rarity.EPIC));
        INTEGRATED_HEAT_SPREADER = registerComputerItem("integrated_heat_spreader");
        JEREMY_LAPTOP = registerModItem("jeremys_laptop",new LaptopClass(
                new Item.Settings().maxCount(1),90000,100,0));
        KEY_CAP = registerComputerItem("key_cap");
        KEY_SPRING = registerComputerItem("key_spring");
        LIQUID_HELIUM_BUCKET = (BucketItem) registerModItem("liquid_helium_bucket",new CustomColorBucket(ModFluids.STILL_LIQUID_HELIUM,
                new Item.Settings().maxCount(1), ColorHelper.Argb.getArgb(3,255,255,255)));
    LYOKO_THEME =
        (MusicDiscItem)
            registerModItem(
                "lyokodisc",
                new MusicDiscItem(
                    (int) 3.2e23f,
                    ModSounds.LYOKO_THEME,
                    new Item.Settings().maxCount(1),
                    204));
    LYOKO_THEME_INSTRUMENTAL =
        (MusicDiscItem)
            registerModItem(
                "lyoko_disc_instrumental",
                new MusicDiscItem(
                    (int) 3.2e23f,
                    ModSounds.LYOKO_THEME_INSTRUMENTAL,
                    new Item.Settings().maxCount(1),
                    207));
        MEGABIT = registerComputerItem("megabit");
        MEGABYTE = registerComputerItem("megabyte");
        MOLTEN_POLYCARBONATE_CONCENTRATE = registerModItem("molten_polycarbonate_concentrate",new Polycarbonate(BaseSettings()));
        PETABIT = registerGenericItem("petabit");
        PETABYTE = registerGenericItem("petabyte");
        POLYCARBONATE_CRYSTALLINE_DYE = registerGenericItem("polycarbonate_crystalline_dye");
        COLD_POLYCARBONATE_CONCENTRATE = registerGenericItem("cold_polycarbonate_concentrate");
        QUBIT = registerGenericItem("qubit");
        QUBYTE = registerGenericItem("qubyte");
        RAW_SILICADUST = registerGenericItem("raw_silicadust");
        RAW_POLYCARBONATE = registerGenericItem("raw_polycarbonate");
        SOLID_QUANTUM = registerGenericItem("solid_quantum",BaseSettings().rarity(Rarity.EPIC));
        SOLDER_BLOB = registerGenericItem("solder_blob");
        STORY_BOOK = (WrittenBookItem) registerModItem("story_book",new EntryPool.BaseEntry(DEFAULT_BOOK_SETTINGS,0));
        STORY_BOOK2 = (WrittenBookItem) registerModItem("story_book2",new EntryPool.JournalEntry2());
        SILICON_WAFER = registerModItem("silicon_wafer",new WaferText(BaseSettings().maxDamage(4)));
        SILICON_PLATE = registerComputerItem("silicon_plate");
        TRIURANIUM_OCTAOXIDE = registerGenericItem("triuranium_octaoxide");
        TRUSTY_SCREWDRIVER = registerModItem("trusty_screwdriver",new TrustyScrewDriverItem(
                new Item.Settings().maxCount(1)));
        TERABIT = registerGenericItem("terabit");
        TERABYTE = registerGenericItem("terabyte");
        TITANIUM_INGOT = registerGenericItem("titanium_ingot");
        URANIUM_SILICATE = registerGenericItem("uranium_silicate");
        URANIUM_SILICON_PLATE = registerGenericItem("uranium_silicon_plate");
        URANIUM_DIOXIDE = registerGenericItem("uranium_dioxide");
        URANIUM_MELT = registerGenericItem("uranium_melt");
        URANIUM_ISOTOPE238 = registerGenericItem("uranium_isotope238");
        URANIUM_ISOTOPE235 = registerGenericItem("uranium_isotope235");
        URANIUM_BATTERY_STARTER = registerGenericItem("uranium_battery_starter",BaseSettings().rarity(Rarity.EPIC));
        URANIUM_BATTERY_NOVICE = registerGenericItem("uranium_battery_novice",BaseSettings().rarity(Rarity.EPIC));
        URANIUM_BATTERY_FINAL = registerGenericItem("uranium_battery_final",BaseSettings().rarity(Rarity.EPIC));
        XANA_SYMBOL = registerModItem("xana_symbol_item",new DecorationItem(ModEntities.XANA_SYMBOL_ENTITY_TYPE,
                BaseSettings().rarity(Rarity.EPIC).maxCount(1)));
        //weapons
        ARCHER_BOW = registerWeapon("archer_bow",new ArcherClassBow(WEAPONS));
        DIGITAL_SABER = registerWeapon("digital_saber",new SaberKatana(LyokoTiers.LyokoSamurai, 25, -0.9f, WEAPONS));
        LASER_ARROW_SHOOTER = registerWeapon("laser_arrow_shooter",new LaserArrowShooter(WEAPONS));
        QUANTUM_SABER = registerWeapon("quantum_saber",new SwordItem(LyokoTiers.LyokoTool,WEAPONS.rarity(Rarity.EPIC)));
        YUMI_TRADITIONAL_FANS = registerWeapon("yumi_traditional_fans",new YumiFans(WEAPONS));
        FORCE_FIELD_EMITTER = registerWeapon("force_field_emitter",new ForceFieldEmitter(WEAPONS.rarity(Rarity.EPIC)));
        ZWEIHANDER = registerWeapon("zweihander",new ZweihanderWeapon(LyokoTiers.LyokoWarrior, 60, -3f, WEAPONS));
       //armor
        AELITA_CHESTPLATE = registerArmor("aelita_chestplate",new ArmorGuardian(LyokoArmorMaterial.GUARDIAN.getMaterialRegistryEntry(),
                ArmorItem.Type.CHESTPLATE, ArmorGroup));
        AELITA_LEGGINGS = registerGenericArmorItem("aelita_leggings",LyokoArmorMaterial.GUARDIAN.getMaterialRegistryEntry(), ArmorItem.Type.LEGGINGS);
        AELITA_BOOTS = registerGenericArmorItem("aelita_boots",LyokoArmorMaterial.GUARDIAN.getMaterialRegistryEntry(), ArmorItem.Type.BOOTS);
        BLANK_HELMET = registerGenericArmorItem("blank_helmet",LyokoArmorMaterial.BLANK_HELM.getMaterialRegistryEntry(), ArmorItem.Type.HELMET);
        JEREMY_CHESTPLATE = registerArmor("jeremy_chestplate",new ArmorArcher(LyokoArmorMaterial.ARCHER.getMaterialRegistryEntry(),
                ArmorItem.Type.CHESTPLATE,
                ArmorGroup));
        JEREMY_LEGGINGS = registerArmor("jeremy_leggings",new ArmorArcher(LyokoArmorMaterial.ARCHER.getMaterialRegistryEntry(), ArmorItem.Type.LEGGINGS,
                ArmorGroup));
        JEREMY_BOOTS = registerArmor("jeremy_boots",new ArmorArcher(LyokoArmorMaterial.ARCHER.getMaterialRegistryEntry(), ArmorItem.Type.BOOTS,
                ArmorGroup));
        LINKER = registerArmor("linker",new SuperCalculatorDataLinker(LyokoArmorMaterial.LINKER.getMaterialRegistryEntry(), ArmorItem.Type.CHESTPLATE,
                ArmorGroup.rarity(Rarity.EPIC)));
        MIND_HELMET = registerArmor("mind_helmet",new MindHelm(LyokoArmorMaterial.BLANK_HELM.getMaterialRegistryEntry(), ArmorItem.Type.HELMET,
                ArmorGroup.rarity(Rarity.EPIC)));
        ODD_CHESTPLATE = registerArmor("odd_chestplate",new ArmorFeline(LyokoArmorMaterial.FELINE.getMaterialRegistryEntry(), ArmorItem.Type.CHESTPLATE,
                ArmorGroup));
        ODD_LEGGINGS = registerArmor("odd_leggings",new ArmorFeline(LyokoArmorMaterial.FELINE.getMaterialRegistryEntry(), ArmorItem.Type.LEGGINGS,
                ArmorGroup));
        ODD_BOOTS = registerArmor("odd_boots",new ArmorFeline(LyokoArmorMaterial.FELINE.getMaterialRegistryEntry(), ArmorItem.Type.BOOTS,
                ArmorGroup));
        ULRICH_HEADBAND = registerGenericArmorItem("ulrich_headband",LyokoArmorMaterial.SAMURAI.getMaterialRegistryEntry(), ArmorItem.Type.HELMET);
        ULRICH_CHESTPLATE = registerGenericArmorItem("ulrich_chestplate",LyokoArmorMaterial.SAMURAI.getMaterialRegistryEntry(),
                ArmorItem.Type.CHESTPLATE);
        ULRICH_LEGGINGS = registerGenericArmorItem("ulrich_leggings",LyokoArmorMaterial.SAMURAI.getMaterialRegistryEntry(), ArmorItem.Type.LEGGINGS);
        ULRICH_BOOTS = registerGenericArmorItem("ulrich_boots",LyokoArmorMaterial.SAMURAI.getMaterialRegistryEntry(), ArmorItem.Type.BOOTS);
        WILLIAM_CHESTPLATE = registerArmor("william_chestplate",new ArmorWarrior(LyokoArmorMaterial.WARRIOR.getMaterialRegistryEntry(),
                ArmorItem.Type.CHESTPLATE,
                ArmorGroup));
        WILLIAM_LEGGINGS = registerArmor("william_leggings",new ArmorWarrior(LyokoArmorMaterial.WARRIOR.getMaterialRegistryEntry(),
                ArmorItem.Type.LEGGINGS,
                ArmorGroup));
        WILLIAM_BOOTS = registerArmor("william_boots",new ArmorWarrior(LyokoArmorMaterial.WARRIOR.getMaterialRegistryEntry(), ArmorItem.Type.BOOTS,
                ArmorGroup));
        YUMI_CHESTPLATE = registerArmor("yumi_chestplate",new ArmorNinja(LyokoArmorMaterial.NINJA.getMaterialRegistryEntry(), ArmorItem.Type.CHESTPLATE,
                ArmorGroup));
        YUMI_LEGGINGS = registerArmor("yumi_leggings",new ArmorNinja(LyokoArmorMaterial.NINJA.getMaterialRegistryEntry(), ArmorItem.Type.LEGGINGS,
                ArmorGroup));
        YUMI_BOOTS = registerArmor("yumi_boots",new ArmorNinja(LyokoArmorMaterial.NINJA.getMaterialRegistryEntry(), ArmorItem.Type.BOOTS, ArmorGroup));
    }


   

    private static Item.Settings BaseSettings() {
        return new Item.Settings();

    }
    private static void addToItemGroup(final Item item)
    {
        ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                CodeLyokoMain.codeLyokoPrefix("lyoko_item"))).register(entries -> entries.add(item));
    }
    private static void addToArmorGroup(final Item item)
    {
        ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                CodeLyokoMain.codeLyokoPrefix("lyoko_armor"))).register(entries -> entries.add(item));
    }
    private static void addToWeaponGroup(final Item item)
    {

        ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                CodeLyokoMain.codeLyokoPrefix("lyoko_weapons"))).register(entries -> entries.add(item));
    }
    private static Item registerComputerItem(final String name, final Item.Settings settings)
    {
        return registerModItem(name,new ComputerItem(settings));
    }
    private static Item registerComputerItem(final String name)
    {
        return registerModItem(name,new ComputerItem(BaseSettings()));
    }
    private static Item registerGenericItem(final String name,final Item.Settings settings)
    {
        return registerModItem(name,new Item(settings));
    }
    private static Item registerGenericItem(final String name)
    {
        return registerModItem(name,new Item(BaseSettings()));
    }
    private static Item registerModItem(final String name,final Item item)
    {
        final Item registeredItem = Items.register(CodeLyokoMain.codeLyokoPrefix(name),item);
        addToItemGroup(registeredItem);
        return registeredItem;
    }
    private static Item registerModItem(final String name,final Item item,final ItemGroupTypes itemGroupTypes)
    {
        final Item registeredItem = Items.register(CodeLyokoMain.codeLyokoPrefix(name),item);
        switch (itemGroupTypes)
        {
            case ARMOR -> addToArmorGroup(item);
            case WEAPON -> addToWeaponGroup(item);
        }
        return registeredItem;
    }
    private static <T extends Item> T registerWeapon(final String name, final Item item)
    {
        return (T) registerModItem(name,item,ItemGroupTypes.WEAPON);
    }
    private static ArmorItem registerArmor(final String name, final Item item)
    {
        return (ArmorItem) registerModItem(name, item, ItemGroupTypes.ARMOR);
    }
    private static ArmorItem registerGenericArmorItem(final String name,final RegistryEntry<ArmorMaterial> material, final ArmorItem.Type armorType,final Item.Settings itemSettings)
    {
        final ArmorItem armorItem = new ArmorItem(material,armorType,itemSettings);
        return registerArmor(name,armorItem);
    }
    private static ArmorItem registerGenericArmorItem(final String name,final RegistryEntry<ArmorMaterial> material, final ArmorItem.Type armorType)
    {
        final ArmorItem armorItem = new ArmorItem(material,armorType,ArmorGroup);
        return registerArmor(name,armorItem);
    }
    private enum ItemGroupTypes
    {
        ARMOR,
        WEAPON
    }
    public static void registerItems()
    {}

}
