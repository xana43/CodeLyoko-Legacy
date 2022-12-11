package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.sound.SoundEvent;

public record ModSounds() {


    public static final SoundEvent LAZY_WARRIOR = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("armor_equip_warrior"));
    public static final SoundEvent LAZY_FELINE = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("armor_equip_feline"));
    public static final SoundEvent LAZY_NINJA = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("armor_equip_ninja"));
    public static final SoundEvent LAZY_SAMURAI = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("armor_equip_samurai"));
    public static final SoundEvent LAZY_GUARDIAN = new SoundEvent(
            CodeLyokoMain.codeLyokoPrefix("armor_equip_guardian"));
    public static final SoundEvent LAZY_ARCHER = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("armor_equip_archer"));
    public static final SoundEvent SECTOR5 = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("sector5"));
    public static final SoundEvent BLOKAMBIENT = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("entity.blok.ambient"));
    public static final SoundEvent BLOKHURT = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("entity.blok.hurt"));
    public static final SoundEvent GUISOUND = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("gui"));
    public static final SoundEvent LASERARROW = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("laser"));
    public static final SoundEvent ICE = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("icesector"));
    public static final SoundEvent DESERT = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("desertsector"));
    public static final SoundEvent FOREST = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("forestsector"));
    public static final SoundEvent MOUNTAIN = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("mountainsector"));
    public static final SoundEvent OCEAN = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("digital_ocean"));
    public static final SoundEvent VOLCANO = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("volcano_replika_music"));
    public static final SoundEvent OPENTOWERGUISOUND = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("tower_gui_sound"));
    public static final SoundEvent SWORDDRAW = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("lyoko.weapon.sword.draw"));
    public static final SoundEvent SWORDSLASH = new SoundEvent(
            CodeLyokoMain.codeLyokoPrefix("lyoko.weapon.sword.slash"));
    public static final SoundEvent MEGATANKROLL = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("entity.megatank.move"));
    public static final SoundEvent MEGATANKHURT1 = new SoundEvent(
            CodeLyokoMain.codeLyokoPrefix("entity.megatank.hurt1"));
    public static final SoundEvent MEGATANKHURT2 = new SoundEvent(
            CodeLyokoMain.codeLyokoPrefix("entity.megatank.hurt2"));
    public static final SoundEvent MEGATANKBIGFALL = new SoundEvent(
            CodeLyokoMain.codeLyokoPrefix("entity.megatank.bigfall"));
    public static final SoundEvent MEGATANKSMALLFALL = new SoundEvent(
            CodeLyokoMain.codeLyokoPrefix("entity.megatank.smallfall"));
    public static final SoundEvent MEGATANKDIE = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("entity.megatank.die"));
    public static final SoundEvent CURSORBLINK = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("interface_cursor"));
    public static final SoundEvent HORNETFLY = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("entity.hornet.fly"));

    public static final SoundEvent LYOKO_THEME = new SoundEvent(CodeLyokoMain.codeLyokoPrefix("lyoko"));
    //public static final BlockSoundGroup TowerInterfaceSound = new BlockSoundGroup();
    public static final SoundEvent[] SOUNDS = new SoundEvent[]{
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
            LYOKO_THEME

    };

