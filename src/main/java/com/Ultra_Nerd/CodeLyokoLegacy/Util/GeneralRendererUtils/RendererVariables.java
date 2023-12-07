package com.Ultra_Nerd.CodeLyokoLegacy.Util.GeneralRendererUtils;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;

public record RendererVariables() {
    private static MatrixStack matrixStack;
    private static VertexConsumerProvider consumerProvider;
    public static void consumeRenderSystems(final WorldRenderContext context)
    {
        matrixStack = context.matrixStack();
        consumerProvider = context.consumers();
    }

    public static VertexConsumerProvider getConsumerProvider()
    {
        return consumerProvider;
    }
    public static MatrixStack getMatrixStack()
    {
        return matrixStack;
    }
}
