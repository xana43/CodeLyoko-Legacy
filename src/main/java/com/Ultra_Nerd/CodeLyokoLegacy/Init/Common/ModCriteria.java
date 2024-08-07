package com.Ultra_Nerd.CodeLyokoLegacy.Init.Common;

public record ModCriteria() {
  /*  public static final class InvokeClassChange extends AbstractCriterion<InvokeClassChange.Condition>
    {
        private static final Identifier ID = CodeLyokoMain.codeLyokoPrefix("class_change");
        @Override
        protected Condition conditionsFromJson(JsonObject obj, Optional<LootContextPredicate> playerPredicate, AdvancementEntityPredicateDeserializer predicateDeserializer) {
            CriterionConditions
            return new Condition(playerPredicate,obj.get("previous_class_id").getAsInt());
        }
        public void trigger(final ServerPlayerEntity player)
        {
            this.trigger(player,condition -> condition.classChanged(player));
        }

        public static Identifier getId() {
            return ID;
        }


        public static final class ClassCondition implements Conditions{

            public static final Codec<ClassCondition> CODEC = RecordCodecBuilder.create(classConditionInstance -> classConditionInstance.group(EntityPredicate.LOOT_CONTEXT_PREDICATE_CODEC.optionalFieldOf("player").forGetter(classCondition -> classCondition.player)).apply(classConditionInstance, ClassCondition::new));
            private Optional<LootContextPredicate> player;
            private int previousClassId;
            public ClassCondition(Optional<LootContextPredicate> player) {
                this.player = player;
            }
            public boolean test(ServerPlayerEntity player) {
               return CardinalData.LyokoClass.getLyokoClass(player) != previousClassId;
            }
            @Override
            public Optional<LootContextPredicate> player() {
                return Optional.empty();
            }
        }
        public static final class Condition extends Abs
        {
            private final int previousClassId;
            public Condition(final Optional<LootContextPredicate> entity,final int previousClassId) {
                super(entity);
                this.previousClassId = previousClassId;

            }
            public boolean classChanged(final ServerPlayerEntity player)
            {
                return CardinalData.LyokoClass.getLyokoClass(player) != previousClassId;
            }
            @Override
            public JsonObject toJson() {
                final JsonObject obj = super.toJson();
                obj.addProperty("previous_class_id", previousClassId);
                return obj;
            }
        }
    }
    public static final class UseItem extends AbstractCriterion<UseItem.Condition>
    {
        private static final Identifier ID = CodeLyokoMain.codeLyokoPrefix("use_item");
        @Override
        protected Condition conditionsFromJson(final JsonObject obj, final Optional<LootContextPredicate> playerPredicate, final AdvancementEntityPredicateDeserializer predicateDeserializer) {
            return new Condition(playerPredicate, ItemPredicate.fromJson(obj.get("item")));
        }

        public void trigger(final ServerPlayerEntity player,final ItemStack stack)
        {
            this.trigger(player,condition -> condition.test(stack));
        }


        public static Identifier getId() {
            return ID;
        }

        public static final class Condition extends AbstractCriterionConditions
        {
            private final Optional<ItemPredicate> itemPredicate;
            public Condition(final Optional<LootContextPredicate> entity,final Optional<ItemPredicate> itemPredicate) {
                super(entity);
                this.itemPredicate = itemPredicate;
            }
            public boolean test(final ItemStack stack)
            {
                return itemPredicate.map(predicate -> predicate.test(stack)).orElse(false);
            }
            public static Condition create(final EntityPredicate.Builder player , final ItemPredicate.Builder item)
            {
                return new Condition(Optional.of(EntityPredicate.asLootContextPredicate(player.build())), Optional.ofNullable(item.build()));
            }
            public static Condition create(final ItemConvertible... itemConvertibles)
            {
                return new Condition(Optional.of(EntityPredicate.asLootContextPredicate(EntityPredicate.Builder.create().build()))
                        , Optional.ofNullable(ItemPredicate.Builder.create().items(itemConvertibles).build()));
            }
            @Override
            public JsonObject toJson() {
                final JsonObject jsonObject = super.toJson();
                itemPredicate.ifPresent(predicate -> jsonObject.add("item", predicate.toJson()));
                return jsonObject;
            }
        }
    }

    public static final class EnteredLyoko extends AbstractCriterion<EnteredLyoko.Condition>
    {
        private static final Identifier ID = CodeLyokoMain.codeLyokoPrefix("entered_lyoko_advancement");
        @Override
        protected Condition conditionsFromJson(final JsonObject obj, final Optional<LootContextPredicate> playerPredicate, final AdvancementEntityPredicateDeserializer predicateDeserializer) {
            final List<RegistryKey<World>> registryKeys = new ObjectArrayList<>();
            for(final String entry: obj.keySet())
            {
                registryKeys.add(RegistryKey.of(RegistryKeys.WORLD,new Identifier(JsonHelper.getString(obj,entry))));
            }
            return new Condition(playerPredicate,registryKeys);
        }

        public void trigger(final ServerPlayerEntity player,final ServerWorld world)
        {

            this.trigger(player,(condition) -> condition.worldTest(world.getRegistryKey()));
        }

        public static Identifier getId() {
            return ID;
        }
        public static final class Condition extends AbstractCriterionConditions
        {
            private final List<RegistryKey<World>> nextWorld;

            private Condition(final Optional<LootContextPredicate> player,final List<RegistryKey<World>> nextWorld) {
                super(player);
                this.nextWorld = nextWorld;

            }



            public static Condition create(final List<RegistryKey<World>> nextWorld)
            {
                final Condition Condition;

                AdvancementCriterion<?> test = new EnteredLyoko().create(new Condition(Optional.empty(),nextWorld));
                return new Condition(Optional.empty(),nextWorld);
            }

            @SafeVarargs
            public static Condition create(final RegistryKey<World>... nextWorlds)
            {
                return new Condition(Optional.empty(), List.of(nextWorlds));
            }

            public boolean worldTest(final RegistryKey<World> nextWorld)
            {
                return this.nextWorld.contains(nextWorld);
            }

            @Override
            public JsonObject toJson() {
                final JsonObject jsonObject = super.toJson();
                if(nextWorld != null)
                {
                    final StringBuilder builder = new StringBuilder("next0");
                    int i = 0;
                    for (final RegistryKey<World> registryKey : nextWorld)
                    {
                        builder.setCharAt(4, Character.forDigit(i,10));
                        jsonObject.addProperty(builder.toString(),registryKey.getValue().toString());
                        i++;
                    }

                }
                return jsonObject;
            }
        }
    }*/
}
