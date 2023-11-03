package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.*;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition.DigitalLavaBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition.DigitalSeaBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition.LiquidHelium;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition.UraniumWaste;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Sector.SectorEntrance;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.*;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculatorNetwork.CableBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculatorNetwork.DemarcationPoint;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.Electricity.LaptopCharger;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.Electricity.RackChargerBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.Electricity.UniversalEnergyBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.Lithography.LithographyMachine;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.electroplate.ElectroplatingMachine;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.flouride.ElectricFluorideInfuser;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.flouride.FluorideInfuser;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests.*;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;

public record ModBlocks() {
    //for blocks
    public static final Block ARCHITECTURE_WORK_STATION;
    public static final Block ANTI_MARABUNTA;
    public static final Block AUTUNITE_ORE;
    public static final Block ANODE_PART;
    public static final Block BLACK_VOID;
    public static final Block BORNITE_ORE;
    public static final Block CABLE_BLOCK;
    public static final Block COMPUTER_SCREEN_CONNECTOR;
    public static final Block CHALCOPYRITE_ORE;
    public static final Block COVELLITE_ORE;
    public static final Block CHALCOCITE_ORE;
    public static final Block COMPUTER_FRAME;
    public static final Block CENTRAL_CONTROL_UNIT;
    public static final Block COMPUTER_SCREEN;
    public static final Block COMPUTER_SCREEN_FRAME;
    public static final Block COMPUTER_CORE;
    public static final Block COMPUTER_KEYBOARD;
    public static final Block CHIPLET_BASIC_BLOCK;
    public static final Block CHIPLET_ADVANCED_BLOCK;
    public static final Block CHIPLET_FRANZ_BLOCK;
    public static final Block COMPUTER_COOLING_BLOCK;
    public static final Block COMPUTER_LIQUID_CIRCULATOR;
    public static final Block COMPUTER_LIQUID_PIPE;
    public static final Block COMPUTER_LIQUID_INTAKE_PUMP;
    public static final Block COMPUTER_FLUID_COOLER;
    public static final Block COMPUTER_TOWER_CONTROL_PANEL;
    public static final Block CATHODE_PART;
    public static final Block COFFINITE_ORE;
    public static final Block CARNOTITE_ORE;
    public static final Block DEMARCATION_POINT;
    public static final Block DATA_TRANSFER_INTERFACE;
    public static final Block DIGITAL_SEA_PYLON;
    public static final Block DIGITAL_GRASS;
    public static final Block DIGITAL_DIRT;
    public static final Block DIGITAL_ROCK;

    public static final Block DIGITAL_WOOD_FOREST;
    public static final Block DIGITAL_WOOD_MOUNTAIN;
    public static final Block DIGITAL_LEAF_MOUNTAIN;

    public static final Block DIGITAL_ICE;
    public static final Block DIGITAL_SAND;
    public static final Block DIGITAL_DARKNESS;
    public static final Block ELECTRIC_FLUORIDE_INFUSER;
    public static final Block EXTERNAL_ENERGY_ACCEPTOR;
    public static final Block ELECTROPLATING_MACHINE;
    public static final Block ELECTROPLATING_MACHINE_FRAME;
    public static final Block ELECTROPLATING_ANODE;
    public static final Block ELECTROPLATING_CATHODE;

    public static final Block FLUORIDE_INFUSER;
    public static final Block FLUORITE_BLOCK;
    public static final Block FLUORITE_ORE;
    public static final Block FALSE_WATER;
    public static final Block FRONTIER_BLOCK;
    public static final Block GUMMITE_ORE;
    public static final Block HOLOPROJECTOR;
    public static final Block LYOKO_CORE;
    public static final Block LITHOGRAPHY_MACHINE;
    public static final Block MARABUNTA;
    public static final Block METATYUYAMUNITE_ORE;
    public static final Block METATORBERNITE_ORE;
    public static final Block METAAUTUNITE_ORE;

