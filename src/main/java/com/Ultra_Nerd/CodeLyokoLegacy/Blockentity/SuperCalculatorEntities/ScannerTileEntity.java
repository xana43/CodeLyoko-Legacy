package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Scanner;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModDimensions;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MultiBlock.BlockPatternRegistry;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.MultiBlockController;
import net.minecraft.block.BlockState;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public final class ScannerTileEntity extends MultiBlockController {

    private RegistryKey<World> destinationWorld = ModDimensions.carthage;
    private boolean inScanner;
    private int scanTimer = MethodUtil.TickConversion.secondsToTicks(9);

    public ScannerTileEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.SCANNER_TILE_ENTITY, pos, state, BlockPatternRegistry.SCANNER.getThisBlockPattern(),
                Scanner.SCANNER_PROPERTY);
        //destinationWorld = ModDimensions.carthage;
    }

    public void setDestinationWorld(final RegistryKey<World> destinationWorld) {
        this.destinationWorld = destinationWorld;
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
            final ServerWorld serverDestinationWorld = mcs.getWorld(this.destinationWorld);
            final ServerPlayerEntity player = (ServerPlayerEntity) serverWorld.getClosestPlayer(this.pos.getX(),
                    this.pos.getY(), this.pos.getZ(), 1, false);
            if (serverDestinationWorld != null && player != null) {
                //serverWorld.getProfiler().push("portal");
                if (scanTimer <= 0 && inScanner) {
                    if (this.destinationWorld == ModDimensions.carthage) {
                        player.teleport(serverDestinationWorld, 0, 140, 0, player.getYaw(), player.getPitch());
                    } else {
                        final BlockPos validPosition = MethodUtil.HelperMethods.getValidPosition(serverDestinationWorld, player.getHeight(), Direction.UP, player.getSafeFallDistance());
                        if (validPosition != null) {
                            player.teleport(serverDestinationWorld, validPosition.getX(), validPosition.getY(), validPosition.getZ(), player.getYaw(), player.getPitch());
                        }
                    }
                }
                //serverWorld.getProfiler().pop();
            }


        }
    }


}
