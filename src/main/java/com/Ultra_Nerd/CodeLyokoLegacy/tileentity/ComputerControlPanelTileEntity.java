package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerControlPanelScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.ControlPanel;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.ComputerControlPanelUI;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerBlockEntityEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.client.gui.screen.ingame.LecternScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkData;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.server.network.ServerQueryNetworkHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.BlockEntityTickInvoker;
import org.apache.commons.lang3.BooleanUtils;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public final class ComputerControlPanelTileEntity extends BlockEntity implements NamedScreenHandlerFactory {
    public ComputerControlPanelTileEntity( final BlockPos pos, final BlockState state) {
        super(ModTileEntities.COMPUTER_CONTROL_PANEL, pos, state);

    }



private final PropertyDelegate propertyDelegate =  new PropertyDelegate() {
    @Override
    public int get(final int index) {

        //CodeLyokoMain.LOG.info("active = " + activebool);
        return ComputerControlPanelTileEntity.this.activebool? 1:0;


    }

    @Override
    public void set(final int index, final int value) {

if(index == 0) {
    activebool = value==1;
    markDirty();

}

    }
    @Override
    public int size() {
        return 1;
    }
};
public void setActivebool(boolean value)
{
    activebool = value;



    world.setBlockState(pos, world.getBlockState(pos).with(ControlPanel.ScreenOn, activebool));

    this.markDirty();



}


    private  boolean activebool;
    @Override
    public Text getDisplayName() {
        return LiteralText.EMPTY;
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

        CodeLyokoMain.LOG.info("construct menu");
        return new ComputerControlPanelScreenHandler(syncId, this.propertyDelegate);
    }



}
