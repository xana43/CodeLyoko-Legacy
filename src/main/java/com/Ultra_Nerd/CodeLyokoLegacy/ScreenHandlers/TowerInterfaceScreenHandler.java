package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ScreenHandler;

public final class TowerInterfaceScreenHandler extends ScreenHandler {

    public TowerInterfaceScreenHandler(final int syncId) {
        super(ModScreenHandlers.TOWER_INTERFACE_SCREEN_HANDLER, syncId);

    }

    @Override
    public boolean canUse(final PlayerEntity player) {
        return true;
    }
/*

    private @Nullable BlockEntity TE2;
    private Player inplayer;




    public TowerInterfaceScreenHandler(int id, @NotNull BlockPos pos, Inventory playerInv, @NotNull Player player)
    {

        super(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(),id);
        inplayer = player;
        this.TE2 = player.getCommandSenderWorld().getBlockEntity(pos);

    }
    public TowerInterfaceScreenHandler(final int windowid, final Inventory PInventory, final TowerInterfaceTileEntity TowerEntity) {
        super(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(), windowid);


    }
    public TowerInterfaceScreenHandler(final int windowid, final @NotNull Inventory inven, final @NotNull FriendlyByteBuf data/*, TowerInterfaceTileEntity towerEntity*///) //{
  /*      this(windowid, inven, getTowerEntity(inven, data));
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

   */




}

