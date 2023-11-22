package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Tower.TowerWall;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModDimensions;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ThreadUtil;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public record ScanForActiveXanaTowersC2SPacket() {


    public static void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {

        server.execute(() -> ThreadUtil.LARGE_TASK_THREAD_EXECUTOR.submit(()-> {
            final ServerWorld serverWorld = server.getWorld(ModDimensions.desertSectorWorld);
            for (int x = -90000; x < 90000; ++x) {
                assert serverWorld != null;
                for (int y = serverWorld.getHeight() >> 1; y > 0; --y) {
                    for (int z = -90000; z < 90000; ++z) {
                        CodeLyokoMain.LOG.error("scanning");
                        final BlockPos checkedPosition = new BlockPos(x, y, z);
                        if (serverWorld.getBlockState(checkedPosition).isOf(ModBlocks.TOWER_WALL) || serverWorld.getBlockState(checkedPosition).isOf(ModBlocks.TOWER_BASE) || serverWorld.getBlockState(checkedPosition).isOf(ModBlocks.TOWER_WALL_CORNER)
                                || serverWorld.getBlockState(checkedPosition).isOf(ModBlocks.TOWER_BASE_CORNER)) {
                            if (serverWorld.getBlockState(checkedPosition).get(TowerWall.CURRENT_ACTIVATION_STATE) == 1) {
                                CodeLyokoMain.LOG.error("found a xana activated tower");
                            }
                        }
                    }
                }
            }
            CodeLyokoMain.LOG.error("nothing found");
        }));
    }
}
