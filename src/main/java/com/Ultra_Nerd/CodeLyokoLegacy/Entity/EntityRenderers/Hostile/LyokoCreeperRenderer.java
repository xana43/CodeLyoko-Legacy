package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Hostile;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelCreeper;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.LyokoCreeperEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public final class LyokoCreeperRenderer<R extends EntityRenderState & GeoRenderState> extends GeoEntityRenderer<LyokoCreeperEntity,R> {
    public LyokoCreeperRenderer(final EntityRendererFactory.Context renderManager) {
        super(renderManager, new ModelCreeper(true));
    }
}
