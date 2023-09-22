package com.Ultra_Nerd.CodeLyokoLegacy.player;

import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import dev.onyxstudios.cca.api.v3.util.NbtSerializable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class PlayerProfile implements NbtSerializable {
    private final PlayerEntity player;
    private int playerClassType;
    private String DNA;
    private int timesEntered = 0;
    public PlayerProfile(final PlayerEntity player)
    {
        this.player = player;
    }

    public int getPlayerClassType()
    {
        return playerClassType;
    }

    public void refreshPlayerClass()
    {
      playerClassType = CardinalData.LyokoClass.getLyokoClass(player);

    }
    public void incrementEntered()
    {
        timesEntered++;
    }
    public void loadDNA()
    {
        DNA = CardinalData.HumanDNAAttribute.getDna(player);
    }
    public PlayerEntity getPlayer()
    {
        return player;
    }
    public String getDNA()
    {
        return DNA;
    }


    @Override
    public void fromTag(final @NotNull NbtCompound tag) {
        if(player != null) {
            //this.player.readNbt(tag);
            this.DNA = tag.getString(player.getEntityName() + "-dna");
            this.playerClassType = tag.getInt(player.getEntityName() + "-class");
            this.timesEntered = tag.getInt(player.getEntityName() + "-entered");
        }
    }

    @Override
    public NbtCompound toTag(final @NotNull NbtCompound tag) {
        if(player != null) {
            tag.putString(player.getEntityName() + "-dna", DNA);
            tag.putInt(player.getEntityName() + "-class", playerClassType);
            tag.putInt(player.getEntityName() + "-entered", timesEntered);
            //player.writeNbt(tag);
        }
        return tag;
    }
    public NbtCompound toTag()
    {
        final NbtCompound compound = new NbtCompound();
        if(player != null)
        {
            compound.putString(player.getEntityName() + "-dna", DNA);
            compound.putInt(player.getEntityName() + "-class", playerClassType);
            compound.putInt(player.getEntityName() + "-entered", timesEntered);
            return compound;
        }
        return compound;
    }

    @Override
    public boolean equals(final Object obj) {
        if(obj instanceof final PlayerProfile otherPlayerProfile)
        {
            return Objects.equals(this.DNA, otherPlayerProfile.DNA) && this.player == otherPlayerProfile.player && this.playerClassType == otherPlayerProfile.playerClassType && this.timesEntered == otherPlayerProfile.timesEntered;
        }
        else
        {
            return false;
        }
    }


}
