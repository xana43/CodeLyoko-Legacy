package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.sound.SoundEvent;

public record ModSounds() {


    public static final SoundEvent LAZY_WARRIOR = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix(
            "armor_equip_warrior"));
    public static final SoundEvent LAZY_FELINE = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("armor_equip_feline"));
    public static final SoundEvent LAZY_NINJA = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("armor_equip_ninja"));
    public static final SoundEvent LAZY_SAMURAI = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("armor_equip_samurai"));
    public static final SoundEvent LAZY_GUARDIAN = SoundEvent.of(
            CodeLyokoMain.codeLyokoPrefix("armor_equip_guardian"));
    public static final SoundEvent LAZY_ARCHER = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("armor_equip_archer"));
    public static final SoundEvent SECTOR5 = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("sector5"));
    public static final SoundEvent BLOKAMBIENT = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("entity.blok.ambient"));
    public static final SoundEvent BLOKHURT = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("entity.blok.hurt"));
    public static final SoundEvent GUISOUND = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("gui"));
    public static final SoundEvent LASERARROW = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("laser"));
    public static final SoundEvent ICE = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("icesector"));
    public static final SoundEvent DESERT = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("desertsector"));
    public static final SoundEvent FOREST = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("forestsector"));
    public static final SoundEvent MOUNTAIN = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("mountainsector"));
    public static final SoundEvent OCEAN = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("digital_ocean"));
    public static final SoundEvent VOLCANO = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("volcano_replika_music"));
    public static final SoundEvent OPENTOWERGUISOUND = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("tower_gui_sound"));
    public static final SoundEvent SWORDDRAW = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("lyoko.weapon.sword.draw"));
    public static final SoundEvent SWORDSLASH = SoundEvent.of(
            CodeLyokoMain.codeLyokoPrefix("lyoko.weapon.sword.slash"));
    public static final SoundEvent MEGATANKROLL = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("entity.megatank.move"));
    public static final SoundEvent MEGATANKHURT1 = SoundEvent.of(
            CodeLyokoMain.codeLyokoPrefix("entity.megatank.hurt1"));
    public static final SoundEvent MEGATANKHURT2 = SoundEvent.of(
            CodeLyokoMain.codeLyokoPrefix("entity.megatank.hurt2"));
    public static final SoundEvent MEGATANKBIGFALL = SoundEvent.of(
            CodeLyokoMain.codeLyokoPrefix("entity.megatank.bigfall"));
    public static final SoundEvent MEGATANKSMALLFALL = SoundEvent.of(
            CodeLyokoMain.codeLyokoPrefix("entity.megatank.smallfall"));
    public static final SoundEvent MEGATANKDIE = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("entity.megatank.die"));
    public static final SoundEvent CURSORBLINK = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("interface_cursor"));
    public static final SoundEvent HORNETFLY = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("entity.hornet.fly"));

    public static final SoundEvent LYOKO_THEME = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("lyoko"));
    public static final SoundEvent DEVIRTUALIZATION = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix("player" +
            ".devertualization"));
    //public static final BlockSoundGroup TowerInterfaceSound = BlockSoundGroup();
    public static final SoundEvent[] SOUNDS = {
            OPENTOWERGUISOUND,
            LAZY_WARRIOR,
            LAZY_FELINE,
            LAZY_NINJA,
            LAZY_GUARDIAN,
            SECTOR5,
            BLOKAMBIENT,
            BLOKHURT,
            LAZY_ARCHER,
            GUISOUND,
            LASERARROW,
            ICE,
            DESERT,
            FOREST,
            MOUNTAIN,
            OCEAN,
            VOLCANO,
            SWORDDRAW,
            SWORDSLASH,
            MEGATANKROLL,
            MEGATANKHURT1,
            MEGATANKHURT2,
            MEGATANKDIE,
            MEGATANKSMALLFALL,
            MEGATANKBIGFALL,
            CURSORBLINK,
            HORNETFLY,
            LYOKO_THEME,
            DEVIRTUALIZATION

    };



}
