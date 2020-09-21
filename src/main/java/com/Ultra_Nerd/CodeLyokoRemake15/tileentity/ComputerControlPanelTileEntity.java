package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.blocks.tower.TowerInterface;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ComputerControlPanelContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ComputerControlPanelTileEntity extends TileEntity implements INamedContainerProvider, ITickableTileEntity {

    @Nullable // May be accessed before onLoad
    @OnlyIn(Dist.CLIENT)
    public ComputerControlPanelTileEntity anInterface;
    protected int PlayersPresent;

    public ComputerControlPanelTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ComputerControlPanelTileEntity() {
        this(ModTileEntities.COMPUTER_CONTROL_PLANEL_TILE_ENTITY.get());
    }

    // @OnlyIn(Dist.CLIENT) Makes it so this method will be removed from the class on the PHYSICAL SERVER
    // This is because we only want the Interface on the physical client - its rendering only.
	/*@OnlyIn(Dist.CLIENT)
	@Override
	public void onLoad() {
		super.onLoad();
		World world = getWorld();
		if (world == null || !world.isRemote)
			return; // Return if the world is null or if we are on the logical server
		anInterface = TowerInterfaceTileEntity.forTileEntity(this);
	}

	 */


    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        // This, combined with isGlobalRenderer in the TileEntityRenderer makes it so that the
        // render does not disappear if the player can't see the block
        // This is useful for rendering larger models or dynamically sized models
        return INFINITE_EXTENT_AABB;
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT nbtTag = new CompoundNBT();
        //Write your data into the nbtTag
        return new SUpdateTileEntityPacket(getPos(), -1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        CompoundNBT tag = pkt.getNbtCompound();
        //Handle your Data
    }

    /**
     * @return display name of the interface
     */
    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(ModBlocks.COMPUTER_TOWER_CONTROL_PANEL.get().getTranslationKey());
    }

    /**
     * Create a containder from interfaceTileEntity
     *
     * @param windowIn     Id of GUI
     * @param playerInv    Inventory of interacting player
     * @param playerEntity PlayerEntity of interacting player
     * @return Gui container
     */
    @Nullable
    @Override
    public Container createMenu(int windowIn, @Nonnull PlayerInventory playerInv, @Nonnull PlayerEntity playerEntity) {
        return new ComputerControlPanelContainer(windowIn, playerInv, this);
    }



    @Override
    public boolean receiveClientEvent(int id, int type) {
        if (id == 1) {
            this.PlayersPresent = type;
            return true;
        } else {
            return super.receiveClientEvent(id, type);
        }
    }

    protected void onActiveateOrDeactiveate() {
        Block block = this.getBlockState().getBlock();
        if (block instanceof TowerInterface) {
            this.world.addBlockEvent(this.pos, block, 1, this.PlayersPresent);
            this.world.notifyNeighborsOfStateChange(this.pos, block);
        }
    }

    public static int getPlayersPresent(IBlockReader read, BlockPos pos) {
        BlockState state = read.getBlockState(pos);
        if (state.hasTileEntity()) {
            TileEntity te = read.getTileEntity(pos);
            if (te instanceof ComputerControlPanelTileEntity) {
                return ((ComputerControlPanelTileEntity) te).PlayersPresent;
            }
        }

        return 0;

    }

    @Override
    public void tick() {

    }
}
