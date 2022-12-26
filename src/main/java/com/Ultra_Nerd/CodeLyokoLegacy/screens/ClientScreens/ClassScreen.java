package com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandlerCommon;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ConstantUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public final class ClassScreen extends Screen {


    private static final Identifier textures = CodeLyokoMain.codeLyokoPrefix("textures/gui/laptopguibase_pot.png");
    private static final int xSize = 1024, ySize = 1024;
    private static final int colors = ColorHelper.Argb.getArgb(1, 255, 0, 255);
    private static int x;
    private TexturedButtonWidget feline, samurai, ninja, guardian, warrior;
    private int IndicatorColor = 0;

    public ClassScreen() {
        super(Text.empty());
    }



    private void drawClassIndicator(Text classname, MatrixStack pPoseStack) {
        drawCenteredText(pPoseStack, textRenderer,
                classname.getWithStyle(ConstantUtil.Styles.HUD.getThisStyle()).get(0), this.width >> 2,
                this.height >> 2, IndicatorColor);
    }

    @Override
    public void render(final @NotNull MatrixStack pPoseStack, final int pMouseX, final int pMouseY, final float pPartialTick) {
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderBackground(pPoseStack);
        //feline option
        feline.render(pPoseStack, pMouseX, pMouseY, pPartialTick);

        drawCenteredText(pPoseStack, textRenderer, feline.getMessage(), feline.getX() + (feline.getWidth() >> 1),
                feline.getY(),
                colors);
        //samurai option
        samurai.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredText(pPoseStack, textRenderer, samurai.getMessage(), samurai.getX() + (samurai.getWidth() >> 1),
                samurai.getY(), 2007);
        //ninja option
        ninja.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredText(pPoseStack, textRenderer, ninja.getMessage(), ninja.getX() + (ninja.getWidth() >> 1), ninja.getY(),
                5125);
        //guardian option
        guardian.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredText(pPoseStack, textRenderer, guardian.getMessage(), guardian.getX() + (guardian.getWidth() >> 1),
                guardian.getY(), 0xff369b);
        //warrior option
        warrior.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredText(pPoseStack, textRenderer, warrior.getMessage(), warrior.getX() + (guardian.getWidth() >> 1),
                warrior.getY(), 0xa9a9a9);
        //current class
        if (IndicatorColor != 0) {
            switch (CardinalData.LyokoClass.getLyokoClass(this.client.player)) {
                case 0 -> drawClassIndicator(Text.translatable("lyoko.class.feline"), pPoseStack);
                case 1 -> drawClassIndicator(Text.translatable("lyoko.class.samurai"), pPoseStack);
                case 2 -> drawClassIndicator(Text.translatable("lyoko.class.ninja"), pPoseStack);
                case 3 -> drawClassIndicator(Text.translatable("lyoko.class.guardian"), pPoseStack);
                case 4 -> drawClassIndicator(Text.translatable("lyoko.class.warrior"),pPoseStack);
                default -> {}
            }
        } else {
            drawCenteredText(pPoseStack, textRenderer,
                    Text.translatable("lyoko.class.null").getWithStyle(ConstantUtil.Styles.HUD.getThisStyle()).get(0),
                    this.width >> 2, this.height >> 2, IndicatorColor);
        }
        /*
        if(ClientCapabilitySync.getPlayerClassType() != null) {
            drawCenteredText(pPoseStack, font, new TextComponent("Current Class: ".concat(ClientCapabilitySync.getPlayerClassType().getClassName())).withStyle(ConstantUtil.HUD), this.width >> 2, this.height >> 2, IndicatorColor);
        }
        else
        {
            drawCenteredText(pPoseStack,font,new TextComponent("no class assigned").withStyle(ConstantUtil.HUD),this.width >> 2, this.height >> 2,Color.WHITE.getRGB());
        }

         */
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    protected void init() {
        super.init();
        assert this.client != null;


        x = (this.width - xSize) >> 1;
        //y = (this.height - ySize) >> 1;
        setFeline();
        setSamurai();
        setNinja();
        setGuardian();
        setWarrior();
        addDrawable(feline);
        addDrawable(samurai);
        addDrawable(ninja);
        addDrawable(guardian);
        addDrawable(warrior);
        switch (CardinalData.LyokoClass.getLyokoClass(this.client.player)) {
            case 0 -> IndicatorColor = colors;
            case 1 -> IndicatorColor = 2007;
            case 2 -> IndicatorColor = 5125;
            case 3 -> IndicatorColor = 0x1d5e18;
            case 4 -> IndicatorColor = ColorHelper.Argb.getArgb(255,10,10,10);
            default -> {}
        }



    }

    @Override
    public boolean mouseClicked(final double mouseX, final double mouseY, final int button) {
        feline.mouseClicked(mouseX, mouseY, button);
        samurai.mouseClicked(mouseX, mouseY, button);
        ninja.mouseClicked(mouseX, mouseY, button);
        guardian.mouseClicked(mouseX, mouseY, button);
        warrior.mouseClicked(mouseX, mouseY, button);
        return super.mouseClicked(mouseX, mouseY, button);

    }

    //set buttons for each class
    private void setFeline() {
        feline = new TexturedButtonWidget(this.width >> 3, this.height >> 1, 30, 30, 128, 0, 31, textures,
                256, 256, (input) -> {


            //((PlayerEXT) this.client.player).setClass(0);

            //CapabilityPlayerClassSync.Sync(PlayerClassType.Feline);

            assert this.client != null;
            assert this.client.player != null;
            this.client.player.playSound(ModSounds.GUISOUND, 1, 6);
            final PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(0);
            ClientPlayNetworking.send(PacketHandlerCommon.ClassScreenID,buf);


        }, Text.of("feline").getWithStyle(ConstantUtil.Styles.HUD.getThisStyle().withColor(colors)).get(0));

    }

    private void setSamurai() {
        samurai = new TexturedButtonWidget((int) (this.width / 3f), this.height >> 1, 30, 30, 128, 0, 31, textures,
                128, 128, (input) -> {


            this.client.player.playSound(ModSounds.GUISOUND, 1, 6);
            final PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(1);
            ClientPlayNetworking.send(PacketHandlerCommon.ClassScreenID,buf);
            //ClassID =1;
            // classIndicatorString.replace(15,ClientCapabilitySync.getPlayerClassType().getClassName().length() + 17,ClientCapabilitySync.getPlayerClassType().getClassName());
        }, Text.of("samurai").getWithStyle(ConstantUtil.Styles.HUD.getThisStyle().withColor(2007)).get(0));

    }

    private void setNinja() {
        ninja = new TexturedButtonWidget(this.width >> 1, this.height >> 1, 30, 30, 128, 0, 31, textures,
                256, 256, (input) -> {
            //CapabilityPlayerClassSync.Sync(PlayerClassType.Ninja);
            this.client.player.playSound(ModSounds.GUISOUND, 1, 6);
            final PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(2);
            ClientPlayNetworking.send(PacketHandlerCommon.ClassScreenID,buf);
            //ClassID = 2;
        }, Text.of("ninja").getWithStyle(ConstantUtil.Styles.HUD.getThisStyle().withColor(5125)).get(0));

    }

    private void setGuardian() {
        guardian = new TexturedButtonWidget((this.width >> 1) + 80, this.height >> 1, 30, 30, 128, 0, 31, textures,
                256, 256, (input) -> {
            final PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(3);
            ClientPlayNetworking.send(PacketHandlerCommon.ClassScreenID,buf);
            },
                Text.of("guardian").getWithStyle(ConstantUtil.Styles.HUD.getThisStyle().withColor(0x1d5e18)).get(0));


    }

    private void setWarrior() {
        warrior = new TexturedButtonWidget((this.width >> 1) + 150, this.height >> 1, 30, 30, 128, 0, 31, textures,
                256, 256, (input) -> CardinalData.LyokoClass.setLyokoclass(this.client.player,4),
                Text.of("warrior").getWithStyle(ConstantUtil.Styles.HUD.getThisStyle().withColor(0x1d5e18)).get(0));

    }


    @Override
    public void renderBackground(@NotNull MatrixStack pPoseStack) {
        // super.renderBackground(pPoseStack);
        RenderSystem.setShaderTexture(0, textures);
        drawTexture(pPoseStack, x, 0, 0, 0, xSize, ySize);
    }





/*

    @Override
    public void saveClass(final NbtCompound nbt, final CallbackInfo ci) {
        final NbtCompound playerCompount = new NbtCompound();
        playerCompount.putInt("player_class",ClassID);
        nbt.put(CodeLyokoMain.MOD_ID, playerCompount);
    }

    @Override
    public void readeClass(final NbtCompound nbt, final CallbackInfo ci) {

    }

 */


}
