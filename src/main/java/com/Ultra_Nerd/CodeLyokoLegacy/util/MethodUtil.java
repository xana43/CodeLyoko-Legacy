package com.Ultra_Nerd.CodeLyokoLegacy.util;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public record MethodUtil() {
    public record ArmorMethods()
    {
        public static boolean isArmorSlot(final int slot)
        {
            return slot == EquipmentSlot.CHEST.getEntitySlotId() || slot == EquipmentSlot.LEGS.getEntitySlotId()
                    || slot == EquipmentSlot.FEET.getEntitySlotId() || slot == EquipmentSlot.HEAD.getEntitySlotId();
        }
    }

    public record TickConversion() {
        public static int tickToSeconds(final int ticks) {
            return ticks / 20;
        }

        public static int secondsToTicks(final int seconds) {
            return seconds * 20;
        }
    }

    public record DimensionCheck() {

        public static boolean playerNotInVanillaWorld(@NotNull PlayerEntity player) {
            return player.getWorld().getRegistryKey() == ModDimensions.forestSectorWorld || player.getWorld().getRegistryKey() == ModDimensions.carthage || player.getWorld().getRegistryKey() == ModDimensions.desertSectorWorld || player.getWorld().getRegistryKey() == ModDimensions.iceSectorWorld

                    || player.getWorld().getRegistryKey() == ModDimensions.mountainSectorWorld || player.getWorld().getRegistryKey() == ModDimensions.volcanoWorld || player.getWorld().getRegistryKey() == ModDimensions.digitalOceanWorld || player.getWorld().getRegistryKey() == ModDimensions.frontierWorld;


        }

        public static boolean entityNotInVanillaWorld(@NotNull Entity entity) {

            return entity.getWorld().getRegistryKey() == ModDimensions.forestSectorWorld || entity.getWorld().getRegistryKey() == ModDimensions.carthage || entity.getWorld().getRegistryKey() == ModDimensions.desertSectorWorld || entity.getWorld().getRegistryKey() == ModDimensions.iceSectorWorld

                    || entity.getWorld().getRegistryKey() == ModDimensions.mountainSectorWorld || entity.getWorld().getRegistryKey() == ModDimensions.volcanoWorld || entity.getWorld().getRegistryKey() == ModDimensions.digitalOceanWorld || entity.getWorld().getRegistryKey() == ModDimensions.frontierWorld;


        }

        public static boolean worldIsNotVanilla(@NotNull World level) {
            return level.getRegistryKey() == ModDimensions.forestSectorWorld || level.getRegistryKey() == ModDimensions.carthage || level.getRegistryKey() == ModDimensions.desertSectorWorld || level.getRegistryKey() == ModDimensions.iceSectorWorld
                    || level.getRegistryKey() == ModDimensions.mountainSectorWorld || level.getRegistryKey() == ModDimensions.volcanoWorld || level.getRegistryKey() == ModDimensions.digitalOceanWorld || level.getRegistryKey() == ModDimensions.frontierWorld;


        }

        public static boolean playerInVanilla(PlayerEntity player) {
            return player.getWorld().getRegistryKey() == World.OVERWORLD || player.getWorld().getRegistryKey() == World.NETHER || player.getWorld().getRegistryKey() == World.END;
        }

        public static boolean worldIsVanilla(World level) {
            return level.getRegistryKey() == World.END || level.getRegistryKey() == World.OVERWORLD || level.getRegistryKey() == World.NETHER;
        }

        public static boolean worldIsVanilla(RegistryKey<World> level) {
            return level == World.END || level == World.OVERWORLD || level == World.NETHER;
        }


    }


    public record TextUtil() {

        private static final StringVisitable[] pages = new StringVisitable[100];

        public static StringVisitable[] textArray(@NotNull final String textToDenote) {
            final String[] denoted = textToDenote.split(">δ<");
            final int length = denoted.length;
            for (int i = 0; i < length; i++) {
                pages[i] = Text.translatable(denoted[i]);
            }
            return pages.clone();
        }

        public static int textArrayLengthToPage(final StringVisitable @NotNull [] formattedTexts) {
            int length = 0;

            for (final StringVisitable formattedText : formattedTexts) {
                if (formattedText != null) {
                    length++;
                }
            }
            return length;
        }


    }
}
