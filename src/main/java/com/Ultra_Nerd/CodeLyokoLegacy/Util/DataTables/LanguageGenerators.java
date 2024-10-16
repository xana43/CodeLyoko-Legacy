package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public record LanguageGenerators() {
    private static String generateMidnightKey(final String variable)
    {
        return "codelyoko.midnightconfig."+variable;
    }

    public static final class EnglishProvider extends FabricLanguageProvider
    {


        public EnglishProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, registryLookup);
        }

        @Override
        public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup,final TranslationBuilder translationBuilder) {

            translationBuilder.add(ModBlocks.COMPUTER_LIQUID_INTAKE_PUMP,"Fluid Intake Pump");
            translationBuilder.add(ModBlocks.COMPUTER_LIQUID_PIPE,"Basic Fluid Pipe");
//            translationBuilder.add(ModItems.LYOKO_THEME_INSTRUMENTAL,"CodeLyoko Theme song (Instrumental Remix)");
  //          translationBuilder.add(ModItems.LYOKO_THEME_INSTRUMENTAL.getTranslationKey()+".desc","A World Without Danger (Instrumental Remix) - FractelLegend");
            //custom translation keys
            translationBuilder.add("discovered.super_calculator","And so it begins");
            translationBuilder.add("discovered.super_calculator.description","you'd found the schematics for an " +
                    "unknown device, what does it do?");
            translationBuilder.add("tooltip.energy.mindhelm","Stored Energy:%dJ");
            translationBuilder.add("reactor.energy.amount.gui","Stored Energy:%dJ");
            translationBuilder.add("reactor.waste.amount.gui","Stored Waste:%dL");
            translationBuilder.add("demarcation.name","Point:%s");
            translationBuilder.add("xana.attack.start","Xana has started an attack!");
            translationBuilder.add("splashscreen.entry1","X.A.N.A. Is watching");
            translationBuilder.add(generateMidnightKey("title"),"Codelyoko Evolution Configuration (WIP)");
            try{
                final Optional<Path> pathOptional = dataOutput.getModContainer().findPath("assets/codelyoko/lang/en_us.existing.json");
                if(pathOptional.isPresent())
                {
                    translationBuilder.add(pathOptional.get());
                }

            } catch (final Exception e)
            {
                throw new RuntimeException("failed to add existing language file", e);
            }
        }


    }
    public static final class FrenchProvider extends FabricLanguageProvider
    {

        public FrenchProvider(final FabricDataOutput dataOutput,CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, "fr_fr",registryLookup);
        }

        @Override
        public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup,final TranslationBuilder translationBuilder) {
            //translationBuilder.add(ModItems.LYOKO_THEME_INSTRUMENTAL,"Générique de CodeLyoko (Remix d'Instrumental)");
            //translationBuilder.add(ModItems.LYOKO_THEME_INSTRUMENTAL.getTranslationKey()+".desc","Un Monde Sans Danger (Remix d'Instrumental) - FractelLegend");
            try{
                final Optional<Path> optionalPath = dataOutput.getModContainer().findPath("assets/codelyoko/lang/fr_fr.existing.json");
                if(optionalPath.isPresent()) {
                    translationBuilder.add(optionalPath.get());
                }
            } catch (final Exception e)
            {
                throw new RuntimeException("failed to add existing language file", e);
            }
        }
    }
}
