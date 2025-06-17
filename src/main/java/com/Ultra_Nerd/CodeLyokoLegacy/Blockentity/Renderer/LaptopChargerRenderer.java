package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity.LaptopChargerBlockEntityInventory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;

@Environment(EnvType.CLIENT)
public record LaptopChargerRenderer(
        BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<LaptopChargerBlockEntityInventory> {




    @Override
    public void render(LaptopChargerBlockEntityInventory entity, float tickProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
        final ItemStack heldItem = entity.getStack(0);
        if (!heldItem.isEmpty()) {
            matrices.push();
            matrices.translate(0.5, 0.08, 0.5);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
            matrices.scale(0.8f, 0.8f, 0.8f);
            context.getItemRenderer().renderItem(heldItem, ItemDisplayContext.FIXED, light, overlay,
                    matrices,
                    vertexConsumers,entity.getWorld(), 0);
            matrices.pop();
        }
    }
}
