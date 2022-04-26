package com.Ultra_Nerd.CodeLyokoLegacy;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.DimensionCheck;
import io.github.ladysnake.locki.DefaultInventoryNodes;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.ServerMetadata;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
@Environment(EnvType.SERVER)
public class CodeLyokoServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        final String nbtcheck = "first_join";
        ServerTickEvents.START_WORLD_TICK.register(world -> world.getPlayers().forEach(serverPlayerEntity -> {
            CodeLyokoMain.LOG.info("server ");
            if(DimensionCheck.playerNotInVanillaWorld(serverPlayerEntity))
            {
                CodeLyokoMain.LYOKO_LOCK.lock(serverPlayerEntity,DefaultInventoryNodes.ARMOR);
            } else if (CodeLyokoMain.LYOKO_LOCK.isLocking(serverPlayerEntity,DefaultInventoryNodes.ARMOR)) {
                CodeLyokoMain.LYOKO_LOCK.unlock(serverPlayerEntity,DefaultInventoryNodes.ARMOR);
            }


        }));
    }
}
