package io.github.elsopeen.lyokomod.tileentity;

import io.github.elsopeen.lyokomod.client.render.Interface;
import io.github.elsopeen.lyokomod.container.InterfaceContainer;
import io.github.elsopeen.lyokomod.init.ModBlocks;
import io.github.elsopeen.lyokomod.init.ModTileEntityTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * TileEntity for interface block
 */
public class InterfaceTileEntity extends TileEntity implements INamedContainerProvider {
    /**
     *
     * @OnlyIn(Dist.CLIENT) Makes it so this field will be removed from the class on the PHYSICAL SERVER
     * This is because we only want the MiniModel on the physical client - its rendering only.
     */
    @Nullable // May be accessed before onLoad
    @OnlyIn(Dist.CLIENT)
    public Interface anInterface;

    public InterfaceTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public InterfaceTileEntity(){
        super(ModTileEntityTypes.INTERFACE.get());
    }

    // @OnlyIn(Dist.CLIENT) Makes it so this method will be removed from the class on the PHYSICAL SERVER
    // This is because we only want the Interface on the physical client - its rendering only.
    @OnlyIn(Dist.CLIENT)
    @Override
    public void onLoad() {
        super.onLoad();
        World world = getWorld();
        if (world == null || !world.isRemote)
            return; // Return if the world is null or if we are on the logical server
        anInterface = Interface.forTileEntity(this);
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        // This, combined with isGlobalRenderer in the TileEntityRenderer makes it so that the
        // render does not disappear if the player can't see the block
        // This is useful for rendering larger models or dynamically sized models
        return INFINITE_EXTENT_AABB;
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket(){
        CompoundNBT nbtTag = new CompoundNBT();
        //Write your data into the nbtTag
        return new SUpdateTileEntityPacket(getPos(), -1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt){
        CompoundNBT tag = pkt.getNbtCompound();
        //Handle your Data
    }

    /**
     *
     * @return name of the interface
     */
    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(ModBlocks.INTERFACE.get().getTranslationKey());
    }

    /**
     * Create a containder from interfaceTileEntity
     * @param windowIn ID of the window
     * @param playerInv Inventory of player opening the gui
     * @param playerEntity Player opening the gui
     * @return new container for gui
     */
    @Nullable
    @Override
    public Container createMenu(int windowIn, @Nonnull PlayerInventory playerInv,
                                @Nonnull PlayerEntity playerEntity) {
        return new InterfaceContainer(windowIn, playerInv, this);
    }
}
