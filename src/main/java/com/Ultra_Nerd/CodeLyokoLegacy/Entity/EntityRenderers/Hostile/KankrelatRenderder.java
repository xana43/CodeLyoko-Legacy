package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Hostile;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelKankrelat;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.KankrelatEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public final class KankrelatRenderder<R extends EntityRenderState & GeoRenderState> extends GeoEntityRenderer<KankrelatEntity,R> {


    public KankrelatRenderder(final EntityRendererFactory.Context renderManager) {
        super(renderManager, new ModelKankrelat());
    }
}
