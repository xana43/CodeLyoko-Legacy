package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.InventoryProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

public final class ComputerControlPanelTileEntity extends BlockEntity implements InventoryProvider {
    public ComputerControlPanelTileEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state) {
        super(type, pos, state);
    }

    @Override
    public SidedInventory getInventory(final BlockState state, final WorldAccess world, final BlockPos pos) {
        return null;
    }
/*
    // May be accessed before onLoad
    @OnlyIn(Dist.CLIENT)
    private int PlayersPresent;

    public ComputerControlPanelTileEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        super(ModTileEntities.COMPUTER_CONTROL_PANEL_TILE_ENTITY.get(),pos,state);
    }
/*
    public ComputerControlPanelTileEntity() {
        this(ModTileEntities.COMPUTER_CONTROL_PANEL_TILE_ENTITY.get());
    }*/

/*


    @Override
    public @NotNull AABB getRenderBoundingBox() {
        // This, combined with isGlobalRenderer in the TileEntityRenderer makes it so that the
        // render does not disappear if the player can't see the block
        // This is useful for rendering larger models or dynamically sized models
        return INFINITE_EXTENT_AABB;
    }


    @Override
    public void onDataPacket(Connection net, @NotNull ClientboundBlockEntityDataPacket pkt) {
        CompoundTag tag = pkt.getTag();
    }

    @Override
    public @NotNull CompoundTag getTileData() {
        return super.getTileData();
    }


    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        CompoundTag nbtTag = new CompoundTag();
        return super.getUpdatePacket();//new ClientGamePacketListener(getBlockPos(), -1, nbtTag);
    }




    /**
     * @return display name of the interface
     */
    /*
    @Nonnull
    @Override
    public Component getDisplayName() {
        return new TranslatableComponent(ModBlocks.COMPUTER_TOWER_CONTROL_PANEL.get().getName().toString());
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
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int windowIn, @Nonnull Inventory playerInv, @Nonnull Player playerEntity) {
        return new ComputerControlPanelContainer(windowIn, playerInv, this);
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


    @Override
    public SidedInventory getInventory(final BlockState state, final WorldAccess world, final BlockPos pos) {
        return null;
    }

     */
}
