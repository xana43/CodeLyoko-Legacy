package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.blocks.*;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.*;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests.DataTransferInterface;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower.TowerInterface;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

import java.util.HashMap;
import java.util.Map;

public final class ModBlocks {



    public static final Map<String,Block> BLOCK_MAP = new HashMap<>(200);

    private static AbstractBlock.Settings QuickCopy(AbstractBlock block)
    {
        return FabricBlockSettings.copy(block);
    }

    public static void addBlocksToRegistry()
    {
        //BLOCK_MAP.put("architecture_work_station",ARCHITECTURE_WORK_STATION);
        BLOCK_MAP.put("anti_marabunta",ANTI_MARABUNTA);
        BLOCK_MAP.put("autunite_ore",AUTUNITE_ORE);
        BLOCK_MAP.put("black_void",BLACK_VOID);
        BLOCK_MAP.put("bornite_ore",BORNITE_ORE);
        BLOCK_MAP.put("cable_block",CABLE_BLOCK);
        BLOCK_MAP.put("computer_screen_connector",COMPUTER_SCREEN_CONNECTOR);
        BLOCK_MAP.put("chalcopyrite_ore",CHALCOPYRITE_ORE);
        BLOCK_MAP.put("covellite_ore",COVELLITE_ORE);
        BLOCK_MAP.put("chalcocite_ore",CHALCOCITE_ORE);
        BLOCK_MAP.put("computer_frame",COMPUTER_FRAME);
        BLOCK_MAP.put("central_control_unit",CENTRAL_CONTROL_UNIT);
        BLOCK_MAP.put("computer_screen",COMPUTER_SCREEN);
        BLOCK_MAP.put("computer_screen_frame",COMPUTER_SCREEN_FRAME);
        BLOCK_MAP.put("computer_keyboard",COMPUTER_KEYBOARD);
        BLOCK_MAP.put("chiplet_basic_block",CHIPLET_BASIC_BLOCK);
        BLOCK_MAP.put("chiplet_advanced_block",CHIPLET_ADVANCED_BLOCK);
        BLOCK_MAP.put("chiplet_franz_block",CHIPLET_FRANZ_BLOCK);
        BLOCK_MAP.put("computer_cooling_block",COMPUTER_COOLING_BLOCK);
        BLOCK_MAP.put("computer_liquid_circulator",COMPUTER_LIQUID_CIRCULATOR);
        BLOCK_MAP.put("computer_tower_control_panel",COMPUTER_TOWER_CONTROL_PANEL);
        BLOCK_MAP.put("coffinite_ore",COFFINITE_ORE);
        BLOCK_MAP.put("carnotite_ore",CARNOTITE_ORE);
        BLOCK_MAP.put("data_transfer_interface",DATA_TRANSFER_INTERFACE);
        BLOCK_MAP.put("digital_sea_pylon",DIGITAL_SEA_PYLON);
        BLOCK_MAP.put("digital_grass",DIGITAL_GRASS);
        BLOCK_MAP.put("digital_dirt",DIGITAL_DIRT);
        BLOCK_MAP.put("digital_rock",DIGITAL_ROCK);
        BLOCK_MAP.put("digital_wood_forest",DIGITAL_WOOD_FOREST);
        BLOCK_MAP.put("digital_wood_mountain",DIGITAL_WOOD_MOUNTAIN);
        BLOCK_MAP.put("digital_leaf_mountain",DIGITAL_LEAF_MOUNTAIN);
        BLOCK_MAP.put("tower_interface",TOWER_INTERFACE);
        BLOCK_MAP.put("lyoko_core",LYOKO_CORE);

    }

