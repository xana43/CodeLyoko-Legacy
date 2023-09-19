package com.Ultra_Nerd.CodeLyokoLegacy.Entity.Capabilities;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public final class SkidBladnirData implements AutoSyncedComponent {

    private final Entity entity;
    private final BlockPos[] positions = new BlockPos[2];

    private static final String HOME_KEY = "home_position";
    private static final String DESTINATION_KEY = "destination_position";
    public SkidBladnirData(final Entity entity)
    {
        this.entity = entity;
    }
    public void setLyokoPosition(final BlockPos position)
    {
        positions[0] = position;
    }
    public void setHubDestinationPosition(final BlockPos position)
    {
        positions[1] = position;
    }
    public Entity getEntity()
    {
        return entity;
    }
    public BlockPos getLyokoPosition()
    {
        return positions[0];
    }
    public BlockPos getHubDestinationPosition()
    {
        return positions[1];
    }


    @Override
    public void readFromNbt(final NbtCompound tag) {
        positions[0] = BlockPos.fromLong(tag.getLong(HOME_KEY));
        positions[1] = BlockPos.fromLong(tag.getLong(DESTINATION_KEY));
    }

    @Override
    public void writeToNbt(final NbtCompound tag) {
        tag.putLong(HOME_KEY,positions[0].asLong());
        tag.putLong(DESTINATION_KEY,positions[1].asLong());
    }
}
