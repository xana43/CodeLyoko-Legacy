package com.Ultra_Nerd.CodeLyokoLegacy.items;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.DamageSources.LyokoDamage;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public final class  Polycarbonate extends Item {
    private  int timer;


    public Polycarbonate(@NotNull Settings properties) {
        super(properties);
        //instance = this.getDefaultInstance();
        timer = ThreadLocalRandom.current().nextInt(100, 1000);

    }

    @Override
    public void inventoryTick(final ItemStack stack, final World world, final Entity entity, final int slot, final boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (timer-- <= 0 && entity instanceof final @NotNull PlayerEntity playerEntity) {
            final ItemStack stack1 = new ItemStack(ModItems.COLD_POLYCARBONATE_CONCENTRATE);
            stack1.setCount(stack.getCount());
            playerEntity.getInventory().setStack(slot, stack1);

        }
        if(selected)
        {
            entity.damage(new LyokoDamage("damage.polycarbonate"),0.2f);
        }
    }

    /*
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

 */
}
