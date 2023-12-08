package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Hostile;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelCreeper;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.LyokoCreeperEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public final class LyokoCreeperRenderer extends GeoEntityRenderer<LyokoCreeperEntity> {
    public LyokoCreeperRenderer(final EntityRendererFactory.Context renderManager) {
        super(renderManager, new ModelCreeper(true));
    }
}
