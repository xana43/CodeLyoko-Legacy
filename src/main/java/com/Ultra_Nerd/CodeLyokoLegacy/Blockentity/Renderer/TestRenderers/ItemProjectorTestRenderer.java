package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer.TestRenderers;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test.ItemProjectorTestBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.joml.Quaternionf;

@Environment(EnvType.CLIENT)
public record ItemProjectorTestRenderer(BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<ItemProjectorTestBlockEntity> {
    private static final Quaternionf rotation = new Quaternionf();
    @Override
    public void render(final ItemProjectorTestBlockEntity entity,final float tickDelta,final MatrixStack matrices,final VertexConsumerProvider vertexConsumers,final int light,final int overlay) {
            final ItemStack storedStack = entity.getStack(0);
            if(!storedStack.isEmpty())
            {
                matrices.push();
                rotation.rotateLocalY(2);
                matrices.multiply(rotation,entity.getPos().getX(),entity.getPos().getY(),entity.getPos().getZ());
                context.getItemRenderer().renderItem(storedStack,ModelTransformationMode.FIXED,light,overlay,matrices,vertexConsumers,entity.getWorld(),0);
                matrices.pop();
            }
    }
}
