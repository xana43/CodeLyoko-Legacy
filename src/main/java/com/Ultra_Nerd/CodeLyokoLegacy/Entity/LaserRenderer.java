package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;

public final class LaserRenderer extends ArrowEntityRenderer {

    public LaserRenderer(final EntityRendererFactory.Context context) {
        super(context);
    }


    @Override
    public Identifier getTexture(final ArrowEntity arrowEntity) {
        return CodeLyokoMain.codeLyokoPrefix("textures/entity/laserarrow.png");
    }
}
