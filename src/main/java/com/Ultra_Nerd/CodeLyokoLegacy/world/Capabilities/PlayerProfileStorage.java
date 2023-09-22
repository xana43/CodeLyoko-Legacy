package com.Ultra_Nerd.CodeLyokoLegacy.world.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerProfile;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public final class PlayerProfileStorage implements AutoSyncedComponent{


    //private PlayerEntity player;
    private static final HashMap<UUID,NbtCompound> PLAYER_PROFILE_HASH_MAP = new HashMap<>();

    public void saveProfile(final PlayerEntity player)
    {
        //CodeLyokoMain.LOG.info(PLAYER_PROFILE_HASH_MAP.toString());
        if(!PLAYER_PROFILE_HASH_MAP.containsKey(player.getUuid())) {
            final PlayerProfile playerProfile = new PlayerProfile(player);
            playerProfile.loadDNA();
            playerProfile.refreshPlayerClass();
            PLAYER_PROFILE_HASH_MAP.put(player.getUuid(), playerProfile.toTag());
        }
    }


    public PlayerProfile getPlayerProfile(final PlayerEntity player)
    {
        if(PLAYER_PROFILE_HASH_MAP.containsKey(player.getUuid())) {
            final PlayerProfile profile = new PlayerProfile(player);
            profile.fromTag(PLAYER_PROFILE_HASH_MAP.get(player.getUuid()));
            return profile;
        }
        throw new RuntimeException("Player:"+player.getEntityName()+" not found");
    }
    public void updatePlayerProfile(final PlayerProfile newProfile)
    {
        PLAYER_PROFILE_HASH_MAP.replace(newProfile.getPlayer().getUuid(), newProfile.toTag());
    }
    @Override
    public void readFromNbt(final NbtCompound tag) {

        for (final String tagKey : tag.getKeys()) {
            final NbtCompound compound = tag.getCompound(tagKey);
            PLAYER_PROFILE_HASH_MAP.put(UUID.fromString(tagKey), compound);

        }
    }

    @Override
    public void writeToNbt(final @NotNull NbtCompound tag) {
       PLAYER_PROFILE_HASH_MAP.forEach((uuid, playerProfile) -> tag.put(uuid.toString(), playerProfile));
    }
}
