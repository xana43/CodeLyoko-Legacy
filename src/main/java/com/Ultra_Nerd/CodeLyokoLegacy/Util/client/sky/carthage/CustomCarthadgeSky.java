package com.Ultra_Nerd.CodeLyokoLegacy.Util.client.sky.carthage;

public record CustomCarthadgeSky() /*implements ISkyRenderHandler*/ {
    /*


    private static final ResourceLocation texturelocation = new ResourceLocation(CodeLyokoMain.MOD_ID, "textures/skies/sector5/sector5sky.png");


    @Override
    public void render(int ticks, float partialTicks, @NotNull PoseStack matrixStack, ClientLevel world, Minecraft mc) {

        RenderSystem.setShaderTexture(0,texturelocation);
        final Tesselator tessellator = Tesselator.getInstance();
        final BufferBuilder bufferBuilder = tessellator.getBuilder();


        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        for (int i = 0; i < 6; ++i) {

            matrixStack.pushPose();
            if(i == 0)
            {
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(0.0F));
            }
            if (i == 1) {
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));

            }

            if (i == 2) {
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(-90.0F));
            }

            if (i == 3) {
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(180.0F));
            }

            if (i == 4) {
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
            }

            if (i == 5) {
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(-90.0F));
            }
            final Matrix4f matrix4f = matrixStack.last().pose();
            bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
            bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).uv(0.0F, 0.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).uv(0.0F, 16.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, 100.0F).uv(16.0F, 16.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, -100.0F).uv(16.0F, 0.0F).color(40, 40, 40, 255).endVertex();
            tessellator.end();
            matrixStack.popPose();
        }



    }

     */
}
