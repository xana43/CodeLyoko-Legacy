package com.Ultra_Nerd.CodeLyokoLegacy.util.GeneralRendererUtils;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;

public record RendererVariables() {
    private static MatrixStack matrixStack;
    private static VertexConsumerProvider consumerProvider;
    public static void populateMatrixStack(final MatrixStack stack)
    {
        matrixStack = stack;
    }
    public static void setConsumerProvider(final VertexConsumerProvider consumerProvider)
    {
        RendererVariables.consumerProvider = consumerProvider;
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
