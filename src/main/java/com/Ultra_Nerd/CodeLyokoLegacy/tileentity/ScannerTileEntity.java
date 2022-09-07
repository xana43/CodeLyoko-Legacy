package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock.BlockPatternRegistry;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock.MasterEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Scanner;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.ScannerFrame;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.ScannerTop;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModStats;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public final class ScannerTileEntity extends BlockEntity implements MasterEntity {

    public RegistryKey<World> destinationWorld = ModDimensions.carthage;
    private int scanTimer = MethodUtil.TickConversion.secondsToTicks(9);
    private boolean inScanner;

    public ScannerTileEntity(final BlockPos pos, final BlockState state) {
        super(ModTileEntities.SCANNER_TILE_ENTITY, pos, state);
        //destinationWorld = ModDimensions.carthage;
    }

    public boolean isInScanner() {
        return inScanner;
    }

    @Override
    public void tick() {
        MasterEntity.super.tick();
        inScanner = this.world.getClosestPlayer(this.pos.getX(), this.pos.getY(), this.pos.getZ(), 1, false) != null;
        if (inScanner) {
            scanTimer--;
            virtualizePlayer();

        } else {
            scanTimer = MethodUtil.TickConversion.secondsToTicks(9);
        }
    }

    public void virtualizePlayer() {
        if (this.world instanceof ServerWorld serverWorld) {

            final MinecraftServer mcs = serverWorld.getServer();
            final ServerWorld serverWorld1 = mcs.getWorld(destinationWorld);
            final ServerPlayerEntity player = (ServerPlayerEntity) serverWorld.getClosestPlayer(this.pos.getX(), this.pos.getY(), this.pos.getZ(), 1, false);

            if (serverWorld1 != null && player != null) {
                serverWorld.getProfiler().push("portal");
                if (scanTimer <= 0 && inScanner) {


                    player.incrementStat(ModStats.ENTERED_LYOKO_IDENTIFIER);
                    player.teleport(serverWorld1, 0, 140, 0, player.getYaw(), player.getPitch());
                    //player.moveToWorld(serverWorld1);
                    //player.teleport(0,130,0);

                }
                serverWorld.getProfiler().pop();
            }


        }
    }


    /*
    public ScannerTileEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        super(ModTileEntities.SCANNER_TILE_ENTITY.get(), pos, state);




    }

     */


    // public void invalidateStruct()
    // {
    //   deactivateStructure();
    // }

    @Override
    public void check() {
        //scannerpattern.matches(this.level,this.worldPosition,this.level.getBlockState(this.worldPosition).getValue(Scanner.directionProperty), Direction.UP);
        if (world != null) {
            //String.valueOf(BlockPatternRegistry.matches(BlockPatternRegistry.scanner,this.level,this.worldPosition,this.level.getBlockState(this.worldPosition).getValue(Scanner.directionProperty),Direction.DOWN))
            //CodeLyokoMain.Log.info(String.valueOf(BlockPatternRegistry.scanner.find(level,worldPosition)));
            final BlockPattern.Result match = BlockPatternRegistry.SCANNER.getThisBlockPatttern().searchAround(world, pos);


            if (match != null) {

                //CodeLyokoMain.Log.info("pattern matched");
                final BlockPos frame = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
                final BlockPos top = new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ());
                world.setBlockState(frame, world.getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, true));
                world.setBlockState(top, world.getBlockState(top).with(ScannerTop.scannerFormedTop, true));
                world.setBlockState(pos, world.getBlockState(pos).with(Scanner.Scanner, true));
            } else {

                invalidateEntity();
            }
        }
        /*if (checkStructure()) {
            activateStructure();

        } else if (!checkStructure()) {
            deactivateStructure();

        }

        return checkStructure();

         */
    }

    @Override
    public void invalidateEntity() {
        assert world != null;
        final BlockPos frame = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        final BlockPos top = new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ());
        world.setBlockState(pos, world.getBlockState(pos).with(Scanner.Scanner, false));
        if (world.getBlockState(frame).getBlock() == ModBlocks.SCANNER_FRAME) {
            world.setBlockState(frame, world.getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
        }
        if (world.getBlockState(top).getBlock() == ModBlocks.SCANNER_TOP) {
            world.setBlockState(top, world.getBlockState(top).with(ScannerTop.scannerFormedTop, false));
        }
    }
/*

    private boolean checkStructure() {

        assert level != null;
        final BlockState height1 = level.getBlockState(new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 1, this.getBlockPos().getZ()));
        final BlockState height2 = level.getBlockState(new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 2, this.getBlockPos().getZ()));
        //height3 = level.getBlockState(new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 3, this.getBlockPos().getZ()));

        return height1.getBlock() == ModBlocks.SCANNER_FRAME.get() &&
                height1.getValue(ScannerFrame.directionPropertyFrame) == level.getBlockState(this.getBlockPos()).getValue(Scanner.directionProperty) &&
                height2.getBlock() == ModBlocks.SCANNER_TOP.get() &&
                height2.getValue(ScannerTop.directionPropertyTop) == level.getBlockState(this.getBlockPos()).getValue(Scanner.directionProperty); //&&
                //height3.getBlock() == ModBlocks.SCANNER_TOP.get() &&
                //height3.getValue(ScannerTop.directionPropertyTop) == level.getBlockState(this.getBlockPos()).getValue(Scanner.directionProperty);
    }

    private void activateStructure() {
        getLevel().setBlockAndUpdate(this.getBlockPos(), getLevel().getBlockState(getBlockPos()).setValue(Scanner.Scanner, true));
        //BlockPos h3;
        final BlockPos h1 = new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 1, this.getBlockPos().getZ());
        final BlockPos h2 = new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 2, this.getBlockPos().getZ());
        //h3 = new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 3, this.getBlockPos().getZ());
        getLevel().setBlockAndUpdate(h1, getLevel().getBlockState(h1).setValue(ScannerFrame.ScannerFrameInvis, true));
        getLevel().setBlockAndUpdate(h2, getLevel().getBlockState(h2).setValue(ScannerTop.scannerFormedTop, true));
        //getLevel().setBlockAndUpdate(h3, getLevel().getBlockState(h3).setValue(ScannerTop.scannerFormedTop, true));
    }

    private void deactivateStructure() {
        BlockPos h1, h2, h3;
        h1 = new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 1, this.getBlockPos().getZ());
        h2 = new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 2, this.getBlockPos().getZ());
        //h3 = new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 3, this.getBlockPos().getZ());

        if (getLevel().getBlockState(this.getBlockPos()).getBlock() == ModBlocks.SCANNER_BASE.get()) {
            getLevel().setBlockAndUpdate(this.getBlockPos(), getLevel().getBlockState(this.getBlockPos()).setValue(Scanner.Scanner, false));
        }
        if (getLevel().getBlockState(h1).getBlock() == ModBlocks.SCANNER_FRAME.get()) {
            getLevel().setBlockAndUpdate(h1, getLevel().getBlockState(h1).setValue(ScannerFrame.ScannerFrameInvis, false));
        }
       // if (getLevel().getBlockState(h2).getBlock() == ModBlocks.SCANNER_FRAME.get()) {
        //    getLevel().setBlockAndUpdate(h2, getLevel().getBlockState(h2).setValue(ScannerFrame.ScannerFrameInvis, false));
        //}
        if (getLevel().getBlockState(h2).getBlock() == ModBlocks.SCANNER_TOP.get()) {
            getLevel().setBlockAndUpdate(h2, getLevel().getBlockState(h2).setValue(ScannerTop.scannerFormedTop, false));
        }
    }

 */


}
