package com.Ultra_Nerd.CodeLyokoLegacy.screens;


import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandlerCommon;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerInterfaceScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerProfile;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.client.GUI.LyokoButton;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.onyxstudios.cca.api.v3.level.LevelComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Npc;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import org.joml.Quaternionf;

@Environment(EnvType.CLIENT)
public final class ComputerInterfaceUi extends HandledScreen<ComputerInterfaceScreenHandler> {
    private static final Identifier TEXTURE = CodeLyokoMain.codeLyokoPrefix("textures/gui/computer_gui.png");


    public ComputerInterfaceUi(final ComputerInterfaceScreenHandler handler, final PlayerInventory inventory,
            final Text title) {
        super(handler, inventory, title);
        this.playerInventoryTitleY = -90;
    }


    @Override
    public void render(final MatrixStack matrices, final int mouseX, final int mouseY, final float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);


    }

    @Override
    protected void drawBackground(final MatrixStack matrices, final float delta, final int mouseX, final int mouseY) {

    }


    @Override
    protected void init() {
        super.init();
        this.addDrawableChild(new LyokoButton(this,80,20,Text.literal("test"),
                button -> {

                   final PacketByteBuf namebuf = PacketByteBufs.create();
                    CardinalData.PlayerSavedProfile.saveProfile(handler.getWorldProperties(),
                            handler.getPlayer());
                   //ClientPlayNetworking.send(PacketHandlerCommon.ComputerUIChannelID, namebuf);
                  if(CardinalData.PlayerSavedProfile.getPlayerProfile(handler.getWorldProperties(),
                           handler.getPlayer()) != null) {
                       CardinalData.PlayerSavedProfile.getPlayerProfile(handler.getWorldProperties(),
                               handler.getPlayer()).refreshPlayerClass();
                   }
                }));


    }

    @Override
    public void renderBackground(final MatrixStack matrices) {
        //super.renderBackground(matrices);
        RenderSystem.setShaderTexture(0,TEXTURE);
        drawTexture(matrices,0,0,0,0,1280,720,this.width,this.height);
        matrices.push();
        matrices.scale(0.4f,0.4f,0.4f);
        final PlayerProfile playerProfile =
                CardinalData.PlayerSavedProfile.getPlayerProfile(handler.getWorldProperties(),
                        getScreenHandler().getPlayer());
        if(playerProfile != null) {
            drawEntity((this.width>>3) - 10,(this.height>>2) + 10,30,0,0,playerProfile.getPlayer());
            drawPlayerClasses(playerProfile,matrices,textRenderer);
            drawPlayerDNA(playerProfile,matrices,textRenderer);
        }
        matrices.pop();
    }
    private void drawPlayerDNA(final PlayerProfile playerProfile, final MatrixStack matrixStack, final TextRenderer textRenderer)
    {
        final Text DNASnip =
                Text.of(playerProfile.getDNA().substring(0,10)).getWithStyle(ConstantUtil.Styles.HUD.getThisStyle()).get(0);
        drawCenteredText(matrixStack, textRenderer,DNASnip,(int) (this.width / 3.5f),(int)(this.height/1.1f),
                ColorHelper.Argb.getArgb(255,255,255,255));
    }
    private void drawPlayerClasses(final PlayerProfile playerProfile,final MatrixStack matrixStack,final TextRenderer textRenderer)
    {
        final int color = ColorHelper.Argb.getArgb(255, 255, 255, 255);
        final MutableText prependClass = Text.translatable("lyoko.screen.class").append(":");
        switch (playerProfile.getPlayerClassType())
        {
            case 0 -> drawCenteredText(matrixStack,textRenderer,
                    prependClass.append(Text.translatable("lyoko.class.feline")).setStyle(ConstantUtil.Styles.HUD.getThisStyle()),
                    (int) (this.width / 3.5f),(int) (this.height / 1.2f),color);
            case 1 -> drawCenteredText(matrixStack,textRenderer,
                    prependClass.append(Text.translatable("lyoko.class.samurai")).setStyle(ConstantUtil.Styles.HUD.getThisStyle()),
                    (int) (this.width / 3.5f),(int) (this.height / 1.2f),color);
            case 2 -> drawCenteredText(matrixStack,textRenderer,
                    prependClass.append(Text.translatable("lyoko.class.ninja")).setStyle(ConstantUtil.Styles.HUD.getThisStyle()),
                    (int) (this.width / 3.5f),(int) (this.height / 1.2f),color);
            case 3 -> drawCenteredText(matrixStack,textRenderer,
                    prependClass.append(Text.translatable("lyoko.class.guardian")).setStyle(ConstantUtil.Styles.HUD.getThisStyle()),
                    (int) (this.width / 3.5f),(int) (this.height / 1.2f),color);
            case 4 -> drawCenteredText(matrixStack,textRenderer,
                    prependClass.append(Text.translatable("lyoko.class.warrior")).setStyle(ConstantUtil.Styles.HUD.getThisStyle()),
                    (int) (this.width / 3.5f),(int) (this.height / 1.2f),color);
        }
    }
    private static void drawEntity(int x, int y, int size, float mouseX, float mouseY, LivingEntity entity) {
        final float f = (float)Math.atan(mouseX / 40.0F);
        final float g = (float)Math.atan(mouseY / 40.0F);
        final MatrixStack matrixStack = RenderSystem.getModelViewStack();
        matrixStack.push();
        matrixStack.translate((float)x, (float)y, 1050.0F);
        matrixStack.scale(1.0F, 1.0F, -1.0F);
        RenderSystem.applyModelViewMatrix();
        final MatrixStack matrixStack2 = new MatrixStack();
        matrixStack2.translate(0.0F, 0.0F, 1000.0F);
        matrixStack2.scale((float)size, (float)size, (float)size);
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
        VertexConsumerProvider.Immediate immediate = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
        RenderSystem.runAsFancy(() -> entityRenderDispatcher.render(entity, 0.0, 0.0, 0.0, 0.0F, 1.0F, matrixStack2, immediate, 15728880));
        immediate.draw();
        entity.bodyYaw = h;
        entity.setYaw(i);
        entity.setPitch(j);
        entity.prevHeadYaw = k;
        entity.headYaw = l;
        matrixStack.pop();
        RenderSystem.applyModelViewMatrix();
        DiffuseLighting.disableGuiDepthLighting();
    }
    @Override
    public boolean shouldPause() {
        return false;
    }
}