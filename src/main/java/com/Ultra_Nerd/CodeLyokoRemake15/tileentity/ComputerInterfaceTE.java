package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class ComputerInterfaceTE extends TileEntity implements ITickableTileEntity {
    public ComputerInterfaceTE(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    boolean screen = false;

    private boolean once = false;
    public ComputerInterfaceTE() {
        this(ModTileEntities.COMPUTER_INTERFACE_TILE_ENTITY.get());
    }

    @Override
    public void tick() {
        if(CheckStructure() && !once)
        {
            Base.Log.info("computer is built");
            once = true;
        }
        else if(!CheckStructure())
        {

            once = false;
        }
    }
    private boolean CheckStructure()
    {

        BlockState[] l1_1 = new BlockState[5],l2_1 = new BlockState[5];
        Block[] screen_blocks1,screen_blocks2,frame_blocks1,frame_blocks2;

        for(int i = 0; i < l1_1.length;i++)
        {

            if(world != null) {
                l1_1[i] = world.getBlockState(new BlockPos((this.pos.getX() - 2) + i, this.pos.getY() + 1, this.pos.getZ()));
                l2_1[i] = world.getBlockState(new BlockPos((this.pos.getX() - 2) + i, this.pos.getY() + 2, this.pos.getZ()));
                if(l1_1[4] != null) {
                    if (l1_1[0].getBlock() == ModBlocks.COMPUTER_SCREEN_FRAME.get()
                            && l1_1[4].getBlock() == ModBlocks.COMPUTER_SCREEN_FRAME.get()
                            && l1_1[1].getBlock() == ModBlocks.COMPUTER_SCREEN.get()
                            && l1_1[2].getBlock() == ModBlocks.COMPUTER_SCREEN.get()
                            && l1_1[3].getBlock() == ModBlocks.COMPUTER_SCREEN.get()
                            && l2_1[0].getBlock() == ModBlocks.COMPUTER_SCREEN_FRAME.get()
                            && l2_1[4].getBlock() == ModBlocks.COMPUTER_SCREEN_FRAME.get()
                            && l2_1[1].getBlock() == ModBlocks.COMPUTER_SCREEN.get()
                            && l2_1[2].getBlock() == ModBlocks.COMPUTER_SCREEN.get()
                            && l2_1[3].getBlock() == ModBlocks.COMPUTER_SCREEN.get()) {
                        screen = true;
                    }
                }
                else
                {screen = false;
                }

            }
        }

        return screen;


    }
}
