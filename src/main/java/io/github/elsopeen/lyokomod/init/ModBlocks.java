package io.github.elsopeen.lyokomod.init;

import io.github.elsopeen.lyokomod.LyokoMod;
import io.github.elsopeen.lyokomod.blocks.*;
import net.minecraft.block.Block;
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

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LyokoMod.MOD_ID);

    //Register the tutorial block with "tutorial_block" as registry name and default ROCK properties
    public static final RegistryObject<Block> MOUNTAIN_ROCK = BLOCKS.register("mountain_rock", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> FOREST_GRASS = BLOCKS.register("forest_grass", () -> new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> FOREST_LOG = BLOCKS.register("forest_log", () -> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> DESERT_SAND = BLOCKS.register("desert_sand", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> BANQUISE_ICE = BLOCKS.register("banquise_ice", () -> new Block(Block.Properties.create(Material.ICE).hardnessAndResistance(-1.f).slipperiness(0.99f)));
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
    public static final RegistryObject<Block> NUMERIC_SEA_FLUID_BLOCK = BLOCKS.register("numeric_sea_block", ()->new NumericSeaFluidBlock(ModFluids.NUMERIC_SEA, Block.Properties.create(Material.WATER).hardnessAndResistance(-1.f).doesNotBlockMovement().noDrops()));
    public static final RegistryObject<Block> SALEEITE_ORE = BLOCKS.register("saleeite_ore", ()->new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6.f, 10).harvestLevel(2).harvestTool(ToolType.PICKAXE).lightValue(2)));
}
