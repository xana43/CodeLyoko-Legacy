package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityBlok;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelBlok;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public final class RendBlok extends GeoEntityRenderer<EntityBlok> {



    public RendBlok(EntityRendererProvider.@NotNull Context renderManager) {
        super(renderManager,new ModelBlok());

    }


}
