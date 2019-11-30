package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Conf;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Souinds;
import com.Ultra_Nerd.CodeLyokoRemake.commands.tele;
import com.Ultra_Nerd.CodeLyokoRemake.world.biome.LyokoFS;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Virutalization extends blockBase {

	public Virutalization(String name, Material material) {
		super(name, material);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onBlockActivated(World worldin, BlockPos pos, IBlockState state, EntityPlayer playerin, EnumHand hand, EnumFacing facing, float x, float y, float z)
	{	
		

		if(!worldin.isRemote)// TODO Auto-generated method stub
		{
			
			tele.teleportToDim(playerin, Conf.Dim, playerin.getPosition().getX(), playerin.getPosition().getY() + 5, playerin.getPosition().getZ());
			return true;
			
		}
		else return false;
	}

}
