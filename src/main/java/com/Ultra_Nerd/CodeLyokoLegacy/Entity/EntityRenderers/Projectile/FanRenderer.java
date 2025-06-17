package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Projectile;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelFan;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.FanEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public final class FanRenderer<R extends EntityRenderState & GeoRenderState> extends GeoEntityRenderer<FanEntity, R> {
    public FanRenderer(final EntityRendererFactory.Context renderManager) {
        super(renderManager, new ModelFan());
    }




}
