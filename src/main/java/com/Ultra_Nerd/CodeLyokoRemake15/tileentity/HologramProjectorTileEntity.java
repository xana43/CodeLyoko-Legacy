package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.blocks.HologramProjectorBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.ProjectorFocusblock;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.HologramContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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


public class HologramProjectorTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
    public static boolean valid = false;
    private boolean OOOF = false;
    private int x,y,z;
    boolean once = false;
    private List<BlockState> stateList;
    public HologramProjectorTileEntity(TileEntityType<?> tileEntityTypeIn) {

        super(tileEntityTypeIn);
    }

public HologramProjectorTileEntity()
{
        super(ModTileEntities.HOLOGRAM_TILE_ENTITY.get());
}


    @Override
    public void tick() {

        boolean onceback = false;


        checkstruct();
        once = false;
        if (valid) {

            Block blockState = world.getBlockState(new BlockPos(this.pos.getX(), this.pos.getY() + 1, this.pos.getZ())).getBlock();






            if (blockState == ModBlocks.PROJECTOR_FOCUS.get() && !once) {

                ProjectorFocusblock.SetModelFocus(true, this.world, new BlockPos(this.pos.getX(),this.pos.getY() + 1,this.pos.getZ()));
                HologramProjectorBlock.SetModel(true, this.world, this.pos);
               // QuantumSteel.SetModel(true,this.world,new BlockPos(this.pos.getX() + 1, this.pos.getY(),this.pos.getZ()));

                once = true;
            }
            //useUran();

        } else {

            HologramProjectorBlock.SetModel(false, this.world, this.pos);
            if(this.world.getBlockState(new BlockPos(this.pos.getX(),this.pos.getY() + 1,this.pos.getZ())) == ModBlocks.PROJECTOR_FOCUS.get().getDefaultState())
            {
                ProjectorFocusblock.SetModelFocus(false, this.world, new BlockPos(this.pos.getX(), this.pos.getY() + 1, this.pos.getZ()));
            }

            }

        }


    private void checkstruct() {

        x++;
        if (x > 1) {
            x = -1;
            y++;
            if (y > 0) {
                y = -1;
                z++;
                if (z > 1) {
                    z = -1;
                    valid = !OOOF ;
                    OOOF = false;

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

                OOOF = true;

        }




        if (y == 0 && x != 0 ^ z != 0) {
            TileEntity te = world.getTileEntity(new BlockPos(this.pos.getX() + x, this.pos.getY() + y, this.pos.getZ() + z));
            //TileEntity te2 = world.getTileEntity(new BlockPos(this.pos.getX() + x, this.pos.getY() + y, this.pos.getZ() + z));


            if (block != ModBlocks.QUANTUM_STEEL.get()) {
                OOOF = true;
            }

        }
    }

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
