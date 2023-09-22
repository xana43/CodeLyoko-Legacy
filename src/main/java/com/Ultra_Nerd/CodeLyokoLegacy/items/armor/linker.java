package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import com.Ultra_Nerd.CodeLyokoLegacy.util.ArmorTicker;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import team.reborn.energy.api.base.SimpleEnergyItem;

public final class linker extends ArmorItem implements SimpleEnergyItem, ArmorTicker {
    public linker(final @NotNull ArmorMaterial materialIn,final @NotNull ArmorItem.Type slot,
            final @NotNull Settings builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public long getEnergyCapacity(final ItemStack stack) {
        return 90000;
    }

    @Override
    public long getEnergyMaxInput(final ItemStack stack) {
        return 40;
    }

    @Override
    public long getEnergyMaxOutput(final ItemStack stack) {
        return 0;
    }

    @Override
    public void inventoryTick(final ItemStack stack, final World world, final Entity entity, final int slot, final boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if(entity instanceof final PlayerEntity player)
        {
            onArmorTick(player,world, stack.getItem(), slot);
        }
    }

    @Override
    public void onArmorTick(final PlayerEntity player, final World world, final Item armorItem, final int slot) {
        ArmorTicker.super.onArmorTick(player, world, armorItem, slot);
        tryUseEnergy(armorItem.getDefaultStack(),10);
    }


}
