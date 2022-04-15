package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = CodeLyokoMain.MOD_ID)
public final class ModWorldFeatures {

   public static final DeferredRegister<StructureFeature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, CodeLyokoMain.MOD_ID);
   public static final ResourceLocation RL_LYOKO_STRUCTURE_SET = CodeLyokoMain.CodeLyokoPrefix("tower");
   public static final TagKey<StructureSet> LYOKO_STRUCTURE_SET = TagKey.create(Registry.STRUCTURE_SET_REGISTRY,RL_LYOKO_STRUCTURE_SET);
  /*
    //Feature parts
   public static StructurePieceType TOWER_PART = TowerParts.Part::new;
    //Main Features
    public static final RegistryObject<TowerStructure> TOWER = FEATURES.register("tower", () -> new TowerStructure(
            NoFeatureConfig::deserialize));

    @SubscribeEvent
    public static void RegisterBits(RegistryEvent.Register<Feature<?>> event) {
        Registry.register(Registry.STRUCTURE_PIECE, "TOWER".toLowerCase(Locale.ROOT), TOWER_PART);
    }

   */


}
