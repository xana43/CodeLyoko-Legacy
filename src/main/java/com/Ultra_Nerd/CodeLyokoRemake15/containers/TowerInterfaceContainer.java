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
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Objects;

public class TowerInterfaceContainer extends AbstractContainerMenu {

    private TowerInterfaceTileEntity TowerEntity;
    private BlockEntity TE2;
    private Player inplayer;


    public TowerInterfaceContainer(@Nullable MenuType<?> Typpe, int id) {
        super(Typpe,id);

    }

    public TowerInterfaceContainer(int id, BlockPos pos,Inventory playerInv, Player player)
    {

        super(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(),id);
        inplayer = player;
        this.TE2 = player.getCommandSenderWorld().getBlockEntity(pos);

    }
    public TowerInterfaceContainer(final int windowid, final Inventory PInventory, final TowerInterfaceTileEntity TowerEntity) {
        super(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(), windowid);
        this.TowerEntity = TowerEntity;

    }
    public TowerInterfaceContainer(final int windowid, final Inventory inven, final FriendlyByteBuf data/*, TowerInterfaceTileEntity towerEntity*/) {
        this(windowid, inven, getTowerEntity(inven, data));
    }




    private static TowerInterfaceTileEntity getTowerEntity(final Inventory inventory, final FriendlyByteBuf data) {
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

