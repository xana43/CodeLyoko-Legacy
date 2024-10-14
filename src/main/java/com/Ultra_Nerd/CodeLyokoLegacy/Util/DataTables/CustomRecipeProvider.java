package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModTags;
import com.Ultra_Nerd.CodeLyokoLegacy.Recipies.LithographyRecipe;
import com.Ultra_Nerd.CodeLyokoLegacy.Recipies.ReactorRecipe;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables.CustomRecipeBuilderProviders.CustomCookingRecipeJsonBuilder;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public final class CustomRecipeProvider extends FabricRecipeProvider {


    public CustomRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(final RecipeExporter exporter) {
        final ResourceCondition NEVER_LOADED = ResourceConditions.allModsLoaded(CodeLyokoMain.MOD_ID);
        final ResourceCondition ALWAYS_LOADED = ResourceConditions.not(NEVER_LOADED);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.TRUSTY_SCREWDRIVER).input('i', Items.IRON_INGOT)
                .input('h', Items.COBWEB)
                .criterion("knows_screwdriver", conditionsFromItem(ModItems.TRUSTY_SCREWDRIVER))
                .pattern(" i ")
                .pattern("hih")
                .pattern("hhh")
                .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("screwdriver"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.ANODE_PART).input('c',
                        ModTags.ItemTags.COMMON_COPPER_INGOTS)
                .criterion("knows_anode", conditionsFromItem(ModBlocks.ANODE_PART))
                .pattern("c c")
                .pattern("c c")
                .pattern("c c")
                .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("anode"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.INTEGRATED_HEAT_SPREADER, 20).input('i',
                        ModTags.ItemTags.COMMON_IRON_INGOTS)
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.CATHODE_PART).input('c', ModTags.ItemTags.COMMON_COPPER_INGOTS)
                .input('i', ModTags.ItemTags.COMMON_IRON_INGOTS).criterion("knows_cathode", conditionsFromItem(ModBlocks.CATHODE_PART))
                .pattern("cic")
                .pattern("cic")
                .pattern("cic")
                .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("cathode"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.RAW_POLYCARBONATE).input(Items.CLAY_BALL).input(Items.BLACKSTONE)
                .input(Items.AMETHYST_BLOCK).input(Items.GRANITE).input(ModTags.ItemTags.COMMON_GRAVEL).input(Items.LAVA_BUCKET)
                .input(Items.HONEY_BLOCK).criterion("knows_polycarbonate", conditionsFromItem(ModItems.SILICON_WAFER))
                .offerTo(exporter, CodeLyokoMain.codeLyokoPrefix("polycarbonate"));
        offerBlasting(exporter, List.of(ModItems.RAW_SILICADUST),RecipeCategory.MISC, ModItems.SILICON_WAFER, 38, 50,
                CodeLyokoMain.codeLyokoPrefix("refinement").toString());
        offerBlasting(exporter, List.of(ModItems.RAW_POLYCARBONATE),RecipeCategory.MISC, ModItems.MOLTEN_POLYCARBONATE_CONCENTRATE, 78, 88,
                CodeLyokoMain.codeLyokoPrefix("refinement").toString());
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.KEY_SPRING).input('i', ModTags.ItemTags.COMMON_IRON_INGOTS)
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.URANIUM_BATTERY_STARTER,1).input('c',ModTags.ItemTags.URANIUM_235_INGOTS).input('t',ModTags.ItemTags.LEAD_INGOTS)
                        .pattern("ttt")
                        .pattern("tct")
                        .pattern("ttt").criterion("has_uranium",conditionsFromItem(ModBlocks.URANINITE_ORE));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.SILICON_WAFER).input('a',ModTags.ItemTags.COMMON_SILICON)
                .pattern("aaa")
                .pattern("aaa")
                .pattern("aaa");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.LITHOGRAPHY_MACHINE.asItem()).input('s',Items.IRON_BLOCK)
                        .input('p',Items.GLASS).input('c',Items.REDSTONE_LAMP)
                        .pattern("sps")
                        .pattern("scs")
                                .pattern("sss");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.LITHOGRAPHY_MACHINE.asItem()).input('s',Items.COPPER_BLOCK)
                .input('p',Items.LIGHT_BLUE_STAINED_GLASS).input('c',ModBlocks.LITHOGRAPHY_MACHINE.asItem())
                .pattern("sps")
                .pattern("scs")
                .pattern("sss");
        CustomRecipeUtil.offerReacting(exporter, ObjectList.of(ModItems.URANIUM_ISOTOPE235), ModItems.URANIUM_ISOTOPE238);
        CustomRecipeUtil.offerReacting(exporter,ObjectList.of(ModBlocks.URANIUM_BLOCK_235), ModBlocks.URANIUM_BLOCK_238);
        CustomRecipeUtil.offerLithographyArray(exporter,ObjectList.of(ModItems.SILICON_WAFER,Items.COPPER_INGOT,Items.GOLD_NUGGET),ModItems.CPU_DIE_ARM);
        CustomRecipeUtil.offerLithographyArray(exporter,ObjectList.of(ModItems.SILICON_WAFER,Items.GOLD_INGOT,ModItems.CPU_DIE_ARM),ModItems.CPU_DIE_RISC);
        CustomRecipeUtil.offerLithographyArray(exporter,ObjectList.of(ModItems.SILICON_WAFER,Items.GOLD_INGOT,ModItems.CPU_DIE_RISC,Items.IRON_NUGGET),ModItems.CPU_DIE_x86);
        CustomRecipeUtil.offerLithographyArray(exporter,ObjectList.of(ModItems.SILICON_WAFER,Items.GOLD_INGOT,ModItems.CPU_DIE_x86,Items.IRON_INGOT), ModItems.CPU_DIE_ASIC);
        CustomRecipeUtil.offerLithographyArray(exporter,ObjectList.of(ModItems.URANIUM_SILICON_PLATE,Items.GOLD_BLOCK,ModItems.CPU_DIE_ASIC,ModItems.SILICON_WAFER,Items.DIAMOND),ModItems.CPU_DIE_QUANTUM);
        offerSmelting(exporter,ObjectList.of(ModItems.RAW_SILICADUST),RecipeCategory.MISC,ModItems.SILICON_PLATE,4,4,CodeLyokoMain.codeLyokoPrefix("basic_refinement").toString());
    }

    private record CustomRecipeUtil()
    {

        private static final StringBuilder recipePathBuilder = new StringBuilder();
        private static void offerLithographyArray(final RecipeExporter recipeExporter,final List<ItemConvertible> inputs,final ItemConvertible output)
        {
            offerCustomCookingArray(recipeExporter,ModItems.SILICON_WAFER,LithographyRecipe::new,inputs,output,0,"lithography","_from_lithography");
        }
        private static void offerLithography(final RecipeExporter recipeExporter,final List<ItemConvertible> inputs,final ItemConvertible output)
        {
            offerCustomCooking(recipeExporter, LithographyRecipe::new,inputs,output,0,"lithography","_from_lithography");
        }
        private static void offerReacting(final RecipeExporter recipeJsonProviderConsumer, final List<ItemConvertible> inputs, final ItemConvertible output)
        {
            offerCustomCooking(recipeJsonProviderConsumer, ReactorRecipe::new,inputs, output, 0, "reacting","_from_reacting");
        }
        private static void offerCustomCookingArray(final RecipeExporter exporter,final ItemConvertible hasItem, final AbstractCookingRecipe.RecipeFactory<?> factory, final List<ItemConvertible> inputs, final ItemConvertible output, final float experience, final String group, final String method)
        {
            final String declaredGroup = CodeLyokoMain.codeLyokoPrefix(group).toString();
            recipePathBuilder.setLength(0);
            recipePathBuilder.append(getItemPath(output))
                .append(method);

      for (final ItemConvertible itemConvertible : inputs) {

        recipePathBuilder
            .append('_')
            .append(getItemPath(itemConvertible));

      }
            final ItemConvertible[] convertibles = inputs.toArray(inputs.toArray(new ItemConvertible[0]));
            CustomCookingRecipeJsonBuilder.create(Ingredient.ofItems(convertibles), RecipeCategory.MISC,output,experience,null,factory).group(declaredGroup).criterion(hasItem(hasItem),conditionsFromPredicates(ItemPredicate.Builder.create().items(convertibles))).offerTo(exporter,recipePathBuilder.toString());

        }
        private static void offerCustomCooking(final RecipeExporter exporter, final AbstractCookingRecipe.RecipeFactory<?> factory, final List<ItemConvertible> inputs, final ItemConvertible output, final float experience, final String group, final String method)
        {
            final String declaredGroup = CodeLyokoMain.codeLyokoPrefix(group).toString();
            for (final ItemConvertible itemConvertible : inputs) {
                recipePathBuilder.setLength(0);
                recipePathBuilder.append(getItemPath(output)).append(method).append('_').append(getItemPath(itemConvertible));
                CustomCookingRecipeJsonBuilder.create(Ingredient.ofItems(itemConvertible), RecipeCategory.MISC,output,experience,null,factory).group(declaredGroup).criterion(hasItem(itemConvertible),conditionsFromItem(itemConvertible)).offerTo(exporter,recipePathBuilder.toString());
            }
        }
        
    }
}
