package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem.ComputerCirculatorBlockEntity;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;

@Environment(EnvType.CLIENT)
public record ComputerCirculatorRenderer(BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<ComputerCirculatorBlockEntity> {
    private static final Tessellator tessellator = Tessellator.getInstance();
    @Override
    public void render(final ComputerCirculatorBlockEntity entity, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {
        RenderSystem.setShader(GameRenderer::getPositionColorLightmapProgram);
        matrices.push();

            final BufferBuilder bufferBuilder = tessellator.begin(VertexFormat.DrawMode.QUADS,VertexFormats.POSITION_COLOR_LIGHT);
            final Matrix4f positionMatrix = matrices.peek().getPositionMatrix();
            bufferBuilder.vertex(positionMatrix,entity.getPos().getX() - 0.5f,
                    entity.getPos().getY() - 0.5f + entity.getInternalFluidTankAmount(),entity.getPos().getZ() - 0.5f).color(0,0,
                    128,32).light(light);
            bufferBuilder.vertex(positionMatrix,entity.getPos().getX() + 0.5f,
                    entity.getPos().getY() - 0.5f + entity.getInternalFluidTankAmount(),entity.getPos().getZ() - 0.5f).color(0,0,
                    128,32).light(light);
            bufferBuilder.vertex(positionMatrix,entity.getPos().getX() - 0.5f,
                    entity.getPos().getY() - 0.5f + entity.getInternalFluidTankAmount(),entity.getPos().getZ() + 0.5f).color(0,0,
                    128,32).light(light);
            bufferBuilder.vertex(matrices.peek().getPositionMatrix(),entity.getPos().getX() + 0.5f,
                    entity.getPos().getY() - 0.5f + entity.getInternalFluidTankAmount(),entity.getPos().getZ() + 0.5f).color(0,0,
                    128,32).light(light);
            bufferBuilder.end().close();
            matrices.pop();

    }
}
