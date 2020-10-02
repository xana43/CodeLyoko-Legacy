package com.Ultra_Nerd.CodeLyokoRemake15.items;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;

import javax.annotation.Nonnull;

public class MultiplayerPhone extends Item {
    public MultiplayerPhone(Properties properties) {
        super(properties);
    }


    @Nonnull
    @Override
    public ActionResultType onItemUse(@Nonnull ItemUseContext context) {
        if(context.getPlayer() instanceof ServerPlayerEntity)
    }
}
