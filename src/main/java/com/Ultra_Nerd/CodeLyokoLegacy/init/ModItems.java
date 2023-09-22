package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.items.*;
import com.Ultra_Nerd.CodeLyokoLegacy.items.SpawnItems.LyokoSpawnItem;
import com.Ultra_Nerd.CodeLyokoLegacy.items.armor.*;
import com.Ultra_Nerd.CodeLyokoLegacy.items.tools.*;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CustomLyokoRarity;
import com.Ultra_Nerd.CodeLyokoLegacy.util.enums.LyokoArmorMaterial;
import com.Ultra_Nerd.CodeLyokoLegacy.util.enums.LyokoTiers;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Rarity;

public record ModItems() {


    //public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CodeLyokoMain.MOD_ID);


    //for blocks items
    //public static final RegistryObject<BlockItem> ANTI_MARABUNTA = ITEMS.register("anti_marabunta",() -> new BlockItem(ModBlocks.ANTI_MARABUNTA.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    //for test items
    public static final Item TEST_MULTIPLAYER_PHONE = new MultiplayerPhone(BaseSettings());
    //for spawn eggs
    /*public static final RegistryObject<ForgeSpawnEggItem> BLOK_SPAWN_EGG = ITEMS.register("blok_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.BLOK, 1, 1, new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<ForgeSpawnEggItem> HORNET_SPAWN_EGG = ITEMS.register("hornet_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.HORNET, 1, 1, new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<ForgeSpawnEggItem> MANTA_SPAWN_EGG = ITEMS.register("manta_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.MANTA, 1, 1, new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<ForgeSpawnEggItem> MEGATANK_SPAWN_EGG = ITEMS.register("megatank_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.MEGATANK, 1, 1, new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<ForgeSpawnEggItem> KANKRELAT_SPAWN_EGG = ITEMS.register("kankrelat_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.KANKRELAT, 1, 1, new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<ForgeSpawnEggItem> GUARDIAN_SPAWN_EGG = ITEMS.register("guardian_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.GUARDIAN,1,1,new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    *///for spawn items
    //public static final RegistryObject<ForgeSpawnEggItem> HOVERBOARD_SPAWN_ITEM = ITEMS.register("hoverboard_spawn_item", () -> new ForgeSpawnEggItem(ModEntities.HOVERBOARD,1,1,new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    //public static final RegistryObject<ForgeSpawnEggItem> OVERBOARD_SPAWN_ITEM = ITEMS.register("overboard_spawn_item",() -> new ForgeSpawnEggItem(ModEntities.OVERBOARD,1,1,new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    // public static final RegistryObject<ForgeSpawnEggItem> OVERBIKE_SPAWN_ITEM = ITEMS.register("overbike_spawn_item", () -> new ForgeSpawnEggItem(ModEntities.OVERBIKE,1,1,new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    //public static final RegistryObject<ForgeSpawnEggItem> SKID_SPAWN_ITEM = ITEMS.register("skid_spawn_item", () -> new ForgeSpawnEggItem(ModEntities.SKID,1,1,new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    //public static final Item HOVERBOARD_SPAWN_ITEM = ITEMS.register("hoverboard_spawn_item",
    //      () -> new LyokoSpawnItem(new Item.Properties().setNoRepair().stacksTo(1).tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final Item HOVERBOARD_SPAWN_ITEM = new LyokoSpawnItem(
            BaseSettings().rarity(CustomLyokoRarity.FRANZ_NOVICE),ModEntities.HOVERBOARD);
    public static final Item OVERBOARD_SPAWN_ITEM =
            new LyokoSpawnItem(BaseSettings().rarity(CustomLyokoRarity.FRANZ_NOVICE),ModEntities.OVERBOARD);
    //public static final RegistryObject<Item> OVERBOARD_SPAWN_ITEM = ITEMS.register("overboard_spawn_item",() -> new OverBoardItem(new Item.Properties().setNoRepair().tab(CodeLyokoMain.LYOKO_ITEMS).stacksTo(1)));

    //for items
    public static final Item APU_PACKAGE_ARM = new ComputerItem(BaseSettings());
    //public static final RegistryObject<Item> APU_PACKAGE_ARM = ITEMS.register("apu_package_arm", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final Item APU_PACKAGE_x86 = new ComputerItem(BaseSettings().rarity(
            Rarity.UNCOMMON));//ITEMS.register("", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final Item APU_PACKAGE_ASIC = new ComputerItem(BaseSettings().rarity(
            Rarity.RARE));//ITEMS.register("apu_package_asic", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final Item APU_PACKAGE_RISC = new ComputerItem(BaseSettings().rarity(
            Rarity.EPIC));//ITEMS.register("apu_package_risc", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final Item APU_DIE_ARM = new ComputerItem(
            BaseSettings());//ITEMS.register("apu_die_arm", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final Item APU_DIE_x86 = new ComputerItem(BaseSettings().rarity(
            Rarity.COMMON));//ITEMS.register("apu_die_x86", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final Item APU_DIE_ASIC = new ComputerItem(BaseSettings().rarity(
            Rarity.RARE));//ITEMS.register("apu_die_asic", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final Item BORNITE_ITEM = new Item(BaseSettings().maxDamage(4));
    public static final Item BLISTER_COPPER = new BlisterCopper(BaseSettings().maxDamage(60));
    public static final Item CHALCOPYRITE_ITEM = new Item(BaseSettings().maxDamage(5));
    public static final Item CHALCOCITE_ITEM = new Item(BaseSettings().maxDamage(7));
    public static final Item COVELLITE_ITEM = new Item(BaseSettings().maxDamage(6));
    public static final Item CUPROUS_OXIDE = new Item(BaseSettings());
    public static final Item CPU_PACKAGE_ARM = new ComputerItem(BaseSettings().rarity(Rarity.COMMON));
    public static final Item CPU_PACKAGE_x86 = new ComputerItem(BaseSettings().rarity(Rarity.COMMON));
    public static final Item CPU_PACKAGE_RISC = new ComputerItem(BaseSettings().rarity(Rarity.UNCOMMON));
    public static final Item CPU_PACKAGE_ASIC = new ComputerItem(BaseSettings().rarity(Rarity.RARE));
    public static final Item CPU_PACKAGE_QUANTUM = new ComputerItem(BaseSettings().rarity(CustomLyokoRarity.MAINFRAME));
    public static final Item CPU_DIE_ARM = new ComputerItem(BaseSettings().rarity(Rarity.COMMON));
    public static final Item CPU_DIE_x86 = new ComputerItem(BaseSettings().rarity(Rarity.COMMON));
    public static final Item CPU_DIE_RISC = new ComputerItem(BaseSettings().rarity(Rarity.UNCOMMON));
    public static final Item CPU_DIE_ASIC = new ComputerItem(BaseSettings().rarity(Rarity.RARE));
    public static final Item CPU_DIE_QUANTUM = new ComputerItem(BaseSettings().rarity(CustomLyokoRarity.MAINFRAME));
    public static final Item COMPUTER_ARM_CORE = new ComputerItem(BaseSettings().rarity(Rarity.COMMON));
    public static final Item COMPUTER_X86_CORE = new ComputerItem(BaseSettings().rarity(Rarity.COMMON));
    public static final Item COMPUTER_RISC_CORE = new ComputerItem(BaseSettings().rarity(Rarity.UNCOMMON));
    public static final Item COMPUTER_ASIC_CORE = new ComputerItem(BaseSettings().rarity(Rarity.RARE));
    public static final Item COMPUTER_QUANTUM_CORE = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.MAINFRAME));
    public static final Item COMPUTER_RISC_GPU_CORE = new ComputerItem(BaseSettings().rarity(Rarity.UNCOMMON));
    public static final Item COMPUTER_ASIC_GPU_CORE = new ComputerItem(BaseSettings().rarity(Rarity.RARE));
    public static final Item COMPUTER_NEURAL_GPU_CORE = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.MAINFRAME));
    public static final Item COMPUTER_QUANTUM_NUMA_GPU_CORE = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.FRANZ_STARTER));
    public static final Item COMPUTER_DRAM_DIE = new ComputerItem(BaseSettings());
    public static final Item COMPUTER_SRAM_DIE = new ComputerItem(BaseSettings());
    public static final Item COMPUTER_QRAM_DIE = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.FRANZ_STARTER));
    public static final Item COMPUTER_SRAM_CONTROLLER = new ComputerItem(BaseSettings());
    public static final Item COMPUTER_SDR_CONTROLLER = new ComputerItem(BaseSettings());
    public static final Item COMPUTER_DDR_CONTROLLER = new ComputerItem(BaseSettings());
    public static final Item COMPUTER_ECC_CONTROLLER = new ComputerItem(BaseSettings());
    public static final Item COMPUTER_DRAM_SDR_RAM = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.COMMONPART));
    public static final Item COMPUTER_DRAM_DDR_RAM = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.COMMONPART));
    public static final Item COMPUTER_DRAM2_DDR_RAM = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.COMMONPART));
    public static final Item COMPUTER_DRAM3_DDR_RAM = new ComputerItem(BaseSettings().rarity(Rarity.COMMON));
    public static final Item COMPUTER_DRAM4_DDR_RAM = new ComputerItem(BaseSettings().rarity(Rarity.UNCOMMON));
    public static final Item COMPUTER_DRAM5_DDR_RAM = new ComputerItem(BaseSettings().rarity(Rarity.RARE));
    public static final Item COMPUTER_SRAM_DDR_RAM = new ComputerItem(BaseSettings().rarity(Rarity.EPIC));
    public static final Item COMPUTER_SRAM_DDR2_RAM = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.PROSUMER));
    public static final Item COMPUTER_SRAM_DDR3_RAM = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.SERVER_BETA));
    public static final Item COMPUTER_SRAM_DDR4_RAM = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.ENTHUSIAST));
    public static final Item COMPUTER_SRAM_DDR5_RAM = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.DATACENTER));
    public static final Item COMPUTER_SRAM_ECC_DDR_RAM = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.SERVER_BETA));
    public static final Item COMPUTER_SRAM_ECC_DDR2_RAM = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.SERVER_CONSUMER));
    public static final Item COMPUTER_SRAM_ECC_DDR3_RAM = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.SERVER_MATURE));
    public static final Item COMPUTER_SRAM_ECC_DDR4_RAM = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.SERVER_PROSUMER));
    public static final Item COMPUTER_SRAM_ECC_DDR5_RAM = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.DATACENTER));
    public static final Item COMPUTER_QRAM_LOW_DENSITY = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.FRANZ_STARTER));
    public static final Item COMPUTER_QRAM_MEDIUM_DENSITY = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.FRANZ_NOVICE));
    public static final Item COMPUTER_QRAM_HIGH_DENSITY = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.FRANZ_HOPPER));
    public static final Item COMPUTER_HEATSINK = new ComputerItem(BaseSettings().rarity(Rarity.UNCOMMON));
    public static final Item COMPUTER_FULLTOWER_FAN_HEATSINK = new ComputerItem(BaseSettings().rarity(Rarity.RARE));
    public static final Item COMPUTER_FLUID_HEAT_TRANSFER_PLATE = new ComputerItem(
            BaseSettings().rarity(CustomLyokoRarity.FRANZ_HOPPER));
    public static final Item COLORED_POLYCARBONATE_BODY_PART = new Item(BaseSettings());
    public static final Item BIT = new Item(BaseSettings());
    public static final Item BYTE = new Item(BaseSettings());
    public static final Item FLUORIDE = new Item(BaseSettings());
    public static final Item GIGABIT = new Item(BaseSettings());
    public static final Item GIGABYTE = new Item(BaseSettings());
    public static final Item GPU_COMPUTE_PROCESSOR_CORE = new ComputerItem(BaseSettings());
    public static final Item GPU_COMPUTE_PROCESSOR = new ComputerItem(BaseSettings().rarity(Rarity.UNCOMMON));
    public static final Item GPU_PACKAGE_RISC = new ComputerItem(BaseSettings().rarity(Rarity.RARE));
    public static final Item GPU_PACKAGE_ASIC = new ComputerItem(BaseSettings().rarity(Rarity.EPIC));
    public static final Item GPU_PACKAGE_QUANTUM = new ComputerItem(BaseSettings().rarity(CustomLyokoRarity.MAINFRAME));
    public static final Item INTEGRATED_HEAT_SPREADER = new Item(BaseSettings());
    public static final Item KEY_CAP = new Item(BaseSettings());
    public static final Item KEY_SPRING = new Item(BaseSettings());
    public static final Item MEGABIT = new Item(BaseSettings());
    public static final Item MEGABYTE = new Item(BaseSettings());
    public static final Item MOLTEN_POLYCARBONATE_CONCENTRATE = new Polycarbonate(BaseSettings());
    public static final Item PETABIT = new Item(BaseSettings());
    public static final Item PETABYTE = new Item(BaseSettings());
    public static final Item POLYCARBONATE_CRYSTALLINE_DYE = new Item(BaseSettings());
    public static final Item COLD_POLYCARBONATE_CONCENTRATE = new Item(BaseSettings());
    public static final Item QUBIT = new Item(BaseSettings());
    public static final Item QUBYTE = new Item(BaseSettings());
    public static final Item RAW_SILICADUST = new Item(BaseSettings());
    public static final Item RAW_POLYCARBONATE = new Item(BaseSettings());
    public static final Item SOLID_QUANTUM = new Item(BaseSettings().rarity(CustomLyokoRarity.FRANZ_HOPPER));
    public static final Item SOLDER_BLOB = new Item(BaseSettings());
    public static final WrittenBookItem STORY_BOOK = new EntryPool.Entry1(new Item.Settings().maxCount(1));
    public static final Item SILICON_WAFER = new WaferText(BaseSettings().maxDamage(4));
    public static final Item URANIUM_SILICATE = new Item(BaseSettings());
    public static final Item URANIUM_SILICON_PLATE = new Item(BaseSettings());
    public static final Item TRIURANIUM_OCTAOXIDE = new Item(BaseSettings());
    public static final Item TERABIT = new Item(BaseSettings());
    public static final Item TERABYTE = new Item(BaseSettings());
    public static final Item TITANIUM_INGOT = new Item(BaseSettings());
    public static final Item URANIUM_DIOXIDE = new Item(BaseSettings());
    public static final Item URANIUM_MELT = new Item(BaseSettings());
    public static final Item URANIUM_ISOTOPE238 = new Item(BaseSettings());
    public static final Item URANIUM_ISOTOPE235 = new Item(BaseSettings());
    public static final Item URANIUM_BATTERY_STARTER = new Item(BaseSettings().rarity(CustomLyokoRarity.FRANZ_STARTER));
    public static final Item URANIUM_BATTERY_NOVICE = new Item(BaseSettings().rarity(CustomLyokoRarity.FRANZ_NOVICE));
    public static final Item URANIUM_BATTERY_FINAL = new Item(BaseSettings().rarity(CustomLyokoRarity.FRANZ_HOPPER));
    //for tools
    //public static final RegistryObject<Item> DIGITAL_SAMPLER = ITEMS.register("digital_sampler", () -> new ShovelItem(LyokoTiers.LyokoTool, 2, 2, new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final Item TRUSTY_SCREWDRIVER = new TrustyScrewDriverItem(
            new Item.Settings().maxCount(1));
    //public static final RegistryObject<Item> SOLDERING_IRON = ITEMS.register("soldering_iron", () -> new soldering_iron(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final Item JEREMY_LAPTOP = new LaptopClass(
            new FabricItemSettings().maxCount(1),90000,100,0);
    //for buckets
    public static final BucketItem LIQUID_HELIUM_BUCKET = new BucketItem(ModFluids.STILL_LIQUID_HELIUM,
            new Item.Settings().maxCount(1));
    public static final WrittenBookItem STORY_BOOK2 = new EntryPool.Entry2(
            new Item.Settings().maxCount(1));
    public static final MusicDiscItem LYOKO_THEME = new LyokoDisc((int) 3.2e23f, ModSounds.LYOKO_THEME,
            new FabricItemSettings().maxCount(1), 204);
    public static final ImmutableMap<String, Item> ITEM_MAP = ImmutableMap.<String, Item>builder()
