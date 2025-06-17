package com.Ultra_Nerd.CodeLyokoLegacy.Init.Common;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Items.Armor.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Items.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Items.SpawnItems.LyokoSpawnItem;
import com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools.Buckets.CustomColorBucket;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.Enums.LyokoArmorMaterial;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.Enums.LyokoTiers;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.ColorHelper;

import java.util.function.Function;

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
    public static final Item TITANIUM_DIOXIDE;
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
    public static final Item DIGITAL_SABER;
    public static final BowItem FORCE_FIELD_EMITTER;
    public static final BowItem LASER_ARROW_SHOOTER;
    public static final Item QUANTUM_SABER;
    public static final TridentItem YUMI_TRADITIONAL_FANS;
    public static final Item ZWEIHANDER;
    
    

    //armor
    private static final Item.Settings ArmorGroup = new Item.Settings().maxCount(1);
    public static final Item AELITA_CHESTPLATE;
    public static final Item AELITA_LEGGINGS;
    public static final Item AELITA_BOOTS;
    public static final Item BLANK_HELMET;
    public static final Item JEREMY_CHESTPLATE;
    public static final Item JEREMY_LEGGINGS;
    public static final Item JEREMY_BOOTS;
    public static final Item LINKER;
    public static final Item MIND_HELMET;
    public static final Item ODD_CHESTPLATE;
    public static final Item ODD_LEGGINGS;
    public static final Item ODD_BOOTS;
    public static final Item ULRICH_HEADBAND;
    public static final Item ULRICH_CHESTPLATE;
    public static final Item ULRICH_LEGGINGS;
    public static final Item ULRICH_BOOTS;

    public static final Item WILLIAM_CHESTPLATE;
    public static final Item WILLIAM_LEGGINGS;
    public static final Item WILLIAM_BOOTS;
    public static final Item YUMI_CHESTPLATE;
    public static final Item YUMI_LEGGINGS;
    public static final Item YUMI_BOOTS;





