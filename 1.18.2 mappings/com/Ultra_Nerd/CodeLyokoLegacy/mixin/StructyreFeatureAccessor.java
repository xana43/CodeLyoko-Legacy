package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.Structures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Structures.class)
public interface StructyreFeatureAccessor {

    @Invoker
    static <F extends Structure<?>> F callRegister(String name, F structureFeature, GenerationStep.Feature step)
    {
        throw new UnsupportedOperationException();
    }
}
