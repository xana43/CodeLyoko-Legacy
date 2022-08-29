package com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;

public final class XanaDataComponent implements AutoSyncedComponent {
    private int dangerLevel;
    public int getDangerLevel()
    {
        return dangerLevel;
    }
    public void setDangerLevel(final int level)
    {
        dangerLevel = level;
    }
    @Override
    public void readFromNbt(final @NotNull NbtCompound tag) {
        dangerLevel = tag.getInt("xana_danger_level");
    }

    @Override
    public void writeToNbt(final @NotNull NbtCompound tag) {
        tag.putInt("xana_danger_level",dangerLevel);
    }
}
