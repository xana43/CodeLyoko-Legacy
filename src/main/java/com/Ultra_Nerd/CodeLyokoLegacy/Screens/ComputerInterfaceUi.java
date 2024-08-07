package com.Ultra_Nerd.CodeLyokoLegacy.Screens;


import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Player.PlayerProfile;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerInterfaceScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.Client.GUI.LyokoButton;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.ConstantUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import org.joml.Matrix4fStack;
import org.joml.Quaternionf;

@Environment(EnvType.CLIENT)
public final class ComputerInterfaceUi extends HandledScreen<ComputerInterfaceScreenHandler> {
    private static final Identifier TEXTURE = CodeLyokoMain.codeLyokoPrefix("textures/gui/computer_gui.png");
    private static final Identifier PREVIEW_CARTHAGE = CodeLyokoMain.codeLyokoPrefix(
            "textures/gui/computer_gui_preview_images/carthage.png");
    private static final Identifier PREVIEW_FOREST = CodeLyokoMain.codeLyokoPrefix(
            "textures/gui/computer_gui_preview_images/forest.jpg");
    private static final Identifier PREVIEW_DESERT = CodeLyokoMain.codeLyokoPrefix(
            "textures/gui/computer_gui_preview_images/desert.jpg");
    private static final Identifier PREVIEW_ICE = CodeLyokoMain.codeLyokoPrefix(
            "textures/gui/computer_gui_preview_images/ice.jpg");
    private static final Identifier PREVIEW_MOUNTAIN = CodeLyokoMain.codeLyokoPrefix(
            "textures/gui/computer_gui_preview_images/mountain.png");
    private final LyokoButton carthage = new LyokoButton(0, 0, 80, 20, Text.literal("Carthage"), button -> {


    }) {
    };
    private final LyokoButton forest = new LyokoButton(0, 0, 80, 20, Text.literal("Forest"), button -> {

    });
    private final LyokoButton desert = new LyokoButton(0, 0, 80, 20, Text.literal("Desert"), button -> {

    });
    private final LyokoButton ice = new LyokoButton(0, 0, 80, 20, Text.literal("Ice"), button -> {
    });
    private final LyokoButton mountain = new LyokoButton(0, 0, 80, 20, Text.literal("Mountain"), button -> {
    });

    public ComputerInterfaceUi(final ComputerInterfaceScreenHandler handler, final PlayerInventory inventory, final Text title) {
        super(handler, inventory, title);
        this.playerInventoryTitleY = -90;
    }

    private static void drawEntity(int x, int y, LivingEntity entity) {
        final float f = (float) Math.atan((float) 0 / 40.0F);
        final float g = (float) Math.atan((float) 0 / 40.0F);
        final Matrix4fStack matrixStack = RenderSystem.getModelViewStack();
        matrixStack.pushMatrix();
        matrixStack.translate((float) x, (float) y, 1050.0F);
        matrixStack.scale(1.0F, 1.0F, -1.0F);
        RenderSystem.applyModelViewMatrix();
        final MatrixStack matrixStack2 = new MatrixStack();
        matrixStack2.translate(0.0F, 0.0F, 1000.0F);
        matrixStack2.scale((float) 30, (float) 30, (float) 30);
        final Quaternionf quaternionf = (new Quaternionf()).rotateZ(3.1415927F);
        final Quaternionf quaternionf2 = (new Quaternionf()).rotateX(g * 20.0F * 0.017453292F);
        quaternionf.mul(quaternionf2);
        matrixStack2.multiply(quaternionf);
        final float h = entity.bodyYaw;
        final float i = entity.getYaw();
        final float j = entity.getPitch();
        final float k = entity.prevHeadYaw;
        final float l = entity.headYaw;
        entity.bodyYaw = 180.0F + f * 20.0F;
        entity.setYaw(180.0F + f * 40.0F);
        entity.setPitch(-g * 20.0F);
        entity.headYaw = entity.getYaw();
        DiffuseLighting.method_34742();
        final EntityRenderDispatcher entityRenderDispatcher = MinecraftClient.getInstance().getEntityRenderDispatcher();
        quaternionf2.conjugate();
        entityRenderDispatcher.setRenderShadows(false);
        VertexConsumerProvider.Immediate immediate = MinecraftClient.getInstance().getBufferBuilders()
                .getEntityVertexConsumers();
        RenderSystem.runAsFancy(
                () -> entityRenderDispatcher.render(entity, 0.0, 0.0, 0.0, 0.0F, 1.0F, matrixStack2, immediate,
                        15728880));
        immediate.draw();
        entity.bodyYaw = h;
        entity.setYaw(i);
        entity.setPitch(j);
        entity.prevHeadYaw = k;
        entity.headYaw = l;
        matrixStack.popMatrix();
        RenderSystem.applyModelViewMatrix();
        DiffuseLighting.disableGuiDepthLighting();
    }

