package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityFan;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelFan;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public final class RendFan extends GeoEntityRenderer<EntityFan> {
    public RendFan(final EntityRendererFactory.Context renderManager) {
        super(renderManager, new ModelFan());
    }




}
