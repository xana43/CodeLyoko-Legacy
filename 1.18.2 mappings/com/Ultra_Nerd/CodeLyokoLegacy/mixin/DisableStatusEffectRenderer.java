package com.Ultra_Nerd.CodeLyokoLegacy.mixin;


import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.village.VillageGossipType;
import net.minecraft.village.VillagerGossips;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractInventoryScreen.class)
public abstract class DisableStatusEffectRenderer {

    @Inject(method = "drawStatusEffects",at = @At("HEAD"),cancellable = true)
    private void disableStatusRenderer(final MatrixStack matrices, final int mouseX, final int mouseY, final CallbackInfo ci)
    {
        final MinecraftClient mc = MinecraftClient.getInstance();
        if(mc != null)
        {
            if(mc.player != null)
            {
                if(MethodUtil.DimensionCheck.playerNotInVanillaWorld(mc.player)) {
                    ci.cancel();

                }
            }
        }
    }
}
