package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.containers.TowerInterfaceContainer;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TowerInterfaceTileEntity extends BlockEntity implements MenuProvider
 {

    // May be accessed before onLoad
    @OnlyIn(Dist.CLIENT)
    protected int PlayersPresent;

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

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int windowIn, @Nonnull Inventory playerInv, @Nonnull Player playerEntity) {
        return new TowerInterfaceContainer(windowIn, playerInv, this);
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


}