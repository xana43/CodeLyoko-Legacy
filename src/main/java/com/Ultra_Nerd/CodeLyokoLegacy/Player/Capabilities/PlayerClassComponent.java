package com.Ultra_Nerd.CodeLyokoLegacy.Player.Capabilities;


import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.NotNull;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;


public final class PlayerClassComponent implements AutoSyncedComponent {

    private int classID;

    public int getClassID() {
        return this.classID;
    }

    public void setClassID(final int classID) {
        this.classID = classID;
    }

    @Override
    public void readFromNbt(final @NotNull NbtCompound tag,final RegistryWrapper.WrapperLookup registryLookup) {
        classID = tag.getInt("player_class");
    }

    @Override
    public void writeToNbt(final @NotNull NbtCompound tag,final RegistryWrapper.WrapperLookup registryLookup) {
        tag.putInt("player_class", classID);
    }
}
