package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public record EntityPacketHandler() {


    public static Packet<?> create(Entity e, Identifier packetID) {
        if (e.world.isClient) {
            throw new IllegalStateException("can't be called on client");
        }
        final PacketByteBuf byteBuf = new PacketByteBuf(Unpooled.buffer());
        byteBuf.writeVarInt(Registries.ENTITY_TYPE.getRawId(e.getType()));
        byteBuf.writeUuid(e.getUuid());
        byteBuf.writeVarInt(e.getId());
        PacketBufUtil.writeVec3d(byteBuf, e.getPos());
        PacketBufUtil.writeAngle(byteBuf, e.getPitch());
        PacketBufUtil.writeAngle(byteBuf, e.getYaw());
        return ServerPlayNetworking.createS2CPacket(packetID, byteBuf);
    }

    public record PacketBufUtil() {

        /**
         * Packs a floating-point angle into a {@code byte}.
         *
         * @param angle angle
         * @return packed angle
         */
        public static byte packAngle(float angle) {
            return (byte) MathHelper.floor(angle * 256 / 360);
        }

        /**
         * Unpacks a floating-point angle from a {@code byte}.
         *
         * @param angleByte packed angle
         * @return angle
         */
        public static float unpackAngle(byte angleByte) {
            return (angleByte * 360) / 256f;
        }

        /**
         * Writes an angle to a {@link PacketByteBuf}.
         *
         * @param byteBuf destination buffer
         * @param angle   angle
         */
        public static void writeAngle(PacketByteBuf byteBuf, float angle) {
            byteBuf.writeByte(packAngle(angle));
        }

        /**
         * Reads an angle from a {@link PacketByteBuf}.
         *
         * @param byteBuf source buffer
         * @return angle
         */
        public static float readAngle(PacketByteBuf byteBuf) {
            return unpackAngle(byteBuf.readByte());
        }

        /**
         * Writes a {@link Vec3d} to a {@link PacketByteBuf}.
         *
         * @param byteBuf destination buffer
         * @param vec3d   vector
         */
        public static void writeVec3d(PacketByteBuf byteBuf, Vec3d vec3d) {
            byteBuf.writeDouble(vec3d.x);
            byteBuf.writeDouble(vec3d.y);
            byteBuf.writeDouble(vec3d.z);
        }

        /**
         * Reads a {@link Vec3d} from a {@link PacketByteBuf}.
         *
         * @param byteBuf source buffer
         * @return vector
         */
        public static Vec3d readVec3d(PacketByteBuf byteBuf) {
            double x = byteBuf.readDouble();
            double y = byteBuf.readDouble();
            double z = byteBuf.readDouble();
            return new Vec3d(x, y, z);
        }
    }

    /*
    private static final String NET_VERSION = "1";
    private static int nextId = 0;
    public static final SimpleChannelPool INSTANCE = new.newSimpleChannel(
            new ResourceLocation(CodeLyokoMain.MOD_ID, "network"),
            () -> NET_VERSION,
            NET_VERSION::equals,
            NET_VERSION::equals

    );

    public static void init() {
      INSTANCE.registerMessage(nextId++,DataTransferInterfaceMessage.class, DataTransferInterfaceMessage::encode,
                DataTransferInterfaceMessage::decode, DataTransferInterfaceMessage::handle);
      INSTANCE.registerMessage(nextId++,CustomControlServerHandler.class,CustomControlServerHandler::encapsulate,CustomControlServerHandler::make,CustomControlServerHandler.Handler::handle);
      INSTANCE.registerMessage(nextId++,ServerSaveHandler.class,ServerSaveHandler::encapsulate,ServerSaveHandler::make,ServerSaveHandler.SaveHandleer::saveServer);
      INSTANCE.registerMessage(nextId++, CapabilityPlayerClassSync.class, CapabilityPlayerClassSync::encapsulate, CapabilityPlayerClassSync::make, CapabilityPlayerClassSync.Handler::handle);
      INSTANCE.registerMessage(nextId++,ReturnToScanner.class,ReturnToScanner::encap,ReturnToScanner::make,ReturnToScanner.Handler::handle);

    }

     */


}
