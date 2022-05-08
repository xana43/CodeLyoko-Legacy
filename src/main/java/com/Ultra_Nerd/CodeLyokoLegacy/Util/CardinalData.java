package com.Ultra_Nerd.CodeLyokoLegacy.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities.PlayerClassComponent;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.NotNull;

public final class CardinalData implements EntityComponentInitializer {




    public static class LyokoClass{
        public static final ComponentKey<PlayerClassComponent> LYOKOCLASS = ComponentRegistry.getOrCreate(CodeLyokoMain.CodeLyokoPrefix("lyoko_class"),PlayerClassComponent.class);

        public static int getLyokoClass(final PlayerEntity player)
        {
            return LYOKOCLASS.get(player).getClassID();
        }
        public static void setLyokoclass(final PlayerEntity player,final int ID)
        {
            LYOKOCLASS.get(player).setClassID(ID);
        }


    }





    @Override
    public void registerEntityComponentFactories(final @NotNull EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(LyokoClass.LYOKOCLASS,it -> new PlayerClassComponent());

    }
}
