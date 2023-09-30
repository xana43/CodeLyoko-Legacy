package com.Ultra_Nerd.CodeLyokoLegacy.util.NBT;

import net.minecraft.nbt.NbtCompound;

public final class DefaultNbtHelper extends NbtCompound {
    public DefaultNbtHelper(final Boolean booleanValue,final String name)
    {
        super();
        this.putBoolean(name, booleanValue.booleanValue());
    }

    public DefaultNbtHelper(final int intValue,final String name)
    {
        super();
        this.putInt(name,intValue);
    }

    public DefaultNbtHelper(final int[] intArray, final String name)
    {
        super();
        this.putIntArray(name,intArray);
    }
}
