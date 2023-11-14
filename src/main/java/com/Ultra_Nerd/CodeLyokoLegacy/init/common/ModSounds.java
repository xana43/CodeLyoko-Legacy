package com.Ultra_Nerd.CodeLyokoLegacy.init.common;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;

public record ModSounds() {


    public static final SoundEvent BLOK_AMBIENT = registerSound("entity.blok.ambient");
    public static final SoundEvent BLOK_HURT = registerSound("entity.blok.hurt");
    public static final SoundEvent CURSOR_BLINK =registerSound("interface_cursor");
    public static final SoundEvent DESERT = registerSound("desertsector");
    public static final SoundEvent DEVIRTUALIZATION = registerSound("player" +
            ".devirtualization");
    public static final SoundEvent FOREST = registerSound("forestsector");
    public static final SoundEvent GUISOUND = registerSound("gui");
    public static final SoundEvent HORNETFLY = registerSound("entity.hornet.fly");
    public static final SoundEvent ICE = registerSound("icesector");
    public static final SoundEvent LASERARROW = registerSound("laser");
    public static final SoundEvent LAZY_ARCHER = registerSound("armor_equip_archer");
    public static final SoundEvent LAZY_FELINE = registerSound("armor_equip_feline");
    public static final SoundEvent LAZY_GUARDIAN = registerSound("armor_equip_guardian");
    public static final SoundEvent LAZY_NINJA = registerSound("armor_equip_ninja");
    public static final SoundEvent LAZY_SAMURAI = registerSound("armor_equip_samurai");
    public static final SoundEvent LAZY_WARRIOR = registerSound(
            "armor_equip_warrior");
    public static final SoundEvent LYOKO_THEME = registerSound("lyoko");
    public static final SoundEvent LYOKO_THEME_INSTRUMENTAL = registerSound("lyoko.instrumental");
    public static final SoundEvent MEGATANKHURT1 = registerSound("entity.megatank.hurt1");
    public static final SoundEvent MEGATANKHURT2 = registerSound("entity.megatank.hurt2");
    public static final SoundEvent MEGATANKROLL = registerSound("entity.megatank.move");
    public static final SoundEvent MEGATANKSMALLFALL = registerSound("entity.megatank.smallfall");
    public static final SoundEvent MEGATANK_BIG_FALL = registerSound("entity.megatank.bigfall");
    public static final SoundEvent MEGATANK_DIE = registerSound("entity.megatank.die");
    public static final SoundEvent MOUNTAIN = registerSound("mountainsector");
    public static final SoundEvent OCEAN = registerSound("digital_ocean");
    public static final SoundEvent OPENTOWERGUISOUND = registerSound("tower_gui_sound");
    public static final SoundEvent SECTOR5 = registerSound("sector5");
    public static final SoundEvent SWORDDRAW = registerSound("lyoko.weapon.sword.draw");
    public static final SoundEvent SWORDSLASH = registerSound("lyoko.weapon.sword.slash");
    public static final SoundEvent VOLCANO = registerSound("volcano_replika_music");


    private static SoundEvent registerSound(final String name)
    {
        final SoundEvent registeredSoundEvent = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix(name));
        return Registry.register(Registries.SOUND_EVENT, registeredSoundEvent.getId(), registeredSoundEvent);
    }

    private static SoundEvent registerSound(final String name,final float distanceToTravel)
    {
        final SoundEvent registeredSoundEvent = SoundEvent.of(CodeLyokoMain.codeLyokoPrefix(name),distanceToTravel);
        return Registry.register(Registries.SOUND_EVENT, registeredSoundEvent.getId(), registeredSoundEvent);
    }

    public static void registerSounds()
    {

    }



}
