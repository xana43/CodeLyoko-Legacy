package com.Ultra_Nerd.CodeLyokoRemake15.Network.Util;

public class DataTransferInterfaceMessage {
    private int territory, xCoord, yCoord, zCoord;

    public DataTransferInterfaceMessage() {

    }

    public DataTransferInterfaceMessage(int territory, int xCoord, int yCoord, int zCoord) {
        this.territory = territory;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
    }
/*
    public static void encode(DataTransferInterfaceMessage msg, buffer) {

        buffer.writeVarIntArray(new int[]{msg.territory, msg.xCoord, msg.yCoord, msg.zCoord});
    }

    public static DataTransferInterfaceMessage decode(PacketBuffer buffer) {
        int[] array = buffer.readVarIntArray();
        if (array.length != 4)
            return new DataTransferInterfaceMessage(0, 0, 80, 0);
        return new DataTransferInterfaceMessage(array[0], array[1], array[2], array[3]);
    }

    public static void handle(DataTransferInterfaceMessage msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(
                () -> {
                    switch (msg.territory) {
                        case 0x101010: //CARTHAGE
                            Objects.requireNonNull(ctx.get().getSender()).changeDimension(DimensionType.registerBuiltin(ModDimensionTypes.DimensionTypeCarthage, ModDimensions.SECTOR_5.get(), null, true));
                            Objects.requireNonNull(ctx.get().getSender()).setPos(0, 130, 0);
                            break;
                        case 0x222222: //DESERT
                            Objects.requireNonNull(ctx.get().getSender()).changeDimension(DimensionManager.registerOrGetDimension(ModDimensionTypes.DimensionTypeDesert, ModDimensions.DESERT_DIMENSION.get(), null, true));
                            Objects.requireNonNull(ctx.get().getSender()).setPos(msg.xCoord, msg.yCoord, msg.zCoord);
                            break;
                        case 0x111111: //MOUNTAIN
                            Objects.requireNonNull(ctx.get().getSender()).changeDimension(DimensionManager.registerOrGetDimension(ModDimensionTypes.DimensionTypeMountain, ModDimensions.MOUNTAIN_DIMENSION.get(), null, true));
                            Objects.requireNonNull(ctx.get().getSender()).setPositionAndUpdate(msg.xCoord, msg.yCoord, msg.zCoord);
                            break;
                        case 0x333333: //FOREST
                            Objects.requireNonNull(ctx.get().getSender()).changeDimension(DimensionManager.registerOrGetDimension(ModDimensionTypes.DimensionTypeForest, ModDimensions.FOREST_DIMENSION.get(), null, true));
                            Objects.requireNonNull(ctx.get().getSender()).setPositionAndUpdate(msg.xCoord, msg.yCoord, msg.zCoord);
                            break;
                        case 0x444444: //ICE
                            Objects.requireNonNull(ctx.get().getSender()).changeDimension(DimensionManager.registerOrGetDimension(ModDimensionTypes.DimensionTypeIce, ModDimensions.ICE_DIMENSION.get(), null, true));
                            Objects.requireNonNull(ctx.get().getSender()).setPositionAndUpdate(msg.xCoord, msg.yCoord, msg.zCoord);
                            break;
                    }
                }
        );
        ctx.get().setPacketHandled(true);
    }

 */

}
