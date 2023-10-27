package com.Ultra_Nerd.CodeLyokoLegacy.world.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerProfile;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.level.LevelComponents;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("MethodMayBeStatic")
public final class PlayerProfileStorage implements AutoSyncedComponent{


    //private PlayerEntity player;
    private static final Map<UUID,NbtCompound> PLAYER_PROFILE_HASH_MAP = new Object2ObjectOpenHashMap<>();

    public void saveProfile(final PlayerEntity player)
    {

        //CodeLyokoMain.LOG.info(PLAYER_PROFILE_HASH_MAP.toString());
        PLAYER_PROFILE_HASH_MAP.computeIfAbsent(player.getUuid(),uuid -> {
            CodeLyokoMain.LOG.info("initial player save");
            final PlayerProfile playerProfile = new PlayerProfile(player);
            playerProfile.loadDNA();
            playerProfile.refreshPlayerClass();
            return playerProfile.toTag();
        });
        LevelComponents.sync(CardinalData.PlayerSavedProfile.getPlayerProfileComponentKey(), Objects.requireNonNull(player.getServer()));
    }
    public void removePlayerProfile(final PlayerEntity player)
    {
        final UUID playerUUID = player.getUuid();
        final NbtCompound compound = PLAYER_PROFILE_HASH_MAP.get(playerUUID);
        if(compound != null) {
            PLAYER_PROFILE_HASH_MAP.remove(player.getUuid());
            profileCache.remove(player.getUuid());
        }
        LevelComponents.sync(CardinalData.PlayerSavedProfile.getPlayerProfileComponentKey(), Objects.requireNonNull(player.getServer()));
    }
    private static void resetCache()
    {
        profileCache.clear();
    }
    private static final Map<UUID,PlayerProfile> profileCache = new Object2ObjectOpenHashMap<>();
    public PlayerProfile getPlayerProfile(final PlayerEntity player)
    {
        final UUID playerUUID = player.getUuid();
        final PlayerProfile cachedProfile = profileCache.get(playerUUID);
        if(cachedProfile == null) {
            final PlayerProfile tmpProfile = getProfileFromMap(player,playerUUID);
            profileCache.put(playerUUID,tmpProfile);
            return PLAYER_PROFILE_HASH_MAP.containsKey(playerUUID) ? tmpProfile : null;
        }
        LevelComponents.sync(CardinalData.PlayerSavedProfile.getPlayerProfileComponentKey(), Objects.requireNonNull(player.getServer()));
        return profileCache.get(playerUUID);
    }

    private static PlayerProfile getProfileFromMap(final PlayerEntity player,final UUID uuid)
    {
        final PlayerProfile profile = new PlayerProfile(player);
        final NbtCompound compound = PLAYER_PROFILE_HASH_MAP.get(uuid);
        if(compound != null) {
            profile.fromTag(compound);
        }
        else
        {
            CodeLyokoMain.LOG.warn("no player profile data found, creating new profile");
        }
        LevelComponents.sync(CardinalData.PlayerSavedProfile.getPlayerProfileComponentKey(), Objects.requireNonNull(player.getServer()));
        return profile;
    }
    public void updatePlayerProfile(@NotNull final PlayerProfile newProfile)
    {
        if(newProfile.toTag().equals(PLAYER_PROFILE_HASH_MAP.get(newProfile.getPlayer().getUuid())))
        {
            return;
        }
        PLAYER_PROFILE_HASH_MAP.replace(newProfile.getPlayer().getUuid(), newProfile.toTag());
        LevelComponents.sync(CardinalData.PlayerSavedProfile.getPlayerProfileComponentKey(), Objects.requireNonNull(newProfile.getPlayer().getServer()));
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
