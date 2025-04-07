package com.Ultra_Nerd.CodeLyokoLegacy.Player;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.NotNull;
import org.ladysnake.cca.api.v3.util.NbtSerializable;

import java.util.Objects;

public final class PlayerProfile implements NbtSerializable {
    private final PlayerEntity player;
    private int playerClassType;
    private String DNA;
    private int timesEntered = 0;
    private boolean firstJoin;

    public PlayerProfile(final PlayerEntity player) {
        super();
        this.player = player;
    }

    public int getPlayerClassType() {
        return playerClassType;
    }

    public void refreshPlayerClass() {
        playerClassType = CardinalData.LyokoClass.getLyokoClass(player);

    }

    public boolean getFirstJoin() {
        return firstJoin;
    }

    public void setFirstJoin(final boolean firstJoin) {
        this.firstJoin = firstJoin;
    }

    public void incrementEntered() {
        timesEntered++;
    }

    public void loadDNA() {
        DNA = CardinalData.HumanDNAAttribute.getDna(player);
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public String getDNA() {
        return DNA;
    }

    @Override
    public void fromTag(final @NotNull NbtCompound tag, final RegistryWrapper.WrapperLookup registryLookup) {
        if (player == null) {
            CodeLyokoMain.LOG.warn("player is null, cannot assign values");
            return;
        }
        //this.player.readNbt(tag);
        DNA = tag.getString(player.getUuid() + "-dna");
        playerClassType = tag.getInt(player.getUuid() + "-class");
        timesEntered = tag.getInt(player.getUuid() + "-entered");
        firstJoin = tag.getBoolean(player.getUuid() + "-joined");
    }

    private NbtCompound toCommonTag() {
        final NbtCompound compound = new NbtCompound();
        return toCommonTag(compound);
    }

    private NbtCompound toCommonTag(final @NotNull NbtCompound tag) {
        if (player != null) {
            tag.putString(player.getUuid() + "-dna", DNA);
            tag.putInt(player.getUuid() + "-class", playerClassType);
            tag.putInt(player.getUuid() + "-entered", timesEntered);
            tag.putBoolean(player.getUuid() + "-joined", firstJoin);
            return tag;
        } else {
            throw new NullPointerException("player is null, cannot write values");
        }
    }

    @Override
    public @NotNull NbtCompound toTag(final @NotNull NbtCompound tag, final RegistryWrapper.WrapperLookup registryLookup) {
        return toCommonTag(tag);
    }

    public NbtCompound toTag() {
        return toCommonTag();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof final PlayerProfile otherPlayerProfile) {
            return Objects.equals(DNA, otherPlayerProfile.DNA) && player == otherPlayerProfile.player && playerClassType == otherPlayerProfile.playerClassType && timesEntered == otherPlayerProfile.timesEntered && firstJoin == otherPlayerProfile.firstJoin;
        } else {
            return super.equals(obj);
        }
    }


}
