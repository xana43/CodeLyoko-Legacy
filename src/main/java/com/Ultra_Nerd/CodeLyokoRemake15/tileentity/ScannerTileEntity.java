package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.blocks.QuantumSteelBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.Scanner;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class ScannerTileEntity extends TileEntity implements ITickableTileEntity {


    public ScannerTileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ScannerTileEntity(){
        this(ModTileEntities.SCANNER_TILE_ENTITY.get());
    }
    private static boolean once = false;
    @Override
    public void tick() {
        if (checkStructure() && !once) {
            getWorld().setBlockState(this.getPos(), getWorld().getBlockState(getPos()).with(Scanner.Scanner, true));
            BlockPos side1,side2,side3,side4,side5;
            for (int i : new int[]{-1,1}) {
                side1 = new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ());
                side2 = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + i);
                side3 = new BlockPos(this.getPos().getX() + i,this.getPos().getY(),this.getPos().getZ() + i);

                getWorld().setBlockState(side1, getWorld().getBlockState(side1).with(QuantumSteelBlock.formed, true));
                getWorld().setBlockState(side2, getWorld().getBlockState(side2).with(QuantumSteelBlock.formed, true));
                getWorld().setBlockState(side3, getWorld().getBlockState(side3).with(QuantumSteelBlock.formed,true));

            }

            once = true;

        } else if (!checkStructure()) {
            once = false;


        }
    }




    private boolean checkStructure() {
        Block above = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() + 1, this.getPos().getZ())).getBlock();
        if (above != ModBlocks.PROJECTOR_FOCUS.get()) {
            return false;
        }
        int[] data = {-1,1};
        for (int i: data) {
            Block side = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ())).getBlock();
            Block side2 = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + i)).getBlock();
            Block Side3 = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY(),this.getPos().getZ() + 1)).getBlock();
            if (side != ModBlocks.QUANTUM_STEEL_BLOCK.get() || side2 != ModBlocks.QUANTUM_STEEL_BLOCK.get()) {
                return false;
            }
        }
        return true;
    }
}
