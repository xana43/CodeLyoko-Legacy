package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TowerInterfaceScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TowerInterfaceTileEntity extends BlockEntity implements NamedScreenHandlerFactory
 {
     public TowerInterfaceTileEntity(final BlockPos pos, final BlockState state) {
         super(ModTileEntities.LYOKO_CORE, pos, state);
     }

     @Override
     public Text getDisplayName() {
         return LiteralText.EMPTY;
     }

     @Override
     public @NotNull ScreenHandler createMenu(final int syncId, final PlayerInventory inv, final PlayerEntity player) {
         return new TowerInterfaceScreenHandler(syncId, null);
     }
/*
    // May be accessed before onLoad
    @OnlyIn(Dist.CLIENT)
    private int PlayersPresent;

    public TowerInterfaceTileEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        super(ModTileEntities.TOWER_INTERFACE_TILE_ENTITY.get(), pos,state);
    }











    @Override
    public void onDataPacket(Connection net, @NotNull ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
        CompoundTag tag = pkt.getTag();
    }




    /**
     * @return display name of the interface
     */

/*
    @Nonnull
    @Override
    public Component getDisplayName() {
        return new TranslatableComponent(ModBlocks.TOWER_INTERFACE.get().getName().toString());
    }

    /**
     * Create a containder from interfaceTileEntity
     *
     * @param windowIn     Id of GUI
     * @param playerInv    Inventory of interacting player
     * @param playerEntity PlayerEntity of interacting player
     * @return Gui container
     */
/*
    @Override
    public @NotNull AbstractContainerMenu createMenu(int windowIn, @Nonnull Inventory playerInv, @Nonnull Player playerEntity) {
        return new TowerInterfaceScreenHandler(windowIn, playerInv, this);
    }




    @Override
    public boolean triggerEvent(int id, int type) {
        if (id == 1) {
            this.PlayersPresent = type;
            return true;
        } else {
            return super.triggerEvent(id, type);
        }
    }

 */


}
