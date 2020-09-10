package com.Ultra_Nerd.CodeLyokoRemake15.items;

import com.Ultra_Nerd.CodeLyokoRemake15.screens.LaptopGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class LaptopClass extends Item {
    public LaptopClass(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(@Nonnull ItemStack stack, @Nonnull World worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {
        if(!(Minecraft.getInstance().currentScreen instanceof LaptopGUI) && stack.getDamage() != 0)
        {
            stack.setDamage(0);
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, @Nonnull PlayerEntity playerIn, @Nonnull Hand handIn) {
       if(!worldIn.isRemote)
       {
           Minecraft.getInstance().displayGuiScreen(new LaptopGUI(new StringTextComponent("test")));
       }

       if(playerIn.getHeldItem(handIn).getItem() == this)
       {
           playerIn.getHeldItem(handIn).getItem().setDamage(playerIn.getHeldItem(handIn).getStack(),1);
       }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
