package com.Ultra_Nerd.CodeLyokoLegacy.Screens;

public final class ElectricInfusingChamberScreen /*extends AbstractContainerScreen<ContainerElectricInfusing>*/ {
    /*
    public ElectricInfusingChamberScreen(@NotNull ContainerElectricInfusing p_97741_, @NotNull Inventory p_97742_, @NotNull Component p_97743_) {
        super(p_97741_, p_97742_, p_97743_);
    }

    @Override
    protected void renderBg(PoseStack p_97787_, float p_97788_, int p_97789_, int p_97790_) {

    }
    /*
    private static final ResourceLocation TEX = new ResourceLocation(CodeLyokoMain.MOD_ID + ":textures/gui/flouride_infuser.png");
    private PlayerInventory player;
    private ElectricInfusingChamberTileEntity tileentity;

    public ElectricInfusingChamberScreen(final ContainerElectricInfusing interfaceContainer, final PlayerInventory playerInventory, final ITextComponent title, final ElectricInfusingChamberTileEntity tileentity) {
        this(interfaceContainer, playerInventory, title);
        this.player = playerInventory;
        this.tileentity = tileentity;
    }

    public ElectricInfusingChamberScreen(final ContainerElectricInfusing interfaceContainer, final PlayerInventory playerInventory, final ITextComponent title) {
        super(interfaceContainer, playerInventory, title);
        this.tileentity = interfaceContainer.tileentity;
        this.player = playerInventory;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String tn = this.tileentity.getDisplayName().getUnformattedComponentText();

        this.font.drawString(tn, (this.xSize / 2.f - this.font.getStringWidth(tn) / 2.f), 5, 4210752);
        this.font.drawString(this.player.getDisplayName().getUnformattedComponentText(), 122, this.ySize - 96 + 2, 4210752);
        this.font.drawString(Integer.toString(this.tileentity.getENER()), 100, 72, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.blendColor(1.0f, 1.0f, 1.0f, 1.f);
        this.minecraft.getTextureManager().bindTexture(TEX);
        this.blit(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);


        int l = this.progress(10);
        this.blit(this.guiLeft + 98, this.guiTop + 57 + 12 - l, 176, 91 - l, 59, l + 1);

        int k = this.getEnergyStoredScaled(75);
        this.blit(this.guiLeft + 152, this.guiTop + 7, 300, 32, 16, 76 - k);

    }


    private int getEnergyStoredScaled(int pixels) {
        int i = this.tileentity.getENER();
        int j = this.tileentity.maxenergy();
        return i != 0 && j != 0 ? i * pixels / j : 0;
    }

    private int progress(int pixels) {
        int i = this.tileentity.getField(1);
        return i != 0 ? i * pixels / 25 : 0;
    }

     */

}
