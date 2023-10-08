package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.UsingItemCriterion;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

import static com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil.AdvancementCreation.create;
public record ModAdvancements() {

    private record LyokoTierAdvancement()
    {
        private static Advancement DiscoveredSuperCalculator;
        private static Advancement EnteredLyokoAdvancement;
        private static Advancement selectedClass;
        public static void bootstrap(final Consumer<Advancement> advancementConsumer,
                @Nullable final Advancement rootAdvancement)
        {
            DiscoveredSuperCalculator = MethodUtil.AdvancementCreation.create(ModItems.CPU_PACKAGE_QUANTUM,
                    Text.translatable("discovered.super_calculator"),Text.translatable("discovered.super_calculator" +
                            ".description"),null,
                    AdvancementFrame.GOAL,true,true,false,"discovered_super_calculator_advancement",
                    ModCriteria.UseItem.Condition.create(ModItems.STORY_BOOK2),"super_computer",
                    advancementConsumer);
            EnteredLyokoAdvancement = MethodUtil.AdvancementCreation.create(DiscoveredSuperCalculator,ModItems.BIT,
                    Text.translatable("entered.lyoko"),Text.translatable("entered.lyoko.description"),
                    AdvancementFrame.GOAL,true,true,false,"entered_lyoko_advancement", ModCriteria.EnteredLyoko.Condition.create(
                            List.of(ModDimensions.volcanoWorld,
                                    ModDimensions.carthage,
                                    ModDimensions.desertSectorWorld,
                                    ModDimensions.digitalOceanWorld,
                                    ModDimensions.forestSectorWorld,
                                    ModDimensions.iceSectorWorld,
                                    ModDimensions.frontierWorld,
                                    ModDimensions.mountainSectorWorld)),"/entered_lyoko",advancementConsumer);
        }


    }
    public record RegisteredAdvancements()
    {
        public enum LyokoTierAdvancements
        {
            DISCOVERED_SUPER_COMPUTER(LyokoTierAdvancement.DiscoveredSuperCalculator),
            ENTERED_LYOKO(LyokoTierAdvancement.EnteredLyokoAdvancement);
            private final Advancement registeredAdvancement;
            LyokoTierAdvancements(final Advancement advancement)
            {
                this.registeredAdvancement = advancement;
            }
            public final Advancement getRegisteredAdvancement()
            {
                return registeredAdvancement;
            }
        }

        public enum Tier1Advancements
        {
            BUILD_LITHOGRAPHY_MACHINE(TierOneAdvancements.buildLithography);
            private final Advancement registeredAdvancement;
            Tier1Advancements(final Advancement advancement) {
                registeredAdvancement = advancement;
            }
            public final Advancement getRegisteredAdvancement()
            {
                return registeredAdvancement;
            }
        }
    }

    private record TierOneAdvancements()
    {
        private static Advancement buildLithography;


        public static void bootstrap(final Consumer<Advancement> advancementConsumer,
                @Nullable final Advancement rootAdvancement)
        {
        buildLithography = create(rootAdvancement,ModItems.INTEGRATED_HEAT_SPREADER,Text.translatable("build.litho"),
                Text.translatable("build.litho.desc"),AdvancementFrame.TASK,true,true,false,
                "build_lithography_machine",ModCriteria.UseItem.Condition.create(EntityPredicate.Builder.create(),
                        ItemPredicate.Builder.create().items(ModBlocks.UV_MACHINE)),"/lithography",advancementConsumer);

        }

    }

    private static Advancement foundBaseSchematics;
    public static void constructAdvancementTree(final Consumer<Advancement> advancementConsumer)
    {
        foundBaseSchematics = create(ModItems.CPU_DIE_ARM, Text.translatable("starter" +
                        ".schematic"),Text.translatable("starter.schematic.description"),null,
                AdvancementFrame.GOAL,true,true,false,"found_schematics",
                UsingItemCriterion.Conditions.create(EntityPredicate.Builder.create(),
                        ItemPredicate.Builder.create().items(ModItems.STORY_BOOK)),"/root",
                advancementConsumer);
        TierOneAdvancements.bootstrap(advancementConsumer, foundBaseSchematics);
        LyokoTierAdvancement.bootstrap(advancementConsumer,null);
    }
    public static Advancement getCurrentRootAdvancement()
    {
        return foundBaseSchematics;
    }
}
