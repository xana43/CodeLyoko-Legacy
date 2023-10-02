package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.nio.file.Path;

public record LanguageGenerators() {

    public static final class EnglishProvider extends FabricLanguageProvider
    {

        public EnglishProvider(final FabricDataOutput dataOutput) {
            super(dataOutput);
        }

        @Override
        public void generateTranslations(final TranslationBuilder translationBuilder) {
            translationBuilder.add(ModBlocks.COMPUTER_LIQUID_INTAKE_PUMP,"Fluid Intake Pump");
            translationBuilder.add(ModBlocks.COMPUTER_LIQUID_PIPE,"Basic Fluid Pipe");
            //custom translation keys
            translationBuilder.add("discovered.super_calculator","And so it begins");
            translationBuilder.add("discovered.super_calculator.description","you'd found the schematics for an " +
                    "unknown device, what does it do?");
            translationBuilder.add("tooltip.energy.mindhelm","Stored Energy:%d");
            //translationBuilder.add(ModItems.LYOKO_THEME,"A world without Danger - CodeLyoko Theme");
            try{
                final Path  existing = dataOutput.getModContainer().findPath(
                        "assets/codelyoko/lang/en_us.existing.json").get();
                translationBuilder.add(existing);
            } catch (final Exception e)
            {
                throw new RuntimeException("failed to add existing language file", e);
            }
        }
    }
    public static final class FrenchProvider extends FabricLanguageProvider
    {

        public FrenchProvider(final FabricDataOutput dataOutput) {
            super(dataOutput, "fr_fr");
        }

        @Override
        public void generateTranslations(final TranslationBuilder translationBuilder) {
            //translationBuilder.add(ModItems.LYOKO_THEME,"Un Monde Sans Danger - Thème du Codelyoko");
            try{
                final Path  existing = dataOutput.getModContainer().findPath(
                        "assets/codelyoko/lang/fr_fr.existing.json").get();
                translationBuilder.add(existing);
            } catch (final Exception e)
            {
                throw new RuntimeException("failed to add existing language file", e);
            }
        }
    }
}
