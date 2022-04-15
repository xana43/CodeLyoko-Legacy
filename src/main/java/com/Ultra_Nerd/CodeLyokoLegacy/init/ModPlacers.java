package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.world.ModFeatures.FoliagePlaces.DigitalForestTreeDecorator;
import com.Ultra_Nerd.CodeLyokoLegacy.world.ModFeatures.FoliagePlaces.DigitalForestTreePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModPlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> placerTypes = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, CodeLyokoMain.MOD_ID);
    public static final DeferredRegister<TreeDecoratorType<?>> DECORATOR_TYPE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES,CodeLyokoMain.MOD_ID);
    public static final RegistryObject<TreeDecoratorType<?>> DIGITAL_TREE_DECORATOR = DECORATOR_TYPE_DEFERRED_REGISTER.register("digital_tree_core_placer", () ->
            new TreeDecoratorType<>(DigitalForestTreeDecorator.CODEC));
    public static final RegistryObject<FoliagePlacerType<?>> DIGITAL_TREE_PLACER = placerTypes.register("digital_tree_placer",() ->
            new FoliagePlacerType<>(DigitalForestTreePlacer.CODEC));



}
