package com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities;


import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;


public final class PlayerClassComponent implements PlayerComponent<PlayerClassComponent>, AutoSyncedComponent {

    private int classID;

    /*
    public PlayerClassComponent(final PlayerEntity player){
    }

     */
    public int getClassID() {
        return this.classID;
    }

    public void setClassID(final int classID) {
        //CodeLyokoMain.LOG.info("setting classID " + classID +" for player " + player.getName());
        this.classID = classID;
    }

    @Override
    public void readFromNbt(final @NotNull NbtCompound tag) {
        classID = tag.getInt("player_class");
        //CodeLyokoMain.LOG.info("Loading Data for Player " + player.getName());
    }

    @Override
    public void writeToNbt(final @NotNull NbtCompound tag) {
        //CodeLyokoMain.LOG.info("Saving data for Player " + player.getName());
        tag.putInt("player_class", classID);
    }
}
