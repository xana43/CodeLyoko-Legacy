package com.Ultra_Nerd.CodeLyokoLegacy.player.Dimension;

import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.INBTSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public final class DimensionCapabilities implements INBTSerializable<ListTag>
{
    private static final HashMap<UUID,ListTag> playermap = new HashMap<>();


    public void savePlayerInventory(Player player)
    {
        final ListTag tags = new ListTag();
        player.getInventory().save(tags);
        playermap.put(player.getUUID(),tags);


    }

    public void setPlayerInventory(@NotNull Player player)
    {
        //if(playermap.get(player.getUUID()) != null) {
            player.getInventory().load(playermap.get(player.getUUID()));
        //}
    }


    @Override
    public ListTag serializeNBT() {
        ListTag tag = new ListTag();

        for (final UUID uuid : playermap.keySet()) {
            tag = playermap.get(uuid);
        }
        return tag;
    }

    @Override
    public void deserializeNBT(final ListTag nbt) {
            for(final UUID uuid : playermap.keySet())
            {
                playermap.replace(uuid,nbt);
            }
    }
}
