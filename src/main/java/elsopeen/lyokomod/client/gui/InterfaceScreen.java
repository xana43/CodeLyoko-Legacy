package elsopeen.lyokomod.client.gui;

import elsopeen.lyokomod.container.InterfaceContainer;
import elsopeen.lyokomod.init.ModBlocks;
import elsopeen.lyokomod.client.render.Interface;
import elsopeen.lyokomod.LyokoMod;
import elsopeen.lyokomod.init.ModContainerTypes;
import elsopeen.lyokomod.tileentity.InterfaceTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftGame;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.fonts.Font;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.lwjgl.opengl.GL11;

/**
 * As Minecraft Screen, so GUI for the Interface block
 */
public class InterfaceScreen extends ContainerScreen<InterfaceContainer> {

    public static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("lyokomod:textures/gui/interface.png");
    private TextFieldWidget textField;


    /**
     * Base constructor
     * @param interfaceContainer container in order to have a custom gui
     * @param playerInventory inv of player opening the gui
     * @param title title of gui
     */
    public InterfaceScreen(final InterfaceContainer interfaceContainer, final PlayerInventory playerInventory, final ITextComponent title) {
        super(interfaceContainer, playerInventory, title);
    }

    /**
     * Function to show the GUI
     * @param mouseX pos_x of mouse
     * @param mouseY pos_y of mouse
     * @param partialTicks Ticks
     */
    @Override
    public void render(final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        final InterfaceTileEntity tileEntity = this.container.interfaceTileEntity;
        /*String tooltip = "CODE";
        this.renderTooltip(tooltip, this.guiLeft, this.guiTop);*/
        this.textField.render(mouseX, mouseY, partialTicks);
    }

    /**
     * Draw the background
     * @param mouseX pos_x of mouse
     * @param mouseY pos_y of mouse
     * @param partialTicks Ticks
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getInstance().getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        this.blit(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    /**
     * Function to initialise GUI's elements
     */
    protected void init() {
        this.initTextField();
        final int halfW = this.width / 2;
        final int halfH = this.height / 2;
       /* this.addButton(new ExtendedButton(halfW - 150, halfH, 150, 20, I18n.format("gui." + LyokoMod.MOD_ID + ".interface"),
                $ -> {
                    final Interface anInterface = this.tileEntity.anInterface;
                    if (anInterface != null)
                        anInterface.compile();
                }
        ));
        // "Done" button exits the GUI
        this.addButton(new ExtendedButton(halfW, halfH, 150, 20, I18n.format("gui.done"),
                $ -> this.minecraft.displayGuiScreen(null)
        ));*/
        super.init();
    }

    /**
     * Function to add a textField in the GUI
     * Broken for now
     */
    protected void initTextField() {
        int i = (this.width - 134) / 2;
        int j = (this.height - 33) / 2;
        String s = this.textField != null ? this.textField.getText() : "";
        FontRenderer gunship_font = this.getMinecraft().getFontResourceManager().getFontRenderer(new ResourceLocation("lyokomod:gunship"));
        assert gunship_font != null;
        this.textField = new TextFieldWidget(gunship_font, i+6, j-10, 134, 33, I18n.format("gui.lyokomod.interface_input"));
        this.textField.setMaxStringLength(50);
        this.textField.setEnableBackgroundDrawing(false);
        this.textField.setVisible(true);
        this.textField.setTextColor(16777215);
        this.textField.setFocused2(true);

    }

    @Override
    public boolean keyPressed(int charID, int p_keyPressed_2_, int p_keyPressed_3_) {
        this.textField.keyPressed(charID, p_keyPressed_2_, p_keyPressed_3_);
        if(!(this.getMinecraft().gameSettings.keyBindInventory.matchesKey(charID, p_keyPressed_2_) && this.textField.isFocused())) return super.keyPressed(charID, p_keyPressed_2_, p_keyPressed_3_);
        return true;
    }

    @Override
    public boolean charTyped(char p_charTyped_1_, int p_charTyped_2_) {
        this.textField.charTyped(p_charTyped_1_, p_charTyped_2_);
        return true;
    }

    @Override
    public boolean mouseClicked(double p_mouseClicked_1_, double p_mouseClicked_3_, int p_mouseClicked_5_) {
        this.textField.mouseClicked(p_mouseClicked_1_, p_mouseClicked_3_, p_mouseClicked_5_);
        return super.mouseClicked(p_mouseClicked_1_, p_mouseClicked_3_, p_mouseClicked_5_);
    }



    @Override
    public boolean isPauseScreen() {
        return false; // Don't pause the game when this screen is open
    }

}
