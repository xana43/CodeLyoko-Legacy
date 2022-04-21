package com.Ultra_Nerd.CodeLyokoLegacy.items;

import net.minecraft.item.WrittenBookItem;
import org.jetbrains.annotations.NotNull;

public final class Entry1 extends WrittenBookItem {
    public Entry1(@NotNull Settings builder) {
        super(builder);
    }
/*
    @Nonnull
    @Override
    public Component getName(@Nonnull ItemStack stack) {
        return new TranslatableComponent("Entry 1");
    }



    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pHand) {
        if(pLevel.isClientSide)
        {
           // CodeLyokoMain.Log.info("client");
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientMiscFunctions.runnableScreen(TextUtil.textArray(ConstantUtil.StoryEntry.Entry1),TextUtil.textArrayLengthToPage(TextUtil.textArray(ConstantUtil.StoryEntry.Entry1))));
        }
        return super.use(pLevel, pPlayer, pHand);
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslatableComponent("a mysterious journal you found while traveling to this land"));
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return false;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean isFoil(ItemStack p_43476_) {
        return false;
    }

 */




}
