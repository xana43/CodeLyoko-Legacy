package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Recipies.TestRecipe;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers.CustomItemHandler;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.electroplate.ElectroplatingMachine;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ContainerElectroplate;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModRecipes;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ElectroplatingTileEntity extends TileEntity implements ITickable, INamedContainerProvider {
    private final int maxSmeltTime = 1000;
    private final CustomItemHandler inventory;
    public int currentTime;
    private boolean once = false;

    public ElectroplatingTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        this.inventory = new CustomItemHandler(2);
    }

    public ElectroplatingTileEntity() {
        this(ModTileEntities.ELECTROPLATING_TILE_ENTITY.get());
    }

    public static Set<IRecipe<?>> findRecipesByType(IRecipeType<?> type, World world) {
        return world != null ? world.getRecipeManager().getRecipes().stream()
                .filter(recipe -> recipe.getType() == type).collect(Collectors.toSet()) : Collections.emptySet();
    }

    @OnlyIn(Dist.CLIENT)
    public static Set<IRecipe<?>> findRecipesByType(IRecipeType<?> type) {
        ClientWorld world = Minecraft.getInstance().world;
        return world != null ? world.getRecipeManager().getRecipes().stream()
                .filter(recipe -> recipe.getType() == type).collect(Collectors.toSet()) : Collections.emptySet();
    }

    public static Set<ItemStack> getInputs(IRecipeType<?> type, World world) {
        Set<ItemStack> inputs = new HashSet<ItemStack>();
        Set<IRecipe<?>> recipes = findRecipesByType(type, world);
        for (IRecipe<?> recipe : recipes) {
            NonNullList<Ingredient> ingredients = recipe.getIngredients();
            ingredients.forEach(ingredient -> {
                for (ItemStack stack : ingredient.getMatchingStacks()) {
                    inputs.add(stack);
                }
            });
        }
        return inputs;
    }

    private static void activate() {

    }

    private static void deactivate() {

    }

    @Nullable
    private TestRecipe getRecipe(ItemStack stack) {
        if (stack == null) {
            return null;
        }
        Set<IRecipe<?>> recipes = findRecipesByType(ModRecipes.TYPE, this.world);
        for (IRecipe<?> Recipe : recipes) {
            TestRecipe recipe = (TestRecipe) Recipe;
            if (recipe.matches(new RecipeWrapper(this.inventory), this.world)) {
                return recipe;
            }
        }
        return null;
    }

    @Override
    public void tick() {
        boolean dirty = false;
        if (CheckStruct() && !once) {
            activate();
            once = true;
        } else if (!CheckStruct()) {
            once = false;
            deactivate();
        }
        if (this.world != null && !this.world.isRemote) {
            if (this.world.isBlockPowered(this.pos)) {
                if (this.getRecipe(this.inventory.getStackInSlot(0)) != null) {
                    if (this.currentTime != this.maxSmeltTime) {
                        this.world.setBlockState(this.getPos(), this.getBlockState().with(ElectroplatingMachine.ELECTRO_ACTIVE, true));
                        this.currentTime++;
                        dirty = true;
                    } else {
                        this.world.setBlockState(this.getPos(), this.getBlockState().with(ElectroplatingMachine.ELECTRO_ACTIVE, false));
                        this.currentTime = 0;
                        ItemStack output = this.getRecipe(this.inventory.getStackInSlot(0)).getRecipeOutput();
                        this.inventory.insertItem(1, output.copy(), false);
                        this.inventory.decrStackSize(0, 1);
                        dirty = true;
                    }
                }
            }
        }
        if (dirty) {
            this.markDirty();
            this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
        }
    }

    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return null;
    }

    @Nullable
    @Override
    public Container createMenu(final int windowID, @Nonnull final PlayerInventory playerInv, @Nonnull final PlayerEntity playerIn) {
        return new ContainerElectroplate(windowID, playerInv, this);
    }

    @Override
    public void read(@Nonnull CompoundNBT compound) {
        super.read(compound);
        NonNullList<ItemStack> inv = NonNullList.withSize(this.inventory.getSlots(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, inv);
        this.inventory.setNonNullList(inv);
        this.currentTime = compound.getInt("currentElectroTime");

    }

    @Nonnull
    @Override
    public CompoundNBT write(@Nonnull CompoundNBT compound) {
        super.write(compound);
        ItemStackHelper.saveAllItems(compound, this.inventory.toNonNullList());
        compound.putInt("currentElectroTime", this.currentTime);
        return compound;
    }

    public final IItemHandlerModifiable getInventory() {
        return this.inventory;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.orEmpty(cap, LazyOptional.of(() -> this.inventory));
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT nbt = new CompoundNBT();
        this.write(nbt);
        return new SUpdateTileEntityPacket(this.pos, 0, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        this.read(pkt.getNbtCompound());
    }

    @Nonnull
    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT nbt = new CompoundNBT();
        this.write(nbt);
        return nbt;
    }

    @Override
    public void handleUpdateTag(CompoundNBT nbt) {
        this.read(nbt);
    }

    //multiblock stuff
    private boolean CheckStruct() {

        if (this.getBlockState().get(ElectroplatingMachine.ELECTRO_FACING) == Direction.NORTH) {
            int[] locationX = {1, 2};
            int[] locationZ = {1, 2, 3};
            for (int I : locationX) {
                if (world.getBlockState(new BlockPos(this.getPos().getX() + I, this.getPos().getY(), this.getPos().getZ()))
                        == ModBlocks.ELECTROPLATING_MACHINE_FRAME.get().getBlock().getDefaultState()) {
                    if (world.getBlockState(new BlockPos(this.getPos().getX() - I, this.getPos().getY(), this.getPos().getZ())) ==
                            ModBlocks.ELECTROPLATING_MACHINE_FRAME.get().getDefaultState()) {
                        if (world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + I))
                                == ModBlocks.ELECTROPLATING_MACHINE_FRAME.get().getDefaultState()) {
                            if (world.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() - I)) ==
                                    ModBlocks.ELECTROPLATING_MACHINE_FRAME.get().getDefaultState()) {
                                Base.Log.debug("foprmed");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        Base.Log.debug("dead");
        return false;
    }


}
