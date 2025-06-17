package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer.TestRenderers;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test.ItemProjectorTestEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.util.math.Vec3d;


@Environment(EnvType.CLIENT)
public record ItemProjectorTestRenderer(BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<ItemProjectorTestEntity> {



    @Override
    public void render(ItemProjectorTestEntity entity, float tickProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
        matrices.push();
        matrices.translate(0.5f,1,0.5f);

        context.getItemRenderer().renderItem(entity.getStack(0), ItemDisplayContext.FIXED,light,overlay,matrices,vertexConsumers,entity.getWorld(),0);
        matrices.pop();
    }
}
