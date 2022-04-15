package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityFan;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelFan;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;


public final class RendFan extends GeoProjectilesRenderer<EntityFan> {


    public RendFan(EntityRendererProvider.@NotNull Context renderManager) {
        super(renderManager, new ModelFan());
    }










}
