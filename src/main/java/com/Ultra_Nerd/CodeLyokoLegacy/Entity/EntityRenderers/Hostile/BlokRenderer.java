package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Hostile;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelBlok;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.EntityBlok;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public final class BlokRenderer extends GeoEntityRenderer<EntityBlok> {
    public BlokRenderer(final EntityRendererFactory.Context ctx) {
        super(ctx, new ModelBlok());
    }
}






