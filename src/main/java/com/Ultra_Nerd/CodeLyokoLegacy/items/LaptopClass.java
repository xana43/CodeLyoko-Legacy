package com.Ultra_Nerd.CodeLyokoLegacy.items;

import net.minecraft.item.Item;
import org.jetbrains.annotations.NotNull;

public final class LaptopClass extends Item {
    public LaptopClass(@NotNull Settings properties) {
        super(properties);
    }
   /* @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level worldIn, @Nonnull Player playerIn, @Nonnull InteractionHand handIn) {

        final ItemStack item = playerIn.getItemInHand(handIn);
        if (item.getItem() == this && item.getDamageValue() == 0) {
            item.setDamageValue(1);
            if (worldIn.isClientSide) {

                DistExecutor.unsafeRunWhenOn(Dist.CLIENT,() -> ClientMiscFunctions.runnableScreen(ConstantUtil.EMPTY_TEXT_COMPONENT, ClientMiscFunctions.Screens.LAPTOP));
            }
            worldIn.playSound(playerIn,playerIn.blockPosition(), ModSounds.OPENTOWERGUISOUND.get(), SoundSource.BLOCKS,1,1);
        }
        else if (item.getItem() == this && item.getDamageValue() == 1) {
            item.setDamageValue(0);


        }




        return super.use(worldIn, playerIn, handIn);
    }

    */




}
