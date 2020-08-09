package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.blocks.Scanner;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.ScannerFrame;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.ScannerTop;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class ScannerTileEntity extends TileEntity implements ITickableTileEntity {


    public ScannerTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ScannerTileEntity() {
        this(ModTileEntities.SCANNER_TILE_ENTITY.get());
    }

    private boolean once = false;

    @Override
    public void tick() {
        if(checkStructure() && !once) {
            activateStructure();
            once=true;
        } else if(!checkStructure()) {
            once=false;
            deactivateStructure();
        }
    }

    private boolean checkStructure() {
        BlockState height1, height2, height3;
        height1 = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() + 1, this.getPos().getZ()));
        height2 = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() + 2, this.getPos().getZ()));
        height3 = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() + 3, this.getPos().getZ()));

        return height1.getBlock() == ModBlocks.SCANNER_FRAME.get() &&
                height1.get(ScannerFrame.directionPropertyFrame) == world.getBlockState(this.getPos()).get(Scanner.directionProperty) &&
                height2.getBlock() == ModBlocks.SCANNER_FRAME.get() &&
                height2.get(ScannerFrame.directionPropertyFrame) == world.getBlockState(this.getPos()).get(Scanner.directionProperty) &&
                height3.getBlock() == ModBlocks.SCANNER_TOP.get() &&
                height3.get(ScannerTop.directionPropertyTop) == world.getBlockState(this.getPos()).get(Scanner.directionProperty);
    }

    private void activateStructure() {
        getWorld().setBlockState(this.getPos(), getWorld().getBlockState(getPos()).with(Scanner.Scanner, true));
        BlockPos h1, h2, h3;
        h1 = new BlockPos(this.getPos().getX(), this.getPos().getY() + 1, this.getPos().getZ());
        h2 = new BlockPos(this.getPos().getX(), this.getPos().getY() + 2, this.getPos().getZ());
        h3 = new BlockPos(this.getPos().getX(), this.getPos().getY() + 3, this.getPos().getZ());
        getWorld().setBlockState(h1, getWorld().getBlockState(h1).with(ScannerFrame.ScannerFrameInvis, true));
        getWorld().setBlockState(h2, getWorld().getBlockState(h2).with(ScannerFrame.ScannerFrameInvis, true));
        getWorld().setBlockState(h3, getWorld().getBlockState(h3).with(ScannerTop.scannerFormedTop, true));
    }

    private void deactivateStructure() {
        BlockPos h1, h2, h3;
        h1 = new BlockPos(this.getPos().getX(), this.getPos().getY() + 1, this.getPos().getZ());
        h2 = new BlockPos(this.getPos().getX(), this.getPos().getY() + 2, this.getPos().getZ());
        h3 = new BlockPos(this.getPos().getX(), this.getPos().getY() + 3, this.getPos().getZ());

        if (getWorld().getBlockState(this.getPos()).getBlock() == ModBlocks.SCANNER_BASE.get()) {
            getWorld().setBlockState(this.getPos(), getWorld().getBlockState(this.getPos()).with(Scanner.Scanner, false));
        }
        if (getWorld().getBlockState(h1).getBlock()==ModBlocks.SCANNER_FRAME.get()){
            getWorld().setBlockState(h1, getWorld().getBlockState(h1).with(ScannerFrame.ScannerFrameInvis, false));
        }
        if (getWorld().getBlockState(h2).getBlock()==ModBlocks.SCANNER_FRAME.get()){
            getWorld().setBlockState(h2, getWorld().getBlockState(h2).with(ScannerFrame.ScannerFrameInvis, false));
        }
        if (getWorld().getBlockState(h3).getBlock()==ModBlocks.SCANNER_TOP.get()){
            getWorld().setBlockState(h3, getWorld().getBlockState(h3).with(ScannerTop.scannerFormedTop, false));
        }
    }

}
