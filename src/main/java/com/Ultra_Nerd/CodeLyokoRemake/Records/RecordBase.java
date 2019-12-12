package com.Ultra_Nerd.CodeLyokoRemake.Records;

import java.util.Map;

import javax.annotation.Nullable;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.google.common.collect.Maps;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;
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
ModItems.Records.add(this);
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