    @Override
    public void render(final DrawContext matrices, final int mouseX, final int mouseY, final float delta) {

        this.renderBackground(matrices,mouseX,mouseY,delta);
        super.render(matrices, mouseX, mouseY, delta);
        this.renderSectorImages(matrices);


    }

    private void renderSectorImages(final DrawContext matrixStack) {
        if (carthage.isHovered()) {
            //RenderSystem.setShaderTexture(0, PREVIEW_CARTHAGE);
            matrixStack.drawTexture(PREVIEW_CARTHAGE, (int) (this.width / 2.579f), (int) (this.height / 3.2f), 0, 0, 118,
                    96,
                    118, 96);

        }
        else if (forest.isHovered()) {
            //RenderSystem.setShaderTexture(0, PREVIEW_FOREST);
            matrixStack.drawTexture(PREVIEW_FOREST, (int) (this.width / 2.579f), (int) (this.height / 3.2f), 0, 0, 118,
                    96,
                    118, 96);

        }
        else if(desert.isHovered())
        {
           //RenderSystem.setShaderTexture(0,PREVIEW_DESERT);
            matrixStack.drawTexture(PREVIEW_DESERT, (int) (this.width / 2.579f), (int) (this.height / 3.2f), 0, 0, 118,
                    96,
                    118, 96);

        }
        else if(ice.isHovered())
        {
            //RenderSystem.setShaderTexture(0,PREVIEW_ICE);
            matrixStack.drawTexture(PREVIEW_ICE, (int) (this.width / 2.579f), (int) (this.height / 3.2f), 0, 0, 118,
                96,
                118, 96);


        }
        else if(mountain.isHovered())
        {
            //RenderSystem.setShaderTexture(0,PREVIEW_MOUNTAIN);
            matrixStack.drawTexture(PREVIEW_MOUNTAIN, (int) (this.width / 2.579f), (int) (this.height / 3.2f), 0, 0, 118,
                    96,
                    118, 96);

        }

    }

    @Override
    protected void drawBackground(final DrawContext matrices, final float delta, final int mouseX, final int mouseY) {

    }
    private final LyokoButton profileButton = new LyokoButton(0,0, 80, 20, Text.literal("lyoko.player.profiles"),
            button -> {


    });
    @Override
    protected void init() {
        super.init();
        profileButton.setPosition((int) (this.backgroundWidth / 10f), (int) (this.height / 1.5f));
        this.addDrawableChild(profileButton);
        final int sector_button_position = (int) (this.width/1.38f);
        carthage.setPosition(sector_button_position, this.height >> 2);
        carthage.setCentered();
        forest.setPosition(sector_button_position, this.height / 3);
        forest.setCentered();
        desert.setPosition(sector_button_position, (int) (this.height / 2.4f));
        desert.setCentered();
        ice.setPosition(sector_button_position,this.height / 2);
        ice.setCentered();
        mountain.setPosition(sector_button_position, (int) (this.height / 1.72f));
        mountain.setCentered();
        this.addDrawableChild(carthage);
        this.addDrawableChild(forest);
        this.addDrawableChild(desert);
        this.addDrawableChild(ice);
        this.addDrawableChild(mountain);

    }


