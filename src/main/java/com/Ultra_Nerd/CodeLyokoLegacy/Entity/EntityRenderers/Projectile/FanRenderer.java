package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Projectile;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelFan;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.FanEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public final class FanRenderer extends GeoEntityRenderer<FanEntity> {
    public FanRenderer(final EntityRendererFactory.Context renderManager) {
        super(renderManager, new ModelFan());
    }




}
