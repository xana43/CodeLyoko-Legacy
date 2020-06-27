package com.Ultra_Nerd.CodeLyokoRemake15.screens;


import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.TowerInterfaceContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.TowerInterfaceTileEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class TowerGUI extends ContainerScreen<TowerInterfaceContainer>
{

	private static final ResourceLocation TEXTURES = new ResourceLocation(Base.MOD_ID + ":textures/gui/towerinterface.png");
	private TextFieldWidget text;




    private TowerInterfaceTileEntity tileentity;
    int x,y;


    public TowerGUI(TowerInterfaceContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 200;
        this.ySize = 141;


    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        this.text.mouseClicked(mouseX,mouseY,mouseButton);
        return super.mouseClicked(mouseX,mouseY,mouseButton);
    }

    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        this.renderBackground();
        super.render(p_render_1_,p_render_2_,p_render_3_);
        this.text.render(p_render_1_,p_render_2_,p_render_3_);
    }

    @Override
    public void tick() {
        this.text.tick();

    }



    @Override
    public void init() {
        super.init();
         x = (this.width - this.xSize) / 2;
         y = (this.height - this.ySize) / 2;
         this.setTextField();

    }
    @Override
    public boolean keyPressed(int Key, int p_keyPressed_2_, int p_keyPressed_3_) {


        switch(Key)
        {
            case 8:this.text.deleteFromCursor(1);

        }
        this.text.keyPressed(Key,p_keyPressed_2_,p_keyPressed_3_);
        return super.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
    }

    @Override
    public boolean charTyped(char key, int Keynum) {

        this.text.charTyped(Character.toUpperCase(key),Keynum);
        return super.charTyped(key,Keynum);

    }


    protected void setTextField()
    {
        int tx = this.width / 2 ;
        int ty = this.height / 2;
        //String Code = this.text != null ? this.text.getText() : "";
        FontRenderer gunship_font = this.getMinecraft().getFontResourceManager().getFontRenderer(new ResourceLocation(Base.MOD_ID + ":gunship"));
        assert gunship_font != null;
        this.text = new TextFieldWidget(gunship_font, tx-70, ty-10, 200, 33, I18n.format("gui.lyokomod.interface_input"));
        this.text.setMaxStringLength(7);
        this.text.setEnableBackgroundDrawing(false);
        this.text.setVisible(true);
        this.text.setTextColor(16777215);
        this.text.setFocused2(true);
        this.text.setEnabled(true);
        this.text.setCursorPositionZero();
        this.text.setCanLoseFocus(false);
        this.text.isFocused();
        this.text.canWrite();
    }





    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        this.minecraft.getTextureManager().bindTexture(TEXTURES);

        this.blit(x,y,0,0,this.xSize,this.ySize);
    }



}