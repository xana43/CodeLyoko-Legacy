package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Scanner;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MultiBlock.BlockPatternRegistry;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.MultiBlockController;
import net.minecraft.block.BlockState;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ScannerTileEntity extends MultiBlockController {

    private RegistryKey<World> destinationWorld = ModDimensions.carthage;
    private int scanTimer = MethodUtil.TickConversion.secondsToTicks(9);

    private boolean inScanner;

    public void setDestinationWorld(final RegistryKey<World> destinationWorld) {
        this.destinationWorld = destinationWorld;
    }

    public ScannerTileEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.SCANNER_TILE_ENTITY, pos, state, BlockPatternRegistry.SCANNER.getThisBlockPattern(),
                Scanner.SCANNER_PROPERTY);
        //destinationWorld = ModDimensions.carthage;
    }

    public boolean isInScanner() {
        return inScanner;
    }

    @Override
    public void tick() {
        super.tick();
        inScanner = this.world.getClosestPlayer(this.pos.getX(), this.pos.getY(), this.pos.getZ(), 1, false) != null;
        if (inScanner) {
            scanTimer--;
            virtualizePlayer();

        } else {
            scanTimer = MethodUtil.TickConversion.secondsToTicks(9);
        }
    }

    public void virtualizePlayer() {
        if (this.world instanceof final ServerWorld serverWorld) {
            final MinecraftServer mcs = serverWorld.getServer();
            final ServerWorld serverWorld1 = mcs.getWorld(destinationWorld);
            final ServerPlayerEntity player = (ServerPlayerEntity) serverWorld.getClosestPlayer(this.pos.getX(),
                    this.pos.getY(), this.pos.getZ(), 1, false);
            if (serverWorld1 != null && player != null) {
                serverWorld.getProfiler().push("portal");
                if (scanTimer <= 0 && inScanner) {
                    player.teleport(serverWorld1, 0, 140, 0, player.getYaw(), player.getPitch());
                }
                serverWorld.getProfiler().pop();
            }


        }
    }


}
