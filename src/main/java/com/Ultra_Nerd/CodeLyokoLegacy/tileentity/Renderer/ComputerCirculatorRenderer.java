package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.SuperCalculatorEntities.FluidSystem.ComputerCirculatorBlockEntity;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public record ComputerCirculatorRenderer(BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<ComputerCirculatorBlockEntity> {
    private static final Tessellator tessellator = Tessellator.getInstance();
    private static final BufferBuilder bufferbuilder = tessellator.getBuffer();
    @Override
    public void render(final ComputerCirculatorBlockEntity entity, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {
        RenderSystem.setShader(GameRenderer::getPositionColorLightmapProgram);
        matrices.push();
            bufferbuilder.begin(VertexFormat.DrawMode.QUADS,VertexFormats.POSITION_COLOR_LIGHT);
            bufferbuilder.vertex(matrices.peek().getPositionMatrix(),entity.getPos().getX() - 0.5f,
                    entity.getPos().getY() - 0.5f + entity.getInternalFluidTankAmount(),entity.getPos().getZ() - 0.5f).color(0,0,
                    128,32).light(light);
            bufferbuilder.vertex(matrices.peek().getPositionMatrix(),entity.getPos().getX() + 0.5f,
                    entity.getPos().getY() - 0.5f + entity.getInternalFluidTankAmount(),entity.getPos().getZ() - 0.5f).color(0,0,
                    128,32).light(light);
            bufferbuilder.vertex(matrices.peek().getPositionMatrix(),entity.getPos().getX() - 0.5f,
                    entity.getPos().getY() - 0.5f + entity.getInternalFluidTankAmount(),entity.getPos().getZ() + 0.5f).color(0,0,
                    128,32).light(light);
            bufferbuilder.vertex(matrices.peek().getPositionMatrix(),entity.getPos().getX() + 0.5f,
                    entity.getPos().getY() - 0.5f + entity.getInternalFluidTankAmount(),entity.getPos().getZ() + 0.5f).color(0,0,
                    128,32).light(light);
            tessellator.draw();
            matrices.pop();

    }
}
