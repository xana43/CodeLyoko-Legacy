package com.Ultra_Nerd.CodeLyokoRemake15.Network.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.blocks.tests.DataTransferInterface;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensionTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensions;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.network.NetworkEvent.Context;

import java.util.Objects;
import java.util.function.Supplier;

public class DataTransferInterfaceMessage {
    private int territory, xCoord, yCoord, zCoord;

    public DataTransferInterfaceMessage() {

    }

    public DataTransferInterfaceMessage(int territory, int xCoord, int yCoord, int zCoord) {
        this.territory = territory;
        this.xCoord = xCoord;
        this.yCoord=yCoord;
        this.zCoord=zCoord;
    }

    public void encode(DataTransferInterfaceMessage msg, PacketBuffer buffer) {
        buffer.writeVarIntArray(new int[]{territory, xCoord, yCoord, zCoord});
    }

    public DataTransferInterfaceMessage decode(PacketBuffer buffer) {
        int[] array = buffer.readVarIntArray();
        if(array.length!=4)
            return new DataTransferInterfaceMessage(0,0,80,0);
        return new DataTransferInterfaceMessage(array[0], array[1], array[2], array[3]);
    }

    public void handle(DataTransferInterfaceMessage msg, Supplier<Context> ctx) {
        ctx.get().enqueueWork(
                () -> {
                    switch (territory) {
                        case 0x101010: //CARTHAGE
                            Objects.requireNonNull(ctx.get().getSender()).changeDimension(DimensionManager.registerOrGetDimension(ModDimensionTypes.DimensionTypeCarthage, ModDimensions.SECTOR_5.get(), null, true));
                            Objects.requireNonNull(ctx.get().getSender()).setPositionAndUpdate(0,130,0);
                            break;
                        case 0x222222: //DESERT
                            Objects.requireNonNull(ctx.get().getSender()).changeDimension(DimensionManager.registerOrGetDimension(ModDimensionTypes.DimensionTypeDesert, ModDimensions.DESERT_DIMENSION.get(), null, true));
                            Objects.requireNonNull(ctx.get().getSender()).setPositionAndUpdate(xCoord, yCoord, zCoord);
                            break;
                        case 0x111111: //MOUNTAIN
                            Objects.requireNonNull(ctx.get().getSender()).changeDimension(DimensionManager.registerOrGetDimension(ModDimensionTypes.DimensionTypeMountain, ModDimensions.MOUNTAIN_DIMENSION.get(), null, true));
                            Objects.requireNonNull(ctx.get().getSender()).setPositionAndUpdate(xCoord, yCoord, zCoord);
                            break;
                        case 0x333333: //FOREST
                            Objects.requireNonNull(ctx.get().getSender()).changeDimension(DimensionManager.registerOrGetDimension(ModDimensionTypes.DimensionTypeForest, ModDimensions.FOREST_DIMENSION.get(), null, true));
                            Objects.requireNonNull(ctx.get().getSender()).setPositionAndUpdate(xCoord, yCoord, zCoord);
                            break;
                        case 0x444444: //ICE
                            Objects.requireNonNull(ctx.get().getSender()).changeDimension(DimensionManager.registerOrGetDimension(ModDimensionTypes.DimensionTypeIce, ModDimensions.ICE_DIMENSION.get(), null, true));
                            Objects.requireNonNull(ctx.get().getSender()).setPositionAndUpdate(xCoord, yCoord, zCoord);
                            break;
                    }
                }
        );
        ctx.get().setPacketHandled(true);
    }

}