    public static final Block PROJECTOR_FOCUS;
    public static final Block QUANTUM_BLOCK;
    public static final Block QUANTUM_CORE;
    public static final Block QUANTUM_STEEL_BLOCK;
    public static final Block RACK_CHARGER_BLOCK;
    public static final Block SALEEITE_ORE;
    public static final Block SCANNER_BASE;
    public static final Block SCANNER_FRAME;
    public static final Block SCANNER_TOP;
    public static final Block STORAGE;
    public static final Block SKLODOWSKITE_ORE;
    public static final Block SILICA_SAND;
    public static final Block SECTOR5_STEEL;
    public static final Block SECTOR_ENTRANCE_DESERT;
    public static final Block ROUTER;
    public static final Block TOWER_WHITE;
    public static final Block TOWER_INTERFACE;
    public static final Block TOWER_BASE;
    public static final Block TOWER_WALL;
    public static final Block TOWER_BLUE;
    public static final Block TOWER_TOP;
    public static final Block TOWER_WALL_CORNER;
    public static final Block TOWER_BASE_CORNER;
    public static final Block TOWER_BOTTOM;
    public static final Block TYUYAMUNITE_ORE;
    public static final Block TORBERNITE_ORE;
    public static final Block TOWER_ENTER;
    public static final Block TITANIUM;
    public static final Block URANIUM_REACTOR;
    public static final Block URANINITE_ORE;
    public static final Block URANIUM_BLOCK_238;
    public static final Block URANIUM_BLOCK_235;
    public static final Block URANIUM_CANISTER;
    public static final Block URANOPHANE_ORE;
    public static final Block UV_MACHINE;

    public static final Block UV_LIGHT;
    public static final Block VOLCANO_GROUND;
    public static final Block DIGITAL_OCEAN_BLOCK;
    public static final Block DIGITAL_LAVA_BLOCK;
    public static final Block URANIUM_WASTE_BLOCK;
    public static final Block LIQUID_HELIUM_BLOCK;
    public static final Block LAPTOP_CHARGER;
    public static final Block TESTUI;
    public static final Block TEST_PROFILE;
    public static final Block TEST_SPHERE;
    public static final Block TEST_VEHICLE_INTERFACE;
    public static final Block TEST_ITEM_PROJECTOR;

