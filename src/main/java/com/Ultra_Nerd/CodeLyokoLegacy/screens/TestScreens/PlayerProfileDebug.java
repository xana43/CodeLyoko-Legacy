package com.Ultra_Nerd.CodeLyokoLegacy.screens.TestScreens;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.world.WorldProperties;

public final class PlayerProfileDebug extends Screen {
    private final PlayerEntity callingPlayer;
    private final WorldProperties worldProperties;
    public PlayerProfileDebug(final Text title,final PlayerEntity callingPlayer,final WorldProperties worldProperties) {
        super(title);
        this.callingPlayer = callingPlayer;
        this.worldProperties = worldProperties;
    }
    private TextWidget profileText;
    @Override
    protected void init() {
        super.init();
        profileText = new TextWidget(1920/2,1080/2,80,100,
                Text.of(CardinalData.PlayerSavedProfile.getPlayerProfile(worldProperties,callingPlayer).getDNA()),
                textRenderer);
        addDrawableChild(profileText);

    }

    @Override
    public void render(final MatrixStack matrices, final int mouseX, final int mouseY, final float delta) {
        super.render(matrices, mouseX, mouseY, delta);
        profileText.render(matrices, mouseX, mouseY, delta);
        profileText.renderButton(matrices, mouseX, mouseY, delta);
        drawCenteredText(matrices,textRenderer,
                Text.of(CardinalData.PlayerSavedProfile.getPlayerProfile(worldProperties,callingPlayer).getPlayer().getEntityName()),
                width>>1,height>>1, ColorHelper.Argb.getArgb(255,255,255,255));
        drawCenteredText(matrices,textRenderer,
                Text.of("Class" + CardinalData.PlayerSavedProfile.getPlayerProfile(worldProperties,
                        callingPlayer).getPlayerClassType()),width >> 1, height >> 2, ColorHelper.Argb.getArgb(255,
                        255,255,255));


    }
}
