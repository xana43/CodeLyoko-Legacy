package com.Ultra_Nerd.CodeLyokoLegacy.items;

import net.minecraft.item.Item;
import org.jetbrains.annotations.NotNull;

public final class MultiplayerPhone extends Item {

    public MultiplayerPhone(@NotNull Settings properties) {
        super(properties);


    }

/*
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level worldIn, Player playerIn, InteractionHand handIn) {
        if (worldIn.players().size() > 1 && worldIn.isClientSide) {

            playerIn.sendMessage(new TranslatableComponent("you sent a message"),playerIn.getUUID());

            Player[] playerEntities = (Player[]) worldIn.players().toArray();
            for(Player playerEntity : playerEntities)
            {
                if(playerEntity != playerIn)
                {
                    playerEntity.playSound(SoundEvents.ANVIL_LAND,1,1);
                    playerEntity.sendMessage(new TranslatableComponent("Xana attack reported by " + playerIn.getDisplayName()),playerEntity.getUUID());
                }
            }
            return InteractionResultHolder.success(playerIn.getItemInHand(handIn));
        } else
        {
            playerIn.sendMessage(new TranslatableComponent("this isn't a multiplayer game"),playerIn.getUUID());
            return InteractionResultHolder.pass(playerIn.getItemInHand(handIn));
        }
    }

 */


}
