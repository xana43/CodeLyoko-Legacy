package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer.ElectricityRenderers;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity.RackChargerBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public record RackChargerRenderer(BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<RackChargerBlockEntity> {

    private void calculateOffsetForSlot(final int slot, final RackChargerBlockEntity entity, final MatrixStack matrices, final int light, final int overlay, final VertexConsumerProvider vertexConsumers)
    {
        final ItemStack gottenStack = entity.getStack(slot);
        if(!gottenStack.isEmpty()) {
            if (gottenStack.isOf(ModItems.MIND_HELMET)) {
                if (slot != 0) {
                    matrices.translate(0, -.55f, 0);
                }

            } else if (gottenStack.isOf(ModItems.LINKER)) {

            }
            switch (entity.getWorld().getBlockState(entity.getPos()).get(Properties.HORIZONTAL_FACING)) {
                case NORTH -> {
                }
                case SOUTH -> {
                }
                case EAST -> {
                }
                case WEST -> {
                }
                default -> {
                }
            }
            context.getItemRenderer().renderItem(gottenStack, ModelTransformationMode.FIXED, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
        }

    }
    @Override
    public void render(final RackChargerBlockEntity entity, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {
        matrices.push();
        matrices.translate(0.5,0.5,0.5);
        matrices.scale(0.7f,0.7f,0.7f);
        matrices.translate(-.7f, 0.4f, 0.07f);
        if(entity.getWorld().getBlockState(entity.getPos()) != Blocks.AIR.getDefaultState()) {
            switch (entity.getWorld().getBlockState(entity.getPos()).get(Properties.HORIZONTAL_FACING)) {
                case NORTH -> {
                }
                case SOUTH -> {
                }
                case EAST -> {
                }
                case WEST -> {
                }
                default -> {
                }
            }
        }
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90));
        for(int i = 0; i < 3; ++i) {
            if(entity.getWorld().getBlockState(entity.getPos()) != Blocks.AIR.getDefaultState()) {
                calculateOffsetForSlot(i, entity, matrices, light, overlay, vertexConsumers);
            }
        }
        matrices.pop();
    }
}
