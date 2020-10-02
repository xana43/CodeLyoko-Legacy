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
    private static Minecraft mc = null;
    public MultiplayerPhone(Properties properties) {
        super(properties);
        mc = Minecraft.getInstance();

    }




    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World worldIn, @Nonnull PlayerEntity playerIn, @Nonnull Hand handIn) {
        if (worldIn.getPlayers().size() > 1) {
            return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
        } else
        {
            playerIn.sendMessage(new StringTextComponent("this isn't a multiplayer game"));
            return ActionResult.resultPass(playerIn.getHeldItem(handIn));
        }
    }
}
