package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.DataProviders;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.tag.ItemTags;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public final class CustomRecipeProvider extends FabricRecipeProvider {

    public CustomRecipeProvider(final FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }
    @Override
    protected void generateRecipes(final Consumer<RecipeJsonProvider> exporter) {
        final ConditionJsonProvider NEVER_LOADED = DefaultResourceConditions.allModsLoaded("codelyoko");
        final ConditionJsonProvider ALWAYS_LOADED = DefaultResourceConditions.not(NEVER_LOADED);
        ShapedRecipeJsonBuilder.create(ModItems.TRUSTTY_SCREWDRIVER).input('i', Items.IRON_INGOT).input('h',Items.COBWEB).criterion("knows_screwdriver", conditionsFromItem(ModItems.TRUSTTY_SCREWDRIVER))
                .pattern(" i ")
                .pattern("hih")
                .pattern("hhh")
        .offerTo(withConditions(exporter, NEVER_LOADED),CodeLyokoMain.CodeLyokoPrefix("screwdriver"));
        ShapedRecipeJsonBuilder.create(ModBlocks.ANODE_PART).input('c',Items.COPPER_INGOT).criterion("knows_anode",conditionsFromItem(ModBlocks.ANODE_PART))
                .pattern("c c")
                .pattern("c c")
                .pattern("c c")
                .offerTo(withConditions(exporter,NEVER_LOADED),CodeLyokoMain.CodeLyokoPrefix("anode"));
        ShapedRecipeJsonBuilder.create(ModItems.INTEGRATED_HEAT_SPREADER,20).input('i',Items.IRON_INGOT).input('p',Items.HEAVY_WEIGHTED_PRESSURE_PLATE).criterion("knows_ihs",conditionsFromItem(ModItems.INTEGRATED_HEAT_SPREADER))
                .pattern("iii")
                .pattern("iii")
                .pattern("p p")
                .offerTo(withConditions(exporter,NEVER_LOADED),CodeLyokoMain.CodeLyokoPrefix("ihs"));
        ShapedRecipeJsonBuilder.create(ModItems.KEY_CAP).input('b',ModItems.COLD_POLYCARBONATE_CONCENTRATE).input('s',ModItems.KEY_SPRING).criterion("knows_key",conditionsFromItem(ModItems.KEY_CAP))
                .pattern("bbb")
                .pattern("bsb")
                .pattern("sss")
                .offerTo(withConditions(exporter,NEVER_LOADED),CodeLyokoMain.CodeLyokoPrefix("keycap"));
        ShapedRecipeJsonBuilder.create(ModBlocks.CATHODE_PART).input('c',Items.COPPER_INGOT).input('i',Items.IRON_INGOT).criterion("knows_cathode",conditionsFromItem(ModBlocks.CATHODE_PART))
                .pattern("cic")
                .pattern("cic")
                .pattern("cic")
                .offerTo(withConditions(exporter,NEVER_LOADED),CodeLyokoMain.CodeLyokoPrefix("cathode"));
        ShapelessRecipeJsonBuilder.create(ModItems.RAW_POLYCARBONATE).input(Items.CLAY_BALL).input(Items.BLACKSTONE).input(Items.AMETHYST_BLOCK).input(Items.GRANITE).input(Items.GRAVEL).input(Items.LAVA_BUCKET).input(Items.HONEY_BLOCK).criterion("knows_polycarbonate",conditionsFromItem(ModItems.SILICON_WAFER)).offerTo(exporter,CodeLyokoMain.CodeLyokoPrefix("polycarbonate"));
        offerBlasting(exporter, List.of(ModItems.RAW_SILICADUST),ModItems.SILICON_WAFER, 38,50,CodeLyokoMain.MOD_ID + "refinement");
        offerBlasting(exporter,List.of(ModItems.RAW_POLYCARBONATE),ModItems.MOLTEN_POLYCARBONATE_CONCENTRATE,78,88,CodeLyokoMain.MOD_ID +"refinement");
        ShapedRecipeJsonBuilder.create(ModItems.KEY_SPRING).input('i',Items.IRON_INGOT).criterion("knows_key_spring",conditionsFromItem(ModItems.KEY_SPRING))
                .pattern("iii")
                .pattern(" i ")
                .pattern("i i")
                .offerTo(withConditions(exporter,NEVER_LOADED),CodeLyokoMain.CodeLyokoPrefix("key_spring"));

    }

}
