package com.Ultra_Nerd.CodeLyokoLegacy.world.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerProfile;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public final class PlayerProfileStorage implements AutoSyncedComponent{


    //private PlayerEntity player;
    private static final Map<UUID,NbtCompound> PLAYER_PROFILE_HASH_MAP = new HashMap<>();

    public void saveProfile(final PlayerEntity player)
    {
        //CodeLyokoMain.LOG.info(PLAYER_PROFILE_HASH_MAP.toString());
        PLAYER_PROFILE_HASH_MAP.computeIfAbsent(player.getUuid(),uuid -> {
            final PlayerProfile playerProfile = new PlayerProfile(player);
            playerProfile.loadDNA();
            playerProfile.refreshPlayerClass();
            return playerProfile.toTag();
        });
    }

    private static final Map<UUID,PlayerProfile> profileCache = new HashMap<>();
    public PlayerProfile getPlayerProfile(final PlayerEntity player)
    {
        final UUID playerUUID = player.getUuid();
        final PlayerProfile cachedProfile = profileCache.get(playerUUID);
        if(cachedProfile == null) {
            final PlayerProfile tmpProfile = getProfileFromMap(player,playerUUID);
            profileCache.put(playerUUID,tmpProfile);
            return PLAYER_PROFILE_HASH_MAP.containsKey(playerUUID) ? tmpProfile : null;
        }
        return profileCache.get(playerUUID);
    }

    private static PlayerProfile getProfileFromMap(final PlayerEntity player,final UUID uuid)
    {
        final PlayerProfile profile = new PlayerProfile(player);
        profile.fromTag(PLAYER_PROFILE_HASH_MAP.get(uuid));
        return profile;
    }
    public void updatePlayerProfile(@NotNull final PlayerProfile newProfile)
    {
        if(newProfile == null)
        {
            throw new NullPointerException("the new data that the profile is being updated with is null");
        }
        final PlayerProfile cachedProfile = profileCache.get(newProfile.getPlayer().getUuid());
        if(cachedProfile != null) {
            profileCache.replace(newProfile.getPlayer().getUuid(), newProfile);
        }
        PLAYER_PROFILE_HASH_MAP.replace(newProfile.getPlayer().getUuid(), newProfile.toTag());
    }
    @Override
    public void readFromNbt(final NbtCompound tag) {
        tag.getKeys().forEach(tagKey -> PLAYER_PROFILE_HASH_MAP.put(UUID.fromString(tagKey),tag.getCompound(tagKey)));
    }

    @Override
    public void writeToNbt(final @NotNull NbtCompound tag) {
       PLAYER_PROFILE_HASH_MAP.forEach((uuid, playerProfile) -> tag.put(uuid.toString(), playerProfile));
    }
}
