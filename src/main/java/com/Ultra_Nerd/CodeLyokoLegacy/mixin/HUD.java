package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.DimensionCheck;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class HUD {


   // @Shadow protected abstract void renderHealthBar(final MatrixStack matrices, final PlayerEntity player, final int x, final int y, final int lines, final int regeneratingHeartIndex, final float maxHealth, final int lastHealth, final int health, final int absorption, final boolean blinking);

    //@Shadow protected abstract void renderHealthBar(final MatrixStack matrices, final PlayerEntity player, final int x, final int y, final int lines, final int regeneratingHeartIndex, final float maxHealth, final int lastHealth, final int health, final int absorption, final boolean blinking);

    @Shadow @Final private MinecraftClient client;

    @Inject(method = "renderHealthBar",at = @At(value = "HEAD"),cancellable = true)
    public void disableHealth(final MatrixStack matrices, final PlayerEntity player, final int x, final int y, final int lines, final int regeneratingHeartIndex, final float maxHealth, final int lastHealth, final int health, final int absorption, final boolean blinking, final CallbackInfo ci)
    {
        if(DimensionCheck.playerNotInVanillaWorld(player))
        {
            ci.cancel();
        }
    }
    @Inject(method = "renderStatusBars",at = @At(value = "HEAD"),cancellable = true)
    public void disableFood(final MatrixStack matrices, final CallbackInfo ci)
    {
        if(client.player != null)
        {
            if(DimensionCheck.playerNotInVanillaWorld(client.player))
            {
                ci.cancel();
            }
        }
    }


}
