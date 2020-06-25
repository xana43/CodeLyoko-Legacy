package io.github.elsopeen.lyokomod;

import io.github.elsopeen.lyokomod.init.*;
import io.github.elsopeen.lyokomod.world.WorldGen;
import io.github.elsopeen.lyokomod.world.template.LyokoPlacement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

/**
 * Main mod class
 */
@Mod(LyokoMod.MOD_ID)
public class LyokoMod {
    public static final String MOD_ID = "lyokomod";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static Logger getLOGGER() {
        return LOGGER;
    }

    /**
     * Constructor
     * With blocks and tileEntities registering
     */
    public LyokoMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register items
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register Blocks
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register TileEntity
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register Containers
        ModContainerTypes.CONTAINER_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register Structures
        ModStructures.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register Biomes
        ModBiomes.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register Dimensions
        ModDimensions.DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register Fluids
        ModFluids.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());

        LyokoPlacement.TOWER_MIN22.getRegistryName();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("INTERFACE >> {}", ModBlocks.INTERFACE.get().getRegistryName());
        LOGGER.info("tour >> {}", ModStructures.TOWER.get().getRegistryName());
        DeferredWorkQueue.runLater(() -> {

            ModStructurePieceTypes.registerPieces();
            WorldGen.setupWorldGen();
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("LyokoMod-1.15", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("LyokoMod says XANA WILL DESTROY YOU");
    }

}
