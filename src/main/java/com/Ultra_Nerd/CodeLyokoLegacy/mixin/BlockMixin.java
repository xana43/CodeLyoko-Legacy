package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MixinHooks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("MethodMayBeStatic")
@Mixin(Block.class)
public abstract class BlockMixin {

    @Inject(at = @At("HEAD"), method = "onPlaced", cancellable = true)
    private void codelyoko$onPlaced(final World world, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack itemStack, final CallbackInfo ci) {
        MixinHooks.PlayerEvents.LyokoBlockPlacer(world, pos, placer, ci);
    }
}
