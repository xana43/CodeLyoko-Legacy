package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityFan;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelFan;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;


public final class RendFan extends GeoProjectilesRenderer<EntityFan> {


    public RendFan(EntityRendererProvider.@NotNull Context renderManager) {
        super(renderManager, new ModelFan());
    }










}
