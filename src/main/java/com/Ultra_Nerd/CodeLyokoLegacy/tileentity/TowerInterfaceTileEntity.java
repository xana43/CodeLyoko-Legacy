package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TowerInterfaceScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower.TowerInterface;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower.TowerWall;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TowerInterfaceTileEntity extends BlockEntity implements NamedScreenHandlerFactory, ExtendedScreenHandlerFactory {
    public TowerInterfaceTileEntity(final BlockPos pos, final BlockState state) {
        super(ModTileEntities.TOWER_INTERFACE_TILE_ENTITY, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return Text.empty();
    }

    @Override
    public @NotNull ScreenHandler createMenu(final int syncId, final PlayerInventory inv, final PlayerEntity player) {
        return new TowerInterfaceScreenHandler(syncId,player);
    }
    public void calculateTowerActivation(final int stateToChangeTo)
    {
        if(world.getBlockState(pos).get(TowerInterface.IS_GENERATED))
        {
            checkTowerState(stateToChangeTo);

        }
    }
private int controlState = 0;
    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }


    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }



    private void checkTowerState(final int newState)
    {
       final BlockPos topBlockPosition = pos.offset(Direction.UP,11).offset(Direction.SOUTH,10).offset(Direction.WEST
               ,8);
       for(int x = 0; x < 17; ++x)
       {
           for (int y = 0; y < 42; ++y)
           {
               for (int z = 0; z < 17; ++z)
               {
                   final BlockPos checkedPosition = topBlockPosition.add(x,-y,-z);
                    if(world.getBlockState(checkedPosition).isOf(ModBlocks.TOWER_WALL) ||world.getBlockState(checkedPosition).isOf(ModBlocks.TOWER_BASE)||
                            world.getBlockState(checkedPosition).isOf(ModBlocks.TOWER_BASE_CORNER)
                        ||world.getBlockState(checkedPosition).isOf(ModBlocks.TOWER_WALL_CORNER)
                    )
                    {
                        if(world.getBlockState(checkedPosition).get(TowerWall.CURRENT_ACTIVATION_STATE) != null)
                        {
                            controlState = newState;
                            world.setBlockState(checkedPosition,
                                    world.getBlockState(checkedPosition).with(TowerWall.CURRENT_ACTIVATION_STATE,newState));
                        }
                    }
               }
           }
       }
    }
    private static final String stateKey = "controlled_state";
    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt(stateKey,controlState);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        controlState = nbt.getInt(stateKey);
    }

    @Override
    public void writeScreenOpeningData(final ServerPlayerEntity player, final PacketByteBuf buf) {
        buf.writeBlockPos(pos);
    }
}
