package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.client.gui.LogoDrawer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LogoDrawer.class)
public class CustomTitleLogo {
    @Final
    @Shadow
    public static final Identifier LOGO_TEXTURE = CodeLyokoMain.codeLyokoPrefix("textures/block/transparent.png");
}
