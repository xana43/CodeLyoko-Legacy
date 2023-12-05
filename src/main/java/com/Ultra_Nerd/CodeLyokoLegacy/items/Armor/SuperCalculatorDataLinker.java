package com.Ultra_Nerd.CodeLyokoLegacy.items.Armor;

import com.Ultra_Nerd.CodeLyokoLegacy.util.ArmorTicker;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyItem;

import java.util.List;

public final class SuperCalculatorDataLinker extends ArmorItem implements SimpleEnergyItem, ArmorTicker {
    public SuperCalculatorDataLinker(final @NotNull ArmorMaterial materialIn, final @NotNull ArmorItem.Type slot,
                                     final @NotNull Settings builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public void appendTooltip(final ItemStack stack, @Nullable final World world, final List<Text> tooltip, final TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable("tooltip.energy.linker", getStoredEnergy(stack)));
    }

    @Override
    public long getEnergyCapacity(final ItemStack stack) {
        return 432000;
    }

    @Override
    public long getEnergyMaxInput(final ItemStack stack) {
        return 2000;
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
