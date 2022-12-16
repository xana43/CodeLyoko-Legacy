package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityBlok;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelBlok;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public final class RendBlok extends GeoEntityRenderer<EntityBlok> {
    public RendBlok(final EntityRendererFactory.Context ctx) {
        super(ctx, new ModelBlok());
    }
}






