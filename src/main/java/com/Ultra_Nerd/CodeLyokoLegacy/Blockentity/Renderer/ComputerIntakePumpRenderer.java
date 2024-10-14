package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem.ComputerFluidIntakeBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.GeneralRendererUtils.CommonRenderRoutines;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public record ComputerIntakePumpRenderer(BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<ComputerFluidIntakeBlockEntity> {
    @Override
    public void render(final ComputerFluidIntakeBlockEntity entity, final float tickDelta, final MatrixStack matrices,
            final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {

        final long fluidAmount = entity.getStoredFluid();
        if (fluidAmount == 0L) {
            return;
        }
        final FluidVariant storedFluid = entity.getStoredFluidVariant();
        final long capacity = entity.getCapacity();
        float fillPercentage = (float) fluidAmount / capacity;
        fillPercentage = MathHelper.clamp(fillPercentage, 0, 1);
        final int fluidColor = FluidVariantRendering.getColor(storedFluid, entity.getWorld(), entity.getPos());
        final Sprite fluidSprite = FluidVariantRendering.getSprites(storedFluid)[0];
        final RenderLayer layer = RenderLayers.getFluidLayer(storedFluid.getFluid().getDefaultState());
        final VertexConsumer vertexConsumer = vertexConsumers.getBuffer(layer);

        CommonRenderRoutines.QuadRender.drawCalculatedSize(fluidSprite, 0, 16, 16, fillPercentage, vertexConsumer, matrices, fluidColor, light, overlay);


    }
    }

