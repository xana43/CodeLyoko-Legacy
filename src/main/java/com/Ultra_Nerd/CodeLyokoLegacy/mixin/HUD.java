package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MixinHooks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
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

    @Shadow
    @Final
    private MinecraftClient client;
    @Shadow
    private int scaledWidth;
    @Shadow
    private int scaledHeight;
    @Shadow
    private int renderHealthValue;


    @Shadow
    protected abstract PlayerEntity getCameraPlayer();

    @Shadow @Final private static Identifier ARMOR_FULL_TEXTURE;

    @Shadow @Final private static Identifier ARMOR_HALF_TEXTURE;

    @Shadow @Final private static Identifier ARMOR_EMPTY_TEXTURE;

    @Inject(method = "renderHealthBar", at = @At(value = "HEAD"), cancellable = true)
    public void codelyoko$disableHealth(final DrawContext matrices, final PlayerEntity player, final int x, final int y,
            final int lines,
            final int regeneratingHeartIndex, final float maxHealth, final int lastHealth, final int health, final int absorption, final boolean blinking, final CallbackInfo ci) {
        MixinHooks.PlayerEvents.cancelPlayerEvents(client,ci);
    }

    @Inject(method = "renderStatusBars", at = @At(value = "HEAD"), cancellable = true)
    public void codelyoko$disableFood(final DrawContext matrices, final CallbackInfo ci) {
        if (client.player != null) {
            if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(client.player)) {

                ci.cancel();
                final PlayerEntity playerEntity = this.getCameraPlayer();
                final int i = MathHelper.ceil(playerEntity.getHealth());
                final int j = this.renderHealthValue;
                final float f = Math.max((float) playerEntity.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH),
                        (float) Math.max(j, i));
                final int u = playerEntity.getArmor();
                final int m = (this.scaledWidth >> 1) - 91;
                final int o = this.scaledHeight - 39;
                final int p = MathHelper.ceil(playerEntity.getAbsorptionAmount());
                final int q = MathHelper.ceil((f + (float) p) / 2.0F / 10.0F);
                final int r = Math.max(10 - (q - 2), 3);
                final int s = o - (q - 1) * r - 10;

                this.client.getProfiler().push("armor");

                int x;
                for (int w = 0; w < 10; ++w) {
                    if (u > 0) {
                        x = m + w * 8;
                        if (w * 2 + 1 < u) {
                            matrices.drawTexture(ARMOR_FULL_TEXTURE, x, s, 34, 9, 9, 9);
                        }

                        if (w * 2 + 1 == u) {
                            matrices.drawTexture(ARMOR_HALF_TEXTURE, x, s, 25, 9, 9, 9);
                        }

                        if (w * 2 + 1 > u) {
                            matrices.drawTexture(ARMOR_EMPTY_TEXTURE, x, s, 16, 9, 9, 9);
                        }
                    }
                }
                this.client.getProfiler().pop();

            }
        }
    }

    @Inject(method = "renderStatusEffectOverlay", at = @At(value = "HEAD"), cancellable = true)
    public void codelyoko$test(final DrawContext matrices, final CallbackInfo ci) {
        MixinHooks.PlayerEvents.cancelPlayerEvents(client,ci);

    }


}
