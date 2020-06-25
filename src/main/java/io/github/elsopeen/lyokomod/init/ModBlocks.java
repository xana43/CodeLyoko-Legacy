package io.github.elsopeen.lyokomod.init;

import io.github.elsopeen.lyokomod.LyokoMod;
import io.github.elsopeen.lyokomod.blocks.InterfaceBlock;
import io.github.elsopeen.lyokomod.blocks.NumericSeaFluidBlock;
import io.github.elsopeen.lyokomod.blocks.TowerBaseBlock;
import io.github.elsopeen.lyokomod.blocks.TowerBodyBlock;
import io.github.elsopeen.lyokomod.blocks.TowerBottomResetBlock;
import io.github.elsopeen.lyokomod.blocks.TowerPlatformAccessBlock;
import io.github.elsopeen.lyokomod.blocks.TowerPlatformCenterBlock;
import io.github.elsopeen.lyokomod.blocks.TowerPlatformCornerBlock;
import io.github.elsopeen.lyokomod.blocks.TowerPlatformStraightBlock;
import io.github.elsopeen.lyokomod.blocks.TowerPlatformTShapeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Registering class for blocks
 * as explained in Forge Doc 1.15.2
 */
public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, LyokoMod.MOD_ID);

    // Territory blocks
    public static final RegistryObject<Block> MOUNTAIN_ROCK = BLOCKS.register("mountain_rock", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> FOREST_GRASS = BLOCKS.register("forest_grass", () -> new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> FOREST_LOG = BLOCKS.register("forest_log", () -> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> DESERT_SAND = BLOCKS.register("desert_sand", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> BANQUISE_ICE = BLOCKS.register("banquise_ice", () -> new Block(Block.Properties.create(Material.ICE).hardnessAndResistance(-1.f).slipperiness(0.99f)));
    public static final RegistryObject<Block> SECTOR_5 = BLOCKS.register("sector5ground",() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1, -1).sound(SoundType.GLASS).lightValue(4)));
    // Tower blocks
    public static final RegistryObject<Block> INTERFACE = BLOCKS.register("interface", () -> new InterfaceBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> TOWER_BASE = BLOCKS.register("tower_base", () -> new TowerBaseBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> TOWER_BODY = BLOCKS.register("tower_body", () -> new TowerBodyBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> TOWER_PLATFORM_ACCESS = BLOCKS.register("tower_platform_access", () -> new TowerPlatformAccessBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> TOWER_PLATFORM_CORNER = BLOCKS.register("tower_platform_corner", () -> new TowerPlatformCornerBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> TOWER_PLATFORM_STRAIGHT = BLOCKS.register("tower_platform_straight", () -> new TowerPlatformStraightBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> TOWER_PLATFORM_TSHAPE = BLOCKS.register("tower_platform_tshape", () -> new TowerPlatformTShapeBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> TOWER_PLATFORM_CENTER = BLOCKS.register("tower_platform_center", () -> new TowerPlatformCenterBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> TOWER_BOTTOM_RESET = BLOCKS.register("tower_bottom_reset", ()->new TowerBottomResetBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> TOWER_TOP = BLOCKS.register("tower_top", ()->new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f).lightValue(15)));
    public static final RegistryObject<Block> TOWER_MUSH = BLOCKS.register("tower_mush", ()->new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f).lightValue(15)));

    // Numeric Sea
    public static final RegistryObject<Block> NUMERIC_SEA_FLUID_BLOCK = BLOCKS.register("numeric_sea_block", ()->new NumericSeaFluidBlock(ModFluids.NUMERIC_SEA, Block.Properties.create(Material.WATER).hardnessAndResistance(-1.f).doesNotBlockMovement().noDrops()));

    // Ores
    public static final RegistryObject<Block> SALEEITE_ORE = BLOCKS.register("saleeite_ore", ()->new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6.f, 10).harvestLevel(2).harvestTool(ToolType.PICKAXE).lightValue(2)));
    public static final RegistryObject<Block> AUTUNITE_ORE = BLOCKS.register("autunite_ore", ()->new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.f,2.f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> COFFINITE_ORE = BLOCKS.register("coffinite_ore", ()->new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(6.f,10.f).harvestTool(ToolType.PICKAXE).harvestLevel(2).lightValue(1)));
	public static final RegistryObject<Block> TYUYAMUNITE_ORE = BLOCKS.register("tyuyamunite_ore",() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6, 10).sound(SoundType.STONE).lightValue(0).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> TORBERNITE_ORE = BLOCKS.register("torbernite_ore",() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6, 10).sound(SoundType.STONE).lightValue(1).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
}

