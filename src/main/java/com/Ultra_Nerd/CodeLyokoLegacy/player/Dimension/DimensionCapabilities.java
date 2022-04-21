package com.Ultra_Nerd.CodeLyokoLegacy.player.Dimension;

public final class DimensionCapabilities //implements INBTSerializable<ListTag>
{
    /*
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

     */
}
