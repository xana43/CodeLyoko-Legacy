package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.LaptopChargerBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3f;

public record LaptopChargerRenderer(BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<LaptopChargerBlockEntity> {


    @Override
    public void render(final LaptopChargerBlockEntity entity, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {


        final ItemStack heldItem = entity.getStack(0);
        if (heldItem != ItemStack.EMPTY) {
            matrices.push();
            matrices.translate(0.5, 0.08, 0.5);
            matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(90));
            matrices.scale(0.8f, 0.8f, 0.8f);
            context.getItemRenderer().renderItem(heldItem, ModelTransformation.Mode.FIXED, light, overlay, matrices,
                    vertexConsumers, 0);
            matrices.pop();
        }

    }
}
