package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.blocks.Scanner;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.ScannerFrame;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.ScannerTop;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ScannerTileEntity extends BlockEntity implements BlockEntityTicker {


    public ScannerTileEntity(BlockEntityType<?> tileEntityTypeIn, BlockPos pos, BlockState state) {
        super(tileEntityTypeIn,pos,state);
    }

    public ScannerTileEntity() {
        this(ModTileEntities.SCANNER_TILE_ENTITY);
    }

    private boolean once = false;

    @Override
    public void tick(Level p_155253_, BlockPos p_155254_, BlockState p_155255_, BlockEntity p_155256_) {
        if (checkStructure() && !once) {
            activateStructure();
            once = true;
        } else if (!checkStructure()) {
            once = false;
            deactivateStructure();
        }
    }

    private boolean checkStructure() {
        BlockState height1, height2, height3;
        height1 = level.getBlockState(new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 1, this.getBlockPos().getZ()));
        height2 = level.getBlockState(new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 2, this.getBlockPos().getZ()));
        height3 = level.getBlockState(new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 3, this.getBlockPos().getZ()));

        return height1.getBlock() == ModBlocks.SCANNER_FRAME.get() &&
                height1.getValue(ScannerFrame.directionPropertyFrame) == level.getBlockState(this.getBlockPos()).getValue(Scanner.directionProperty) &&
                height2.getBlock() == ModBlocks.SCANNER_FRAME.get() &&
                height2.getValue(ScannerFrame.directionPropertyFrame) == level.getBlockState(this.getBlockPos()).getValue(Scanner.directionProperty) &&
                height3.getBlock() == ModBlocks.SCANNER_TOP.get() &&
                height3.getValue(ScannerTop.directionPropertyTop) == level.getBlockState(this.getBlockPos()).getValue(Scanner.directionProperty);
    }

    private void activateStructure() {
        getLevel().setBlockAndUpdate(this.getBlockPos(), getLevel().getBlockState(getBlockPos()).setValue(Scanner.Scanner, true));
        BlockPos h1, h2, h3;
        h1 = new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 1, this.getBlockPos().getZ());
        h2 = new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 2, this.getBlockPos().getZ());
        h3 = new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 3, this.getBlockPos().getZ());
        getLevel().setBlockAndUpdate(h1, getLevel().getBlockState(h1).setValue(ScannerFrame.ScannerFrameInvis, true));
        getLevel().setBlockAndUpdate(h2, getLevel().getBlockState(h2).setValue(ScannerFrame.ScannerFrameInvis, true));
        getLevel().setBlockAndUpdate(h3, getLevel().getBlockState(h3).setValue(ScannerTop.scannerFormedTop, true));
    }

    private void deactivateStructure() {
        BlockPos h1, h2, h3;
        h1 = new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 1, this.getBlockPos().getZ());
        h2 = new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 2, this.getBlockPos().getZ());
        h3 = new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 3, this.getBlockPos().getZ());

        if (getLevel().getBlockState(this.getBlockPos()).getBlock() == ModBlocks.SCANNER_BASE.get()) {
            getLevel().setBlockAndUpdate(this.getBlockPos(), getLevel().getBlockState(this.getBlockPos()).setValue(Scanner.Scanner, false));
        }
        if (getLevel().getBlockState(h1).getBlock() == ModBlocks.SCANNER_FRAME.get()) {
            getLevel().setBlockAndUpdate(h1, getLevel().getBlockState(h1).setValue(ScannerFrame.ScannerFrameInvis, false));
        }
        if (getLevel().getBlockState(h2).getBlock() == ModBlocks.SCANNER_FRAME.get()) {
            getLevel().setBlockAndUpdate(h2, getLevel().getBlockState(h2).setValue(ScannerFrame.ScannerFrameInvis, false));
        }
        if (getLevel().getBlockState(h3).getBlock() == ModBlocks.SCANNER_TOP.get()) {
            getLevel().setBlockAndUpdate(h3, getLevel().getBlockState(h3).setValue(ScannerTop.scannerFormedTop, false));
        }
    }


}
