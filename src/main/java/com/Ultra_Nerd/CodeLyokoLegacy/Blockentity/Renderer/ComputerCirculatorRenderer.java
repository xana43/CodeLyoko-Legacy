package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem.ComputerCirculatorBlockEntity;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;

@Environment(EnvType.CLIENT)
public record ComputerCirculatorRenderer(BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<ComputerCirculatorBlockEntity> {
    private static final Tessellator tessellator = Tessellator.getInstance();

    @Override
    public void render(ComputerCirculatorBlockEntity entity, float tickProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
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
