package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerCirculatorScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.NBT.NBTEntries;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.SyncedBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.TickingBlockEntity;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.FilteringStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;

import static com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil.FluidStorageCreation.createFluidStorage;

public final class ComputerCirculatorBlockEntity extends SyncedBlockEntity implements NamedScreenHandlerFactory,
        ExtendedScreenHandlerFactory,TickingBlockEntity {



    private long[] cardinalFlowSpeeds = new long[]{1,1,1,1,1,1};
    private byte[] flowDirections = new byte[]{0,0,1,0,0,1};
    private final SingleVariantStorage<FluidVariant> fluidStorage = createFluidStorage(this,Fluids.WATER);
    public final Storage<FluidVariant> waterIntake = FilteringStorage.insertOnlyOf(fluidStorage);
    public final Storage<FluidVariant> waterDistibution = FilteringStorage.extractOnlyOf(fluidStorage);
    public ComputerCirculatorBlockEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.COMPUTER_CIRCULATOR_BLOCK_ENTITY_TYPE, pos, state);
    }


    public long getInternalFluidTankAmount()
    {
        return fluidStorage.amount;
    }

    private void calculateFlow()
    {
        int index = 0;
        for(final Direction dir : Direction.values())
        {
            assert world != null;
            if(world.getBlockEntity(pos.offset(dir)) instanceof final CirculatorPipeBlockEntity circulatorPipeBlock) {
                if (flowDirections[index] == 1) {
                            try(final Transaction transaction = Transaction.openOuter())
                            {
                                if(fluidStorage.extract(FluidVariant.of(Fluids.WATER), cardinalFlowSpeeds[index],
                                        transaction) == cardinalFlowSpeeds[index] && circulatorPipeBlock.getInput().insert(FluidVariant.of(Fluids.WATER,
                                                NBTEntries.chilled),
                                        cardinalFlowSpeeds[index],transaction) == cardinalFlowSpeeds[index])
                                {
                                    transaction.commit();
                                }
                            }
                }
            }

            index++;
        }
    }


    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.put("fluid_type",fluidStorage.variant.toNbt());
        nbt.putLong("amount",fluidStorage.amount);
        nbt.putByteArray("flow_allowance",flowDirections);
        nbt.putLongArray("flow_speed",cardinalFlowSpeeds);

    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        fluidStorage.variant = FluidVariant.fromNbt(nbt.getCompound("fluid_type"));
        fluidStorage.amount = nbt.getLong("amount");
        cardinalFlowSpeeds = nbt.getLongArray("flow_speed");
        flowDirections = nbt.getByteArray("flow_allowance");
    }

    @Override
    public void writeScreenOpeningData(final ServerPlayerEntity player, final PacketByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeByteArray(flowDirections);
        buf.writeLongArray(cardinalFlowSpeeds);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(CodeLyokoMain.codeLyokoPrefix("computer.circulator").toString());
    }

    @Override
    public @NotNull ScreenHandler createMenu(final int syncId, final PlayerInventory playerInventory, final PlayerEntity player) {
        return new ComputerCirculatorScreenHandler(syncId,player);
    }

    @Override
    public void tick() {

    }
}
