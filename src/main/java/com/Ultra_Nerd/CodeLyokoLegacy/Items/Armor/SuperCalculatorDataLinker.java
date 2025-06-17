package com.Ultra_Nerd.CodeLyokoLegacy.Items.Armor;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.ArmorTicker;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyItem;

import java.util.function.Consumer;

public final class SuperCalculatorDataLinker extends Item implements SimpleEnergyItem, ArmorTicker {


    public SuperCalculatorDataLinker(net.minecraft.item.equipment.ArmorMaterial material, EquipmentType type, Settings settings) {
        super(settings.armor(material,type));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        textConsumer.accept(Text.translatable("tooltip.energy.linker", getStoredEnergy(stack)));
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
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        super.inventoryTick(stack, world, entity, slot);
        if(entity instanceof final PlayerEntity player)
        {
            onArmorTick(player,world, stack.getItem(), slot);
        }
    }

    @Override
    public void onArmorTick(final PlayerEntity player, final World world, final Item armorItem, final EquipmentSlot slot) {
        ArmorTicker.super.onArmorTick(player, world, armorItem, slot);
        tryUseEnergy(armorItem.getDefaultStack(),10);
    }


}
