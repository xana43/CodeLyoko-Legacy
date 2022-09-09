package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.blocks.*;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition.DigitalLavaBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition.DigitalSeaBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition.LiquidHelium;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition.UraniumWaste;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.*;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.electroplate.ElectroplatingMachine;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.flouride.ElectricFluorideInfuser;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.flouride.FluorideInfuser;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests.DataTransferInterface;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower.*;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public record ModBlocks() {
    //for blocks
    public static final Block ARCHITECTURE_WORK_STATION = new ArchitectureWorkstation(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    //public static final RegistryObject<Block> ARCHITECTURE_WORK_STATION = BLOCKS.register("architecture_work_station", () -> new ArchitectureWorkstation(Block.Properties.copyOf(Blocks.IRON_BLOCK)));
    public static final Block ANTI_MARABUNTA = new AntiMarabunta();
    public static final Block AUTUNITE_ORE = new OreBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE));
    public static final Block BLACK_VOID = new BlackVoid();
    public static final Block BORNITE_ORE = new OreBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE));
    public static final Block CABLE_BLOCK = new CableBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_SCREEN_CONNECTOR = new SuperComputerSideScreenConnector(FabricBlockSettings.copyOf(Blocks.IRON_BARS));//BLOCKS.register("computer_screen_connector", () -> new SuperComputerSideScreenConnector(BlockBehaviour.Properties.copyOf(Blocks.IRON_BARS)));
    public static final Block CHALCOPYRITE_ORE = new OreBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE));//BLOCKS.register("chalcopyrite_ore", () -> new Block(Block.Properties.copyOf(Blocks.IRON_ORE)));
    public static final Block COVELLITE_ORE = new OreBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE));
    public static final Block CHALCOCITE_ORE = new OreBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE));
    public static final Block COMPUTER_FRAME = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block CENTRAL_CONTROL_UNIT = new ComputerCentralControlUnit(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_SCREEN = new Block(FabricBlockSettings.of(Material.GLASS).strength(1, Blocks.GLASS.getBlastResistance()).sounds(BlockSoundGroup.GLASS));
    public static final Block COMPUTER_SCREEN_FRAME = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_KEYBOARD = new ComputerKeyboard();
    public static final Block CHIPLET_BASIC_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block CHIPLET_ADVANCED_BLOCK = new ChipletAdvancedBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block CHIPLET_FRANZ_BLOCK = new FranzChiplet(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_COOLING_BLOCK = new CoolingBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_LIQUID_CIRCULATOR = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_TOWER_CONTROL_PANEL = new ControlPanel();
    public static final Block COFFINITE_ORE = new OreBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE));
    public static final Block CARNOTITE_ORE = new OreBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE));
    public static final Block DATA_TRANSFER_INTERFACE = new DataTransferInterface();
    public static final Block DIGITAL_SEA_PYLON = new SeaPylon();
    public static final Block DIGITAL_GRASS = new Block(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).allowsSpawning((state, world, pos, type) -> true).strength(-1, -1));
    public static final Block DIGITAL_DIRT = new Block(FabricBlockSettings.copyOf(Blocks.DIRT).strength(-1, -1));
    public static final Block DIGITAL_ROCK = new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(-1, -1).allowsSpawning((state, world, pos, type) -> true));
    public static final Block DIGITAL_WOOD_FOREST = new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(-1, -1));
    public static final Block DIGITAL_WOOD_MOUNTAIN = new Block(FabricBlockSettings.copyOf(Blocks.JUNGLE_WOOD));
    public static final Block DIGITAL_LEAF_MOUNTAIN = new LeavesBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_LEAVES));

