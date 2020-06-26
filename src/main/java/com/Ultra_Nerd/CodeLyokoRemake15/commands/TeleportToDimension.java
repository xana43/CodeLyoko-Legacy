package com.Ultra_Nerd.CodeLyokoRemake15.commands;

import net.minecraft.world.Teleporter;
import net.minecraft.world.server.ServerWorld;

public class TeleportToDimension extends Teleporter
{
	public TeleportToDimension(ServerWorld worldIn) {
		super(worldIn);
	}
/*
	private final WorldServer world;
	private double x,y,z;
	
	public TeleportToDimension(WorldServer world, double x, double y, double z)
	{
		super(world);
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
 public void placeInPortal(Entity entityin, float rotationYaw)
	{
	this.world.getBlockState(new BlockPos((int)this.x, (int) this.y, (int) this.z));
	entityin.setPosition(x, y, y);
	entityin.motionX = 0f;
	entityin.motionY = 0f;
	entityin.motionZ = 0f;
	}
	public static void teleportToDim(EntityPlayer player, int dim, double x, double y, double z)
	{
		int oldDimension = player.getEntityWorld().provider.getDimension();
		EntityPlayerMP entityplayermp = (EntityPlayerMP) player;
		MinecraftServer server = player.getEntityWorld().getMinecraftServer();
		WorldServer worldServer = server.getWorld(dim);
		
		if (worldServer == null || server == null) throw new IllegalArgumentException("Dimension:" + dim + "doesn't exist");
		worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityplayermp, dim, new TeleportToDimension(worldServer, x, y + 5, z));
		player.setPositionAndUpdate(x, y + 5, z);
		
	}

 */
}
