package com.Ultra_Nerd.CodeLyokoRemake15.Network.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensions;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.network.NetworkEvent;

import java.util.Objects;
import java.util.function.Supplier;

public class DataTransferInterfaceMessage {
    private int territory, xCoord, yCoord, zCoord;



    public DataTransferInterfaceMessage(int territory, int xCoord, int yCoord, int zCoord) {
        this.territory = territory;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
    }

    public static void encode(DataTransferInterfaceMessage msg, FriendlyByteBuf buffer) {

        buffer.writeVarIntArray(new int[]{msg.territory, msg.xCoord, msg.yCoord, msg.zCoord});
    }

    public static DataTransferInterfaceMessage decode(FriendlyByteBuf buffer) {
        int[] array = buffer.readVarIntArray();
        if (array.length != 4)
            return new DataTransferInterfaceMessage(0, 0, 80, 0);
        return new DataTransferInterfaceMessage(array[0], array[1], array[2], array[3]);
    }

    public static void handle(DataTransferInterfaceMessage msg, Supplier<NetworkEvent.Context> ctx) {
        if(RegistryAccess.BUILTIN.get().registry(Registry.DIMENSION_REGISTRY).isPresent()) {
            ctx.get().enqueueWork(
                    () -> {
                        switch (msg.territory) {
                            case 0x101010: //CARTHAGE
                                CodeLyokoMain.Log.debug("should be sent to sector 5");
                                (ctx.get().getSender()).changeDimension((ServerLevel) RegistryAccess.BUILTIN.get().registry(Registry.DIMENSION_REGISTRY).get().get(ModDimensions.SECTOR5));
                                (ctx.get().getSender()).setPos(0, 130, 0);
                                break;
                            case 0x222222: //DESERT
                                Objects.requireNonNull(ctx.get().getSender()).changeDimension((ServerLevel) Objects.requireNonNull(RegistryAccess.BUILTIN.get().registry(Registry.DIMENSION_REGISTRY).get().get(ModDimensions.DESERT)));
                                Objects.requireNonNull(ctx.get().getSender()).setPos(msg.xCoord, msg.yCoord, msg.zCoord);
                                break;
                            case 0x111111: //MOUNTAIN
                                Objects.requireNonNull(ctx.get().getSender()).changeDimension((ServerLevel) Objects.requireNonNull(RegistryAccess.BUILTIN.get().registry(Registry.DIMENSION_REGISTRY).get().get(ModDimensions.MOUNTAIN)));
                                Objects.requireNonNull(ctx.get().getSender()).setPos(msg.xCoord, msg.yCoord, msg.zCoord);
                                break;
                            case 0x333333: //FOREST
                                Objects.requireNonNull(ctx.get().getSender()).changeDimension((ServerLevel) Objects.requireNonNull(RegistryAccess.BUILTIN.get().registry(Registry.DIMENSION_REGISTRY).get().get(ModDimensions.FOREST)));
                                Objects.requireNonNull(ctx.get().getSender()).setPos(msg.xCoord, msg.yCoord, msg.zCoord);
                                break;
                            case 0x444444: //ICE
                                Objects.requireNonNull(ctx.get().getSender()).changeDimension((ServerLevel) Objects.requireNonNull(RegistryAccess.BUILTIN.get().registry(Registry.DIMENSION_REGISTRY).get().get(ModDimensions.ICE)));
                                Objects.requireNonNull(ctx.get().getSender()).setPos(msg.xCoord, msg.yCoord, msg.zCoord);
                                break;
                        }
                    }
            );
        }
        ctx.get().setPacketHandled(true);
    }



}
