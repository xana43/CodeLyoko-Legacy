package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.SuperCalculatorEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerCirculatorScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.NBT.NBTEntries;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.TickingBlockEntity;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.FilteringStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;

import static com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil.FluidStorageCreation.createFluidStorage;

public final class ComputerCirculatorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory,
        ExtendedScreenHandlerFactory,TickingBlockEntity {



    private final long[] cardinalFlowSpeeds = new long[]{1,1,1,1,1,1};
    private final boolean[] flowDirections = new boolean[]{false,false,true,false,false,true};
    public final SingleVariantStorage<FluidVariant> fluidStorage = createFluidStorage(this,Fluids.WATER);
    public final Storage<FluidVariant> waterIntake = FilteringStorage.insertOnlyOf(fluidStorage);

    public ComputerCirculatorBlockEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.COMPUTER_CIRCULATOR_BLOCK_ENTITY_TYPE, pos, state);
    }

    @Override
    public @NotNull Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }
    private void calculateFlow()
    {
        int index = 0;
        for(final Direction dir : Direction.values())
        {
            assert world != null;
            if(world.getBlockEntity(pos.offset(dir)) instanceof final CirculatorPipeBlockEntity circulatorPipeBlock) {
                if (flowDirections[index]) {
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
        for (int i = 0; i < 6;i++)
        {
            nbt.putLong("flow_speed"+i,cardinalFlowSpeeds[i]);
            nbt.putBoolean("flow_allowance"+i,flowDirections[i]);
        }

    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        fluidStorage.variant = FluidVariant.fromNbt(nbt.getCompound("fluid_type"));
        fluidStorage.amount = nbt.getLong("amount");
        for(int i = 0; i < 6; i++)
        {
            cardinalFlowSpeeds[i] = nbt.getLong("flow_speed"+i);
            flowDirections[i] = nbt.getBoolean("flow_allowance"+i);
        }
    }

    @Override
    public void writeScreenOpeningData(final ServerPlayerEntity player, final PacketByteBuf buf) {
        buf.writeBlockPos(pos);
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
