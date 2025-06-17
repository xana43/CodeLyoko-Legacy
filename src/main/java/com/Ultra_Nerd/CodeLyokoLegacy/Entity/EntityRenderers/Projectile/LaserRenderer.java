package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Projectile;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.ArrowEntityRenderState;
import net.minecraft.util.Identifier;

public final class LaserRenderer extends ArrowEntityRenderer {

    public LaserRenderer(final EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    protected Identifier getTexture(ArrowEntityRenderState arrowEntityRenderState) {
        return CodeLyokoMain.codeLyokoPrefix("textures/entity/laserarrow.png");
    }
}
