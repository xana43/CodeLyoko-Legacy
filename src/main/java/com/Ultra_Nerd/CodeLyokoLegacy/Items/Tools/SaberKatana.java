package com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModSounds;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public final class SaberKatana extends SwordItem {

    private boolean selectedOnce;
    private final AttributeModifiersComponent component;
    public SaberKatana(final ToolMaterial toolMaterial, final int attackDamage, final float attackSpeed, final Settings settings) {
        super(toolMaterial, settings);
        component = createAttributeModifiers(toolMaterial,attackDamage,attackSpeed);
    }

    @Override
    public UseAction getUseAction(final ItemStack stack) {
        return UseAction.BLOCK;
    }
    @Override
    public int getMaxUseTime(final ItemStack stack) {
        return 72000;
    }

    @Override
    public AttributeModifiersComponent getAttributeModifiers() {
        return component;
    }




    @Override
    public void inventoryTick(final ItemStack stack, final World world, final Entity entity, final int slot, final boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if(!world.isClient()) {
            if (selected && !selectedOnce) {
                entity.playSound(ModSounds.SWORDDRAW, 1, 1);
                selectedOnce = true;
            } else if (!selected) {
                selectedOnce = false;
            }
            if (!stack.hasEnchantments()) {
                stack.addEnchantment(Enchantments.SWEEPING_EDGE, Enchantments.SWEEPING_EDGE.getMaxLevel());
                //stack.addHideFlag(ItemStack.TooltipSection.ENCHANTMENTS);
            }
        }
    }



    @Override
    public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
        final ItemStack stack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(stack);
    }



    @Override
    public boolean hasGlint(final ItemStack stack) {
        return false;
    }

}
