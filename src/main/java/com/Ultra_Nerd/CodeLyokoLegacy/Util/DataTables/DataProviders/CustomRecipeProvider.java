package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables.DataProviders;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public final class CustomRecipeProvider extends FabricRecipeProvider {
    private static final ConditionJsonProvider NEVER_LOADED = DefaultResourceConditions.allModsLoaded("cm");
    private static final ConditionJsonProvider ALWAYS_LOADED = DefaultResourceConditions.not(NEVER_LOADED);
    public CustomRecipeProvider(final FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }
    @Override
    protected void generateRecipes(final Consumer<RecipeJsonProvider> exporter) {

        ShapedRecipeJsonBuilder.create(ModItems.TRUSTTY_SCREWDRIVER).input('i', Items.IRON_INGOT).input('h',Items.COBWEB).input('a', Items.AIR).criterion("knows_screwdriver", conditionsFromItem(ModItems.TRUSTTY_SCREWDRIVER))
                .pattern("aia")
                .pattern("hih")
                .pattern("hhh")
        .offerTo(withConditions(exporter, NEVER_LOADED));
        ShapedRecipeJsonBuilder.create(ModBlocks.ANODE_PART).input('c',Items.COPPER_INGOT).input('a',Items.AIR).criterion("knows_anode",conditionsFromItem(ModBlocks.ANODE_PART))
                .pattern("cac")
                .pattern("cac")
                .pattern("cac")
                .offerTo(withConditions(exporter,NEVER_LOADED));
    }
}
