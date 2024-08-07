package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MixinHooks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
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
    private int renderHealthValue;
    @Shadow
    private long heartJumpEndTick;
    @Shadow
    private int ticks;
    @Shadow
    private int lastHealthValue;
    @Shadow
    private long lastHealthCheckTime;
    @Final
    @Shadow
    private Random random;
    @Shadow
    protected abstract PlayerEntity getCameraPlayer();

    @Shadow
    private static void renderArmor(DrawContext context, PlayerEntity player, int i, int j, int k, int x) {
    }

    @Inject(method = "renderHealthBar", at = @At(value = "HEAD"), cancellable = true)
    public void codelyoko$disableHealth(final DrawContext matrices, final PlayerEntity player, final int x, final int y,
            final int lines,
            final int regeneratingHeartIndex, final float maxHealth, final int lastHealth, final int health, final int absorption, final boolean blinking, final CallbackInfo ci) {
        MixinHooks.PlayerEvents.cancelPlayerEvents(client,ci);
    }

    @Inject(method = "renderStatusBars", at = @At(value = "HEAD"), cancellable = true)
    public void codelyoko$disableFood(final DrawContext context, final CallbackInfo ci) {
        if (client.player != null) {
            if (MethodUtil.DimensionCheck.isPlayerInLyoko(client.player)) {

                ci.cancel();
                PlayerEntity playerEntity = this.getCameraPlayer();
                if (playerEntity != null) {
                    int i = MathHelper.ceil(playerEntity.getHealth());
                    boolean bl = this.heartJumpEndTick > (long)this.ticks && (this.heartJumpEndTick - (long)this.ticks) / 3L % 2L == 1L;
                    long l = Util.getMeasuringTimeMs();
                    if (i < this.lastHealthValue && playerEntity.timeUntilRegen > 0) {
                        this.lastHealthCheckTime = l;
                        this.heartJumpEndTick = (long)(this.ticks + 20);
                    } else if (i > this.lastHealthValue && playerEntity.timeUntilRegen > 0) {
                        this.lastHealthCheckTime = l;
                        this.heartJumpEndTick = (long)(this.ticks + 10);
                    }

                    if (l - this.lastHealthCheckTime > 1000L) {
                        this.lastHealthValue = i;
                        this.renderHealthValue = i;
                        this.lastHealthCheckTime = l;
                    }

                    this.lastHealthValue = i;
                    int j = this.renderHealthValue;
                    this.random.setSeed(this.ticks * 312871L);
                    int k = context.getScaledWindowWidth() / 2 - 91;
                    int m = context.getScaledWindowWidth() / 2 + 91;
                    int n = context.getScaledWindowHeight() - 39;
                    float f = Math.max((float)playerEntity.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH), (float)Math.max(j, i));
                    int o = MathHelper.ceil(playerEntity.getAbsorptionAmount());
                    int p = MathHelper.ceil((f + (float)o) / 2.0F / 10.0F);
                    int q = Math.max(10 - (p - 2), 3);
                    int r = n - 10;
                    int s = -1;
                    if (playerEntity.hasStatusEffect(StatusEffects.REGENERATION)) {
                        s = this.ticks % MathHelper.ceil(f + 5.0F);
                    }

                    this.client.getProfiler().push("armor");
                    renderArmor(context, playerEntity, n, p, q, k);

                    this.client.getProfiler().pop();
                }

            }
        }
    }

    @Inject(method = "renderStatusEffectOverlay", at = @At(value = "HEAD"), cancellable = true)
    public void codelyoko$test(DrawContext context, float tickDelta, CallbackInfo ci) {
        MixinHooks.PlayerEvents.cancelPlayerEvents(client,ci);

    }


}
