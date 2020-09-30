package com.Ultra_Nerd.CodeLyokoRemake15.items;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class BlisterCopper extends Item {
    private short I = 500;
    public BlisterCopper(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack, @Nullable World worldIn,@Nonnull List<ITextComponent> tooltip,@Nonnull ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new StringTextComponent("this form of copper is usable, but it oxidizes quickly back to cuprous oxide, use electroplating to keep it stable"));

    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public void inventoryTick(@Nonnull ItemStack stack,@Nonnull World worldIn,@Nonnull Entity entityIn, int itemSlot, boolean isSelected) {

            if(!worldIn.isRemote) {
                Base.Log.debug(I);
                if (I-- == 0  ) {
                    if(stack.getDamage() != 60) {

                        stack.setDamage(stack.getDamage() + 1);

                        I = 500;
                    }
                }
                if(stack.getDamage() == 60)
                {
                    PlayerEntity playerEntity = (PlayerEntity)entityIn;
                    playerEntity.inventory.setInventorySlotContents(itemSlot,new ItemStack(ModItems.CUPROUS_OXIDE.get()));

                }
            }


    }
}
