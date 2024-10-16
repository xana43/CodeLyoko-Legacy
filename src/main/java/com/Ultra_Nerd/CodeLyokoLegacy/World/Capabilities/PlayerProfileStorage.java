package com.Ultra_Nerd.CodeLyokoLegacy.World.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Player.PlayerProfile;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.NotNull;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.level.LevelComponents;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("MethodMayBeStatic")
public final class PlayerProfileStorage implements AutoSyncedComponent {


    //private PlayerEntity player;
    private static final Object2ObjectMap<UUID,NbtCompound> PLAYER_PROFILE_HASH_MAP = new Object2ObjectOpenHashMap<>();

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
            final PlayerProfile tmpProfile = getProfileFromMap(player,playerUUID,player.getRegistryManager());
            profileCache.put(playerUUID,tmpProfile);
            return PLAYER_PROFILE_HASH_MAP.containsKey(playerUUID) ? tmpProfile : null;
        }
        LevelComponents.sync(CardinalData.PlayerSavedProfile.getPlayerProfileComponentKey(), Objects.requireNonNull(player.getServer()));
        return profileCache.get(playerUUID);
    }

    private static PlayerProfile getProfileFromMap(final PlayerEntity player,final UUID uuid, RegistryWrapper. WrapperLookup registryLookup) {
        final PlayerProfile profile = new PlayerProfile(player);
        final NbtCompound compound = PLAYER_PROFILE_HASH_MAP.get(uuid);
        if(compound != null) {
            profile.fromTag(compound,registryLookup);
        }
        else
        {
            CodeLyokoMain.LOG.warn("no player profile data found, creating new profile");
        }
        LevelComponents.sync(CardinalData.PlayerSavedProfile.getPlayerProfileComponentKey(), Objects.requireNonNull(player.getServer()));
        return profile;
    }
    public void updatePlayerProfile(@NotNull final PlayerProfile newProfile) {
        if(newProfile.toTag().equals(PLAYER_PROFILE_HASH_MAP.get(newProfile.getPlayer().getUuid()))) {
            return;
        }
        PLAYER_PROFILE_HASH_MAP.replace(newProfile.getPlayer().getUuid(), newProfile.toTag());
        LevelComponents.sync(CardinalData.PlayerSavedProfile.getPlayerProfileComponentKey(), Objects.requireNonNull(newProfile.getPlayer().getServer()));
    }
    @Override
    public void readFromNbt(final NbtCompound tag,final RegistryWrapper.WrapperLookup wrapperLookup) {
        tag.getKeys().forEach(tagKey -> PLAYER_PROFILE_HASH_MAP.put(UUID.fromString(tagKey),tag.getCompound(tagKey)));
    }

    @Override
    public void writeToNbt(final @NotNull NbtCompound tag,final RegistryWrapper.WrapperLookup wrapperLookup) {
        Object2ObjectMaps.fastForEach(PLAYER_PROFILE_HASH_MAP,uuidNbtCompoundEntry -> tag.put(uuidNbtCompoundEntry.getKey().toString(),uuidNbtCompoundEntry.getValue()));
    }
}
