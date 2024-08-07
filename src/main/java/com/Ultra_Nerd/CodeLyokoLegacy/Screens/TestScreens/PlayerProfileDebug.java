package com.Ultra_Nerd.CodeLyokoLegacy.Screens.TestScreens;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TestHandler.ProfileDebugScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.world.WorldProperties;

import java.util.Objects;

@Environment(EnvType.CLIENT)
public final class PlayerProfileDebug extends HandledScreen<ProfileDebugScreenHandler> {
    private final PlayerEntity callingPlayer;
    private final WorldProperties worldProperties;

    private TextWidget profileText;

    public PlayerProfileDebug(final ProfileDebugScreenHandler handler, final PlayerInventory inventory,
            final Text title) {
        super(handler, inventory, title);
        this.callingPlayer = handler.getPlayer();
        this.worldProperties = handler.getWorldProperties();
    }

    @Override
    protected void init() {
        super.init();
        profileText = new TextWidget(1920/2,1080/2,80,100,
                Text.of(CardinalData.PlayerSavedProfile.getPlayerProfile(worldProperties,callingPlayer).getDNA()),
                textRenderer);
        addDrawableChild(profileText);

    }

    @Override
    public void render(final DrawContext matrices, final int mouseX, final int mouseY, final float delta) {
        super.render(matrices, mouseX, mouseY, delta);
        profileText.render(matrices, mouseX, mouseY, delta);
        profileText.renderWidget(matrices, mouseX, mouseY, delta);
        matrices.drawCenteredTextWithShadow(textRenderer,
                Text.of(Objects.requireNonNull(CardinalData.PlayerSavedProfile.getPlayerProfile(worldProperties, callingPlayer).getPlayer().getDisplayName())),
                width>>1,height>>1, ColorHelper.Argb.getArgb(255,255,255,255));
        matrices.drawCenteredTextWithShadow(textRenderer,
                Text.of("Class" + CardinalData.PlayerSavedProfile.getPlayerProfile(worldProperties,
                        callingPlayer).getPlayerClassType()),width >> 1, height >> 2, ColorHelper.Argb.getArgb(255,
                        255,255,255));


    }

    @Override
    protected void drawBackground(final DrawContext matrices, final float delta, final int mouseX, final int mouseY) {

    }
}
