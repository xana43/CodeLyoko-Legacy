package elsopeen.lyokomod.init;

import elsopeen.lyokomod.LyokoMod;
import elsopeen.lyokomod.structures.Tower;
import elsopeen.lyokomod.structures.pieces.TowerPiece;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD, modid = LyokoMod.MOD_ID)
public class ModBusEvents {

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> args) {
        ModStructurePieceTypes.TOWER_PIECE = Registry.register(Registry.STRUCTURE_PIECE,
                ModStructurePieceTypes.TOWER_LOC,
                TowerPiece.Piece::new);
                //args.getRegistry().register(new Tower(NoFeatureConfig::deserialize)
                //        .setRegistryName(ModStructurePieceTypes.TOWER_LOC));
    }

}
