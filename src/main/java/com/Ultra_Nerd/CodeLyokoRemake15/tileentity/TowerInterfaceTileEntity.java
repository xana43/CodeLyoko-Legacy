package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.containers.TowerInterfaceContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.client.gui.components.events.ContainerEventHandler;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ContainerListener;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TowerInterfaceTileEntity extends BlockEntity {

    // May be accessed before onLoad
    @OnlyIn(Dist.CLIENT)
    protected int PlayersPresent;

    public TowerInterfaceTileEntity(BlockEntityType<?> tileEntityTypeIn, BlockPos pos, BlockState state) {
        super(tileEntityTypeIn,pos,state);
    }

    public TowerInterfaceTileEntity() {
        this(ModTileEntities.TOWER_INTERFACE_TILE_ENTITY.get());
    }


    @Override
    public AABB getRenderBoundingBox() {
        // This, combined with isGlobalRenderer in the TileEntityRenderer makes it so that the
        // render does not disappear if the player can't see the block
        // This is useful for rendering larger models or dynamically sized models
        return INFINITE_EXTENT_AABB;
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        CompoundTag nbtTag = new CompoundTag();
        //Write your data into the nbtTag
        return new ClientboundBlockEntityDataPacket(getBlockPos()Pos(), -1, nbtTag);
    }


    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
        CompoundTag tag = pkt.getTag();
    }




    /**
     * @return display name of the interface
     */


    @Nonnull
    @Override
    public TextComponent getDisplayName() {
        return new TranslationTextComponent(ModBlocks.TOWER_INTERFACE.get().getTranslationKey());
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
    public Container createMenu(int windowIn, @Nonnull Inventory playerInv, @Nonnull PlayerEntity playerEntity) {
        return new TowerInterfaceContainer(windowIn, playerInv, this);
    }


    @Override
    public boolean receiveClientEvent(int id, int type) {
        if (id == 1) {
            this.PlayersPresent = type;
            return true;
        } else {
            return super.receiveClientEvent(id, type);
        }
    }


}
