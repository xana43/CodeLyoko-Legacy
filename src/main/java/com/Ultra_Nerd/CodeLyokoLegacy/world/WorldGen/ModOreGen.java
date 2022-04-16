package com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

public final class ModOreGen {

    //public static final RuleTest ruletest = new TagMatchTest(Tags.Blocks.END_STONES);
    public static Holder<PlacedFeature> OVERWORLD;

    public static void registerea()
    {


        OVERWORLD = registerPlacedFeature("test",new ConfiguredFeature<>(Feature.ORE,makeConfig(ModBlocks.METATYUYAMUNITE_ORE.get(), 10)),
                CountPlacement.of(10),
                InSquarePlacement.spread(),
                new WorldFilter(levelResourceKey -> levelResourceKey.equals(Level.OVERWORLD)),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0),VerticalAnchor.absolute(90)));
    }
    private static <C extends FeatureConfiguration, F extends Feature<C>> Holder<PlacedFeature> registerPlacedFeature(String registryName, ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
        return PlacementUtils.register(registryName, Holder.direct(feature), placementModifiers);
    }

    private static OreConfiguration makeConfig(final Block state, final int Size)
    {
        return new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES,state.defaultBlockState(),Size);
    }
}
