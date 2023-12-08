package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Hostile;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelManta;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.MantaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public final class MantaRenderer extends GeoEntityRenderer<MantaEntity> {
    public MantaRenderer(final EntityRendererFactory.Context ctx) {
        super(ctx, new ModelManta());
    }

}
