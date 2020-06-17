package elsopeen.lyokomod.init;

import elsopeen.lyokomod.LyokoMod;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Registering class for items
 * as explained by Cadiboo's tutorial
 */
public class ModItems {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, LyokoMod.MOD_ID);

    //Register the tutorial dust with "tutorial_dust" as registry name and default properties
    public static final RegistryObject<Item> MOUNTAIN_ROCK = ITEMS.register("mountain_rock", () -> new BlockItem(ModBlocks.MOUNTAIN_ROCK.get(), new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)));
    public static final RegistryObject<Item> FOREST_GRASS = ITEMS.register("forest_grass", () -> new BlockItem(ModBlocks.FOREST_GRASS.get(), new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)));
    public static final RegistryObject<Item> FOREST_LOG = ITEMS.register("forest_log", () -> new BlockItem(ModBlocks.FOREST_LOG.get(), new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)));
    public static final RegistryObject<Item> DESERT_SAND = ITEMS.register("desert_sand", () -> new BlockItem(ModBlocks.DESERT_SAND.get(), new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)));
    public static final RegistryObject<Item> BANQUISE_ICE = ITEMS.register("banquise_ice", () -> new BlockItem(ModBlocks.BANQUISE_ICE.get(), new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)));
    public static final RegistryObject<Item> INTERFACE = ITEMS.register("interface", () -> new BlockItem(ModBlocks.INTERFACE.get(), new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)));
    public static final RegistryObject<Item> TOWER_BASE = ITEMS.register("tower_base", () -> new BlockItem(ModBlocks.TOWER_BASE.get(), new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)));
    public static final RegistryObject<Item> TOWER_BODY = ITEMS.register("tower_body", () -> new BlockItem(ModBlocks.TOWER_BODY.get(), new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)));
    public static final RegistryObject<Item> TOWER_PLATFORM_ACCESS = ITEMS.register("tower_platform_access", () -> new BlockItem(ModBlocks.TOWER_PLATFORM_ACCESS.get(), new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)));
    public static final RegistryObject<Item> TOWER_PLATFORM_CORNER = ITEMS.register("tower_platform_corner", () -> new BlockItem(ModBlocks.TOWER_PLATFORM_CORNER.get(), new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)));
    public static final RegistryObject<Item> TOWER_PLATFORM_STRAIGHT = ITEMS.register("tower_platform_straight", () -> new BlockItem(ModBlocks.TOWER_PLATFORM_STRAIGHT.get(), new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)));
    public static final RegistryObject<Item> TOWER_PLATFORM_TSHAPE = ITEMS.register("tower_platform_tshape", ()-> new BlockItem(ModBlocks.TOWER_PLATFORM_TSHAPE.get(), new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)));
    public static final RegistryObject<Item> TOWER_PLATFORM_CENTER = ITEMS.register("tower_platform_center", ()->new BlockItem(ModBlocks.TOWER_PLATFORM_CENTER.get(), new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)));
    public static final RegistryObject<Item> TOWER_BOTTOM_RESET = ITEMS.register("tower_bottom_reset", ()->new BlockItem(ModBlocks.TOWER_BOTTOM_RESET.get(), new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)));

}
