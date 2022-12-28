package com.Ultra_Nerd.CodeLyokoLegacy.player;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.jetbrains.annotations.NotNull;

@NotNull
@Environment(EnvType.CLIENT)
public enum PlayerClassType {

    Archer("Archer", 34),
    Feline("Felyne", 62),
    Guardian("Guardian", 90),
    Samurai("Samurai", 118),
    Ninja("Ninja", 146);

    private final @NotNull String name;
    private final int textureIndex;


    PlayerClassType(@NotNull final String nameIn, final int TextureIndex) {
        this.name = nameIn;
        this.textureIndex = TextureIndex;
    }


    public final String getClassName() {
        return this.name;
    }


    public final int getTextureIndex() {
        return this.textureIndex;
    }


}
