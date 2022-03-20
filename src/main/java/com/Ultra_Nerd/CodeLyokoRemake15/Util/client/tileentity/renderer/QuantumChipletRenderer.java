package com.Ultra_Nerd.CodeLyokoRemake15.Util.client.tileentity.renderer;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.QuantumChipletTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.core.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class QuantumChipletRenderer extends BlockEntityRenderer<QuantumChipletTileEntity> {

    private float degrees;
    private int delay;

    public QuantumChipletRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        degrees = 0;
        delay = 0;
    }

    @Override
    public void render(QuantumChipletTileEntity tileEntityIn, float partialTicks, @Nonnull PoseStack matrixStackIn,
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
                    matrixStackIn.pop();
                }
            }
        }
    }


    private void PlaySound(QuantumChipletTileEntity tileEntity) {
        tileEntity.getWorld().playSound(tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ(), ModSounds.QUANTUMZAP.get(), SoundCategory.BLOCKS, 1, 1, true);
    }


    public void render(ItemStack stack, float p_112308_, PoseStack matrix, MultiBufferSource buff, int lightIn, int oveerlayIn) {
        Minecraft.getInstance().getItemRenderer().render(stack, ItemTransforms.TransformType.FIXED,false,matrix,buff,lightIn,oveerlayIn,null);
    }
}
