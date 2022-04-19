package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.*;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.*;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.electroplate.ElectroplatingMachine;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.flouride.ElectricFluorideInfuser;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.flouride.FluorideInfuser;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.saplings.DigitalMountainSapling;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.saplings.DigitalSapling;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests.DataTransferInterface;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests.TestBlockPortal;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower.*;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public final class ModBlocks {


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CodeLyokoMain.MOD_ID);

    //for blocks
    public static final RegistryObject<Block> ARCHITECTURE_WORK_STATION = BLOCKS.register("architecture_work_station", () -> new ArchitectureWorkstation(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ANTI_MARABUNTA = BLOCKS.register("anti_marabunta", AntiMarabunta::new);
    public static final RegistryObject<Block> AUTUNITE_ORE = BLOCKS.register("autunite_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(6, 10).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLACK_VOID = BLOCKS.register("black_void", BlackVoid::new);
    public static final RegistryObject<Block> BORNITE_ORE = BLOCKS.register("bornite_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CABLE_BLOCK = BLOCKS.register("cable_block", () -> new CableBlock(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> COMPUTER_SCREEN_CONNECTOR = BLOCKS.register("computer_screen_connector", () -> new SuperComputerSideScreenConnector(BlockBehaviour.Properties.copy(Blocks.IRON_BARS)));
    public static final RegistryObject<Block> CHALCOPYRITE_ORE = BLOCKS.register("chalcopyrite_ore", () -> new Block(Block.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> COVELLITE_ORE = BLOCKS.register("covellite_ore", () -> new Block(Block.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> CHALCOCITE_ORE = BLOCKS.register("chalcocite_ore", () -> new Block(Block.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> COMPUTER_FRAME = BLOCKS.register("computer_frame", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> CENTRAL_CONTROL_UNIT = BLOCKS.register("central_control_unit", () -> new ComputerCentralControlUnit(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> COMPUTER_SCREEN = BLOCKS.register("computer_screen", () -> new Block(Block.Properties.of(Material.GLASS).strength(1, 20).sound(SoundType.GLASS).explosionResistance(Blocks.GLASS.getExplosionResistance())));
    public static final RegistryObject<Block> COMPUTER_SCREEN_FRAME = BLOCKS.register("computer_screen_frame", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> COMPUTER_KEYBOARD = BLOCKS.register("computer_keyboard", ComputerKeyboard::new);
    public static final RegistryObject<Block> CHIPLET_BASIC_BLOCK = BLOCKS.register("chiplet_basic_block", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> CHIPLET_ADVANCED_BLOCK = BLOCKS.register("chiplet_advanced_block", () -> new ChipletAdvancedBlock(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> CHIPLET_FRANZ_BLOCK = BLOCKS.register("chiplet_franz_block", FranzChiplet::new);
    public static final RegistryObject<Block> COMPUTER_COOLING_BLOCK = BLOCKS.register("computer_cooling_block", () -> new CoolingBlock(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> COMPUTER_LIQUID_CIRCULATOR = BLOCKS.register("computer_liquid_circulator", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> COMPUTER_TOWER_CONTROL_PANEL = BLOCKS.register("computer_tower_control_panel", ControlPanel::new);
    public static final RegistryObject<Block> COFFINITE_ORE = BLOCKS.register("coffinite_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(6,10).sound(SoundType.STONE).explosionResistance(Blocks.IRON_ORE.getExplosionResistance()).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CARNOTITE_ORE = BLOCKS.register("carnotite_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(6, 10).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DATA_TRANSFER_INTERFACE = BLOCKS.register("data_transfer_interface", DataTransferInterface::new);
    public static final RegistryObject<Block> DIGITAL_SEA_PYLON = BLOCKS.register("digital_sea_pylon", SeaPylon::new);
    public static final RegistryObject<Block> DIGITAL_GRASS = BLOCKS.register("digital_grass", () -> new Block(Block.Properties.copy(Blocks.GRASS_BLOCK).isValidSpawn((p_61031_, p_61032_, p_61033_, p_61034_) -> true).strength(-1).explosionResistance(-1)));
    public static final RegistryObject<Block> DIGITAL_DIRT = BLOCKS.register("digital_dirt", () -> new Block(Block.Properties.copy(Blocks.DIRT).strength(-1).explosionResistance(-1)));
    public static final RegistryObject<Block> DIGITAL_ROCK = BLOCKS.register("digital_rock", () -> new Block(Block.Properties.copy(Blocks.STONE).strength(-1)));
    public static final RegistryObject<Block> DIGITAL_WOOD_FOREST = BLOCKS.register("digital_wood_forest", () -> new Block(Block.Properties.copy(Blocks.OAK_WOOD).strength(-1).explosionResistance(-1)));
    public static final RegistryObject<Block> DIGITAL_WOOD_MOUNTAIN = BLOCKS.register("digital_wood_mountain", () -> new Block(Block.Properties.copy(Blocks.JUNGLE_WOOD)));
    public static final RegistryObject<Block> DIGITAL_LEAF_MOUNTAIN = BLOCKS.register("digital_leaf_mountain", () -> new LeavesBlock(Block.Properties.copy(Blocks.JUNGLE_LEAVES)));


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
    public static final RegistryObject<Block> LYOKO_CORE = BLOCKS.register("lyoko_core", () -> new LyokoCore(Block.Properties.copy(Blocks.DRAGON_EGG).noCollission().noOcclusion().strength(-1,-1)));
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
    public static final RegistryObject<Block> TOWER_INTERFACE = BLOCKS.register("tower_interface", TowerInterface::new);
    public static final RegistryObject<Block> TOWER_BASE = BLOCKS.register("tower_base", TowerBase::new);
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
}