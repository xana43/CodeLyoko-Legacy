package com.Ultra_Nerd.CodeLyokoLegacy.items.SpawnItems;

import net.minecraft.item.Item;

public final class HoverBoardItem extends Item {
    public HoverBoardItem(final Settings pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isDamageable() {
        return false;
    }
/*
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(final @NotNull Level pLevel, final @NotNull Player pPlayer, final @NotNull InteractionHand pUsedHand) {
        if(DimensionCheck.playerNotInVanillaWorld(pPlayer))
        {
            if(!pLevel.isClientSide) {
                final HitResult playerPOVHitResult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.NONE);
                ModEntities.HOVERBOARD.get().spawn((ServerLevel) pLevel, pPlayer.getItemInHand(pUsedHand), pPlayer, new BlockPos(playerPOVHitResult.getLocation().x, playerPOVHitResult.getLocation().y,
                        playerPOVHitResult.getLocation().z), MobSpawnType.SPAWN_EGG, true, true);
                return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
            }
        }

        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }

 */
}
