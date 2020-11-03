package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModContainerTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensionTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.test.DataTransferInterfaceTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nonnull;
import java.util.Objects;

public class DataTransferInterfaceContainer extends Container implements ITeleporter {
    private final DataTransferInterfaceTileEntity dataTransferInterfaceTileEntity;
    private final IWorldPosCallable canInteractWithCallable;
    private final PlayerEntity playerEntity;

    public DataTransferInterfaceContainer(final int windowid, final PlayerInventory PInventory, final DataTransferInterfaceTileEntity dataTransferInterfaceTileEntity) {
        super(ModContainerTypes.DATA_TRANSFER_INTERFACE_CONTAINER.get(), windowid);
        this.dataTransferInterfaceTileEntity = dataTransferInterfaceTileEntity;
        this.playerEntity = PInventory.player;
        this.canInteractWithCallable = IWorldPosCallable.of(dataTransferInterfaceTileEntity.getWorld(), dataTransferInterfaceTileEntity.getPos());
    }

    public DataTransferInterfaceContainer(final int windowid, final PlayerInventory inven, final PacketBuffer data) {
        this(windowid, inven, getBlockTE(inven, data));
    }

    private static DataTransferInterfaceTileEntity getBlockTE(final PlayerInventory inventory, final PacketBuffer data) {
        Objects.requireNonNull(inventory, "player inventory can't be null");
        Objects.requireNonNull(data, "data can't be null");
        final TileEntity tileAtPos = inventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof DataTransferInterfaceTileEntity) {
            return (DataTransferInterfaceTileEntity) tileAtPos;
        } else {
            throw new IllegalStateException("TileEntity isn't correct" + tileAtPos);
        }
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, ModBlocks.DATA_TRANSFER_INTERFACE.get());
    }

    public DataTransferInterfaceTileEntity getDataTransferInterfaceTileEntity() {
        return dataTransferInterfaceTileEntity;
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    public void teleportPlayer() {
        ((ServerPlayerEntity) this.playerEntity).changeDimension(DimensionManager.registerOrGetDimension(ModDimensionTypes.DimensionTypeCarthage, ModDimensions.SECTOR_5.get(), null, true), this);
        this.playerEntity.setPositionAndUpdate(0, 130, 0);
    }
}
