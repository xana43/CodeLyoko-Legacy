package com.Ultra_Nerd.CodeLyokoLegacy.Entity.Capabilities;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public final class SkidBladnirData implements AutoSyncedComponent {

    private final BlockPos[] positions = new BlockPos[2];

    private static final String HOME_KEY = "home_position";
    private static final String DESTINATION_KEY = "destination_position";
    public SkidBladnirData()
    {

    }
    public void setLyokoPosition(final BlockPos position)
    {
        positions[0] = position;
    }
    public void setHubDestinationPosition(final BlockPos position)
    {
        positions[1] = position;
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
        if(positions[0] != null && positions[1] != null && positions[0] != BlockPos.ORIGIN && positions[1] != BlockPos.ORIGIN) {
            tag.putLong(HOME_KEY, positions[0].asLong());
            tag.putLong(DESTINATION_KEY, positions[1].asLong());
        }
    }
}
