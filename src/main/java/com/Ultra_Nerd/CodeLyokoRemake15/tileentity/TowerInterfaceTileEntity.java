package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.blocks.TowerInterface;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.TowerInterfaceContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.tutorial.OpenInventoryStep;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class TowerInterfaceTileEntity extends TileEntity implements INamedContainerProvider
{

	@Nullable // May be accessed before onLoad
	@OnlyIn(Dist.CLIENT)
	public TowerInterfaceTileEntity anInterface;
	protected int PlayersPresent;
	public TowerInterfaceTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public TowerInterfaceTileEntity() {
		super(ModTileEntities.TOWER_INTERFACE_TILE_ENTITY.get());
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
	 * @return
	 */
	@Override
	public ITextComponent getDisplayName() {
		return new TranslationTextComponent(ModBlocks.TOWER_INTERFACE.get().getTranslationKey());
	}

	/**
	 * Create a containder from interfaceTileEntity
	 *
	 * @param windowIn
	 * @param playerInv
	 * @param playerEntity
	 * @return
	 */
	@Nullable
	@Override
	public Container createMenu(int windowIn, PlayerInventory playerInv, PlayerEntity playerEntity) {
		return new TowerInterfaceContainer(windowIn, playerInv, this);
	}

	private void IntrfaceSound(SoundEvent sound)
	{
		double dx = (double)this.pos.getX() + 0.5D;
		double dy = (double)this.pos.getY() + 0.5D;
		double dz = (double)this.pos.getZ() + 0.5D;
		this.world.playSound((PlayerEntity)null,dx,dy,dz,sound, SoundCategory.BLOCKS,0.5f,this.world.rand.nextFloat() * 0.1f + 0.2f);
	}

	@Override
	public boolean receiveClientEvent(int id, int type) {
		if(id == 1)
		{
			this.PlayersPresent = type;
			return true;
		}
		else
		{
			return super.receiveClientEvent(id,type);
		}
	}
	protected void onActiveateOrDeactiveate() {
		Block block = this.getBlockState().getBlock();
		if (block instanceof TowerInterface)
		{
			this.world.addBlockEvent(this.pos,block,1,this.PlayersPresent);
			this.world.notifyNeighborsOfStateChange(this.pos,block);
		}
	}

	public static int getPlayersPresent(IBlockReader read, BlockPos pos)
	{
		BlockState state = read.getBlockState(pos);
		if(state.hasTileEntity())
		{
			TileEntity te = read.getTileEntity(pos);
			if(te instanceof TowerInterfaceTileEntity)
			{
				return ((TowerInterfaceTileEntity)te).PlayersPresent;
			}
		}

			return 0;

	}

}
