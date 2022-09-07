package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerControlPanelScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.ControlPanel;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public final class ComputerControlPanelTileEntity extends BlockEntity implements NamedScreenHandlerFactory {
    private boolean activebool;
    private final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int get(final int index) {
            return activebool ? 1 : 0;

        }

        @Override
        public void set(final int index, final int value) {
            activebool = value == 1;
        }

        @Override
        public int size() {
            return 1;
        }
    };

    public ComputerControlPanelTileEntity(final BlockPos pos, final BlockState state) {
        super(ModTileEntities.COMPUTER_CONTROL_PANEL, pos, state);

    }

    public static void setState(World world, BlockPos pos, BlockState state) {
        if (MinecraftClient.getInstance().player != null) {
            final ScreenHandler currentScreenHandler = MinecraftClient.getInstance().player.currentScreenHandler;
            if (currentScreenHandler != null) {
                if (currentScreenHandler instanceof ComputerControlPanelScreenHandler computerControlPanelScreenHandler) {
                    if (!world.isClient()) {
                        world.setBlockState(pos, state.with(ControlPanel.ScreenOn, computerControlPanelScreenHandler.getIsActive()));
                    }
                }
            }
        }
    }

    @Override
    public Text getDisplayName() {
        return Text.empty();
    }

    @Override
    public @NotNull BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    @Override
    public @NotNull ScreenHandler createMenu(final int syncId, final PlayerInventory inv, final PlayerEntity player) {
        return new ComputerControlPanelScreenHandler(syncId, propertyDelegate, ScreenHandlerContext.create(this.world, this.getPos()));
    }


}
