package com.Ultra_Nerd.CodeLyokoRemake15.items;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.TextUtil;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.ClientMiscFunctions;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.WrittenBookItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class Entry1 extends WrittenBookItem {
    private static final FormattedText[] textArray =   TextUtil.textArray(
            "Entry 1: " + "\n" +
                    "XXXX/xx/xx" + "\n" +
                    "Jeremy Belpois" + "\n" + "xx:00" + "\n" +
                    "I'm not sure what happened, X.A.N.A. was defeated years ago" + "\n" +
                    "but this time he's done it, he's managed to destroy the world as we know it" +"δ" +
                    "I survived because I tried to save everyone by putting  them in lyoko" + "\n" +
                    "I'm not sure how long I have to be here, hopefully someone finds this, " +
                    "and finds the hidden instructions to rebuild the super calculator and reset this mess");
    public Entry1(@NotNull Properties builder) {
        super(builder);
    }

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
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientMiscFunctions.runnableScreen(textArray,TextUtil.textArrayLengthToPage(textArray)));
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




}
