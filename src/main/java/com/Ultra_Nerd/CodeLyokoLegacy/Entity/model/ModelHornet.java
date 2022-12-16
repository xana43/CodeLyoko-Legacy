// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoLegacy.Entity.model;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HornetEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public final class ModelHornet extends DefaultedEntityGeoModel<HornetEntity> {
    public ModelHornet() {
        super(CodeLyokoMain.codeLyokoPrefix("hornet"));
    }

    @Override
    public DefaultedEntityGeoModel<HornetEntity> withAltAnimations(final Identifier altPath) {
        return super.withAltAnimations(CodeLyokoMain.codeLyokoPrefix("animations/entities/hornet.json"));
    }

    @Override
    public DefaultedEntityGeoModel<HornetEntity> withAltTexture(final Identifier altPath) {
        return super.withAltTexture(CodeLyokoMain.codeLyokoPrefix("textures/entity/hornet/hornetatlas.png"));
    }

    @Override
    public RenderLayer getRenderType(final HornetEntity animatable, final Identifier texture) {
        return RenderLayer.getEntityTranslucent(getTextureResource(animatable));
    }

   /*
    @Override
    public @Nullable ResourceLocation getModelResource(HornetEntity object) {
        return null;
    }

    @Override
    public @Nullable ResourceLocation getTextureResource(HornetEntity object) {
        return null;
    }

    @Override
    public @NotNull ResourceLocation getAnimationResource(HornetEntity animatable) {
        return new ResourceLocation(CodeLyokoMain.MOD_ID, "animations/entities/hornet.json");
    }

 */
}