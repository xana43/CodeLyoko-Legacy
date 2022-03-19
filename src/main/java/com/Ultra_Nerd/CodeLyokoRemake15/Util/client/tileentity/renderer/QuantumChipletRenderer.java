package com.Ultra_Nerd.CodeLyokoRemake15.Util.client.tileentity.renderer;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.QuantumChipletTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.core.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class QuantumChipletRenderer extends TileEntityRenderer<QuantumChipletTileEntity> {

    private float degrees;
    private int delay;

    public QuantumChipletRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        degrees = 0;
        delay = 0;
    }

    @Override
    public void render(QuantumChipletTileEntity tileEntityIn, float partialTicks, @Nonnull MatrixStack matrixStackIn,
                       @Nonnull IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {

        NonNullList<ItemStack> items = tileEntityIn.getItems();

        for (ItemStack stack : items) {
            if (!stack.isEmpty()) {
                if (stack.getItem() == ModItems.SOLID_QUANTUM.get()) {
                    matrixStackIn.push();
                    matrixStackIn.scale(.5f, .5f, .5f);
                    matrixStackIn.translate(1, 1, 1);
                    matrixStackIn.rotate(Vector3f.YP.rotationDegrees(degrees++));
                    delay++;
                    if (delay == 10) {
                        PlaySound(tileEntityIn);
                        delay = 0;
                    }
                    renderItem(stack, partialTicks, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
                    matrixStackIn.pop();
                }
            }
        }
    }

    private void renderItem(ItemStack stack, float partialTicks, MatrixStack matrix, IRenderTypeBuffer buff, int lightIn, int overlayIn) {
        Minecraft.getInstance().getItemRenderer().renderItem(stack, ItemCameraTransforms.TransformType.FIXED, lightIn, OverlayTexture.NO_OVERLAY, matrix, buff);
    }

    private void PlaySound(QuantumChipletTileEntity tileEntity) {
        tileEntity.getWorld().playSound(tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ(), ModSounds.QUANTUMZAP.get(), SoundCategory.BLOCKS, 1, 1, true);
    }
}
