package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Hostile;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelManta;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.MantaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;


public final class MantaRenderer<R extends EntityRenderState & GeoRenderState> extends GeoEntityRenderer<MantaEntity,R> {
    public MantaRenderer(final EntityRendererFactory.Context ctx) {
        super(ctx, new ModelManta());
    }

}
