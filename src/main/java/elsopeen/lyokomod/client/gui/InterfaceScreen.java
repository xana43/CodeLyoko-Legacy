package elsopeen.lyokomod.client.gui;

import elsopeen.lyokomod.init.ModBlocks;
import elsopeen.lyokomod.client.render.Interface;
import elsopeen.lyokomod.LyokoMod;
import elsopeen.lyokomod.tileentity.InterfaceTileEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.client.gui.widget.ExtendedButton;

public class InterfaceScreen extends Screen {

    private final InterfaceTileEntity tileEntity;

    public InterfaceScreen(final InterfaceTileEntity iteIN) {
        super(ModBlocks.INTERFACE.getNameTextComponent());
        this.tileEntity = iteIN;
    }

    @Override
    public void render(final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void init() {
        final int halfW = this.width / 2;
        final int halfH = this.height / 2;
        // "Refresh Mini Model" button rebuilds the tile's MiniModel
        this.addButton(new ExtendedButton(halfW - 150, halfH, 150, 20, I18n.format("gui." + LyokoMod.MOD_ID + ".refresh_mini_model"),
                $ -> {
                    final Interface anInterface = this.tileEntity.anInterface;
                    if (anInterface != null)
                        anInterface.compile();
                }
        ));
        // "Done" button exits the GUI
        this.addButton(new ExtendedButton(halfW, halfH, 150, 20, I18n.format("gui.done"),
                $ -> this.minecraft.displayGuiScreen(null)
        ));
        super.init();
    }

    @Override
    public boolean isPauseScreen() {
        return false; // Don't pause the game when this screen is open
    }

}
