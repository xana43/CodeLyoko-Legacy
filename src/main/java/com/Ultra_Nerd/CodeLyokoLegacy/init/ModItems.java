package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.enums.LyokoArmorMaterial;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.enums.LyokoTiers;
import com.Ultra_Nerd.CodeLyokoLegacy.items.*;
import com.Ultra_Nerd.CodeLyokoLegacy.items.armor.*;
import com.Ultra_Nerd.CodeLyokoLegacy.items.tools.*;
import com.google.common.collect.ImmutableMap;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Arm;
import net.minecraft.util.Rarity;

import java.util.HashMap;
import java.util.Map;

public final class ModItems {


    //public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CodeLyokoMain.MOD_ID);


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
    public static final Item APU_PACKAGE_ARM = new ComputerItem(BaseSettings);
    //public static final RegistryObject<Item> APU_PACKAGE_ARM = ITEMS.register("apu_package_arm", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final Item APU_PACKAGE_x86 = new ComputerItem(BaseSettings.rarity(Rarity.UNCOMMON));//ITEMS.register("", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.UNCOMMON)));
    public static final Item APU_PACKAGE_ASIC = new ComputerItem(BaseSettings.rarity(Rarity.RARE));//ITEMS.register("apu_package_asic", () -> new ComputerItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).rarity(Rarity.RARE)));
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
*/    public static final WrittenBookItem STORY_BOOK = new Entry1(BaseSettings.maxCount(1));
    public static final Item SILICON_WAFER = new WaferText(BaseSettings.maxDamage(4));
    public static final Item URANIUM_SILICATE = new PropertyLessItem();
    public static final Item URANIUM_SILICON_PLATE = new PropertyLessItem();
    public static final Item TRIURANIUM_OCTAOXIDE = new PropertyLessItem();
    public static final Item TERABIT = new PropertyLessItem();
    public static final Item TERABYTE = new PropertyLessItem();
    public static final Item TITANIUM_INGOT = new PropertyLessItem();
    public static final Item URANIUM_DIOXIDE = new PropertyLessItem();
    public static final Item URANIUM_MELT = new PropertyLessItem();
    public static final Item URANIUM_ISOTOPE238 = new PropertyLessItem();
    public static final Item URANIUM_ISOTOPE235 = new PropertyLessItem();
    //for tools
   // public static final RegistryObject<Item> DIGITAL_SAMPLER = ITEMS.register("digital_sampler", () -> new ShovelItem(LyokoTiers.LyokoTool, 2, 2, new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    //public static final RegistryObject<Item> TRUSTTY_SCREWDRIVER = ITEMS.register("trusty_screwdriver", () -> new TrustyScrewDriverItem(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    //public static final RegistryObject<Item> SOLDERING_IRON = ITEMS.register("soldering_iron", () -> new soldering_iron(new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS)));
    public static final Item JEREMY_LAPTOP = new LaptopClass(new FabricItemSettings().group(CodeLyokoMain.LYOKO_ITEM));
    //for weapons
    private static final FabricItemSettings WEAPONS = new FabricItemSettings().group(CodeLyokoMain.LYOKO_WEAPONS);
    public static final SwordItem DIGITAL_SABER = new SaberKatana(LyokoTiers.LyokoSamurai, 25, -0.9f, WEAPONS);
    public static final BowItem LASER_ARROWSHOOTER = new LaserArrowShooter(WEAPONS);
    public static final SwordItem QUANTUM_SABER = new SwordItem(LyokoTiers.LyokoTool, 15, 2, WEAPONS.rarity(Rarity.EPIC));
    public static final TridentItem YUMI_TRADITONAL_FANS = new YumiFans(WEAPONS);
    public static final SwordItem ZWEIHANDER = new ZweihanderWeapon(LyokoTiers.LyokoWarrior, 60, -3.9f, WEAPONS);
    public static final BowItem FORCE_FIELD_EMITTER = new ForceFieldEmitter(WEAPONS.rarity(Rarity.EPIC));
    public static final BowItem ARCHER_BOW = new ArcherClassBow(WEAPONS);
  //for armor
    private static final FabricItemSettings ArmorGroup = new FabricItemSettings().group(CodeLyokoMain.LYOKO_ARMOR);
    public static final ArmorItem AELITA_CHESTPLATE = new AelitaArmorElytra(LyokoArmorMaterial.GUARDIAN, EquipmentSlot.CHEST, ArmorGroup);
    public static final ArmorItem AELITA_LEGGINGS = new ArmorItem(LyokoArmorMaterial.GUARDIAN, EquipmentSlot.LEGS, ArmorGroup);
    public static final ArmorItem AELITA_BOOTS = new ArmorItem(LyokoArmorMaterial.GUARDIAN, EquipmentSlot.FEET, ArmorGroup);

