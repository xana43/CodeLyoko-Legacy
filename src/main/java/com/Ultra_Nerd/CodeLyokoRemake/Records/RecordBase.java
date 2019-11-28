package com.Ultra_Nerd.CodeLyokoRemake.Records;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.Ultra_Nerd.CodeLyokoRemake.Base;
import com.Ultra_Nerd.CodeLyokoRemake.Util.IHasModel;
import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.google.common.collect.Maps;

import net.minecraft.block.BlockJukebox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RecordBase extends ItemRecord 
{



	private final SoundEvent sound;
	private static final Map<SoundEvent, ItemRecord> RECORDS = Maps.<SoundEvent, ItemRecord>newHashMap();

 public RecordBase(String recordName, SoundEvent sound)
 {
 super(recordName, sound);
this.sound = sound;
this.setUnlocalizedName(recordName);
this.setRegistryName(recordName);
 this.maxStackSize = 1;
//ModItems.recs.add(this);
RECORDS.put(sound, this);
 

 
 }
 @Nullable
 @SideOnly(Side.CLIENT)
 public static ItemRecord getBySound(SoundEvent soundIn)
 {
     return RECORDS.get(soundIn);
 }
@Override
 @SideOnly(Side.CLIENT)
 public SoundEvent getSound()
 {
     return this.sound;
 }


}
