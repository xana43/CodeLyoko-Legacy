package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer.TestRenderers;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test.ItemProjectorTestEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public record ItemProjectorTestRenderer(BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<ItemProjectorTestEntity> {

    @Override
    public void render(final ItemProjectorTestEntity entity, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {
        matrices.push();
        matrices.translate(0.5f,1,0.5f);

        context.getItemRenderer().renderItem(entity.getStack(0), ModelTransformationMode.FIXED,light,overlay,matrices,vertexConsumers,entity.getWorld(),0);
        matrices.pop();
    }
}
