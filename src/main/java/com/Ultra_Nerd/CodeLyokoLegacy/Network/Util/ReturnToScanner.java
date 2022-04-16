package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.ScannerTileEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.function.Function;
import java.util.function.Supplier;

public record ReturnToScanner(int x, int y, int z) {
    public static void materialize(Player player)
    {
        PacketHandler.INSTANCE.send(PacketDistributor.SERVER.with(() -> null),new ReturnToScanner(player.getBlockX(),player.getBlockY(),player.getBlockZ()));
    }
    public static void materialize(ScannerTileEntity scannerTileEntity)
    {
        PacketHandler.INSTANCE.send(PacketDistributor.SERVER.with(() -> null),new ReturnToScanner(scannerTileEntity.getBlockPos().getX(),scannerTileEntity.getBlockPos().above().getY(),scannerTileEntity.getBlockPos().getZ()));
    }

    public static ReturnToScanner make(FriendlyByteBuf buf)
    {
        final int[] ints = buf.readVarIntArray();
        return new ReturnToScanner(ints[0],ints[1],ints[2]);
    }

    public static void encap(ReturnToScanner returnToScanner,FriendlyByteBuf buf)
    {
        buf.writeVarIntArray(new int[]{returnToScanner.x, returnToScanner.y, returnToScanner.z});
    }


    public static final class Handler{
        public static void handle(final ReturnToScanner scanner, final Supplier<NetworkEvent.Context> ctx)
        {
            ctx.get().enqueueWork(()->{
                final ServerPlayer player = ctx.get().getSender();
                final MinecraftServer mserver = player.getServer();

            player.changeDimension(mserver.getLevel(Level.OVERWORLD), new ITeleporter() {
                @Override
                public Entity placeEntity(Entity entity, final ServerLevel currentWorld, final ServerLevel destWorld, final float yaw, final Function<Boolean, Entity> repositionEntity) {
                    entity = repositionEntity.apply(false);
                    entity.teleportTo(scanner.x,scanner.y,scanner.z);

                    return entity;
                }

                @Override
                public boolean playTeleportSound(final ServerPlayer player, final ServerLevel sourceWorld, final ServerLevel destWorld) {
                    return false;
                }
            });


            });
        }
    }

}
