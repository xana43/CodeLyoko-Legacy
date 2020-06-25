package io.github.elsopeen.lyokomod.client;

import io.github.elsopeen.lyokomod.LyokoMod;
import io.github.elsopeen.lyokomod.client.gui.InterfaceScreen;
import io.github.elsopeen.lyokomod.init.ModContainerTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Subscribe to events from the MOD EventBus that should be handled on the PHYSICAL CLIENT side in this class
 *
 * @author Cadiboo
 */
@EventBusSubscriber(modid = LyokoMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEventSubscriber {

	private static final Logger LOGGER = LogManager.getLogger(LyokoMod.MOD_ID + " Client Mod Event Subscriber");

	/**
	 * We need to register our renderers on the client because rendering code does not exist on the server
	 * and trying to use it on a dedicated server will crash the game.
	 * <p>
	 * This method will be called by Forge when it is time for the mod to do its client-side setup
	 * This method will always be called after the Registry events.
	 * This means that all Blocks, Items, TileEntityTypes, etc. will all have been registered already
	 */
	@SubscribeEvent
	public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {

		// Register ContainerType Screens
		// ScreenManager.registerFactory is not safe to call during parallel mod loading so we queue it to run later
		DeferredWorkQueue.runLater(() -> {
			ScreenManager.registerFactory(ModContainerTypes.INTERFACE_CONTAINER.get(), InterfaceScreen::new);
			LOGGER.debug("Registered ContainerType Screens");
		});
	}

}
