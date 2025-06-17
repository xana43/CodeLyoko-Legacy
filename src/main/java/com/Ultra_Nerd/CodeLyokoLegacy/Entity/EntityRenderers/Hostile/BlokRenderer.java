package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Hostile;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelBlok;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.BlokEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public final class BlokRenderer<R extends EntityRenderState & GeoRenderState> extends GeoEntityRenderer<BlokEntity,R> {
    public BlokRenderer(final EntityRendererFactory.Context ctx) {
        super(ctx, new ModelBlok());
    }
}






