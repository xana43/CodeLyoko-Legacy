package com.Ultra_Nerd.CodeLyokoRemake15.items;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.concurrent.ThreadLocalRandom;

public class Polycarbonate extends Item {
    private static int timer;
    private static ItemStack instance;

    public Polycarbonate(Properties properties) {
        super(properties);
        instance = this.getDefaultInstance();
        timer = ThreadLocalRandom.current().nextInt(100, 1000);

    }

    @Override
    public void inventoryTick(@Nonnull ItemStack stack, @Nonnull World worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
        if (timer-- <= 0 && entityIn instanceof PlayerEntity && instance == this.getDefaultInstance()) {
            PlayerEntity playerEntity = (PlayerEntity) entityIn;
            ItemStack stack1 = new ItemStack(ModItems.COLD_POLYCARBONATE_CONCENTRATE.get());
            stack1.setCount(stack.getCount());
            playerEntity.inventory.setInventorySlotContents(itemSlot, stack1);
            timer = ThreadLocalRandom.current().nextInt(100, 1000);
        }
        if(isSelected && entityIn instanceof PlayerEntity)
        {
            entityIn.attackEntityFrom(new DamageSource(this.getTranslationKey()),0.2f);
        }
    }
}
