package com.Ultra_Nerd.CodeLyokoLegacy.Compat.LithographyMachineDisplay;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public record CodeLyokoLithographyCategory() implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE = CodeLyokoMain.codeLyokoPrefix("textures/gui/reactor_new.png");
    public static final CategoryIdentifier<CodeLyokoLithographyDisplay> LITHOGRAPHY_DISPLAY_CATEGORY_IDENTIFIER =
            CategoryIdentifier.of(CodeLyokoMain.MOD_ID,"lithography");
    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return LITHOGRAPHY_DISPLAY_CATEGORY_IDENTIFIER;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("lithography.help");
    }

    @Override
    public Renderer getIcon() {
        return null;
    }

    /*@Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.LITHOGRAPHY_MACHINE.asItem().getDefaultStack());
    }*/

   /* @Override
    public List<Widget> setupDisplay(final BasicDisplay display, final Rectangle bounds) {
        final Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 35);
        final List<Widget> widgets = new ObjectArrayList<>();
        final EntryIngredient inputEntries = display.getInputEntries().get(0);
        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x,startPoint.y,175,82)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 44, startPoint.y + 33)).entries(inputEntries).markInput());
        widgets.add(
                Widgets.createSlot(new Point(startPoint.x + 44, startPoint.y))
                        .entries(inputEntries).markInput());
        widgets.add(
                Widgets.createSlot(new Point(startPoint.x + 44, (startPoint.y + 66)))
            .entries(inputEntries).markInput());
        widgets.add(
                Widgets.createSlot(new Point(startPoint.x + 110, startPoint.y + 33))
                        .markOutput().entries(display.getOutputEntries().get(0)).markOutput());
        return widgets;
    }*/

    @Override
    public int getDisplayHeight() {
        return 90;
    }
}
