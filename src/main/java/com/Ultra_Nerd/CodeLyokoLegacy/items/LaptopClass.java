package com.Ultra_Nerd.CodeLyokoLegacy.items;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens.LapTopHeirarichy.MainLaptopScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public final class LaptopClass extends Item {
    public LaptopClass(@NotNull Settings properties) {
        super(properties);
    }



   @Nonnull
    @Override
    public TypedActionResult<ItemStack> use(@NotNull World worldIn, @Nonnull PlayerEntity playerIn, @Nonnull Hand handIn) {

        final ItemStack item = playerIn.getStackInHand(handIn);
        if (item.getItem() == this && item.getDamage() == 0) {
            item.setDamage(1);
            if (worldIn.isClient) {
                MinecraftClient.getInstance().setScreen(new MainLaptopScreen());
            }
            worldIn.playSound(playerIn,playerIn.getBlockPos(), ModSounds.OPENTOWERGUISOUND, SoundCategory.BLOCKS,1,1);
        }
        else if (item.getItem() == this && item.getDamage() == 1) {
            item.setDamage(0);


        }




        return super.use(worldIn, playerIn, handIn);
    }






}
