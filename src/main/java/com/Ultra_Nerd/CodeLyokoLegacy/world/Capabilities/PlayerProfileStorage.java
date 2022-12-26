package com.Ultra_Nerd.CodeLyokoLegacy.world.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerProfile;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

public final class PlayerProfileStorage implements AutoSyncedComponent{


    private PlayerEntity player;
    private PlayerProfile playerProfile;
    public void saveProfile(final PlayerEntity player)
    {
        this.player = player;

            final PlayerProfile playerProfile = new PlayerProfile(player);
            playerProfile.loadDNA();
            playerProfile.refreshPlayerClass();
            this.playerProfile = playerProfile;

    }
    public PlayerProfile getPlayerProfile(final PlayerEntity player)
    {
        this.player = player;
        return playerProfile;
    }
    @Override
    public void readFromNbt(final NbtCompound tag) {
        if(player != null) {
            final PlayerProfile playerProfile = new PlayerProfile(player);
            playerProfile.fromTag(tag);
            this.playerProfile = playerProfile;
        }
    }

    @Override
    public void writeToNbt(final NbtCompound tag) {
        if(player != null) {
        final NbtCompound profileTag = new NbtCompound();

            tag.put(player.getUuidAsString(), playerProfile.toTag(profileTag));
        }


    }
}
