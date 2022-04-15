package com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.CapabilityPlayerClassSync;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerSaveHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.ClientCapabilitySync;
import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerClassType;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public final class ClassScreen extends Screen {

    private static final ResourceLocation textures = CodeLyokoMain.CodeLyokoPrefix("textures/gui/laptopguibase.png");
    private static final int xSize = 1280,  ySize = 720;
    private static int x,y;
    private ImageButton feline,samurai,ninja,guardian,warrior;
    private static final int classLabelLocation = 3;
    private int IndicatorColor = 0;
    public ClassScreen(final Component pTitle) {
        super(pTitle);
    }
    @Override
    public void render(final @NotNull PoseStack pPoseStack, final int pMouseX, final int pMouseY, final float pPartialTick) {
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderBackground(pPoseStack);
        //feline option
        feline.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredString(pPoseStack,font, feline.getMessage(), feline.x + (feline.getWidth() >> 1), feline.y,Color.MAGENTA.getRGB());
        //samurai option
        samurai.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredString(pPoseStack,font,samurai.getMessage(),samurai.x + (samurai.getWidth() >> 1),samurai.y,2007);
        //ninja option
        ninja.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredString(pPoseStack,font,ninja.getMessage(),ninja.x + (ninja.getWidth() >> 1),ninja.y, 5125);
        //guardian option
        guardian.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredString(pPoseStack,font,guardian.getMessage(),guardian.x + (guardian.getWidth() >> 1),guardian.y,0xff369b);
        //warrior option
        warrior.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredString(pPoseStack,font,warrior.getMessage(),warrior.x + (guardian.getWidth() >> 1),warrior.y,Color.DARK_GRAY.getRGB());
        //current class
        if(ClientCapabilitySync.getPlayerClassType() != null) {
            drawCenteredString(pPoseStack, font, new TextComponent("Current Class: ".concat(ClientCapabilitySync.getPlayerClassType().getClassName())).withStyle(ConstantUtil.HUD), this.width >> classLabelLocation, this.height >> classLabelLocation - 1, IndicatorColor);
        }
        else
        {
            drawCenteredString(pPoseStack,font,new TextComponent("no class assigned").withStyle(ConstantUtil.HUD),this.width >> classLabelLocation, this.height >> classLabelLocation - 1,Color.WHITE.getRGB());
        }
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }




    protected void init() {
        super.init();
        x = (this.width - xSize) >> 1;
        y = (this.height - ySize) >> 1;
        setFeline();
        setSamurai();
        setNinja();
        setGuardian();
        setWarrior();
        addWidget(feline);
        addWidget(samurai);
        addWidget(ninja);
        addWidget(guardian);
        addWidget(warrior);
        if(ClientCapabilitySync.getPlayerClassType() != null) {

            switch (ClientCapabilitySync.getPlayerClassType().getClassName()) {
                case "Felyne" -> IndicatorColor = Color.MAGENTA.getRGB();
                case "Samurai" -> IndicatorColor = 2007;
                case "Ninja" -> IndicatorColor = 5125;
                case "Guardian" -> IndicatorColor = Color.PINK.getRGB();
            }
        }

    }


    private void PressOperation()
    {

        assert minecraft != null;
        assert minecraft.player != null;







        assert minecraft != null;
        if (minecraft.getSingleplayerServer() != null) {
            if(minecraft.getSingleplayerServer().isSingleplayer()) {
                minecraft.getSingleplayerServer().getPlayerList().saveAll();
            }
        }

        assert minecraft.level != null;
        if(minecraft.getCurrentServer() != null && minecraft.player != null) {

            ServerSaveHandler.send(false);

        }
    }

//set buttons for each class
    private void setFeline()
    {
        feline =  new ImageButton(this.width >> 3, this.height >> 1, 30, 30, 128, 0, 31, textures,
                256, 256, (input) -> {

            PressOperation();
            CapabilityPlayerClassSync.Sync(PlayerClassType.Feline);
            IndicatorColor = Color.MAGENTA.getRGB();



            }, new TextComponent("feline").withStyle(ConstantUtil.HUD));
        feline.setFGColor(0x1d5e18);
    }

    private void setSamurai()
    {
        samurai =  new ImageButton(this.width >> 2, this.height >> 1, 30, 30, 128, 0, 31, textures,
                128, 128, (input) -> {

            CapabilityPlayerClassSync.Sync(PlayerClassType.Samurai);
            IndicatorColor = 2007;
            PressOperation();
           // classIndicatorString.replace(15,ClientCapabilitySync.getPlayerClassType().getClassName().length() + 17,ClientCapabilitySync.getPlayerClassType().getClassName());
            }, new TextComponent("samurai").withStyle(ConstantUtil.HUD));
        samurai.setFGColor(0x1d5e18);
    }

    private void setNinja()
    {
        ninja =  new ImageButton((int) (this.width / 2.8f), this.height >> 1, 30, 30, 128, 0, 31, textures,
                256, 256, (input) -> {
            CapabilityPlayerClassSync.Sync(PlayerClassType.Ninja);
            IndicatorColor = 5125;
            PressOperation();}, new TextComponent("ninja"));
        ninja.setFGColor(0x1d5e18);
    }
    private void setGuardian()
    {
        guardian =  new ImageButton((int)(this.width / 2.1f), this.height >> 1, 30, 30, 128, 0, 31, textures,
                256, 256, (input) -> {PressOperation();
            IndicatorColor = 0xff369b;
            CapabilityPlayerClassSync.Sync(PlayerClassType.Guardian);
            }, new TextComponent("guardian"));
        guardian.setFGColor(0x1d5e18);
    }

    private void setWarrior()
    {
        warrior =  new ImageButton((this.width >> 1) + 40 , this.height >> 1, 30, 30, 128, 0, 31, textures,
                256, 256, (input) -> PressOperation(), new TextComponent("warrior"));
        warrior.setFGColor(0x1d5e18);
    }


    @Override
    public void renderBackground(@NotNull PoseStack pPoseStack) {
        // super.renderBackground(pPoseStack);
        RenderSystem.setShaderTexture(0,textures);
        blit(pPoseStack,x, y,  0,  -60, xSize, ySize,(-(this.width - xSize) >> 1) , (-(this.height - ySize)));
    }
}
