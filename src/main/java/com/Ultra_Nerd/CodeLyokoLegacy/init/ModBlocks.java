package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.blocks.*;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition.DigitalLavaBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition.DigitalSeaBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition.LiquidHelium;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition.UraniumWaste;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.*;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.Electricity.LaptopCharger;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.Electricity.RackChargerBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.Electricity.UniversalEnergyBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.electroplate.ElectroplatingMachine;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.flouride.ElectricFluorideInfuser;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.flouride.FluorideInfuser;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests.*;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower.*;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;

public record ModBlocks() {
    //for blocks
    public static final Block ARCHITECTURE_WORK_STATION = new ArchitectureWorkstation(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    //public static final RegistryObject<Block> ARCHITECTURE_WORK_STATION = BLOCKS.register("architecture_work_station", () -> new ArchitectureWorkstation(Block.Properties.copyOf(Blocks.IRON_BLOCK)));
    public static final Block ANTI_MARABUNTA = new AntiMarabunta();
    public static final Block AUTUNITE_ORE = new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE));
    public static final Block BLACK_VOID = new BlackVoid();
    public static final Block BORNITE_ORE = new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE));
    public static final Block CABLE_BLOCK = new CableBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_SCREEN_CONNECTOR = new FenceBlock(
            FabricBlockSettings.copyOf(Blocks.IRON_BARS)){
        @Override
        public BlockState getPlacementState(final ItemPlacementContext ctx) {
            return this.getDefaultState().with(ComputerKeyboard.IS_SCREEN_FORMED, Boolean.FALSE);
        }

        @Override
        protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
            super.appendProperties(builder.add(ComputerKeyboard.IS_SCREEN_FORMED));
        }
    };
    public static final Block CHALCOPYRITE_ORE = new ExperienceDroppingBlock(FabricBlockSettings.copyOf(
            Blocks.IRON_ORE));//BLOCKS.register("chalcopyrite_ore", () -> new Block(Block.Properties.copyOf(Blocks.IRON_ORE)));
    public static final Block COVELLITE_ORE = new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE));
    public static final Block CHALCOCITE_ORE = new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE));
    public static final Block COMPUTER_FRAME = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block CENTRAL_CONTROL_UNIT = new ComputerCoreUnit(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_SCREEN = new Block(
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
    };
    public static final Block COMPUTER_SCREEN_FRAME = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)){
        @Override
        public BlockState getPlacementState(final ItemPlacementContext ctx) {
            return this.getDefaultState().with(ComputerKeyboard.IS_SCREEN_FORMED, Boolean.FALSE);
        }
        @Override
        protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
            super.appendProperties(builder.add(ComputerKeyboard.IS_SCREEN_FORMED));
        }
    };
    public static final Block COMPUTER_CORE = new ComputerCoreUnit(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_KEYBOARD = new ComputerKeyboard();
    public static final Block CHIPLET_BASIC_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block CHIPLET_ADVANCED_BLOCK = new ChipletAdvancedBlock(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque());
    public static final Block CHIPLET_FRANZ_BLOCK = new FranzChiplet(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_COOLING_BLOCK = new CoolingBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_LIQUID_CIRCULATOR = new ComputerFluidCirculator(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_LIQUID_PIPE = new BaseComputerPipe(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_LIQUID_INTAKE_PUMP = new ComputerIntakePump(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_TOWER_CONTROL_PANEL = new ControlPanel();

    public static final Block COFFINITE_ORE = new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE));
    public static final Block CARNOTITE_ORE = new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE));
    public static final Block DATA_TRANSFER_INTERFACE = new DataTransferInterface();
    public static final Block DIGITAL_SEA_PYLON = new SeaPylon();
    public static final Block DIGITAL_GRASS = new Block(
            FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).allowsSpawning((state, world, pos, type) -> true)
                    .strength(-1, Integer.MAX_VALUE));
    public static final Block DIGITAL_DIRT = new Block(FabricBlockSettings.copyOf(Blocks.DIRT).strength(-1,
            Integer.MAX_VALUE));
    public static final Block DIGITAL_ROCK = new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(-1, Integer.MAX_VALUE)
            .allowsSpawning((state, world, pos, type) -> true));
    public static final Block DIGITAL_WOOD_FOREST = new Block(
            FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(-1, Integer.MAX_VALUE));
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

    public static final Block DIGITAL_ICE = new IceBlock(FabricBlockSettings.copyOf(Blocks.ICE).strength(-1, Integer.MAX_VALUE));
    public static final Block DIGITAL_SAND = new Block(
            FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).strength(-1, Integer.MAX_VALUE));
    public static final Block DIGITAL_DARKNESS = new Block(FabricBlockSettings.copyOf(Blocks.DRAGON_EGG).strength(-1,
            Integer.MAX_VALUE));
    public static final Block ELECTRIC_FLUORIDE_INFUSER = new ElectricFluorideInfuser();
    public static final Block EXTERNAL_ENERGY_ACCEPTOR = new ExternalPowerAcceptor(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ELECTROPLATING_MACHINE = new ElectroplatingMachine(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ELECTROPLATING_MACHINE_FRAME = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ELECTROPLATING_ANODE = new ElectroplatingRodImplements(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ELECTROPLATING_CATHODE = new ElectroplatingRodImplements(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ANODE_PART = new ElectroplatingRodParts(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block CATHODE_PART = new ElectroplatingRodParts(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block FLUORIDE_INFUSER = new FluorideInfuser();
    public static final Block FLUORITE_BLOCK = new Block(
            FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).strength(-1, 10)
                    .sounds(BlockSoundGroup.SAND));
    public static final Block FLUORITE_ORE = new ExperienceDroppingBlock(
            FabricBlockSettings.copyOf(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
    public static final Block FALSE_WATER = new Block(FabricBlockSettings.copyOf(Blocks.WATER).noCollision());
    public static final Block FRONTIER_BLOCK = new FrontierBlock();
    public static final Block GUMMITE_ORE = new ExperienceDroppingBlock(
            FabricBlockSettings.copyOf(Blocks.STONE).strength(3, 10).sounds(BlockSoundGroup.STONE));
    public static final Block HOLOPROJECTOR = new HologramProjectorBlock();
    public static final Block LYOKO_CORE = new LyokoCore(
            FabricBlockSettings.copyOf(Blocks.DRAGON_EGG).dropsNothing().nonOpaque().strength(-1, -1)
                    .luminance(Blocks.GLOWSTONE.getDefaultState().getLuminance()));
    public static final Block MARABUNTA = new Marabunta();
    public static final Block METATYUYAMUNITE_ORE = new ExperienceDroppingBlock(FabricBlockSettings.copy(Blocks.IRON_ORE));
    public static final Block METATORBERNITE_ORE = new ExperienceDroppingBlock(FabricBlockSettings.copy(METATYUYAMUNITE_ORE));
    public static final Block METAAUTUNITE_ORE = new ExperienceDroppingBlock(FabricBlockSettings.copy(AUTUNITE_ORE));

    public static final Block PROJECTOR_FOCUS = new ProjectorFocusblock();
    public static final Block QUANTUM_BLOCK = new Block(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL).strength(8, 20));
    public static final Block QUANTUM_CORE = new Block(FabricBlockSettings.copyOf(Blocks.END_PORTAL));
    public static final Block QUANTUM_STEEL_BLOCK = new QuantumSteelBlock(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(6, 20).sounds(BlockSoundGroup.METAL));
    public static final Block RACK_CHARGER_BLOCK = new RackChargerBlock(FabricBlockSettings.copyOf(Blocks.REDSTONE_BLOCK));
    public static final Block SALEEITE_ORE = new ExperienceDroppingBlock(
            FabricBlockSettings.copyOf(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
    public static final Block SCANNER_BASE = new Scanner();
    public static final Block SCANNER_FRAME = new ScannerFrame(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block SCANNER_TOP = new ScannerTop(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block STORAGE = new UniversalEnergyBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block SKLODOWSKITE_ORE = new Block(
            FabricBlockSettings.copyOf(Blocks.STONE).strength(4, 4).sounds(BlockSoundGroup.STONE));
    public static final Block SILICA_SAND = new SandBlock(0xFFFFFF, FabricBlockSettings.copy(Blocks.SAND));
    public static final Block SECTOR5_STEEL = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(-1,
            Integer.MAX_VALUE));
    public static final Block ROUTER = new Router(FabricBlockSettings.copyOf(Blocks.DRAGON_EGG));
    public static final Block TOWER_WHITE =
            new Block(FabricBlockSettings.copyOf(Blocks.BARRIER).strength(-1, Integer.MAX_VALUE).sounds(BlockSoundGroup.GLASS).luminance(250));
    public static final Block TOWER_INTERFACE = new TowerInterface();
    public static final Block TOWER_BASE = new TowerWall();
    public static final Block TOWER_WALL = new TowerWall();
    public static final Block TOWER_BLUE = new Block(FabricBlockSettings.copyOf(Blocks.BARRIER).strength(-1,
            Integer.MAX_VALUE).sounds(BlockSoundGroup.GLASS).luminance(250));
    public static final Block TOWER_TOP = new Block(
            FabricBlockSettings.copy(Blocks.IRON_BLOCK).strength(-1, Integer.MAX_VALUE).sounds(BlockSoundGroup.GLASS));
    public static final Block TOWER_WALL_CORNER = new TowerWallCorner();
    public static final Block TOWER_BASE_CORNER = new TowerWallCorner();
    public static final Block TOWER_BOTTOM = new TowerBottomBlock(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.GLASS));
    public static final Block TYUYAMUNITE_ORE = new ExperienceDroppingBlock(
            FabricBlockSettings.copyOf(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
    public static final Block TORBERNITE_ORE = new ExperienceDroppingBlock(
            FabricBlockSettings.copyOf(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
    public static final Block TOWER_ENTER = new TowerEnter();
    public static final Block TITANIUM = new Block(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(6, 10).sounds(BlockSoundGroup.METAL));
    public static final Block URANUM_REACTOR = new ComputerIntegratedReactor();
    public static final Block URANINITE_ORE = new Block(
            FabricBlockSettings.copyOf(Blocks.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
    public static final Block URANIUM_BLOCK_238 = new Block(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(6, 20).sounds(BlockSoundGroup.METAL));
    public static final Block URANIUM_BLOCK_235 = new Block(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(6, 20).sounds(BlockSoundGroup.METAL));
    public static final Block URANIUM_CANISTER = new UraniumCanister(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(5, 5));
    public static final Block URANOPHANE_ORE = new Block(
            FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).strength(4, 4));
    public static final Block UV_MACHINE = new Block(FabricBlockSettings.copyOf(Blocks.ANVIL));
    //public static final Block UV_FOCUS = new UVFocusBlock(FabricBlockSettings.copyOf(Blocks.GLASS));
    public static final Block UV_LIGHT = new Block(FabricBlockSettings.copyOf(Blocks.GLOWSTONE));
    public static final Block VOLCANO_GROUND = new Block(FabricBlockSettings.copyOf(Blocks.STONE));
    public static final Block DIGITAL_OCEAN_BLOCK = new DigitalSeaBlock();
    public static final Block DIGITAL_LAVA_BLOCK = new DigitalLavaBlock();
    public static final Block URANIUM_WASTE_BLOCK = new UraniumWaste();
    public static final Block LIQUID_HELIUM_BLOCK = new LiquidHelium();
    public static final LaptopCharger LAPTOP_CHARGER = new LaptopCharger(FabricBlockSettings.copy(Blocks.ANVIL));
    public static final Block TESTUI = new TestComputerUI(FabricBlockSettings.copy(Blocks.IRON_BLOCK));
    public static final Block TEST_PROFILE = new PlayerCustomProfileTest(FabricBlockSettings.copyOf(Blocks.BARRIER));
    public static final Block TEST_SPHERE = new TestSphereRenderer(FabricBlockSettings.copyOf(Blocks.BARRIER));
    public static final Block TEST_VECHICLE_INTERFACE =
            new PlayerVehicleTest(FabricBlockSettings.copyOf(Blocks.BARRIER));
    public static final Block TEST_ITEM_PROJECTOR = new ItemProjectorTest();
    public static final Block COMPUTER_FLUID_COOLER = new ComputerFluidCooler(FabricBlockSettings.copyOf(Blocks.IRON_BARS));
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
            .put("computer_liquid_pipe",COMPUTER_LIQUID_PIPE)
            .put("computer_fluid_intake",COMPUTER_LIQUID_INTAKE_PUMP)
            .put("computer_fluid_cooler",COMPUTER_FLUID_COOLER)
            .put("computer_tower_control_panel", COMPUTER_TOWER_CONTROL_PANEL)
            .put("computer_core",COMPUTER_CORE)
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
            .put("core_of_lyoko", LYOKO_CORE)
            .put("marabunta", MARABUNTA)
            .put("metatyuyamunite_ore", METATYUYAMUNITE_ORE)
            .put("metatorbernite_ore", METATORBERNITE_ORE)
            .put("metaautunite_ore", METAAUTUNITE_ORE)
            .put("projector_focus", PROJECTOR_FOCUS)
            .put("quantum_block", QUANTUM_BLOCK)
            .put("quantum_core", QUANTUM_CORE)
            .put("quantum_steel", QUANTUM_STEEL_BLOCK)
            .put("rack_charger",RACK_CHARGER_BLOCK)
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
            .put("laptop_charger", LAPTOP_CHARGER)
            .put("test_ui",TESTUI)
            .put("player_profile_block",TEST_PROFILE)
            .put("test_phere",TEST_SPHERE)
            .put("test_vechicle_materialization",TEST_VECHICLE_INTERFACE)
            .put("test_item_projector",TEST_ITEM_PROJECTOR)
            .build();
}