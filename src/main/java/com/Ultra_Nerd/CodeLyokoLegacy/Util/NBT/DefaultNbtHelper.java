package com.Ultra_Nerd.CodeLyokoLegacy.Util.NBT;

import net.minecraft.nbt.NbtCompound;

public final class DefaultNbtHelper extends NbtCompound {
    public DefaultNbtHelper(final boolean booleanValue,final String name)
    {
        super();
        this.putBoolean(name, booleanValue);
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
