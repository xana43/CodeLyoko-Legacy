package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.blocks.*;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition.DigitalLavaBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition.DigitalSeaBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.*;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.electroplate.ElectroplatingMachine;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.flouride.ElectricFluorideInfuser;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.flouride.FluorideInfuser;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests.DataTransferInterface;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower.TowerGeneric;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower.TowerInterface;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public final class ModBlocks {








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
    public static final Block DIGITAL_GRASS = new Block(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).allowsSpawning((state, world, pos, type) -> true).strength(-1,-1));
    public static final Block DIGITAL_DIRT = new Block(FabricBlockSettings.copyOf(Blocks.DIRT).strength(-1,-1));
    public static final Block DIGITAL_ROCK = new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(-1,-1));
    public static final Block DIGITAL_WOOD_FOREST = new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(-1,-1));
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

    public static final Block DIGITAL_ICE = new IceBlock(FabricBlockSettings.copyOf(Blocks.ICE).strength(-1,-1));
    public static final Block DIGITAL_SAND = new Block(FabricBlockSettings.of(Material.AGGREGATE,MapColor.PALE_YELLOW).strength(-1,-1));
    public static final Block DIGITAL_DARKNESS = new Block(FabricBlockSettings.of(Material.EGG).strength(-1,-1));
    public static final Block ELECTRIC_FLUORIDE_INFUSER = new ElectricFluorideInfuser();
    public static final Block EXTERNAL_ENERGY_ACCEPTOR = new ExternalPowerAcceptor(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ELECTROPLATING_MACHINE = new ElectroplatingMachine(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ELECTROPLATING_MACHINE_FRAME = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ELECTROPLATING_ANODE = new ElectroplatingRodImplements(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ELECTROPLATING_CATHODE = new ElectroplatingRodImplements(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block ANODE_PART = new ElectroplatingRodParts(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block CATHODE_PART = new ElectroplatingRodParts(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block FLUORIDE_INFUSER = new FluorideInfuser();
    public static final Block FLUORITE_BLOCK = new Block(FabricBlockSettings.of(Material.AGGREGATE,MapColor.PALE_YELLOW).strength(-1, 10).sounds(BlockSoundGroup.SAND));
    public static final Block FLUORITE_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength(6, 10).sounds(BlockSoundGroup.STONE));
    public static final Block FALSE_WATER = new Block(FabricBlockSettings.copyOf(Blocks.WATER));
    public static final Block FRONTIER_BLOCK = new FrontierBlock();
    public static final Block GUMMITE_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3, 10).sounds(BlockSoundGroup.STONE));
    public static final Block HOLOPROJECTOR = new HologramProjectorBlock();

    public static final Block LYOKO_CORE = new LyokoCore(FabricBlockSettings.copyOf(Blocks.DRAGON_EGG).noCollision().strength(-1,-1));


    public static final Block MARABUNTA = new Marabunta();
    /*public static final RegistryObject<Block> METATYUYAMUNITE_ORE = BLOCKS.register("metatyuyamunite_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3, 10).sound(SoundType.STONE)));
    public static final RegistryObject<Block> METATORBERNITE_ORE = BLOCKS.register("metatorbernite_ore", () -> new OreBlock(Block.Properties.copyOf(METATYUYAMUNITE_ORE.get())));
    public static final RegistryObject<Block> METAAUTUNITE_ORE = BLOCKS.register("metaautunite_ore", () -> new OreBlock(Block.Properties.copyOf(AUTUNITE_ORE.get())));
    public static final RegistryObject<Block> PROJECTOR_FOCUS = BLOCKS.register("projector_focus", ProjectorFocusblock::new);
    public static final RegistryObject<Block> QUANTUM_BLOCK = BLOCKS.register("quantum_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(6, 20).sound(SoundType.METAL)));
    public static final RegistryObject<Block> QUANTUM_CORE = BLOCKS.register("quantum_core", () -> new QuantumCore(Block.Properties.of(Material.DECORATION).strength(1, 20).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> QUANTUM_STEEL_BLOCK = BLOCKS.register("quantum_steel", () -> new QuantumSteelBlock(Block.Properties.of(Material.HEAVY_METAL).strength(6, 20).sound(SoundType.METAL)));
    public static final RegistryObject<Block> SALEEITE_ORE = BLOCKS.register("saleeite_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(6, 10).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SCANNER_BASE = BLOCKS.register("scanner_base", Scanner::new);
    public static final RegistryObject<Block> SCANNER_FRAME = BLOCKS.register("scanner_frame", () -> new ScannerFrame(Block.Properties.copyOf(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> SCANNER_TOP = BLOCKS.register("scanner_top", () -> new ScannerTop(Block.Properties.copyOf(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STORAGE = BLOCKS.register("universal", UniversalEnergyBlock::new);
    public static final RegistryObject<Block> SKLODOWSKITE_ORE = BLOCKS.register("sklodowskite_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(4, 4).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SILICA_SAND = BLOCKS.register("silica_sand", () -> new SandBlock(0xFFFFFF, Block.Properties.copyOf(Blocks.SAND)));
    public static final RegistryObject<Block> SECTOR5_STEEL = BLOCKS.register("sector5_steel", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(-1, -1)));
    public static final RegistryObject<Block> ROUTER = BLOCKS.register("router", () -> new Router(Block.Properties.copyOf(Blocks.DRAGON_EGG)));
    public static final RegistryObject<Block> TOWER_WHITE = BLOCKS.register("tower_white", TowerGeneric::new);
    */
    public static final Block TOWER_INTERFACE = new TowerInterface();
    /*public static final RegistryObject<Block> TOWER_BASE = BLOCKS.register("tower_base", TowerBase::new);
    public static final RegistryObject<Block> TOWER_WALL = BLOCKS.register("tower_wall", TowerWall::new);
    public static final RegistryObject<Block> TOWER_BLUE = BLOCKS.register("tower_blue", TowerGeneric::new);
    public static final RegistryObject<Block> TOWER_TOP = BLOCKS.register("tower_top", () -> new Block(Block.Properties.copyOf(Blocks.IRON_BLOCK).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> TOWER_WALL_CORNER = BLOCKS.register("tower_wall_corner", TowerWallCorner::new);
    public static final RegistryObject<Block> TOWER_BASE_CORNER = BLOCKS.register("tower_base_corner", TowerBaseCorner::new);
    public static final RegistryObject<TowerBottomBlock> TOWER_BOTTOM = BLOCKS.register("tower_bottom", () -> new TowerBottomBlock(Block.Properties.copyOf(Blocks.IRON_BLOCK).sound(SoundType.GLASS)));
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
    public static final RegistryObject<Block> UV_MACHINE = BLOCKS.register("uv_machine", () -> new Block(Block.Properties.copyOf(Blocks.ANVIL)));
    public static final RegistryObject<Block> UV_FOCUS = BLOCKS.register("uv_focus", () -> new UVFocusBlock(Block.Properties.copyOf(Blocks.GLASS)));
    public static final RegistryObject<Block> UV_LIGHT = BLOCKS.register("uv_light", () -> new Block(Block.Properties.copyOf(Blocks.GLOWSTONE)));
    public static final RegistryObject<Block> VOLCANO_GROUND = BLOCKS.register("volcano_ground", () -> new Block(Block.Properties.copyOf(Blocks.STONE)));

   */
    public static final Block DIGITAL_OCEAN_BLOCK = new DigitalSeaBlock();
    public static final Block DIGITAL_LAVA_BLOCK = new DigitalLavaBlock();
    public static final ImmutableMap<String,Block> BLOCK_MAP = ImmutableMap.<String,Block>builder()
            .put("architecture_work_station",ARCHITECTURE_WORK_STATION)
            .put("anti_marabunta",ANTI_MARABUNTA)
            .put("autunite_ore",AUTUNITE_ORE)
            .put("black_void",BLACK_VOID)
            .put("bornite_ore",BORNITE_ORE)
            .put("cable_block",CABLE_BLOCK)
            .put("computer_screen_connector",COMPUTER_SCREEN_CONNECTOR)
            .put("chalcopyrite_ore",CHALCOPYRITE_ORE)
            .put("covellite_ore",COVELLITE_ORE)
            .put("chalcocite_ore",CHALCOCITE_ORE)
            .put("computer_frame",COMPUTER_FRAME)
            .put("central_control_unit",CENTRAL_CONTROL_UNIT)
            .put("computer_screen",COMPUTER_SCREEN)
            .put("computer_screen_frame",COMPUTER_SCREEN_FRAME)
            .put("computer_keyboard",COMPUTER_KEYBOARD)
            .put("chiplet_basic_block",CHIPLET_BASIC_BLOCK)
            .put("chiplet_advanced_block",CHIPLET_ADVANCED_BLOCK)
            .put("chiplet_franz_block",CHIPLET_FRANZ_BLOCK)
            .put("computer_cooling_block",COMPUTER_COOLING_BLOCK)
            .put("computer_liquid_circulator",COMPUTER_LIQUID_CIRCULATOR)
            .put("computer_tower_control_panel",COMPUTER_TOWER_CONTROL_PANEL)
            .put("coffinite_ore",COFFINITE_ORE)
            .put("carnotite_ore",CARNOTITE_ORE)
            .put("data_transfer_interface",DATA_TRANSFER_INTERFACE)
            .put("digital_sea_pylon",DIGITAL_SEA_PYLON)
            .put("digital_grass",DIGITAL_GRASS)
            .put("digital_dirt",DIGITAL_DIRT)
            .put("digital_rock",DIGITAL_ROCK)
            .put("digital_wood_forest",DIGITAL_WOOD_FOREST)
            .put("digital_wood_mountain",DIGITAL_WOOD_MOUNTAIN)
            .put("digital_leaf_mountain",DIGITAL_LEAF_MOUNTAIN)
            .put("digital_ice",DIGITAL_ICE)
            .put("digital_sand",DIGITAL_SAND)
            .put("digital_darkness",DIGITAL_DARKNESS)
            .put("electric_fluoride_infuser",ELECTRIC_FLUORIDE_INFUSER)
            .put("external_energy_acceptor",EXTERNAL_ENERGY_ACCEPTOR)
            .put("electroplating_machine",ELECTROPLATING_MACHINE)
            .put("electroplating_machine_frame",ELECTROPLATING_MACHINE_FRAME)
            .put("electroplating_anode",ELECTROPLATING_ANODE)
            .put("electroplating_cathode",ELECTROPLATING_CATHODE)
            .put("anodepart",ANODE_PART)
            .put("cathodepart",CATHODE_PART)
            .put("fluoride_infuser",FLUORIDE_INFUSER)
            .put("fluorite_block",FLUORITE_BLOCK)
            .put("fluorite_ore",FLUORITE_ORE)
            .put("false_water",FALSE_WATER)
            .put("frontier_block",FRONTIER_BLOCK)
            .put("gummite_ore",GUMMITE_ORE)
            .put("holoprojector",HOLOPROJECTOR)
            .put("tower_interface",TOWER_INTERFACE)
            .put("lyoko_core",LYOKO_CORE)
            .put("marabunta",MARABUNTA)
            //fluidblocks
            .put("digital_ocean",DIGITAL_OCEAN_BLOCK)
            .put("digital_lava",DIGITAL_LAVA_BLOCK)
            .build();

}