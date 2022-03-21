package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures.structures.Tower.TowerParts;
import com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures.structures.Tower.TowerStructure;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Base.MOD_ID)
public class ModWorldFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Base.MOD_ID);
    //Feature parts
    public static StructurePieceType TOWER_PART = TowerParts.Part::new;
    //Main Features
    public static final RegistryObject<TowerStructure> TOWER = FEATURES.register("tower", () -> new TowerStructure(
            NoFeatureConfig::deserialize));

    @SubscribeEvent
    public static void RegisterBits(RegistryEvent.Register<Feature<?>> event) {
        Registry.register(Registry.STRUCTURE_PIECE, "TOWER".toLowerCase(Locale.ROOT), TOWER_PART);
    }
}
