package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.nio.file.Path;

public record LanguageGenerators() {

    public static class EnglishProvider extends FabricLanguageProvider
    {

        public EnglishProvider(final FabricDataOutput dataOutput) {
            super(dataOutput, "en_us");
        }

        @Override
        public void generateTranslations(final TranslationBuilder translationBuilder) {
            translationBuilder.add(ModBlocks.COMPUTER_LIQUID_INTAKE_PUMP,"Fluid Intake Pump");
            translationBuilder.add(ModBlocks.COMPUTER_LIQUID_PIPE,"Basic Fluid Pipe");

        }
    }
    public static class FrenchProvider extends FabricLanguageProvider
    {

        public FrenchProvider(final FabricDataOutput dataOutput) {
            super(dataOutput, "fr_fr");
        }

        @Override
        public void generateTranslations(final TranslationBuilder translationBuilder) {
            try{
                final Path  existing = dataOutput.getModContainer().findPath("assets/codelyoko/lang/fr_fr.json").get();
                translationBuilder.add(existing);
            } catch (final Exception e)
            {
                throw new RuntimeException("failed to add existing language file", e);
            }
        }
    }
}
