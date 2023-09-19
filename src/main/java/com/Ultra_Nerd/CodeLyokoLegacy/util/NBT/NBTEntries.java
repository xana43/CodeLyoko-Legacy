package com.Ultra_Nerd.CodeLyokoLegacy.util.NBT;

import net.minecraft.nbt.NbtCompound;

public record NBTEntries() {
    public static final NbtCompound chilled = new DefaultNbtHelper(false,"chilled");
}
