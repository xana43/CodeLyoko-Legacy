package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class retainXP {

    @Inject(method = "getXpToDrop",at = @At("RETURN"), cancellable = true)
    private void retainxp(final PlayerEntity player, final CallbackInfoReturnable<Integer> cir)
    {

            if(MethodUtil.DimensionCheck.playerNotInVanillaWorld(player))
                {
                    CodeLyokoMain.LOG.info("died");
                    cir.setReturnValue(0);
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
