package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Hostile;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelKankrelat;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.KankrelatEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public final class KankrelatRenderder extends GeoEntityRenderer<KankrelatEntity> {


    public KankrelatRenderder(final EntityRendererFactory.Context renderManager) {
        super(renderManager, new ModelKankrelat());
    }
}