    //for blocks
   // public static final Block ARCHITECTURE_WORK_STATION = new ArchitectureWorkstation(FabricBlockSettings.copy(Blocks.IRON_BLOCK));
    //public static final RegistryObject<Block> ARCHITECTURE_WORK_STATION = BLOCKS.register("architecture_work_station", () -> new ArchitectureWorkstation(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final Block ANTI_MARABUNTA = new AntiMarabunta();
    public static final Block AUTUNITE_ORE = new OreBlock(FabricBlockSettings.copy(Blocks.IRON_ORE));
    public static final Block BLACK_VOID = new BlackVoid();
    public static final Block BORNITE_ORE = new OreBlock(FabricBlockSettings.copy(Blocks.IRON_ORE));
    public static final Block CABLE_BLOCK = new CableBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_SCREEN_CONNECTOR = new SuperComputerSideScreenConnector(QuickCopy(Blocks.IRON_BARS));//BLOCKS.register("computer_screen_connector", () -> new SuperComputerSideScreenConnector(BlockBehaviour.Properties.copy(Blocks.IRON_BARS)));
    public static final Block CHALCOPYRITE_ORE = new OreBlock(QuickCopy(Blocks.IRON_ORE));//BLOCKS.register("chalcopyrite_ore", () -> new Block(Block.Properties.copy(Blocks.IRON_ORE)));
    public static final Block COVELLITE_ORE = new OreBlock(QuickCopy(Blocks.IRON_ORE));
    public static final Block CHALCOCITE_ORE = new OreBlock(QuickCopy(Blocks.IRON_ORE));
    public static final Block COMPUTER_FRAME = new Block(QuickCopy(Blocks.IRON_BLOCK));
    public static final Block CENTRAL_CONTROL_UNIT = new ComputerCentralControlUnit(QuickCopy(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_SCREEN = new Block(FabricBlockSettings.of(Material.GLASS).strength(1, Blocks.GLASS.getBlastResistance()).sounds(BlockSoundGroup.GLASS));
    public static final Block COMPUTER_SCREEN_FRAME = new Block(QuickCopy(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_KEYBOARD = new ComputerKeyboard();
    public static final Block CHIPLET_BASIC_BLOCK = new Block(QuickCopy(Blocks.IRON_BLOCK));
    public static final Block CHIPLET_ADVANCED_BLOCK = new ChipletAdvancedBlock(QuickCopy(Blocks.IRON_BLOCK));
    public static final Block CHIPLET_FRANZ_BLOCK = new FranzChiplet(QuickCopy(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_COOLING_BLOCK = new CoolingBlock(QuickCopy(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_LIQUID_CIRCULATOR = new Block(QuickCopy(Blocks.IRON_BLOCK));
    public static final Block COMPUTER_TOWER_CONTROL_PANEL = new ControlPanel();
    public static final Block COFFINITE_ORE = new OreBlock(QuickCopy(Blocks.IRON_ORE));
    public static final Block CARNOTITE_ORE = new OreBlock(QuickCopy(Blocks.DIAMOND_ORE));
    public static final Block DATA_TRANSFER_INTERFACE = new DataTransferInterface();
    public static final Block DIGITAL_SEA_PYLON = new SeaPylon();
    public static final Block DIGITAL_GRASS = new Block(QuickCopy(Blocks.GRASS_BLOCK).allowsSpawning((state, world, pos, type) -> true).strength(-1,-1));
    public static final Block DIGITAL_DIRT = new Block(QuickCopy(Blocks.DIRT).strength(-1,-1));
    public static final Block DIGITAL_ROCK = new Block(QuickCopy(Blocks.STONE).strength(-1,-1));
    public static final Block DIGITAL_WOOD_FOREST = new Block(QuickCopy(Blocks.OAK_WOOD).strength(-1,-1));
    public static final Block DIGITAL_WOOD_MOUNTAIN = new Block(QuickCopy(Blocks.JUNGLE_WOOD));
    public static final Block DIGITAL_LEAF_MOUNTAIN = new LeavesBlock(QuickCopy(Blocks.JUNGLE_LEAVES));

/*
    public static void registerTestBlocks()
    {
        if(!FMLEnvironment.production)
        {
            BLOCKS.register("portal_block", () -> new TestBlockPortal(Block.Properties.copy(Blocks.NETHER_PORTAL)));
            //BLOCKS.register("block_pattern", () -> new BlockPatternTest(Block.Properties.copy(Blocks.IRON_BLOCK)));
            BLOCKS.register("digital_mountain_sapling", () -> new DigitalMountainSapling(new AbstractTreeGrower() {
                @Override
                protected @NotNull Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull Random pRandom, boolean pLargeHive) {
                    return ModFeature.DIGITAL_MOUNTAIN_TREE_FEATURE;
                }
            }, Block.Properties.copy(Blocks.ACACIA_SAPLING)));
            //BLOCKS.register("test_caller", () -> new TestCaller(BlockBehaviour.Properties.copy(Blocks.BARRIER)));

             BLOCKS.register("digital_tree_forest_sapling", () -> new DigitalSapling(new AbstractTreeGrower() {
            @Override
            protected @NotNull Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull Random pRandom, boolean pLargeHive) {
                return ModFeature.DIGITAL_FOREST_TREE_FEATURE;
            }
        }, Block.Properties.copy(Blocks.JUNGLE_SAPLING)));
        }
    }
    */
    /*
    public static final RegistryObject<Block> DIGITAL_ICE = BLOCKS.register("digital_ice", () -> new IceBlock(Block.Properties.copy(Blocks.ICE).strength(-1).explosionResistance(-1)));
    public static final RegistryObject<Block> DIGITAL_SAND = BLOCKS.register("digital_sand", () -> new Block(Block.Properties.of(Material.SAND)));
    public static final RegistryObject<Block> DIGITAL_DARKNESS = BLOCKS.register("digital_darkness", () -> new Block(Block.Properties.of(Material.EGG)));
    public static final RegistryObject<Block> ELECTRIC_FLUORIDE_INFUSER = BLOCKS.register("electric_fluoride_infuser", ElectricFluorideInfuser::new);
    public static final RegistryObject<Block> EXTERNAL_ENERGY_ACCEPTOR = BLOCKS.register("external_energy_acceptor", () -> new ExternalPowerAcceptor(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ELECTROPLATING_MACHINE = BLOCKS.register("electroplating_machine", () -> new ElectroplatingMachine(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ELECTROPLATING_MACHINE_FRAME = BLOCKS.register("electroplating_machine_frame", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ELECTROPLATING_ANODE = BLOCKS.register("electroplating_anode", () -> new ElectroplatingRodImplements(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ELECTROPLATING_CATHODE = BLOCKS.register("electroplating_cathode", () -> new ElectroplatingRodImplements(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ANODE_PART = BLOCKS.register("anodepart", () -> new ElectroplatingRodParts(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> CATHODE_PART = BLOCKS.register("cathodepart", () -> new ElectroplatingRodParts(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> FLUORIDE_INFUSER = BLOCKS.register("fluoride_infuser", FluorideInfuser::new);
    public static final RegistryObject<Block> FLUORITE_BLOCK = BLOCKS.register("fluorite_block", () -> new Block(Block.Properties.of(Material.SAND).strength(-1, 10).sound(SoundType.SAND)));
    public static final RegistryObject<Block> FLUORITE_ORE = BLOCKS.register("fluorite_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(6, 10).sound(SoundType.STONE)));
    public static final RegistryObject<Block> FALSE_WATER = BLOCKS.register("false_water", () -> new Block(Block.Properties.copy(Blocks.WATER)));
    public static final RegistryObject<Block> FRONTIER_BLOCK = BLOCKS.register("frontier_block", FrontierBlock::new);
    public static final RegistryObject<Block> GUMMITE_ORE = BLOCKS.register("gummite_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3, 10).sound(SoundType.STONE)));
    public static final RegistryObject<Block> HOLOPROJECTOR = BLOCKS.register("holoprojector", HologramProjectorBlock::new);
   */
    public static final Block LYOKO_CORE = new LyokoCore(FabricBlockSettings.copy(Blocks.DRAGON_EGG).noCollision().strength(-1,-1));

    /*
    public static final RegistryObject<Block> MARABUNTA = BLOCKS.register("marabunta", Marabunta::new);
    public static final RegistryObject<Block> METATYUYAMUNITE_ORE = BLOCKS.register("metatyuyamunite_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3, 10).sound(SoundType.STONE)));
    public static final RegistryObject<Block> METATORBERNITE_ORE = BLOCKS.register("metatorbernite_ore", () -> new OreBlock(Block.Properties.copy(METATYUYAMUNITE_ORE.get())));
    public static final RegistryObject<Block> METAAUTUNITE_ORE = BLOCKS.register("metaautunite_ore", () -> new OreBlock(Block.Properties.copy(AUTUNITE_ORE.get())));
    public static final RegistryObject<Block> PROJECTOR_FOCUS = BLOCKS.register("projector_focus", ProjectorFocusblock::new);
    public static final RegistryObject<Block> QUANTUM_BLOCK = BLOCKS.register("quantum_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(6, 20).sound(SoundType.METAL)));
    public static final RegistryObject<Block> QUANTUM_CORE = BLOCKS.register("quantum_core", () -> new QuantumCore(Block.Properties.of(Material.DECORATION).strength(1, 20).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> QUANTUM_STEEL_BLOCK = BLOCKS.register("quantum_steel", () -> new QuantumSteelBlock(Block.Properties.of(Material.HEAVY_METAL).strength(6, 20).sound(SoundType.METAL)));
    public static final RegistryObject<Block> SALEEITE_ORE = BLOCKS.register("saleeite_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(6, 10).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SCANNER_BASE = BLOCKS.register("scanner_base", Scanner::new);
    public static final RegistryObject<Block> SCANNER_FRAME = BLOCKS.register("scanner_frame", () -> new ScannerFrame(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> SCANNER_TOP = BLOCKS.register("scanner_top", () -> new ScannerTop(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STORAGE = BLOCKS.register("universal", UniversalEnergyBlock::new);
    public static final RegistryObject<Block> SKLODOWSKITE_ORE = BLOCKS.register("sklodowskite_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(4, 4).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SILICA_SAND = BLOCKS.register("silica_sand", () -> new SandBlock(0xFFFFFF, Block.Properties.copy(Blocks.SAND)));
    public static final RegistryObject<Block> SECTOR5_STEEL = BLOCKS.register("sector5_steel", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(-1, -1)));
    public static final RegistryObject<Block> ROUTER = BLOCKS.register("router", () -> new Router(Block.Properties.copy(Blocks.DRAGON_EGG)));
    public static final RegistryObject<Block> TOWER_WHITE = BLOCKS.register("tower_white", TowerGeneric::new);
    */
    public static final Block TOWER_INTERFACE = new TowerInterface();
    /*public static final RegistryObject<Block> TOWER_BASE = BLOCKS.register("tower_base", TowerBase::new);
    public static final RegistryObject<Block> TOWER_WALL = BLOCKS.register("tower_wall", TowerWall::new);
    public static final RegistryObject<Block> TOWER_BLUE = BLOCKS.register("tower_blue", TowerGeneric::new);
    public static final RegistryObject<Block> TOWER_TOP = BLOCKS.register("tower_top", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> TOWER_WALL_CORNER = BLOCKS.register("tower_wall_corner", TowerWallCorner::new);
    public static final RegistryObject<Block> TOWER_BASE_CORNER = BLOCKS.register("tower_base_corner", TowerBaseCorner::new);
    public static final RegistryObject<TowerBottomBlock> TOWER_BOTTOM = BLOCKS.register("tower_bottom", () -> new TowerBottomBlock(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> TYUYAMUNITE_ORE = BLOCKS.register("tyuyamunite_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(6, 10).sound(SoundType.STONE)));
    public static final RegistryObject<Block> TORBERNITE_ORE = BLOCKS.register("torbernite_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(6, 10).sound(SoundType.STONE)));
    public static final RegistryObject<Block> TOWER_ENTER = BLOCKS.register("tower_enter", TowerEnter::new);
    public static final RegistryObject<Block> TITANIUM = BLOCKS.register("titanium_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(6, 10).sound(SoundType.METAL)));
    public static final RegistryObject<Block> TRANSPARENT = BLOCKS.register("transparent", TransparentBlock::new);
    public static final RegistryObject<Block> URANUM_REACTOR = BLOCKS.register("computer_reactor", ComputerIntegratedReactor::new);
    public static final RegistryObject<Block> URANINITE_ORE = BLOCKS.register("uraninite_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(6, 10).sound(SoundType.STONE)));
    public static final RegistryObject<Block> URANIUM_BLOCK_238 = BLOCKS.register("uranium_block_238", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(6, 20).sound(SoundType.METAL)));
    public static final RegistryObject<Block> URANIUM_BLOCK_235 = BLOCKS.register("uranium_block_235", () -> new Block(Block.Properties.of(Material.METAL).strength(6, 20).sound(SoundType.METAL)));
    public static final RegistryObject<Block> URANIUM_CANISTER = BLOCKS.register("uranium_canister", () -> new UraniumCanister(Block.Properties.of(Material.EGG).requiresCorrectToolForDrops().strength(5, 5)));
    public static final RegistryObject<Block> URANOPHANE_ORE = BLOCKS.register("uranophane_ore", () -> new Block(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(4, 4)));
    public static final RegistryObject<Block> UV_MACHINE = BLOCKS.register("uv_machine", () -> new Block(Block.Properties.copy(Blocks.ANVIL)));
    public static final RegistryObject<Block> UV_FOCUS = BLOCKS.register("uv_focus", () -> new UVFocusBlock(Block.Properties.copy(Blocks.GLASS)));
    public static final RegistryObject<Block> UV_LIGHT = BLOCKS.register("uv_light", () -> new Block(Block.Properties.copy(Blocks.GLOWSTONE)));
    public static final RegistryObject<Block> VOLCANO_GROUND = BLOCKS.register("volcano_ground", () -> new Block(Block.Properties.copy(Blocks.STONE)));

   */
}