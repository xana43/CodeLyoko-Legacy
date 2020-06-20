package elsopeen.lyokomod.util;

import elsopeen.lyokomod.LyokoMod;
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

/**
 * Registering nothing yet
 */
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

    /**
     * Registering items
     * @param event
     *
    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {

                setup(new BlockItem(ModBlocks.TOWER_BASE.get(),
                        new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)),
                        "tower_base"),
                setup(new BlockItem(ModBlocks.TOWER_BODY.get(),
                        new Item.Properties().group(ModItemGroups.CODE_LYOKO_BLOCKS)),
                        "tower_body"));
    }*/

    /**
     * Function to register the passed parameters
     * @param entry
     * @param name
     * @param <T>
     * @return
     */
    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(LyokoMod.MOD_ID, name));
    }

    /**
     * Function to register the passed parameters
     * @param entry
     * @param registryName
     * @param <T>
     * @return
     */
    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }

}
