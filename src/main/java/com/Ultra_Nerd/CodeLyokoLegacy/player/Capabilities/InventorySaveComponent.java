package com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import dev.onyxstudios.cca.api.v3.level.LevelComponents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.world.WorldProperties;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public final class InventorySaveComponent implements AutoSyncedComponent {

    private final HashMap<UUID, NbtList> playerInvSave = new HashMap<>();
    private static UUID playerUUID;




    public void savePlayerInventory(final PlayerEntity player)
    {

        playerUUID = player.getUuid();
        //CodeLyokoMain.LOG.info(playerUUID.toString());
        final NbtList playerInvTmp = new NbtList();
        player.getInventory().writeNbt(playerInvTmp);
        playerInvSave.put(player.getUuid(),playerInvTmp);
        player.getInventory().clear();
    }

    public void loadPlayerInventory(final PlayerEntity player)
    {
        //playerUUID = player.getUuid();
        player.getInventory().clear();
        player.getInventory().readNbt(playerInvSave.get(player.getUuid()));
    }
    @Override
    public void readFromNbt(final @NotNull NbtCompound tag) {
       // if(playerUUID != null) {
       // CodeLyokoMain.LOG.info(playerUUID.toString());
            playerInvSave.replace(playerUUID, tag.getList(playerUUID.toString(), NbtList.COMPOUND_TYPE));
       // }
    }

    @Override
    public void writeToNbt(final @NotNull NbtCompound tag) {
            playerInvSave.forEach((uuid, nbtElements) -> tag.put(uuid.toString(),nbtElements));
    }
}
