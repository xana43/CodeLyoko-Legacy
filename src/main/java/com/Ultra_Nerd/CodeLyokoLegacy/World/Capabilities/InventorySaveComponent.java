package com.Ultra_Nerd.CodeLyokoLegacy.World.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.level.LevelComponents;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("MethodMayBeStatic")
public final class InventorySaveComponent implements AutoSyncedComponent {

    private static final Object2ObjectMap<UUID, NbtList> PLAYER_INVENTORY_HASHMAP = new Object2ObjectOpenHashMap<>();

    public void savePlayerInventory(final PlayerEntity player) {
        final NbtList playerStoredInventory = new NbtList();
        player.getInventory().writeNbt(playerStoredInventory);
        PLAYER_INVENTORY_HASHMAP.put(player.getUuid(), playerStoredInventory);
        player.getInventory().clear();
        LevelComponents.sync(CardinalData.LyokoInventorySave.getLyokoInventorySave(), Objects.requireNonNull(player.getServer()));
    }
    public void loadPlayerInventory(final PlayerEntity player) {
        final UUID playerUUID = player.getUuid();
        final NbtList queriedHashmapEntry = PLAYER_INVENTORY_HASHMAP.get(playerUUID);
        if (queriedHashmapEntry != null) {
            player.getInventory().clear();
            player.getInventory().readNbt(queriedHashmapEntry);
        } else {
            CodeLyokoMain.LOG.error("player:"+player.getEntityName()+" not found in save");
        }
        LevelComponents.sync(CardinalData.LyokoInventorySave.getLyokoInventorySave(), Objects.requireNonNull(player.getServer()));
    }

    @Override
    public void readFromNbt(final @NotNull NbtCompound tag) {
        tag.getKeys().forEach(key -> PLAYER_INVENTORY_HASHMAP.put(UUID.fromString(key),tag.getList(key,NbtElement.COMPOUND_TYPE)));
    }

    @Override
    public void writeToNbt(final @NotNull NbtCompound tag) {
        Object2ObjectMaps.fastForEach(PLAYER_INVENTORY_HASHMAP,uuidNbtListEntry -> tag.put(uuidNbtListEntry.getKey().toString(),uuidNbtListEntry.getValue()));
    }
}
