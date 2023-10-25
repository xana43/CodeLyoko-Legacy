package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModRecipes;
import com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.CustomRecipeBuilderProviders.CustomCookingRecipeJsonBuilder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;

public final class CustomRecipeProvider extends FabricRecipeProvider {


    public CustomRecipeProvider(final FabricDataOutput output) {
        super(output);
    }



    @Override
    public void generate(final RecipeExporter exporter) {
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
        CustomRecipeUtil.offerReacting(exporter,List.of(ModItems.URANIUM_ISOTOPE235), ModItems.URANIUM_ISOTOPE238);
        CustomRecipeUtil.offerReacting(exporter,List.of(ModBlocks.URANIUM_BLOCK_235), ModBlocks.URANIUM_BLOCK_238);


    }

    private record CustomRecipeUtil()
    {

        private static final StringBuilder recipePathBuilder = new StringBuilder();
        private static void offerReacting(final RecipeExporter recipeJsonProviderConsumer, final List<ItemConvertible> inputs, final ItemConvertible output)
        {
            offerCustomCooking(recipeJsonProviderConsumer, ModRecipes.RecipeSerializers.REACTOR_RECIPE_SERIALIZER,inputs, output, 0, "reacting","_from_reacting");
        }

        private static void offerCustomCooking(final RecipeExporter exporter, final RecipeSerializer<? extends AbstractCookingRecipe> serializer, final List<ItemConvertible> inputs, final ItemConvertible output, final float experience, final String group, final String method)
        {
            final String declaredGroup = CodeLyokoMain.codeLyokoPrefix(group).toString();
            for (final ItemConvertible itemConvertible : inputs) {
                recipePathBuilder.setLength(0);
                recipePathBuilder.append(getItemPath(output)).append(method).append('_').append(getItemPath(itemConvertible));
                CustomCookingRecipeJsonBuilder.create(Ingredient.ofItems(itemConvertible), RecipeCategory.MISC,output,experience,serializer).group(declaredGroup).criterion(hasItem(itemConvertible),conditionsFromItem(itemConvertible)).offerTo(exporter,recipePathBuilder.toString());
            }
        }
    }
}
