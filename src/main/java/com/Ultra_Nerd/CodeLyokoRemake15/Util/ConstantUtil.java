package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.ClientMiscFunctions;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.enums.LyokoArmorMaterial;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.enums.LyokoTiers;
import net.minecraft.network.chat.Style;

public record ConstantUtil() {

    public static final LyokoArmorMaterial[] LYOKO_ARMOR_MATERIALS_VALUES = LyokoArmorMaterial.values();
    public static final LyokoTiers[] LYOKO_TIERS_VALUES = LyokoTiers.values();
    public static final ClientMiscFunctions.Screens[] CLIENT_SCREEN_VALUES = ClientMiscFunctions.Screens.values();
    public static final Style GUNSHIP = Style.EMPTY.withFont(CodeLyokoMain.CodeLyokoPrefix("gunship"));
    public static final Style HUD = Style.EMPTY.withFont(CodeLyokoMain.CodeLyokoPrefix("lyoko_hud_font"));
}
