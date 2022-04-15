package com.Ultra_Nerd.CodeLyokoLegacy.items.armor.Models.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public final class ModModelLayers {




    public static final ModelLayerLocation FELINE_LAYER_LOCATION_INNER = MakeModelRegistry("feline_armor","inner");
    public static final ModelLayerLocation FELINE_LAYER_LOCATION_OUTER = MakeModelRegistry("feline_armor","outer");




    private static @NotNull ModelLayerLocation MakeModelRegistry(@NotNull String name)
    {
        return MakeModelRegistry(name,"main");
    }

    private static @NotNull ModelLayerLocation MakeModelRegistry(@NotNull String name, @NotNull String Layer)
    {
        return new ModelLayerLocation(new ResourceLocation(CodeLyokoMain.MOD_ID,name),Layer);
    }
}
