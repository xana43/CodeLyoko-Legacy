package com.Ultra_Nerd.CodeLyokoLegacy.Player.Capabilities;


import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;


public final class PlayerClassComponent implements PlayerComponent<PlayerClassComponent>, AutoSyncedComponent {

    private int classID;

    public int getClassID() {
        return this.classID;
    }

    public void setClassID(final int classID) {
        this.classID = classID;
    }

    @Override
    public void readFromNbt(final @NotNull NbtCompound tag) {
        classID = tag.getInt("player_class");
    }

    @Override
    public void writeToNbt(final @NotNull NbtCompound tag) {
        tag.putInt("player_class", classID);
    }
}
