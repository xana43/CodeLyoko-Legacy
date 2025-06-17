// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.HornetEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public final class ModelHornet extends DefaultedEntityGeoModel<HornetEntity> {
    public ModelHornet() {
        super(CodeLyokoMain.codeLyokoPrefix("hornet"));
        withAltTexture(CodeLyokoMain.codeLyokoPrefix("hornet/hornetatlas"));
    }


    @Override
    public @Nullable RenderLayer getRenderType(final GeoRenderState renderState,final Identifier texture) {
        return RenderLayer.getEntityTranslucent(getTextureResource(renderState));
    }


}