package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.blocks.DigitalSeaBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower.*;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;
import java.util.function.Supplier;

public record DataTransferInterfaceMessage(int territory, int xCoord, int yCoord, int zCoord) {


    public static void encode(@NotNull DataTransferInterfaceMessage msg, @NotNull FriendlyByteBuf buffer) {

        buffer.writeVarIntArray(new int[]{msg.territory, msg.xCoord, msg.yCoord, msg.zCoord});
    }

    public static @NotNull DataTransferInterfaceMessage decode(@NotNull FriendlyByteBuf buffer) {
        int[] array = buffer.readVarIntArray();
        if (array.length != 4)
            return new DataTransferInterfaceMessage(0, 0, 80, 0);
        return new DataTransferInterfaceMessage(array[0], array[1], array[2], array[3]);
    }

    private static boolean calculateSurface(@NotNull BlockPos posOperator, @NotNull ServerLevel worldToCheck) {

        return !(worldToCheck.getBlockState(posOperator.below()).getBlock() instanceof DigitalSeaBlock)
                && worldToCheck.getBlockState(posOperator.below()).getBlock() != Blocks.AIR
                && !(worldToCheck.getBlockState(posOperator.below()).getBlock() instanceof TowerBase)
                && !(worldToCheck.getBlockState(posOperator.below()).getBlock() instanceof TowerGeneric)
                && !(worldToCheck.getBlockState(posOperator.below()).getBlock() instanceof TowerWall)
                && !(worldToCheck.getBlockState(posOperator.below()).getBlock() instanceof TowerWallCorner)
                && !(worldToCheck.getBlockState(posOperator.below()).getBlock() instanceof TowerEnter)
                && !(worldToCheck.getBlockState(posOperator.below()).getBlock() instanceof TowerBottomBlock)
                && !(worldToCheck.getBlockState(posOperator.below()).getBlock() instanceof TowerBaseCorner)
                && !(worldToCheck.getBlockState(posOperator.below()).getBlock() == ModBlocks.FALSE_WATER.get())
                && worldToCheck.getBlockState(posOperator.above()).getBlock() == Blocks.AIR;
    }

    public static void handle(@NotNull DataTransferInterfaceMessage msg, @NotNull Supplier<NetworkEvent.Context> ctx) {


        final ServerPlayer sender = ctx.get().getSender();
        assert sender != null;

        final MinecraftServer MServer = sender.getServer();

        final ITeleporter surfaceterritorytop = new ITeleporter() {
            @Override
            public Entity placeEntity(Entity entity, ServerLevel currentWorld, @NotNull ServerLevel destWorld, float yaw, @NotNull Function<Boolean, Entity> repositionEntity) {
                entity = repositionEntity.apply(false);
                int surfacey = 0;
                int xoff = 0, zoff = 0;
                for (int i = destWorld.getHeight() >> 1; i > 0; i--) {
                    BlockPos checkForValidSurface = new BlockPos(msg.xCoord + xoff, i, msg.zCoord + zoff);

                    if (calculateSurface(checkForValidSurface, destWorld)) {
                        surfacey = i;
                        break;
                    } else {
                        xoff++;
                        zoff++;
                    }
                }

                entity.teleportTo(msg.xCoord + xoff, surfacey + 10, msg.zCoord + zoff);
                return entity;
            }

            @Override
            public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld) {
                return false;
            }

            @Override
            public boolean isVanilla() {
                return false;
            }
        };
        assert MServer != null;
        ctx.get().enqueueWork(
                () -> {
                    switch (msg.territory) {
                        case 0x101010: //CARTHAGE

                            sender.changeDimension(MServer.getLevel(ModDimensions.SECTOR5), new ITeleporter() {
                                @Override
                                public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, @NotNull Function<Boolean, Entity> repositionEntity) {
                                    entity = repositionEntity.apply(false);
                                    entity.teleportTo(0, 130, 0);
                                    return entity;
                                }

                                @Override
                                public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld) {
                                    return false;
                                }

                                @Override
                                public boolean isVanilla() {
                                    return false;
                                }
                            });

                            break;
                        case 0x222222: //DESERT
                            sender.changeDimension(MServer.getLevel(ModDimensions.DESERT), surfaceterritorytop);
                            break;
                        case 0x111111: //MOUNTAIN
                            sender.changeDimension(MServer.getLevel(ModDimensions.MOUNTAIN), surfaceterritorytop);
                            break;
                        case 0x333333: //FOREST
                            sender.changeDimension(MServer.getLevel(ModDimensions.FOREST), surfaceterritorytop);
                            break;
                        case 0x444444: //ICE
                            sender.changeDimension(MServer.getLevel(ModDimensions.ICE), surfaceterritorytop);
                            break;
                    }
                }
        );

        ctx.get().setPacketHandled(true);

    }


}
