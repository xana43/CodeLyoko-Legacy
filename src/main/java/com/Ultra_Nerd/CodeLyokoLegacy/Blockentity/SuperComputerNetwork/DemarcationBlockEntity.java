package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperComputerNetwork;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.SuperCalculatorNetwork.DemarcationScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.SuperCalculator.DataPacketType;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.IdBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.RenameableBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.SyncedBlockEntity;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public final class DemarcationBlockEntity extends SyncedBlockEntity implements ExtendedScreenHandlerFactory, RenameableBlockEntity, IdBlockEntity {
    private int uid;
    private final PropertyDelegate idDelegate = new PropertyDelegate() {
        @Override
        public int get(final int index) {
            return uid;
        }

        @Override
        public void set(final int index, final int value) {
            uid = value;
        }

        @Override
        public int size() {
            return 1;
        }
    };
    private String name = "default";
    public DemarcationBlockEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.DEMARCATION_BLOCK_ENTITY_TYPE, pos, state);
    }
    @Override
    public void rename(final String name)
    {
        this.name = name;
        update();
    }

    @Override
    public void setId(final int id) {
        this.uid = id;
    }

    public int getId() {
        return uid;
    }

    public <T> void testDataReceive(final DataPacketType<T> dataPacket)
    {
       CodeLyokoMain.LOG.error(String.valueOf(dataPacket.getEncapsulatedData().get(0)));
    }
    private static final String UID_KEY = "uid",NAME_KEY = "name";
    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt(UID_KEY,uid);
        nbt.putString(NAME_KEY,name);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        uid = nbt.getInt(UID_KEY);
        name = nbt.getString(NAME_KEY);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("demarcation.name",name);
    }

    @Override
    public @NotNull ScreenHandler createMenu(final int syncId, final PlayerInventory playerInventory, final PlayerEntity player) {
        return new DemarcationScreenHandler(syncId,idDelegate);
    }

    @Override
    public void writeScreenOpeningData(final ServerPlayerEntity player, final PacketByteBuf buf) {
        buf.writeBlockPos(pos);
    }
}
