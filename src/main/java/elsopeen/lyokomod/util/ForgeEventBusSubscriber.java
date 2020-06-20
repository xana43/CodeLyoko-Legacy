package elsopeen.lyokomod.util;

import elsopeen.lyokomod.LyokoMod;
import elsopeen.lyokomod.init.ModDimensions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = LyokoMod.MOD_ID)
public class ForgeEventBusSubscriber {

    @SubscribeEvent
    public static void onDimensionRegister(final RegisterDimensionsEvent event){
        LyokoMod.getLOGGER().info("Starting Dimension registering");
        if(DimensionType.byName(ModDimensions.LYOKO_FOREST.getId())==null) {
            DimensionManager.registerDimension(ModDimensions.LYOKO_FOREST.getId(),
                    ModDimensions.LYOKO_FOREST.get(),
                    null, true);
        }
        LyokoMod.getLOGGER().info("Dimension Forest registered");
        if(DimensionType.byName(ModDimensions.LYOKO_MOUNTAIN.getId())==null) {
            DimensionManager.registerDimension(ModDimensions.LYOKO_MOUNTAIN.getId(),
                    ModDimensions.LYOKO_MOUNTAIN.get(),
                    null, true);
        }
        LyokoMod.getLOGGER().info("Dimension Mountain Registered");
        if(DimensionType.byName(ModDimensions.LYOKO_DESERT.getId())==null) {
            DimensionManager.registerDimension(ModDimensions.LYOKO_DESERT.getId(),
                    ModDimensions.LYOKO_DESERT.get(),
                    null, true);
        }
        LyokoMod.getLOGGER().info("Dimension Desert Registered");
        if(DimensionType.byName(ModDimensions.LYOKO_BANQUISE.getId())==null) {
            DimensionManager.registerDimension(ModDimensions.LYOKO_BANQUISE.getId(),
                    ModDimensions.LYOKO_BANQUISE.get(),
                    null, true);
        }
        LyokoMod.getLOGGER().info("Dimension Banquise Registered");

    }
}
