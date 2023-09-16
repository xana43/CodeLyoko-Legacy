package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.AdvancementEntityPredicateSerializer;
import net.minecraft.predicate.entity.LootContextPredicate;
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
            final Advancement EnteredLyokoAdvancement = Advancement.Builder.create()
                    .display(
                            ModItems.BIT,
                            Text.translatable("entered.lyoko"),
                            Text.translatable("entered.lyoko.description"),
                            new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    ).criterion("entered_lyoko_advancement",
                            Criterions.EnteredLyoko.Condition.create(
                                    List.of(ModDimensions.volcanoWorld,
                                            ModDimensions.carthage,
                                            ModDimensions.desertSectorWorld,
                                            ModDimensions.digitalOceanWorld,
                                            ModDimensions.forestSectorWorld,
                                            ModDimensions.iceSectorWorld,
                                            ModDimensions.frontierWorld,
                                            ModDimensions.mountainSectorWorld)))
                    .build(advancementConsumer,CodeLyokoMain.MOD_ID + "/root");
        }
    }
    public record Criterions()
    {
        public static final class EnteredLyoko extends AbstractCriterion<EnteredLyoko.Condition>
        {
            public static final Identifier ID = CodeLyokoMain.codeLyokoPrefix("entered_lyoko_advancement");
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
