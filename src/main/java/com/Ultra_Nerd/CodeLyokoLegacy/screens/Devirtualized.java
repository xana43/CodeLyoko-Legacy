package com.Ultra_Nerd.CodeLyokoLegacy.screens;

import com.google.common.collect.Lists;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.awt.*;
import java.util.List;

public final class Devirtualized extends Screen {

    private int delayTicker;
   // private final @org.jetbrains.annotations.Nullable Text causeOfDeath;
    //private final boolean hardcore;
    private Text deathScore;
    private final List<Button> exitButtons = Lists.newArrayList();

    protected Devirtualized(final Text title) {
        super(title);
    }
/*
    public Devirtualized(@javax.annotation.Nullable Component pCauseOfDeath, boolean pHardcore) {
        super(new Text(pHardcore ? "lyoko.deathScreen.title.hardcore" : "lyoko.deathScreen.title").withStyle(Style.EMPTY.withFont(CodeLyokoMain.CodeLyokoPrefix("gunship"))));
        this.causeOfDeath = pCauseOfDeath;
        this.hardcore = pHardcore;
    }

    protected void init() {
        this.delayTicker = 0;
        this.exitButtons.clear();
        this.exitButtons.add(this.addRenderableWidget(new Button((this.width >> 1) - 100, (this.height >> 2) + 72, 200, 20, this.hardcore ? new TranslatableComponent("deathScreen.spectate") : new TranslatableComponent("deathScreen.respawn"), (p_95930_) -> {
            assert this.minecraft != null;
            assert this.minecraft.player != null;
            this.minecraft.player.respawn();
            this.minecraft.setScreen(null);
        })));
        this.exitButtons.add(this.addRenderableWidget(new Button((this.width >> 1) - 100, (this.height >> 2) + 96, 200, 20, new TranslatableComponent("deathScreen.titleScreen"), (p_95925_) -> {
            if (this.hardcore) {
                confirmResult(true);
                this.exitToTitleScreen();
            } else {
                final ConfirmScreen confirmscreen = new ConfirmScreen(this::confirmResult, new TranslatableComponent("deathScreen.quit.confirm"), TextComponent.EMPTY, new TranslatableComponent("deathScreen.titleScreen"), new TranslatableComponent("deathScreen.respawn"));
                assert this.minecraft != null;
                this.minecraft.setScreen(confirmscreen);
                confirmscreen.setDelay(20);
            }
        })));

        for(Button button : this.exitButtons) {
            button.active = false;
        }

        this.deathScore = (new TranslatableComponent("deathScreen.score")).append(": ").append((new TextComponent(Integer.toString(this.minecraft.player.getScore()))).withStyle(ChatFormatting.YELLOW));
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    private void confirmResult(boolean p_95932_) {
        if (p_95932_) {
            this.exitToTitleScreen();
        } else {
            assert Objects.requireNonNull(this.minecraft).player != null;
            assert this.minecraft.player != null;
            this.minecraft.player.respawn();
            this.minecraft.setScreen(null);
        }

    }

    private void exitToTitleScreen() {
        assert this.minecraft != null;
        if (this.minecraft.level != null) {
            this.minecraft.level.disconnect();
        }

        this.minecraft.clearLevel(new GenericDirtMessageScreen(new TranslatableComponent("menu.savingLevel")));
        this.minecraft.setScreen(new TitleScreen());
    }

    public void render(@NotNull PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.fillGradient(pPoseStack, 0, 0, this.width, this.height, 1615855616, -1602211792);
        pPoseStack.pushPose();
        pPoseStack.scale(2.0F, 2.0F, 2.0F);
        drawCenteredString(pPoseStack, this.font, this.title, this.width >> 2, 30, 16777215);
        pPoseStack.popPose();
        if (this.causeOfDeath != null) {
            drawCenteredString(pPoseStack, this.font, this.causeOfDeath, this.width >> 1, 85, 16777215);
        }

        drawCenteredString(pPoseStack, this.font, this.deathScore, this.width >> 1, 100, 16777215);
        if (this.causeOfDeath != null && pMouseY > 85 && pMouseY < 94) {
            Style style = this.getClickedComponentStyleAt(pMouseX);
            this.renderComponentHoverEffect(pPoseStack, style, pMouseX, pMouseY);
        }

        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    @Nullable
    private Style getClickedComponentStyleAt(int p_95918_) {
        if (this.causeOfDeath == null) {
            return null;
        } else {
            assert this.minecraft != null;
            final int i = this.minecraft.font.width(this.causeOfDeath);
            final int j = (this.width >> 1) - (i  >> 1);
            final int k = (this.width >> 1) + (i >> 1);
            return p_95918_ >= j && p_95918_ <= k ? this.minecraft.font.getSplitter().componentStyleAtWidth(this.causeOfDeath, p_95918_ - j) : null;
        }
    }

    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        if (this.causeOfDeath != null && pMouseY > 85.0D && pMouseY < 94) {
            final Style style = this.getClickedComponentStyleAt((int)pMouseX);
            if (style != null && style.getClickEvent() != null && style.getClickEvent().getAction() == ClickEvent.Action.OPEN_URL) {
                this.handleComponentClicked(style);
                return false;
            }
        }

        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }

    public boolean isPauseScreen() {
        return false;
    }

    public void tick() {
        super.tick();
        ++this.delayTicker;
        if (this.delayTicker == 20) {
            for(Button button : this.exitButtons) {
                button.active = true;
            }
        }

    }

 */

}
