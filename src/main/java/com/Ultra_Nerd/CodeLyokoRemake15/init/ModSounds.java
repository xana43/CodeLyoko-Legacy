package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Base.MOD_ID);

    //for objects that load last
    public static final Lazy<SoundEvent> LAZY_THEME = Lazy.of(() -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "lyoko")));
    public static final Lazy<SoundEvent> LAZY_WARRIOR = Lazy.of(() -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "armor_equip_warrior")));
    public static final Lazy<SoundEvent> LAZY_FELINE = Lazy.of(() -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "armor_equip_feline")));
    public static final Lazy<SoundEvent> LAZY_NINJA = Lazy.of(() -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "armor_equip_ninja")));
    public static final Lazy<SoundEvent> LAZY_SAMURAI = Lazy.of(() -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "armor_equip_samurai")));
    public static final Lazy<SoundEvent> LAZY_GUARDIAN = Lazy.of(() -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "armor_equip_guardian")));
    public static final Lazy<SoundEvent> LAZY_ARCHER = Lazy.of(() -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "armor_equip_archer")));
    //for music discs
    public static final RegistryObject<MusicDiscItem> LYOKO_DISC = ModItems.ITEMS.register("lyokodisc", () -> new MusicDiscItem((byte) 10, LAZY_THEME, new Item.Properties().group(Base.LYOKO_ITEMS).maxStackSize(1).rarity(Rarity.RARE)));
    //for sound events
    public static final RegistryObject<SoundEvent> BLOKAMBIENT = SOUNDS.register("entity.blok.ambient", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "entity.blok.ambient")));
    public static final RegistryObject<SoundEvent> BLOKHURT = SOUNDS.register("entity.blok.hurt", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "entity.blok.hurt")));
    public static final RegistryObject<SoundEvent> FOREST = SOUNDS.register("forestsector", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "forestsector")));
    public static final RegistryObject<SoundEvent> GUISOUND = SOUNDS.register("gui", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "gui")));
    public static final RegistryObject<SoundEvent> ICE = SOUNDS.register("icesector", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "icesector")));
    public static final RegistryObject<SoundEvent> LASERARROW = SOUNDS.register("laser", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "laser")));
    public static final RegistryObject<SoundEvent> OCEAN = SOUNDS.register("digital_ocean", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "digital_ocean")));
    public static final RegistryObject<SoundEvent> QUANTUMZAP = SOUNDS.register("quantum_zap", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "quantum_zap")));
    public static final RegistryObject<SoundEvent> THEME = SOUNDS.register("lyoko", LAZY_THEME);
    public static final RegistryObject<SoundEvent> MEGATANKROLL = SOUNDS.register("entity.megatank.move", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "entity.megatank.move")));
    public static final RegistryObject<SoundEvent> MEGATANKHURT1 = SOUNDS.register("entity.megatank.hurt1", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "entity.megatank.hurt1")));
    public static final RegistryObject<SoundEvent> MEGATANKHURT2 = SOUNDS.register("entity.megatank.hurt2", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "entity.megatank.hurt2")));
    public static final RegistryObject<SoundEvent> MEGATANKBIGFALL = SOUNDS.register("entity.megatank.bigfall", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "entity.megatank.bigfall")));
    public static final RegistryObject<SoundEvent> MEGATANKSMALLFALL = SOUNDS.register("entity.megatank.smallfall", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "entity.megatank.smallfall")));
    public static final RegistryObject<SoundEvent> MEGATANKDIE = SOUNDS.register("entity.megatank.die", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "entity.megatank.die")));
    public static final RegistryObject<SoundEvent> HORNETFLY = SOUNDS.register("entity.hornet.fly", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "entity.hornet.fly")));
    public static final RegistryObject<SoundEvent> SECTOR5 = SOUNDS.register("sector5", () -> new SoundEvent(new ResourceLocation(Base.MOD_ID, "sector5")));
}