    public static final ArmorItem ODD_CHESTPLATE = new ArmorFeline(LyokoArmorMaterial.FELINE, EquipmentSlot.CHEST, ArmorGroup);
    public static final ArmorItem ODD_LEGGINGS = new ArmorFeline(LyokoArmorMaterial.FELINE, EquipmentSlot.LEGS, ArmorGroup);
    public static final ArmorItem ODD_BOOTS = new ArmorFeline(LyokoArmorMaterial.FELINE, EquipmentSlot.FEET, ArmorGroup);
    public static final ArmorItem ULRICH_HEADBAND = new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlot.HEAD, ArmorGroup);
    public static final ArmorItem ULRICH_CHESTPLATE = new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlot.CHEST, ArmorGroup);
    public static final ArmorItem ULRICH_LEGGINGS = new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlot.LEGS, ArmorGroup);
    public static final ArmorItem ULRICH_BOOTS = new ArmorItem(LyokoArmorMaterial.SAMURAI, EquipmentSlot.FEET, ArmorGroup);
    public static final ArmorItem BLANKHELMET = new ArmorItem(LyokoArmorMaterial.BLANKHELM, EquipmentSlot.HEAD, ArmorGroup);
    public static final ArmorItem WILLIAM_CHESTPLATE = new ArmorWarrior(LyokoArmorMaterial.WARRIOR, EquipmentSlot.CHEST, ArmorGroup);
    public static final ArmorItem WILLIAM_LEGGINGS = new ArmorWarrior(LyokoArmorMaterial.WARRIOR, EquipmentSlot.LEGS, ArmorGroup);
    public static final ArmorItem WILLIAM_BOOTS = new ArmorWarrior(LyokoArmorMaterial.WARRIOR, EquipmentSlot.FEET, ArmorGroup);
    public static final ArmorItem YUMI_CHESTPLATE = new ArmorNinja(LyokoArmorMaterial.NINJA, EquipmentSlot.CHEST, ArmorGroup);
    public static final ArmorItem YUMI_LEGGINGS = new ArmorNinja(LyokoArmorMaterial.NINJA, EquipmentSlot.LEGS, ArmorGroup);
    public static final ArmorItem YUMI_BOOTS = new ArmorNinja(LyokoArmorMaterial.NINJA, EquipmentSlot.FEET, ArmorGroup);
    public static final ArmorItem MIND_HELMET = new MindHelm(LyokoArmorMaterial.BLANKHELM, EquipmentSlot.HEAD, ArmorGroup.rarity(Rarity.EPIC));
    public static final ArmorItem LINKER = new linker(LyokoArmorMaterial.LINKER, EquipmentSlot.CHEST, ArmorGroup.rarity(Rarity.EPIC));
    public static final ArmorItem JEREMY_CHESTPLATE = new ArmorArcher(LyokoArmorMaterial.ARCHER, EquipmentSlot.CHEST, ArmorGroup);
    public static final ArmorItem JEREMY_LEGGINGS = new ArmorArcher(LyokoArmorMaterial.ARCHER, EquipmentSlot.LEGS, ArmorGroup);
    public static final ArmorItem JEREMY_BOOTS = new ArmorArcher(LyokoArmorMaterial.ARCHER, EquipmentSlot.FEET, ArmorGroup);
    //for buckets
   // public static final RegistryObject<BucketItem> LIQUID_HELIUM_BUCKET = ITEMS.register("liquid_helium_bucket", () -> new BucketItem(() -> ModFluids.STILL_LIQUID_HELIUM.get(), new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).stacksTo(1)));


    public static final ImmutableMap<String,Item> ITEM_MAP = ImmutableMap.<String,Item>builder()

