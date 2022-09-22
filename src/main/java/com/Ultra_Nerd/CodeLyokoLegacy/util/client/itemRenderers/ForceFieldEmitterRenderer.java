package com.Ultra_Nerd.CodeLyokoLegacy.util.client.itemRenderers;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.util.client.APIEmbed.api.Myron;
import com.Ultra_Nerd.CodeLyokoLegacy.items.tools.ForceFieldEmitter;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

public record ForceFieldEmitterRenderer() implements BuiltinItemRendererRegistry.DynamicItemRenderer {

    @Override
    public void render(final ItemStack stack, final ModelTransformation.Mode mode, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {
        matrices.push();
        final MinecraftClient mc = MinecraftClient.getInstance();
        if (stack.getItem() instanceof final ForceFieldEmitter forceFieldEmitter) {

            final float pull = ForceFieldEmitter.getPullProgress(stack.getMaxUseTime() - forceFieldEmitter.publicUseTicks);

            matrices.scale(pull, pull, pull);

        }
        if (mc != null) {
            final BakedModel forceField = Myron.getModel(CodeLyokoMain.CodeLyokoPrefix("models/item/force_field_model"));
            if (forceField != null) {
                mc.getBlockRenderManager().getModelRenderer().render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getSolid()), Blocks.AIR.getDefaultState(), forceField, 1, 1, 1, light, overlay);
            }
        }
        matrices.pop();
    }
}
