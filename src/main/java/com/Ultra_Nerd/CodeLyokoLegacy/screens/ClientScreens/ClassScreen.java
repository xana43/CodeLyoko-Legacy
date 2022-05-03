package com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import org.jetbrains.annotations.NotNull;




public final class ClassScreen extends Screen {


    private static final Identifier textures = CodeLyokoMain.CodeLyokoPrefix("textures/gui/laptopguibase_pot.png");
    private static final int xSize = 1024,  ySize = 1024;
    private static int x,y;
    private TexturedButtonWidget feline,samurai,ninja,guardian,warrior;
    private int IndicatorColor = 0;
    private static TextRenderer textRenderer;

    public ClassScreen() {
        super(Text.of(""));
    }

    @Override
    public void render(final @NotNull MatrixStack pPoseStack, final int pMouseX, final int pMouseY, final float pPartialTick) {
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderBackground(pPoseStack);
        //feline option
        feline.render(pPoseStack, pMouseX, pMouseY, pPartialTick);

        drawCenteredText(pPoseStack,textRenderer, feline.getMessage(), feline.x + (feline.getWidth() >> 1), feline.y, colors);
        //samurai option
        samurai.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredText(pPoseStack,textRenderer,samurai.getMessage(),samurai.x + (samurai.getWidth() >> 1),samurai.y,2007);
        //ninja option
        ninja.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredText(pPoseStack,textRenderer,ninja.getMessage(),ninja.x + (ninja.getWidth() >> 1),ninja.y, 5125);
        //guardian option
        guardian.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredText(pPoseStack,textRenderer,guardian.getMessage(),guardian.x + (guardian.getWidth() >> 1),guardian.y,0xff369b);
        //warrior option
        warrior.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredText(pPoseStack,textRenderer,warrior.getMessage(),warrior.x + (guardian.getWidth() >> 1),warrior.y,0xa9a9a9);
        //current class
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
private static final NbtCompound pClass = new NbtCompound();


    @Override
    public boolean shouldPause() {
        return false;
    }

    protected void init() {
        super.init();
        assert this.client != null;
        textRenderer = this.client.textRenderer;

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


        /*
        if(ClientCapabilitySync.getPlayerClassType() != null) {

            switch (ClientCapabilitySync.getPlayerClassType().getClassName()) {
                case "Felyne" -> IndicatorColor = Color.MAGENTA.getRGB();
                case "Samurai" -> IndicatorColor = 2007;
                case "Ninja" -> IndicatorColor = 5125;
                case "Guardian" -> IndicatorColor = Color.PINK.getRGB();
            }
        }

         */

    }

    @Override
    public boolean mouseClicked(final double mouseX, final double mouseY, final int button) {
        feline.mouseClicked(mouseX, mouseY, button);
        return super.mouseClicked(mouseX, mouseY, button);

    }

    private void PressOperation(String Key,int ID)
    {
        if(this.client != null)
        {
            if(this.client.player != null)
            {
                pClass.putUuid(Key,client.player.getUuid());
                CodeLyokoMain.persistantState.writeNbt(pClass);


            }
        }

    }
 private static final int colors = ColorHelper.Argb.getArgb(1,255,0,255);
//set buttons for each class
    private void setFeline()
    {
        feline =  new TexturedButtonWidget(this.width >> 3, this.height >> 1, 30, 30, 128, 0, 31, textures,
                256, 256, (input) -> {

            PressOperation("feline",0);
            //CapabilityPlayerClassSync.Sync(PlayerClassType.Feline);
            IndicatorColor = colors;
            assert this.client != null;
            assert this.client.player != null;
            this.client.player.playSound(ModSounds.GUI,1,6);





            }, Text.of("feline").getWithStyle(ConstantUtil.HUD.withColor(colors)).get(0));

    }

    private void setSamurai()
    {
        samurai =  new TexturedButtonWidget((int) (this.width / 3f), this.height >> 1, 30, 30, 128, 0, 31, textures,
                128, 128, (input) -> {

            //CapabilityPlayerClassSync.Sync(PlayerClassType.Samurai);
            IndicatorColor = 2007;
            PressOperation("samurai",1);
           // classIndicatorString.replace(15,ClientCapabilitySync.getPlayerClassType().getClassName().length() + 17,ClientCapabilitySync.getPlayerClassType().getClassName());
            }, Text.of("samurai").getWithStyle(ConstantUtil.HUD.withColor(2007)).get(0));

    }

    private void setNinja()
    {
        ninja =  new TexturedButtonWidget(this.width >> 1, this.height >> 1, 30, 30, 128, 0, 31, textures,
                256, 256, (input) -> {
            //CapabilityPlayerClassSync.Sync(PlayerClassType.Ninja);
            IndicatorColor = 5125;
            PressOperation("ninja",2);
            }, Text.of("ninja").getWithStyle(ConstantUtil.HUD.withColor(5125)).get(0));

    }
    private void setGuardian()
    {
        guardian =  new TexturedButtonWidget((this.width >> 1) + 80, this.height >> 1, 30, 30, 128, 0, 31, textures,
                256, 256, (input) -> {PressOperation("guardian",3);
            IndicatorColor = 0x1d5e18;
            //CapabilityPlayerClassSync.Sync(PlayerClassType.Guardian);
            }, Text.of("guardian").getWithStyle(ConstantUtil.HUD.withColor(0x1d5e18)).get(0));

    }

    private void setWarrior()
    {
        warrior =  new TexturedButtonWidget((this.width >> 1) + 150 , this.height >> 1, 30, 30, 128, 0, 31, textures,
                256, 256, (input) -> PressOperation("warrior",4), Text.of("warrior").getWithStyle(ConstantUtil.HUD.withColor(0x1d5e18)).get(0));

    }


    @Override
    public void renderBackground(@NotNull MatrixStack pPoseStack) {
        // super.renderBackground(pPoseStack);
        RenderSystem.setShaderTexture(0,textures);
        drawTexture(pPoseStack,x, 0,  0,  0, xSize, ySize);
    }


}
