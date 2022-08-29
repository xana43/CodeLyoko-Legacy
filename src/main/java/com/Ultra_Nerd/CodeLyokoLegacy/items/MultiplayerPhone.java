package com.Ultra_Nerd.CodeLyokoLegacy.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public final class MultiplayerPhone extends Item {

    public MultiplayerPhone(@NotNull Settings properties) {
        super(properties);


    }

    @Override
    public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
        final ItemStack thisStack = user.getStackInHand(hand);
        if(user.getServer() != null)
        {
            if(user.getServer().isSingleplayer())
            {
                user.sendMessage(Text.translatable("phone.use.singleplayer"),false);
                return TypedActionResult.fail(thisStack);
            }
            else if (!user.getServer().isSingleplayer())
            {
                user.sendMessage(Text.translatable("phone.use.multiplayer").formatted(Formatting.BLACK),true);
                world.getPlayers().forEach(playerEntity -> {

                    if(playerEntity != user && playerEntity.getInventory().contains(new ItemStack(this)))
                    {
                        playerEntity.sendMessage(Text.translatable("phone.receive").append("").append(user.getGameProfile().getName()).append("").append(Text.translatable("phone.receive2")),true);
                    }

                });
                return TypedActionResult.success(thisStack);
            }

        }

        return TypedActionResult.pass(thisStack);

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
