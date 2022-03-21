package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModContainerTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ComputerInterfaceTE;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ComputerInterfaceContainer extends AbstractContainerMenu {
    public final ComputerInterfaceTE ComputerTE;
    private final IWorldPosCallable canInteractWithCallable;

    public ComputerInterfaceContainer(final int windowid, final PlayerInventory PInventory, final ComputerInterfaceTE computerTE) {
        super(ModContainerTypes.COMPUTER_INTERFACE_CONTAINER.get(), windowid);
        this.ComputerTE = computerTE;
        this.canInteractWithCallable = IWorldPosCallable.of(ComputerTE.getWorld(), ComputerTE.getPos());
    }

    public ComputerInterfaceContainer(final int windowid, final PlayerInventory inven, final PacketBuffer data) {
        this(windowid, inven, getIntrfaceEntity(inven, data));
    }

    private static ComputerInterfaceTE getIntrfaceEntity(final PlayerInventory inventory, final PacketBuffer data) {
        Objects.requireNonNull(inventory, "player inventory can't be null");
        Objects.requireNonNull(data, "data can't be null");
        final TileEntity tileAtPos = inventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof ComputerInterfaceTE) {
            return (ComputerInterfaceTE) tileAtPos;
        } else {
            throw new IllegalStateException("TileEntity isn't correct" + tileAtPos);
        }
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, ModBlocks.COMPUTER_KEYBOARD.get());
    }

    @Override
    public boolean stillValid(Player p_38874_) {
        return false;
    }
}
