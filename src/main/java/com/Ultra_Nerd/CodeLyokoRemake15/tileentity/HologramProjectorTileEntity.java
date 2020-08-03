package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.HologramProjectorBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.ProjectorFocusBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.QuantumSteelBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.HologramContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.command.CommandSource;
import net.minecraft.command.impl.SetBlockCommand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;


public class HologramProjectorTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
    public static boolean once = false;
    //private boolean invalid_block = false;
    //private int x, y, z;
    //boolean once = false;
    //private List<BlockState> stateList;

    public HologramProjectorTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public HologramProjectorTileEntity() {
        super(ModTileEntities.HOLOGRAM_TILE_ENTITY.get());
    }

    private BlockPos focus;


    @Override
    public void tick() {
        focus = new BlockPos(this.getPos().getX(), this.getPos().getY() + 1, this.getPos().getZ());
        // Validate the boolean properties to change the models
        if (checkStructure() && !once) {
            // Projector block
            getWorld().setBlockState(this.getPos(), getWorld().getBlockState(getPos()).with(HologramProjectorBlock.VALID, true));
            // Lens/Focus
            getWorld().setBlockState(focus, getWorld().getBlockState(focus).with(ProjectorFocusBlock.VALIDFOCUS, true));
            // Quantum Steel blocks
            BlockPos steel_1, steel_2;
            for (int i : new int[]{-1,1}) {
                steel_1 = new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ());
                steel_2 = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + i);
                getWorld().setBlockState(steel_1, getWorld().getBlockState(steel_1).with(QuantumSteelBlock.formed, true));
                getWorld().setBlockState(steel_2, getWorld().getBlockState(steel_2).with(QuantumSteelBlock.formed, true));
            }
            //getWorld().setBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() + 2, this.getPos().getZ()),
            //        ModBlocks.HOLOPROJECTOR_PROJECTION.get().getDefaultState());
            once = true;
            //useUran();
        } else if (!checkStructure()) {
            once = false;
            if (getWorld().getBlockState(this.getPos()).getBlock() == ModBlocks.HOLOPROJECTOR.get())
                getWorld().setBlockState(this.getPos(), getWorld().getBlockState(getPos()).with(HologramProjectorBlock.VALID, false));
            if (getWorld().getBlockState(focus).getBlock() == ModBlocks.PROJECTOR_FOCUS.get())
                getWorld().setBlockState(focus, getWorld().getBlockState(focus).with(ProjectorFocusBlock.VALIDFOCUS, false));
            BlockPos steel;
            for (int i : new int[]{-1,1}) {
                steel = new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ());
                if (getWorld().getBlockState(steel).getBlock() == ModBlocks.QUANTUM_STEEL_BLOCK.get())
                    getWorld().setBlockState(steel, getWorld().getBlockState(steel).with(QuantumSteelBlock.formed, false));
            }
            for (int j : new int[]{-1,1}) {
                steel = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + j);
                if (getWorld().getBlockState(steel).getBlock() == ModBlocks.QUANTUM_STEEL_BLOCK.get())
                    getWorld().setBlockState(steel, getWorld().getBlockState(steel).with(QuantumSteelBlock.formed, false));
            }
            //getWorld().setBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() + 2, this.getPos().getZ()),
            //        Blocks.AIR.getDefaultState());
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
            if (side != ModBlocks.QUANTUM_STEEL_BLOCK.get() || side2 != ModBlocks.QUANTUM_STEEL_BLOCK.get()) {
                return false;
            }
        }
        return true;
    }

    /*private void checkstruct() {
        x++;
        if (x > 1) {
            x = -1;
            y++;
            if (y > 0) {
                y = -1;
                z++;
                if (z > 1) {
                    z = -1;
                    valid = !invalid_block;
                    invalid_block = false;
                    System.out.println("Valid" + valid);
                }
            }
        }
        if (x == 0 && y == 0 && z == 0) {
            return;
        }

        Block block = world.getBlockState(new BlockPos(this.pos.getX() + x, this.pos.getY() + y, this.pos.getZ() + z)).getBlock();
        Block Focus = world.getBlockState(new BlockPos(this.pos.getX(), this.pos.getY() + 1, this.pos.getZ())).getBlock();

        if (Focus != ModBlocks.PROJECTOR_FOCUS.get()) {
            invalid_block = true;
        }

        if (y == 0 && x != 0 ^ z != 0) {
            if (block != ModBlocks.QUANTUM_STEEL_BLOCK.get()) {
                invalid_block = true;
            }
        }
    }*/

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(ModBlocks.HOLOPROJECTOR.get().getTranslationKey());
    }

    @Nullable
    @Override
    public Container createMenu(int windowIn, PlayerInventory playerInv, PlayerEntity playerEntity) {
        return new HologramContainer(windowIn, playerInv, this);
    }
}