//testing Items
            .put("test_multiplayer_phone", TEST_MULTIPLAYER_PHONE)
            // spawn Items
            .put("hoverboard_spawn_item", HOVERBOARD_SPAWN_ITEM)
            .put("overboard_spawn_item",OVERBOARD_SPAWN_ITEM)
//Items

            .put("apu_package_arm", APU_PACKAGE_ARM)
            .put("apu_package_x86", APU_PACKAGE_x86)
            .put("apu_package_asic", APU_PACKAGE_ASIC)
            .put("apu_package_risc", APU_PACKAGE_RISC)
            .put("apu_die_arm", APU_DIE_ARM)
            .put("apu_die_x86", APU_DIE_x86)
            .put("apu_die_asic", APU_DIE_ASIC)
            .put("bornite_item", BORNITE_ITEM)
            .put("chalcopyrite_item", CHALCOPYRITE_ITEM)
            .put("chalcocite_item", CHALCOCITE_ITEM)
            .put("covellite_item", COVELLITE_ITEM)
            .put("cuprous_oxide", CUPROUS_OXIDE)
            .put("blister_copper", BLISTER_COPPER)
            .put("cpu_package_arm", CPU_PACKAGE_ARM)
            .put("cpu_package_x86", CPU_PACKAGE_x86)
            .put("cpu_package_risc", CPU_PACKAGE_RISC)
            .put("cpu_package_asic", CPU_PACKAGE_ASIC)
            .put("cpu_package_quantum", CPU_PACKAGE_QUANTUM)
            .put("cpu_die_arm", CPU_DIE_ARM)
            .put("cpu_die_x86", CPU_DIE_x86)
            .put("cpu_die_risc", CPU_DIE_RISC)
            .put("cpu_die_asic", CPU_DIE_ASIC)
            .put("cpu_die_quantum", CPU_DIE_QUANTUM)
            .put("computer_arm_core", COMPUTER_ARM_CORE)
            .put("computer_x86_core", COMPUTER_X86_CORE)
            .put("computer_risc_core", COMPUTER_RISC_CORE)
            .put("computer_asic_core", COMPUTER_ASIC_CORE)
            .put("computer_quantum_core", COMPUTER_QUANTUM_CORE)
            .put("computer_risc_gpu_core", COMPUTER_RISC_GPU_CORE)
            .put("computer_asic_gpu_core", COMPUTER_ASIC_GPU_CORE)
            .put("computer_neural_gpu_core", COMPUTER_NEURAL_GPU_CORE)
            .put("computer_quantum_numa_gpu_core", COMPUTER_QUANTUM_NUMA_GPU_CORE)
            .put("computer_dram_die", COMPUTER_DRAM_DIE)
            .put("computer_sram_die", COMPUTER_SRAM_DIE)
            .put("computer_qram_die", COMPUTER_QRAM_DIE)
            .put("computer_sram_controller", COMPUTER_SRAM_CONTROLLER)
            .put("computer_sdr_controller", COMPUTER_SDR_CONTROLLER)
            .put("computer_ddr_controller", COMPUTER_DDR_CONTROLLER)
            .put("computer_ecc_controller", COMPUTER_ECC_CONTROLLER)
            .put("computer_dram_sdr_ram", COMPUTER_DRAM_SDR_RAM)
            .put("computer_dram_ddr_ram", COMPUTER_DRAM_DDR_RAM)
            .put("computer_dram_ddr2_ram", COMPUTER_DRAM2_DDR_RAM)
            .put("computer_dram_ddr3_ram", COMPUTER_DRAM3_DDR_RAM)
            .put("computer_dram_ddr4_ram", COMPUTER_DRAM4_DDR_RAM)
            .put("computer_dram_ddr5_ram", COMPUTER_DRAM5_DDR_RAM)
            .put("computer_sram_ddr_ram", COMPUTER_SRAM_DDR_RAM)
            .put("computer_sram_ddr2_ram", COMPUTER_SRAM_DDR2_RAM)
            .put("computer_sram_ddr3_ram", COMPUTER_SRAM_DDR3_RAM)
            .put("computer_sram_ddr4_ram", COMPUTER_SRAM_DDR4_RAM)
            .put("computer_sram_ddr5_ram", COMPUTER_SRAM_DDR5_RAM)
            .put("computer_sram_ecc_ddr_ram", COMPUTER_SRAM_ECC_DDR_RAM)
            .put("computer_sram_ecc_ddr2_ram", COMPUTER_SRAM_ECC_DDR2_RAM)
            .put("computer_sram_ecc_ddr3_ram", COMPUTER_SRAM_ECC_DDR3_RAM)
            .put("computer_sram_ecc_ddr4_ram", COMPUTER_SRAM_ECC_DDR4_RAM)
            .put("computer_sram_ecc_ddr5_ram", COMPUTER_SRAM_ECC_DDR5_RAM)
            .put("computer_qram_low_density", COMPUTER_QRAM_LOW_DENSITY)
            .put("computer_qram_medium_density", COMPUTER_QRAM_MEDIUM_DENSITY)
            .put("computer_qram_high_density", COMPUTER_QRAM_HIGH_DENSITY)
            .put("computer_heatsink", COMPUTER_HEATSINK)
            .put("computer_fulltower_fan_heatsink", COMPUTER_FULLTOWER_FAN_HEATSINK)
            .put("computer_fluid_heat_transfer_plate", COMPUTER_FLUID_HEAT_TRANSFER_PLATE)
            .put("colored_polycarbonate_body_part", COLORED_POLYCARBONATE_BODY_PART)

            //other computer components
            .put("bit", BIT)
            .put("byte", BYTE)
            .put("fluoride", FLUORIDE)
            .put("gigabit", GIGABIT)
            .put("gigabyte", GIGABYTE)
            .put("gpu_compute_processor_core", GPU_COMPUTE_PROCESSOR_CORE)
            .put("gpu_compute_processor", GPU_COMPUTE_PROCESSOR)
            .put("gpu_package_risc", GPU_PACKAGE_RISC)
            .put("gpu_package_asic", GPU_PACKAGE_ASIC)
            .put("gpu_package_quantum", GPU_PACKAGE_QUANTUM)
            .put("integrated_heat_spreader", INTEGRATED_HEAT_SPREADER)
            .put("key_cap", KEY_CAP)
            .put("key_spring", KEY_SPRING)
            .put("megabit", MEGABIT)
            .put("megabyte", MEGABYTE)
            .put("molten_polycarbonate_concentrate", MOLTEN_POLYCARBONATE_CONCENTRATE)
            .put("petabit", PETABIT)
            .put("petabyte", PETABYTE)
            .put("polycarbonate_crystalline_dye", POLYCARBONATE_CRYSTALLINE_DYE)
            .put("cold_polycarbonate_concentrate", COLD_POLYCARBONATE_CONCENTRATE)
            .put("qubit", QUBIT)
            .put("qubyte", QUBYTE)
            .put("raw_silicadust", RAW_SILICADUST)
            .put("raw_polycarbonate", RAW_POLYCARBONATE)
            .put("solid_quantum", SOLID_QUANTUM)
            .put("solder_blob", SOLDER_BLOB)
            .put("story_book", STORY_BOOK)
            .put("story_book2", STORY_BOOK2)
            .put("silicon_wafer", SILICON_WAFER)
            .put("uranium_silicate", URANIUM_SILICATE)
            .put("uranium_silicon_plate", URANIUM_SILICON_PLATE)
            .put("triuranium_octaoxide", TRIURANIUM_OCTAOXIDE)
            .put("terabit", TERABIT)
            .put("terabyte", TERABYTE)
            .put("titanium_ingot", TITANIUM_INGOT)
            .put("uranium_dioxide", URANIUM_DIOXIDE)
            .put("uranium_melt", URANIUM_MELT)
            .put("uranium_isotope238", URANIUM_ISOTOPE238)
            .put("uranium_isotope235", URANIUM_ISOTOPE235)
            .put("uranium_battery_starter",URANIUM_BATTERY_STARTER)
            .put("uranium_battery_novice",URANIUM_BATTERY_NOVICE)
            .put("uranium_battery_final",URANIUM_BATTERY_FINAL)
            .put("trusty_screwdriver", TRUSTY_SCREWDRIVER)
            //tools
            .put("jeremys_laptop", JEREMY_LAPTOP)


            .put("lyokodisc", LYOKO_THEME)
            .put("liquid_helium_bucket", LIQUID_HELIUM_BUCKET)
            .build();

    //for weapons
    private static final FabricItemSettings WEAPONS = new FabricItemSettings();
    public static final SwordItem DIGITAL_SABER = new SaberKatana(LyokoTiers.LyokoSamurai, 25, -0.9f, WEAPONS);
    public static final BowItem LASER_ARROWSHOOTER = new LaserArrowShooter(WEAPONS);
    public static final SwordItem QUANTUM_SABER = new SwordItem(LyokoTiers.LyokoTool, 15, 2,
            WEAPONS.rarity(Rarity.EPIC));
    public static final TridentItem YUMI_TRADITONAL_FANS = new YumiFans(WEAPONS);
    public static final SwordItem ZWEIHANDER = new ZweihanderWeapon(LyokoTiers.LyokoWarrior, 60, -3f, WEAPONS);
    public static final BowItem FORCE_FIELD_EMITTER = new ForceFieldEmitter(WEAPONS.rarity(Rarity.EPIC));
    public static final BowItem ARCHER_BOW = new ArcherClassBow(WEAPONS);
    public static final ImmutableMap<String, Item> WEAPON_MAP = ImmutableMap.<String, Item>builder()

            .put("digital_saber", DIGITAL_SABER)
            .put("laser_arrowshooter", LASER_ARROWSHOOTER)
            .put("quantum_saber", QUANTUM_SABER)
            .put("yumi_traditional_fans", YUMI_TRADITONAL_FANS)
            .put("zweihander", ZWEIHANDER)
            .put("force_field_emitter", FORCE_FIELD_EMITTER)
            .put("archer_bow", ARCHER_BOW)
            .build();
    //for armor
    private static final FabricItemSettings ArmorGroup = new FabricItemSettings().maxCount(1);
    public static final ArmorItem AELITA_CHESTPLATE = new AelitaArmorElytra(LyokoArmorMaterial.GUARDIAN,
            ArmorItem.Type.CHESTPLATE, ArmorGroup);
    public static final ArmorItem AELITA_LEGGINGS = new ArmorItem(LyokoArmorMaterial.GUARDIAN, ArmorItem.Type.LEGGINGS,
            ArmorGroup);
    public static final ArmorItem AELITA_BOOTS = new ArmorItem(LyokoArmorMaterial.GUARDIAN, ArmorItem.Type.BOOTS,
            ArmorGroup);
    public static final ArmorItem ODD_CHESTPLATE = new ArmorFeline(LyokoArmorMaterial.FELINE, ArmorItem.Type.CHESTPLATE,
            ArmorGroup);
    public static final ArmorItem ODD_LEGGINGS = new ArmorFeline(LyokoArmorMaterial.FELINE, ArmorItem.Type.LEGGINGS,
            ArmorGroup);
    public static final ArmorItem ODD_BOOTS = new ArmorFeline(LyokoArmorMaterial.FELINE, ArmorItem.Type.BOOTS,
            ArmorGroup);
    public static final ArmorItem ULRICH_HEADBAND = new ArmorItem(LyokoArmorMaterial.SAMURAI, ArmorItem.Type.HELMET,
            ArmorGroup);
    public static final ArmorItem ULRICH_CHESTPLATE = new ArmorItem(LyokoArmorMaterial.SAMURAI,
            ArmorItem.Type.CHESTPLATE,
            ArmorGroup);
    public static final ArmorItem ULRICH_LEGGINGS = new ArmorItem(LyokoArmorMaterial.SAMURAI, ArmorItem.Type.LEGGINGS,
            ArmorGroup);
    public static final ArmorItem ULRICH_BOOTS = new ArmorItem(LyokoArmorMaterial.SAMURAI, ArmorItem.Type.BOOTS,
            ArmorGroup);
    public static final ArmorItem BLANKHELMET = new ArmorItem(LyokoArmorMaterial.BLANKHELM, ArmorItem.Type.HELMET,
            ArmorGroup);
    public static final ArmorItem WILLIAM_CHESTPLATE = new ArmorWarrior(LyokoArmorMaterial.WARRIOR,
            ArmorItem.Type.CHESTPLATE,
            ArmorGroup);
    public static final ArmorItem WILLIAM_LEGGINGS = new ArmorWarrior(LyokoArmorMaterial.WARRIOR,
            ArmorItem.Type.LEGGINGS,
            ArmorGroup);
    public static final ArmorItem WILLIAM_BOOTS = new ArmorWarrior(LyokoArmorMaterial.WARRIOR, ArmorItem.Type.BOOTS,
            ArmorGroup);
    public static final ArmorItem YUMI_CHESTPLATE = new ArmorNinja(LyokoArmorMaterial.NINJA, ArmorItem.Type.CHESTPLATE,
            ArmorGroup);
    public static final ArmorItem YUMI_LEGGINGS = new ArmorNinja(LyokoArmorMaterial.NINJA, ArmorItem.Type.LEGGINGS,
            ArmorGroup);
    public static final ArmorItem YUMI_BOOTS = new ArmorNinja(LyokoArmorMaterial.NINJA, ArmorItem.Type.BOOTS, ArmorGroup);
    public static final ArmorItem MIND_HELMET = new MindHelm(LyokoArmorMaterial.BLANKHELM, ArmorItem.Type.HELMET,
            ArmorGroup.rarity(Rarity.EPIC));
    public static final ArmorItem LINKER = new linker(LyokoArmorMaterial.LINKER, ArmorItem.Type.CHESTPLATE,
            ArmorGroup.rarity(Rarity.EPIC));
    public static final ArmorItem JEREMY_CHESTPLATE = new ArmorArcher(LyokoArmorMaterial.ARCHER,
            ArmorItem.Type.CHESTPLATE,
            ArmorGroup);
    public static final ArmorItem JEREMY_LEGGINGS = new ArmorArcher(LyokoArmorMaterial.ARCHER, ArmorItem.Type.LEGGINGS,
            ArmorGroup);
    public static final ArmorItem JEREMY_BOOTS = new ArmorArcher(LyokoArmorMaterial.ARCHER, ArmorItem.Type.BOOTS,
            ArmorGroup);
    public static final ImmutableMap<String, Item> ARMOR_MAP = ImmutableMap.<String, Item>builder()
            .put("aelita_chestplate", AELITA_CHESTPLATE)
            .put("aelita_leggings", AELITA_LEGGINGS)
            .put("aelita_boots", AELITA_BOOTS)
            .put("odd_chestplate", ODD_CHESTPLATE)
            .put("odd_leggings", ODD_LEGGINGS)
            .put("odd_boots", ODD_BOOTS)
            .put("ulrich_headband", ULRICH_HEADBAND)
            .put("ulrich_chestplate", ULRICH_CHESTPLATE)
            .put("ulrich_leggings", ULRICH_LEGGINGS)
            .put("ulrich_boots", ULRICH_BOOTS)
            .put("blank_helmet", BLANKHELMET)
            .put("william_chestplate", WILLIAM_CHESTPLATE)
            .put("william_leggings", WILLIAM_LEGGINGS)
            .put("william_boots", WILLIAM_BOOTS)
            .put("yumi_chestplate", YUMI_CHESTPLATE)
            .put("yumi_leggings", YUMI_LEGGINGS)
            .put("yumi_boots", YUMI_BOOTS)
            .put("mind_helmet", MIND_HELMET)
            .put("linker", LINKER)
            .put("jeremy_chestplate", JEREMY_CHESTPLATE)
            .put("jeremy_leggings", JEREMY_LEGGINGS)
            .put("jeremy_boots", JEREMY_BOOTS)
            .build();

    private static FabricItemSettings BaseSettings() {
        return new FabricItemSettings();

    }

    private static final class LyokoDisc extends MusicDiscItem {

        public LyokoDisc(int comparatorOutPut, SoundEvent soundEvent, FabricItemSettings settings, int lengthInSeconds) {
            super(comparatorOutPut, soundEvent, settings, lengthInSeconds);
        }
    }
}
