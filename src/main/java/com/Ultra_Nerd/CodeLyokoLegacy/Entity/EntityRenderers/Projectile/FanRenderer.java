package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Projectile;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelFan;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.EntityFan;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public final class FanRenderer extends GeoEntityRenderer<EntityFan> {
    public FanRenderer(final EntityRendererFactory.Context renderManager) {
        super(renderManager, new ModelFan());
    }




}
