package elsopeen.lyokomod.client.gui;

import elsopeen.lyokomod.container.InterfaceContainer;
import elsopeen.lyokomod.init.ModBlocks;
import elsopeen.lyokomod.client.render.Interface;
import elsopeen.lyokomod.LyokoMod;
import elsopeen.lyokomod.init.ModContainerTypes;
import elsopeen.lyokomod.tileentity.InterfaceTileEntity;
import net.minecraft.client.Minecraft;
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
     * @param interfaceContainer
     * @param playerInventory
     * @param title
     */
    public InterfaceScreen(final InterfaceContainer interfaceContainer, final PlayerInventory playerInventory, final ITextComponent title) {
        super(interfaceContainer, playerInventory, title);
    }

    /**
     * Function to show the GUI
     * @param mouseX
     * @param mouseY
     * @param partialTicks
     */
    @Override
    public void render(final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        final InterfaceTileEntity tileEntity = this.container.interfaceTileEntity;
        String tooltip = "CODE";
        this.renderTooltip(tooltip, 50, 50);
    }

    /**
     * Draw the background
     * @param partialTicks
     * @param mouseX
     * @param mouseY
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lyokomod:textures/interface.png"));
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
        //int i = (this.width - 147) / 2;
        //int j = (this.height - 166) / 2;
        String s = this.textField != null ? this.textField.getText() : "";
        this.textField = new TextFieldWidget(this.getMinecraft().fontRenderer, 50, 50, 80, 80, I18n.format("gui.lyokomod.interface_input"));
        this.textField.setMaxStringLength(50);
        this.textField.setEnableBackgroundDrawing(true);
        this.textField.setVisible(true);
        this.textField.setTextColor(16777215);

    }

    @Override
    public boolean isPauseScreen() {
        return false; // Don't pause the game when this screen is open
    }

}
