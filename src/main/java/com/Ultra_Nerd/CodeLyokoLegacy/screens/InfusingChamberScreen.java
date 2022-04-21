package com.Ultra_Nerd.CodeLyokoLegacy.screens;

public final class InfusingChamberScreen /*extends ContainerScreen*/ {
    /*
    public InfusingChamberScreen(@NotNull ChestMenu p_98409_, @NotNull Inventory p_98410_, @NotNull Component p_98411_) {
        super(p_98409_, p_98410_, p_98411_);
    }
/*
    private static final ResourceLocation TEX = new ResourceLocation(CodeLyokoMain.MOD_ID + ":textures/gui/flouride_infuser.png");
    private Inventory player;
    private InfusingChamberTileEntity tileentity;

    public InfusingChamberScreen(final ContainerInfusing interfaceContainer, final Inventory playerInventory, final Component title, final InfusingChamberTileEntity tileentity) {
        this(interfaceContainer, playerInventory, title);
        this.player = playerInventory;
        this.tileentity = tileentity;
    }

    public InfusingChamberScreen(final ContainerInfusing interfaceContainer, final Inventory playerInventory, final Component title) {
        super(interfaceContainer, playerInventory, title);
        this.tileentity = interfaceContainer.get;
        this.player = playerInventory;
    }



    @Override
    public void render(PoseStack poseStack,final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack,mouseX, mouseY, partialTicks);
        this.renderTooltip(poseStack,mouseX, mouseY);
    }



    @Override
    public void renderBackground(PoseStack stack, int whateverthisis) {
        Component tn = this.tileentity.getDisplayName();

        this.font.draw(stack,tn, (this.getXSize() / 2.f - this.font.width(tn) / 2.f), 5, 4210752);
        this.font.draw(stack,this.player.getDisplayName().getString(), 122, this.getYSize() - 96 + 2, 4210752);

    }


    @Override
    protected void renderBg(PoseStack poseStack,float partialTicks, int mouseX, int mouseY) {
        GlStateManager._clearColor(1.0f, 1.0f, 1.0f, 1.f);
        this.minecraft.getTextureManager().bindForSetup(TEX);
        this.blit(poseStack,this.getGuiLeft(), this.getGuiTop(), 0, 0, this.getXSize(), this.getYSize());
        if (InfusingChamberTileEntity.isBurning(tileentity)) {
            int k = this.getBurnLeftSDca(13);
            this.blit(poseStack,this.getGuiLeft() + 57, this.getGuiTop() + 38 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.progess(59);
        this.blit(poseStack,this.getGuiLeft() + 98, this.getGuiTop() + 57 + 12 - l, 176, 91 - l, 59, l + 1);
        // TODO Auto-generated method stub

    }

    private int getBurnLeftSDca(int pixels) {
        int i = this.tileentity.getField(1);
        if (i == 0) {
            i = 20;
        }
        return this.tileentity.getField(0) * pixels / i;
    }


    private int progess(int pixels) {
        int i = this.tileentity.getField(2);
        int j = this.tileentity.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }


    @Override
    public boolean stillValid(Player p_38874_) {
        return false;
    }
    
 */
}
