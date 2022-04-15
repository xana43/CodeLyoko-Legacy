package com.Ultra_Nerd.CodeLyokoLegacy.player.Dimension;

import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.INBTSerializable;

public final class DimensionCapabilities implements INBTSerializable<ListTag>
{
    private ListTag playerInventory = new ListTag();

    public void savePlayerInventory(Player player)
    {
        player.getInventory().save(playerInventory);
    }
    public void setPlayerInventory(Player player)
    {

       player.getInventory().load(playerInventory);

    }
    @Override
    public ListTag serializeNBT() {
        ListTag saveTag = new ListTag();
        if(playerInventory != null) {
            saveTag.addAll(playerInventory);
        }
        return saveTag;
    }

    @Override
    public void deserializeNBT(final ListTag nbt) {

        for(int i = 0; i < nbt.size(); i++)
        {
            playerInventory.set(i,nbt.get(i));
        }
    }
}
