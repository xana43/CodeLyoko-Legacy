package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Virutalization extends Block {

	public Virutalization() {
		super(Block.Properties.create(Material.IRON)

				.hardnessAndResistance(6, 20)
				.sound(SoundType.METAL)
				.lightValue(0)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)






		);

	}
/*
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		if(!worldin.isRemote)// TODO Auto-generated method stub
		{

			TeleportToDimension.teleportToDim(player, Conf.Dim, player.getPosition().getX(), player.getPosition().getY() + 5, player.getPosition().getZ());
			return true;

		}
		else return false;
	}

 */



}