    @Override
    public void renderBackground(final DrawContext matrices,final int mouseX, final int mouseY, final float delta) {
        //super.renderBackground(matrices);
        RenderSystem.setShaderTexture(0, TEXTURE);
        matrices.drawTexture(TEXTURE, 0, 0, 0, 0, 1280, 720, this.width, this.height);
        //matrices.push();
        //matrices.scale(0.4f, 0.4f, 0.4f);
        final PlayerProfile playerProfile = CardinalData.PlayerSavedProfile.getPlayerProfile(
                handler.getWorldProperties(), getScreenHandler().getPlayer());
        if (playerProfile != null) {
            drawEntity((this.width >> 3) - 10, (this.height >> 2) + 10, playerProfile.getPlayer());
            drawPlayerClasses(playerProfile, matrices, textRenderer);
            drawPlayerDNA(playerProfile, matrices, textRenderer);
        }
        //matrices.pop();

    }

    private void drawPlayerDNA(final PlayerProfile playerProfile, final DrawContext matrixStack,
            final TextRenderer textRenderer) {
        final Text DNASnip = Text.of(playerProfile.getDNA().substring(0, 20))
                .getWithStyle(ConstantUtil.Styles.HUD.getThisStyle()).get(0);
        final Text DNASnipHelix2 = Text.of(playerProfile.getDNA().substring(101, 121))
                .getWithStyle(ConstantUtil.Styles.HUD.getThisStyle()).get(0);
        matrixStack.drawCenteredTextWithShadow(textRenderer,
                Text.translatable("lyoko.dna.indicator").setStyle(ConstantUtil.Styles.HUD.getThisStyle()),
                (int) (this.width / 3.5f), (int) (this.height / 1.08f), ColorHelper.Argb.getArgb(255, 255, 255, 255));
        matrixStack.drawCenteredTextWithShadow(textRenderer, DNASnip, (int) (this.width / 3.5f),
                this.height,
                ColorHelper.Argb.getArgb(255, 255, 255, 255));
        matrixStack.drawCenteredTextWithShadow( textRenderer, DNASnipHelix2, (int) (this.width / 3.5f),
                (int) (this.height * 1.06f), ColorHelper.Argb.getArgb(255, 255, 255, 255));
    }
    private void drawPlayerClasses(final PlayerProfile playerProfile, final DrawContext matrixStack,
            final TextRenderer textRenderer) {
        final int classWidth = (int)(this.width / 3.5f);
        final int classHeight = (int)(this.height/1.2f);
        final int color = ColorHelper.Argb.getArgb(255, 255, 255, 255);
        final MutableText prependClass = Text.translatable("lyoko.screen.class").append(":");
        switch (playerProfile.getPlayerClassType()) {
            case 0 -> matrixStack.drawCenteredTextWithShadow( textRenderer,
                    prependClass.append(Text.translatable("lyoko.class.feline"))
                            .setStyle(ConstantUtil.Styles.HUD.getThisStyle()), classWidth,
                    classHeight, color);
            case 1 -> matrixStack.drawCenteredTextWithShadow(textRenderer,
                    prependClass.append(Text.translatable("lyoko.class.samurai"))
                            .setStyle(ConstantUtil.Styles.HUD.getThisStyle()), classWidth,
                    classHeight, color);
            case 2 -> matrixStack.drawCenteredTextWithShadow(textRenderer,
                    prependClass.append(Text.translatable("lyoko.class.ninja"))
                            .setStyle(ConstantUtil.Styles.HUD.getThisStyle()), classWidth,
                    classHeight, color);
            case 3 -> matrixStack.drawCenteredTextWithShadow(textRenderer,
                    prependClass.append(Text.translatable("lyoko.class.guardian"))
                            .setStyle(ConstantUtil.Styles.HUD.getThisStyle()), classWidth,
                    classHeight, color);
            case 4 -> matrixStack.drawCenteredTextWithShadow(textRenderer,
                    prependClass.append(Text.translatable("lyoko.class.warrior"))
                            .setStyle(ConstantUtil.Styles.HUD.getThisStyle()), classWidth,
                    classHeight, color);
        }
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}