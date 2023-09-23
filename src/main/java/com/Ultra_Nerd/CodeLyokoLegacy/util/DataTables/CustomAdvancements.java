package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.advancement.criterion.ItemCriterion;
import net.minecraft.advancement.criterion.UsingItemCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.AdvancementEntityPredicateSerializer;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class CustomAdvancements extends FabricAdvancementProvider {
    public CustomAdvancements(final FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(final Consumer<Advancement> consumer) {
        new Advancements().accept(consumer);
    }

    private record Advancements() implements Consumer<Consumer<Advancement>>
    {

        @Override
        public void accept(final Consumer<Advancement> advancementConsumer) {
            final Advancement DiscoveredSuperCalculator = Advancement.Builder.create().
                    display(ModItems.COMPUTER_ARM_CORE,
                            Text.translatable("discovered.super_calculator"),
                            Text.translatable("discovered.super_calculator.description"),
                            new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                            ).criterion("discovered_super_calculator_advancement",
                            Criteria.UseItem.Condition.create(EntityPredicate.Builder.create(),
                                            ItemPredicate.Builder.create().items(ModItems.STORY_BOOK2)))
                    .build(advancementConsumer,CodeLyokoMain.MOD_ID+"/root");
            final Advancement EnteredLyokoAdvancement = Advancement.Builder.create().parent(DiscoveredSuperCalculator)
                    .display(
                            ModItems.BIT,
                            Text.translatable("entered.lyoko"),
                            Text.translatable("entered.lyoko.description"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    ).criterion("entered_lyoko_advancement",
                            Criteria.EnteredLyoko.Condition.create(
                                    List.of(ModDimensions.volcanoWorld,
                                            ModDimensions.carthage,
                                            ModDimensions.desertSectorWorld,
                                            ModDimensions.digitalOceanWorld,
                                            ModDimensions.forestSectorWorld,
                                            ModDimensions.iceSectorWorld,
                                            ModDimensions.frontierWorld,
                                            ModDimensions.mountainSectorWorld)))
                    .build(advancementConsumer,CodeLyokoMain.MOD_ID + "/entered_lyoko");
        }
    }
    public record Criteria()
    {
        public static final class UseItem extends AbstractCriterion<UseItem.Condition>
        {
            private static final Identifier ID = CodeLyokoMain.codeLyokoPrefix("use_item");
            @Override
            protected Condition conditionsFromJson(final JsonObject obj, final LootContextPredicate playerPredicate, final AdvancementEntityPredicateDeserializer predicateDeserializer) {
                return new Condition(playerPredicate, ItemPredicate.fromJson(obj.get("item")));
            }

            public void trigger(final ServerPlayerEntity player,final ItemStack stack)
            {
                this.trigger(player,condition -> condition.test(stack));
            }

            @Override
            public Identifier getId() {
                return ID;
            }

            public static final class Condition extends AbstractCriterionConditions
            {
                private final ItemPredicate itemPredicate;
                public Condition(final LootContextPredicate entity,final ItemPredicate itemPredicate) {
                    super(ID, entity);
                    this.itemPredicate = itemPredicate;
                }
                public boolean test(final ItemStack stack)
                {
                    return itemPredicate.test(stack);
                }
                public static Condition create(final EntityPredicate.Builder player , final ItemPredicate.Builder item)
                {
                    return new Condition(EntityPredicate.asLootContextPredicate(player.build()),item.build());
                }
                @Override
                public JsonObject toJson(final AdvancementEntityPredicateSerializer predicateSerializer) {
                    final JsonObject jsonObject = super.toJson(predicateSerializer);
                    jsonObject.add("item",itemPredicate.toJson());
                    return jsonObject;
                }
            }
        }
        public static final class EnteredLyoko extends AbstractCriterion<EnteredLyoko.Condition>
        {
            private static final Identifier ID = CodeLyokoMain.codeLyokoPrefix("entered_lyoko_advancement");
            @Override
            protected Condition conditionsFromJson(final JsonObject obj, final LootContextPredicate playerPredicate, final AdvancementEntityPredicateDeserializer predicateDeserializer) {
                final List<RegistryKey<World>> registryKeys = new ArrayList<>();
                for (int i = 0; i < 8; i++)
                {
                    registryKeys.add(obj.has("next"+i) ? RegistryKey.of(RegistryKeys.WORLD,
                            new Identifier(JsonHelper.getString(obj,"next"+i))): null);
                }
                return new Condition(playerPredicate,registryKeys);
            }

            public void trigger(final ServerPlayerEntity player,final ServerWorld world)
            {

                this.trigger(player,(condition) -> condition.worldTest(world.getRegistryKey()));
            }

            @Override
            public Identifier getId() {
                return ID;
            }
            public static final class Condition extends AbstractCriterionConditions
            {
                private final List<RegistryKey<World>> nextWorld;

                private Condition(final LootContextPredicate player,final List<RegistryKey<World>> nextWorld) {
                    super(ID, player);
                    this.nextWorld = nextWorld;

                }



                public static Condition create(final List<RegistryKey<World>> nextWorld)
                {
                    return new Condition(LootContextPredicate.EMPTY,nextWorld);
                }

                public boolean worldTest(final RegistryKey<World> nextWorld)
                {
                    return this.nextWorld.contains(nextWorld);
                }

                @Override
                public JsonObject toJson(final AdvancementEntityPredicateSerializer predicateSerializer) {
                    final JsonObject jsonObject = super.toJson(predicateSerializer);
                    if(nextWorld != null)
                    {
                        int i = 0;
                        for (final RegistryKey<World> registryKey : nextWorld)
                        {
                            
                            jsonObject.addProperty("next"+i,registryKey.getValue().toString());
                            i++;
                        }

                    }
                    return jsonObject;
                }
            }
        }
    }
}
