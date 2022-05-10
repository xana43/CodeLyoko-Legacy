package com.Ultra_Nerd.CodeLyokoLegacy.items;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.TextUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens.StoryBookGUI;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public final class Entry1 extends WrittenBookItem {
    public Entry1(@NotNull Settings builder) {
        super(builder);
    }

    @Override
    public void appendTooltip(final ItemStack stack, @Nullable final World world, final List<Text> tooltip, final TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("lyoko.story.entry"));
    }

    private static final StringVisitable[] entry = TextUtil.textArray(ConstantUtil.StoryEntry.Entry1);

    @Override
    public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
        if(world.isClient)
        {
            MinecraftClient.getInstance().setScreen(new StoryBookGUI(entry, TextUtil.textArrayLengthToPage(entry)));
        }
        return super.use(world, user, hand);
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
