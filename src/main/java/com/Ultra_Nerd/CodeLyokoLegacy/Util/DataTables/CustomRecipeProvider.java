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
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.recipe.RecipeGenerator.*;

public final class CustomRecipeProvider extends FabricRecipeProvider {


    public CustomRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter exporter) {

        return new RecipeGenerator(wrapperLookup,exporter) {
            @Override
            public void generate() {
                final ResourceCondition NEVER_LOADED = ResourceConditions.allModsLoaded(CodeLyokoMain.MOD_ID);
                final ResourceCondition ALWAYS_LOADED = ResourceConditions.not(NEVER_LOADED);
                final RegistryWrapper.Impl<Item> registryLookup = registries.getOrThrow(RegistryKeys.ITEM);
                createShaped(RecipeCategory.TOOLS,ModItems.TRUSTY_SCREWDRIVER).input('i', Items.IRON_INGOT)
                        .input('h', Items.COBWEB)
                        .criterion("knows_screwdriver", conditionsFromItem(ModItems.TRUSTY_SCREWDRIVER))
                        .pattern(" i ")
                        .pattern("hih")
                        .pattern("hhh")
                        .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("screwdriver").toString());
                createShaped(RecipeCategory.BUILDING_BLOCKS,ModBlocks.ANODE_PART).input('c',
                                ModTags.ItemTags.COMMON_COPPER_INGOTS)
                        .criterion("knows_anode", conditionsFromItem(ModBlocks.ANODE_PART))
                        .pattern("c c")
                        .pattern("c c")
                        .pattern("c c")
                        .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("anode").toString());
                createShaped(RecipeCategory.MISC,ModItems.INTEGRATED_HEAT_SPREADER, 20).input('i',
                                ModTags.ItemTags.COMMON_IRON_INGOTS)
                        .input('p', Items.HEAVY_WEIGHTED_PRESSURE_PLATE)
                        .criterion("knows_ihs", conditionsFromItem(ModItems.INTEGRATED_HEAT_SPREADER))
                        .pattern("iii")
                        .pattern("iii")
                        .pattern("p p")
                        .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("ihs").toString());
                createShaped(RecipeCategory.MISC,ModItems.KEY_CAP).input('b', ModItems.COLD_POLYCARBONATE_CONCENTRATE)
                        .input('s', ModItems.KEY_SPRING).criterion("knows_key", conditionsFromItem(ModItems.KEY_CAP))
                        .pattern("bbb")
                        .pattern("bsb")
                        .pattern("sss")
                        .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("keycap").toString());
                createShaped(RecipeCategory.BUILDING_BLOCKS,ModBlocks.CATHODE_PART).input('c', ModTags.ItemTags.COMMON_COPPER_INGOTS)
                        .input('i', ModTags.ItemTags.COMMON_IRON_INGOTS).criterion("knows_cathode", conditionsFromItem(ModBlocks.CATHODE_PART))
                        .pattern("cic")
                        .pattern("cic")
                        .pattern("cic")
                        .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("cathode").toString());
                createShapeless(RecipeCategory.MISC,ModItems.RAW_POLYCARBONATE).input(Items.CLAY_BALL).input(Items.BLACKSTONE)
                        .input(Items.AMETHYST_BLOCK).input(Items.GRANITE).input(ModTags.ItemTags.COMMON_GRAVEL).input(Items.LAVA_BUCKET)
                        .input(Items.HONEY_BLOCK).criterion("knows_polycarbonate", conditionsFromItem(ModItems.SILICON_WAFER))
                        .offerTo(exporter, CodeLyokoMain.codeLyokoPrefix("polycarbonate").toString());
                offerBlasting(List.of(ModItems.RAW_SILICADUST),RecipeCategory.MISC, ModItems.SILICON_WAFER, 38, 50,
                        CodeLyokoMain.codeLyokoPrefix("refinement").toString());
                offerBlasting(List.of(ModItems.RAW_POLYCARBONATE),RecipeCategory.MISC, ModItems.MOLTEN_POLYCARBONATE_CONCENTRATE, 78, 88,
                        CodeLyokoMain.codeLyokoPrefix("refinement").toString());
                createShaped(RecipeCategory.MISC,ModItems.KEY_SPRING).input('i', ModTags.ItemTags.COMMON_IRON_INGOTS)
                        .criterion("knows_key_spring", conditionsFromItem(ModItems.KEY_SPRING))
                        .pattern("iii")
                        .pattern(" i ")
                        .pattern("i i")
                        .offerTo(withConditions(exporter, NEVER_LOADED), CodeLyokoMain.codeLyokoPrefix("key_spring_recipe").toString());
                offerReversibleCompactingRecipes(RecipeCategory.MISC,ModItems.URANIUM_ISOTOPE235,RecipeCategory.MISC
                        ,ModBlocks.URANIUM_BLOCK_235);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,ModItems.URANIUM_ISOTOPE238,RecipeCategory.MISC
                        ,ModBlocks.URANIUM_BLOCK_238);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,ModItems.SOLID_QUANTUM,RecipeCategory.MISC,
                        ModBlocks.QUANTUM_BLOCK);
                createShaped(RecipeCategory.MISC,ModItems.URANIUM_BATTERY_STARTER,1).input('c',ModTags.ItemTags.URANIUM_235_INGOTS).input('t',ModTags.ItemTags.LEAD_INGOTS)
                        .pattern("ttt")
                        .pattern("tct")
                        .pattern("ttt").criterion("has_uranium",conditionsFromItem(ModBlocks.URANINITE_ORE));
                createShaped(RecipeCategory.MISC,ModItems.SILICON_WAFER).input('a',ModTags.ItemTags.COMMON_SILICON)
                        .pattern("aaa")
                        .pattern("aaa")
                        .pattern("aaa");
                createShaped(RecipeCategory.MISC,ModBlocks.LITHOGRAPHY_MACHINE.asItem()).input('s',Items.IRON_BLOCK)
                        .input('p',Items.GLASS).input('c',Items.REDSTONE_LAMP)
                        .pattern("sps")
                        .pattern("scs")
                        .pattern("sss");
                createShaped(RecipeCategory.MISC,ModBlocks.LITHOGRAPHY_MACHINE.asItem()).input('s',Items.COPPER_BLOCK)
                        .input('p',Items.LIGHT_BLUE_STAINED_GLASS).input('c',ModBlocks.LITHOGRAPHY_MACHINE.asItem())
                        .pattern("sps")
                        .pattern("scs")
                        .pattern("sss");
                CustomRecipeUtil.offerReacting(registryLookup,exporter,ObjectList.of(ModItems.URANIUM_ISOTOPE235), ModItems.URANIUM_ISOTOPE238);
                CustomRecipeUtil.offerReacting(registryLookup,exporter,ObjectList.of(ModBlocks.URANIUM_BLOCK_235), ModBlocks.URANIUM_BLOCK_238);
                CustomRecipeUtil.offerLithographyArray(registryLookup,exporter,ObjectList.of(ModItems.SILICON_WAFER,Items.COPPER_INGOT,Items.GOLD_NUGGET),ModItems.CPU_DIE_ARM);
                CustomRecipeUtil.offerLithographyArray(registryLookup,exporter,ObjectList.of(ModItems.SILICON_WAFER,Items.GOLD_INGOT,ModItems.CPU_DIE_ARM),ModItems.CPU_DIE_RISC);
                CustomRecipeUtil.offerLithographyArray(registryLookup,exporter,ObjectList.of(ModItems.SILICON_WAFER,Items.GOLD_INGOT,ModItems.CPU_DIE_RISC,Items.IRON_NUGGET),ModItems.CPU_DIE_x86);
                CustomRecipeUtil.offerLithographyArray(registryLookup,exporter,ObjectList.of(ModItems.SILICON_WAFER,Items.GOLD_INGOT,ModItems.CPU_DIE_x86,Items.IRON_INGOT), ModItems.CPU_DIE_ASIC);
                CustomRecipeUtil.offerLithographyArray(registryLookup,exporter,ObjectList.of(ModItems.URANIUM_SILICON_PLATE,Items.GOLD_BLOCK,ModItems.CPU_DIE_ASIC,ModItems.SILICON_WAFER,Items.DIAMOND),ModItems.CPU_DIE_QUANTUM);
                offerSmelting(ObjectList.of(ModItems.RAW_SILICADUST),RecipeCategory.MISC,ModItems.SILICON_PLATE,4,4,CodeLyokoMain.codeLyokoPrefix("basic_refinement").toString());
            }
        };
    }

    @Override
    public String getName() {
        return "CodelyokoRecipeProvider";
    }

    private record CustomRecipeUtil()
    {

        private static final StringBuilder recipePathBuilder = new StringBuilder();
        private static void offerLithographyArray(final RegistryWrapper.Impl<Item> wrapperLookup,final RecipeExporter recipeExporter,final List<ItemConvertible> inputs,final ItemConvertible output)
        {
            offerCustomCookingArray(wrapperLookup,recipeExporter,ModItems.SILICON_WAFER,LithographyRecipe::new,inputs,output,0,"lithography","_from_lithography");
        }
        private static void offerLithography(final RegistryWrapper.Impl<Item> wrapperLookup,final RecipeExporter recipeExporter,final List<ItemConvertible> inputs,final ItemConvertible output)
        {
            offerCustomCooking(wrapperLookup,recipeExporter, LithographyRecipe::new,inputs,output,0,"lithography","_from_lithography");
        }
        private static void offerReacting(final RegistryWrapper.Impl<Item> wrapperLookup,final RecipeExporter recipeJsonProviderConsumer, final List<ItemConvertible> inputs, final ItemConvertible output)
        {
            offerCustomCooking(wrapperLookup,recipeJsonProviderConsumer, ReactorRecipe::new,inputs, output, 0, "reacting","_from_reacting");
        }
        private static void offerCustomCookingArray(final RegistryWrapper.Impl<Item> wrapperLookup,final RecipeExporter exporter,final ItemConvertible hasItem, final AbstractCookingRecipe.RecipeFactory<?> factory, final List<ItemConvertible> inputs, final ItemConvertible output, final float experience, final String group, final String method)
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
            CustomCookingRecipeJsonBuilder.create(Ingredient.ofItems(convertibles), RecipeCategory.MISC,output,experience,null,factory).group(declaredGroup).criterion(hasItem(hasItem),conditionsFromPredicates(ItemPredicate.Builder.create().items(wrapperLookup,convertibles))).offerTo(exporter,recipePathBuilder.toString());

        }
        private static void offerCustomCooking(final RegistryWrapper.Impl<Item> wrapperLookup, final RecipeExporter exporter, final AbstractCookingRecipe.RecipeFactory<?> factory, final List<ItemConvertible> inputs, final ItemConvertible output, final float experience, final String group, final String method)
        {
            final String declaredGroup = CodeLyokoMain.codeLyokoPrefix(group).toString();
            for (final ItemConvertible itemConvertible : inputs) {
                recipePathBuilder.setLength(0);
                recipePathBuilder.append(getItemPath(output)).append(method).append('_').append(getItemPath(itemConvertible));
                CustomCookingRecipeJsonBuilder.create(Ingredient.ofItems(itemConvertible), RecipeCategory.MISC,output,experience,null,factory).group(declaredGroup).criterion(hasItem(itemConvertible),conditionsFromItemPredicates(ItemPredicate.Builder.create().items(wrapperLookup,itemConvertible).build())/*.offerTo(exporter,recipePathBuilder.toString()*/);
            }
        }

    }
}
