package elsopeen.lyokomod.client.gui;

import elsopeen.lyokomod.init.ModBlocks;
import elsopeen.lyokomod.client.render.Interface;
import elsopeen.lyokomod.LyokoMod;
import elsopeen.lyokomod.tileentity.InterfaceTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.gui.widget.ExtendedButton;

public class InterfaceScreen extends Screen {

    public static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("lyokomod:gui/interface");
    private TextFieldWidget textField;

    private final InterfaceTileEntity tileEntity;

    public InterfaceScreen(final InterfaceTileEntity iteIN) {
        super(ModBlocks.INTERFACE.get().getNameTextComponent());
        this.tileEntity = iteIN;

    }

    @Override
    public void render(final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
    }

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

    protected void initTextField() {
        int i = (this.width - 147) / 2;
        int j = (this.height - 166) / 2;
        String s = this.textField != null ? this.textField.getText() : "";
        this.textField = new TextFieldWidget(this.getMinecraft().fontRenderer, i+5, j + 14, 80, 9 + 5, I18n.format("gui.lyokomod.interface_input"));
        this.textField.setMaxStringLength(50);
        this.textField.setEnableBackgroundDrawing(false);
        this.textField.setVisible(true);
        this.textField.setTextColor(16777215);
        this.textField.setText(s);
    }

    @Override
    public boolean isPauseScreen() {
        return false; // Don't pause the game when this screen is open
    }

}
