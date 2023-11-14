package com.Ultra_Nerd.CodeLyokoLegacy.HookEvents;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerClassType;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

public record HudRenderCallbackOverride() {
    private static final Identifier HUD_TEXTURE =CodeLyokoMain.codeLyokoPrefix("textures/gui/lyoko_health_bar.png");
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public static void consume(final DrawContext context,final float tickDelta)
    {
        //if(mc != null) {
        if (mc.player != null) {
            if (MethodUtil.DimensionCheck.isPlayerInLyoko(mc.player)) {
                RenderSystem.setShaderTexture(0, HUD_TEXTURE);
                if (!mc.player.isCreative() && !mc.player.isSpectator()) {
                    context.drawTexture( HUD_TEXTURE, (mc.getWindow().getScaledWidth() >> 7) - 2,
                            mc.getWindow().getScaledHeight() >> 11, 0, 0, 33
                            , 254);

                    context.drawTexture(HUD_TEXTURE, mc.getWindow().getScaledWidth() >> 4,
                            mc.getWindow().getScaledHeight() >> 11, 174, 0, 6, 254);
                    int textureXOffset = 0;
                    switch (CardinalData.LyokoClass.getLyokoClass(mc.player)) {
                        case 0 -> textureXOffset = PlayerClassType.Feline.getTextureIndex();
                        case 1 -> textureXOffset = PlayerClassType.Samurai.getTextureIndex();
                        case 2 -> textureXOffset = PlayerClassType.Ninja.getTextureIndex();
                        case 3 -> textureXOffset = PlayerClassType.Guardian.getTextureIndex();
                    }
                    context.drawTexture(HUD_TEXTURE, (mc.getWindow().getScaledWidth() >> 6) - 1,
                            (mc.getWindow().getScaledHeight() >> 11), textureXOffset, 0, 25,
                            (int) ((mc.getWindow().getScaledHeight() >> 5) * (mc.player.getHealth() * 1.6f)));
                    context.drawTexture(HUD_TEXTURE, mc.getWindow().getScaledWidth() >> 4,
                            mc.getWindow().getScaledHeight() >> 11, 183, 0, 6,
                            (CardinalData.DigitalEnergyComponent.getCurrentEnergy(mc.player)) << 1);

                }


            }
        }
        // }
    }
}
