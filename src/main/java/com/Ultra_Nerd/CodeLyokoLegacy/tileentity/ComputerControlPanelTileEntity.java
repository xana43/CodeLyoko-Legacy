package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerControlPanelScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.ControlPanel;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicBoolean;

public final class ComputerControlPanelTileEntity extends BlockEntity implements ExtendedScreenHandlerFactory {
    public ComputerControlPanelTileEntity( final BlockPos pos, final BlockState state) {
        super(ModTileEntities.COMPUTER_CONTROL_PANEL, pos, state);

    }


public void setActivebool(boolean value)
{
    activebool = value;




    world.setBlockState(pos, world.getBlockState(pos).with(ControlPanel.ScreenOn, activebool));
    this.markDirty();



}

    private  boolean activebool;
    @Override
    public Text getDisplayName() {
        return LiteralTextContent.EMPTY;
    }
    public boolean getActive()
    {
        return activebool;
    }

    @Override
    public @NotNull Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public void markRemoved() {
        activebool = false;
        super.markRemoved();
    }

    @Override
    public void markDirty() {
        super.markDirty();

    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        nbt.putBoolean("computer_active",activebool);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        activebool = nbt.getBoolean("computer_active");
        super.readNbt(nbt);
    }

    @Override
    public @NotNull ScreenHandler createMenu(final int syncId, final PlayerInventory inv, final PlayerEntity player) {
        //LecternScreen


        return new ComputerControlPanelScreenHandler(syncId);
    }




    @Override
    public void writeScreenOpeningData(final ServerPlayerEntity player, final PacketByteBuf buf) {
        buf.writeBoolean(activebool);
    }
}
