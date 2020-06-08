package elsopeen.lyokomod.Blocks;

import elsopeen.lyokomod.LyokoMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    //The BLOCKS deferred register in which you can register blocks.
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, LyokoMod.MOD_ID);

    //Register the tutorial block with "tutorial_block" as registry name and default ROCK properties
    public static final RegistryObject<Block> MOUNTAIN_BLOCK = BLOCKS.register("mountain_rock", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> FOREST_GRASS = BLOCKS.register("forest_grass", () -> new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> FOREST_LOG = BLOCKS.register("forest_log", () -> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> DESERT_SAND = BLOCKS.register("desert_sand", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)));
    public static final RegistryObject<Block> BANQUISE_ICE = BLOCKS.register("banquise_ice", () -> new Block(Block.Properties.create(Material.ICE).hardnessAndResistance(-1.f).slipperiness(0.99f)));
}