/*
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CodeLyokoMain.MOD_ID);
    public static final HashMap<ResourceKey<Level>,Lazy<Music>> LAZY_HASH_MAP = new HashMap<>();

    //for objects that load last
    public static final Lazy<SoundEvent> LAZY_THEME = RegisterLazyDuplicateSounds("lyoko",CodeLyokoMain.CodeLyokoPrefix("lyoko"));
    public static final Lazy<SoundEvent> LAZY_WARRIOR = Lazy.of(() -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "armor_equip_warrior")));
    public static final Lazy<SoundEvent> LAZY_FELINE = Lazy.of(() -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "armor_equip_feline")));
    public static final Lazy<SoundEvent> LAZY_NINJA = Lazy.of(() -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "armor_equip_ninja")));
    public static final Lazy<SoundEvent> LAZY_SAMURAI = Lazy.of(() -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "armor_equip_samurai")));
    public static final Lazy<SoundEvent> LAZY_GUARDIAN = Lazy.of(() -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "armor_equip_guardian")));
    public static final Lazy<SoundEvent> LAZY_ARCHER = Lazy.of(() -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "armor_equip_archer")));
    public static final Lazy<Music> LAZY_SECTOR5 = RegisterThemeSounds("sector5",CodeLyokoMain.CodeLyokoPrefix("sector5"));
    public static final Lazy<Music> LAZY_FOREST = RegisterThemeSounds("forest",CodeLyokoMain.CodeLyokoPrefix("forestsector"));
    public static final Lazy<Music> LAZY_DESERT = RegisterThemeSounds("desertsector",CodeLyokoMain.CodeLyokoPrefix("desertsector"));
    public static final Lazy<Music> LAZY_ICE = RegisterThemeSounds("icesector",CodeLyokoMain.CodeLyokoPrefix("icesector"));
    public static final Lazy<Music> LAZY_OCEAN = RegisterThemeSounds("digital_ocean",CodeLyokoMain.CodeLyokoPrefix("digital_ocean"));
    public static final Lazy<Music> LAZY_VOLCANO = RegisterThemeSounds("volcano_replika_music",CodeLyokoMain.CodeLyokoPrefix("volcano_replika_music"));
    public static final Lazy<Music> LAZY_MOUNTAIN = RegisterThemeSounds("mountainsector",CodeLyokoMain.CodeLyokoPrefix("mountainsector"));
    //for music discs
    public static final RegistryObject<RecordItem> LYOKO_DISC = ModItems.ITEMS.register("lyokodisc", () -> new RecordItem((byte) 10, LAZY_THEME, new Item.Properties().tab(CodeLyokoMain.LYOKO_ITEMS).stacksTo(1).rarity(Rarity.RARE)));
    //for sound events


    public static final RegistryObject<SoundEvent> BLOKAMBIENT = SOUNDS.register("entity.blok.ambient", () -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "entity.blok.ambient")));
    public static final RegistryObject<SoundEvent> BLOKHURT = SOUNDS.register("entity.blok.hurt", () -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "entity.blok.hurt")));

    public static final RegistryObject<SoundEvent> OPENTOWERGUISOUND = SOUNDS.register("tower_gui_sound", () -> new SoundEvent(CodeLyokoMain.CodeLyokoPrefix("tower_gui_sound")));

    public static final RegistryObject<SoundEvent> LASERARROW = SOUNDS.register("laser", () -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "laser")));
    public static final RegistryObject<SoundEvent> QUANTUMZAP = SOUNDS.register("quantum_zap", () -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "quantum_zap")));
    public static final RegistryObject<SoundEvent> MEGATANKROLL = SOUNDS.register("entity.megatank.move", () -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "entity.megatank.move")));
    public static final RegistryObject<SoundEvent> MEGATANKHURT1 = SOUNDS.register("entity.megatank.hurt1", () -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "entity.megatank.hurt1")));
    public static final RegistryObject<SoundEvent> MEGATANKHURT2 = SOUNDS.register("entity.megatank.hurt2", () -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "entity.megatank.hurt2")));
    public static final RegistryObject<SoundEvent> MEGATANKBIGFALL = SOUNDS.register("entity.megatank.bigfall", () -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "entity.megatank.bigfall")));
    public static final RegistryObject<SoundEvent> MEGATANKSMALLFALL = SOUNDS.register("entity.megatank.smallfall", () -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "entity.megatank.smallfall")));
    public static final RegistryObject<SoundEvent> MEGATANKDIE = SOUNDS.register("entity.megatank.die", () -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID, "entity.megatank.die")));

    public static final RegistryObject<SoundEvent> DEVIRTUALIZATION = SOUNDS.register("devertualization", () -> new SoundEvent(new ResourceLocation(CodeLyokoMain.MOD_ID,"player.devertualization")));

    //required for the correct background music to be played in each dimension(See CodeLyokoMain.Java)
    public static void populateMusicHashMap()
    {

        LAZY_HASH_MAP.put(ModDimensions.SECTOR5,LAZY_SECTOR5);
        LAZY_HASH_MAP.put(ModDimensions.DESERT,LAZY_DESERT);
        LAZY_HASH_MAP.put(ModDimensions.ICE,LAZY_ICE);
        LAZY_HASH_MAP.put(ModDimensions.DIGITAL_OCEAN,LAZY_OCEAN);
        LAZY_HASH_MAP.put(ModDimensions.FOREST,LAZY_FOREST);
        LAZY_HASH_MAP.put(ModDimensions.VOLCANO,LAZY_VOLCANO);
        LAZY_HASH_MAP.put(ModDimensions.MOUNTAIN,LAZY_MOUNTAIN);

    }
    //methods that streamline the Lazy sound event creation process
    private static @NotNull Lazy<Music> RegisterThemeSounds(@NotNull String registryName, @NotNull ResourceLocation location)
    {
        SoundEvent tmpEvent = new SoundEvent(location);
        SOUNDS.register(registryName, () -> tmpEvent);
        return Lazy.of(()->new Music(tmpEvent,0,0,true));
    }
    private static @NotNull Lazy<SoundEvent> RegisterLazyDuplicateSounds(@NotNull String registryName, @NotNull ResourceLocation location)
    {
        SoundEvent tmpEvent = new SoundEvent(location);
        SOUNDS.register(registryName, () -> tmpEvent);
        return Lazy.of(()-> tmpEvent);
    }

 */

}
