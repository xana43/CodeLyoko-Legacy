package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModRecipes;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricCodecDataProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public final class CustomRecipeProvider extends FabricRecipeProvider {


    public CustomRecipeProvider(final FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(final Consumer<RecipeJsonProvider> exporter) {
        final ConditionJsonProvider NEVER_LOADED = DefaultResourceConditions.allModsLoaded(CodeLyokoMain.MOD_ID);
        final ConditionJsonProvider ALWAYS_LOADED = DefaultResourceConditions.not(NEVER_LOADED);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.TRUSTY_SCREWDRIVER).input('i', Items.IRON_INGOT)
                .input('h', Items.COBWEB)
                .criterion("knows_screwdriver", conditionsFromItem(ModItems.TRUSTY_SCREWDRIVER))
                .pattern(" i ")
                .pattern("hih")
                .pattern("hhh")
                .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("screwdriver"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.ANODE_PART).input('c',
                        Items.COPPER_INGOT)
                .criterion("knows_anode", conditionsFromItem(ModBlocks.ANODE_PART))
                .pattern("c c")
                .pattern("c c")
                .pattern("c c")
                .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("anode"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.INTEGRATED_HEAT_SPREADER, 20).input('i',
                        Items.IRON_INGOT)
                .input('p', Items.HEAVY_WEIGHTED_PRESSURE_PLATE)
                .criterion("knows_ihs", conditionsFromItem(ModItems.INTEGRATED_HEAT_SPREADER))
                .pattern("iii")
                .pattern("iii")
                .pattern("p p")
                .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("ihs"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.KEY_CAP).input('b', ModItems.COLD_POLYCARBONATE_CONCENTRATE)
                .input('s', ModItems.KEY_SPRING).criterion("knows_key", conditionsFromItem(ModItems.KEY_CAP))
                .pattern("bbb")
                .pattern("bsb")
                .pattern("sss")
                .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("keycap"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.CATHODE_PART).input('c', Items.COPPER_INGOT)
                .input('i', Items.IRON_INGOT).criterion("knows_cathode", conditionsFromItem(ModBlocks.CATHODE_PART))
                .pattern("cic")
                .pattern("cic")
                .pattern("cic")
                .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("cathode"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.RAW_POLYCARBONATE).input(Items.CLAY_BALL).input(Items.BLACKSTONE)
                .input(Items.AMETHYST_BLOCK).input(Items.GRANITE).input(Items.GRAVEL).input(Items.LAVA_BUCKET)
                .input(Items.HONEY_BLOCK).criterion("knows_polycarbonate", conditionsFromItem(ModItems.SILICON_WAFER))
                .offerTo(exporter, CodeLyokoMain.codeLyokoPrefix("polycarbonate"));
        offerBlasting(exporter, List.of(ModItems.RAW_SILICADUST),RecipeCategory.MISC, ModItems.SILICON_WAFER, 38, 50,
                CodeLyokoMain.codeLyokoPrefix("refinement").toString());
        offerBlasting(exporter, List.of(ModItems.RAW_POLYCARBONATE),RecipeCategory.MISC, ModItems.MOLTEN_POLYCARBONATE_CONCENTRATE, 78, 88,
                CodeLyokoMain.codeLyokoPrefix("refinement").toString());
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.KEY_SPRING).input('i', Items.IRON_INGOT)
                .criterion("knows_key_spring", conditionsFromItem(ModItems.KEY_SPRING))
                .pattern("iii")
                .pattern(" i ")
                .pattern("i i")
                .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("key_spring"));
        offerReversibleCompactingRecipes(exporter,RecipeCategory.MISC,ModItems.URANIUM_ISOTOPE235,RecipeCategory.MISC
                ,ModBlocks.URANIUM_BLOCK_235);
        offerReversibleCompactingRecipes(exporter,RecipeCategory.MISC,ModItems.URANIUM_ISOTOPE238,RecipeCategory.MISC
                ,ModBlocks.URANIUM_BLOCK_238);
        offerReversibleCompactingRecipes(exporter,RecipeCategory.MISC,ModItems.SOLID_QUANTUM,RecipeCategory.MISC,
                ModBlocks.QUANTUM_BLOCK);
    }

}