//Items
           .put("apu_package_arm",APU_PACKAGE_ARM)
           .put("apu_package_x86",APU_PACKAGE_x86)
           .put("apu_package_asic",APU_PACKAGE_ASIC)
           .put("apu_package_risc",APU_PACKAGE_RISC)
           .put("apu_die_arm",APU_DIE_ARM)
           .put("apu_die_x86",APU_DIE_x86)
           .put("apu_die_asic",APU_DIE_ASIC)
            //other computer components
           .put("bit",BIT)
            .put("story_book",STORY_BOOK)
            .put("silicon_wafer",SILICON_WAFER)
            .put("uranium_silicate",URANIUM_SILICATE)
            .put("uranium_silicon_plate",URANIUM_SILICON_PLATE)
            .put("triuranium_octaoxide",TRIURANIUM_OCTAOXIDE)
            .put("terabit",TERABIT)
            .put("terabyte",TERABYTE)
            .put("titanium_ingot",TITANIUM_INGOT)
            .put("uranium_dioxide",URANIUM_DIOXIDE)
            .put("uranium_melt",URANIUM_MELT)
            .put("uranium_isotope238",URANIUM_ISOTOPE238)
            .put("uranium_isotope235",URANIUM_ISOTOPE235)
            //tools
            .put("jeremys_laptop",JEREMY_LAPTOP)
            //weapons
            .put("digital_saber",DIGITAL_SABER)
            .put("laser_arrowshooter",LASER_ARROWSHOOTER)
            .put("quantum_saber",QUANTUM_SABER)
            .put("yumi_traditional_fans",YUMI_TRADITONAL_FANS)
            .put("zweihander",ZWEIHANDER)
            .put("force_field_emitter",FORCE_FIELD_EMITTER)
            .put("archer_bow",ARCHER_BOW)
           //armor
           .put("aelita_chestplate",AELITA_CHESTPLATE)
           .put("aelita_leggings",AELITA_LEGGINGS)
            .put("aelita_boots",AELITA_BOOTS)
            .put("odd_chestplate",ODD_CHESTPLATE)
            .put("odd_leggings",ODD_LEGGINGS)
            .put("odd_boots",ODD_BOOTS)
            .put("ulrich_headband",ULRICH_HEADBAND)
            .put("ulrich_chestplate",ULRICH_CHESTPLATE)
            .put("ulrich_leggings",ULRICH_LEGGINGS)
            .put("ulrich_boots",ULRICH_BOOTS)
            .put("blank_helmet",BLANKHELMET)
            .put("william_chestplate",WILLIAM_CHESTPLATE)
            .put("william_leggings",WILLIAM_LEGGINGS)
            .put("william_boots",WILLIAM_BOOTS)
            .put("yumi_chestplate",YUMI_CHESTPLATE)
            .put("yumi_leggings",YUMI_LEGGINGS)
            .put("yumi_boots",YUMI_BOOTS)
            .put("mind_helmet",MIND_HELMET)
            .put("linker",LINKER)
            .put("jeremy_chestplate",JEREMY_CHESTPLATE)
            .put("jeremy_leggings",JEREMY_LEGGINGS)
            .put("jeremy_boots",JEREMY_BOOTS)
            .put("lyokodisc",new LyokoDisc())
           .build();

    private static final class LyokoDisc extends MusicDiscItem
    {

        public LyokoDisc() {
            super(0, new SoundEvent(CodeLyokoMain.CodeLyokoPrefix("lyoko")), new Settings().group(CodeLyokoMain.LYOKO_ITEM).maxCount(1));
        }
    }
}
