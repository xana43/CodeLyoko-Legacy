package com.Ultra_Nerd.CodeLyokoLegacy.containers;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public final class HologramContainer extends AbstractContainerMenu implements Container {
    protected HologramContainer(@Nullable MenuType<?> p_38851_, int p_38852_) {
        super(p_38851_, p_38852_);
    }

    @Override
    public int getContainerSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public @Nullable ItemStack getItem(int p_18941_) {
        return null;
    }

    @Override
    public @Nullable ItemStack removeItem(int p_18942_, int p_18943_) {
        return null;
    }

    @Override
    public @Nullable ItemStack removeItemNoUpdate(int p_18951_) {
        return null;
    }

    @Override
    public void setItem(int p_18944_, ItemStack p_18945_) {

    }

    @Override
    public void setChanged() {

    }

    @Override
    public void clearContent() {

    }

    @Override
    public boolean stillValid(Player p_38874_) {
        return false;
    }
    /*
    private final IWorldPosCallable canInteractWithCallable;
    private final BlockEntityCapabilit te;

    public HologramContainer(int windowid, Inventory inventory, HologramProjectorTileEntity te) {
        super(ModContainerTypes.HOLOGRAM_CONTAINER.get(), windowid);
        this.te = te;
        this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());
    }

    public HologramContainer(final int windowId, final Inventory playerInventory, final FriendlyByteBuf data) {
        this(windowId, playerInventory, getHoloEntity(playerInventory, data));
    }

    private static HologramProjectorTileEntity getHoloEntity(final Inventory inventory, final FriendlyByteBuf data) {
        Objects.requireNonNull(inventory, "player inventory can't be null");
        Objects.requireNonNull(data, "data can't be null");
        final BlockEntityCapabilit tileAtPos = inventory.player.level.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof HologramProjectorTileEntity) {
            return (HologramProjectorTileEntity) tileAtPos;
        } else {
            throw new IllegalStateException("TileEntity isn't correct" + tileAtPos);
        }
    }

    @Override
    public boolean stillValid(@Nonnull Player playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, ModBlocks.HOLOPROJECTOR.get());
    }*/

}
