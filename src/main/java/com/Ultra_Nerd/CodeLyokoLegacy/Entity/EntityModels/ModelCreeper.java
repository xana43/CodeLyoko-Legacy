package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.LyokoCreeperEntity;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public final class ModelCreeper extends DefaultedEntityGeoModel<LyokoCreeperEntity> {
    public ModelCreeper(final boolean turnsHead) {
        super(CodeLyokoMain.codeLyokoPrefix("creeper"), turnsHead);
    }
}
