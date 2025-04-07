package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperComputerNetwork;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.CableNetworkConnectedBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.SuperCalculatorNetwork.CableBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.SuperCalculatorNetwork.DemarcationScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.IdBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.RenameableBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.SyncedBlockEntity;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;

public final class DemarcationBlockEntity extends SyncedBlockEntity implements CableNetworkConnectedBlockEntity, ExtendedScreenHandlerFactory, RenameableBlockEntity, IdBlockEntity {
    private int uid;
    private boolean connected;
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
    private static final String UID_KEY = "uid",NAME_KEY = "name",connectedPositionKey = "connected_position",isConnectedKey = "is_connected";
    @Override
    protected void writeNbt(final NbtCompound nbt,final RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt,registryLookup);
        nbt.putInt(UID_KEY,uid);
        nbt.putString(NAME_KEY,name);
        nbt.putLong(connectedPositionKey,connectedPosition.asLong());
        nbt.putBoolean(isConnectedKey,connected);
    }

    @Override
    public void readNbt(final NbtCompound nbt,final RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt,registryLookup);
        uid = nbt.getInt(UID_KEY);
        name = nbt.getString(NAME_KEY);
        connected = nbt.getBoolean(isConnectedKey);
        connectedPosition = BlockPos.fromLong(nbt.getLong(connectedPositionKey));
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("demarcation.name",name);
    }

    @Override
    public @NotNull ScreenHandler createMenu(final int syncId, final PlayerInventory playerInventory, final PlayerEntity player) {
        return new DemarcationScreenHandler(syncId,idDelegate);
    }

   /* @Override
    public void writeScreenOpeningData(final ServerPlayerEntity player, final PacketByteBuf buf) {
        buf.writeBlockPos(pos);
    }*/

    @Override
    public Object getScreenOpeningData(ServerPlayerEntity player) {
        return null;
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    public BlockPos getConnectedPos() {
        return connectedPosition;
    }
    private BlockPos connectedPosition = BlockPos.ORIGIN;
    @Override
    public void tryConnect() {
        assert world != null;
        if(world.isClient){
            return;
        }
        for(final Direction direction : Direction.values() ) {
            if(world.getBlockState(pos.offset(direction)).getBlock() instanceof CableBlock){
                connectedPosition = pos.offset(direction);
                return;
            }
        }
        connected = !connectedPosition.equals(BlockPos.ORIGIN);
    }

    @Override
    public void tryDisconnect() {

    }
}
