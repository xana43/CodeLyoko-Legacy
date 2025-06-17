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
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Util.BlockWithExtraProperties;
import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.Enums.DimensionSelector;
import com.google.common.collect.ImmutableMap;
import dev.felnull.specialmodelloader.api.data.SpecialModelDataGenHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

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
    public static final Block LAPTOP_BLOCK;
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
    public static final Block SUPERCOMPUTER_INTERFACE;
    public static final Block TEST_PROFILE;
    public static final Block TEST_SPHERE;
    public static final Block TEST_VEHICLE_INTERFACE;
    public static final Block TEST_ITEM_PROJECTOR;
    //private static final Object2BooleanMap<ObjectObjectImmutablePair<Identifier,Block>> LYOKO_BLOCK_SHOULD_HAVE_ITEM_MAP;
    static {
            //block Items collector
           //LYOKO_BLOCK_SHOULD_HAVE_ITEM_MAP = new Object2BooleanOpenHashMap<>(64);


           ARCHITECTURE_WORK_STATION = registerModBlocks("architecture_work_station", ArchitectureWorkstation::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           ANTI_MARABUNTA = registerModBlocks("anti_marabunta",AntiMarabunta::new,AbstractBlock.Settings.create().strength(6, 10).sounds(BlockSoundGroup.STONE).ticksRandomly());
           ANODE_PART = registerModBlocks("anodepart",ElectroplatingRodParts::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           AUTUNITE_ORE = registerModBlocks("autunite_ore",settings -> new ExperienceDroppingBlock(UniformIntProvider.create(0,1),settings),AbstractBlock.Settings.copy(Blocks.IRON_ORE));
           BLACK_VOID = registerModBlocks("black_void",BlackVoid::new, AbstractBlock.Settings.copy(Blocks.STRUCTURE_VOID).strength(-1, -1).dropsNothing().nonOpaque()
                   .luminance(value -> 10));
           BORNITE_ORE = registerModBlocks("bornite_ore",settings -> new ExperienceDroppingBlock(UniformIntProvider.create(0,1),settings),AbstractBlock.Settings.copy(Blocks.IRON_ORE));
           CABLE_BLOCK = registerModBlocks("cable_block",CableBlock::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           COMPUTER_SCREEN_CONNECTOR = registerModBlocks("computer_screen_connector",settings -> new FenceBlock(
                   settings){
               @Override
               public BlockState getPlacementState(final ItemPlacementContext ctx) {
                       return getDefaultState().with(ComputerKeyboard.IS_SCREEN_FORMED, Boolean.FALSE);

               }

               @Override
               protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
                   super.appendProperties(builder.add(ComputerKeyboard.IS_SCREEN_FORMED));               }
           },AbstractBlock.Settings.copy(Blocks.IRON_BARS));
           CHALCOPYRITE_ORE = registerExperienceDroppingOre("chalcopyrite_ore",UniformIntProvider.create(0,1));
           COVELLITE_ORE = registerExperienceDroppingOre("covellite_ore",UniformIntProvider.create(0,1));
           CHALCOCITE_ORE = registerExperienceDroppingOre("chalcocite_ore",UniformIntProvider.create(0,1));
           COMPUTER_FRAME = registerGenericBlock("computer_frame");
           CENTRAL_CONTROL_UNIT = registerModBlocks("central_control_unit",ComputerCoreUnit::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           COMPUTER_SCREEN = registerModBlocks("computer_screen",settings -> new Block(settings){
               @Override
               public BlockState getPlacementState(final ItemPlacementContext ctx) {
                   return getDefaultState().with(ComputerKeyboard.IS_SCREEN_FORMED, Boolean.FALSE);
               }
               @Override
               protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
                   super.appendProperties(builder.add(ComputerKeyboard.IS_SCREEN_FORMED));
               }
           },AbstractBlock.Settings.copy(Blocks.GLASS).strength(1, Blocks.GLASS.getBlastResistance())
                   .sounds(BlockSoundGroup.GLASS));
           COMPUTER_SCREEN_FRAME = registerModBlocks("computer_screen_frame",settings -> new Block(settings){
               @Override
               public BlockState getPlacementState(final ItemPlacementContext ctx) {
                   return getDefaultState().with(ComputerKeyboard.IS_SCREEN_FORMED, Boolean.FALSE);
               }
               @Override
               protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
                   super.appendProperties(builder.add(ComputerKeyboard.IS_SCREEN_FORMED));
               }
           },AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           COMPUTER_CORE = registerModBlocks("computer_core",ComputerCoreUnit::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           COMPUTER_KEYBOARD = registerModBlocks("computer_keyboard",ComputerKeyboard::new, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                   .strength(1, 10)
                   .sounds(BlockSoundGroup.METAL));
           CHIPLET_BASIC_BLOCK = registerGenericBlock("chiplet_basic_block");
           CHIPLET_ADVANCED_BLOCK = registerModBlocks("chiplet_advanced_block",ChipletAdvancedBlock::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).nonOpaque());
           CHIPLET_FRANZ_BLOCK = registerModBlocks("chiplet_franz_block",FranzChiplet::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           COMPUTER_COOLING_BLOCK = registerModBlocks("computer_cooling_block",CoolingBlock::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           COMPUTER_LIQUID_CIRCULATOR = registerModBlocks("computer_liquid_circulator",ComputerFluidCirculator::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           COMPUTER_LIQUID_PIPE = registerModBlocks("computer_liquid_pipe",BaseComputerPipe::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           COMPUTER_LIQUID_INTAKE_PUMP = registerModBlocks("computer_fluid_intake",ComputerIntakePump::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           COMPUTER_FLUID_COOLER = registerModBlocks("computer_fluid_cooler",ComputerFluidCooler::new,AbstractBlock.Settings.copy(Blocks.IRON_BARS));
           COMPUTER_TOWER_CONTROL_PANEL = registerModBlocks("computer_tower_control_panel",ControlPanel::new, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                   .strength(10, 10)
                   .sounds(BlockSoundGroup.METAL));
           CATHODE_PART = registerModBlocks("cathodepart",ElectroplatingRodParts::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           COFFINITE_ORE = registerExperienceDroppingOre("coffinite_ore",UniformIntProvider.create(0,1));
           CASSERITE_ORE = registerExperienceDroppingOre("casserite_ore", AbstractBlock.Settings.copy(Blocks.COPPER_ORE),UniformIntProvider.create(0,1));
           CARNOTITE_ORE = registerExperienceDroppingOre("carnotite_ore",AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE),UniformIntProvider.create(0,1));
           DEMARCATION_POINT = registerModBlocks("demarcation_point",DemarcationPoint::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           DATA_TRANSFER_INTERFACE = registerModBlocks("data_transfer_interface",DataTransferInterface::new, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                   .strength(-1, -1)
                   .sounds(BlockSoundGroup.METAL));
           DIGITAL_SEA_PYLON = registerModBlocks("digital_sea_pylon",SeaPylon::new, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                   .strength(-1, Integer.MAX_VALUE)
                   .sounds(BlockSoundGroup.GLASS)
                   .nonOpaque()
                   .luminance(value -> 10));
           DIGITAL_GRASS = registerGenericBlock("digital_grass",
                   AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK).allowsSpawning((state, world, pos, type) -> true)
                           .strength(-1, Integer.MAX_VALUE));
           DIGITAL_DIRT = registerModBlocks("digital_dirt",Block::new,AbstractBlock.Settings.copy(Blocks.DIRT).strength(-1,
                   Integer.MAX_VALUE));
           DIGITAL_ROCK = registerGenericBlock("digital_rock",AbstractBlock.Settings.copy(Blocks.STONE).strength(-1, Integer.MAX_VALUE)
                   .allowsSpawning((state, world, pos, type) -> true));
           DIGITAL_WOOD_FOREST = registerModBlocks("digital_wood_forest",Block::new,AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(-1, Integer.MAX_VALUE));
           DIGITAL_WOOD_MOUNTAIN = registerGenericBlock("digital_wood_mountain",AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD));
           DIGITAL_LEAF_MOUNTAIN = registerModBlocks("digital_leaf_mountain",settings -> new UntintedParticleLeavesBlock(0,null,settings),AbstractBlock.Settings.copy(Blocks.JUNGLE_LEAVES));
           DIGITAL_ICE = registerModBlocks("digital_ice",IceBlock::new,AbstractBlock.Settings.copy(Blocks.ICE).strength(-1, Integer.MAX_VALUE));
           DIGITAL_SAND = registerUnbreakableBlock("digital_sand",
                   AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW));
           DIGITAL_DARKNESS = registerGenericBlock("digital_darkness",AbstractBlock.Settings.copy(Blocks.DRAGON_EGG).strength(-1,
                   Integer.MAX_VALUE));
           ELECTRIC_FLUORIDE_INFUSER = registerModBlocks("electric_fluoride_infuser",ElectricFluorideInfuser::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           EXTERNAL_ENERGY_ACCEPTOR = registerModBlocks("external_energy_acceptor",ExternalPowerAcceptor::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           ELECTROPLATING_MACHINE = registerModBlocks("electroplating_machine",ElectroplatingMachine::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           ELECTROPLATING_MACHINE_FRAME = registerGenericBlock("electroplating_machine_frame");
           ELECTROPLATING_ANODE = registerModBlocks("electroplating_anode",ElectroplatingRodImplements::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           ELECTROPLATING_CATHODE = registerModBlocks("electroplating_cathode",ElectroplatingRodImplements::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));

           FLUORIDE_INFUSER = registerModBlocks("fluoride_infuser",FluorideInfuser::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                   .strength(6, 10)
                   .sounds(BlockSoundGroup.METAL));
           FLUORITE_BLOCK = registerGenericBlock("fluorite_block",
                   AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(-1, 10)
                           .sounds(BlockSoundGroup.SAND));
           FLUORITE_ORE = registerExperienceDroppingOre("fluorite_ore",
                   AbstractBlock.Settings.copy(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE),UniformIntProvider.create(0,1));
           FALSE_WATER = registerGenericBlock("false_water",AbstractBlock.Settings.copy(Blocks.WATER).noCollision());
           FRONTIER_BLOCK = registerUnbreakableModBlock("frontier_block",FrontierBlock::new,false);
           GUMMITE_ORE = registerExperienceDroppingOre("gummite_ore", AbstractBlock.Settings.copy(Blocks.STONE).strength(3, 10).sounds(BlockSoundGroup.STONE),UniformIntProvider.create(0,1));
           HOLOPROJECTOR = registerModBlocks("holoprojector",HologramProjectorBlock::new, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                   .strength(6, 10)
                   .sounds(BlockSoundGroup.METAL));

           LYOKO_CORE = registerModBlocks("core_of_lyoko",LyokoCore::new,AbstractBlock.Settings.copy(Blocks.DRAGON_EGG).dropsNothing().nonOpaque().strength(-1, -1)
                   .luminance(value -> Blocks.GLOWSTONE.getDefaultState().getLuminance()),false);
           LITHOGRAPHY_MACHINE = registerModBlocks("lithography_machine",LithographyMachine::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           LITHOGRAPHY_MACHINET2 = registerModBlocks("lithography_machine_t2", LithographyMachineT2::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           LAPTOP_BLOCK = registerModBlocks("laptop_block",LaptopBlock::new ,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK),false);
           MARABUNTA = registerModBlocks("marabunta",Marabunta::new, AbstractBlock.Settings.copy(Blocks.DRAGON_EGG)
                   .strength(6, 10)
                   .sounds(BlockSoundGroup.STONE).ticksRandomly());
           METATYUYAMUNITE_ORE = registerExperienceDroppingOre("metatyuyamunite_ore",UniformIntProvider.create(0,1));
           METATORBERNITE_ORE = registerExperienceDroppingOre("metatorbernite_ore",AbstractBlock.Settings.copy(METATYUYAMUNITE_ORE),UniformIntProvider.create(0,1));
           METAAUTUNITE_ORE = registerExperienceDroppingOre("metaautunite_ore",AbstractBlock.Settings.copy(AUTUNITE_ORE),UniformIntProvider.create(0,1));
           PROJECTOR_FOCUS = registerModBlocks("projector_focus",ProjectorFocusblock::new, AbstractBlock.Settings.copy(Blocks.GLASS)
                   .strength(6, 10)
                   .sounds(BlockSoundGroup.GLASS)
                   .nonOpaque());
           QUANTUM_BLOCK = registerGenericBlock("quantum_block",
                   AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL).strength(8, 20));
           QUANTUM_CORE = registerGenericBlock("quantum_core",AbstractBlock.Settings.copy(Blocks.END_PORTAL));
           QUANTUM_STEEL_BLOCK = registerModBlocks("quantum_steel",QuantumSteelBlock::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(6, 20).sounds(BlockSoundGroup.METAL));
           RACK_CHARGER_BLOCK = registerModBlocks("rack_charger",RackChargerBlock::new,AbstractBlock.Settings.copy(Blocks.REDSTONE_BLOCK));
           RUTILE_ORE = registerExperienceDroppingOre("rutile_ore",UniformIntProvider.create(0,1));
           SALEEITE_ORE = registerExperienceDroppingOre("saleeite_ore",
                   AbstractBlock.Settings.copy(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE),UniformIntProvider.create(0,1));
           SCANNER_BASE = registerModBlocks("scanner_base",Scanner::new, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                   .strength(10, 10).sounds(BlockSoundGroup.METAL));
           SCANNER_FRAME = registerModBlocks("scanner_frame",ScannerFrame::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           SCANNER_TOP = registerModBlocks("scanner_top",ScannerTop::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           STORAGE = registerModBlocks("universal",UniversalEnergyBlock::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           SKLODOWSKITE_ORE = registerGenericBlock("sklodowskite_ore",
                   AbstractBlock.Settings.copy(Blocks.STONE).strength(4, 4).sounds(BlockSoundGroup.STONE));
           SILICA_SAND = registerModBlocks("silica_sand",settings -> new ColoredFallingBlock(new ColorCode( 0xFFFFFF), settings),AbstractBlock.Settings.copy(Blocks.SAND));
           SECTOR5_STEEL = registerUnbreakableBlock("sector5_steel");
           SECTOR_ENTRANCE_DESERT = registerModBlocks("desert_sector_entrance",settings -> new SectorEntrance(settings, DimensionSelector.DESERT),AbstractBlock.Settings.copy(Blocks.BEDROCK),false);
           ROUTER = registerModBlocks("router",Router::new,AbstractBlock.Settings.copy(Blocks.DRAGON_EGG));

           TOWER_INTERFACE = registerModBlocks("tower_interface",TowerInterface::new,AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).strength(-1, Integer.MAX_VALUE).sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                   .luminance(value -> 80));

           final AbstractBlock.Settings towerWallSettings = AbstractBlock.Settings.copy(Blocks.BEDROCK)
                   .dropsNothing()
                   .sounds(BlockSoundGroup.GLASS)
                   .luminance(value -> 250);
           final AbstractBlock.Settings towerPlatformSettings = AbstractBlock.Settings.copy(Blocks.BEDROCK).sounds(BlockSoundGroup.GLASS).luminance(Blocks.createLightLevelFromLitBlockState(255));
           TOWER_WHITE = registerModBlocks("tower_white",TowerPlatform::new,towerPlatformSettings);
           TOWER_BASE = registerModBlocks("tower_base",TowerWall::new,towerWallSettings);
           TOWER_WALL = registerModBlocks("tower_wall",TowerWall::new,towerWallSettings);
           TOWER_BLUE = registerModBlocks("tower_blue",TowerPlatform::new,towerWallSettings);
           TOWER_TOP = registerGenericBlock("tower_top",AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(-1, Integer.MAX_VALUE).sounds(BlockSoundGroup.GLASS));
           TOWER_WALL_CORNER = registerModBlocks("tower_wall_corner",TowerWallCorner::new,towerWallSettings);
           TOWER_BASE_CORNER = registerModBlocks("tower_base_corner",TowerWallCorner::new,towerWallSettings);
           TOWER_BOTTOM = registerModBlocks("tower_bottom",TowerBottomBlock::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.GLASS));
           TYUYAMUNITE_ORE = registerExperienceDroppingOre("tyuyamunite_ore",AbstractBlock.Settings.copy(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE),UniformIntProvider.create(0,1));
           TORBERNITE_ORE = registerExperienceDroppingOre("torbernite_ore",AbstractBlock.Settings.copy(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE),UniformIntProvider.create(0,1));
           TOWER_ENTER = registerModBlocks("tower_enter",TowerEnter::new,AbstractBlock.Settings.copy(Blocks.BEDROCK).sounds(BlockSoundGroup.GLASS)
                   .noCollision().luminance(value -> 60));
           TITANIUM = registerGenericBlock("titanium_block",
                   AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(6, 10).sounds(BlockSoundGroup.METAL));
           URANIUM_REACTOR = registerModBlocks("computer_reactor",ComputerIntegratedReactor::new, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           URANINITE_ORE = registerExperienceDroppingOre("uraninite_ore",AbstractBlock.Settings.copy(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE),UniformIntProvider.create(0,1));
           URANIUM_BLOCK_238 = registerGenericBlock("uranium_block_238", AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(6, 20).sounds(BlockSoundGroup.METAL));
           URANIUM_BLOCK_235 = registerGenericBlock("uranium_block_235",AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(6, 20).sounds(BlockSoundGroup.METAL));
           URANIUM_CANISTER = registerModBlocks("uranium_canister",UraniumCanister::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(5, 5));
           URANOPHANE_ORE = registerGenericBlock("uranophane_ore",AbstractBlock.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.STONE).strength(4, 4));
           UV_MACHINE = registerGenericBlock("uv_machine",AbstractBlock.Settings.copy(Blocks.ANVIL));
           UV_LIGHT = registerGenericBlock("uv_light",AbstractBlock.Settings.copy(Blocks.GLOWSTONE));
           WAXED_IRON_RAILING = registerModBlocks("waxed_iron_railing",FenceBlock::new,AbstractBlock.Settings.copy(Blocks.IRON_BARS));
           VOLCANO_GROUND = registerGenericBlock("volcano_ground",AbstractBlock.Settings.copy(Blocks.STONE));
           DIGITAL_OCEAN_BLOCK = registerModBlocks("digital_ocean",DigitalSeaBlock::new, AbstractBlock.Settings.copy(Blocks.WATER),false);
           DIGITAL_LAVA_BLOCK = registerModBlocks("digital_lava",DigitalLavaBlock::new, AbstractBlock.Settings.copy(Blocks.LAVA),false);
           URANIUM_WASTE_BLOCK = registerModBlocks("uranium_waste",UraniumWaste::new, AbstractBlock.Settings.copy(Blocks.LAVA),false);
           LIQUID_HELIUM_BLOCK = registerModBlocks("liquid_helium",LiquidHelium::new, AbstractBlock.Settings.copy(Blocks.WATER),false);
           LAPTOP_CHARGER = registerModBlocks("laptop_charger",LaptopCharger::new,AbstractBlock.Settings.copy(Blocks.ANVIL));
           TESTUI = registerModBlocks("test_ui",TestComputerUI::new,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
           TEST_PROFILE = registerModBlocks("player_profile_block",PlayerCustomProfileTest::new,AbstractBlock.Settings.copy(Blocks.BEDROCK));
           TEST_SPHERE = registerModBlocks("test_sphere",TestSphereRenderer::new,AbstractBlock.Settings.copy(Blocks.BEDROCK));
           TEST_VEHICLE_INTERFACE = registerUnbreakableModBlock("test_vehicle_materialization",PlayerVehicleTest::new);
           TEST_ITEM_PROJECTOR = registerUnbreakableModBlock("test_item_projector",ItemProjectorTest::new);
           SUPERCOMPUTER_INTERFACE = registerModBlocks("interface_sc",settings -> new BlockWithExtraProperties(settings,false,false),AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));

        IRON_RAILING = registerModBlocks("iron_railing",(settings) -> new OxidizeableFenceBlock(Oxidizable.OxidationLevel.UNAFFECTED,settings),AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK));
        ERODED_IRON_RAILING = registerModBlocks("eroded_iron_railing",(settings) -> new OxidizeableFenceBlock(Oxidizable.OxidationLevel.EXPOSED,settings),AbstractBlock.Settings.copy(Blocks.EXPOSED_COPPER).mapColor(MapColor.LIGHT_GRAY));
        TARNISHED_IRON_RAILING = registerModBlocks("tarnished_iron_railing",(settings) -> new OxidizeableFenceBlock(Oxidizable.OxidationLevel.WEATHERED,settings),AbstractBlock.Settings.copy(Blocks.WEATHERED_COPPER).mapColor(MapColor.BRIGHT_RED));
        RUSTED_IRON_RAILING = registerModBlocks("rusted_iron_railing",(settings) -> new OxidizeableFenceBlock(Oxidizable.OxidationLevel.OXIDIZED,settings),AbstractBlock.Settings.copy(Blocks.OXIDIZED_COPPER).mapColor(MapColor.DULL_RED));
        OxidizableBlocksRegistry.registerOxidizableBlockPair(IRON_RAILING,ERODED_IRON_RAILING);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ERODED_IRON_RAILING,TARNISHED_IRON_RAILING);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(TARNISHED_IRON_RAILING,RUSTED_IRON_RAILING);
    }
    public record BlockStateProvider(){



        public static void generateBlockStateModels(final BlockStateModelGenerator blockStateModelGenerator) {
            CodeLyokoMain.LOG.info("Generating block state models");
            blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CABLE_BLOCK);
            blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIGITAL_WOOD_FOREST);
            blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIGITAL_WOOD_MOUNTAIN);
            blockStateModelGenerator.registerParentedItemModel(ModBlocks.RACK_CHARGER_BLOCK, CodeLyokoMain.codeLyokoPrefix("block/rack_charger"));
            blockStateModelGenerator.registerParentedItemModel(ModBlocks.CABLE_BLOCK, CodeLyokoMain.codeLyokoPrefix("block/cable_block"));
            blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SECTOR_ENTRANCE_DESERT);
            generateCustomBlockModels(blockStateModelGenerator);
            generateFenceLikeModels(ModBlocks.IRON_RAILING,"block/railing_post","block/railing_side");
            generateFenceLikeModels(ModBlocks.ERODED_IRON_RAILING,"block/eroded_railing_post","block/eroded_railing_side");
            generateFenceLikeModels(ModBlocks.TARNISHED_IRON_RAILING,"block/tarnished_railing_post","block/tarnished_railing_side");
            generateFenceLikeModels(ModBlocks.RUSTED_IRON_RAILING,"block/rusted_railing_post","block/rusted_railing_side");
            generateObjBlockStateModels(blockStateModelGenerator,ModBlocks.SUPERCOMPUTER_INTERFACE,"models/block/interface_sc",true);
            generateObjBlockStateModels(blockStateModelGenerator,ModBlocks.COMPUTER_CORE,"models/block/supercomputer_by_quantum_test",true);
        }
        private static void generateFenceLikeModels(final Block blockToGenerate,final String postModel, final String sideModel)
        {

            final Identifier postIdentifier = CodeLyokoMain.codeLyokoPrefix(postModel);
            final Identifier sideIdentifier = CodeLyokoMain.codeLyokoPrefix(sideModel);
            BlockStateModelGenerator.createFenceBlockState(blockToGenerate,BlockStateModelGenerator.createWeightedVariant(postIdentifier),BlockStateModelGenerator.createWeightedVariant(sideIdentifier));
        }
        private static void generateCustomBlockModels(final BlockStateModelGenerator blockStateModelGenerator){

        }
        public static void generateItemModels(final ItemModelGenerator itemModelGenerator) {

        }
        private static void generateObjBlockStateModels(final BlockStateModelGenerator blockStateModelGenerator, final Block block, final String model){
            generateObjBlockStateModels(blockStateModelGenerator,block,model,false,true);
        }
        private static void generateObjBlockStateModels(final BlockStateModelGenerator blockStateModelGenerator, final Block block, final String model,final boolean flipV){
            generateObjBlockStateModels(blockStateModelGenerator,block,model,flipV,true);
        }
        private static void generateObjBlockStateModels(final BlockStateModelGenerator blockStateModelGenerator, final Block block, final String model,final boolean flipV, final boolean useAO){
            Identifier parsedModel;
            if(model.contains(".obj"))
            {
                parsedModel = CodeLyokoMain.codeLyokoPrefix(model);
            }
            else{
                parsedModel = CodeLyokoMain.codeLyokoPrefix(model+".obj");
            }
            SpecialModelDataGenHelper.generateObjModel(
                    block,
                    parsedModel,
                    flipV,
                    useAO,
                    null,
                    ImmutableMap.of(),
                    null,
                    blockStateModelGenerator.modelCollector);
            blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block,BlockStateModelGenerator.createWeightedVariant(parsedModel))
            );
        }
    }
    private static RegistryKey<Block> getKeyOfBlock(final String name)
    {
        return RegistryKey.of(RegistryKeys.BLOCK,CodeLyokoMain.codeLyokoPrefix(name));
    }
    private static RegistryKey<Item> getKeyOfBlockItem(final String name)
    {
        return RegistryKey.of(RegistryKeys.ITEM,CodeLyokoMain.codeLyokoPrefix(name));
    }
    private static Block registerExperienceDroppingOre(final String name,final IntProvider intProvider)
    {
        return registerExperienceDroppingOre(name,AbstractBlock.Settings.copy(Blocks.IRON_ORE),intProvider);
    }
    private static Block registerExperienceDroppingOre(final String name,final AbstractBlock.Settings settings,final IntProvider intProvider)
    {

        return registerExperienceDroppingOre(name,settings,intProvider,true);
    }
    private static Block registerExperienceDroppingOre(final String name,final AbstractBlock.Settings settings,final IntProvider intProvider,final boolean shouldHaveItem)
    {

        return registerModBlocks(name,settings1 -> new ExperienceDroppingBlock(intProvider,settings1),settings,shouldHaveItem);
    }


    private static Block registerUnbreakableBlock(final String name)
    {
        return registerUnbreakableBlock(name,true);
    }
    private static Block registerUnbreakableBlock(final String name,final boolean shouldRegisterItem)
    {
        return registerModBlocks(name,Block::new,AbstractBlock.Settings.copy(Blocks.BEDROCK),shouldRegisterItem);
    }
    private static Block registerUnbreakableModBlock(final String name, final Function<AbstractBlock.Settings, Block> func)
    {
        return registerModBlocks(name,func, AbstractBlock.Settings.copy(Blocks.BEDROCK),false);
    }
    private static Block registerUnbreakableModBlock(final String name, final Function<AbstractBlock.Settings, Block> func, final boolean shouldRegisterItem)
    {
        return registerModBlocks(name,func, AbstractBlock.Settings.copy(Blocks.BEDROCK),shouldRegisterItem);
    }
    private static Block registerUnbreakableModBlock(final String name, final Function<AbstractBlock.Settings, Block> func, final AbstractBlock.Settings settings)
    {
        settings.strength(Blocks.BEDROCK.getHardness(),Blocks.BEDROCK.getBlastResistance());
        settings.pistonBehavior(PistonBehavior.IGNORE);
        return registerModBlocks(name,func, settings,false);
    }
    private static Block registerUnbreakableModBlock(final String name, final Function<AbstractBlock.Settings, Block> func, final AbstractBlock.Settings settings, final boolean shouldRegisterItem)
    {
        settings.strength(Blocks.BEDROCK.getHardness(),Blocks.BEDROCK.getBlastResistance());
        settings.pistonBehavior(PistonBehavior.IGNORE);
        return registerModBlocks(name,func, settings,shouldRegisterItem);
    }
    private static Block registerUnbreakableBlock(final String name, final AbstractBlock.Settings settings)
    {
        return registerUnbreakableBlock(name,settings,true);
    }
    private static Block registerUnbreakableBlock(final String name, final AbstractBlock.Settings settings,final boolean shouldRegisterItem)
    {
        return registerModBlocks(name,Block::new,settings.strength(Blocks.BEDROCK.getHardness(),Blocks.BEDROCK.getBlastResistance()),shouldRegisterItem);
    }
    private static Block registerGenericBlock(final String name)
    {
       return registerGenericBlock(name,AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
    }
    private static Block registerGenericBlock(final String name,final AbstractBlock.Settings fabricBlockSettings)
    {
        return registerGenericBlock(name,fabricBlockSettings,true);
    }
    private static Block registerGenericBlock(final String name,final AbstractBlock.Settings fabricBlockSettings,final boolean shouldRegisterItem)
    {
        return registerModBlocks(name,Block::new,fabricBlockSettings,shouldRegisterItem);
    }

    private static Block registerModBlocks(final String name, final Function<AbstractBlock.Settings,Block> factory, final AbstractBlock.Settings settings)
    {
        return registerModBlocks(name,factory,settings,true);
    }

    private static final RegistryKey<ItemGroup> LYOKO_BLOCKS_GROUP = RegistryKey.of(Registries.ITEM_GROUP.getKey(), CodeLyokoMain.codeLyokoPrefix("lyoko_blocks"));
    private static Block registerModBlocks(final String name, final java.util.function.Function<AbstractBlock.Settings,Block> factory, final AbstractBlock.Settings settings, final boolean shouldRegisterItem)
    {
        final RegistryKey<Block> key = getKeyOfBlock(name);
        final Block newBlock = factory.apply(settings.registryKey(key));
        if(shouldRegisterItem)
        {
            final RegistryKey<Item> itemKey = getKeyOfBlockItem(name);
            final BlockItem newBlockItem = new BlockItem(newBlock,new Item.Settings().registryKey(itemKey));
            final BlockItem registeredBlockItem = Registry.register(Registries.ITEM,itemKey,newBlockItem);
            ItemGroupEvents.modifyEntriesEvent(LYOKO_BLOCKS_GROUP).register(fabricItemGroupEntries -> {
                fabricItemGroupEntries.add(registeredBlockItem);
            });
        }
        return Registry.register(Registries.BLOCK,key,newBlock);
    }

    public static void registerBlocks()
    {

    }

}