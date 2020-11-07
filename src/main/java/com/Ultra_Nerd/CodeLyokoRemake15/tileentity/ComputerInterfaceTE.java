package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
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
    boolean frame = false;
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

        BlockState[] l1_1 = new BlockState[4],l2_1 = new BlockState[4];
        BlockState[] l1_2 = new BlockState[3],l2_2 = new BlockState[3];

        for(int i = 0; i < 3;i++)
        {

            l1_1[i] = world.getBlockState(new BlockPos(this.pos.getX() + i,this.pos.getY() + 1,this.pos.getZ()));
            l2_1[i] = world.getBlockState(new BlockPos(this.pos.getX() + i,this.pos.getY() + 2,this.pos.getZ()));
        }
        for(int i = 1; i < 3;i++)
        {

            l1_2[i] = world.getBlockState(new BlockPos(this.pos.getX() - i,this.pos.getY() + 1,this.pos.getZ()));
            l2_2[i] = world.getBlockState(new BlockPos(this.pos.getX() - i,this.pos.getY() + 2,this.pos.getZ()));
        }

        if(l1_1[3].getBlock() == ModBlocks.COMPUTER_SCREEN_FRAME.get() && l1_2[2].getBlock() == ModBlocks.COMPUTER_SCREEN_FRAME.get())
        {
            if(l2_1[3].getBlock() == ModBlocks.COMPUTER_SCREEN_FRAME.get() && l2_2[2].getBlock() == ModBlocks.COMPUTER_SCREEN_FRAME.get())
            {
                frame = true;
            }
        }
        else
        {
            frame = false;
        }

        for(int i = 0; i < 2; i++)
        {
            if (l1_1[i].getBlock() == ModBlocks.COMPUTER_SCREEN.get() && l1_2[i].getBlock() == ModBlocks.COMPUTER_SCREEN.get())
            {
                if (l2_1[i].getBlock() == ModBlocks.COMPUTER_SCREEN.get() && l2_2[i].getBlock() == ModBlocks.COMPUTER_SCREEN.get())
                {
                    screen = true;
                }
            }
            else
            {
                screen = false;
            }
        }


        return screen && frame;


    }
}
