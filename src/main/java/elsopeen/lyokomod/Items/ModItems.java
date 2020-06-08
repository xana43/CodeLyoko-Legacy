package elsopeen.lyokomod.Items;

import elsopeen.lyokomod.Blocks.ModBlocks;
import elsopeen.lyokomod.LyokoMod;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    //The ITEMS deferred register in which you can register items.
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, LyokoMod.MOD_ID);

    //Register the tutorial dust with "tutorial_dust" as registry name and default properties
    public static final RegistryObject<Item> MOUNTAIN_ROCK = ITEMS.register("mountain_rock", () -> new BlockItem(ModBlocks.MOUNTAIN_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> FOREST_GRASS = ITEMS.register("forest_grass", () -> new BlockItem(ModBlocks.FOREST_GRASS.get(), new Item.Properties()));
    public static final RegistryObject<Item> FOREST_LOG = ITEMS.register("forest_log", () -> new BlockItem(ModBlocks.FOREST_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> DESERT_SAND = ITEMS.register("desert_sand", () -> new BlockItem(ModBlocks.DESERT_SAND.get(), new Item.Properties()));
    public static final RegistryObject<Item> BANQUISE_ICE = ITEMS.register("banquise_ice", () -> new BlockItem(ModBlocks.BANQUISE_ICE.get(), new Item.Properties()));

}
