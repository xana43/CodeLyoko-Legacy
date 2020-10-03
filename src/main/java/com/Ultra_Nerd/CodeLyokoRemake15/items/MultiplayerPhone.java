package com.Ultra_Nerd.CodeLyokoRemake15.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class MultiplayerPhone extends Item {
    private Minecraft mc = null;
    public MultiplayerPhone(Properties properties) {
        super(properties);
        mc = Minecraft.getInstance();

    }




    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World worldIn, @Nonnull PlayerEntity playerIn, @Nonnull Hand handIn) {
        if (worldIn.getPlayers().size() > 1) {
            assert this.mc.player != null;
            this.mc.player.sendMessage(new StringTextComponent("you sent a message"));
            PlayerEntity[] playerEntities = (PlayerEntity[]) worldIn.getPlayers().toArray();
            for(PlayerEntity playerEntity : playerEntities)
            {
                if(playerEntity != this.mc.player)
                {
                    playerEntity.sendMessage(new StringTextComponent("Xana attack repoirted by %s"));
                }
            }
            return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
        } else
        {
            playerIn.sendMessage(new StringTextComponent("this isn't a multiplayer game"));
            return ActionResult.resultPass(playerIn.getHeldItem(handIn));
        }
    }
}
