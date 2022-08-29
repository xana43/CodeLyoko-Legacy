package com.Ultra_Nerd.CodeLyokoLegacy.Util.client.tileentity.renderer;

public final class QuantumChipletRenderer /*extends BlockEntityRenderers implements BlockEntityRenderer<QuantumChipletTileEntity>*/ {
    /*

    private float degrees;
    private int delay;

    public QuantumChipletRenderer(BlockEntityRenderDispatcher rendererDispatcherIn) {
        super();
        degrees = 0;
        delay = 0;
    }

    @Override
    public void render(@NotNull QuantumChipletTileEntity tileEntityIn, float partialTicks, @Nonnull PoseStack matrixStackIn,
                       @Nonnull MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {

        NonNullList<ItemStack> items = tileEntityIn.getItems();

        for (ItemStack stack : items) {
            if (!stack.isEmpty()) {
                if (stack.getItem() == ModItems.SOLID_QUANTUM.get()) {
                    matrixStackIn.pushPose();
                    matrixStackIn.scale(.5f, .5f, .5f);
                    matrixStackIn.translate(1, 1, 1);
                    matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(degrees++));
                    delay++;
                    if (delay == 10) {
                        PlaySound(tileEntityIn);
                        delay = 0;
                    }
                    render(stack, partialTicks, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
                    matrixStackIn.popPose();
                }
            }
        }
    }


    private void PlaySound(@NotNull QuantumChipletTileEntity tileEntity) {
        tileEntity.getLevel().playLocalSound(tileEntity.getBlockPos().getX(), tileEntity.getBlockPos().getY(), tileEntity.getBlockPos().getZ(), ModSounds.QUANTUMZAP.get(), SoundSource.BLOCKS, 1, 1, true);
    }


    public void render(@NotNull ItemStack stack, float p_112308_, @NotNull PoseStack matrix, @NotNull MultiBufferSource buff, int lightIn, int oveerlayIn) {
        Minecraft.getInstance().getItemRenderer().render(stack, ItemTransforms.TransformType.FIXED,false,matrix,buff,lightIn,oveerlayIn,null);
    }

     */
}
