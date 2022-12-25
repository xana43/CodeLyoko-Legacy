package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MultiBlock.MasterEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;


public final class HologramProjectorTileEntity extends BlockEntity implements MasterEntity //implements InventoryTickingBlockEntity<HologramProjectorTileEntity>//, INamedContainerProvider
{
    public HologramProjectorTileEntity(@NotNull BlockEntityType<?> p_155228_, @NotNull BlockPos p_155229_, @NotNull BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    @Override
    public void check() {

    }

    @Override
    public void invalidateEntity() {

    }


    /*
    private boolean once = false;
    //private boolean invalid_block = false;
    //private int x, y, z;
    //boolean once = false;
    //private List<BlockState> stateList;

    public HologramProjectorTileEntity(BlockEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public HologramProjectorTileEntity() {
        this(ModTileEntities.HOLOGRAM_TILE_ENTITY.get());
    }

    private BlockPos focus;


    @Override
    public void tick(Level p_155253_, BlockPos p_155254_, BlockState p_155255_, HologramProjectorTileEntity p_155256_) {
        focus = new BlockPos(this.getPos().getX(), this.getPos().getY() + 1, this.getPos().getZ());
        // Validate the boolean properties to change the models
        if (checkStructure() && !once) {
            // Projector blocks
            getWorld().setBlockState(this.getPos(), getWorld().getBlockState(getPos()).with(HologramProjectorBlock.VALID, true));
            // Lens/Focus
            getWorld().setBlockState(focus, getWorld().getBlockState(focus).with(ProjectorFocusblock.VALIDFOCUS, true));
            // Quantum Steel blocks
            BlockPos steel_1, steel_2, steel_3, steel_4, steel_5;
            for (int i : new int[]{-1, 1}) {
                steel_1 = new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ());
                steel_2 = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + i);
                steel_3 = new BlockPos(this.getPos().getX() + i, this.getPos().getY() - 1, this.getPos().getZ());
                steel_4 = new BlockPos(this.getPos().getX(), this.getPos().getY() - 1, this.getPos().getZ() + i);
                steel_5 = new BlockPos(this.getPos().getX(), this.getPos().getY() - 1, this.getPos().getZ());
                getWorld().setBlockState(steel_1, getWorld().getBlockState(steel_1).with(QuantumSteelBlock.formed, true));
                getWorld().setBlockState(steel_2, getWorld().getBlockState(steel_2).with(QuantumSteelBlock.formed, true));
                getWorld().setBlockState(steel_3, getWorld().getBlockState(steel_3).with(QuantumSteelBlock.formed, true));
                getWorld().setBlockState(steel_4, getWorld().getBlockState(steel_4).with(QuantumSteelBlock.formed, true));
                getWorld().setBlockState(steel_5, getWorld().getBlockState(steel_5).with(QuantumSteelBlock.formed, true));
            }

            once = true;
            //useUran();
        } else if (!checkStructure()) {
            once = false;
            if (getWorld().getBlockState(this.getPos()).getBlock() == ModBlocks.HOLOPROJECTOR.get()) {
                getWorld().setBlockState(this.getPos(), getWorld().getBlockState(getPos()).with(HologramProjectorBlock.VALID, false));
            }
            if (getWorld().getBlockState(focus).getBlock() == ModBlocks.PROJECTOR_FOCUS.get()) {
                getWorld().setBlockState(focus, getWorld().getBlockState(focus).with(ProjectorFocusblock.VALIDFOCUS, false));
            }
            BlockPos steel, steelcenter;
            for (int i : new int[]{-1, 1}) {
                steel = new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ());
                if (getWorld().getBlockState(steel).getBlock() == ModBlocks.QUANTUM_STEEL_BLOCK.get()) {
                    getWorld().setBlockState(steel, getWorld().getBlockState(steel).with(QuantumSteelBlock.formed, false));
                }
            }
            for (int j : new int[]{-1, 1}) {
                steel = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + j);
                if (getWorld().getBlockState(steel).getBlock() == ModBlocks.QUANTUM_STEEL_BLOCK.get()) {
                    getWorld().setBlockState(steel, getWorld().getBlockState(steel).with(QuantumSteelBlock.formed, false));
                }
            }
            for (int j : new int[]{-1, 1}) {
                steel = new BlockPos(this.getPos().getX(), this.getPos().getY() - 1, this.getPos().getZ() + j);
                if (getWorld().getBlockState(steel).getBlock() == ModBlocks.QUANTUM_STEEL_BLOCK.get()) {
                    getWorld().setBlockState(steel, getWorld().getBlockState(steel).with(QuantumSteelBlock.formed, false));
                }
            }
            for (int i : new int[]{-1, 1}) {
                steel = new BlockPos(this.getPos().getX() + i, this.getPos().getY() - 1, this.getPos().getZ());
                if (getWorld().getBlockState(steel).getBlock() == ModBlocks.QUANTUM_STEEL_BLOCK.get()) {
                    getWorld().setBlockState(steel, getWorld().getBlockState(steel).with(QuantumSteelBlock.formed, false));
                }
            }
            steelcenter = new BlockPos(new BlockPos(this.getPos().getX(), this.getPos().getY() - 1, this.getPos().getZ()));
            if (getWorld().getBlockState(steelcenter).getBlock() == ModBlocks.QUANTUM_STEEL_BLOCK.get()) {
                getWorld().setBlockState(steelcenter, getWorld().getBlockState(steelcenter).with(QuantumSteelBlock.formed, false));
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
        int[] data = {-1, 1};
        for (int i : data) {
            Block side = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY(), this.getPos().getZ())).getBlock();
            Block side2 = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + i)).getBlock();
            Block sidebelow = world.getBlockState(new BlockPos(this.getPos().getX() + i, this.getPos().getY() - 1, this.getPos().getZ())).getBlock();
            Block sidebelow2 = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() - 1, this.getPos().getZ() + i)).getBlock();
            Block middlebelow = world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() - 1, this.getPos().getZ())).getBlock();
            if (side != ModBlocks.QUANTUM_STEEL_BLOCK.get() || side2 != ModBlocks.QUANTUM_STEEL_BLOCK.get() || sidebelow != ModBlocks.QUANTUM_STEEL_BLOCK.get()
                    || sidebelow2 != ModBlocks.QUANTUM_STEEL_BLOCK.get() || middlebelow != ModBlocks.QUANTUM_STEEL_BLOCK.get()) {
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

        Block blocks = world.getBlockState(new BlockPos(this.pos.getX() + x, this.pos.getY() + y, this.pos.getZ() + z)).getBlock();
        Block Focus = world.getBlockState(new BlockPos(this.pos.getX(), this.pos.getY() + 1, this.pos.getZ())).getBlock();

        if (Focus != ModBlocks.PROJECTOR_FOCUS.get()) {
            invalid_block = true;
        }

        if (y == 0 && x != 0 ^ z != 0) {
            if (blocks != ModBlocks.QUANTUM_STEEL_BLOCK.get()) {
                invalid_block = true;
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
    }*/
}
