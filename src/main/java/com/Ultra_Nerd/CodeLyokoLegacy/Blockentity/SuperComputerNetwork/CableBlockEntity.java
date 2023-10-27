package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperComputerNetwork;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.SuperCalculator.DataPacketType;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.SyncedBlockEntity;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public final class CableBlockEntity extends SyncedBlockEntity {
    private static final List<BlockPos> NETWORK_DEFINITION = new ObjectArrayList<>();

    public CableBlockEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.CABLE_TILE_ENTITY_BLOCK_ENTITY_TYPE, pos, state);
    }

    public void checkPhysicalConnection()
    {
        for(final Direction direction : Direction.values())
        {
            assert world != null;
            if(world.getBlockEntity(pos.offset(direction)) instanceof final CableBlockEntity cableBlockEntity)
            {
                if(!NETWORK_DEFINITION.contains(cableBlockEntity.pos)) {
                    NETWORK_DEFINITION.add(cableBlockEntity.pos);
                }
            }
        }
    }
    private static final Map<BlockPos,DemarcationBlockEntity> DEMARCATION_BLOCK_ENTITY_CACHE = new Object2ObjectOpenHashMap<>();

    public void transferData(final int id, final DataPacketType<?> packet)
    {

        for(final BlockPos position : NETWORK_DEFINITION)
        {
            for(final Direction direction : Direction.values())
            {
                final BlockPos demarcatePosition = position.offset(direction);
                final DemarcationBlockEntity cachedDemarcationPoint = DEMARCATION_BLOCK_ENTITY_CACHE.get(demarcatePosition);
                if(cachedDemarcationPoint != null && cachedDemarcationPoint.getId() == id)
                {
                    CodeLyokoMain.LOG.warn("");
                    cachedDemarcationPoint.testDataReceive(packet);
                    return;
                }
                if(world.getBlockEntity(demarcatePosition) instanceof final DemarcationBlockEntity demarcationBlockEntity && demarcationBlockEntity.getId() == id)
                {
                    DEMARCATION_BLOCK_ENTITY_CACHE.put(demarcatePosition,demarcationBlockEntity);
                    demarcationBlockEntity.testDataReceive(packet);
                    return;
                }
            }
        }
    }
    public void removeFromNetwork()
    {
        NETWORK_DEFINITION.remove(pos);
    }
    private static long convertToLong(final BlockPos pos)
    {
        return pos.asLong();
    }
    private static final String NETWORK_CONNECTION_KEY = "network_connections";
    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        final List<Long> longs = Lists.transform(NETWORK_DEFINITION,CableBlockEntity::convertToLong);
        nbt.putLongArray(NETWORK_CONNECTION_KEY,longs);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        for(final long longs : nbt.getLongArray(NETWORK_CONNECTION_KEY))
        {
            NETWORK_DEFINITION.add(BlockPos.fromLong(longs));
        }
    }
}