//    public static final MusicDiscItem LYOKO_THEME;
 //   public static final MusicDiscItem LYOKO_THEME_INSTRUMENTAL;

    private static final ObjectList<Item> ITEM_GROUP;
    private static final ObjectList<Item> ARMOR_GROUP;
    private static final ObjectList<Item> WEAPONS_GROUP;
    private static final RegistryKey<ItemGroup> LYOKO_ITEMS_GROUP = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
            CodeLyokoMain.codeLyokoPrefix("lyoko_item"));

    private static final RegistryKey<ItemGroup> LYOKO_ARMOR_GROUP = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
            CodeLyokoMain.codeLyokoPrefix("lyoko_armor"));

    private static final RegistryKey<ItemGroup> LYOKO_WEAPON_GROUP = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
            CodeLyokoMain.codeLyokoPrefix("lyoko_weapons"));
    static {
        //item collector
        ITEM_GROUP = new ObjectArrayList<>();
        //armor collector
        ARMOR_GROUP = new ObjectArrayList<>();
        //weapon collector
        WEAPONS_GROUP = new ObjectArrayList<>();


        TEST_MULTIPLAYER_PHONE = registerModItem("test_multiplayer_phone",MultiplayerPhone::new,BaseSettings());
        //spawn items
        HOVERBOARD_SPAWN_ITEM = registerModItem("hoverboard_spawn_item",settings -> new LyokoSpawnItem(settings,ModEntities.HOVERBOARD), BaseSettings().rarity(Rarity.EPIC));
        OVERBOARD_SPAWN_ITEM = registerModItem("overboard_spawn_item",settings->new LyokoSpawnItem(settings,ModEntities.OVERBOARD),BaseSettings().rarity(Rarity.EPIC));
        OVERBIKE_SPAWN_ITEM = registerModItem("overbike_spawn_item",settings->new LyokoSpawnItem(settings,ModEntities.OVERBIKE),BaseSettings().rarity(Rarity.EPIC));
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
        BLISTER_COPPER = registerModItem("blister_copper",BlisterCopper::new,BaseSettings().maxDamage(60));
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
        JEREMY_LAPTOP = registerModItem("jeremys_laptop",settings -> new LaptopClass(settings,90000,100,0),BaseSettings().maxCount(1));
        KEY_CAP = registerComputerItem("key_cap");
        KEY_SPRING = registerComputerItem("key_spring");
        LIQUID_HELIUM_BUCKET = (BucketItem) registerModItem("liquid_helium_bucket",settings -> new CustomColorBucket(ModFluids.STILL_LIQUID_HELIUM,
                settings, ColorHelper.getArgb(3,255,255,255)),BaseSettings().maxCount(1));
    /*LYOKO_THEME =
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
                    207));*/
        MEGABIT = registerComputerItem("megabit");
        MEGABYTE = registerComputerItem("megabyte");
        MOLTEN_POLYCARBONATE_CONCENTRATE = registerModItem("molten_polycarbonate_concentrate",Polycarbonate::new,BaseSettings());
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
        STORY_BOOK = (WrittenBookItem) registerModItem("story_book",settings -> new EntryPool.BaseEntry(settings,0),DEFAULT_BOOK_SETTINGS);
        STORY_BOOK2 = (WrittenBookItem) registerModItem("story_book2",EntryPool.JournalEntry2::new,DEFAULT_BOOK_SETTINGS);
        SILICON_WAFER = registerModItem("silicon_wafer",WaferText::new,BaseSettings().maxDamage(4));
        SILICON_PLATE = registerComputerItem("silicon_plate");
        TRIURANIUM_OCTAOXIDE = registerGenericItem("triuranium_octaoxide");
        TRUSTY_SCREWDRIVER = registerModItem("trusty_screwdriver",TrustyScrewDriverItem::new,BaseSettings().maxCount(1));
        TERABIT = registerGenericItem("terabit");
        TERABYTE = registerGenericItem("terabyte");
        TITANIUM_DIOXIDE = registerComputerItem("titanium_dioxide");
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
        XANA_SYMBOL = registerModItem("xana_symbol_item",settings -> new DecorationItem(ModEntities.XANA_SYMBOL_ENTITY_TYPE,settings),BaseSettings().rarity(Rarity.EPIC).maxCount(1));
        //weapons
        ARCHER_BOW = registerWeapon("archer_bow",ArcherClassBow::new,WEAPONS);
        DIGITAL_SABER = registerWeapon("digital_saber",settings -> new SaberKatana(LyokoTiers.LyokoSamurai.getMaterial(), 25, -0.9f,settings),WEAPONS);
        LASER_ARROW_SHOOTER = registerWeapon("laser_arrow_shooter",LaserArrowShooter::new,WEAPONS);
        QUANTUM_SABER = registerWeapon("quantum_saber",Item::new,WEAPONS.rarity(Rarity.EPIC).sword(LyokoTiers.LyokoTool.getMaterial(),5,5));
        YUMI_TRADITIONAL_FANS = registerWeapon("yumi_traditional_fans",YumiFans::new,WEAPONS);
        FORCE_FIELD_EMITTER = registerWeapon("force_field_emitter",ForceFieldEmitter::new,WEAPONS.rarity(Rarity.EPIC));
        ZWEIHANDER = registerWeapon("zweihander",settings -> new ZweihanderWeapon(LyokoTiers.LyokoWarrior.getMaterial(), 60, -3f, settings),WEAPONS);
       //armor
        AELITA_CHESTPLATE = registerArmor("aelita_chestplate",settings -> new ArmorGuardian(LyokoArmorMaterial.GUARDIAN.getMaterial(),
                EquipmentType.CHESTPLATE, settings),ArmorGroup);
        AELITA_LEGGINGS = registerGenericArmorItem("aelita_leggings",LyokoArmorMaterial.GUARDIAN.getMaterial(), EquipmentType.LEGGINGS);
        AELITA_BOOTS = registerGenericArmorItem("aelita_boots",LyokoArmorMaterial.GUARDIAN.getMaterial(), EquipmentType.BOOTS);
        BLANK_HELMET = registerGenericArmorItem("blank_helmet",LyokoArmorMaterial.BLANK_HELM.getMaterial(), EquipmentType.HELMET);
        JEREMY_CHESTPLATE = registerArmor("jeremy_chestplate",settings -> new ArmorArcher(LyokoArmorMaterial.ARCHER.getMaterial(),
                EquipmentType.CHESTPLATE
                ,settings),ArmorGroup);
        JEREMY_LEGGINGS = registerArmor("jeremy_leggings",settings -> new ArmorArcher(LyokoArmorMaterial.ARCHER.getMaterial(), EquipmentType.LEGGINGS,
                settings),ArmorGroup);
        JEREMY_BOOTS = registerArmor("jeremy_boots",settings -> new ArmorArcher(LyokoArmorMaterial.ARCHER.getMaterial(), EquipmentType.BOOTS,
                settings),ArmorGroup);
        LINKER = registerArmor("linker",settings -> new SuperCalculatorDataLinker(LyokoArmorMaterial.LINKER.getMaterial(), EquipmentType.CHESTPLATE,
                settings),ArmorGroup.rarity(Rarity.EPIC));
        MIND_HELMET = registerArmor("mind_helmet",settings -> new MindHelm(LyokoArmorMaterial.BLANK_HELM.getMaterial(), EquipmentType.HELMET,
                settings),ArmorGroup.rarity(Rarity.EPIC));
        ODD_CHESTPLATE = registerArmor("odd_chestplate",settings -> new ArmorFeline(LyokoArmorMaterial.FELINE.getMaterial(), EquipmentType.CHESTPLATE,
                settings),ArmorGroup);
        ODD_LEGGINGS = registerArmor("odd_leggings",settings -> new ArmorFeline(LyokoArmorMaterial.FELINE.getMaterial(), EquipmentType.LEGGINGS,
                settings),ArmorGroup);
        ODD_BOOTS = registerArmor("odd_boots",settings -> new ArmorFeline(LyokoArmorMaterial.FELINE.getMaterial(), EquipmentType.BOOTS,
                settings),ArmorGroup);
        ULRICH_HEADBAND = registerGenericArmorItem("ulrich_headband",LyokoArmorMaterial.SAMURAI.getMaterial(), EquipmentType.HELMET);
        ULRICH_CHESTPLATE = registerGenericArmorItem("ulrich_chestplate",LyokoArmorMaterial.SAMURAI.getMaterial(),
                EquipmentType.CHESTPLATE);
        ULRICH_LEGGINGS = registerGenericArmorItem("ulrich_leggings",LyokoArmorMaterial.SAMURAI.getMaterial(), EquipmentType.LEGGINGS);
        ULRICH_BOOTS = registerGenericArmorItem("ulrich_boots",LyokoArmorMaterial.SAMURAI.getMaterial(), EquipmentType.BOOTS);
        WILLIAM_CHESTPLATE = registerArmor("william_chestplate",settings -> new ArmorWarrior(LyokoArmorMaterial.WARRIOR.getMaterial(),
                EquipmentType.CHESTPLATE,
                settings),ArmorGroup);
        WILLIAM_LEGGINGS = registerArmor("william_leggings",settings -> new ArmorWarrior(LyokoArmorMaterial.WARRIOR.getMaterial(),
                EquipmentType.LEGGINGS,
                settings),ArmorGroup);
        WILLIAM_BOOTS = registerArmor("william_boots",settings -> new ArmorWarrior(LyokoArmorMaterial.WARRIOR.getMaterial(), EquipmentType.BOOTS,
                settings),ArmorGroup);
        YUMI_CHESTPLATE = registerArmor("yumi_chestplate",settings -> new ArmorNinja(LyokoArmorMaterial.NINJA.getMaterial(), EquipmentType.CHESTPLATE,
                settings),ArmorGroup);
        YUMI_LEGGINGS = registerArmor("yumi_leggings",settings -> new ArmorNinja(LyokoArmorMaterial.NINJA.getMaterial(), EquipmentType.LEGGINGS,
                settings),ArmorGroup);
        YUMI_BOOTS = registerArmor("yumi_boots",settings -> new ArmorNinja(LyokoArmorMaterial.NINJA.getMaterial(), EquipmentType.BOOTS,settings), ArmorGroup);
        registerCollectedData();
    }


    private static Item.Settings BaseSettings() {
        return new Item.Settings();

    }
    private static Item registerComputerItem(final String name, final Item.Settings settings)
    {
        return registerModItem(name,ComputerItem::new,settings);
    }
    private static Item registerComputerItem(final String name)
    {
        return registerModItem(name,ComputerItem::new,BaseSettings());
    }
    private static Item registerGenericItem(final String name,final Item.Settings settings)
    {
        return registerModItem(name,Item::new,settings);
    }
    private static Item registerGenericItem(final String name)
    {
        return registerModItem(name,Item::new,BaseSettings());
    }
    private static Item registerModItem(final String name,final Function<Item.Settings,Item> itemFactory,final Item.Settings settings)
    {
        return registerModItem(name,itemFactory,settings,ItemGroupTypes.ITEM);
    }
    private static Item registerModItem(final String name, final Function<Item.Settings,Item> itemFactory,final Item.Settings settings, final ItemGroupTypes itemGroupTypes)
    {
        final RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM,CodeLyokoMain.codeLyokoPrefix(name));
        final Item registeredItem = Registry.register(Registries.ITEM,itemKey,itemFactory.apply(settings.registryKey(itemKey)));
        switch (itemGroupTypes)
        {
            case ARMOR -> ARMOR_GROUP.add(registeredItem);
            case WEAPON -> WEAPONS_GROUP.add(registeredItem);
            case ITEM -> ITEM_GROUP.add(registeredItem);
        }
        return registeredItem;
    }
    private static <T extends Item> T registerWeapon(final String name, final Function<Item.Settings,Item> itemFactory,final Item.Settings settings)
    {
        return (T) registerModItem(name,itemFactory,settings,ItemGroupTypes.WEAPON);
    }
    private static Item registerArmor(final String name, final Function<Item.Settings,Item> itemFactory,final Item.Settings settings)
    {
        return registerModItem(name, itemFactory,settings, ItemGroupTypes.ARMOR);
    }
    private static Item registerGenericArmorItem(final String name, final ArmorMaterial material, final EquipmentType armorType, final Item.Settings itemSettings)
    {
        return registerArmor(name,Item::new,itemSettings.armor(material,armorType));
    }
    private static Item registerGenericArmorItem(final String name,final ArmorMaterial material, final EquipmentType armorType)
    {
        return registerArmor(name,Item::new,ArmorGroup.armor(material,armorType));
    }
    private enum ItemGroupTypes
    {
        ARMOR,
        WEAPON,
        ITEM
    }
    private static void registerCollectedData(){
        ItemGroupEvents.modifyEntriesEvent(LYOKO_ITEMS_GROUP).register(entries -> ITEM_GROUP.forEach(entries::add));
        ItemGroupEvents.modifyEntriesEvent(LYOKO_ARMOR_GROUP).register(entries -> ARMOR_GROUP.forEach(entries::add));
        ItemGroupEvents.modifyEntriesEvent(LYOKO_WEAPON_GROUP).register(entries -> WEAPONS_GROUP.forEach(entries::add));
        ITEM_GROUP.clear();
        ARMOR_GROUP.clear();
        WEAPONS_GROUP.clear();
    }
    public static void registerItems()
    {}

}
