package elsopeen.lyokomod;

import elsopeen.lyokomod.init.ModBlocks;
import elsopeen.lyokomod.init.ModItemGroups;
import elsopeen.lyokomod.tileentity.InterfaceTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = LyokoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {
    private static final Logger logger = LogManager.getLogger(LyokoMod.MOD_ID + "Mod Event Subscriber");

    /*@SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)),
                        "mountain_rock"),
                setup(new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(-1.f)),
                        "forest_grass"),
                setup(new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(-1.f)),
                        "forest_log"),
                setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.f)),
                        "desert_sand"),
                setup(new Block(Block.Properties.create(Material.ICE).hardnessAndResistance(-1.f).slipperiness(0.99f)),
                        "banquise_ice"),
                setup(new Block(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(-1.f)),
                        "interface")
        );
    }*/

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                setup(new BlockItem(ModBlocks.MOUNTAIN_ROCK.get(),
                        new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)),
                        "mountain_rock"),
                setup(new BlockItem(ModBlocks.FOREST_GRASS.get(),
                        new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)),
                        "forest_grass"),
                setup(new BlockItem(ModBlocks.FOREST_LOG.get(),
                        new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)),
                        "forest_log"),
                setup(new BlockItem(ModBlocks.DESERT_SAND.get(),
                        new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)),
                        "desert_sand"),
                setup(new BlockItem(ModBlocks.BANQUISE_ICE.get(),
                        new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)),
                        "banquise_ice"),
                setup(new BlockItem(ModBlocks.INTERFACE.get(),
                        new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)),
                        "interface"));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(LyokoMod.MOD_ID, name));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }

}
