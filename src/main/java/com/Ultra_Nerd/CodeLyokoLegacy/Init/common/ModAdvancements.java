package com.Ultra_Nerd.CodeLyokoLegacy.Init.common;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.advancement.AdvancementEntry;
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
        private static AdvancementEntry DiscoveredSuperCalculator;
        private static AdvancementEntry EnteredLyokoAdvancement;
        private static AdvancementEntry selectedClass;
        public static void bootstrap(final Consumer<AdvancementEntry> advancementConsumer,
                @Nullable final AdvancementEntry rootAdvancement)
        {
            DiscoveredSuperCalculator = MethodUtil.AdvancementCreation.create(ModItems.CPU_PACKAGE_QUANTUM,
                    Text.translatable("discovered.super_calculator"),Text.translatable("discovered.super_calculator" +
                            ".description"),null,
                    AdvancementFrame.GOAL,true,true,false,"discovered_super_calculator_advancement",
                    ModCustomTrackedCriteria.USED_ITEM.create(ModCriteria.UseItem.Condition.create(ModItems.STORY_BOOK2)),"super_computer",
                    advancementConsumer);
            EnteredLyokoAdvancement = MethodUtil.AdvancementCreation.create(DiscoveredSuperCalculator,ModItems.BIT,
                    Text.translatable("entered.lyoko"),Text.translatable("entered.lyoko.description"),null,
                    AdvancementFrame.GOAL,true,true,false,"entered_lyoko_advancement", ModCustomTrackedCriteria.ENTERED_LYOKO.create(ModCriteria.EnteredLyoko.Condition.create(
                            List.of(ModDimensions.volcanoWorld,
                                    ModDimensions.carthage,
                                    ModDimensions.desertSectorWorld,
                                    ModDimensions.digitalOceanWorld,
                                    ModDimensions.forestSectorWorld,
                                    ModDimensions.iceSectorWorld,
                                    ModDimensions.frontierWorld,
                                    ModDimensions.mountainSectorWorld))),"/entered_lyoko",advancementConsumer);
        }


    }
    public record RegisteredAdvancements()
    {
        public enum LyokoTierAdvancements
        {
            DISCOVERED_SUPER_COMPUTER(LyokoTierAdvancement.DiscoveredSuperCalculator),
            ENTERED_LYOKO(LyokoTierAdvancement.EnteredLyokoAdvancement);
            private final AdvancementEntry registeredAdvancement;
            LyokoTierAdvancements(final AdvancementEntry advancement)
            {
                this.registeredAdvancement = advancement;
            }
            public final AdvancementEntry getRegisteredAdvancement()
            {
                return registeredAdvancement;
            }
        }

        public enum Tier1Advancements
        {
            BUILD_LITHOGRAPHY_MACHINE(TierOneAdvancements.buildLithography);
            private final AdvancementEntry registeredAdvancement;
            Tier1Advancements(final AdvancementEntry advancement) {
                registeredAdvancement = advancement;
            }
            public final AdvancementEntry getRegisteredAdvancement()
            {
                return registeredAdvancement;
            }
        }
    }

    private record TierOneAdvancements()
    {
        private static AdvancementEntry buildLithography;


        public static void bootstrap(final Consumer<AdvancementEntry> advancementConsumer,
                @Nullable final AdvancementEntry rootAdvancement)
        {
        buildLithography = create(rootAdvancement,ModItems.INTEGRATED_HEAT_SPREADER,Text.translatable("build.litho"),
                Text.translatable("build.litho.desc"),null,AdvancementFrame.TASK,true,true,false,
                "build_lithography_machine",ModCustomTrackedCriteria.USED_ITEM.create(ModCriteria.UseItem.Condition.create(EntityPredicate.Builder.create(),
                        ItemPredicate.Builder.create().items(ModBlocks.UV_MACHINE))),"/lithography",advancementConsumer);

        }

    }

    private static AdvancementEntry foundBaseSchematics;
    public static void constructAdvancementTree(final Consumer<AdvancementEntry> advancementConsumer)
    {
        foundBaseSchematics = create(ModItems.CPU_DIE_ARM, Text.translatable("starter" +
                        ".schematic"),Text.translatable("starter.schematic.description"), null,
                AdvancementFrame.GOAL,true,true,false,"found_schematics",
                UsingItemCriterion.Conditions.create(EntityPredicate.Builder.create(),
                        ItemPredicate.Builder.create().items(ModItems.STORY_BOOK)),"/root",
                advancementConsumer);
        TierOneAdvancements.bootstrap(advancementConsumer, foundBaseSchematics);
        LyokoTierAdvancement.bootstrap(advancementConsumer,null);
    }
    public static AdvancementEntry getCurrentRootAdvancement()
    {
        return foundBaseSchematics;
    }
}
