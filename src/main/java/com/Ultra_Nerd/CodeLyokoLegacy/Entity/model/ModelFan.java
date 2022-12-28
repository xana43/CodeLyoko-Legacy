package com.Ultra_Nerd.CodeLyokoLegacy.Entity.model;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityFan;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;

public final class ModelFan extends DefaultedEntityGeoModel<EntityFan> {
    private static final Identifier FAN_MODEL = CodeLyokoMain.codeLyokoPrefix("geo/fan.geo.json");
    private static final Identifier FAN_TEXTURE = CodeLyokoMain.codeLyokoPrefix("projectiles/fan/fan");
    private static final Identifier FAN_ANIMATION = CodeLyokoMain.codeLyokoPrefix("animations/entity/fan.animation.json");
    public ModelFan() {
        super(CodeLyokoMain.codeLyokoPrefix("fan"));
        withAltTexture(FAN_TEXTURE);
    }
/*



    @Override
    public @NotNull ResourceLocation getModelResource(EntityFan object) {
        return FAN_MODEL;
    }

    @Override
    public @NotNull ResourceLocation getTextureResource(EntityFan object) {
        return FAN_TEXTURE;
    }

    @Override
    public @NotNull ResourceLocation getAnimationResource(EntityFan animatable) {
        return FAN_ANIMATION;
    }

 */
}