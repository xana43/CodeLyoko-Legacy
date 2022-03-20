package com.Ultra_Nerd.CodeLyokoRemake15.items;

import com.Ultra_Nerd.CodeLyokoRemake15.screens.LaptopGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;

public class LaptopClass extends Item {
    public LaptopClass(Properties properties) {
        super(properties);
    }


    @Override
    public void inventoryTick(@Nonnull ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {
        if (!(Minecraft.getInstance().screen instanceof LaptopGUI) && stack.getDamageValue() != 0) {
            stack.setDamageValue(0);
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, @Nonnull Player playerIn, @Nonnull InteractionHand handIn) {
        if (worldIn.isClientSide) {
            Minecraft.getInstance().setScreen(new LaptopGUI(new StringTextComponent("test")));
        }

        if (playerIn.getItemInHand(handIn).getItem() == this) {
            playerIn.getItemInHand(handIn).getItem().setDamage(playerIn.getItemInHand(handIn), 1);
        }

        return super.use(worldIn, playerIn, handIn);
    }


}
