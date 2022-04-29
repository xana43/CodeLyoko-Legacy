package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.DimensionCheck;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
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

    @Shadow protected abstract PlayerEntity getCameraPlayer();

    @Shadow private int scaledWidth;

    @Shadow private int scaledHeight;

    @Shadow private int renderHealthValue;

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
                PlayerEntity playerEntity = this.getCameraPlayer();
                int i = MathHelper.ceil(playerEntity.getHealth());
                int j = this.renderHealthValue;
                float f = Math.max((float)playerEntity.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH), (float)Math.max(j, i));
                int u = playerEntity.getArmor();
                int m = this.scaledWidth / 2 - 91;
                int o = this.scaledHeight - 39;
                int p = MathHelper.ceil(playerEntity.getAbsorptionAmount());
                int q = MathHelper.ceil((f + (float)p) / 2.0F / 10.0F);
                int r = Math.max(10 - (q - 2), 3);
                int s = o - (q - 1) * r - 10;
                int t = o - 10;
                int v = -1;
                this.client.getProfiler().push("armor");

                int x;
                for(int w = 0; w < 10; ++w) {
                    if (u > 0) {
                        x = m + w * 8;
                        if (w * 2 + 1 < u) {
                            this.client.inGameHud.drawTexture(matrices, x, s, 34, 9, 9, 9);
                        }

                        if (w * 2 + 1 == u) {
                            this.client.inGameHud.drawTexture(matrices, x, s, 25, 9, 9, 9);
                        }

                        if (w * 2 + 1 > u) {
                            this.client.inGameHud.drawTexture(matrices, x, s, 16, 9, 9, 9);
                        }
                    }
                }
                this.client.getProfiler().pop();

            }
        }
    }
    @Inject(method = "renderStatusEffectOverlay",at = @At(value = "HEAD"),cancellable = true)
    public void test(final MatrixStack matrices, final CallbackInfo ci)
    {
        if(client.player != null) {
            if (DimensionCheck.playerNotInVanillaWorld(client.player)) {
                ci.cancel();
            }
        }

    }


}
