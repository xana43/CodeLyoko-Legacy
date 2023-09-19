package com.Ultra_Nerd.CodeLyokoLegacy.util.NBT;

import net.minecraft.nbt.NbtCompound;

public final class DefaultNbtHelper extends NbtCompound {

    public DefaultNbtHelper(final Boolean booleanValue,final String name)
    {
        super();
        this.putBoolean(name,booleanValue);
    }

}
