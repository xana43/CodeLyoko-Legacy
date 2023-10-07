package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFuels;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModRecipes;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.CriterionMerger;
import net.minecraft.advancement.criterion.CriterionConditions;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

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
        offerReacting(exporter,List.of(ModItems.URANIUM_ISOTOPE235), ModItems.URANIUM_ISOTOPE238,0,CodeLyokoMain.codeLyokoPrefix("reacting").toString());

    }
    private static void offerReacting(final Consumer<RecipeJsonProvider> recipeJsonProviderConsumer, final List<ItemConvertible> inputs, final ItemConvertible output, float experience, final String group)
    {
        offerCustom(recipeJsonProviderConsumer, ModRecipes.RecipeSerializers.REACTOR_RECIPE_SERIALIZER,inputs, output,experience,group,"_from_reacting");
    }
    private static void offerCustom(final Consumer<RecipeJsonProvider> exporter, final RecipeSerializer<? extends AbstractCookingRecipe> serializer, final List<ItemConvertible> inputs, final ItemConvertible output, final float experience, final String group, final String method)
    {
        for (final ItemConvertible itemConvertible : inputs) {
            CustomCookingRecipeJsonBuilder.create(Ingredient.ofItems(itemConvertible), RecipeCategory.MISC,output,experience,serializer).group(group).criterion(hasItem(itemConvertible),conditionsFromItem(itemConvertible)).offerTo(exporter,getItemPath(output)+method+'_'+getItemPath(itemConvertible));
        }
    }
    private static final class CustomCookingRecipeJsonBuilder implements CraftingRecipeJsonBuilder
    {
        private static final RecipeSerializer<?>[] serializers = {ModRecipes.RecipeSerializers.REACTOR_RECIPE_SERIALIZER};
        private final RecipeCategory category;
        private final CookingRecipeCategory cookingRecipeCategory;
        private final Ingredient input;
        private final Item output;
        private final float experience;
        private final int cookingTime;
        private final Advancement.Builder advancementBuilder = Advancement.Builder.createUntelemetered();
        private String group;
        private final RecipeSerializer<? extends AbstractCookingRecipe> serializer;

        private CustomCookingRecipeJsonBuilder(final RecipeCategory category, final CookingRecipeCategory cookingRecipeCategory, final ItemConvertible output, final Ingredient input,final float experience,final int cookingTime, final RecipeSerializer<? extends AbstractCookingRecipe> serializer)
        {
            this.category = category;
            this.cookingRecipeCategory = cookingRecipeCategory;
            this.output = output.asItem();
            this.input = input;
            this.experience = experience;
            this.cookingTime = cookingTime;
            this.serializer = serializer;
        }
        @Override
        public CraftingRecipeJsonBuilder criterion(final String name, final CriterionConditions conditions) {
            this.advancementBuilder.criterion(name,conditions);
            return this;
        }

        @Override
        public CraftingRecipeJsonBuilder group(@Nullable final String group) {
            this.group = group;
            return this;
        }
        private static int getModFuelTime(final Ingredient ingredient)
        {
            for(final ItemStack stack : ingredient.getMatchingStacks())
            {
                if(ModFuels.FUEL_MAP.containsKey(stack.getItem()))
                {
                    return ModFuels.FUEL_MAP.get(stack.getItem());
                }
            }
            CodeLyokoMain.LOG.warn("no fuel time found falling back");
            return 200;
        }
        public static CustomCookingRecipeJsonBuilder create(final Ingredient input,final RecipeCategory category,final ItemConvertible output,final float experience,final RecipeSerializer<?extends AbstractCookingRecipe> serializer)
        {
            return new CustomCookingRecipeJsonBuilder(category,CookingRecipeCategory.MISC,output,input,experience,getModFuelTime(input), serializer);
        }
        @Override
        public Item getOutputItem() {
            return this.output;
        }
        private void validate(final Identifier recipeId)
        {
            if(this.advancementBuilder.getCriteria().isEmpty())
            {
                throw new IllegalArgumentException("No way of obtaining recipe " + recipeId);
            }
        }
        @Override
        public void offerTo(final Consumer<RecipeJsonProvider> exporter, final Identifier recipeId) {
            this.validate(recipeId);
            this.advancementBuilder.parent(ROOT).criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).criteriaMerger(CriterionMerger.OR);
            exporter.accept(new CustomCookingRecipeJsonProvider(recipeId,this.group == null ? "" : this.group,this.cookingRecipeCategory,input,output,experience,cookingTime,advancementBuilder
            ,recipeId.withPrefixedPath("recipes/"+category.getName()+"/"),serializer));
        }
        private record CustomCookingRecipeJsonProvider(Identifier recipeId,String group
        ,CookingRecipeCategory cookingRecipeCategory,Ingredient input,Item result,
                                                       float experience,int cookingTime,Advancement.Builder advancementBuilder
        ,Identifier advancementId,RecipeSerializer<? extends AbstractCookingRecipe> serializer) implements RecipeJsonProvider
        {

            @Override
            public void serialize(final JsonObject json) {
                if (!this.group.isEmpty()) {
                    json.addProperty("group", this.group);
                }

                json.addProperty("category", this.cookingRecipeCategory.asString());
                json.add("ingredient", this.input.toJson());
                json.addProperty("result", Registries.ITEM.getId(this.result).toString());
                json.addProperty("experience", this.experience);
                json.addProperty("cookingtime", this.cookingTime);
            }

            @Override
            public Identifier getRecipeId() {
                return recipeId;
            }

            @Override
            public RecipeSerializer<?> getSerializer() {
                return serializer;
            }

            @Nullable
            @Override
            public JsonObject toAdvancementJson() {
                return advancementBuilder.toJson();
            }

            @Nullable
            @Override
            public Identifier getAdvancementId() {
                return advancementId;
            }
        }
    }

}
