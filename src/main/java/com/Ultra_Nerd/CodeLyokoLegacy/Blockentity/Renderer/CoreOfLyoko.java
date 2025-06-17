package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.LyokoCoreBE;
import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;

@Environment(EnvType.CLIENT)
public record CoreOfLyoko(BlockEntityRendererFactory.Context context) implements BlockEntityRenderer<LyokoCoreBE> {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static final Identifier LyokoCore = CodeLyokoMain.codeLyokoPrefix("block/core_of_lyoko");
    private static float z,y;
    private static final float ySpeed = 4,zSpeed = 0.1f;

    @Override
    public void render(LyokoCoreBE entity, float tickProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        if(!mc.isPaused()) {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(y += ySpeed));
            if(entity.getHealth() != LyokoCoreBE.getMaxHealth()) {
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float) Math.toDegrees(Math.sin(z += (entity.getHealth() / 100)))));
            }
        }
        if (y >= 360) {
            y = 0;
        }

        if(z >= 360) {
            z = 0;
        }
        matrices.translate(-0.5, -0.5, -0.5);
        /*context.getRenderManager().getModelRenderer().render(matrices.peek(),
                vertexConsumers.getBuffer(RenderLayer.getTranslucentMovingBlock()),Blocks.AIR.getDefaultState(),
                LyokoModel,1,1,10,light,overlay);*/
        matrices.pop();
    }

    @Override
    public int getRenderDistance() {
        return mc.options.getViewDistance().getValue();
    }

}
