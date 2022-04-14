package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModContainerTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.TowerInterfaceTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public final class TowerInterfaceContainer extends AbstractContainerMenu {


    private @Nullable BlockEntity TE2;
    private Player inplayer;




    public TowerInterfaceContainer(int id, @NotNull BlockPos pos, Inventory playerInv, @NotNull Player player)
    {

        super(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(),id);
        inplayer = player;
        this.TE2 = player.getCommandSenderWorld().getBlockEntity(pos);

    }
    public TowerInterfaceContainer(final int windowid, final Inventory PInventory, final TowerInterfaceTileEntity TowerEntity) {
        super(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(), windowid);


    }
    public TowerInterfaceContainer(final int windowid, final @NotNull Inventory inven, final @NotNull FriendlyByteBuf data/*, TowerInterfaceTileEntity towerEntity*/) {
        this(windowid, inven, getTowerEntity(inven, data));
    }




    private static @NotNull TowerInterfaceTileEntity getTowerEntity(final @NotNull Inventory inventory, final @NotNull FriendlyByteBuf data) {
        Objects.requireNonNull(inventory, "player inventory can't be null");
        Objects.requireNonNull(data, "data can't be null");
        final BlockEntity tileAtPos = inventory.player.level.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof TowerInterfaceTileEntity) {
            return (TowerInterfaceTileEntity) tileAtPos;
        } else {
            throw new IllegalStateException("TileEntity isn't correct" + tileAtPos);
        }
    }


    @Override
    public boolean stillValid(@NotNull Player p_38874_) {
        return stillValid(ContainerLevelAccess.create(Objects.requireNonNull(TE2.getLevel()),TE2.getBlockPos()), inplayer, ModBlocks.TOWER_INTERFACE.get());
    }




}

