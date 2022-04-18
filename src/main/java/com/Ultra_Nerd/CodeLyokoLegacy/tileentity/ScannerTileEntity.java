package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock.BlockPatternRegistry;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock.MasterEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.Scanner;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.ScannerFrame;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.ScannerTop;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import org.jetbrains.annotations.NotNull;

public class ScannerTileEntity extends BlockEntity implements MasterEntity {


    public ScannerTileEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        super(ModTileEntities.SCANNER_TILE_ENTITY.get(), pos, state);




    }




   // public void invalidateStruct()
   // {
     //   deactivateStructure();
   // }

    @Override
    public boolean check() {
        //scannerpattern.matches(this.level,this.worldPosition,this.level.getBlockState(this.worldPosition).getValue(Scanner.directionProperty), Direction.UP);
       if(level != null) {
           //String.valueOf(BlockPatternRegistry.matches(BlockPatternRegistry.scanner,this.level,this.worldPosition,this.level.getBlockState(this.worldPosition).getValue(Scanner.directionProperty),Direction.DOWN))
           //CodeLyokoMain.Log.info(String.valueOf(BlockPatternRegistry.scanner.find(level,worldPosition)));
           final BlockPattern.BlockPatternMatch match = BlockPatternRegistry.scanner.find(level, worldPosition);


           if (match != null) {

               //CodeLyokoMain.Log.info("pattern matched");
                final BlockPos frame = new BlockPos(worldPosition.getX(),worldPosition.getY() + 1,worldPosition.getZ());
                final BlockPos top = new BlockPos(worldPosition.getX(),worldPosition.getY() + 2, worldPosition.getZ());
               level.setBlockAndUpdate(frame, level.getBlockState(frame).setValue(ScannerFrame.ScannerFrameInvis, true));
               level.setBlockAndUpdate(top, level.getBlockState(top).setValue(ScannerTop.scannerFormedTop, true));
               level.setBlockAndUpdate(worldPosition, level.getBlockState(worldPosition).setValue(Scanner.Scanner, true));
               return true;
           } else {

               invalidateEntity();
               return false;
           }
       }
        /*if (checkStructure()) {
            activateStructure();

        } else if (!checkStructure()) {
            deactivateStructure();

        }

        return checkStructure();

         */
        return false;
    }
    @Override
    public void invalidateEntity()
    {
        assert level != null;
        level.setBlockAndUpdate(worldPosition,level.getBlockState(worldPosition).setValue(Scanner.Scanner,false));
        if(level.getBlockState(worldPosition.above()).getBlock() == ModBlocks.SCANNER_FRAME.get()) {
            level.setBlockAndUpdate(worldPosition.above(), level.getBlockState(worldPosition.above()).setValue(ScannerFrame.ScannerFrameInvis, false));
        }
        if(level.getBlockState(worldPosition.above().above()).getBlock() == ModBlocks.SCANNER_TOP.get()) {
            level.setBlockAndUpdate(worldPosition.above().above(), level.getBlockState(worldPosition.above().above()).setValue(ScannerTop.scannerFormedTop, false));
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
