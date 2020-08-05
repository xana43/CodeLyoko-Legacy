package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.blocks.Scanner;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.ScannerFrame;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class ScannerTileEntity extends TileEntity implements ITickableTileEntity {


    public ScannerTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ScannerTileEntity(){
        this(ModTileEntities.SCANNER_TILE_ENTITY.get());
    }

    private boolean once = false;

    @Override
    public void tick() {
        if (checkStructure() && !once) {
            getWorld().setBlockState(this.getPos(), getWorld().getBlockState(getPos()).with(Scanner.Scanner, true));
            BlockPos side1,side2,side3,side4,side5;
            BlockPos h1 = null,h2 = null,h3 = null;
            for (int i : new int[]{-1,1}) {
                side1 = new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ());
                side2 = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + 1);
                side3 = new BlockPos(this.getPos().getX() + i,this.getPos().getY(),this.getPos().getZ() + 1);
                for(int t : new int[]{1,2,3})
                {
                    h1 = new BlockPos(this.getPos().getX() + i, this.getPos().getY() + t, this.getPos().getZ());
                    h2 = new BlockPos(this.getPos().getX(), this.getPos().getY() + t, this.getPos().getZ() + 1);
                    h3 = new BlockPos(this.getPos().getX() + i,this.getPos().getY() + t,this.getPos().getZ() + 1);
                    getWorld().setBlockState(h1, getWorld().getBlockState(h1).with(ScannerFrame.ScannerFrameInvis, true));
                    getWorld().setBlockState(h2, getWorld().getBlockState(h2).with(ScannerFrame.ScannerFrameInvis, true));
                    getWorld().setBlockState(h3, getWorld().getBlockState(h3).with(ScannerFrame.ScannerFrameInvis,true));
                }
                getWorld().setBlockState(side1, getWorld().getBlockState(side1).with(ScannerFrame.ScannerFrameInvis, true));
                getWorld().setBlockState(side2, getWorld().getBlockState(side2).with(ScannerFrame.ScannerFrameInvis, true));
                getWorld().setBlockState(side3, getWorld().getBlockState(side3).with(ScannerFrame.ScannerFrameInvis,true));

            }

            once = true;

        } else if (!checkStructure()) {
            once = false;
            if(getWorld().getBlockState(this.getPos()).getBlock() == ModBlocks.SCANNER_BASE.get())
            {
                getWorld().setBlockState(this.getPos(),getWorld().getBlockState(getPos()).with(Scanner.Scanner,false));
            }
            BlockPos frame = null;
            for(int j : new int[] {-1,1})
            {
                frame = new BlockPos(this.getPos().getX() + j, this.getPos().getY(), this.getPos().getZ());
                if(getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get())
                {
                    getWorld().setBlockState(frame,getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis,false));
                }
            }
            for(int j : new int[] {-1,1})
            {
                frame = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + 1);
                if(getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get())
                {
                    getWorld().setBlockState(frame,getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis,false));
                }
            }
            for(int j : new int[] {-1,1})
            {
                frame = new BlockPos(this.getPos().getX() + j,this.getPos().getY(),this.getPos().getZ() + 1);
                if(getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get())
                {
                    getWorld().setBlockState(frame,getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis,false));
                }
            }
            for(int h : new int[] {1,2,3})
            {
                for(int j : new int[] {-1,1}) {
                    frame = new BlockPos(this.getPos().getX() + j, this.getPos().getY() + h, this.getPos().getZ());
                }
                if(getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get())
                {
                    getWorld().setBlockState(frame,getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis,false));
                }
            }
            for(int h: new int[] {1,2,3})
            {
                for(int j : new int[] {-1,1}) {
                    frame = new BlockPos(this.getPos().getX() + j,this.getPos().getY() + h,this.getPos().getZ() + 1);
                }
                if(getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get())
                {
                    getWorld().setBlockState(frame,getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis,false));
                }
            }
            for(int h: new int[] {1,2,3})
            {


                for(int j : new int[] {-1,1}) {
                    frame = new BlockPos(this.getPos().getX() + j, this.getPos().getY() + h, this.getPos().getZ());;
                }
                if(getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get())
                {
                    getWorld().setBlockState(frame,getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis,false));
                }
            }
            for(int h: new int[] {1,2,3})
            {
                frame = new BlockPos(this.getPos().getX(), this.getPos().getY() + h, this.getPos().getZ() + 1);
                if(getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get())
                {
                    getWorld().setBlockState(frame,getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis,false));
                }
            }

        }
    }




    private boolean checkStructure() {

        int[] data = {-1,1};
        int[] height = {1,2,3};
        for (int i: data) {
            Block side = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ())).getBlock();
            Block side2 = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + 1)).getBlock();
            Block Side3 = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ() + 1)).getBlock();
            Block Height2 = null;
            Block Height1 = null;
            Block Height3 = null;
            for (int h : height) {
                Height1 = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() + h, this.getPos().getZ() + 1)).getBlock();

                Height2 = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY() + h, this.getPos().getZ())).getBlock();
                Height3 = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY() + h, this.getPos().getZ() + 1)).getBlock();
            }
            if (side != ModBlocks.SCANNER_BLOCK.get() || side2 != ModBlocks.SCANNER_BLOCK.get() || Side3 != ModBlocks.SCANNER_BLOCK.get() || Height2 != ModBlocks.SCANNER_BLOCK.get() ||
                    Height1 != ModBlocks.SCANNER_BLOCK.get() || Height3 != ModBlocks.SCANNER_BLOCK.get()) {
                return false;
            }
        }

        return true;
    }
}
