package com.Ultra_Nerd.CodeLyokoRemake15.Records;

import java.util.Map;

import javax.annotation.Nullable;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.google.common.collect.Maps;

import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LyokoRecord extends Item 
{


	private static final ResourceLocation RECORD = new ResourceLocation(ref.MOD_ID + ":textures/items/dk.png");
	private final SoundEvent sound;
	private static final Map<SoundEvent, ItemRecord> RECORDSCUST = Maps.<SoundEvent, ItemRecord>newHashMap();

 public LyokoRecord(String recordName, SoundEvent sound)
 {
 super(recordName, sound);
this.sound = sound;
this.setUnlocalizedName(recordName);
this.setRegistryName(recordName);
this.maxStackSize = 1;
ModItems.Records.add(this);
RECORDSCUST.put(sound, this);
//ModItems.Items.add(this);
ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(RECORD, "inventory"));

 }
 

 
 

 
 @Nullable
 @SideOnly(Side.CLIENT)
 public static ItemRecord getBySound(SoundEvent soundIn)
 {
     return RECORDSCUST.get(soundIn);
 }
@Override
 @SideOnly(Side.CLIENT)
 public SoundEvent getSound()
 {
     return this.sound;
 }


}
