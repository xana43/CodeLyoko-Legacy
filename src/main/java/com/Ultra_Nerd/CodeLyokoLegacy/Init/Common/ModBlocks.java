package com.Ultra_Nerd.CodeLyokoLegacy.Init.Common;

import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Decoration.OxidizeableFenceBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.definition.DigitalLavaBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.definition.DigitalSeaBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.definition.LiquidHelium;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.definition.UraniumWaste;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Machine.Electricity.LaptopCharger;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Machine.Electricity.RackChargerBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Machine.Electricity.UniversalEnergyBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Machine.Lithography.LithographyMachine;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Machine.Lithography.LithographyMachineT2;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Machine.electroplate.ElectroplatingMachine;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Machine.flouride.ElectricFluorideInfuser;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Machine.flouride.FluorideInfuser;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Sector.SectorEntrance;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.SuperCalculator.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.SuperCalculatorNetwork.CableBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.SuperCalculatorNetwork.DemarcationPoint;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Tests.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Tower.*;
import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.Enums.DimensionSelector;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

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
    public static final Block CASSERITE_ORE;
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
    public static final Block ERODED_IRON_RAILING;

    public static final Block FLUORIDE_INFUSER;
    public static final Block FLUORITE_BLOCK;
    public static final Block FLUORITE_ORE;
    public static final Block FALSE_WATER;
    public static final Block FRONTIER_BLOCK;
    public static final Block GUMMITE_ORE;
    public static final Block HOLOPROJECTOR;
    public static final Block IRON_RAILING;
    public static final Block LYOKO_CORE;
    public static final Block LITHOGRAPHY_MACHINE;
    public static final Block LITHOGRAPHY_MACHINET2;
    public static final Block MARABUNTA;
    public static final Block METATYUYAMUNITE_ORE;
    public static final Block METATORBERNITE_ORE;
    public static final Block METAAUTUNITE_ORE;

    public static final Block PROJECTOR_FOCUS;
    public static final Block QUANTUM_BLOCK;
    public static final Block QUANTUM_CORE;
    public static final Block QUANTUM_STEEL_BLOCK;
    public static final Block RACK_CHARGER_BLOCK;
    public static final Block RUTILE_ORE;
    public static final Block ROUTER;
    public static final Block RUSTED_IRON_RAILING;
    public static final Block SALEEITE_ORE;
    public static final Block SCANNER_BASE;
    public static final Block SCANNER_FRAME;
    public static final Block SCANNER_TOP;
    public static final Block STORAGE;
    public static final Block SKLODOWSKITE_ORE;
    public static final Block SILICA_SAND;
    public static final Block SECTOR5_STEEL;
    public static final Block SECTOR_ENTRANCE_DESERT;
    public static final Block TARNISHED_IRON_RAILING;
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
    public static final Block WAXED_IRON_RAILING;
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
           ARCHITECTURE_WORK_STATION = registerModBlocks("architecture_work_station", new ArchitectureWorkstation(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           ANTI_MARABUNTA = registerModBlocks("anti_marabunta",new AntiMarabunta(AbstractBlock.Settings.create().strength(6, 10).sounds(BlockSoundGroup.STONE).ticksRandomly()));
           ANODE_PART = registerModBlocks("anodepart",new ElectroplatingRodParts(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           AUTUNITE_ORE = registerModBlocks("autunite_ore",new ExperienceDroppingBlock(UniformIntProvider.create(0,1),AbstractBlock.Settings.copy(Blocks.IRON_ORE)));
           BLACK_VOID = registerModBlocks("black_void",new BlackVoid());
           BORNITE_ORE = registerModBlocks("bornite_ore",new ExperienceDroppingBlock(UniformIntProvider.create(0,1),AbstractBlock.Settings.copy(Blocks.IRON_ORE)));
           CABLE_BLOCK = registerModBlocks("cable_block",new CableBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           COMPUTER_SCREEN_CONNECTOR = registerModBlocks("computer_screen_connector",new FenceBlock(
                   AbstractBlock.Settings.copy(Blocks.IRON_BARS)){
               @Override
               public BlockState getPlacementState(final ItemPlacementContext ctx) {
                       return this.getDefaultState().with(ComputerKeyboard.IS_SCREEN_FORMED, Boolean.FALSE);

               }

               @Override
               protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
                   super.appendProperties(builder.add(ComputerKeyboard.IS_SCREEN_FORMED));               }
           });
           CHALCOPYRITE_ORE = registerExperienceDroppingOre("chalcopyrite_ore",UniformIntProvider.create(0,1));
           COVELLITE_ORE = registerExperienceDroppingOre("covellite_ore",UniformIntProvider.create(0,1));
           CHALCOCITE_ORE = registerExperienceDroppingOre("chalcocite_ore",UniformIntProvider.create(0,1));
           COMPUTER_FRAME = registerGenericBlock("computer_frame");
           CENTRAL_CONTROL_UNIT = registerModBlocks("central_control_unit",new ComputerCoreUnit(
                   AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           COMPUTER_SCREEN = registerModBlocks("computer_screen",new Block(
                   AbstractBlock.Settings.copy(Blocks.GLASS).strength(1, Blocks.GLASS.getBlastResistance())
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
           COMPUTER_SCREEN_FRAME = registerModBlocks("computer_screen_frame",new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)){
               @Override
               public BlockState getPlacementState(final ItemPlacementContext ctx) {
                   return this.getDefaultState().with(ComputerKeyboard.IS_SCREEN_FORMED, Boolean.FALSE);
               }
               @Override
               protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
                   super.appendProperties(builder.add(ComputerKeyboard.IS_SCREEN_FORMED));
               }
           });
           COMPUTER_CORE = registerModBlocks("computer_core",new ComputerCoreUnit(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           COMPUTER_KEYBOARD = registerModBlocks("computer_keyboard",new ComputerKeyboard());
           CHIPLET_BASIC_BLOCK = registerGenericBlock("chiplet_basic_block");
           CHIPLET_ADVANCED_BLOCK = registerModBlocks("chiplet_advanced_block",new ChipletAdvancedBlock(
                   AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).nonOpaque()));
           CHIPLET_FRANZ_BLOCK = registerModBlocks("chiplet_franz_block",new FranzChiplet(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           COMPUTER_COOLING_BLOCK = registerModBlocks("computer_cooling_block",new CoolingBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           COMPUTER_LIQUID_CIRCULATOR = registerModBlocks("computer_liquid_circulator",new ComputerFluidCirculator(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           COMPUTER_LIQUID_PIPE = registerModBlocks("computer_liquid_pipe",new BaseComputerPipe(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           COMPUTER_LIQUID_INTAKE_PUMP = registerModBlocks("computer_fluid_intake",new ComputerIntakePump(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           COMPUTER_FLUID_COOLER = registerModBlocks("computer_fluid_cooler",new ComputerFluidCooler(AbstractBlock.Settings.copy(Blocks.IRON_BARS)));
           COMPUTER_TOWER_CONTROL_PANEL = registerModBlocks("computer_tower_control_panel",new ControlPanel());
           CATHODE_PART = registerModBlocks("cathodepart",new ElectroplatingRodParts(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           COFFINITE_ORE = registerExperienceDroppingOre("coffinite_ore",UniformIntProvider.create(0,1));
           CASSERITE_ORE = registerExperienceDroppingOre("casserite_ore", AbstractBlock.Settings.copy(Blocks.COPPER_ORE),UniformIntProvider.create(0,1));
           CARNOTITE_ORE = registerExperienceDroppingOre("carnotite_ore",AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE),UniformIntProvider.create(0,1));
           DEMARCATION_POINT = registerModBlocks("demarcation_point",new DemarcationPoint(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           DATA_TRANSFER_INTERFACE = registerModBlocks("data_transfer_interface",new DataTransferInterface());
           DIGITAL_SEA_PYLON = registerModBlocks("digital_sea_pylon",new SeaPylon());
           DIGITAL_GRASS = registerGenericBlock("digital_grass",
                   AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK).allowsSpawning((state, world, pos, type) -> true)
                           .strength(-1, Integer.MAX_VALUE));
           DIGITAL_DIRT = registerModBlocks("digital_dirt",new Block(AbstractBlock.Settings.copy(Blocks.DIRT).strength(-1,
                   Integer.MAX_VALUE)));
           DIGITAL_ROCK = registerGenericBlock("digital_rock",AbstractBlock.Settings.copy(Blocks.STONE).strength(-1, Integer.MAX_VALUE)
                   .allowsSpawning((state, world, pos, type) -> true));
           DIGITAL_WOOD_FOREST = registerModBlocks("digital_wood_forest",new Block(
                   AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(-1, Integer.MAX_VALUE)));
           DIGITAL_WOOD_MOUNTAIN = registerGenericBlock("digital_wood_mountain",AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD));
           DIGITAL_LEAF_MOUNTAIN = registerModBlocks("digital_leaf_mountain",new LeavesBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_LEAVES)));
           DIGITAL_ICE = registerModBlocks("digital_ice",new IceBlock(AbstractBlock.Settings.copy(Blocks.ICE).strength(-1, Integer.MAX_VALUE)));
           DIGITAL_SAND = registerUnbreakableBlock("digital_sand",
                   AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW));
           DIGITAL_DARKNESS = registerGenericBlock("digital_darkness",AbstractBlock.Settings.copy(Blocks.DRAGON_EGG).strength(-1,
                   Integer.MAX_VALUE));
           ELECTRIC_FLUORIDE_INFUSER = registerModBlocks("electric_fluoride_infuser",new ElectricFluorideInfuser());
           EXTERNAL_ENERGY_ACCEPTOR = registerModBlocks("external_energy_acceptor",new ExternalPowerAcceptor(
                   AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           ELECTROPLATING_MACHINE = registerModBlocks("electroplating_machine",new ElectroplatingMachine(
                   AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           ELECTROPLATING_MACHINE_FRAME = registerGenericBlock("electroplating_machine_frame");
           ELECTROPLATING_ANODE = registerModBlocks("electroplating_anode",new ElectroplatingRodImplements(
                   AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           ELECTROPLATING_CATHODE = registerModBlocks("electroplating_cathode",new ElectroplatingRodImplements(
                   AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           ERODED_IRON_RAILING = registerModBlocks("eroded_iron_railing",new OxidizeableFenceBlock(Oxidizable.OxidationLevel.EXPOSED,AbstractBlock.Settings.copy(Blocks.IRON_BARS).mapColor(MapColor.LIGHT_GRAY)));
           FLUORIDE_INFUSER = registerModBlocks("fluoride_infuser",new FluorideInfuser());
           FLUORITE_BLOCK = registerGenericBlock("fluorite_block",
                   AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(-1, 10)
                           .sounds(BlockSoundGroup.SAND));
           FLUORITE_ORE = registerExperienceDroppingOre("fluorite_ore",
                   AbstractBlock.Settings.copy(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE),UniformIntProvider.create(0,1));
           FALSE_WATER = registerGenericBlock("false_water",AbstractBlock.Settings.copy(Blocks.WATER).noCollision());
           FRONTIER_BLOCK = registerModBlocks("frontier_block",new FrontierBlock(AbstractBlock.Settings.copy(Blocks.BEDROCK)));
           GUMMITE_ORE = registerExperienceDroppingOre("gummite_ore", AbstractBlock.Settings.copy(Blocks.STONE).strength(3, 10).sounds(BlockSoundGroup.STONE),UniformIntProvider.create(0,1));
           HOLOPROJECTOR = registerModBlocks("holoprojector",new HologramProjectorBlock());
           IRON_RAILING = registerModBlocks("iron_railing",new OxidizeableFenceBlock(Oxidizable.OxidationLevel.UNAFFECTED,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           LYOKO_CORE = registerModBlocks("core_of_lyoko",new LyokoCore(
                   AbstractBlock.Settings.copy(Blocks.DRAGON_EGG).dropsNothing().nonOpaque().strength(-1, -1)
                           .luminance(value -> Blocks.GLOWSTONE.getDefaultState().getLuminance())));
           LITHOGRAPHY_MACHINE = registerModBlocks("lithography_machine",new LithographyMachine(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           LITHOGRAPHY_MACHINET2 = registerModBlocks("lithography_machine_t2", new LithographyMachineT2(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           MARABUNTA = registerModBlocks("marabunta",new Marabunta());
           METATYUYAMUNITE_ORE = registerExperienceDroppingOre("metatyuyamunite_ore",UniformIntProvider.create(0,1));
           METATORBERNITE_ORE = registerExperienceDroppingOre("metatorbernite_ore",AbstractBlock.Settings.copy(METATYUYAMUNITE_ORE),UniformIntProvider.create(0,1));
           METAAUTUNITE_ORE = registerExperienceDroppingOre("metaautunite_ore",AbstractBlock.Settings.copy(AUTUNITE_ORE),UniformIntProvider.create(0,1));
           PROJECTOR_FOCUS = registerModBlocks("projector_focus",new ProjectorFocusblock());
           QUANTUM_BLOCK = registerGenericBlock("quantum_block",
                   AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL).strength(8, 20));
           QUANTUM_CORE = registerGenericBlock("quantum_core",AbstractBlock.Settings.copy(Blocks.END_PORTAL));
           QUANTUM_STEEL_BLOCK = registerModBlocks("quantum_steel",new QuantumSteelBlock(
                   AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(6, 20).sounds(BlockSoundGroup.METAL)));
           RACK_CHARGER_BLOCK = registerModBlocks("rack_charger",new RackChargerBlock(AbstractBlock.Settings.copy(Blocks.REDSTONE_BLOCK)));
           RUTILE_ORE = registerExperienceDroppingOre("rutile_ore",UniformIntProvider.create(0,1));
           SALEEITE_ORE = registerExperienceDroppingOre("saleeite_ore",
                   AbstractBlock.Settings.copy(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE),UniformIntProvider.create(0,1));
           SCANNER_BASE = registerModBlocks("scanner_base",new Scanner());
           SCANNER_FRAME = registerModBlocks("scanner_frame",new ScannerFrame(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           SCANNER_TOP = registerModBlocks("scanner_top",new ScannerTop(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           STORAGE = registerModBlocks("universal",new UniversalEnergyBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           SKLODOWSKITE_ORE = registerGenericBlock("sklodowskite_ore",
                   AbstractBlock.Settings.copy(Blocks.STONE).strength(4, 4).sounds(BlockSoundGroup.STONE));
           SILICA_SAND = registerModBlocks("silica_sand",new ColoredFallingBlock(new ColorCode( 0xFFFFFF), AbstractBlock.Settings.copy(Blocks.SAND)));
           SECTOR5_STEEL = registerUnbreakableBlock("sector5_steel");
           SECTOR_ENTRANCE_DESERT = registerModBlocks("desert_sector_entrance",new SectorEntrance(AbstractBlock.Settings.copy(Blocks.BEDROCK), DimensionSelector.DESERT));
           ROUTER = registerModBlocks("router",new Router(AbstractBlock.Settings.copy(Blocks.DRAGON_EGG)));
           RUSTED_IRON_RAILING = registerModBlocks("rusted_iron_railing",new OxidizeableFenceBlock(Oxidizable.OxidationLevel.OXIDIZED,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.DULL_RED)));
           TARNISHED_IRON_RAILING = registerModBlocks("tarnished_iron_railing",new OxidizeableFenceBlock(Oxidizable.OxidationLevel.WEATHERED,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.BRIGHT_RED)));
           TOWER_INTERFACE = registerModBlocks("tower_interface",new TowerInterface(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).strength(-1, Integer.MAX_VALUE).sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                   .luminance(value -> 80)));
           TOWER_WHITE = registerModBlocks("tower_white",new TowerPlatform());
           TOWER_BASE = registerModBlocks("tower_base",new TowerWall());
           TOWER_WALL = registerModBlocks("tower_wall",new TowerWall());
           TOWER_BLUE = registerModBlocks("tower_blue",new TowerPlatform());
           TOWER_TOP = registerGenericBlock("tower_top",AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(-1, Integer.MAX_VALUE).sounds(BlockSoundGroup.GLASS));
           TOWER_WALL_CORNER = registerModBlocks("tower_wall_corner",new TowerWallCorner());
           TOWER_BASE_CORNER = registerModBlocks("tower_base_corner",new TowerWallCorner());
           TOWER_BOTTOM = registerModBlocks("tower_bottom",new TowerBottomBlock(
                   AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.GLASS)));
           TYUYAMUNITE_ORE = registerExperienceDroppingOre("tyuyamunite_ore",AbstractBlock.Settings.copy(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE),UniformIntProvider.create(0,1));
           TORBERNITE_ORE = registerExperienceDroppingOre("torbernite_ore",AbstractBlock.Settings.copy(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE),UniformIntProvider.create(0,1));
           TOWER_ENTER = registerModBlocks("tower_enter",new TowerEnter());
           TITANIUM = registerGenericBlock("titanium_block",
                   AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(6, 10).sounds(BlockSoundGroup.METAL));
           URANIUM_REACTOR = registerModBlocks("computer_reactor",new ComputerIntegratedReactor());
           URANINITE_ORE = registerExperienceDroppingOre("uraninite_ore",AbstractBlock.Settings.copy(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE),UniformIntProvider.create(0,1));
           URANIUM_BLOCK_238 = registerGenericBlock("uranium_block_238", AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(6, 20).sounds(BlockSoundGroup.METAL));
           URANIUM_BLOCK_235 = registerGenericBlock("uranium_block_235",AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(6, 20).sounds(BlockSoundGroup.METAL));
           URANIUM_CANISTER = registerModBlocks("uranium_canister",new UraniumCanister(
                   AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(5, 5)));
           URANOPHANE_ORE = registerGenericBlock("uranophane_ore",AbstractBlock.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.STONE).strength(4, 4));
           UV_MACHINE = registerGenericBlock("uv_machine",AbstractBlock.Settings.copy(Blocks.ANVIL));
           UV_LIGHT = registerGenericBlock("uv_light",AbstractBlock.Settings.copy(Blocks.GLOWSTONE));
           WAXED_IRON_RAILING = registerModBlocks("waxed_iron_railing",new FenceBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)));
           VOLCANO_GROUND = registerGenericBlock("volcano_ground",AbstractBlock.Settings.copy(Blocks.STONE));
           DIGITAL_OCEAN_BLOCK = registerModBlocks("digital_ocean",new DigitalSeaBlock());
           DIGITAL_LAVA_BLOCK = registerModBlocks("digital_lava",new DigitalLavaBlock());
           URANIUM_WASTE_BLOCK = registerModBlocks("uranium_waste",new UraniumWaste());
           LIQUID_HELIUM_BLOCK = registerModBlocks("liquid_helium",new LiquidHelium());
           LAPTOP_CHARGER = registerModBlocks("laptop_charger",new LaptopCharger(AbstractBlock.Settings.copy(Blocks.ANVIL)));
           TESTUI = registerModBlocks("test_ui",new TestComputerUI(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
           TEST_PROFILE = registerModBlocks("player_profile_block",new PlayerCustomProfileTest(AbstractBlock.Settings.copy(Blocks.BEDROCK)));
           TEST_SPHERE = registerModBlocks("test_sphere",new TestSphereRenderer(AbstractBlock.Settings.copy(Blocks.BEDROCK)));
           TEST_VEHICLE_INTERFACE = registerModBlocks("test_vehicle_materialization",new PlayerVehicleTest(AbstractBlock.Settings.copy(Blocks.BEDROCK)));
           TEST_ITEM_PROJECTOR = registerModBlocks("test_item_projector",new ItemProjectorTest());

    }
    private static boolean blockBlacklist(final Block block)
    {
        final Class<?>[] blacklistedBlocks = {
                LyokoCore.class,
                DigitalLavaBlock.class,
                DigitalSeaBlock.class,
                LiquidHelium.class,
                UraniumWaste.class,
                SectorEntrance.class
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
            final BlockItem blockItem = new BlockItem(block,new Item.Settings());
            Registry.register(Registries.ITEM,name,blockItem);
            final RegistryKey<ItemGroup> registryKey = RegistryKey.of(Registries.ITEM_GROUP.getKey(), CodeLyokoMain.codeLyokoPrefix("lyoko_blocks"));
            ItemGroupEvents.modifyEntriesEvent(registryKey).register(entries -> entries.add(blockItem));
        }
    }
    private static Block registerExperienceDroppingOre(final String name,final UniformIntProvider intProvider)
    {
        final Block block = new ExperienceDroppingBlock(intProvider,AbstractBlock.Settings.copy(Blocks.IRON_ORE));
        return registerModBlocks(name,block);
    }
    private static Block registerExperienceDroppingOre(final String name,final AbstractBlock.Settings settings,final UniformIntProvider intProvider)
    {
        final Block block = new ExperienceDroppingBlock(intProvider,settings);
        return registerModBlocks(name,block);
    }
    private static Block registerUnbreakableBlock(final String name, final AbstractBlock.Settings settings)
    {
        final Block unbreakable = new Block(settings.strength(Blocks.BEDROCK.getHardness(),Blocks.BEDROCK.getBlastResistance()));
        return registerModBlocks(name,unbreakable);
    }
    private static Block registerUnbreakableBlock(final String name)
    {
        final Block unbreakable = new Block(AbstractBlock.Settings.copy(Blocks.BEDROCK));
        return registerModBlocks(name,unbreakable);
    }

    private static Block registerGenericBlock(final String name)
    {
       final Block block = new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
       return registerModBlocks(name,block);
    }
    private static Block registerGenericBlock(final String name,final AbstractBlock.Settings fabricBlockSettings)
    {
        final Block block = new Block(fabricBlockSettings);
        return registerModBlocks(name,block);
    }
    private static Block registerModBlocks(final String name,final Block block)
    {
        final Identifier id = CodeLyokoMain.codeLyokoPrefix(name);
        final Block registeredBlock = Registry.register(Registries.BLOCK,id,block);
        registerBlockItems(id,registeredBlock);
        return registeredBlock;
    }
    public static void registerBlocks()
    {
    }

}