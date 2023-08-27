package com.Ultra_Nerd.CodeLyokoLegacy.player;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import dev.onyxstudios.cca.api.v3.util.NbtSerializable;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.ServerMetadata;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Arm;
import org.jetbrains.annotations.NotNull;

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
        CodeLyokoMain.LOG.info("refreshing player class");
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
            this.DNA = tag.getString(player.getUuidAsString() + "-dna");
            this.playerClassType = tag.getInt(player.getUuidAsString() + "-class");
            this.timesEntered = tag.getInt(player.getUuidAsString() + "-entered");
        }
    }

    @Override
    public NbtCompound toTag(final @NotNull NbtCompound tag) {
        if(player != null) {
            tag.putString(player.getUuidAsString() + "-dna", DNA);
            tag.putInt(player.getUuidAsString() + "-class", playerClassType);
            tag.putInt(player.getUuidAsString() + "-entered", timesEntered);
            //player.writeNbt(tag);
        }
        return tag;
    }
}
