package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem.ComputerFluidIntakeBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix4f;

import java.util.Objects;

@Environment(EnvType.CLIENT)
public record ComputerIntakePumpRenderer(BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<ComputerFluidIntakeBlockEntity> {
    private static final Tessellator tessellator = Tessellator.getInstance();
    private static final BufferBuilder bufferbuilder = tessellator.getBuffer();
    @Override
    public void render(final ComputerFluidIntakeBlockEntity entity, final float tickDelta, final MatrixStack matrices,
            final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {
        //RenderSystem.setShader(GameRenderer::getPositionColorLightmapProgram);
        final int worldLight = WorldRenderer.getLightmapCoordinates(
                Objects.requireNonNull(entity.getWorld()),entity.getPos().up());

        for (int i = 0; i < 6; ++i) {
            matrices.push();
            switch (i)
            {
                case 1 -> {
                    matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
                    matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0));
                }
                case 2 -> {
                    matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
                    matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
                }
                case 3 -> matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180.0F));
                case 4 -> {

                    matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-90.0F));
                    matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));
                }
                case 5 -> {

                    matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
                    matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90));
                }

            }

            bufferbuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR_LIGHT);
            final Matrix4f matrix4f = matrices.peek().getPositionMatrix();
            bufferbuilder.vertex(matrix4f, .5f, .5f, -.5f).color(3, 37,
                    126, 255).light(worldLight).next();
            bufferbuilder.vertex(matrix4f, -.5f, .5f, -.5f).color(3, 37,
                    126, 255).light(worldLight).next();
            bufferbuilder.vertex(matrix4f, -.5f, .5f, .5f).color(3, 37,
                    126, 255).light(worldLight).next();
            bufferbuilder.vertex(matrix4f, .5f, .5f, .5f).color(3, 37,
                    126, 255).light(worldLight).next();

            tessellator.draw();
            matrices.pop();
        }

    }
}
