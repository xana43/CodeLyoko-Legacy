package io.github.elsopeen.lyokomod.util;

import io.github.elsopeen.lyokomod.LyokoMod;
import io.github.elsopeen.lyokomod.world.LyokoOreGen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Generate "ore"
 */
@Mod.EventBusSubscriber(modid = LyokoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {
    private static final Logger logger = LogManager.getLogger(LyokoMod.MOD_ID + "Mod Event Subscriber");

    @SubscribeEvent
    public static void onLoadCompleteEvent(FMLLoadCompleteEvent event) {
        LyokoOreGen.generateOre();
    }

    /**
     * Function to register the passed parameters
     * @param entry entry to register
     * @param name key for registering
     * @param <T> type of entry
     * @return the registry object
     */
    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(LyokoMod.MOD_ID, name));
    }

    /**
     * Function to register the passed parameters
     * @param entry entry to register
     * @param registryName resourceLocation of the entry
     * @param <T> type of the entry
     * @return registry object to register
     */
    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }

}
