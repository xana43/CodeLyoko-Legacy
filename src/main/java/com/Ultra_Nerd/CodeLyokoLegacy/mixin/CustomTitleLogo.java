package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import net.minecraft.client.gui.LogoDrawer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LogoDrawer.class)
public abstract class CustomTitleLogo {
    //@Final
    //@Shadow
    //public static final Identifier LOGO_TEXTURE = CodeLyokoMain.codeLyokoPrefix("textures/block/transparent.png");
}
