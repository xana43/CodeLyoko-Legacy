package com.Ultra_Nerd.CodeLyokoLegacy.Util.Client.itemRenderers;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools.ForceFieldEmitter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public record ForceFieldEmitterRenderer(MinecraftClient mc) implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    private static final Identifier ForceFieldLocation = CodeLyokoMain.codeLyokoPrefix("item/force_field_emitter");
    private static BakedModel ForceFieldModel;
    public ForceFieldEmitterRenderer()
    {
        this(MinecraftClient.getInstance());
    }

    public static Identifier getForceFieldLocation()
    {
        return ForceFieldLocation;
    }
    @Override
    public void render(final ItemStack stack, final ModelTransformationMode mode, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {
        matrices.push();
        if(ForceFieldModel == null)
        {
            ForceFieldModel = mc.getBakedModelManager().getModel(ForceFieldLocation);
            CodeLyokoMain.LOG.error("loaded:"+ForceFieldModel);
        }
        if (stack.getItem() instanceof final ForceFieldEmitter forceFieldEmitter) {

            final float pull = ForceFieldEmitter.getPullProgress(
                    stack.getMaxUseTime() - forceFieldEmitter.publicUseTicks);

            matrices.scale(pull, pull, pull);

        }
        if (mc != null) {

            if (ForceFieldModel != null) {
               mc.getBlockRenderManager().getModelRenderer()
                    .render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getSolid()),
                           Blocks.AIR.getDefaultState(), ForceFieldModel, 1, 1, 1, light, overlay);
            }
        }
        matrices.pop();
    }
}
