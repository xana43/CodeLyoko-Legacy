package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerCirculatorScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.ComputerFluidPipe;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
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

public final class ComputerCirculatorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory,
        ExtendedScreenHandlerFactory {


    private float fluidHeld;
    private final float[] cardinalFlowSpeeds = new float[]{0.1f,0.1f,0.1f,0.1f,0.1f,0.1f};
    private final boolean[] flowDirections = new boolean[]{false,false,true,false,false,true};

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
            final Block checkedBlock = world.getBlockState(pos.offset(dir)).getBlock();
            if(checkedBlock == ModBlocks.COMPUTER_LIQUID_PIPE)
            {
                if(flowDirections[index]) {
                    world.setBlockState(pos.offset(dir),
                            checkedBlock.getDefaultState().with(ComputerFluidPipe.STORED_FLUID,
                                    checkedBlock.getDefaultState().get(ComputerFluidPipe.STORED_FLUID)+ cardinalFlowSpeeds[index]));
                }  else {
                world.setBlockState(pos.offset(dir),
                        checkedBlock.getDefaultState().with(ComputerFluidPipe.STORED_FLUID,
                                checkedBlock.getDefaultState().get(ComputerFluidPipe.STORED_FLUID) - cardinalFlowSpeeds[index]));
                fluidHeld += cardinalFlowSpeeds[index];
                }
            }
            index++;
        }
    }

    public float getFluidHeld()
    {
        return fluidHeld;
    }
    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putFloat("held_fluid",fluidHeld);
        for (int i = 0; i < 6;i++)
        {
            nbt.putFloat("flow_speed"+i,cardinalFlowSpeeds[i]);
            nbt.putBoolean("flow_allowance"+i,flowDirections[i]);
        }

    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        fluidHeld = nbt.getFloat("held_fluid");
        for(int i = 0; i < 6; i++)
        {
            cardinalFlowSpeeds[i] = nbt.getFloat("flow_speed"+i);
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
}
