package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class retainXP {

    @Shadow public abstract ImmutableList<EntityPose> getPoses();

    @Shadow protected abstract void updatePose();

    @Inject(method = "getXpToDrop",at = @At("HEAD"), cancellable = true)
    private void retainxp(final CallbackInfoReturnable<Integer> cir)
    {
        final MinecraftClient mc = MinecraftClient.getInstance();

            if(mc.player != null) {
                if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(mc.player)) {

                    cir.setReturnValue(0);
                }
            }

    }
    @Inject(method = "shouldAlwaysDropXp",at = @At("HEAD"), cancellable = true)
    private void retainxp2(final CallbackInfoReturnable<Boolean> cir)
    {
        final MinecraftClient mc = MinecraftClient.getInstance();

        if(mc != null)
        {
            if(mc.player != null)
            {
                if(MethodUtil.DimensionCheck.playerNotInVanillaWorld(mc.player))
                {
                    cir.setReturnValue(false);
                }
            }
        }
    }


}
