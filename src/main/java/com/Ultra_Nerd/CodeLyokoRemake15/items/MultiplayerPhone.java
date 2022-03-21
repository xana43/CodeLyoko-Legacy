package com.Ultra_Nerd.CodeLyokoRemake15.items;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MultiplayerPhone extends Item {
    private final Minecraft mc;
    public MultiplayerPhone(Properties properties) {
        super(properties);
        mc = Minecraft.getInstance();

    }


    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (worldIn.players().size() > 1 && worldIn.isClientSide) {
            assert this.mc.player != null;
            Player thisplayer = this.mc.player;
            this.mc.player.sendMessage(new TranslatableComponent("you sent a message"),thisplayer.getUUID());

            Player[] playerEntities = (Player[]) worldIn.players().toArray();
            for(Player playerEntity : playerEntities)
            {
                if(playerEntity != this.mc.player)
                {
                    playerEntity.playSound(SoundEvents.ANVIL_LAND,1,1);
                    playerEntity.sendMessage(new TranslatableComponent("Xana attack reported by " + thisplayer.getDisplayName()),playerEntity.getUUID());
                }
            }
            return InteractionResultHolder.success(playerIn.getItemInHand(handIn));
        } else
        {
            playerIn.sendMessage(new TranslatableComponent("this isn't a multiplayer game"),playerIn.getUUID());
            return InteractionResultHolder.pass(playerIn.getItemInHand(handIn));
        }
    }


}
