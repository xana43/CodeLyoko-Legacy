package com.Ultra_Nerd.CodeLyokoLegacy.items;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.concurrent.ThreadLocalRandom;

public final class Polycarbonate extends Item {
    private static int timer;
    private static ItemStack instance;

    public Polycarbonate(@NotNull Properties properties) {
        super(properties);
        instance = this.getDefaultInstance();
        timer = ThreadLocalRandom.current().nextInt(100, 1000);

    }

    @Override
    public void inventoryTick(@Nonnull ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
        if (timer-- <= 0 && entityIn instanceof final @NotNull Player playerEntity && instance == this.getDefaultInstance()) {
            final ItemStack stack1 = new ItemStack(ModItems.COLD_POLYCARBONATE_CONCENTRATE.get());
            stack1.setCount(stack.getCount());
            playerEntity.getInventory().setItem(itemSlot, stack1);
            timer = ThreadLocalRandom.current().nextInt(100, 1000);
        }
        if(isSelected && entityIn instanceof Player)
        {
            entityIn.hurt(new DamageSource(this.getRegistryName().toString()),0.2f);
        }
    }
}
