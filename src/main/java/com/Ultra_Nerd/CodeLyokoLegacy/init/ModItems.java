package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.items.ComputerItem;
import com.Ultra_Nerd.CodeLyokoLegacy.items.PropertyLessItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import java.util.HashMap;
import java.util.Map;

public final class ModItems {


    //public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CodeLyokoMain.MOD_ID);
    public static final Map<String,Item> ITEM_MAP = new HashMap<>();
    public static void addItemsToRegistry()
    {
            ITEM_MAP.put("apu_package_arm",APU_PACKAGE_ARM);
            ITEM_MAP.put("apu_package_x86",APU_PACKAGE_x86);
            ITEM_MAP.put("apu_package_asic",APU_PACKAGE_ASIC);
            ITEM_MAP.put("apu_package_risc",APU_PACKAGE_RISC);
            ITEM_MAP.put("apu_die_arm",APU_DIE_ARM);
            ITEM_MAP.put("apu_die_x86",APU_DIE_x86);
            ITEM_MAP.put("apu_die_asic",APU_DIE_ASIC);
            ITEM_MAP.put("bit",BIT);
    }
    private static final FabricItemSettings BaseSettings = new FabricItemSettings().group(CodeLyokoMain.LYOKO_ITEM);
    //for block items
    //public static final RegistryObject<BlockItem> ANTI_MARABUNTA = ITEMS.register("anti_marabunta",() -> new BlockItem(ModBlocks.ANTI_MARABUNTA.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    //for test items
    //public static final RegistryObject<Item> TEST_MULTIPLAYER_PHONE = ITEMS.register("test_multiplayer_phone", () -> new MultiplayerPhone(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
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
    //public static final RegistryObject<Item> HOVERBOARD_SPAWN_ITEM = ITEMS.register("hoverboard_spawn_item", () -> new HoverBoardItem(new Item.Properties().setNoRepair().stacksTo(1).tab(CodeLyokoMain.LYOKO_ITEMS)));
    //public static final RegistryObject<Item> OVERBOARD_SPAWN_ITEM = ITEMS.register("overboard_spawn_item",() -> new OverBoardItem(new Item.Properties().setNoRepair().tab(CodeLyokoMain.LYOKO_ITEMS).stacksTo(1)));
     //for items
    public static final Item APU_PACKAGE_ARM = new ComputerItem(new FabricItemSettings().group(CodeLyokoMain.LYOKO_ITEM));
    //public static final RegistryObject<Item> APU_PACKAGE_ARM = ITEMS.register("apu_package_arm", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final Item APU_PACKAGE_x86 = new ComputerItem(new FabricItemSettings().group(CodeLyokoMain.LYOKO_ITEM).rarity(Rarity.UNCOMMON));//ITEMS.register("", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final Item APU_PACKAGE_ASIC = new ComputerItem(new FabricItemSettings().group(CodeLyokoMain.LYOKO_ITEM).rarity(Rarity.RARE));//ITEMS.register("apu_package_asic", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final Item APU_PACKAGE_RISC = new ComputerItem(BaseSettings.rarity(Rarity.EPIC));//ITEMS.register("apu_package_risc", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final Item APU_DIE_ARM = new ComputerItem(BaseSettings);//ITEMS.register("apu_die_arm", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final Item APU_DIE_x86 = new ComputerItem(BaseSettings.rarity(Rarity.COMMON));//ITEMS.register("apu_die_x86", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final Item APU_DIE_ASIC = new ComputerItem(BaseSettings.rarity(Rarity.RARE));//ITEMS.register("apu_die_asic", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.RARE)));
  /*  public static final Item APU_DIE_RISC = ITEMS.register("apu_die_risc", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final Item CHALCOPYRITE_ITEM = ITEMS.register("chalcopyrite_item", () -> new Item(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).durability(5)));
    public static final Item BORNITE_ITEM = ITEMS.register("bornite_item", () -> new Item(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).durability(4)));
    public static final Item CHALCOCITE_ITEM = ITEMS.register("chalcocite_item", () -> new Item(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).durability(7)));
    public static final Item COVELLITE_ITEM = ITEMS.register("covellite_item", () -> new Item(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).durability(6)));
    public static final Item CUPROUS_OXIDE = ITEMS.register("cuprous_oxide", () -> new Item(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final Item BLISTER_COPPER = ITEMS.register("blister_copper", () -> new BlisterCopper(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).durability(60)));
    public static final RegistryObject<Item> CPU_PACKAGE_ARM = ITEMS.register("cpu_package_arm", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> CPU_PACKAGE_x86 = ITEMS.register("cpu_package_x86", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> CPU_PACKAGE_RISC = ITEMS.register("cpu_package_risc", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> CPU_PACKAGE_ASIC = ITEMS.register("cpu_package_asic", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> CPU_PACKAGE_QUANTUM = ITEMS.register("cpu_package_quantum", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("LEGENDARY", ChatFormatting.DARK_AQUA))));
    public static final RegistryObject<Item> CPU_DIE_ARM = ITEMS.register("cpu_die_arm", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> CPU_DIE_x86 = ITEMS.register("cpu_die_x86", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> CPU_DIE_RISC = ITEMS.register("cpu_die_risc", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> CPU_DIE_ASIC = ITEMS.register("cpu_die_asic", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> CPU_DIE_QUANTUM = ITEMS.register("cpu_die_quantum", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("LEGENDARY", ChatFormatting.DARK_AQUA))));
    public static final RegistryObject<Item> COMPUTER_ARM_CORE = ITEMS.register("computer_arm_core", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> COMPUTER_X86_CORE = ITEMS.register("computer_x86_core", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> COMPUTER_RISC_CORE = ITEMS.register("computer_risc_core", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> COMPUTER_ASIC_CORE = ITEMS.register("computer_asic_core", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> COMPUTER_QUANTUM_CORE = ITEMS.register("computer_quantum_core", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("LEGENDARY", ChatFormatting.DARK_AQUA))));
    public static final RegistryObject<Item> COMPUTER_RISC_GPU_CORE = ITEMS.register("computer_risc_gpu_core", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COMPUTER_ASIC_GPU_CORE = ITEMS.register("computer_asic_gpu_core", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> COMPUTER_NEURAL_GPU_CORE = ITEMS.register("computer_neural_gpu_core", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("LEGENDARY", ChatFormatting.DARK_AQUA))));
    public static final RegistryObject<Item> COMPUTER_QUANTUM_NUMA_GPU_CORE = ITEMS.register("computer_quantum_numa_gpu_core", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("QUANTUM", ChatFormatting.DARK_GRAY))));
    public static final RegistryObject<Item> COMPUTER_DRAM_DIE = ITEMS.register("computer_dram_die", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<Item> COMPUTER_SRAM_DIE = ITEMS.register("computer_sram_die", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<Item> COMPUTER_QRAM_DIE = ITEMS.register("computer_qram_die", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<Item> COMPUTER_SRAM_CONTROLLER = ITEMS.register("computer_sram_controller", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<Item> COMPUTER_SDR_CONTROLLER = ITEMS.register("computer_sdr_controller", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<Item> COMPUTER_DDR_CONTROLLER = ITEMS.register("computer_ddr_controller", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<Item> COMPUTER_ECC_CONTROLLER = ITEMS.register("computer_ecc_controller", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<Item> COMPUTER_DRAM_SDR_RAM = ITEMS.register("computer_dram_sdr_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("common_part", ChatFormatting.GRAY))));
    public static final RegistryObject<Item> COMPUTER_DRAM_DDR_RAM = ITEMS.register("computer_dram_ddr_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("common_part", ChatFormatting.GRAY))));
    public static final RegistryObject<Item> COMPUTER_DRAM2_DDR_RAM = ITEMS.register("computer_dram_ddr2_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("common_part", ChatFormatting.GRAY))));
    public static final RegistryObject<Item> COMPUTER_DRAM3_DDR_RAM = ITEMS.register("computer_dram_ddr3_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> COMPUTER_DRAM4_DDR_RAM = ITEMS.register("computer_dram_ddr4_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COMPUTER_DRAM5_DDR_RAM = ITEMS.register("computer_dram_ddr5_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> COMPUTER_SRAM_DDR_RAM = ITEMS.register("computer_sram_ddr_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> COMPUTER_SRAM_DDR2_RAM = ITEMS.register("computer_sram_ddr2_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("prosumer", ChatFormatting.DARK_BLUE))));
    public static final RegistryObject<Item> COMPUTER_SRAM_DDR3_RAM = ITEMS.register("computer_sram_ddr3_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("matureprosumer", ChatFormatting.DARK_AQUA))));
    public static final RegistryObject<Item> COMPUTER_SRAM_DDR4_RAM = ITEMS.register("computer_sram_ddr4_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("professional", ChatFormatting.DARK_GREEN))));
    public static final RegistryObject<Item> COMPUTER_SRAM_DDR5_RAM = ITEMS.register("computer_sram_ddr5_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("professional_enthusiast", ChatFormatting.DARK_RED))));
    public static final RegistryObject<Item> COMPUTER_SRAM_ECC_DDR_RAM = ITEMS.register("computer_sram_ecc_ddr_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("server_entrylevel", ChatFormatting.BLUE))));
    public static final RegistryObject<Item> COMPUTER_SRAM_ECC_DDR2_RAM = ITEMS.register("computer_sram_ecc_ddr2_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("server_prosumer", ChatFormatting.AQUA))));
    public static final RegistryObject<Item> COMPUTER_SRAM_ECC_DDR3_RAM = ITEMS.register("computer_sram_ecc_ddr3_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("server_matureprosumer", ChatFormatting.GREEN))));
    public static final RegistryObject<Item> COMPUTER_SRAM_ECC_DDR4_RAM = ITEMS.register("computer_sram_ecc_ddr4_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("server_professional", ChatFormatting.RED))));
    public static final RegistryObject<Item> COMPUTER_SRAM_ECC_DDR5_RAM = ITEMS.register("computer_sram_ecc_ddr5_ram", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("server_professional_enthusiast", ChatFormatting.GRAY))));
    public static final RegistryObject<Item> COMPUTER_QRAM_LOW_DENSITY = ITEMS.register("computer_qram_low_density", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("franz_starter", ChatFormatting.DARK_GRAY))));
    public static final RegistryObject<Item> COMPUTER_QRAM_MEDIUM_DENSITY = ITEMS.register("computer_qram_medium_density", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("franz_novice", ChatFormatting.GOLD))));
    public static final RegistryObject<Item> COMPUTER_QRAM_HIGH_DENSITY = ITEMS.register("computer_qram_high_density", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("franz_hopper", ChatFormatting.DARK_PURPLE))));
    public static final RegistryObject<Item> COMPUTER_HEATSINK = ITEMS.register("computer_heatsink", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COMPUTER_FULLTOWER_FAN_HEATSINK = ITEMS.register("computer_fulltower_fan_heatsink", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> COMPUTER_FLUID_HEAT_TRANSFER_PLATE = ITEMS.register("computer_fluid_heat_transfer_plate", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("franz_hopper", ChatFormatting.DARK_PURPLE))));
    public static final RegistryObject<Item> COLORED_POLYCARBONATE_BODY_PART = ITEMS.register("colored_polycarbonate_body_part", PropertyLessItem::new);
    */public static final Item BIT =  new PropertyLessItem();
   /* public static final RegistryObject<Item> BYTE = ITEMS.register("byte", PropertyLessItem::new);
    public static final RegistryObject<Item> FLUORIDE = ITEMS.register("fluoride", () -> new FluorideItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<Item> GIGABIT = ITEMS.register("gigabit", PropertyLessItem::new);
    public static final RegistryObject<Item> GIGABYTE = ITEMS.register("gigabyte", PropertyLessItem::new);
    public static final RegistryObject<Item> GPU_COMPUTE_PROCESSOR_CORE = ITEMS.register("gpu_compute_processor_core", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<Item> GPU_COMPUTE_PROCESSOR = ITEMS.register("gpu_compute_processor", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> GPU_PACKAGE_RISC = ITEMS.register("gpu_package_risc", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> GPU_PACKAGE_ASIC = ITEMS.register("gpu_package_asic", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GPU_PACKAGE_QUANTUM = ITEMS.register("gpu_package_quantum", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.create("LEGENDARY", ChatFormatting.DARK_AQUA))));
    public static final RegistryObject<Item> INTEGRATED_HEAT_SPREADER = ITEMS.register("integrated_heat_spreader", PropertyLessItem::new);
    public static final RegistryObject<Item> KEY_CAP = ITEMS.register("key_cap", PropertyLessItem::new);
    public static final RegistryObject<Item> KEY_SPRING = ITEMS.register("key_spring", PropertyLessItem::new);
    public static final RegistryObject<Item> MEGABIT = ITEMS.register("megabit", PropertyLessItem::new);
    public static final RegistryObject<Item> MEGABYTE = ITEMS.register("megabyte", PropertyLessItem::new);
    public static final RegistryObject<Item> MOLTEN_POLYCARBONATE_CONCENTRATE = ITEMS.register("molten_polycarbonate_concentrate", () -> new Polycarbonate(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<Item> PETABIT = ITEMS.register("petabit", PropertyLessItem::new);
    public static final RegistryObject<Item> PETABYTE = ITEMS.register("petabyte", PropertyLessItem::new);
    public static final RegistryObject<Item> POLYCARBONATE_CRYSTALLINE_DYE = ITEMS.register("polycarbonate_crystalline_dye", PropertyLessItem::new);
    public static final RegistryObject<Item> COLD_POLYCARBONATE_CONCENTRATE = ITEMS.register("cold_polycarbonate_concentrate", PropertyLessItem::new);
    public static final RegistryObject<Item> QUBIT = ITEMS.register("qubit", PropertyLessItem::new);
    public static final RegistryObject<Item> QUBYTE = ITEMS.register("qubyte", PropertyLessItem::new);
    public static final RegistryObject<Item> RAW_SILICADUST = ITEMS.register("raw_silicadust", PropertyLessItem::new);
    public static final RegistryObject<Item> RAW_POLYCARBONATE = ITEMS.register("raw_polycarbonate", PropertyLessItem::new);
    public static final RegistryObject<Item> SOLID_QUANTUM = ITEMS.register("solid_quantum", PropertyLessItem::new);
    public static final RegistryObject<Item> SOLDER_BLOB = ITEMS.register("solder_blob", PropertyLessItem::new);
    public static final RegistryObject<WrittenBookItem> STORY_BOOK = ITEMS.register("story_book", () -> new Entry1(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).stacksTo(1)));
    public static final RegistryObject<Item> SILICON_WAFER = ITEMS.register("silicon_wafer", () -> new WaferText(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).durability(4)));
    public static final RegistryObject<Item> URANIUM_SILICATE = ITEMS.register("uranium_silicate", PropertyLessItem::new);
    public static final RegistryObject<Item> URANIUM_SILICON_PLATE = ITEMS.register("uranium_silicon_plate", PropertyLessItem::new);
    public static final RegistryObject<Item> TRIURANIUM_OCTAOXIDE = ITEMS.register("triuranium_octaoxide", PropertyLessItem::new);
    public static final RegistryObject<Item> TERABIT = ITEMS.register("terabit", PropertyLessItem::new);
    public static final RegistryObject<Item> TERABYTE = ITEMS.register("terabyte", PropertyLessItem::new);
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", PropertyLessItem::new);
    public static final RegistryObject<Item> URANIUM_DIOXIDE = ITEMS.register("uranium_dioxide", PropertyLessItem::new);
    public static final RegistryObject<Item> URANIUM_MELT = ITEMS.register("uranium_melt", PropertyLessItem::new);
    public static final RegistryObject<Item> URANIUM_ISOTOPE238 = ITEMS.register("uranium_isotope238", PropertyLessItem::new);
    public static final RegistryObject<Item> URANIUM_ISOTOPE235 = ITEMS.register("uranium_isotope235", PropertyLessItem::new);
    //for tools
    public static final RegistryObject<Item> DIGITAL_SAMPLER = ITEMS.register("digital_sampler", () -> new ShovelItem(LyokoTiers.LyokoTool, 2, 2, new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<Item> TRUSTTY_SCREWDRIVER = ITEMS.register("trusty_screwdriver", () -> new TrustyScrewDriverItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<Item> SOLDERING_IRON = ITEMS.register("soldering_iron", () -> new soldering_iron(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final RegistryObject<Item> JEREMY_LAPTOP = ITEMS.register("jeremys_laptop", () -> new LaptopClass(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    //for weapons
    public static final RegistryObject<SwordItem> DIGITAL_SABER = ITEMS.register("digital_saber", () -> new SaberKatana(LyokoTiers.LyokoSamurai, 25, -0.9f, new Item.Properties().tab(CodeLyokoMain.LYOKO_WEAPONS)));
    public static final RegistryObject<BowItem> LASER_ARROWSHOOTER = ITEMS.register("laser_arrowshooter", () -> new LaserArrowShooter(new Item.Properties().tab(CodeLyokoMain.LYOKO_WEAPONS).durability(40).setNoRepair()));
    public static final RegistryObject<SwordItem> QUANTUM_SABER = ITEMS.register("quantum_saber", () -> new SwordItem(LyokoTiers.LyokoTool, 15, 2, new Item.Properties().tab(CodeLyokoMain.LYOKO_WEAPONS).durability(50).rarity(Rarity.EPIC)));
    public static final RegistryObject<TridentItem> YUMI_TRADITONAL_FANS = ITEMS.register("yumi_traditional_fans", () -> new YumiFans(new Item.Properties().tab(CodeLyokoMain.LYOKO_WEAPONS).durability(20).setNoRepair()));
    public static final RegistryObject<SwordItem> ZWEIHANDER = ITEMS.register("zweihander", () -> new ZweihanderWeapon(LyokoTiers.LyokoWarrior, 60, -3.9f, new Item.Properties().tab(CodeLyokoMain.LYOKO_WEAPONS)));
    public static final RegistryObject<BowItem> FORCE_FIELD_EMITTER = ITEMS.register("force_field_emitter", () -> new ForceFieldEmitter(new Item.Properties().tab(CodeLyokoMain.LYOKO_WEAPONS).rarity(Rarity.EPIC)));
    public static final RegistryObject<BowItem> ARCHER_BOW = ITEMS.register("archer_bow", () -> new ArcherClassBow(new Item.Properties().tab(CodeLyokoMain.LYOKO_WEAPONS).durability(40)));
    //for armor
    public static final RegistryObject<ArmorItem> AELITA_CHESTPLATE = ITEMS.register("aelita_chestplate", () -> new AelitaArmorElytra(LyokoArmorMaterial.GUARDIAN, EquipmentSlot.CHEST, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> AELITA_LEGGINGS = ITEMS.register("aelita_leggings", () -> new ArmorItem(LyokoArmorMaterial.GUARDIAN, EquipmentSlot.LEGS, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> AELITA_BOOTS = ITEMS.register("aelita_boots", () -> new ArmorItem(LyokoArmorMaterial.GUARDIAN, EquipmentSlot.FEET, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> ODD_CHESTPLATE = ITEMS.register("odd_chestplate", () -> new ArmorFeline(LyokoArmorMaterial.FELINE, EquipmentSlot.CHEST, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> ODD_LEGGINGS = ITEMS.register("odd_leggings", () -> new ArmorFeline(LyokoArmorMaterial.FELINE, EquipmentSlot.LEGS, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> ODD_BOOTS = ITEMS.register("odd_boots", () -> new ArmorFeline(LyokoArmorMaterial.FELINE, EquipmentSlot.FEET, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> ULRICH_HEADBAND = ITEMS.register("ulrich_headband", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlot.HEAD, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> ULRICH_CHESTPLATE = ITEMS.register("ulrich_chestplate", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlot.CHEST, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> ULRICH_LEGGINGS = ITEMS.register("ulrich_leggings", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlot.LEGS, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> ULRICH_BOOTS = ITEMS.register("ulrich_boots", () -> new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlot.FEET, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> BLANKHELMET = ITEMS.register("blank_helmet", () -> new ArmorItem(LyokoArmorMaterial.BLANKHELM, EquipmentSlot.HEAD, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR).setNoRepair()));
    public static final RegistryObject<ArmorItem> WILLIAM_CHESTPLATE = ITEMS.register("william_chestplate", () -> new ArmorWarrior(LyokoArmorMaterial.WARRIOR, EquipmentSlot.CHEST, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> WILLIAM_LEGGINGS = ITEMS.register("william_leggings", () -> new ArmorWarrior(LyokoArmorMaterial.WARRIOR, EquipmentSlot.LEGS, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> WILLIAM_BOOTS = ITEMS.register("william_boots", () -> new ArmorWarrior(LyokoArmorMaterial.WARRIOR, EquipmentSlot.FEET, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> YUMI_CHESTPLATE = ITEMS.register("yumi_chestplate", () -> new ArmorNinja(LyokoArmorMaterial.NINJA, EquipmentSlot.CHEST, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> YUMI_LEGGINGS = ITEMS.register("yumi_leggings", () -> new ArmorNinja(LyokoArmorMaterial.NINJA, EquipmentSlot.LEGS, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> YUMI_BOOTS = ITEMS.register("yumi_boots", () -> new ArmorNinja(LyokoArmorMaterial.NINJA, EquipmentSlot.FEET, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> MIND_HELMET = ITEMS.register("mind_helmet", () -> new MindHelm(LyokoArmorMaterial.BLANKHELM, EquipmentSlot.HEAD, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR).rarity(Rarity.EPIC)));
    public static final RegistryObject<ArmorItem> LINKER = ITEMS.register("linker", () -> new linker(LyokoArmorMaterial.LINKER, EquipmentSlot.CHEST, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR).rarity(Rarity.EPIC)));
    public static final RegistryObject<ArmorItem> JEREMY_CHESTPLATE = ITEMS.register("jeremy_chestplate", () -> new ArmorArcher(LyokoArmorMaterial.ARCHER, EquipmentSlot.CHEST, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> JEREMY_LEGGINGS = ITEMS.register("jeremy_leggings", () -> new ArmorArcher(LyokoArmorMaterial.ARCHER, EquipmentSlot.LEGS, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    public static final RegistryObject<ArmorItem> JEREMY_BOOTS = ITEMS.register("jeremy_boots", () -> new ArmorArcher(LyokoArmorMaterial.ARCHER, EquipmentSlot.FEET, new Item.Properties().tab(CodeLyokoMain.LYOKO_ARMOR)));
    //for buckets
    public static final RegistryObject<BucketItem> LIQUID_HELIUM_BUCKET = ITEMS.register("liquid_helium_bucket", () -> new BucketItem(() -> ModFluids.STILL_LIQUID_HELIUM.get(), new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).stacksTo(1)));
*/
}
