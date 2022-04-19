package com.Ultra_Nerd.CodeLyokoLegacy.items.SpawnItems;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.DimensionCheck;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public final class OverBoardItem extends Item {
    public OverBoardItem(final Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isDamageable(final ItemStack stack) {
        return false;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(final @NotNull Level pLevel, final @NotNull Player pPlayer, final @NotNull InteractionHand pUsedHand) {
        if(DimensionCheck.playerNotInVanillaWorld(pPlayer))
        {
            if(!pLevel.isClientSide) {
                final HitResult playerPOVHitResult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.NONE);
                ModEntities.OVERBOARD.get().spawn((ServerLevel) pLevel, pPlayer.getItemInHand(pUsedHand), pPlayer, new BlockPos(playerPOVHitResult.getLocation().x, playerPOVHitResult.getLocation().y,
                        playerPOVHitResult.getLocation().z), MobSpawnType.SPAWN_EGG, true, true);
                return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
            }
        }

        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }
}
