package elsopeen.lyokomod.init;

import elsopeen.lyokomod.LyokoMod;
import elsopeen.lyokomod.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Registering class for blocks
 * as explained in Forge Doc 1.15.2
 */
public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, LyokoMod.MOD_ID);

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
    public static final RegistryObject<Block> TOWER_PLATFORM_CENTER = BLOCKS.register("tower_platform_center", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)));

}