/*
    public static void registerTestBlocks()
    {
        if(!FMLEnvironment.production)
        {
            BLOCKS.register("portal_block", () -> new TestBlockPortal(Block.Properties.copyOf(Blocks.NETHER_PORTAL)));
            //BLOCKS.register("block_pattern", () -> new BlockPatternTest(Block.Properties.copyOf(Blocks.IRON_BLOCK)));
            BLOCKS.register("digital_mountain_sapling", () -> new DigitalMountainSapling(new AbstractTreeGrower() {
                @Override
                protected @NotNull Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull Random pRandom, boolean pLargeHive) {
                    return ModFeature.DIGITAL_MOUNTAIN_TREE_FEATURE;
                }
            }, Block.Properties.copyOf(Blocks.ACACIA_SAPLING)));
            //BLOCKS.register("test_caller", () -> new TestCaller(BlockBehaviour.Properties.copyOf(Blocks.BARRIER)));

             BLOCKS.register("digital_tree_forest_sapling", () -> new DigitalSapling(new AbstractTreeGrower() {
            @Override
            protected @NotNull Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull Random pRandom, boolean pLargeHive) {
                return ModFeature.DIGITAL_FOREST_TREE_FEATURE;
            }
        }, Block.Properties.copyOf(Blocks.JUNGLE_SAPLING)));
        }
    }
    */

    public static final Block DIGITAL_ICE = new IceBlock(FabricBlockSettings.copyOf(Blocks.ICE).strength(-1, -1));
    public static final Block DIGITAL_SAND = new Block(FabricBlockSettings.of(Material.AGGREGATE, MapColor.PALE_YELLOW).strength(-1, -1));
    public static final Block DIGITAL_DARKNESS = new Block(FabricBlockSettings.of(Material.EGG).strength(-1, -1));
    public static final Block ELECTRIC_FLUORIDE_INFUSER = new ElectricFluorideInfuser();
    public static final Block EXTERNAL_ENERGY_ACCEPTOR = new ExternalPowerAcceptor(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ELECTROPLATING_MACHINE = new ElectroplatingMachine(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ELECTROPLATING_MACHINE_FRAME = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ELECTROPLATING_ANODE = new ElectroplatingRodImplements(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ELECTROPLATING_CATHODE = new ElectroplatingRodImplements(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ANODE_PART = new ElectroplatingRodParts(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block CATHODE_PART = new ElectroplatingRodParts(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block FLUORIDE_INFUSER = new FluorideInfuser();
    public static final Block FLUORITE_BLOCK = new Block(FabricBlockSettings.of(Material.AGGREGATE, MapColor.PALE_YELLOW).strength(-1, 10).sounds(BlockSoundGroup.SAND));
    public static final Block FLUORITE_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
    public static final Block FALSE_WATER = new Block(FabricBlockSettings.copyOf(Blocks.WATER));
    public static final Block FRONTIER_BLOCK = new FrontierBlock();
    public static final Block GUMMITE_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3, 10).sounds(BlockSoundGroup.STONE));
    public static final Block HOLOPROJECTOR = new HologramProjectorBlock();
    public static final Block LYOKO_CORE = new LyokoCore(FabricBlockSettings.copyOf(Blocks.DRAGON_EGG).noCollision().strength(-1, -1).luminance(Blocks.GLOWSTONE.getDefaultState().getLuminance() << 1));
    public static final Block MARABUNTA = new Marabunta();
    public static final Block METATYUYAMUNITE_ORE = new OreBlock(FabricBlockSettings.copy(Blocks.IRON_ORE));
    public static final Block METATORBERNITE_ORE = new OreBlock(FabricBlockSettings.copy(METATYUYAMUNITE_ORE));
    public static final Block METAAUTUNITE_ORE = new OreBlock(FabricBlockSettings.copy(AUTUNITE_ORE));
    public static final Block PROJECTOR_FOCUS = new ProjectorFocusblock();
    public static final Block QUANTUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL).strength(8, 20));
    public static final Block QUANTUM_CORE = new QuantumCore(FabricBlockSettings.of(Material.PORTAL));
    public static final Block QUANTUM_STEEL_BLOCK = new QuantumSteelBlock(FabricBlockSettings.of(Material.METAL).strength(6, 20).sounds(BlockSoundGroup.METAL));
    public static final Block SALEEITE_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
    public static final Block SCANNER_BASE = new Scanner();
    public static final Block SCANNER_FRAME = new ScannerFrame(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block SCANNER_TOP = new ScannerTop(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block STORAGE = new UniversalEnergyBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block SKLODOWSKITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4, 4).sounds(BlockSoundGroup.STONE));
    public static final Block SILICA_SAND = new SandBlock(0xFFFFFF, FabricBlockSettings.copy(Blocks.SAND));
    public static final Block SECTOR5_STEEL = new Block(FabricBlockSettings.of(Material.METAL).strength(-1, -1));
    public static final Block ROUTER = new Router(FabricBlockSettings.copy(Blocks.DRAGON_EGG));
    public static final Block TOWER_WHITE = new TowerGeneric();
    public static final Block TOWER_INTERFACE = new TowerInterface();
    public static final Block TOWER_BASE = new TowerBase();
    public static final Block TOWER_WALL = new TowerWall();
    public static final Block TOWER_BLUE = new TowerGeneric();
    public static final Block TOWER_TOP = new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK).strength(-1, -1).sounds(BlockSoundGroup.GLASS));
    public static final Block TOWER_WALL_CORNER = new TowerWallCorner();
    public static final Block TOWER_BASE_CORNER = new TowerWallCorner();
    public static final Block TOWER_BOTTOM = new TowerBottomBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.GLASS));
    public static final Block TYUYAMUNITE_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
    public static final Block TORBERNITE_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
    public static final Block TOWER_ENTER = new TowerEnter();
    public static final Block TITANIUM = new Block(FabricBlockSettings.of(Material.METAL).strength(6, 10).sounds(BlockSoundGroup.METAL));
    public static final Block URANUM_REACTOR = new ComputerIntegratedReactor();
    public static final Block URANINITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
    public static final Block URANIUM_BLOCK_238 = new Block(FabricBlockSettings.of(Material.METAL).strength(6, 20).sounds(BlockSoundGroup.METAL));
    public static final Block URANIUM_BLOCK_235 = new Block(FabricBlockSettings.of(Material.METAL).strength(6, 20).sounds(BlockSoundGroup.METAL));
    public static final Block URANIUM_CANISTER = new UraniumCanister(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(5, 5));
    public static final Block URANOPHANE_ORE = new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(4, 4));
    public static final Block UV_MACHINE = new Block(FabricBlockSettings.copyOf(Blocks.ANVIL));
    //public static final Block UV_FOCUS = new UVFocusBlock(FabricBlockSettings.copyOf(Blocks.GLASS));
    public static final Block UV_LIGHT = new Block(FabricBlockSettings.copyOf(Blocks.GLOWSTONE));


    public static final Block VOLCANO_GROUND = new Block(FabricBlockSettings.copyOf(Blocks.STONE));


    public static final Block DIGITAL_OCEAN_BLOCK = new DigitalSeaBlock();
    public static final Block DIGITAL_LAVA_BLOCK = new DigitalLavaBlock();
    public static final Block URANIUM_WASTE_BLOCK = new UraniumWaste();
    public static final Block LIQUID_HELIUM_BLOCK = new LiquidHelium();
    public static final ImmutableMap<String, Block> BLOCK_MAP = ImmutableMap.<String, Block>builder()
            .put("architecture_work_station", ARCHITECTURE_WORK_STATION)
            .put("anti_marabunta", ANTI_MARABUNTA)
            .put("autunite_ore", AUTUNITE_ORE)
            .put("black_void", BLACK_VOID)
            .put("bornite_ore", BORNITE_ORE)
            .put("cable_block", CABLE_BLOCK)
            .put("computer_screen_connector", COMPUTER_SCREEN_CONNECTOR)
            .put("chalcopyrite_ore", CHALCOPYRITE_ORE)
            .put("covellite_ore", COVELLITE_ORE)
            .put("chalcocite_ore", CHALCOCITE_ORE)
            .put("computer_frame", COMPUTER_FRAME)
            .put("central_control_unit", CENTRAL_CONTROL_UNIT)
            .put("computer_screen", COMPUTER_SCREEN)
            .put("computer_screen_frame", COMPUTER_SCREEN_FRAME)
            .put("computer_keyboard", COMPUTER_KEYBOARD)
            .put("chiplet_basic_block", CHIPLET_BASIC_BLOCK)
            .put("chiplet_advanced_block", CHIPLET_ADVANCED_BLOCK)
            .put("chiplet_franz_block", CHIPLET_FRANZ_BLOCK)
            .put("computer_cooling_block", COMPUTER_COOLING_BLOCK)
            .put("computer_liquid_circulator", COMPUTER_LIQUID_CIRCULATOR)
            .put("computer_tower_control_panel", COMPUTER_TOWER_CONTROL_PANEL)
            .put("coffinite_ore", COFFINITE_ORE)
            .put("carnotite_ore", CARNOTITE_ORE)
            .put("data_transfer_interface", DATA_TRANSFER_INTERFACE)
            .put("digital_sea_pylon", DIGITAL_SEA_PYLON)
            .put("digital_grass", DIGITAL_GRASS)
            .put("digital_dirt", DIGITAL_DIRT)
            .put("digital_rock", DIGITAL_ROCK)
            .put("digital_wood_forest", DIGITAL_WOOD_FOREST)
            .put("digital_wood_mountain", DIGITAL_WOOD_MOUNTAIN)
            .put("digital_leaf_mountain", DIGITAL_LEAF_MOUNTAIN)
            .put("digital_ice", DIGITAL_ICE)
            .put("digital_sand", DIGITAL_SAND)
            .put("digital_darkness", DIGITAL_DARKNESS)
            .put("electric_fluoride_infuser", ELECTRIC_FLUORIDE_INFUSER)
            .put("external_energy_acceptor", EXTERNAL_ENERGY_ACCEPTOR)
            .put("electroplating_machine", ELECTROPLATING_MACHINE)
            .put("electroplating_machine_frame", ELECTROPLATING_MACHINE_FRAME)
            .put("electroplating_anode", ELECTROPLATING_ANODE)
            .put("electroplating_cathode", ELECTROPLATING_CATHODE)
            .put("anodepart", ANODE_PART)
            .put("cathodepart", CATHODE_PART)
            .put("fluoride_infuser", FLUORIDE_INFUSER)
            .put("fluorite_block", FLUORITE_BLOCK)
            .put("fluorite_ore", FLUORITE_ORE)
            .put("false_water", FALSE_WATER)
            .put("frontier_block", FRONTIER_BLOCK)
            .put("gummite_ore", GUMMITE_ORE)
            .put("holoprojector", HOLOPROJECTOR)
            .put("lyoko_core", LYOKO_CORE)
            .put("marabunta", MARABUNTA)
            .put("metatyuyamunite_ore", METATYUYAMUNITE_ORE)
            .put("metatorbernite_ore", METATORBERNITE_ORE)
            .put("metaautunite_ore", METAAUTUNITE_ORE)
            .put("projector_focus", PROJECTOR_FOCUS)
            .put("quantum_block", QUANTUM_BLOCK)
            .put("quantum_core", QUANTUM_CORE)
            .put("quantum_steel", QUANTUM_STEEL_BLOCK)
            .put("saleeite_ore", SALEEITE_ORE)
            .put("scanner_base", SCANNER_BASE)
            .put("scanner_frame", SCANNER_FRAME)
            .put("scanner_top", SCANNER_TOP)
            .put("universal", STORAGE)
            .put("sklodowskite_ore", SKLODOWSKITE_ORE)
            .put("silica_sand", SILICA_SAND)
            .put("sector5_steel", SECTOR5_STEEL)
            .put("router", ROUTER)
            .put("tower_interface", TOWER_INTERFACE)
            .put("tower_white", TOWER_WHITE)
            .put("tower_base", TOWER_BASE)
            .put("tower_wall", TOWER_WALL)
            .put("tower_blue", TOWER_BLUE)
            .put("tower_top", TOWER_TOP)
            .put("tower_wall_corner", TOWER_WALL_CORNER)
            .put("tower_base_corner", TOWER_BASE_CORNER)
            .put("tower_bottom", TOWER_BOTTOM)
            .put("tyuyamunite_ore", TYUYAMUNITE_ORE)
            .put("torbernite_ore", TORBERNITE_ORE)
            .put("tower_enter", TOWER_ENTER)
            .put("titanium_block", TITANIUM)
            .put("computer_reactor", URANUM_REACTOR)
            .put("uraninite_ore", URANINITE_ORE)
            .put("uranium_block_238", URANIUM_BLOCK_238)
            .put("uranium_block_235", URANIUM_BLOCK_235)
            .put("uranium_canister", URANIUM_CANISTER)
            .put("uranophane_ore", URANOPHANE_ORE)
            .put("uv_machine", UV_MACHINE)
            //.put("uv_focus", UV_FOCUS)
            .put("uv_light", UV_LIGHT)
            //other blocks here
            .put("volcano_ground", VOLCANO_GROUND)
            //fluidblocks
            .put("digital_ocean", DIGITAL_OCEAN_BLOCK)
            .put("digital_lava", DIGITAL_LAVA_BLOCK)
            .put("uranium_waste", URANIUM_WASTE_BLOCK)
            .put("liquid_helium", LIQUID_HELIUM_BLOCK)
            .build();

}