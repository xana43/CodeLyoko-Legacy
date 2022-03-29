package com.Ultra_Nerd.CodeLyokoRemake15.player;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.enums.LyokoArmorMaterial;
import org.jetbrains.annotations.NotNull;
@NotNull
public class PlayerClassType {

    private final String name;
    private final int textureIndex;
    private final LyokoArmorMaterial armorMaterial;
    public PlayerClassType(@NotNull String nameIn, int TextureIntex,@NotNull LyokoArmorMaterial armorMaterial)
    {
        this.name = nameIn;
        this.textureIndex = TextureIntex;
        this.armorMaterial = armorMaterial;

    }


    public LyokoArmorMaterial getArmorMaterial() {
        return armorMaterial;
    }

    @NotNull
    public String getClassName()
    {
        return this.name;
    }

    public int getTextureIndex()
    {
        return this.textureIndex;
    }

}
