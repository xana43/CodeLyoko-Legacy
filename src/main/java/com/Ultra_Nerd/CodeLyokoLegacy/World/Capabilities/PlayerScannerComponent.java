package com.Ultra_Nerd.CodeLyokoLegacy.World.Capabilities;


import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

import java.util.UUID;

@SuppressWarnings("MethodMayBeStatic")
public final class PlayerScannerComponent implements AutoSyncedComponent {


    private static final Object2ObjectMap<UUID,BlockPos> POS_HASH_MAP = new Object2ObjectOpenHashMap<>();




    public void savePosition(final PlayerEntity player) {
        POS_HASH_MAP.put(player.getUuid(),player.getBlockPos());
    }

    public void setPosition(final PlayerEntity player) {
        player.setPosition(POS_HASH_MAP.get(player.getUuid()).toCenterPos());
    }


    @Override
    public void readFromNbt(final @NotNull NbtCompound tag,final RegistryWrapper.WrapperLookup wrapperLookup) {
            tag.getKeys().forEach(key -> POS_HASH_MAP.put(UUID.fromString(key),BlockPos.fromLong(tag.getLong(key))));
    }

    @Override
    public void writeToNbt(final @NotNull NbtCompound tag,final RegistryWrapper.WrapperLookup wrapperLookup) {
        Object2ObjectMaps.fastForEach(POS_HASH_MAP,uuidBlockPosEntry -> tag.putLong(uuidBlockPosEntry.getKey().toString(),uuidBlockPosEntry.getValue().asLong()));
    }
}
