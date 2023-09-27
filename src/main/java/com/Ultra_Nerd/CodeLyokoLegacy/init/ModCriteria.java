package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.item.ItemConvertible;
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
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.world.World;

import java.util.*;

public record ModCriteria() {
    public static final class InvokeClassChange extends AbstractCriterion<InvokeClassChange.Condition>
    {
        private static final Identifier ID = CodeLyokoMain.codeLyokoPrefix("class_change");
        @Override
        protected Condition conditionsFromJson(JsonObject obj, LootContextPredicate playerPredicate, AdvancementEntityPredicateDeserializer predicateDeserializer) {
            return new Condition(ID,playerPredicate,obj.get("previous_class_id").getAsInt());
        }
        public void trigger(final ServerPlayerEntity player)
        {
            this.trigger(player,condition -> condition.classChanged(player));
        }
        @Override
        public Identifier getId() {
            return ID;
        }

        public static final class Condition extends AbstractCriterionConditions
        {
            private final int previousClassId;
            public Condition(final Identifier id,final LootContextPredicate entity,final int previousClassId) {
                super(id, entity);
                this.previousClassId = previousClassId;

            }
            public boolean classChanged(final ServerPlayerEntity player)
            {
                return CardinalData.LyokoClass.getLyokoClass(player) != previousClassId;
            }
            @Override
            public JsonObject toJson(AdvancementEntityPredicateSerializer predicateSerializer) {
                final JsonObject obj = super.toJson(predicateSerializer);
                obj.addProperty("previous_class_id",previousClassId);
                return obj;
            }
        }
    }
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
            public static Condition create(final ItemConvertible... itemConvertibles)
            {
                return new Condition(EntityPredicate.asLootContextPredicate(EntityPredicate.Builder.create().build())
                        ,ItemPredicate.Builder.create().items(itemConvertibles).build());
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
            for(final String entry: obj.keySet())
            {
                CodeLyokoMain.LOG.info("adding:"+entry+" to criteria");
                registryKeys.add(RegistryKey.of(RegistryKeys.WORLD,new Identifier(JsonHelper.getString(obj,entry))));
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

            @SafeVarargs
            public static Condition create(final RegistryKey<World>... nextWorlds)
            {
                return new Condition(LootContextPredicate.EMPTY, Arrays.asList(nextWorlds));
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
