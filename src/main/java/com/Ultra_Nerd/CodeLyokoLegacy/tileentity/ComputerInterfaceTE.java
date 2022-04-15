package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

public class ComputerInterfaceTE extends BlockEntity implements BlockEntityTicker<ComputerInterfaceTE> {
    //public ComputerInterfaceTE(BlockEntityType<?> tileEntityTypeIn) {
      //  super(tileEntityTypeIn);
    //}
    boolean screen = false;

    private boolean once = false;

    public ComputerInterfaceTE(@NotNull BlockEntityType<?> p_155228_, @NotNull BlockPos p_155229_, @NotNull BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }
    /*
    public ComputerInterfaceTE() {
        this(ModTileEntities.COMPUTER_INTERFACE_TILE_ENTITY.get());
    }

     */


    private boolean CheckStructure()
    {

        BlockState[] l1_1 = new BlockState[5],l2_1 = new BlockState[5];
        Block[] screen_blocks1,screen_blocks2,frame_blocks1,frame_blocks2;

        for(int i = 0; i < l1_1.length;i++)
        {

            if(level != null) {
                l1_1[i] = level.getBlockState(new BlockPos((this.getBlockPos().getX() - 2) + i, this.getBlockPos().getY() + 1, this.getBlockPos().getZ()));
                l2_1[i] = level.getBlockState(new BlockPos((this.getBlockPos().getX() - 2) + i, this.getBlockPos().getY() + 2, this.getBlockPos().getZ()));
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

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
    }

    @Override
    public CompoundTag serializeNBT() {
        return super.serializeNBT();
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public AABB getRenderBoundingBox() {
        return super.getRenderBoundingBox();
    }

    @Override
    public void tick(Level p_155253_, BlockPos p_155254_, BlockState p_155255_, ComputerInterfaceTE p_155256_) {
        if(CheckStructure() && !once)
        {
            CodeLyokoMain.Log.info("computer is built");
            once = true;
        }
        else if(!CheckStructure())
        {

            once = false;
        }
    }
}
