package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.FanEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public final class ModelFan extends DefaultedEntityGeoModel<FanEntity> {
    private static final Identifier FAN_MODEL = CodeLyokoMain.codeLyokoPrefix("geo/fan.geo.json");
    private static final Identifier FAN_TEXTURE = CodeLyokoMain.codeLyokoPrefix("projectiles/fan/fan");
    private static final Identifier FAN_ANIMATION = CodeLyokoMain.codeLyokoPrefix("animations/entity/fan.animation.json");
    public ModelFan() {
        super(CodeLyokoMain.codeLyokoPrefix("fan"));
        withAltTexture(FAN_TEXTURE);
    }

}