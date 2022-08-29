package com.Ultra_Nerd.CodeLyokoLegacy.screens;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.ConstantUtil;
import com.google.common.collect.Lists;
import net.minecraft.client.gui.screen.ConfirmScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public final class Devirtualized extends Screen {




    private byte ticksSinceDeath;
    private final Text message;
    private final boolean isHardcore;
    private Text scoreText;
    private final List<ButtonWidget> buttons = Lists.newArrayList();

    public Devirtualized(@Nullable Text message, boolean isHardcore) {
        super(Text.translatable(isHardcore ? "lyoko.deathScreen.title.hardcore" : "lyoko.deathScreen.title").fillStyle(ConstantUtil.Styles.GUNSHIP.getThisStyle()));
        this.message = message;
        this.isHardcore = isHardcore;
    }

    protected void init() {
        this.ticksSinceDeath = 0;
        this.buttons.clear();
        this.buttons.add(this.addDrawableChild(new ButtonWidget((this.width >> 1) - 100, (this.height >> 2) + 72, 200, 20, this.isHardcore ? Text.translatable("deathScreen.spectate") : Text.translatable("deathScreen.respawn"), (button) -> {
            this.client.player.requestRespawn();
            this.client.setScreen(null);
        })));
        this.buttons.add(this.addDrawableChild(new ButtonWidget((this.width >> 1) - 100, (this.height >> 2) + 96, 200, 20, Text.translatable("deathScreen.titleScreen"), (button) -> {
            if (this.isHardcore) {
                this.quitLevel();
            } else {
                ConfirmScreen confirmScreen = new ConfirmScreen(this::onConfirmQuit, Text.translatable("deathScreen.quit.confirm"), Text.empty(), Text.translatable("deathScreen.titleScreen"), Text.translatable("deathScreen.respawn"));
                this.client.setScreen(confirmScreen);
                confirmScreen.disableButtons(20);
            }
        })));

        for(ButtonWidget widget : this.buttons)
        {
            widget.active = false;
        }

        this.scoreText = (Text.translatable("deathScreen.score")).append(": ").append((Text.literal(Integer.toString(this.client.player.getScore()))).formatted(Formatting.YELLOW));
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }



    private void onConfirmQuit(boolean quit) {
        if (quit) {
            this.quitLevel();
        } else {
            this.client.player.requestRespawn();
            this.client.setScreen(null);
        }

    }

    private void quitLevel() {
        if (this.client.world != null) {
            this.client.world.disconnect();
        }

        this.client.disconnect(new net.minecraft.client.gui.screen.MessageScreen(Text.translatable("menu.savingLevel")));
       // this.client.setScreen(new TitleScreen());
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.fillGradient(matrices, 0, 0, this.width, this.height, 1615855616, -1602211792);
        matrices.push();
        matrices.scale(2.0F, 2.0F, 2.0F);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width >> 2, 30, 16777215);
        matrices.pop();
        if (this.message != null) {
            drawCenteredText(matrices, this.textRenderer, this.message, this.width >> 1, 85, 16777215);
        }

        drawCenteredText(matrices, this.textRenderer, this.scoreText, this.width >> 1, 100, 16777215);
        if (this.message != null && mouseY > 85) {
            Objects.requireNonNull(this.textRenderer);
            if (mouseY < 94) {
                Style style = this.getTextComponentUnderMouse(mouseX);
                this.renderTextHoverEffect(matrices, style, mouseX, mouseY);
            }
        }

        super.render(matrices, mouseX, mouseY, delta);
    }

    @Nullable
    private Style getTextComponentUnderMouse(int mouseX) {
        if (this.message == null) {
            return null;
        } else {
            final int i = this.client.textRenderer.getWidth(this.message);
            final int j = (this.width >> 1) - (i >> 1);
            final int k = (this.width >> 1) + (i >> 1);
            return mouseX >= j && mouseX <= k ? this.client.textRenderer.getTextHandler().getStyleAt(this.message, mouseX - j) : null;
        }
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (this.message != null && mouseY > 85.0) {
            Objects.requireNonNull(this.textRenderer);
            if (mouseY < 94) {
                Style style = this.getTextComponentUnderMouse((int)mouseX);
                if (style != null && style.getClickEvent() != null && style.getClickEvent().getAction() == ClickEvent.Action.OPEN_URL) {
                    this.handleTextClick(style);
                    return false;
                }
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    public boolean shouldPause() {
        return false;
    }

    public void tick() {
        super.tick();
        ++this.ticksSinceDeath;

        if (this.ticksSinceDeath == 20) {
            for(ButtonWidget widget : this.buttons)
            {
                widget.active = true;
            }

        }

    }
}
