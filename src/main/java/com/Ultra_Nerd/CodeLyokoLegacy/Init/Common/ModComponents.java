package com.Ultra_Nerd.CodeLyokoLegacy.Init.Common;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public record ModComponents() {
    private static final Object2ObjectMap<ComponentType<?>, Identifier> COMPONENT_TYPES = new Object2ObjectOpenHashMap<>();
    public static final ComponentType<Boolean> CHILLED;
    static {
        CHILLED = createComponentType("chilled",Codec.BOOL);
    }
    private static ComponentType<?> createComponentType(final String identifier) {
        return createComponentType(identifier,null);
    }
    private static <T> ComponentType<T> createComponentType(final String identifier, final Codec codecUsed) {
        final ComponentType<T> componentType = ComponentType.builder().codec(codecUsed).build();
        COMPONENT_TYPES.put(componentType, CodeLyokoMain.codeLyokoPrefix(identifier));
        return componentType;
    }
    public static void initializeComponents()
    {
        COMPONENT_TYPES.forEach((componentType, identifier) -> Registry.register(Registries.DATA_COMPONENT_TYPE, identifier, componentType));
    }
}
