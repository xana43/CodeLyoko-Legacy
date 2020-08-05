package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.blocks.Scanner;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.ScannerFrame;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
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
        if (this.getBlockState().get(Scanner.directionProperty) == Direction.SOUTH) {
            if (checkStructureSouth() && !once) {
                activateSouth();
                once = true;

            } else if (!checkStructureSouth()) {
                once = false;
                deactivateSouth();
                deactivateAboveBase();
            }
        } else if (this.getBlockState().get(Scanner.directionProperty) == Direction.NORTH) {
            if (checkStructureNorth() && !once) {
                activateNorth();
                once = true;

            } else if (!checkStructureNorth()) {
                once = false;
                deactivateNorth();
                deactivateAboveBase();
            }
        } else if (this.getBlockState().get(Scanner.directionProperty) == Direction.WEST) {
            if (checkStructureWest() && !once) {
                activateWest();
                once = true;

            } else if (!checkStructureWest()) {
                once = false;
                deactivateWest();
                deactivateAboveBase();
            }
        } else if (this.getBlockState().get(Scanner.directionProperty) == Direction.EAST) {
            if (checkStructureEast() && !once) {
                activateEast();
                once = true;

            } else if (!checkStructureEast()) {
                once = false;
                deactivateEast();
                deactivateAboveBase();
            }
        }
    }


    int[] data = {-1, 1};
    int[] height = {1, 2, 3};

    BlockPos height4;


    private boolean checkStructureAboveBase() {
        height4  = new BlockPos(this.pos.getX(), this.pos.getY() + 3, this.pos.getZ());
        return world.getBlockState(height4).getBlock() == ModBlocks.SCANNER_BLOCK.get();
    }

    private boolean checkStructureSouth() {

        for (int i : data) {
            Block side = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ())).getBlock();
            Block side2 = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + 1)).getBlock();
            Block side3 = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ() + 1)).getBlock();

            Block height1, height2, height3;

            if (side != ModBlocks.SCANNER_BLOCK.get() || side2 != ModBlocks.SCANNER_BLOCK.get() || side3 != ModBlocks.SCANNER_BLOCK.get())
                return false;
            for (int h : height) {
                height1 = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() + h, this.getPos().getZ() + 1)).getBlock();
                height2 = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY() + h, this.getPos().getZ())).getBlock();
                height3 = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY() + h, this.getPos().getZ() + 1)).getBlock();
                if (height2 != ModBlocks.SCANNER_BLOCK.get() || height1 != ModBlocks.SCANNER_BLOCK.get() || height3 != ModBlocks.SCANNER_BLOCK.get()
                        || !checkStructureAboveBase()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkStructureNorth() {
        for (int i : data) {
            Block side = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ())).getBlock();
            Block side2 = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() - 1)).getBlock();
            Block side3 = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ() - 1)).getBlock();
            Block height1, height2, height3;
            if (side != ModBlocks.SCANNER_BLOCK.get() || side2 != ModBlocks.SCANNER_BLOCK.get() || side3 != ModBlocks.SCANNER_BLOCK.get())
                return false;
            for (int h : height) {
                height1 = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() + h, this.getPos().getZ() - 1)).getBlock();
                height2 = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY() + h, this.getPos().getZ())).getBlock();
                height3 = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY() + h, this.getPos().getZ() - 1)).getBlock();
                if (height2 != ModBlocks.SCANNER_BLOCK.get() || height1 != ModBlocks.SCANNER_BLOCK.get() || height3 != ModBlocks.SCANNER_BLOCK.get()
                        || !checkStructureAboveBase()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkStructureWest() {
        for (int i : data) {
            Block side = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + i)).getBlock();
            Block side2 = world.getBlockState(new BlockPos(this.getPos().getX() - 1, this.getPos().getY(), this.getPos().getZ())).getBlock();
            Block side3 = world.getBlockState(new BlockPos(this.getPos().getX() - 1, this.getPos().getY(), this.getPos().getZ() + i)).getBlock();
            Block height1, height2, height3;
            if (side != ModBlocks.SCANNER_BLOCK.get() || side2 != ModBlocks.SCANNER_BLOCK.get() || side3 != ModBlocks.SCANNER_BLOCK.get())
                return false;
            for (int h : height) {
                height1 = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() + h, this.getPos().getZ() + i)).getBlock();
                height2 = world.getBlockState(new BlockPos(this.getPos().getX() - 1, this.getPos().getY() + h, this.getPos().getZ())).getBlock();
                height3 = world.getBlockState(new BlockPos(this.getPos().getX() - 1, this.getPos().getY() + h, this.getPos().getZ() + i)).getBlock();
                if (height2 != ModBlocks.SCANNER_BLOCK.get() || height1 != ModBlocks.SCANNER_BLOCK.get() || height3 != ModBlocks.SCANNER_BLOCK.get()
                        || !checkStructureAboveBase()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkStructureEast() {
        for (int i : data) {
            Block side = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + i)).getBlock();
            Block side2 = world.getBlockState(new BlockPos(this.getPos().getX() + 1, this.getPos().getY(), this.getPos().getZ() + i)).getBlock();
            Block side3 = world.getBlockState(new BlockPos(this.getPos().getX() + 1, this.getPos().getY(), this.getPos().getZ() + i)).getBlock();
            Block height1, height2, height3;
            if (side != ModBlocks.SCANNER_BLOCK.get() || side2 != ModBlocks.SCANNER_BLOCK.get() || side3 != ModBlocks.SCANNER_BLOCK.get())
                return false;
            for (int h : height) {
                height1 = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() + h, this.getPos().getZ() + i)).getBlock();
                height2 = world.getBlockState(new BlockPos(this.getPos().getX() + 1, this.getPos().getY() + h, this.getPos().getZ())).getBlock();
                height3 = world.getBlockState(new BlockPos(this.getPos().getX() + 1, this.getPos().getY() + h, this.getPos().getZ() + i)).getBlock();
                if (height2 != ModBlocks.SCANNER_BLOCK.get() || height1 != ModBlocks.SCANNER_BLOCK.get() || height3 != ModBlocks.SCANNER_BLOCK.get()
                        || !checkStructureAboveBase()) {
                    return false;
                }
            }
        }
        return true;
    }


    private void activateSouth() {
        getWorld().setBlockState(this.getPos(), getWorld().getBlockState(getPos()).with(Scanner.Scanner, true));
        BlockPos side1, side2, side3;
        BlockPos h1, h2, h3;
        for (int i : data) {
            side1 = new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ());
            side2 = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + 1);
            side3 = new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ() + 1);
            for (int t : height) {
                h1 = new BlockPos(this.getPos().getX() + i, this.getPos().getY() + t, this.getPos().getZ());
                h2 = new BlockPos(this.getPos().getX(), this.getPos().getY() + t, this.getPos().getZ() + 1);
                h3 = new BlockPos(this.getPos().getX() + i, this.getPos().getY() + t, this.getPos().getZ() + 1);
                getWorld().setBlockState(h1, getWorld().getBlockState(h1).with(ScannerFrame.ScannerFrameInvis, true));
                getWorld().setBlockState(h2, getWorld().getBlockState(h2).with(ScannerFrame.ScannerFrameInvis, true));
                getWorld().setBlockState(h3, getWorld().getBlockState(h3).with(ScannerFrame.ScannerFrameInvis, true));
            }
            getWorld().setBlockState(side1, getWorld().getBlockState(side1).with(ScannerFrame.ScannerFrameInvis, true));
            getWorld().setBlockState(side2, getWorld().getBlockState(side2).with(ScannerFrame.ScannerFrameInvis, true));
            getWorld().setBlockState(side3, getWorld().getBlockState(side3).with(ScannerFrame.ScannerFrameInvis, true));
        }
        getWorld().setBlockState(height4, getWorld().getBlockState(height4).with(ScannerFrame.ScannerFrameInvis, true));
    }

    private void activateNorth() {
        getWorld().setBlockState(this.getPos(), getWorld().getBlockState(getPos()).with(Scanner.Scanner, true));
        BlockPos side1, side2, side3;
        BlockPos h1, h2, h3;
        for (int i : data) {
            side1 = new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ());
            side2 = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() - 1);
            side3 = new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ() - 1);
            for (int t : height) {
                h1 = new BlockPos(this.getPos().getX() + i, this.getPos().getY() + t, this.getPos().getZ());
                h2 = new BlockPos(this.getPos().getX(), this.getPos().getY() + t, this.getPos().getZ() - 1);
                h3 = new BlockPos(this.getPos().getX() + i, this.getPos().getY() + t, this.getPos().getZ() - 1);
                getWorld().setBlockState(h1, getWorld().getBlockState(h1).with(ScannerFrame.ScannerFrameInvis, true));
                getWorld().setBlockState(h2, getWorld().getBlockState(h2).with(ScannerFrame.ScannerFrameInvis, true));
                getWorld().setBlockState(h3, getWorld().getBlockState(h3).with(ScannerFrame.ScannerFrameInvis, true));
            }
            getWorld().setBlockState(side1, getWorld().getBlockState(side1).with(ScannerFrame.ScannerFrameInvis, true));
            getWorld().setBlockState(side2, getWorld().getBlockState(side2).with(ScannerFrame.ScannerFrameInvis, true));
            getWorld().setBlockState(side3, getWorld().getBlockState(side3).with(ScannerFrame.ScannerFrameInvis, true));
        }
        getWorld().setBlockState(height4, getWorld().getBlockState(height4).with(ScannerFrame.ScannerFrameInvis, true));
    }

    private void activateWest() {
        getWorld().setBlockState(this.getPos(), getWorld().getBlockState(getPos()).with(Scanner.Scanner, true));
        BlockPos side1, side2, side3;
        BlockPos h1 = null, h2 = null, h3;
        for (int i : data) {
            side1 = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + i);
            side2 = new BlockPos(this.getPos().getX() - 1, this.getPos().getY(), this.getPos().getZ());
            side3 = new BlockPos(this.getPos().getX() - 1, this.getPos().getY(), this.getPos().getZ() + i);
            for (int t : height) {
                h1 = new BlockPos(this.getPos().getX(), this.getPos().getY() + t, this.getPos().getZ() + i);
                h2 = new BlockPos(this.getPos().getX() - 1, this.getPos().getY() + t, this.getPos().getZ());
                h3 = new BlockPos(this.getPos().getX() - 1, this.getPos().getY() + t, this.getPos().getZ() + i);
                getWorld().setBlockState(h1, getWorld().getBlockState(h1).with(ScannerFrame.ScannerFrameInvis, true));
                getWorld().setBlockState(h2, getWorld().getBlockState(h2).with(ScannerFrame.ScannerFrameInvis, true));
                getWorld().setBlockState(h3, getWorld().getBlockState(h3).with(ScannerFrame.ScannerFrameInvis, true));
            }
            getWorld().setBlockState(side1, getWorld().getBlockState(side1).with(ScannerFrame.ScannerFrameInvis, true));
            getWorld().setBlockState(side2, getWorld().getBlockState(side2).with(ScannerFrame.ScannerFrameInvis, true));
            getWorld().setBlockState(side3, getWorld().getBlockState(side3).with(ScannerFrame.ScannerFrameInvis, true));

        }
        getWorld().setBlockState(height4, getWorld().getBlockState(height4).with(ScannerFrame.ScannerFrameInvis, true));
    }

    private void activateEast() {
        getWorld().setBlockState(this.getPos(), getWorld().getBlockState(getPos()).with(Scanner.Scanner, true));
        BlockPos side1, side2, side3;
        BlockPos h1, h2, h3;
        for (int i : data) {
            side1 = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + i);
            side2 = new BlockPos(this.getPos().getX() + 1, this.getPos().getY(), this.getPos().getZ());
            side3 = new BlockPos(this.getPos().getX() + 1, this.getPos().getY(), this.getPos().getZ() + i);
            for (int t : height) {
                h1 = new BlockPos(this.getPos().getX(), this.getPos().getY() + t, this.getPos().getZ() + i);
                h2 = new BlockPos(this.getPos().getX() + 1, this.getPos().getY() + t, this.getPos().getZ());
                h3 = new BlockPos(this.getPos().getX() + 1, this.getPos().getY() + t, this.getPos().getZ() + i);
                getWorld().setBlockState(h1, getWorld().getBlockState(h1).with(ScannerFrame.ScannerFrameInvis, true));
                getWorld().setBlockState(h2, getWorld().getBlockState(h2).with(ScannerFrame.ScannerFrameInvis, true));
                getWorld().setBlockState(h3, getWorld().getBlockState(h3).with(ScannerFrame.ScannerFrameInvis, true));
            }
            getWorld().setBlockState(side1, getWorld().getBlockState(side1).with(ScannerFrame.ScannerFrameInvis, true));
            getWorld().setBlockState(side2, getWorld().getBlockState(side2).with(ScannerFrame.ScannerFrameInvis, true));
            getWorld().setBlockState(side3, getWorld().getBlockState(side3).with(ScannerFrame.ScannerFrameInvis, true));

        }
        getWorld().setBlockState(height4, getWorld().getBlockState(height4).with(ScannerFrame.ScannerFrameInvis, true));
    }


    private void deactivateHeightNorthSouth() {
        BlockPos frame;
        for (int h : height) {
            for (int j : data) {
                frame = new BlockPos(this.getPos().getX() + j, this.getPos().getY() + h, this.getPos().getZ());
                if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                    getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
                }
            }
            frame = new BlockPos(this.getPos().getX(), this.getPos().getY() + h, this.getPos().getZ());
            if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
            }
        }
    }

    private void deactivateBaseNorthSouth() {
        if (getWorld().getBlockState(this.getPos()).getBlock() == ModBlocks.SCANNER_BASE.get()) {
            getWorld().setBlockState(this.getPos(), getWorld().getBlockState(getPos()).with(Scanner.Scanner, false));
        }
        BlockPos frame;
        for (int j : data) {
            frame = new BlockPos(this.getPos().getX() + j, this.getPos().getY(), this.getPos().getZ());
            if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
            }
        }
    }

    private void deactivateHeightWestEast() {
        BlockPos frame;
        for (int h : height) {
            for (int j : data) {
                frame = new BlockPos(this.getPos().getX(), this.getPos().getY() + h, this.getPos().getZ() + j);
                if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                    getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
                }
            }

            frame = new BlockPos(this.getPos().getX(), this.getPos().getY() + h, this.getPos().getZ());
            if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
            }

        }
    }

    private void deactivateBaseWestEast() {
        if (getWorld().getBlockState(this.getPos()).getBlock() == ModBlocks.SCANNER_BASE.get()) {
            getWorld().setBlockState(this.getPos(), getWorld().getBlockState(getPos()).with(Scanner.Scanner, false));
        }
        BlockPos frame;
        for (int j : data) {
            frame = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + j);
            if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
            }
        }
    }

    private void deactivateAboveBase() {
        height4  = new BlockPos(this.pos.getX(), this.pos.getY() + 3, this.pos.getZ());
        if(getWorld().getBlockState(height4).getBlock()==ModBlocks.SCANNER_BLOCK.get())
            getWorld().setBlockState(height4, getWorld().getBlockState(height4).with(ScannerFrame.ScannerFrameInvis, false));
    }


    private void deactivateSouth() {
        deactivateBaseNorthSouth();
        BlockPos frame;
        frame = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + 1);
        if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
            getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
        }
        for (int j : data) {
            frame = new BlockPos(this.getPos().getX() + j, this.getPos().getY(), this.getPos().getZ() + 1);
            if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
            }
        }
        deactivateHeightNorthSouth();
        for (int h : height) {
            for (int j : data) {
                frame = new BlockPos(this.getPos().getX() + j, this.getPos().getY() + h, this.getPos().getZ() + 1);
                if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                    getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
                }
            }
        }
        for (int h : height) {
            frame = new BlockPos(this.getPos().getX(), this.getPos().getY() + h, this.getPos().getZ() + 1);
            if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
            }
        }
    }

    private void deactivateNorth() {
        deactivateBaseNorthSouth();
        BlockPos frame;
        frame = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() - 1);
        if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
            getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
        }
        for (int j : data) {
            frame = new BlockPos(this.getPos().getX() + j, this.getPos().getY(), this.getPos().getZ() - 1);
            if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
            }
        }
        deactivateHeightNorthSouth();
        for (int h : height) {
            for (int j : data) {
                frame = new BlockPos(this.getPos().getX() + j, this.getPos().getY() + h, this.getPos().getZ() - 1);
                if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                    getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
                }
            }
        }
        for (int h : height) {
            frame = new BlockPos(this.getPos().getX(), this.getPos().getY() + h, this.getPos().getZ() - 1);
            if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
            }
        }
    }

    private void deactivateWest() {
        deactivateBaseWestEast();
        BlockPos frame;
        frame = new BlockPos(this.getPos().getX() - 1, this.getPos().getY(), this.getPos().getZ());
        if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
            getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
        }
        for (int j : data) {
            frame = new BlockPos(this.getPos().getX() - 1, this.getPos().getY(), this.getPos().getZ() + j);
            if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
            }
        }
        deactivateHeightWestEast();
        for (int h : height) {
            for (int j : data) {
                frame = new BlockPos(this.getPos().getX() - 1, this.getPos().getY() + h, this.getPos().getZ() + j);
                if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                    getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
                }
            }
        }
        for (int h : height) {
            frame = new BlockPos(this.getPos().getX() - 1, this.getPos().getY() + h, this.getPos().getZ());
            if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
            }
        }
    }

    private void deactivateEast() {
        deactivateBaseWestEast();
        BlockPos frame;
        frame = new BlockPos(this.getPos().getX() + 1, this.getPos().getY(), this.getPos().getZ());
        if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
            getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
        }
        for (int j : data) {
            frame = new BlockPos(this.getPos().getX() + 1, this.getPos().getY(), this.getPos().getZ() + j);
            if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
            }
        }

        deactivateHeightWestEast();
        for (int h : height) {
            for (int j : data) {
                frame = new BlockPos(this.getPos().getX() + 1, this.getPos().getY() + h, this.getPos().getZ() + j);
                if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                    getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
                }
            }
        }
        for (int h : height) {
            frame = new BlockPos(this.getPos().getX() + 1, this.getPos().getY() + h, this.getPos().getZ());
            if (getWorld().getBlockState(frame).getBlock() == ModBlocks.SCANNER_BLOCK.get()) {
                getWorld().setBlockState(frame, getWorld().getBlockState(frame).with(ScannerFrame.ScannerFrameInvis, false));
            }
        }

    }
}