    static {
           ARCHITECTURE_WORK_STATION =  registerModBlocks("architecture_work_station", new ArchitectureWorkstation(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           ANTI_MARABUNTA = registerModBlocks("anti_marabunta",new AntiMarabunta());
           ANODE_PART = registerModBlocks("anodepart",new ElectroplatingRodParts(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           AUTUNITE_ORE = registerModBlocks("autunite_ore",new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
           BLACK_VOID = registerModBlocks("black_void",new BlackVoid());
           BORNITE_ORE = registerModBlocks("bornite_ore",new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
           CABLE_BLOCK = registerModBlocks("cable_block",new CableBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           COMPUTER_SCREEN_CONNECTOR = registerModBlocks("computer_screen_connector",new FenceBlock(
                   FabricBlockSettings.copyOf(Blocks.IRON_BARS)){
               @Override
               public BlockState getPlacementState(final ItemPlacementContext ctx) {
                   return this.getDefaultState().with(ComputerKeyboard.IS_SCREEN_FORMED, Boolean.FALSE);
               }

               @Override
               protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
                   super.appendProperties(builder.add(ComputerKeyboard.IS_SCREEN_FORMED));
               }
           });
           CHALCOPYRITE_ORE = registerExperienceDroppingOre("chalcopyrite_ore");
           COVELLITE_ORE = registerExperienceDroppingOre("covellite_ore");
           CHALCOCITE_ORE = registerExperienceDroppingOre("chalcocite_ore");
           COMPUTER_FRAME = registerGenericBlock("computer_frame");
           CENTRAL_CONTROL_UNIT = registerModBlocks("central_control_unit",new ComputerCoreUnit(
                   FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           COMPUTER_SCREEN = registerModBlocks("computer_screen",new Block(
                   FabricBlockSettings.copyOf(Blocks.GLASS).strength(1, Blocks.GLASS.getBlastResistance())
                           .sounds(BlockSoundGroup.GLASS)){
               @Override
               public BlockState getPlacementState(final ItemPlacementContext ctx) {
                   return this.getDefaultState().with(ComputerKeyboard.IS_SCREEN_FORMED, Boolean.FALSE);
               }
               @Override
               protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
                   super.appendProperties(builder.add(ComputerKeyboard.IS_SCREEN_FORMED));
               }
           });
           COMPUTER_SCREEN_FRAME = registerModBlocks("computer_screen_frame",new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)){
               @Override
               public BlockState getPlacementState(final ItemPlacementContext ctx) {
                   return this.getDefaultState().with(ComputerKeyboard.IS_SCREEN_FORMED, Boolean.FALSE);
               }
               @Override
               protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
                   super.appendProperties(builder.add(ComputerKeyboard.IS_SCREEN_FORMED));
               }
           });
           COMPUTER_CORE = registerModBlocks("computer_core",new ComputerCoreUnit(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           COMPUTER_KEYBOARD = registerModBlocks("computer_keyboard",new ComputerKeyboard());
           CHIPLET_BASIC_BLOCK = registerGenericBlock("chiplet_basic_block");
           CHIPLET_ADVANCED_BLOCK = registerModBlocks("chiplet_advanced_block",new ChipletAdvancedBlock(
                   FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));
           CHIPLET_FRANZ_BLOCK = registerModBlocks("chiplet_franz_block",new FranzChiplet(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           COMPUTER_COOLING_BLOCK = registerModBlocks("computer_cooling_block",new CoolingBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           COMPUTER_LIQUID_CIRCULATOR = registerModBlocks("computer_liquid_circulator",new ComputerFluidCirculator(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           COMPUTER_LIQUID_PIPE = registerModBlocks("computer_liquid_pipe",new BaseComputerPipe(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           COMPUTER_LIQUID_INTAKE_PUMP = registerModBlocks("computer_fluid_intake",new ComputerIntakePump(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           COMPUTER_FLUID_COOLER = registerModBlocks("computer_fluid_cooler",new ComputerFluidCooler(FabricBlockSettings.copyOf(Blocks.IRON_BARS)));
           COMPUTER_TOWER_CONTROL_PANEL = registerModBlocks("computer_tower_control_panel",new ControlPanel());
           CATHODE_PART = registerModBlocks("cathodepart",new ElectroplatingRodParts(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           COFFINITE_ORE = registerExperienceDroppingOre("coffinite_ore");
           CARNOTITE_ORE = registerExperienceDroppingOre("carnotite_ore",FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE));
           DEMARCATION_POINT = registerModBlocks("demarcation_point",new DemarcationPoint(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           DATA_TRANSFER_INTERFACE = registerModBlocks("data_transfer_interface",new DataTransferInterface());
           DIGITAL_SEA_PYLON = registerModBlocks("digital_sea_pylon",new SeaPylon());
           DIGITAL_GRASS = registerGenericBlock("digital_grass",
                   FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).allowsSpawning((state, world, pos, type) -> true)
                           .strength(-1, Integer.MAX_VALUE));
           DIGITAL_DIRT = registerModBlocks("digital_dirt",new Block(FabricBlockSettings.copyOf(Blocks.DIRT).strength(-1,
                   Integer.MAX_VALUE)));
           DIGITAL_ROCK = registerGenericBlock("digital_rock",FabricBlockSettings.copyOf(Blocks.STONE).strength(-1, Integer.MAX_VALUE)
                   .allowsSpawning((state, world, pos, type) -> true));
           DIGITAL_WOOD_FOREST = registerModBlocks("digital_wood_forest",new Block(
                   FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(-1, Integer.MAX_VALUE)));
           DIGITAL_WOOD_MOUNTAIN = registerGenericBlock("digital_wood_mountain",FabricBlockSettings.copyOf(Blocks.JUNGLE_WOOD));
           DIGITAL_LEAF_MOUNTAIN = registerModBlocks("digital_leaf_mountain",new LeavesBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_LEAVES)));
           DIGITAL_ICE = registerModBlocks("digital_ice",new IceBlock(FabricBlockSettings.copyOf(Blocks.ICE).strength(-1, Integer.MAX_VALUE)));
           DIGITAL_SAND = registerGenericBlock("digital_sand",
                   FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).strength(-1, Integer.MAX_VALUE));
           DIGITAL_DARKNESS = registerGenericBlock("digital_darkness",FabricBlockSettings.copyOf(Blocks.DRAGON_EGG).strength(-1,
                   Integer.MAX_VALUE));
           ELECTRIC_FLUORIDE_INFUSER = registerModBlocks("electric_fluoride_infuser",new ElectricFluorideInfuser());
           EXTERNAL_ENERGY_ACCEPTOR = registerModBlocks("external_energy_acceptor",new ExternalPowerAcceptor(
                   FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           ELECTROPLATING_MACHINE = registerModBlocks("electroplating_machine",new ElectroplatingMachine(
                   FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           ELECTROPLATING_MACHINE_FRAME = registerGenericBlock("electroplating_machine_frame");
           ELECTROPLATING_ANODE = registerModBlocks("electroplating_anode",new ElectroplatingRodImplements(
                   FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           ELECTROPLATING_CATHODE = registerModBlocks("electroplating_cathode",new ElectroplatingRodImplements(
                   FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           FLUORIDE_INFUSER = registerModBlocks("fluoride_infuser",new FluorideInfuser());
           FLUORITE_BLOCK = registerGenericBlock("fluorite_block",
                   FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).strength(-1, 10)
                           .sounds(BlockSoundGroup.SAND));
           FLUORITE_ORE = registerExperienceDroppingOre("fluorite_ore",
                   FabricBlockSettings.copyOf(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
           FALSE_WATER = registerGenericBlock("false_water",FabricBlockSettings.copyOf(Blocks.WATER).noCollision());
           FRONTIER_BLOCK = registerModBlocks("frontier_block",new FrontierBlock());
           GUMMITE_ORE = registerExperienceDroppingOre("gummite_ore", FabricBlockSettings.copyOf(Blocks.STONE).strength(3, 10).sounds(BlockSoundGroup.STONE));
           HOLOPROJECTOR = registerModBlocks("holoprojector",new HologramProjectorBlock());
           LYOKO_CORE = registerModBlocks("core_of_lyoko",new LyokoCore(
                   FabricBlockSettings.copyOf(Blocks.DRAGON_EGG).dropsNothing().nonOpaque().strength(-1, -1)
                           .luminance(Blocks.GLOWSTONE.getDefaultState().getLuminance())));
           LITHOGRAPHY_MACHINE = registerModBlocks("lithography_machine",new LithographyMachine(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           MARABUNTA = registerModBlocks("marabunta",new Marabunta());
           METATYUYAMUNITE_ORE = registerExperienceDroppingOre("metatyuyamunite_ore");
           METATORBERNITE_ORE = registerExperienceDroppingOre("metatorbernite_ore",FabricBlockSettings.copyOf(METATYUYAMUNITE_ORE));
           METAAUTUNITE_ORE = registerExperienceDroppingOre("metaautunite_ore",FabricBlockSettings.copyOf(AUTUNITE_ORE));
           PROJECTOR_FOCUS = registerModBlocks("projector_focus",new ProjectorFocusblock());
           QUANTUM_BLOCK = registerGenericBlock("quantum_block",
                   FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL).strength(8, 20));
           QUANTUM_CORE = registerGenericBlock("quantum_core",FabricBlockSettings.copyOf(Blocks.END_PORTAL));
           QUANTUM_STEEL_BLOCK = registerModBlocks("quantum_steel",new QuantumSteelBlock(
                   FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(6, 20).sounds(BlockSoundGroup.METAL)));
           RACK_CHARGER_BLOCK = registerModBlocks("rack_charger",new RackChargerBlock(FabricBlockSettings.copyOf(Blocks.REDSTONE_BLOCK)));
           SALEEITE_ORE = registerExperienceDroppingOre("saleeite_ore",
                   FabricBlockSettings.copyOf(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
           SCANNER_BASE = registerModBlocks("scanner_base",new Scanner());
           SCANNER_FRAME = registerModBlocks("scanner_frame",new ScannerFrame(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           SCANNER_TOP = registerModBlocks("scanner_top",new ScannerTop(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           STORAGE = registerModBlocks("universal",new UniversalEnergyBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
           SKLODOWSKITE_ORE = registerGenericBlock("sklodowskite_ore",
                   FabricBlockSettings.copyOf(Blocks.STONE).strength(4, 4).sounds(BlockSoundGroup.STONE));
           SILICA_SAND = registerModBlocks("silica_sand",new SandBlock(0xFFFFFF, FabricBlockSettings.copy(Blocks.SAND)));
           SECTOR5_STEEL = registerGenericBlock("sector5_steel",FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(-1,
                   Integer.MAX_VALUE));
           SECTOR_ENTRANCE_DESERT = registerModBlocks("desert_sector_entrance",new SectorEntrance(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), SectorEntrance.SELECTORS.DESERT));
           ROUTER = registerModBlocks("router",new Router(FabricBlockSettings.copyOf(Blocks.DRAGON_EGG)));
           TOWER_INTERFACE = registerModBlocks("tower_interface",new TowerInterface());
           TOWER_WHITE = registerGenericBlock("tower_white",FabricBlockSettings.copyOf(Blocks.BARRIER).strength(-1, Integer.MAX_VALUE).sounds(BlockSoundGroup.GLASS).luminance(250));
           TOWER_BASE = registerModBlocks("tower_base",new TowerWall());
           TOWER_WALL = registerModBlocks("tower_wall",new TowerWall());
           TOWER_BLUE = registerGenericBlock("tower_blue",FabricBlockSettings.copyOf(Blocks.BARRIER).strength(-1,
                   Integer.MAX_VALUE).sounds(BlockSoundGroup.GLASS).luminance(250));
           TOWER_TOP = registerGenericBlock("tower_top",FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(-1, Integer.MAX_VALUE).sounds(BlockSoundGroup.GLASS));
           TOWER_WALL_CORNER = registerModBlocks("tower_wall_corner",new TowerWallCorner());
           TOWER_BASE_CORNER = registerModBlocks("tower_base_corner",new TowerWallCorner());
           TOWER_BOTTOM = registerModBlocks("tower_bottom",new TowerBottomBlock(
                   FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.GLASS)));
           TYUYAMUNITE_ORE = registerExperienceDroppingOre("tyuyamunite_ore",FabricBlockSettings.copyOf(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
           TORBERNITE_ORE = registerExperienceDroppingOre("torbernite_ore",FabricBlockSettings.copyOf(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
           TOWER_ENTER = registerModBlocks("tower_enter",new TowerEnter());
           TITANIUM = registerGenericBlock("titanium_block",
                   FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(6, 10).sounds(BlockSoundGroup.METAL));
           URANIUM_REACTOR = registerModBlocks("computer_reactor",new ComputerIntegratedReactor());
           URANINITE_ORE = registerExperienceDroppingOre("uraninite_ore",FabricBlockSettings.copyOf(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
           URANIUM_BLOCK_238 = registerGenericBlock("uranium_block_238", FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(6, 20).sounds(BlockSoundGroup.METAL));
           URANIUM_BLOCK_235 = registerGenericBlock("uranium_block_235",FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(6, 20).sounds(BlockSoundGroup.METAL));
           URANIUM_CANISTER = registerModBlocks("uranium_canister",new UraniumCanister(
                   FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(5, 5)));
           URANOPHANE_ORE = registerGenericBlock("uranophane_ore",FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).strength(4, 4));
           UV_MACHINE = registerGenericBlock("uv_machine",FabricBlockSettings.copyOf(Blocks.ANVIL));
           UV_LIGHT = registerGenericBlock("uv_light",FabricBlockSettings.copyOf(Blocks.GLOWSTONE));
           VOLCANO_GROUND = registerGenericBlock("volcano_ground",FabricBlockSettings.copyOf(Blocks.STONE));
           DIGITAL_OCEAN_BLOCK = registerModBlocks("digital_ocean",new DigitalSeaBlock());
           DIGITAL_LAVA_BLOCK = registerModBlocks("digital_lava",new DigitalLavaBlock());
           URANIUM_WASTE_BLOCK = registerModBlocks("uranium_waste",new UraniumWaste());
           LIQUID_HELIUM_BLOCK = registerModBlocks("liquid_helium",new LiquidHelium());
           LAPTOP_CHARGER = registerModBlocks("laptop_charger",new LaptopCharger(FabricBlockSettings.copy(Blocks.ANVIL)));
           TESTUI = registerModBlocks("test_ui",new TestComputerUI(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));
           TEST_PROFILE = registerModBlocks("player_profile_block",new PlayerCustomProfileTest(FabricBlockSettings.copyOf(Blocks.BARRIER)));
           TEST_SPHERE = registerModBlocks("test_sphere",new TestSphereRenderer(FabricBlockSettings.copyOf(Blocks.BARRIER)));
           TEST_VEHICLE_INTERFACE = registerModBlocks("test_vehicle_materialization",new PlayerVehicleTest(FabricBlockSettings.copyOf(Blocks.BARRIER)));
           TEST_ITEM_PROJECTOR = registerModBlocks("test_item_projector",new ItemProjectorTest());

    }
    private static boolean blockBlacklist(final Block block)
    {
        final Class<?>[] blacklistedBlocks = {
                LyokoCore.class,
                DigitalLavaBlock.class,
                DigitalSeaBlock.class,
                LiquidHelium.class,
                UraniumWaste.class
        };
        for(final Class<?> blackListedBlock : blacklistedBlocks)
        {
            if(block.getClass() == blackListedBlock)
            {
                return true;
            }
        }
        return false;
    }
    private static void registerBlockItems(final Identifier name,final Block block)
    {
        if(!blockBlacklist(block))
        {
            final BlockItem blockItem = new BlockItem(block,new FabricItemSettings());
            Registry.register(Registries.ITEM,name,blockItem);
            final RegistryKey<ItemGroup> registryKey = RegistryKey.of(Registries.ITEM_GROUP.getKey(), CodeLyokoMain.codeLyokoPrefix("lyoko_blocks"));
            ItemGroupEvents.modifyEntriesEvent(registryKey).register(entries -> entries.add(blockItem));
        }
    }
    private static Block registerExperienceDroppingOre(final String name)
    {
        final Block block = new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE));
        return registerModBlocks(name,block);
    }
    private static Block registerExperienceDroppingOre(final String name,final FabricBlockSettings settings)
    {
        final Block block = new ExperienceDroppingBlock(settings);
        return registerModBlocks(name,block);
    }
    private static Block registerGenericBlock(final String name)
    {
       final Block block = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
       return registerModBlocks(name,block);
    }
    private static Block registerGenericBlock(final String name,final FabricBlockSettings fabricBlockSettings)
    {
        final Block block = new Block(fabricBlockSettings);
        return registerModBlocks(name,block);
    }
    private static Block registerModBlocks(final String name,final Block block)
    {
        final Identifier id = CodeLyokoMain.codeLyokoPrefix(name);
        final Block registeredBlock = Blocks.register(id,block);
        registerBlockItems(id,registeredBlock);
        return registeredBlock;
    }
    public static void registerBlocks()
    {

    }

}