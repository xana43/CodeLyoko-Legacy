package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import net.minecraft.client.world.GeneratorType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(GeneratorType.class)
public interface GeneratorTypeAccessor
{
    @Accessor("VALUES")
    public static List<GeneratorType> getValues()
    {
        throw  new AssertionError();
    }
}