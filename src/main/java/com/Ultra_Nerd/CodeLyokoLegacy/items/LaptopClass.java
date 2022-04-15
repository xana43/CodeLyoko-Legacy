package com.Ultra_Nerd.CodeLyokoLegacy.items;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.TextUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.ClientMiscFunctions;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class LaptopClass extends Item {
    public LaptopClass(@NotNull Properties properties) {
        super(properties);
    }
    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level worldIn, @Nonnull Player playerIn, @Nonnull InteractionHand handIn) {

        final ItemStack item = playerIn.getItemInHand(handIn);
        if (item.getItem() == this && item.getDamageValue() == 0) {
            item.setDamageValue(1);
            if (worldIn.isClientSide) {

                DistExecutor.unsafeRunWhenOn(Dist.CLIENT,() -> ClientMiscFunctions.runnableScreen(TextUtil.EMPTY_TEXT_COMPONENT, ClientMiscFunctions.Screens.LAPTOP));
            }
            worldIn.playSound(playerIn,playerIn.blockPosition(), ModSounds.OPENTOWERGUISOUND.get(), SoundSource.BLOCKS,1,1);
        }
        else if (item.getItem() == this && item.getDamageValue() == 1) {
            item.setDamageValue(0);


        }




        return super.use(worldIn, playerIn, handIn);
    }




}
