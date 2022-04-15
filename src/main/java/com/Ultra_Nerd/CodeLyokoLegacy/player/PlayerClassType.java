package com.Ultra_Nerd.CodeLyokoLegacy.player;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.enums.LyokoArmorMaterial;
import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.NotNull;
@NotNull
public enum PlayerClassType {

    Archer("Archer",34,LyokoArmorMaterial.ARCHER,new CompoundTag()),
    Feline("Felyne",62,LyokoArmorMaterial.FELINE, new CompoundTag()),
    Guardian("Guardian",90,LyokoArmorMaterial.GUARDIAN, new CompoundTag()),
    Samurai("Samurai",118,LyokoArmorMaterial.SAMURAI, new CompoundTag()),
    Ninja("Ninja",146,LyokoArmorMaterial.NINJA, new CompoundTag()),
    DEFAULT("null",0,LyokoArmorMaterial.LINKER,new CompoundTag());
    private final @NotNull String name;
    private final int textureIndex;
    private final @NotNull LyokoArmorMaterial armorMaterial;
    private final CompoundTag classTag;
    PlayerClassType(@NotNull final String nameIn,final int TextureIntex,@NotNull final LyokoArmorMaterial armorMaterial, @NotNull final CompoundTag classTag)
    {
        this.name = nameIn;
        this.textureIndex = TextureIntex;
        this.armorMaterial = armorMaterial;
        this.classTag = classTag;
        setClassTag();
    }

    @NotNull
    public final LyokoArmorMaterial getArmorMaterial() {
        return armorMaterial;
    }

    @NotNull
    public final String getClassName()
    {
        return this.name;
    }


    public final int getTextureIndex()
    {
        return this.textureIndex;
    }

    @NotNull
    public final CompoundTag getClassTag()
    {
        return this.classTag;
    }

    private void setClassTag()
    {
        this.classTag.putString("Class",getClassName());
    }
}
