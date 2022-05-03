package com.Ultra_Nerd.CodeLyokoLegacy;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.PlayerClassComponent;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;

public class CodeLyokoCardinalData implements EntityComponentInitializer {
    public static final ComponentKey<PlayerClassComponent> pclass = ComponentRegistry.getOrCreate(CodeLyokoMain.CodeLyokoPrefix("pclass"),PlayerClassComponent.class);

    @Override
    public void registerEntityComponentFactories(final EntityComponentFactoryRegistry registry) {
       registry.registerForPlayers(pclass, PlayerClassComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
        CodeLyokoMain.LOG.info("registered cardinal data");
    }
}
